
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

insert into sen_sensor
 (id ,name,full_name, date_begin ,date_end ,measure ,modified_by_user,date_modified) 
 values (8,'QFnew-34236','water from new system VOC4234236','01-01-2021','01-01-2030','t.cubs',2,'01-01-2021') ;

insert into sen_balance 
 (id ,name, date_begin ,date_end,modified_by_user,date_modified) 
 values (1,'Recycled water balance','01-01-2021','01-01-2030',2,'01-01-2021') ;

rollback;
COMMIT;
----------------------------------------------------------------------------------------------------
-- Window functions
 
SELECT  sss.sensor_id , 
max(sss.value) OVER (PARTITION BY sss.sensor_id) max_val,
max(sss.value) OVER (PARTITION BY sss.date_value) max_val_date
, dense_rank() over (order by sum(value) desc) value_dense_rank
, row_number() over (order by sum(value) desc) value_dense_rank
, rank() over (order by sum(value) desc) value_dense_rank
  FROM public.sen_sensor_show sss 
 group by sss.sensor_id ,sss.value,sss.date_value
 ;
  
 
SELECT *,
       first_value(sensor_id) OVER (PARTITION BY date_value ORDER BY value ASC ) as highest_value,
       last_value(sss.sensor_id)
       OVER (
           PARTITION BY sss.date_value 
           ORDER BY value DESC
           ROWS BETWEEN
               UNBOUNDED PRECEDING
               AND UNBOUNDED FOLLOWING
           ) as lowest_sensor 
          FROM public.sen_sensor_show sss order by sss.date_value ;

commit;         
----------------------------------------------------------------------------------------------------
create table logged_actions (
    schema_name text not null,
    table_name text not null,
    user_name text,
    action_tstamp timestamp with time zone not null default current_timestamp,
    action text NOT null check (action in ('I','D','U')),
    original_data text,
    new_data text,
    query text
) with (fillfactor=100);

-- revoke all on audit.logged_actions from public;

-- You may wish to use different permissions; this lets anybody
-- see the full audit data. In Pg 9.0 and above you can use column
-- permissions for fine-grained control.
-- grant select on audit.logged_actions to public;

create index logged_actions_schema_table_idx 
on logged_actions(((schema_name||'.'||table_name)::TEXT));

create index logged_actions_action_tstamp_idx 
on logged_actions(action_tstamp);

create index logged_actions_action_idx 
on logged_actions(action);
         
CREATE OR REPLACE FUNCTION if_modified_func() RETURNS trigger AS $body$
DECLARE
    v_old_data TEXT;
    v_new_data TEXT;
BEGIN
    /*  If this actually for real auditing (where you need to log EVERY action),
        then you would need to use something like dblink or plperl that could log outside the transaction,
        regardless of whether the transaction committed or rolled back.
    */

    /* This dance with casting the NEW and OLD values to a ROW is not necessary in pg 9.0+ */

    if (TG_OP = 'UPDATE') then
        v_old_data := ROW(OLD.*);
        v_new_data := ROW(NEW.*);
        insert into logged_actions (schema_name,table_name,user_name,action,original_data,new_data,query) 
        values (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,session_user::TEXT,substring(TG_OP,1,1),v_old_data,v_new_data, current_query());
        RETURN NEW;
    elsif (TG_OP = 'DELETE') then
        v_old_data := ROW(OLD.*);
        insert into logged_actions (schema_name,table_name,user_name,action,original_data,query)
        values (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,session_user::TEXT,substring(TG_OP,1,1),v_old_data, current_query());
        RETURN OLD;
    elsif (TG_OP = 'INSERT') then
        v_new_data := ROW(NEW.*);
        insert into logged_actions (schema_name,table_name,user_name,action,new_data,query)
        values (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,session_user::TEXT,substring(TG_OP,1,1),v_new_data, current_query());
        RETURN NEW;
    else
        RAISE WARNING '[IF_MODIFIED_FUNC] - Other action occurred: %, at %',TG_OP,now();
        RETURN NULL;
    end if;

EXCEPTION
    WHEN data_exception THEN
        RAISE WARNING '[IF_MODIFIED_FUNC] - UDF ERROR [DATA EXCEPTION] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
    WHEN unique_violation THEN
        RAISE WARNING '[IF_MODIFIED_FUNC] - UDF ERROR [UNIQUE] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
    WHEN others THEN
        RAISE WARNING '[IF_MODIFIED_FUNC] - UDF ERROR [OTHER] - SQLSTATE: %, SQLERRM: % - %',SQLSTATE,sqlerrm,TG_OP;
        RETURN NULL;
