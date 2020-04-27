/* Drop Tables */
DROP TABLE phonebook CASCADE CONSTRAINTS;

/* Create Tables */
CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);

--시퀀스 객체 생성
DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE test_member_seq;

SELECT * FROM PHONEBOOK ORDER BY PB_UID DESC;

SELECT COUNT(*) cnt FROM TEST_MEMBER;
SELECT max(MB_NO) "max" FROM TEST_MEMBER ;
SELECT MIN(MB_NO) "min" FROM TEST_MEMBER ;

SELECT COUNT(*) cnt FROM PHONEBOOK ;
SELECT PB_UID FROM PHONEBOOK WHERE PB_UID = 3;

INSERT INTO TEST_MEMBER VALUES (test_member_seq.nextVal, 'aaa', sysdate);