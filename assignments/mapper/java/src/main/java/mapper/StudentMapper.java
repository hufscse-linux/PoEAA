package mapper;
import main.Student;
import java.sql.*;

public class StudentMapper{

    public String findStatement(String id){
        return "SELECT id, name, department" + 
            " FROM students" +
            " WHERE id = " + id;
    }

    public Student find(long id) {
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
            
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return new Student(1, "SunKyu", "CSE");
    }

    
}
