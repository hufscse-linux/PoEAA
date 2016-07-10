package mapper;

import java.sql.*;
import main.Student;
public class Session {

    public ResultSet getResultSet(Statement statement, String sql){
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            return rs;
        }
    }

    public Student getStudent(ResultSet rs, StudentMapper mapper){
        Student student = null;
        try{
            student = mapper.map(rs);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return student;
        }
    }

}
