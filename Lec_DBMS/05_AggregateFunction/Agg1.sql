SELECT * FROM T_PROFESSOR ;
SELECT COUNT(*), COUNT(HPAGE) FROM T_PROFESSOR ; -- 그룹함수에서는 null 값은 계산에서 제외 
SELECT COUNT(bonus), sum(BONUS), avg(BONUS) FROM T_PROFESSOR;
SELECT MAX(HIREDATE), min(HIREDATE) FROM T_EMP;  

--NULL 허용 컬럼의 그룹함수 적용시
--nvl, nvl2 사용해야 함
SELECT AVG(BONUS), avg(nvl(BONUS ,0)) FROM T_PROFESSOR ;

--교수님 테이블에서 학과별로 교수들의 평균 보너스를 출력하세요

-- ★ select절에 group 함수와 group 함수가 아닌 것과 같이 출력 불가능
SELECT  DEPTNO , round(avg(NVL(BONUS,0)),1) 보너스평균
FROM T_PROFESSOR 
GROUP BY DEPTNO;
--#5101
SELECT DEPTNO , POSITION, avg(pay)
FROM T_PROFESSOR 
GROUP BY DEPTNO , POSITION -- 1. 학과별 그룹핑, 2. 직급별 그룹핑
ORDER BY DEPTNO ,"POSITION";

--부서별 평균급여, 평균급여가 450 보다 많은 학과만 출력
SELECT deptno , AVG(pay) 평균급여
FROM T_PROFESSOR 
--WHERE AVG(PAY) > 450 --그룹함수는 where 절에서 사용불가
GROUP BY DEPTNO 
HAVING avg(pay) > 300; -- having : 그룹함수 결과에 대한 조건절

-- <select 쿼리문 순서>
-- select -> from -> where -> group by -> having -> order by

--#5102
SELECT MGR 매니저, COUNT(MGR) 직원수, 
	SUM(SAL) 급여총액, avg(SAL) 급여평균,
	avg(nvl(comm, 0)) 교통비평균
FROM T_EMP 
WHERE JOB != 'PRESIDENT'
GROUP BY MGR;


--#5103
SELECT DEPTNO , COUNT(*) 총인원, ROUND(AVG(SYSDATE-HIREDATE),5) 근속평균,
	AVG(PAY) 급여평균, AVG(NVL(BONUS, 0)) 보너스평균
FROM T_PROFESSOR 
WHERE "POSITION" = '정교수' OR "POSITION" = '조교수'
GROUP BY DEPTNO; 

--#5104
SELECT DEPTNO1 학과, MAX(WEIGHT) - MIN(WEIGHT) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1;

--#5105
SELECT DEPTNO1 학과, MAX(WEIGHT) - MIN(WEIGHT) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1
HAVING  MAX(WEIGHT) - MIN(WEIGHT) > 30;


