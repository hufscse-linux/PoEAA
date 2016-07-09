package mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;
import main.Main;
import mapper.StudentMapper;
import main.Student;
import java.sql.*;
import java.util.function.*;
import mapper.Session;

import org.junit.Test;
import org.junit.Before;

public class StudentMapperTest2 {
	StudentMapper mapper = null;

	@Before
	public void setUp(){
		mapper = new StudentMapper();
	}

	@Test
	public void findStatementTest(){
		String sql = mapper.findStatement("1");
	}

	void inSession(int id) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Student student = null;
		Session session = new Session(id);
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:university.sqlite3");
			statement = connection.createStatement();
			resultSet = session.getResultSet(statement);
			if (resultSet != null){
			    student = session.getStudent(resultSet, mapper);
            }
            if (student != null){
				assertNotNull(student);
				assertEquals(id, student.getId());
            }
		} finally {
			if(resultSet != null) resultSet.close();
			if(statement != null) statement.close();
			if(connection != null) connection.close();
		}
	}

	@Test
	public void findTest() throws Exception {
		final int id = 1;
		inSession(id);
	}

}
