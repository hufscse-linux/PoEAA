package mapper;
import main.Student;
import java.sql.*;

public class StudentMapper implements Mapper<Student> {
    public Student map(ResultSet rs) throws Exception {
        int studentId = rs.getInt("id");
        String studentName = rs.getString("name");
        return new Student(studentId, studentName, "");
	}
}
