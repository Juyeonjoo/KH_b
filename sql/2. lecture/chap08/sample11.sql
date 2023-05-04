-- sample11.sql


-- ------------------------------------------------------
-- 4. 테이블 변경
-- ------------------------------------------------------
-- 가. 생성된 테이블의 구조를 변경
--     a. 컬럼의 추가/삭제
--     b. 컬럼의 타입/길이 변경
--     c. 컬럼의 제약조건 추가/삭제
-- 나. ALTER TABLE 문장 사용
-- 다. 테이블의 구조변경은 기존 저장된 데이터에 영향을 주게 됨
-- ------------------------------------------------------

DROP TABLE emp04;


CREATE TABLE emp04 AS
SELECT
    *
FROM
    emp;


DESC emp04;

SELECT * FROM emp04;


-- ------------------------------------------------------
-- (1) 컬럼 추가 (ALTER TABLE ADD 문장)
-- ------------------------------------------------------
-- a. 기존 테이블에 새로운 컬럼 추가
-- b. 추가된 컬럼은, 테이블의 마지막에 추가
-- c. 데이터는 자동으로 null 값으로 저장됨
-- d. DEFAULT 옵션 설정도 가능
-- ------------------------------------------------------
-- Basic Syntax:
--
--  ALTER TABLE 테이블명
--  ADD ( 컬럼명1 데이터타입 [, ..., 컬럼명n 데이터타입] );
-- ------------------------------------------------------
DESC emp04;


ALTER TABLE emp04
ADD ( 
        email VARCHAR2(10) CONSTRAINT emp04_email_uk UNIQUE,
        address VARCHAR2(20) 
);


DESC emp04;


-- ------------------------------------------------------
-- (2) 컬럼 변경 (ALTER TABLE MODIFY 문장)
-- ------------------------------------------------------
-- a. 기존 테이블에 기존 컬럼 변경
-- b. 컬럼의 타입/크기/DEFAULT값 변경가능
--    숫자/문자 컬럼의 전체길이의 증가/축소, 타입변경도 가능
-- c. DEFAULT 값 변경의 경우, 이후 입력되는 행에 대해서만 적용
-- ------------------------------------------------------
-- Basic Syntax:
--
--  ALTER TABLE 테이블명
--  MODIFY ( 컬럼명1 데이터타입 [, ..., 컬럼명n 데이터타입] );
-- ------------------------------------------------------
DESC emp04;


ALTER TABLE emp04
MODIFY ( email VARCHAR2(40) ); -- size: 10=>40 증가(문제 안됨)
--current:EMAIL		VARCHAR2(10)

ALTER TABLE emp04
MODIFY ( ename VARCHAR2(20) ); -- size: 10=>20으로 증가 제 안됨.
-- ENAME		VARCHAR2(10)

--결론: 이미 데이터가 있는 컬럼의 길이를 축소하는 것 => 거부된다.
ALTER TABLE emp04
--ORA-01441: cannot decrease column length because some value is too big
MODIFY ( ename VARCHAR2(5) );   -- size를 감소, 축소하기.


DESC emp04;


-- ------------------------------------------------------
-- (2) 컬럼 삭제 (ALTER TABLE DROP 문장)
-- ------------------------------------------------------
-- a. 기존 테이블에 기존 컬럼 삭제
-- b. 컬럼은 값의 존재여부와 상관없이, 무조건 삭제됨
-- c. 동시에 여러 컬럼삭제가 가능
-- d. 최소한 1개의 컬럼은 반드시 존재해야 됨
-- ------------------------------------------------------
-- Basic Syntax:
--
--  ALTER TABLE 테이블명
--  DROP ( 컬럼명1, [컬럼명n] );
-- ------------------------------------------------------
DESC emp04;


ALTER TABLE emp04
DROP ( email, address);

-- 참조 무결성 제약조건이 걸려있는 컬럼은 과연 바로 삭제될까?
-- 예: 부모 테이블의 PK 컬럼 삭제 => 자식 테이블 영향 받음
-- 결론 **거부됨 **

ALTER TABLE DEPT02
DROP(deptno);

DESC emp02;

DESC emp04;

-- ------------------------------------------------------
-- (3) 컬럼 이름 변경 (ALTER TABLE RENAME문장)
-- ------------------------------------------------------
--문법:
-- ALTER TABLE <table>
-- RENAME COLUMN <old> TO <new>;


ALTER TABLE emp02
RENAME COLUMN ename To empname;

DESC emp02;

--실험: 참조 무결성 관계를 가지는 부모 테이블의 PK컬럼은
-- 바로 변경 가능한가?
-- 예 ) 부서 (부모) 테이블의 PK인 부서번호(deptno)컬럼의 이름 변경

ALTER TABLE DEPT02
RENAME COLUMN DEPTNO TO department_no; --될까? (OK)

DESC DEPT02;

SELECT
    table_name,
    constraint_type,
    constraint_name,
    r_constraint_name
FROM
    user_constraints
WHERE
    table_name IN ('DEPT02', 'EMP02');

DESC USER_CONS_COLUMNS;

SELECT 
    * 
FROM 
    USER_CONS_COLUMNS
WHERE 
table_name IN ('DEPT02', 'EMP02');


ALTER TABLE DEPT02
RENAME COLUMN department_no TO deptno; 
