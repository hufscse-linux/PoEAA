package example.domain;

import java.util.*;
import java.util.function.*;
import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MybatisFixture {
  public static final SqlSessionFactory sessionFactory;

  public static void inSession(Consumer<SqlSession> handler) {
    SqlSession session = sessionFactory.openSession();
    if(handler != null) handler.accept(session);
    session.close();
  }
  
  static {
    Properties props = new Properties();
    DataSource dataSource = new PooledDataSource(
        "org.sqlite.JDBC",
        "jdbc:sqlite:university.sqlite3",
        props);
    TransactionFactory txFactory = new JdbcTransactionFactory();
    Environment env = new Environment("development", txFactory, dataSource);
    Configuration configuration = new Configuration(env);

    configuration.getTypeAliasRegistry().registerAlias(Student.class);
    configuration.getTypeAliasRegistry().registerAlias(Department.class);
    configuration.addMapper(Student.Mapper.class);
    configuration.addMapper(Department.Mapper.class);
    sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
  }
};
