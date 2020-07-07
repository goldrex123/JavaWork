
/* Drop Tables */

DROP TABLE tbl_member_auth CASCADE CONSTRAINTS;
DROP TABLE tbl_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE tbl_member
(
	userid varchar2(50) NOT NULL,
	userpw varchar2(100) NOT NULL,
	username varchar2(100) NOT NULL,
	regdate date DEFAULT SYSDATE,
	updatedate date DEFAULT SYSDATE,
	enabled char(1) DEFAULT '1',
	PRIMARY KEY (userid)
);


CREATE TABLE tbl_member_auth
(
	userid varchar2(50) NOT NULL,
	auth varchar2(50) NOT NULL,
	CONSTRAINT fk_member_auth FOREIGN KEY (userid) REFERENCES tbl_member(userid),
	PRIMARY KEY (userid, auth)
);




