#DB Connection Checker

Checked the DB Connection for multiple JDBC Driver. Show on result all table in DB.

You can choose between MSSQL / MYSQL / Oracle JDBC Driver

Example JDBC Driver:
- MSSQL -> runDBCheck/jdbc/mssql-jdbc-6.2.2.jre8.jar
- MYSQL -> runDBCheck/jdbc/com.mysql.jdbc_5.1.5.jar
- Oracle -> runDBCheck/jdbc/ojdbc7.jar

##How do check connection

###Prepare

- Checkout project
- Change with your favorite console into the folder `runDBCheck`
- Do your favorite jdbc driver from the "jdbc" folder into the "lib" folder. Please be sure then only one driver is in the "lib folder".


###Run

1. `java -cp CheckDBConnection.jar:lib/* CheckDBConnection "{jdbcURL}" "{dbUser}" "{password}"`


###Possible Output

####Success

`$ java -cp CheckDBConnection.jar:lib/* ch.acme.util.CheckDBConnection "jdbc:sqlserver://localhost:1433;database=cms" "sa_cms" "password"`

` -------- JDBC Connection Testing ------`

` Microsoft SQL JDBC Driver found`

` Opened Connection successful`

` Execute Query successful, query: SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE'`
` ...`


####Failed

 - MYSQL JDBC Driver found
 - Connection Failed! Check output console
 
 
 


