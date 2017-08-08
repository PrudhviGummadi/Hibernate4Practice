CREATE TABLE EMP
(
EMPNO INT NOT NULL UNIQUE,
ENAME VARCHAR(50),
DEPTNO INT,
JOB VARCHAR(50),
SAL INT,
COMM INT,
MGR INT,
HIREDATE DATE,
ACTIVE BOOLEAN,
CONSTRAINT EMPNO_PK PRIMARY KEY(EMPNO),
CONSTRAINT EMP_DEPT FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO),
CONSTRAINT EMP_MGR FOREIGN KEY (MGR) REFERENCES EMP(EMPNO)
);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7566,'JONES','MANAGER',7839,'1981-4-02',2975,NULL,20);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7788,'SCOTT','ANALYST',7566,'1982-12-09',3000,NULL,20);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7876,'ADAMS','CLERK',7788,'1983-01-12', 1100,NULL,20);

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
VALUES (7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);

COMMIT;