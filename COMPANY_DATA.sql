CREATE DATABASE COMPANY_DATA;
USE COMPANY_DATA;

CREATE TABLE COMPANY (
C_ID INT PRIMARY KEY,
NAME VARCHAR(30),
TURN_OVER INT,
ADDRESS VARCHAR(20),
DATE_OF_ESTB VARCHAR(12)
);

INSERT INTO COMPANY VALUES(101,"TCS",20000000,"BANGLORE","1998-12-11");
INSERT INTO COMPANY VALUES(102,"INFOSYS",20000000,"BANGLORE","1998-12-11");
INSERT INTO COMPANY VALUES(103,"WIPRO",20000000,"BANGLORE","1998-12-11");
INSERT INTO COMPANY VALUES(104,"COGNIZANT",20000000,"BANGLORE","1998-12-11");
SELECT * FROM COMPANY;