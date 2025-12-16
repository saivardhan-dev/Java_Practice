import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "Vardhan@23";
        Connection connect = DriverManager.getConnection(url, user, password);
        Statement statement = connect.createStatement();
        String sql;
        //sql = "INSERT INTO student(id, sname, sage, sclass) values(1,'sam',17,4)";
        //sql = "INSERT INTO student(id, sname, sage, sclass) values(2,'sai',3,34)";
        //sql = "INSERT INTO student(id, sname, sage, sclass) values(3,'ram',14,2)";
        //sql = "DELETE FROM student WHERE id = 3";
        sql = "UPDATE student SET sname='vardhan', sage=21 WHERE id=2";

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


        statement.close();
        connect.close();
    }
}
