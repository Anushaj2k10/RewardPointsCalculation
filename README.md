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

#CUSTOMERS  
#CUSTOMER_PURCHASE_HISTORY 


##Steps to run this application
-------------------------------
1)Pull the code  from git hub url in to a folder(Eg D:\Repository):
git clone 

2)Open git bash window at D:\Repository\rewards
  mvn spring-boot:run
  
3)Install postman to test the endpoint










