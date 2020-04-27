CREATE OR REPLACE view v_prof
AS 
SELECT PROFNO , NAME , EMAIL , HPAGE FROM T_PROFESSOR ;


SELECT * FROM v_prof;
SELECT tname FROM Tab; --VIEW 확인 가능

-- 뷰 생성시 별도의 컬럼이름을 지정해줄수 있다.
CREATE OR REPLACE view v_prof(pfno, nm, em, hp)
AS 
SELECT PROFNO , NAME , EMAIL , HPAGE FROM T_PROFESSOR ;

--#8102
CREATE OR REPLACE VIEW v_prof_dept (교수번호, 교수명, 소속학과명)
AS 
SELECT p.PROFNO , p.NAME , d.DNAME FROM T_PROFESSOR p, T_DEPARTMENT d WHERE p.DEPTNO = d.DEPTNO ;

SELECT * FROM v_prof_dept;

--#8103
SELECT d.DNAME "학과명", s.max_height "최대키", s.max_weight "최대몸무게"
FROM (SELECT DEPTNO1 , MAX(HEIGHT ) max_height, max(WEIGHT ) max_weight FROM T_STUDENT GROUP BY DEPTNO1 ) s,
t_department d
WHERE s.deptno1 = d.DEPTNO ;

--#8104
SELECT d.dname "학과명", a.max_height "최대키", s.name "학생이름", s.height "키"
FROM 
	(SELECT deptno1, MAX(height) max_height FROM t_student GROUP BY deptno1) a,
	t_student s, t_department d
WHERE 
	s.deptno1 = a.deptno1 AND s.height = a.max_height
	AND s.deptno1 =  d.deptno
;

--#8105
SELECT s.GRADE "학년", s.NAME "이름", s.HEIGHT "키", avg_height "평균키" 
FROM (SELECT grade, avg(height) avg_height FROM T_STUDENT GROUP BY GRADE ) a,
	t_student s
WHERE a.grade = s.GRADE AND s.HEIGHT > a.avg_height
ORDER BY 1 ASC;



