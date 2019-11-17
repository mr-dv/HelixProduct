README
=========
Helix Product Application is a simple Rest API for storing product and get product in json format\
It is built using Java 1.8 and Spring Boot technology

Other technologies used:
1. Maven for build tool
2. Hibernate and H2 in-memory database for persistence
3. JUnit5 and Mockito for Unit Testing and Integration Testing
4. curl command to test the Rest API services

The build package for this Helix Product App is inside the HelixProduct/target folder
The jar file name is: 
HelixProduct-0.0.1-SNAPSHOT.jar

How to test the Rest API ?
1. Start the Spring Boot Application by running: 
     java -jar HelixProduct-0.0.1-SNAPSHOT.jar
2. Use the curl command to test the Rest API

Sample curl command for getting the product:
curl -X GET -H "Content-Type: application/json" http://localhost:8080/product/getProduct?id=1

Sample curl command to save the product:
curl -X PUT -H "Content-Type: application/json" -d '{"id": "79", "name": "book79", "quantity": "9", "saleAmount": "99.99"}' http://localhost:8080/product/saveProduct

Testing (which consist of unit testing and integration testing) is inside the test folder\
To run the test, go to HelixProduct project folder, and run this command:    
   mvn test

Testing covered in test folder:
1. Repository Test
2. Service Test
3. Rest Controller Test
4. Integration Test

Thank you for your attention.
