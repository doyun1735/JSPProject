/* 사용자 계정 만들기 */
create user jspuserd identified by jsp1234;

-- SQL -> 관계형 데이터베이스 에서 사용.
-- 1) 데이터 정의 언어(DDL) : create, alter, drop
-- 2) 데이터 조직 언어(DML) : insert, update, delete, select
-- 3) 데이터 제어 언어(DCL) : grant, revoke

-- member 테이블 생성 
create table member
(
	id			varchar2(15)     primary key,
	password	varchar2(10),
	name		varchar2(20),
	age			number,
	gender		char(6),
	addr		varchar2(100),
	regdate		date			 default sysdate
);

select * from member

insert into member values('test5', '1234', '홍길동', 20, 1, '인천 부평구', default);

drop table member;

update member
set addr = '인천'
where id = 'test'

delete from member
where id='test'

select * from member where id ='test4'

