CREATE TABLE channel_tbl
( 	
	channel_id number PRIMARY KEY,
	channel_name varchar2(50)
);
CREATE SEQUENCE channel_id_seq;
CREATE SEQUENCE chat_id_seq;
CREATE TABLE chat_tbl
(	
	chat_id NUMBER PRIMARY KEY,
	channel_id NUMBER,
	author varchar2(10),
	content clob,
	regdate DATE,
	CONSTRAINT chat_tbl_fk foreign key(channel_id) references channel_TBL (channel_id)
);

DROP TABLE channel_tbl CASCADE constraints;