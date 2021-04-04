create table pet
( id number(15),
  nickname varchar2(250),
  user_id Number(15))
  ;
  
drop table sen_user;
create table sen_user
(id bigint,
name varchar(250),
email varchar(250),
password varchar(250),
first_name varchar(250),
last_name varchar(250),
enabled int(1),
salary float(15,2)
)
;   

create table sen_role
(id bigint,
role varchar(250))
;
--drop table sen_user_role;
create table sen_user_role
(user_id bigint,
role_id bigint)
;

insert into listuser (id,name,password,enabled) values(1,'oleg','$2a$10$exyJNC3qCSw4HOVtJq3HyOZEDmVQbWmi9Fro7VzG5GWWVS77MTPbu',1) ;
select * from listuser;  

insert into listrole (id,role) values(1,'ROLE_ADMIN') ;
insert into listrole (id,role) values(2,'ROLE_USER') ;
select * from listrole;

insert into listuser_role (user_id,role_id) values(1,2) ;
select * from listuser_role;
--explain plan into plan_table for select * from listuser_role;
commit ;

SELECT a.*  FROM hibernate_sequences a;
--select name, password, 1 as enabled from listuser where name = 'oleg';
--SELECT lu.name as username, lr.role as role FROM listuser lu INNER JOIN listuser_role user_role ON lu.id = user_role.user_id INNER JOIN listrole lr ON user_role.role_id = lr.id WHERE lu.name = 'oleg'
/* SELECT a.table_name,
    a.column_name,
    a.constraint_name,
    b.owner,
    c_pk.table_name ref_table_name,
    c_pk.constraint_name ref_pk
  FROM user_cons_columns a
  JOIN user_constraints b
  ON a.owner            = b.owner
  AND a.constraint_name = b.constraint_name
  JOIN user_constraints c_pk
  ON b.r_owner            = c_pk.owner
  AND b.r_constraint_name = c_pk.constraint_name
  WHERE b.constraint_type = 'R';

   <changeSet author="Oleg Vydra" id="changelog-1.0"
		objectQuotingStrategy="LEGACY">
		<addColumn schemaName="itacademia" tableName="user">
			<column name="enabled" type="boolean" />
		</addColumn>
	</changeSet>

   */


