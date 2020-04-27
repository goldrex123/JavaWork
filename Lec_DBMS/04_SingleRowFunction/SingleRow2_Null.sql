SELECT * FROM T_PROFESSOR;

-- null 값 과의 연산의 결과는 null이다
SELECT NAME , PAY , BONUS , PAY + BONUS FROM T_PROFESSOR;   

-- 그룹함수에서는 동작, null은 연산에서 제외되어 동작
SELECT sum(pay), sum(BONUS) FROM T_PROFESSOR ;

--nvl() 함수
SELECT NAME , PAY , BONUS , PAY + BONUS,
	pay + NVL(BONUS , 0) 총지급액 
FROM T_PROFESSOR;   

--#4201
SELECT NAME , PAY , NVL2(BONUS,BONUS ,0) bouns , pay * 12 + NVL(BONUS , 0) 연봉 FROM T_PROFESSOR WHERE DEPTNO = 101;






