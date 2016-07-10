package mapper;
import main.Student;
import java.sql.*;
import java.util.HashMap;

public class StudentMapper{
    HashMap map = new HashMap();
    public String findStatement(String id){
        return "SELECT id, name" + 
            " FROM students" +
            " WHERE id = " + id;
    }

    public Student map(ResultSet rs) throws Exception {
        int studentId = rs.getInt("id");
        String studentName = rs.getString("name");
        return new Student(studentId, studentName, "");
	}

    public Student find(int id) throws Exception {
        Connection connection = null;
        Statement statement = null;
        String studentName = "SunKyu";
        ResultSet resultSet = null;
        Session session = new Session();
        Student student = null;
        String sql = findStatement(String.valueOf(id));
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:university.sqlite3");
            statement = connection.createStatement();
            resultSet = session.getResultSet(statement, sql);
            if (resultSet != null){
                student = session.getStudent(resultSet, this);
            }
            if (student != null) {
                return student;
            }
        	return null;
        } finally {
            statement.close();
            connection.close();
        }
    }
}
