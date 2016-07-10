package example.domain;

import java.util.*;
import java.sql.*;

import org.junit.*;
import org.springframework.jdbc.core.*;
import org.sqlite.SQLiteDataSource;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StudentTest {
    @Test
    public void students_should_have_department() {
        String connectionString = "jdbc:sqlite:university.sqlite3";
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(connectionString);
        JdbcTemplate template = new JdbcTemplate(dataSource);

        List<Student> students = template.query("select * from students", new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                int studentId = rs.getInt("id");
                String studentName = rs.getString("name");
                return new Student(studentId, studentName, "");
            }
        });
        students.forEach(student -> assertThat(student.getName(), is(notNullValue())));

        students = template.query("select * from students", (rs, rowNum) -> {
            int studentId = rs.getInt("id");
            String studentName = rs.getString("name");
            return new Student(studentId, studentName, "");
        });
        students.forEach(student -> assertThat(student.getName(), is(notNullValue())));
        
        students = template.query("select * from students", (rs, rowNum) -> {
            return new Student(rs.getInt("id"), rs.getString("name"), "");
        });
        students.forEach(student -> assertThat(student.getName(), is(notNullValue())));

        students = template.query("select * from students", (rs, rowNum) -> new Student(rs.getInt("id"), rs.getString("name"), ""));
        students.forEach(student -> assertThat(student.getName(), is(notNullValue())));
        
        final List<Student> students2 = new ArrayList<Student>();
        template.query("select * from students", new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                int studentId = rs.getInt("id");
                String studentName = rs.getString("name");
                students2.add(new Student(studentId, studentName, ""));
            }
        });
        students2.forEach(student -> assertThat(student.getName(), is(notNullValue())));
        
        MybatisFixture.inSession(session -> {
            Student.Mapper mapper = session.getMapper(Student.Mapper.class);
            List<Student> students3 = mapper.listAll();
            students3.forEach(student -> assertThat(student.getName(), is(notNullValue())));
        });

        HibernateFixture.inSession(session -> {
            List<Student> students4 = session.createCriteria(Student.class).list();
            students4.forEach(student -> assertThat(student.getName(), is(notNullValue())));
        });
    }
};
