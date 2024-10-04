# infosys-coding-exercise

## WebAPI Developer:

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total. 

## Tech Stack:
* Spring Boot for RESTful API
* MySQL for database
* Maven for dependency management

## Prerequisites:
* Compatible versions of Java and Maven.
* Local MySQL database with valid credentials.

## Testing the API:

Clone the repository using `git clone git@github.com:manicharanloka/infosys-coding-exercise.git`

cd into application using `cd infosys-coding-exercise`

generate jar file using `mvn clean install`

run the jar file using `java -jar ./target/rewards-api-0.0.1-SNAPSHOT.jar`

test the results using `curl localhost:8080/rewards/{customerId}`