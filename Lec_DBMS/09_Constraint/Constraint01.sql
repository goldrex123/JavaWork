-- 제약조건
-- 테이블 생성과 동시에 설정하기

--t_dept2.dcode 참조 예정 0001, 1000 ... 1011
SELECT * FROM T_DEPT2;

--#9001
--제약조건명을 명시하지 않는 방법
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	no NUMBER(4) PRIMARY KEY,
	name varchar2(10) NOT null,
	jumin varchar2(13) NOT NULL UNIQUE,
	area NUMBER(1) CHECK (area < 5),
	deptno varchar2(6) REFERENCES t_dept2(dcode) 
);

-- 별도의 항목으로 제약조건 정의 가능
DROP TABLE t_emp4 CASCADE CONSTRAINT;
CREATE TABLE t_emp4 (
	no NUMBER(4),
	name varchar2(10) NOT null,
	jumin varchar2(13) NOT NULL,
	area NUMBER(1),
	deptno varchar2(6),
	PRIMARY KEY (no),
	UNIQUE (jumin),
	CHECK(area < 5),
	FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
);

--#9002
--제약조건명을 명시하여 정의
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	no NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin varchar2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL 
		CONSTRAINT emp3_jumin_uk UNIQUE,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK (area < 5),
	deptno varchar2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode) 
);

DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	no NUMBER(4),
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL ,
	area NUMBER(1),
	deptno varchar2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY (no),
	CONSTRAINT emp3_jumin_uk UNIQUE (jumin),
	CONSTRAINT emp3_area_ck CHECK (area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY (deptno) REFERENCES t_dept2(dcode) 
);

--#9003 제약조건 조회
SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM user_constraints 
WHERE TABLE_NAME = 'T_EMP4'; --테이블명 대문자

SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM user_constraints 
WHERE TABLE_NAME = 'T_EMP3'; --테이블명 대문자

--#9005 : 제약조건에 맞는 / 위배되는 DML 시도해보기

INSERT INTO T_EMP3 VALUES(1, '오라클', '1234561234567', 4, 1000); --두번 실행하면 오류
--ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated

INSERT INTO T_EMP3 VALUES(2, '오라클', '1234561234567', 4, 1000); 
--ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated

INSERT INTO T_EMP3 VALUES(2, '오라클', '2222222222222222', 4, 1000); 
--ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 16, maximum: 13)

INSERT INTO T_EMP3 VALUES(2, '오라클', '2222222222222', 10, 1000); 
--ORA-01438: value larger than specified precision allowed for this column

INSERT INTO T_EMP3 VALUES(2, '오라클', '2222222222222', 3, 2000); 
-- ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found

INSERT INTO T_EMP3 (no, JUMIN, AREA, DEPTNO) VALUES (2,'3333333333333', 4, 1001);
-- ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

--insert뿐 아니라 update/delete 에서도 오류 발생 가능
UPDATE t_emp3 SET area = 10 WHERE NO = 1; --check 값 오류

DELETE FROM t_dept2 WHERE dcode = 1000; -- 참조하고 있는 부모는 삭제 불가
-- ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - child record found

-- #9005 테이블 생성 후 alter 명령 사용하여 제약조건 추가 가능
-- t_emp4의 name 컬럼에 unique 제약조건 추가
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE (name);

--#9006
-- t_emp4 테이블의 area 컬럼에 not null 제약조건 추가
-- 이미 컬럼의 기본값인 null로 되어 있기 때문에 add가 아닌 modify로 해야 한다
ALTER TABLE t_emp4 MODIFY (area CONSTRAINT emp4_area_nn NOT NULL);

--#9007
ALTER TABLE t_emp4 
ADD CONSTRAINT emp4_name_fk FOREIGN KEY (name) REFERENCES t_emp2(name);
--ORA-02270: no matching unique or primary key for this column-list
--참조되는 부모테이블의 컬럼은 PRIMARY key이거나  UNIQUE 해야 한다.

--일단 부모 테이블의 name을 unique로 바꾼 뒤 위의 쿼리를 다시 실행
ALTER TABLE T_EMP2 
ADD CONSTRAINT emp2_name_uk UNIQUE (name);

--#9008
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	no NUMBER(4),
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL ,
	area NUMBER(1),
	deptno varchar2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY (no),
	CONSTRAINT emp3_jumin_uk UNIQUE (jumin),
	CONSTRAINT emp3_area_ck CHECK (area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY (deptno) REFERENCES t_dept2(dcode) 
	ON DELETE CASCADE --부모 삭제되면 같이 자식도 삭제 
	--ON DELETE SET NULL -- 부모 삭제되면 null 값으로
);

--  #9009
-- t_emp4 테이블의 name 필드의 제약조건에
-- 부모테이블이 삭제되면 null이 되도록 설정하기 (ALTER 사용)

ALTER TABLE T_EMP4 DROP CONSTRAINT emp4_name_fk;
ALTER TABLE t_emp4 
ADD CONSTRAINT emp4_name_fk FOREIGN KEY (name) 
REFERENCES t_emp2(name) 
ON DELETE SET NULL; -- 부모 삭제되면 자식은 null로 변환 

-----------------------------------------
-- DISABLE NOVALIDATE
--#9010
SELECT * FROM T_NOVALIDATE ;
SELECT * FROM T_VALIDATE ;

SELECT owner, CONSTRAINT_name, CONSTRAINT_type, status FROM user_constraints WHERE table_name = 'T_VALIDATE';
SELECT owner, CONSTRAINT_name, CONSTRAINT_type, status FROM user_constraints WHERE table_name = 'T_NOVALIDATE';

INSERT INTO T_NOVALIDATE VALUES(1, 'DDD'); --처음엔 에러 PK니까

ALTER TABLE T_NOVALIDATE 
DISABLE NOVALIDATE CONSTRAINT SYS_C007031;

ALTER TABLE T_NOVALIDATE 
ENABLE NOVALIDATE CONSTRAINT SYS_C007031;

DELETE FROM T_NOVALIDATE WHERE NAME = 'DDD';