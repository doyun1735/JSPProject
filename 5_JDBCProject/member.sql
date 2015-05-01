/*사용자 계정 만들기*/

/*  create user jspuserd identified by jsp1234;  */

--SQL ->관계형 데이터베이스 에서 사용.
--1) 데이터 정의 언어(DDL) : create,alter,drop   //alter는 컬럼이 추가 create는 테이블이 추가
--2) 데이터 조직 언어(DML) : insert,update,delete,select
--3) 데이터 제어 언어(DCL) : grant,revoke


--member 테이블 생성 					primary key는 중복된값 안들어 오게 해주는 키워드!
create table member
(
	id				varchar2(15)		primary key, 
	password		varchar2(10),
	name			varchar2(20),
	age			number,
	gender			char(1),        
	addr			varchar2(100),
	regdate		date				default sysdate
);
select * from MEMBER

insert into MEMBER values('test1','1234','최도','24','1','인천광역시 계양구 계산동',default);

drop table member;

update member 
set addr ='경기도'
where id='test'
--delete는 데이터만 지운다
delete member
where id='test'
--where 키워드는 조건을 붙이는 것이다.
--from은 생략이 가능하다.
