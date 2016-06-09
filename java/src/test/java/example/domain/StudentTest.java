package example.domain;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StudentTest {
  @Test
  public void students_should_have_department() {
    HibernateFixture.inSession(session -> {
        List<Student> students = session.createCriteria(Student.class).list();
        students.forEach(student -> assertThat(student.getDepartment(), is(notNullValue())));
      });

    MybatisFixture.inSession(session -> {
        Student.Mapper mapper = session.getMapper(Student.Mapper.class);
        List<Student> students = mapper.listAll();
        students.forEach(student -> assertThat(student.getDepartment(), is(notNullValue())));
      });
  }
};
