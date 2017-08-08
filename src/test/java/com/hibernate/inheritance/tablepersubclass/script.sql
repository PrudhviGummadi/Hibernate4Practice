drop table if exists employee;

drop table if exists owners;

drop table if exists person;

create table person(
id int auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
constraint person_pk primary key (id)
);

create table employee(
id int auto_increment,
joining_date date,
dept_name varchar(30),
constraint employee_pk primary key (id),
constraint employee_person_fk foreign key (id) references person(id)
);

create table owners(
id int auto_increment,
stock int,
property_value varchar(30),
constraint owners_pk primary key (id),
constraint owners_person_fk foreign key (id) references person(id)
);