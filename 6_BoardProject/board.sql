create table board
(
	num number	primary key,
	name varchar2(10), 
	title varchar2(100),
	content varchar2(1000),
	hits number default 0,
	wdate date default sysdate,
	attachment varchar2(50) --첨부파일
);
-- 시퀀스 생성
create sequence board_seq;
insert into BOARD values(board_seq.nextval,'1','1','111',default ,default ,'' )
select * from BOARD;