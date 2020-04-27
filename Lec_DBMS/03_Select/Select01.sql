-- dual은 ROW 1개 짜리 dummy TABLE
SELECT 'abcde' FROM DUAL;
SELECT '안녕하세요' FROM DUAL;
SELECT 100 FROM DUAL;
SELECT 100+10 FROM DUAL;


-- *: 모든 컬럼
SELECT * FROM t_emp;

-- 원하는 컬럼만 조회
SELECT empno, ename FROM T_EMP ;

SELECT * FROM T_PROFESSOR;
SELECT NAME FROM T_PROFESSOR ;

SELECT '안녕하세요' FROM T_PROFESSOR ;

SELECT name, '교수님 싸랑해요' FROM T_PROFESSOR ; 

--컬럼 별명(alias) 사용한 출력
SELECT STUDNO 학번, NAME 이름
FROM T_STUDENT;

SELECT studno "학번" , name AS 이름
FROM T_STUDENT ;

SELECT studno "학생 학번" , name AS 이름
FROM T_STUDENT ;

SELECT EMPNO AS 사원번호, ename AS 사원명, job AS 직업
FROM T_EMP ;

SELECT DEPTNO AS 부서#, dname AS 부서명, loc AS 위치
FROM T_DEPT ;

--DISTINCT : 중복값제거 후 출력
SELECT * FROM T_EMP ;
SELECT DISTINCT deptno FROM T_EMP ;

SELECT DISTINCT deptno1 FROM T_STUDENT ;
SELECT DISTINCT job FROM T_EMP ;

-- ||: 필드, 문자열 연결 연산
SELECT name, POSITION 
FROM T_PROFESSOR ;

SELECT name || '-' || POSITION AS 교수님명단
FROM T_PROFESSOR ;

SELECT NAME || '의 키는' || HEIGHT || 'cm, 몸무게는 ' || WEIGHT || 'kg 입니다' "학생의 키와 몸무게"
FROM T_STUDENT ;





