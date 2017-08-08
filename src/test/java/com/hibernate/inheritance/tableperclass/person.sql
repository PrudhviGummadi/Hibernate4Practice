DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON(
id INT AUTO_INCREMENT,
first_name varchar(30) not null,
last_name varchar(30) not null,
joining_date date,
dept_name varchar(30),
discriminator_value varchar(10),
constraint person_pk primary key (id)
);


commit;


