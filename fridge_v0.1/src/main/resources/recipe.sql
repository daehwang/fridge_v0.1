drop table recipe;
select * from recipe;
create table recipe(
   recipe_no         number               primary key,
   title               varchar2(50)      not null,
   contents         varchar2(4000)      not null,
   post_date         date      not null,
   nick               varchar2(30)      not null,
   cooking_time   number               not null,
   good               number               default 0,
   bad               number               default 0,
   hits               number             default 0,
   member_id      varchar2(30)      not null,
   constraint fk_member_id foreign key(member_id) references member(member_id)
)
drop sequence recope_seq;
create sequence recipe_seq nocache; 

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
select count(good) from good_n_bad where recipe_no='74' and good=1;


select * from favorites;