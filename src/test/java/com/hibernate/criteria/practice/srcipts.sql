DROP TABLE STUDENT IF EXISTS;

drop sequence student_seq if exists;

CREATE SEQUENCE STUDENT_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE TABLE STUDENT(
	ID NUMBER(10),
	NAME VARCHAR2(50),
	COURSE VARCHAR2(50),
	START_DATE DATE,
	END_DATE DATE,
	CONSTRAINT STUDENT_PK PRIMARY KEY(ID)
);

INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Jack','Java',parsedatetime('01-07-2017', 'dd-mm-yyyy'),parsedatetime('01-08-2017','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Jill','Groovy',parsedatetime('01-09-2017', 'dd-mm-yyyy'),parsedatetime('01-10-2017','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Jim','Scala',parsedatetime('01-11-2017', 'dd-mm-yyyy'),parsedatetime('01-12-2017','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'John','Python',parsedatetime('01-01-2017', 'dd-mm-yyyy'),parsedatetime('01-02-2017','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Scott','Spock',parsedatetime('01-03-2017', 'dd-mm-yyyy'),parsedatetime('01-04-2017','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Mike','H20',parsedatetime('01-07-2017', 'dd-mm-yyyy'),parsedatetime('01-08-2017','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Rick','Spark',parsedatetime('01-05-2017', 'dd-mm-yyyy'),parsedatetime('01-06-2017','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Rich','Kafka',parsedatetime('01-07-2018', 'dd-mm-yyyy'),parsedatetime('01-08-2018','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Emy','Spring',parsedatetime('01-02-2018', 'dd-mm-yyyy'),parsedatetime('01-03-2018','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Stott','Hibernate',parsedatetime('01-04-2018', 'dd-mm-yyyy'),parsedatetime('01-05-2018','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Mahesh','Hibernate',parsedatetime('01-04-2018', 'dd-mm-yyyy'),parsedatetime('01-05-2018','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Suresh','Hibernate',parsedatetime('01-04-2018', 'dd-mm-yyyy'),parsedatetime('01-05-2018','dd-mm-yyyy'));
INSERT INTO STUDENT(ID, NAME, COURSE, START_DATE, END_DATE) VALUES (STUDENT_SEQ.NEXTVAL, 'Ramesh','Hibernate',parsedatetime('01-04-2018', 'dd-mm-yyyy'),parsedatetime('01-05-2018','dd-mm-yyyy'));

COMMIT;