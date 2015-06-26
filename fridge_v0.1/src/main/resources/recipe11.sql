-- 레시피 테이블 --
drop table recipe;
drop table member;
drop table recipe_file;
drop table recipe_item;
select * from recipe;
create table recipe(
   recipe_no         number               primary key,
   title               varchar2(50)      not null,
   contents         clob    not null,
   post_date         date      not null,
   nick               varchar2(50)      not null,
   cooking_time   number               not null,
   hits               number             default 0,
   member_id      varchar2(50)      not null,
   constraint fk_member_id foreign key(member_id) references member(member_id)
)
drop sequence recipe_seq;
create sequence recipe_seq nocache; 
delete from recipe;

-- 요리재료 테이블 -- 
drop table item;
create table item(
	item_no number primary key,
	item_name varchar2(50) not null
)
drop sequence item_no_seq;
create sequence item_no_seq nocache;

-- 식자재 테이블 --
select * from recipe_item;
drop table recipe_item;
create table recipe_item(
	food_reserves number primary key,
	item_no number not null,
	recipe_no number not null,
	constraint fk_recipe_no foreign key(recipe_no) references recipe(recipe_no),
	constraint fk_item_no foreign key(item_no) references item(item_no)
)
drop sequence food_reserves_seq;
create sequence food_reserves_seq nocache;
commit
-- 회원 테이블 --
drop table member;
select * from member;
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

insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('java', '1234', 'abcd', '한지민', 'java@gmail.com', 1, '파스타', 5, sysdate, 0 );
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('jquery', '1234', 'abcd', '이윤지', 'java@gmail.com', 1, '파스타', 5, sysdate, 0 );
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('salad', '1234', 'abcd', '아이유', 'java@gmail.com', 1, '파스타', 5, sysdate, 0 );
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('aa', '1234', 'abcd', '후아유', 'java@gmail.com', 1, '파스타', 5, sysdate, 0 );
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('bb', '1234', 'abcd', '씬디', 'java@gmail.com', 1, '파스타', 5, sysdate, 0 );
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('cc', '1234', 'abcd', '신봉선', 'java@gmail.com', 1 '파스타', 5, sysdate, 0 );

insert into recipe(recipe_no,   title, contents, post_date, nick, cooking_time, good, bad, hits, member_id)
values(recipe_seq.nextval, '안녕하세요', '안녕하세요 반갑습니다.', sysdate, '한지민', '30', 0,0,0,'java');
insert into recipe(recipe_no,   title, contents, post_date, nick, cooking_time, good, bad, hits, member_id)
values(recipe_seq.nextval, '안녕하세요', '안녕하세요 반갑습니다.', sysdate, '이윤지', '30', 0,0,0,'jquery');
insert into recipe(recipe_no,   title, contents, post_date, nick, cooking_time, good, bad, hits, member_id)
values(recipe_seq.nextval, '안녕하세요', '안녕하세요 반갑습니다.', sysdate, '아이유', '30', 0,0,0,'salad');
insert into recipe(recipe_no,   title, contents, post_date, nick, cooking_time, good, bad, hits, member_id)
values(recipe_seq.nextval, '안녕하세요', '안녕하세요 반갑습니다.', sysdate, '후아유', '30', 0,0,0,'aa');
insert into recipe(recipe_no,   title, contents, post_date, nick, cooking_time, good, bad, hits, member_id)
values(recipe_seq.nextval, '안녕하세요', '안녕하세요 반갑습니다.', sysdate, '씬디', '30', 0,0,0,'bb');
insert into recipe(recipe_no,   title, contents, post_date, nick, cooking_time, good, bad, hits, member_id)
values(recipe_seq.nextval, '안녕하세요', '안녕하세요 반갑습니다.', sysdate, '신봉선', '30', 0,0,0,'cc');


insert into item(item_no,item_name) values(item_no_seq.nextval,'대파');
insert into item(item_no,item_name) values(item_no_seq.nextval,'쪽파');
insert into item(item_no,item_name) values(item_no_seq.nextval,'양파');
insert into item(item_no,item_name) values(item_no_seq.nextval,'버터');
insert into item(item_no,item_name) values(item_no_seq.nextval,'날치알');
insert into item(item_no,item_name) values(item_no_seq.nextval,'마늘');
insert into item(item_no,item_name) values(item_no_seq.nextval,'참치');
insert into item(item_no,item_name) values(item_no_seq.nextval,'만두');
insert into item(item_no,item_name) values(item_no_seq.nextval,'꽁치');

insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,1,1);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,2,1);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,3,1);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,4,2);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,5,2);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,6,2);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,1,3);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,2,3);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,5,3);
insert into recipe_item(food_reserves,item_no,recipe_no) values(food_reserves_seq.nextval,9,3);

-- 레시피 번호로 재료 목록 뽑기 -- 
select item_name from item i, 
(select item_no from recipe_item where recipe_no=2) 
where i.item_no=r.item_no;

-- 재료로 레시피 찾기 -- 
select * from recipe 
where recipe_no=(select recipe_no from recipe_item 
where item_no=(select item_no from item 
where item_name='날치알'));

select * from item where item_name='날치알';
select * from recipe where ;



delete from recipe_item;
delete from recipe_file;
delete from recipe;
select * from recipe;
select * from recipe_item;
select * from item;
drop table recipe_file
create table recipe_file(
	file_no number primary key,
	file_name varchar2(100) not null,
	recipe_no number not null,
	file_path varchar2(500) not null,
	constraint fk_recipe_no_file foreign key(recipe_no) references recipe(recipe_no)
)
create sequence file_no_seq nocache;

select file_name from recipe_file where recipe_no='55'

select max(file_no) from recipe_file where recipe_no='147'
select file_path from recipe_file where recipe_no='150'

create table good_n_bad(
	gnb_no number primary key,
	good number default 0,
	bad number default 0,
	recipe_no number not null,
	member_id varchar2(50) not null,
	constraint fk_recipe_no_gnb foreign key(recipe_no) references recipe(recipe_no),
	constraint fk_member_id_gnb foreign key(member_id) references member(member_id)
);
create sequence gnb_no_seq nocache;
select gnb_no_seq.nextval from dual

drop table favorites;
create table favorites(
   favorites_no         number               primary key,
   member_id           varchar2(50)         not null,
   recipe_no             number             not null,
   insert_date         date                  not null,
   constraint recipe_no   foreign key(recipe_no) references recipe(recipe_no),
   constraint member_id   foreign key(member_id) references member(member_id)
)
drop sequence favorites_no_seq;
create sequence favorites_no_seq nocache;
