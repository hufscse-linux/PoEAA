package mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import main.Main;
import mapper.StudentMapper;
import main.Student;
import java.util.*;
import java.sql.*;
import java.util.function.*;

import org.junit.Test;
import org.junit.Before;

public class StudentMapperTest {

    static class Query {
        public Query(Connection connection, Class clazz) {
            this.connection = connection;
            this.clazz = clazz;
        }

        public Query columns(List<String> columns) {
            this.columns = columns; 
            return this;
        }

        public Query table(String name) {
            this.tableName = name;
            return this; 
        }
        
        public Query where(List<String> conditions) {
            this.conditions = conditions;
            return this;
        }
        
        public Query mapper(Mapper mapper) {
            this.mapper = mapper;
            return this;
        }

        private String buildSql() {
            StringBuilder builder = new StringBuilder();
            builder.append("select ");
            builder.append(String.join(",", columns));
            builder.append(" from ");
            builder.append(tableName);
            builder.append(" where ");
            builder.append(String.join(" and ", conditions));
            return builder.toString();
        }
        
        public List execute() throws Exception{
            String sql = buildSql();
            Statement statement = null;
            ResultSet rs = null;
            List results = new ArrayList();
            try {
                statement = connection.createStatement();
                rs = statement.executeQuery(sql);
                if(null == mapper) throw new Exception("mapper is required");
                while(rs.next()) {
                    Object o = mapper.map(rs);
                    results.add(o);
                }
            } finally {
                if(null == rs) rs.close();
                if(null == statement) statement.close();
            }
            return results;
        };

        private Class clazz;
        private String tableName;
        private List<String> columns;
        private List<String> conditions;
        private Mapper mapper;
        private Connection connection;
    }

    static class SessionFactory {
        public Session createSession(String driverClass, String connectionString) throws Exception {
			Class.forName(driverClass);
			Connection connection = DriverManager.getConnection(connectionString);

            return new Session(connection);
        }
    }

    static class Session {

        public Session(Connection connection) throws Exception {
            this.connection = connection;
        }

        public Query createQuery(Class clazz) {
            Query query = new Query(connection, clazz);
            return query; 
        }

        public void close() throws Exception {
            connection.close();
        }

        private Connection connection;
    }

	@Test
	public void findTest() throws Exception {
		final int id = 1;
		
        String driverClass = "org.sqlite.JDBC";
        String connectionString = "jdbc:sqlite:university.sqlite3";
        SessionFactory sessionFactory = new SessionFactory();
        Session session = sessionFactory.createSession(driverClass, connectionString);

        Query query = session.createQuery(Student.class);
        List<String> columns = new ArrayList<String>();
        columns.add("id");
        columns.add("name");
        List<String> conditions = new ArrayList<String>();
        conditions.add("id = " + id);
        List<Student> results = query.table("students")
            .columns(columns)
            .where(conditions)
            .mapper(new StudentMapper())
            .execute();

        assertNotNull(results);
        assertTrue(results.size() > 0);
	}

}
