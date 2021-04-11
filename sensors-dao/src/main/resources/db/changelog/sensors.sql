
--SET datestyle = dmy;

--drop table hibernate_sequences;
drop table databasechangelog;
drop table databasechangeloglock;
-- ALTER USER postgres WITH PASSWORD 'postgres';
drop table sen_balance_sensor;
drop table sen_balance_role;
drop table sen_sensor_show;
drop table sen_user_role;

drop table sen_balance;
drop table sen_sensor;
drop table sen_user;
drop table sen_role;

create table sen_user
(   id bigint PRIMARY KEY,
    name varchar(250),
    email varchar(250),
    password varchar(250),
    first_name varchar(250),
    last_name varchar(250),
    enabled int default 1
);
comment on table  sen_user is 'Table of users';

create table sen_role 
(   id bigint PRIMARy KEY,
    name varchar(250),
    description varchar(250))
;

create table sen_user_role(
    user_id bigint,
    role_id bigint,
    enabled int
);
comment on table  sen_user_role is 'Table relations between USER and ROLE';

ALTER TABLE sen_user_role
ADD CONSTRAINT sen_user_role_pk PRIMARY KEY (user_id, role_id);


ALTER TABLE sen_user_role
ADD CONSTRAINT sen_user_role_fk_user FOREIGN KEY (user_id)
REFERENCES sen_user (id)
;
ALTER TABLE sen_user_role
ADD CONSTRAINT sen_user_role_fk_role FOREIGN KEY (role_id)
REFERENCES sen_role (id)
;

create table sen_sensor
(   id bigint PRIMARY KEY,
    name varchar(250),
    full_name varchar(250),
    date_begin date,
    date_end date,
    measure varchar(10),
    modified_by_user bigint,
    date_modified date
    );

comment on table  sen_sensor is 'Table of sensors';
    
create table sen_balance
(   id bigint PRIMARY KEY,
    name varchar(250),
    date_begin date,
    date_end date,
    modified_by_user bigint,
    date_modified date
    );
comment on table  sen_balance is 'Table of balances';

create table sen_balance_role(
    balance_id bigint,
    role_id bigint,
    enabled int
);
comment on table  sen_balance_role is 'table of relationships between balances and roles';
    
ALTER TABLE sen_balance_role
ADD CONSTRAINT sen_balance_role_pk PRIMARY KEY (balance_id, role_id);

ALTER TABLE sen_balance_role
ADD CONSTRAINT sen_balance_role_fk_balance FOREIGN KEY (balance_id)
REFERENCES sen_balance (id)
;
ALTER TABLE sen_balance_role
ADD CONSTRAINT sen_balance_role_fk_role FOREIGN KEY (role_id)
REFERENCES sen_role (id)
;
create table sen_balance_sensor(
    balance_id bigint,
    sensor_id bigint,
    enabled int,
    inout   int
);

ALTER TABLE sen_balance_sensor
ADD CONSTRAINT sen_balance_sensor_pk PRIMARY KEY (balance_id, sensor_id);
;

ALTER TABLE sen_balance_sensor
ADD CONSTRAINT sen_balance_sensor_fk_balance FOREIGN KEY (balance_id)
REFERENCES sen_balance (id)
;
ALTER TABLE sen_balance_sensor
ADD CONSTRAINT sen_balance_sensor_fk_sensor FOREIGN KEY (sensor_id)
REFERENCES sen_sensor (id)
;

comment on table  sen_balance_sensor is 'table of relationships between balances and sensors';

create table sen_sensor_show(
    sensor_id bigint,
    date_value date,
    value   real
);
comment on table  sen_balance_sensor is 'Sensor readings table';

ALTER TABLE sen_sensor_show
ADD CONSTRAINT sen_sensor_show_pk PRIMARY KEY (sensor_id,date_value);
;
ALTER TABLE sen_sensor_show
ADD CONSTRAINT sen_sensor_show_fk_sensor FOREIGN KEY (sensor_id)
REFERENCES sen_sensor (id);
 
    
insert into sen_role(id, name,description) values(1,'ROLE_USER','User'); 
insert into sen_role(id, name,description) values(2,'ROLE_ADMIN','Administrator');
insert into sen_role(id, name,description) values(3,'ROLE_ADM_BALANCE','Administrator of balances');

insert into sen_user(id, name,email, password,first_name, last_name) values(1,'oleg','oleg@vydra.com','$2a$10$exyJNC3qCSw4HOVtJq3HyOZEDmVQbWmi9Fro7VzG5GWWVS77MTPbu','Oleg','Vydra'); 
insert into sen_user(id, name,email, password,first_name, last_name) values(2,'dima','dima@gmail.com','$2a$10$exyJNC3qCSw4HOVtJq3HyOZEDmVQbWmi9Fro7VzG5GWWVS77MTPbu','Dima','Volkov');

insert into sen_user_role(user_id, role_id) values(1,1); 
insert into sen_user_role(user_id, role_id) values(1,2); 
insert into sen_user_role(user_id, role_id) values(2,1); 
insert into sen_user_role(user_id, role_id) values(2,3); 

insert into sen_sensor
 (id ,name,full_name, date_begin ,date_end ,measure ,modified_by_user,date_modified) 
 values (1,'QF-1','water from VOC1','01-01-2021','01-01-2030','t.cubs',2,'01-01-2021') ;

insert into sen_sensor
 (id ,name,full_name, date_begin ,date_end ,measure ,modified_by_user,date_modified) 
 values (2,'QF-2','water from VOC2','01-01-2021','01-01-2030','t.cubs',2,'01-01-2021') ;

insert into sen_balance 
 (id ,name, date_begin ,date_end,modified_by_user,date_modified) 
 values (1,'Recycled water balance','01-01-2021','01-01-2030',2,'01-01-2021') ;

