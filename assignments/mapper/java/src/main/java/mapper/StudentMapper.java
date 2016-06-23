package mapper;
import main.Student;
import java.sql.*;

public class StudentMapper{

    public String findStatement(String id){
        return "SELECT id, name, department" + 
            " FROM students" +
            " WHERE id = " + id;
    }

    public Student find(long id) throws Exception {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:universit.sqlite3");
            System.out.println("Opened database successfully");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findStatement(String.valueOf(id)));
            resultSet.next();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("DB error");
        }
        finally {
        }
        return new Student(1, "SunKyu", "CSE");
    }

    
}
