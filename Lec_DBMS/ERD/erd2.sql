
/* Drop Tables */

DROP TABLE NEW_TABLE CASCADE CONSTRAINTS;
DROP TABLE lecture CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE department
(
	deptno number NOT NULL,
	phonenum varchar2(20),
	office varchar2(10),
	name varchar2(10) NOT NULL,
	PRIMARY KEY (deptno)
);


CREATE TABLE lecture
(
	lecno number NOT NULL,
	name varchar2(10) NOT NULL,
	scorecount number,
	stucnt number,
	location varchar2(10) UNIQUE,
	lecyear varchar2(10),
	profno number NOT NULL,
	PRIMARY KEY (lecno)
);


CREATE TABLE NEW_TABLE
(
	studno number NOT NULL,
	lecno number NOT NULL
);


CREATE TABLE professor
(
	profno number NOT NULL,
	jumin char(13),
	addr varchar2(40),
	name varchar2(10) NOT NULL,
	position varchar2(10),
	phonenum varchar2(20),
	hiredate date,
	deptno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE student
(
	studno number NOT NULL,
	jumin char(13),
	name varchar2(10) NOT NULL,
	grade number,
	phonenum varchar2(20),
	addr varchar2(40),
	deptno number NOT NULL,
	PRIMARY KEY (studno)
);



/* Create Foreign Keys */

ALTER TABLE professor
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE student
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE NEW_TABLE
	ADD FOREIGN KEY (lecno)
	REFERENCES lecture (lecno)
;


ALTER TABLE lecture
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE NEW_TABLE
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;



