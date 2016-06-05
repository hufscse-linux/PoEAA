package example.domain;

import java.util.*;
import org.junit.*;
import org.hibernate.*;

import static example.domain.HibernateFixture.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StudentTest {
  @Test
  public void loadStudents() {
    inSession(
        new SessionHandler() {
          public void work(Session session) {
            List<Student> students = session.createCriteria(Student.class).list();

            Student student = students.get(0);
            System.out.println("Student name: " + student.getName() + ", department: " + student.getDepartment().getName());

            assertThat(students.isEmpty(), is(false));
          }
        });
  }
};
