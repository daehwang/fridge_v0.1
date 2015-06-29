select * from member;
drop table member;
select * from recipe;

create table member(
	member_id varchar2(50) primary key,
	password varchar2(50) not null,
	nick varchar2(50) not null,
	name varchar2(50) not null,
	email varchar2(50) not null,
	gender number default 0,
	answer varchar2(50) not null,
	member_level number default 0,
	register_date date not null,
	love number default 0
)

 select * from member where member_id='java'
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('java', '1234', 'abcd', '한지민', 'java@gmail.com', 2, '파스타', 5, sysdate, 0 )



insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('java11', '1234', '진썬', '김진선', 'jinsun@gmail.com', 2, '김치볶음밥', 4, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('victor', '1234', 'salad', '임승주', 'flydlawn@naver.com', 1, '김치볶음밥', 6, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('java22', '1234', '진썬', '김진선', 'jinsun@gmail.com', 2, '버거킹', 3, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('helloo', '1234', '나나', '나나나', 'jinsun@gmail.com', 2, '수제비', 1, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('hihihihi', '1234', '멍멍이', 'ㅇㅇㅇ', 'aaa@gmail.com', 1, '계란말이', 4, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('zzzzz', '1234', '구리구리', '개구리', 'dfd@gmail.com', 2, '강낭콩', 3, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('victorsj', '1234', '빅터승주', '임승주', 's@gmail.com', 1, '알촌', 3, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('jiwon', '1234', '지원언니', '최지원', 'jiwon@gmail.com', 1, '삼겹살', 5, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('aaaaa', '1234', 'ㅋㅋㅋㅋㅋ', 'ㄹㄹㄹ', 'fes@gmail.com', 2, '된장국', 1, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('bbbbb', '1234', 'ㄷㄷㄷㄷ', 'ㄹㄹㄹ', 'ijd@gmail.com', 1, '피자', 2, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('cccscd', '1234', 'ㄴㄴㄴㄴ', 'ㅇㄹㅇ', 'dfd@gmail.com', 2, '햄버거', 2, sysdate, 0 )

update member set love=35 where member_id='java';


  update member set member_level=5 	where member_id='cccscd';
select member_id, member_level from member;


select *from member;


update member set password='1234', name='한지민ㅇㅇㅇ', nick='abcd',gender=2, email='java@gamil.com',answer='파스타' where member_id='java';
   
   
   
   
   
   select password from member where member_id='aaaa' and name='aaaa' and email='aaa@aaa.com' and answer='aaa';
   select password from member where member_id='aaaa' and name='aaaa' and email='aaa@aaa.com' and answer='aaa';
   
 update member set love=10, member_level=1 where member_id='hihihi'
   
 
 insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('zzzz', '1234', '진썬', '김진선', 'jinsun@gmail.com', 2, '김치볶음밥', 4, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('xxxx', '1234', 'salad', '임승주', 'flydlawn@naver.com', 1, '김치볶음밥', 6, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('cccc', '1234', '진썬', '김진선', 'jinsun@gmail.com', 2, '버거킹', 3, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('vvvv', '1234', '나나', '나나나', 'jinsun@gmail.com', 2, '수제비', 1, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('bbbb', '1234', '멍멍이', 'ㅇㅇㅇ', 'aaa@gmail.com', 1, '계란말이', 4, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('nnnn', '1234', '구리구리', '개구리', 'dfd@gmail.com', 2, '강낭콩', 3, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('mmmm', '1234', '빅터승주', '임승주', 's@gmail.com', 1, '알촌', 3, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('aaaa', '1234', '지원언니', '최지원', 'jiwon@gmail.com', 1, '삼겹살', 5, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('ssss', '1234', 'ㅋㅋㅋㅋㅋ', 'ㄹㄹㄹ', 'fes@gmail.com', 2, '된장국', 1, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('dddd', '1234', 'ㄷㄷㄷㄷ', 'ㄹㄹㄹ', 'ijd@gmail.com', 1, '피자', 2, sysdate, 0 )
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('ffff', '1234', 'ㄴㄴㄴㄴ', 'ㅇㄹㅇ', 'dfd@gmail.com', 2, '햄버거', 2, sysdate, 0 )

   