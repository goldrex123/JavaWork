SELECT * FROM TEST_MEMBER ;

INSERT INTO TEST_MEMBER values(10,'남윤주', SYSDATE);
INSERT INTO TEST_MEMBER VALUES(22, '이승환', '1994-02-21');
INSERT INTO TEST_MEMBER VALUES(17, '윤종섭', '2019-08-03');
INSERT INTO TEST_MEMBER VALUES('', '이예지', ''); -- 비어있는 ''를 INSERT하면 NULL값 처리
--INSERT INTO TEST_MEMBER VALUES(10, '', SYSDATE);
INSERT INTO TEST_MEMBER VALUES(NULL, '문상현', '2017-01-01');

--dBeaver에서는 기본적으로 auto-commit 수행



