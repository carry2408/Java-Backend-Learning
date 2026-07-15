import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "carry24";
        Connection connect = null;
        Statement statement = null;
        try {
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Connection failed");
        }

        String sqlInsertStudents = "insert into studentInfo values (1,'Veeresh',20,'Bengaluru'),(2,'Roopa',20,'Bengaluru')";
        String sqlCreateCollegeTable = "create table college(cid int primary key ,name varchar(100),address varchar(100))";
        String sqlGetStudents = "select * from studentInfo";
        try {
            boolean result = statement.execute(sqlCreateCollegeTable);
            System.out.println(result);
            int rows = statement.executeUpdate(sqlInsertStudents);
            System.out.println(rows + " rows inserted");
            ResultSet resultSet = statement.executeQuery(sqlGetStudents);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                String city = resultSet.getString("city");
                System.out.println(id + " " + name + " " + age+ " " + city);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Statement failed");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // closing resources
        try {
            connect.close();
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}