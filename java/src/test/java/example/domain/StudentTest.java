package example.domain;

import java.util.*;
import org.junit.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StudentTest {
  private SessionFactory sessionFactory;
  private Session session = null;

  @Before
  public void before() {
    // setup the session factory
    Configuration configuration = new Configuration();
    configuration.addAnnotatedClass(Student.class);
    configuration.addAnnotatedClass(Department.class);
    configuration.addAnnotatedClass(Professor.class);
    configuration.addAnnotatedClass(Course.class);

    configuration.setProperty("hibernate.dialect",
                              "org.hibernate.dialect.SQLiteDialect");
    configuration.setProperty("hibernate.connection.driver_class",
                              "org.sqlite.JDBC");
    configuration.setProperty("hibernate.connection.url",
                              "jdbc:sqlite:university.sqlite3");
    
    sessionFactory = configuration.buildSessionFactory();
    session = sessionFactory.openSession();
  }
  @After
  public void after() {
    session.close();
    sessionFactory.close();
  }
  @Test
  public void loadStudents() {
    List<Student> students = session.createCriteria(Student.class).list();

    Student student = students.get(0);
    System.out.println("Student name: " + student.getName() + ", department: " + student.getDepartment().getName());

    assertThat(students.isEmpty(), is(false));
  }
};
