CREATE TABLE SALGRADE(
HISAL INT,
LOSAL INT,
GRADE INT);

INSERT INTO SALGRADE (HISAL, LOSAL, GRADE)
VALUES (1, 700, 1200);

INSERT INTO SALGRADE (HISAL, LOSAL, GRADE)
VALUES (2, 1201, 1400);

INSERT INTO SALGRADE (HISAL, LOSAL, GRADE)
VALUES (3, 1401, 2000);

INSERT INTO SALGRADE (HISAL, LOSAL, GRADE)
VALUES (4, 2001, 3000);

INSERT INTO SALGRADE (HISAL, LOSAL, GRADE)
VALUES (5, 3001, 9999);

COMMIT;