package example.domain;

import java.util.*;
import org.junit.*;
import org.hibernate.*;

import static example.domain.HibernateFixture.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StudentTest {
  @Test
  public void students_should_have_department() {
    inSession(session -> {
        List<Student> students = session.createCriteria(Student.class).list();
        students.forEach(student -> assertThat(student.getDepartment(), is(notNullValue())));
      });
  }
};
