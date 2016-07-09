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

	void inSession(Consumer<ResultSet> cr) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Session session = new Session();
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:university.sqlite3");
			statement = connection.createStatement();
			resultSet = session.getResultSet(statement);
			if (resultSet != null){
			    //do somehting maybe consume ResultSet?
			    if(cr != null){
			        cr.accept(resultSet);
                }
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
		inSession(
		rs -> {
			try {
				Student student = mapper.map(rs);
				assertNotNull(student);
				assertEquals(id, student.getId());
			} catch(Exception e) {
				System.out.println(e);
			}
		});
	}

}
