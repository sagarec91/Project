1.H&M -Application contains two folders.
2."Project War File" contains war file of the project.
3."Project Source Code" contains source code base of the project.
   
**************************************************************************************************************

					Steps to run the project on Tomcat7 Server

**************************************************************************************************************

1. Download and save project war in the local system.
2. Put war file in the folder \webapps folder.
3. Start the server. (Go to tomcat's \bin folder and run startup batch file)
4. Hit url : http://localhost:8080/
5. You will be redirected to the application's home page.
6. Enter any number between 1 and 50 and click on 'Sort' button.
7. Details of randomly generated numbers, sorted numbers and other details will be displayed on the screen.
8. Now Hit this url : http://localhost:8080/console.
9. On console, login with JDBC url : "jdbc:h2:mem:testdb"
10.You can find database table created. Run query "SELECT * FROM NUMBER_SORTING_DETAILS" to check with the data.


**************************************************************************************************************

						Technologies Used

**************************************************************************************************************

1. Spring Boot Framework
2. Apache Maven 4.0.0
3. Java 8
4. Tomcat 7
5. Spring 5.0
6. Hibernate 5.2.0 and JPA
7. JSP
8. H2 in-Memory Database
9. jUnit

**************************************************************************************************************

Sorting Algorithm : Selection Sort algorithm is used as it requires minimum number of swaps. It is based on the concept of doing a significant number of comparisons before moving each element directly to its eventual sorted resting place.

**************************************************************************************************************