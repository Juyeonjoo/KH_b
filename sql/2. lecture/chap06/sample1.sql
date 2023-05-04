-- sample1.sql


-- ******************************************************
-- SELECT 문의 기본구조와 각 절의 실행순서
-- ******************************************************
--  - Clauses -                 - 실행순서 -
--
-- SELECT clause                        (5)
-- FROM clause                          (1)
-- [ WHERE clause ]                     (2)
-- [ GROUP BY clause ]                  (3)
-- [ HAVING clause ]                    (4)
-- [ ORDER BY clause ]                  (6)
-- ******************************************************


-- ------------------------------------------------------
-- 1. Sub-query (부속질의)
-- ------------------------------------------------------
--  가. Join은 한 개 이상의 테이블에서, 원하는 데이터를 조회
--  나. 서브쿼리(=부속질의)는, 하나의 SELECT 문장 만으로 원하는
--      데이터를 조회할 수 없을 때 사용하는 방법
--  다. 한 개 이상의 SELECT문장을, 하나로 합쳐서, 하나의 실행가능
--      한 문장으로 만들어, 원하는 데이터를 조회하는 방법
--  라. 종류:
--      (1) 상관 부속질의
--          - 서브쿼리(=부속질의)의 단독 수행이 불가능한 경우
--          - 메인쿼리의 데이터가 있어야 실행가능한 경우로,
--          - 메인쿼리가 먼저 수행되고, 차례대로 서브쿼리가 수행됨
--          - 메인쿼리의 결과가 서브쿼리에 전달되어, 서브쿼리 수행
--      (2) 비상관 부속질의
--          - 서브쿼리(=부속질의)의 단독 수행이 가능한 경우로,
--          - 서브쿼리가 먼저 수행된 다음에, 메인쿼리가 수행됨
--          - 서브쿼리의 결과가 메인쿼리에 전달되어 실행됨
--  마. 사실상, 서브쿼리(=부속질의)는, SELECT 문의 모든 절(clause)
--      에서 뿐만 아니라, 모든 DML문장에서도 사용가능하다!!! (*주의*)
--  사. 반드시 소괄호()를 사용해야 함.
--  아. 구분: 서브쿼리가 실행되어 반환된 행의 개수에 따라,
--      (1) 단일 행 서브쿼리
--          - 서브쿼리 실행 결과가 한 개의 행 반환.
--          - 메인쿼리에서 사용가능 연산자: 
--              *** 비교 연산자 (=, !=, <, >, <=, >=) ***
--      (2) 복수 행 서브쿼리
--          - 서브쿼리 실행 결과가 복수 개의 행 반환.
--          - 메인쿼리에서 사용가능 연산자: 
--              *** IN, ANY, ALL, EXISTS 등 ***
--  자. 서브쿼리 사용시, **가장 주의해야** 할 점: 사용할 연산자
--      사용된 연산자에 따라, 위 '아'와 같이 행 반환
-- ------------------------------------------------------
-- Basic Syntax)
--
--  SELECT select_list       -- 메인쿼리(바깥쪽 SELECT 문장)
--  FROM 테이블
--  WHERE 컬럼명 연산자 (
--      SELECT select_list FROM 테이블    -- 서브쿼리(안쪽 SELECT 문장)
--  );
-- ------------------------------------------------------
-- * Please refer to the chapter 06, page 2.
-- ------------------------------------------------------

-- ------------------------------------------------------
-- 사원정보에서, 'Whalen'보다 많은 월급을 받는 사원조회 #1
-- ------------------------------------------------------
-- * 하나의 SELECT문장만으로는 조회불가:
--   가. 먼저, 'Whalen'의 월급이 얼마나인지 알아야 함. (SELECT 1)
--   나. 조회한 'Whalen'의 월급보다 많은 월급을 받는 사원조회가능 (SELECT 2)
-- ------------------------------------------------------

-- SELECT #1: Whalen 의 월급조회(4400)
SELECT
    salary
FROM
    employees
WHERE
    last_name = 'Whalen';


-- SELECT #2: Whalen 보다 월급을 많이 받는 사원 조회
SELECT
    last_name,
    salary
FROM
    employees
WHERE
    salary >= 4400;   -- Whalen의 월급지정


-- ------------------------------------------------------
-- 사원정보에서, 'Whalen'보다 많은 월급을 받는 사원조회 #2
-- ------------------------------------------------------
-- 위 #1과 같이, 하나 이상의 SELECT 문장이 있어야만, 원하는 결과
-- 를 조회가능한 경우에, 서브쿼리(=부속질의) 사용가능.
--
-- 즉, 서브쿼리는, 여러 번의 SELECT 문장을 수행해야 얻을 수 있는
-- 결과를, 하나의 중첩된(nested) SELECT 문장으로 만들어, 원하는
-- 결과를 쉽게 조회가능하게 함.
-- ------------------------------------------------------
SELECT  -- 메인쿼리
    last_name,
    salary
FROM
    employees
WHERE
    -- 2nd. Whalen 보다 많은 월급여를 받는 사원조회
    salary >= (
        -- 서브쿼리(= 비상관 부속질의):
        --  a. 단독 수행에 지장없음
        --  b. Whalen의 월급여가 메인쿼리에 전달됨
        SELECT
            salary
        FROM
            employees
        WHERE
            last_name = 'Whalen'  -- 1st. Whalen 의 월급여 획득
    );

