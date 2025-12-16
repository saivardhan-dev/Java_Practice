# JDBC #
- JDBC (Java Database Connectivity) is an API that allows Java applications to communicate with databases (MySQL, Oracle, PostgreSQL, etc.).
- JDBC allows Java programs to connect to databases using a driver, execute SQL queries, process results, and safely close resources.

# STEP-BY-STEP JDBC FLOW #
*Step-1* : Import JDBC Packages 
- These packages contain interfaces & classes like: Connction, Statement, PreparedStatement, ResultSet, DriverManager. Without importing them, Java doesn’t know how to talk to a database.

*Step-2* : Load & Register JDBC Driver (Class.forName("com.mysql.cj.jdbc.Driver");)
- Internally JVM loads MySQL driver class into memory and Driver registers itself with DriverManager. Think of driver as a translator between Java & MySQL.

*Step-3* : Establish Connection
```text
String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "Vardhan@23";
        Connection connect = DriverManager.getConnection(url, user, password);
```
- Java sends request to DB using driver, MySQL verifies: DB exists and Username & password.
- If valid → Connection object created
- Connection represents a live session between Java and DB.

*Step-4* : Create Statement
- Statement statement = connect.createStatement();
  
*Step-5* :  Execute SQL Query (INSERT / UPDATE / DELETE)
```text
sql = "INSERT INTO student(id, sname, sage, sclass) values(1,'sam',17,4)";
sql = "INSERT INTO student(id, sname, sage, sclass) values(2,'sai',3,34)";
sql = "INSERT INTO student(id, sname, sage, sclass) values(3,'ram',14,2)";
sql = "DELETE FROM student WHERE id = 3";
sql = "UPDATE student SET sname='vardhan', sage=21 WHERE id=2";
```

*Step-6* : Process Results
```text
int rowAffected = statement.executeUpdate(sql);
//        if (rowAffected == 0) {
//            System.out.println("Unable to insert Data");
//        } else {
//            System.out.println("Inserted Data successfully");
//        }

//        if (rowAffected == 0) {
//            System.out.println("No record found with id = 3");
//        } else {
//            System.out.println("Deleted record successfully");
//        }
        if (rowAffected > 0) {
            System.out.println("Record updated successfully");
        } else {
            System.out.println("No record found to update");
        }
```

*Step-7* : Close Resources: In order to prevent data or memory leaks, it is important to use close statements.
```text
  statement.close();
  connect.close();
```
