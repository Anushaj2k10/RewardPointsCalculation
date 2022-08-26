## RewardPointsCalculation
A project to demonstrate reward points awarded by retailer to the customer based on each recorded purchase.

##Assigned Problem:
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
 
##Logic Covered:
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Tech Stack Used:
---------------
#DataBase: In Memory Database H2 

#Framework :Spring Boot Rest

#Code Formatter
Used Google-Java-Code Formatter


# Application runs on port ::9095
server.port=9095 (Configured in application.properties)

# Application context path:: /rewards
server.servlet.context-path=/rewards (Configured in application.properties)

RestEndpoint URL to test:
------------------------
http://localhost:9095/rewards/{Customer Id}


#DataSets:
---------

Spring Boot automatically picks up the below datasets to on the start of application

DataSets for demonstrating this scenario is  added in schema.sql and data.sql

Schema for below data sets
--------------------------
CREATE TABLE IF NOT EXISTS CUSTOMERS (
                                         ID INTEGER auto_increment(1000,1)  PRIMARY KEY,
    FIRST_NAME VARCHAR(100) NOT NULL,
    LAST_NAME VARCHAR(100) NOT NULL,
    SEX CHAR NOT NULL ,
    CITY VARCHAR(50)NOT NULL ,
    ZIP number NOT NULL,
    ADDRESS VARCHAR(500) NOT NULL
    );

CREATE TABLE IF NOT EXISTS  CUSTOMER_PURCHASE_HISTORY (
                                                          ID INTEGER auto_increment(1,1)  PRIMARY KEY,
    CUST_ID number,
    FOREIGN KEY (CUST_ID) REFERENCES CUSTOMERS(ID),
    PURCHASE_CODE VARCHAR(10) NOT NULL,
    PURCHASE_NUM  VARCHAR(100) NOT NULL,
    PURCHASE_AMOUNT DECIMAL NOT NULL,
    PURCHASE_DATE DATE NOT NULL
    );
    

#CUSTOMERS  
#CUSTOMER_PURCHASE_HISTORY 

Added data as below
-------------------
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('MIKE','JOHNSON','M','COLUMBUS','66200','COLUMBUS ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('NANCY','WHITE','F','OHIO','66201','OHIO ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('MARIA','GOMEZ','F','CALIFORNIA','66202','CALIFORNIA ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('TARO','TANAKA','M','NORTH CAROLINA','66203','NORTH CAROLINA ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('BOB','CLINTON','M','TEXAS','66204','TEXAS ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('PAUL','SMITH','M','NEW YORK','66205','NEW YORK ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('JOHN','DALES','M','CONNECTICUT','66206','CONNECTICUT ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('MICHAEL','JACKSON','M','MISSOURI','66207','MISSOURI ADDRESS');
INSERT INTO CUSTOMERS (FIRST_NAME, LAST_NAME,SEX,CITY,ZIP,ADDRESS) VALUES ('PERRY','COPUS','M','FLORIDA','66208','FLORIDA ADDRESS');


INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1000,'P001','3','100','2022-07-03');
INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1000,'P002','4','50','2022-06-03');
INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1001,'P010','12','10','2022-05-27');
INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1002,'P001','3','120','2022-07-02');
INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1000,'P004','3','180','2022-07-20');
INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1002,'P001','3','108','2022-08-03');
INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1003,'P001','3','120.75','2022-08-15');
INSERT INTO CUSTOMER_PURCHASE_HISTORY (CUST_ID, PURCHASE_CODE, PURCHASE_NUM,PURCHASE_AMOUNT,PURCHASE_DATE) VALUES (1000,'P008','3','100','2022-08-03');


##Steps to run this application
-------------------------------
1)Pull the code  from git hub url in to a folder(Eg D:\Repository):
git clone https://github.com/Anushaj2k10/RewardPointsCalculation.git

2)Open git bash window at D:\Repository\rewards
  mvn spring-boot:run
  
3)Install postman to test the endpoint
http://localhost:9095/rewards/{Customer Id}

In data.sql sample customer ids maintained as 1000,1001,1002,1003


#Unit testing:
-------------
#Junit 5 test cases added to test the scenarios












