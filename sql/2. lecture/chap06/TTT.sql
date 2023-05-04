

--각 사원별, 사번/이름/부서번호/부서명을 얻자
--(without join and using subquery)

SELECT
    employee_id AS 사번,
    last_name AS 이름,
    department_id AS 부서번호,
    
    (   -- 상관부속질의: 
        --메인 쿼리의 데이터를 받아서 수행되는 서브쿼리 ==상관부속질의
        -- (1) 단독수행불가 (왜? 메인 쿼리데이터 없이는 수행 불가하여)
        -- (2) SELECT절이 수행되는 횟수만큼 똑같이 수행
        -- (3) 메인쿼리와 함께 수행된다.(먼저 수행되지 못함)
        
        SELECT  --join안하고 select절에 subquery넣기
         DEPARTMENT_NAME
        FROM 
            DEPARTMENTS t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1;


SELECT
    사번 AS 사원번호,
    이름 AS 사원명,
    부서번호,
    부서명
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    department_id AS 부서번호,
    
    (   
        SELECT 
        DEPARTMENT_NAME
        FROM 
            DEPARTMENTS t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e ;

--
SELECT
    사번 AS 사원번호,
    이름 AS 사원명,
    부서번호,
    부서명
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    department_id AS 부서번호,
    
    (   
        SELECT 
            department_name
        FROM 
            departments t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e
WHERE
사번 IN(100, 110,120, 130, 140, 150,160);

--
SELECT
    사번 AS 사원번호,
    이름 AS 사원명,
    부서번호,
    부서명
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    department_id AS 부서번호,
    
    (   
        SELECT 
            department_name
        FROM 
            departments t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e
WHERE
사번 IN(
    SELECT employee_id
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID > 100
);

-- 부서번호로 group by 하기
SELECT
    -- 사번 AS 사원번호, -- 이제 얘네 못나옴..왜?
    -- 이름 AS 사원명,   --groupby나오면 select 제약받으니까
    -- 부서번호,         -- 직계함수 or,,
    -- 부서명
    부서번호,
    avg(급여) AS 평균급여
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    salary AS 급여,
    department_id AS 부서번호,
    
    (   
        SELECT 
            department_name
        FROM 
            departments t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e
WHERE
사번 IN(
    SELECT employee_id
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID > 100
)
GROUP BY
    부서번호;

--group by도 sub query 사용 가능

SELECT
    -- 사번 AS 사원번호, -- 이제 얘네 못나옴..왜?
    -- 이름 AS 사원명,   --groupby나오면 select 제약받으니까
    -- 부서번호,         -- 직계함수 or,,
    -- 부서명
    부서번호,
    avg(급여) AS 평균급여
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    salary AS 급여,
    department_id AS 부서번호,
    
    (   
        SELECT 
            department_name
        FROM 
            departments t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e
WHERE
사번 IN(
    SELECT employee_id
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID > 100
)
GROUP BY
    부서번호

HAVING
    부서번호 >= 70;

--
SELECT
    -- 사번 AS 사원번호, -- 이제 얘네 못나옴..왜?
    -- 이름 AS 사원명,   --groupby나오면 select 제약받으니까
    -- 부서번호,         -- 직계함수 or,,
    -- 부서명
    부서번호,
    avg(급여) AS 평균급여
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    salary AS 급여,
    department_id AS 부서번호,
    
    (   
        SELECT 
            department_name
        FROM 
            departments t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e
WHERE
사번 IN(
    SELECT employee_id
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID > 100
)
GROUP BY
    부서번호

HAVING
    부서번호 IN( --비상관쿼리, 단독 수행 가능,메인쿼리데이터 사용안함
        SELECT DEPARTMENT_ID
        FROM DEPARTMENTS
        WHERE DEPARTMENT_ID >= 70
    );

    --order by에 써보기
SELECT
    -- 사번 AS 사원번호, -- 이제 얘네 못나옴..왜?
    -- 이름 AS 사원명,   --groupby나오면 select 제약받으니까
    -- 부서번호,         -- 직계함수 or,,
    -- 부서명
    부서번호,
    avg(급여) AS 평균급여
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    salary AS 급여,
    department_id AS 부서번호,
    
    (   
        SELECT 
            department_name
        FROM 
            departments t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e
WHERE
사번 IN(
    SELECT employee_id
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID > 100
)
GROUP BY
    부서번호

HAVING
    부서번호 IN( --비상관쿼리, 단독 수행 가능,메인쿼리데이터 사용안함
        SELECT DEPARTMENT_ID
        FROM DEPARTMENTS
        WHERE DEPARTMENT_ID >= 70
    )

    ORDER BY
    부서번호 ASC;

    --having절 필요없게? 인라인에서 전체 쓰지 않고
SELECT
    -- 사번 AS 사원번호, -- 이제 얘네 못나옴..왜?
    -- 이름 AS 사원명,   --groupby나오면 select 제약받으니까
    -- 부서번호,         -- 직계함수 or,,
    -- 부서명
    부서번호,
    avg(급여) AS 평균급여
FROM (
    SELECT

    employee_id AS 사번,
    last_name AS 이름,
    salary AS 급여,
    department_id AS 부서번호,
    
    (   
        SELECT 
            department_name
        FROM 
            departments t2 
         WHERE 
             t2.department_id = t1.department_id
    ) AS 부서명 
FROM
    employees t1
)e
WHERE
사번 IN(
    SELECT employee_id
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID > 100
)
GROUP BY
    부서번호
-- 여기 있던 having 필요 없음
    ORDER BY
    부서번호 ASC;
