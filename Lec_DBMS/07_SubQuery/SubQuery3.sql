CREATE TABLE test_emp_a(
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);

CREATE TABLE test_emp_b(
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);


DELETE FROM TEST_EMP_A ;
DELETE FROM TEST_EMP_B ;

INSERT INTO TEST_EMP_A VALUES(101, '장윤성');
INSERT INTO TEST_EMP_B VALUES(201, '고유성');

SELECT * FROM TEST_EMP_A ;
SELECT * FROM TEST_EMP_B ;

--동시에 여러개 테이블에 INSERT 하기
-- 다중 테이블 INSERT구문에 sub query 필요
INSERT ALL
	INTO TEST_EMP_A VALUES (102, '조현주')
	INTO TEST_EMP_B VALUES (202, '최현주')
SELECT * FROM dual;

--sub query 로 insert 가능
INSERT INTO TEST_EMP_A (SELECT 400, '안성원' FROM DUAL );
INSERT INTO TEST_EMP_B (SELECT 500, '김성원' FROM DUAL );

-- 테이블 묻고 더블로
INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A); 

INSERT INTO TEST_EMP_B (emp_name) (SELECT emp_name FROM TEST_EMP_A );












