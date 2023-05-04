--현재 연결세션의 날짜와 시간 포맷을 변경하고 싶다.
--연결세션에 대해서, 즉 HR.cloud, or local

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- Oracle SQL * Develper
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-RR'; -- Visual Source Code
ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy/MM/dd - hh24:mi:ss';
ALTER SESSION SET NLS_TIMESTAMP_TZ_FORMAT='yyyy/MM/dd - hh24:mi:ss';

SELECT
    sysdate,
    sysdate + 9,            -- 일수를 더함
    sysdate + 9/24,         --24시간을 나눈 값이, 시간으로 더해짐
    sysdate + 9/24/60,      --24시간/60분으로 나눈 값이, 분으로 더해짐
    sysdate + 9/24/60/60    -- 24시간/60분/60초로 나눈 값이, 초로 더해짐
    systimestamp,

    CURRENT_DATE,          --현재 Timezone(ASIA/SEOUL)에 맞는 Local Date Time
    CURRENT_TIMESTAMP         -- 현재 Timezone(ASIA/SEOUL)에 맞는 Local Date Time  
FROM
    DUAL;

SELECT
*
FROM
nls_session_parameters;  
