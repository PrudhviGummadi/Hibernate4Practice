DROP TABLE STUDENT IF EXISTS;

CREATE TABLE STUDENT(
id INT  PRIMARY KEY AUTO_INCREMENT,
std_name VARCHAR(50),
course VARCHAR(50),
course_end_date date);

insert into student (std_name, course, course_end_date) values('David','java',curdate());

insert into student (std_name, course, course_end_date) values('Sai','Spring',curdate()-1);

insert into student (std_name, course, course_end_date) values('Prudhvi','java',curdate()-2);


commit;