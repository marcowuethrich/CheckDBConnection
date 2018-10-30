#DB Connection Checker

Checked the DB Connection for multiple JDBC Driver. Run java with some parameter (userName, JDBC-URL, password, query).

You can choose between MSSQL / MYSQL / Oracle JDBC Driver

Example JDBC Driver:
- MSSQL -> runDBCheck/jdbc/mssql-jdbc-6.2.2.jre8.jar
- MYSQL -> runDBCheck/jdbc/com.mysql.jdbc_5.1.5.jar
- Oracle -> runDBCheck/jdbc/ojdbc7.jar

Java start parameter:

- args[0] = JDBC Connection String
- args[1] = Username
- args[2] = password
- args[3] = DB-Query // Can be emtpy, its show all readable tables from the db

Example:

`java -cp CheckDBConnection.jar:lib/* ch.acme.util.CheckDBConnection args[0] args[1] args[2] args[3] args[4]`

##How do check connection

###Prepare

- Checkout project
- Change with your favorite console into the folder `runDBCheck`
- Do your favorite jdbc driver from the "jdbc" folder into the "lib" folder. Please be sure then only one driver is in the "lib folder".


###Run

`java -cp CheckDBConnection.jar:lib/* ch.acme.util.CheckDBConnection "{jdbcURL}" "{dbUser}" "{password}" "{query|empty}"`


###Possible Output

####Success

`$ java -cp CheckDBConnection.jar:lib/* ch.acme.util.CheckDBConnection "jdbc:sqlserver://localhost:1433;database=cms" "sa_cms" "password" ""` 

` -------- JDBC Connection Testing ------`

` Microsoft SQL JDBC Driver found`

` Opened Connection successful`

` Execute Query successful, query: SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE'`
` ...`


####Failed

 - MYSQL JDBC Driver found
 - Connection Failed! Check output console
 
 
 