END;
$body$
LANGUAGE plpgsql
SECURITY DEFINER
SET search_path = pg_catalog, public;         

drop TRIGGER sen_user_if_modified_trg on sen_user ;
drop TRIGGER sen_role_if_modified_trg on sen_role;
drop TRIGGER sen_sensor_if_modified_trg on sen_sensor;

CREATE TRIGGER sen_user_if_modified_trg 
 AFTER INSERT OR UPDATE OR DELETE ON sen_user
 FOR EACH ROW EXECUTE PROCEDURE if_modified_func();

CREATE TRIGGER sen_role_if_modified_trg 
 AFTER INSERT OR UPDATE OR DELETE ON sen_role
 FOR EACH ROW EXECUTE PROCEDURE if_modified_func();

CREATE TRIGGER sen_sensor_if_modified_trg 
 AFTER INSERT OR UPDATE OR DELETE ON sen_sensor
 FOR EACH ROW EXECUTE PROCEDURE if_modified_func();


CREATE TRIGGER sen_user_if_update_trg 
 AFTER INSERT OR UPDATE OR DELETE ON sen_user
 FOR EACH ROW EXECUTE PROCEDURE if_modified_table();

CREATE TRIGGER sen_role_if_modified_trg 
 AFTER INSERT OR UPDATE OR DELETE ON sen_role
 FOR EACH ROW EXECUTE PROCEDURE if_modified_table();

CREATE TRIGGER sen_sensor_if_modified_trg 
 AFTER INSERT OR UPDATE OR DELETE ON sen_sensor
 FOR EACH ROW EXECUTE PROCEDURE if_modified_table();



CREATE OR REPLACE FUNCTION if_modified_table() RETURNS trigger AS $body$
BEGIN
    new.date_modified:= NOW();
    new.date_modified:= user;
END;
$body$
LANGUAGE plpgsql
SECURITY DEFINER
SET search_path = pg_catalog, public;         

drop view sen_vbal_sen_show;

create or replace view sen_vbal_sen_show as 

select sb.id balance_id, sb.name name_balance, 
      ss.id id, ss.name name_sensor, 
      ss.full_name full_name,
      sss.date_value as date_value,
      sss.value as value
from sen_balance_sensor sbs 
       join sen_balance sb on sb.id = sbs.balance_id 
       join sen_sensor ss on ss.id =sbs.sensor_id
       left join ( select * from sen_sensor_show where date_value = '2021-04-12' ) sss 
       on ss.id = sss.sensor_id 
    
    
select balance_id, name_balance,  id,  name_sensor,  full_name,
      date_value, value from sen_vbal_sen_show;

select svss.balance_id, svss.name_balance, svss.id, svss.name_sensor, svss.full_name, sss.date_value , sss.value 
 from sen_vbal_sen_show svss 
 left join ( select * from sen_sensor_show where date_value = '2021-04-12') sss 
 on svss.id = sss.sensor_id      
     
select * from sen_sensor_show where date_value = '2021-04-12'       
      
 
select svss.balance_id, svss.name_balance, svss.id, svss.name_sensor, svss.full_name, 
             sss.date_value , sss.value from sen_vbal_sen_show svss 
             left join (select * from sen_sensor_show where date_value = '2021-04-12') sss 
             on svss.id = sss.sensor_id

commit; 
/


select sensor_id, date_value, value, 
lag(value) over(partition by sensor_id order by date_value ) lg,
lag(date_value) over(partition by sensor_id order by date_value ) ld,
case date_value-1 
	when lag(date_value) over(partition by sensor_id order by date_value ) 
	then lag(value) over(partition by sensor_id order by date_value )
	else null
end as prev
from sen_sensor_show order by date_value desc, sensor_id; 

insert into sen_sensor_show values (39,'2021-04-12',121.34);
insert into sen_sensor_show values (3,'2021-04-12',21.34);
insert into sen_sensor_show values (34,'2021-04-12',121.34);
insert into sen_sensor_show values (35,'2021-04-12',34.34);
insert into sen_sensor_show values (36,'2021-04-12',44.34);



