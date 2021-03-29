create table pet
( id number(15),
  nickname varchar2(250),
  user_id Number(15))
  ;
  
drop table listuser;
create table listuser
(id number(15),
name varchar2(250),
email varchar2(250),
password varchar2(250),
first_name varchar2(250),
last_name varchar2(250),
enabled number(1),
salary number(15,2)
)
;   

create table listrole
(id number(15),
role varchar2(250))
;
drop table listuser_role;
create table listuser_role
(user_id number(15),
role_id number(15))
;

insert into listuser (id,name,enabled) values(1,'oleg',1) ;
select * from listuser;  

insert into listrole (id,role) values(1,'ROLE_ADMIN') ;
insert into listrole (id,role) values(2,'ROLE_USER') ;
select * from listrole;

insert into listuser_role (user_id,role_id) values(1,2) ;
select * from listuser_role;
commit ;

SELECT a.sequence_name, a.next_val  FROM hibernate_sequences a;
--select name, password, 1 as enabled from listuser where name = 'oleg';
--SELECT lu.name as username, lr.role as role FROM listuser lu INNER JOIN listuser_role user_role ON lu.id = user_role.user_id INNER JOIN listrole lr ON user_role.role_id = lr.id WHERE lu.name = 'oleg'

