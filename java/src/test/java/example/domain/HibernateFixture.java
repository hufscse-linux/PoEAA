package example.domain;

import java.util.function.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateFixture {
  public static final SessionFactory sessionFactory;

  public static void inSession(Consumer<Session> handler) {
    Session session = sessionFactory.openSession();
    if(handler != null) handler.accept(session);
    session.close();
  }
  
  static {
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
  }
};
