INSERT INTO T_STUDENT VALUES (9091, '김수진', 'sooplus', 2, 101, 1004); --2번

DELETE FROM T_STUDENT WHERE grade = 4; -- 3번

SELECT NAME "이름", PAY "급여"
FROM T_PROFESSOR 
WHERE pay >= 5000; -- 4번

CREATE INDEX idx_student_name ON T_STUDENT(NAME); -- 5번

SELECT P.NAME AS "교수님 이름", D.DNAME AS "소속 학과명"
FROM T_PROFESSOR P, T_DEPARTMENT D
WHERE P.DEPTNO = D.DEPTNO ; -- 6번

SELECT S.NAME "학생이름", D.DNAME "학과명"
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO = D.DEPTNO 
	AND S.DEPTNO = (SELECT DEPTNO FROM T_STUDENT WHERE NAME  = '이윤나'	); -- 7번

CREATE VIEW v_stud_info (sname, dname, pname)
AS
SELECT s.NAME , d.DNAME , p.NAME FROM T_STUDENT s, T_PROFESSOR p, T_DEPARTMENT d 
WHERE s.PROFNO = p.PROFNO AND p.DEPTNO = d.DEPTNO; --8번


ALTER TABLE T_STUDENT ADD (
	BIRTHDAY DATE
); -- 9번

SELECT TNAME FROM TAB; --10번

COMMIT; --11번

DROP TABLE T_MEMBER;

CREATE TABLE T_MEMBER (
	mb_uid number,
	mb_name varchar2(20) NOT NULL,
	mb_jumin char(13),
	mb_age number,
	mb_dept number,
	PRIMARY KEY (mb_uid),
	UNIQUE (mb_jumin),
	CHECK (mb_age > 0),
	FOREIGN KEY (mb_dept) REFERENCES T_DEPARTMENT(DEPTNO)
);

