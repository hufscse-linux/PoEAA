package mapper;
import main.Student;
import java.sql.*;
import java.util.HashMap;

public class StudentMapper{
    HashMap <Integer, Student> map = new HashMap<Integer, Student>();

    public String findStatement(String id){
        return "SELECT id, name" + 
            " FROM students" +
            " WHERE id = " + id;
    }

    public Student find(int id) throws Exception {
        if (map.containsKey(id)){
            return map.get(id);
        }
        Student student = null;
        Connection connection = null;
        Statement statement = null;
        int studentId = 1;
        String studentName = "SunKyu";
        //String departmentId = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:university.sqlite3");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findStatement(String.valueOf(id)));
            resultSet.next();
            studentId = resultSet.getInt("id");
            studentName = resultSet.getString("name");
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("DB error");
            return;
        }
        finally {
            student = new Student(studentId, studentName, "CSE");
            map.put(id, student);

        }
        return student;
    }

    
}
