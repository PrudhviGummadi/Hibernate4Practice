DROP TABLE IF EXISTS PERSON;

DROP TABLE IF EXISTS EMPLOYEE;

DROP TABLE IF EXISTS OWNERS;

DROP TABLE IF EXISTS SEQUENCES;

CREATE TABLE PERSON(
id int auto_increment,
first_name varchar(30),
last_name varchar(30),
constraint person_pk primary key (id)
);


CREATE TABLE EMPLOYEE(
id int auto_increment,
first_name varchar(30),
last_name varchar(30),
joining_date date,
dept_name varchar(50),
constraint employee_pk primary key (id));

CREATE TABLE OWNERS(
id int auto_increment,
first_name varchar(30),
last_name varchar(30),
stock int,
property_value int,
constraint owners_pk primary key (id)
);

CREATE TABLE SEQUENCES(
seq_name varchar(30) primary key,
seq_num int not null
);  

insert into sequences  (seq_name, seq_num) values ('person_sequence', 100);

commit;



