package mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;
import main.Main;
import mapper.StudentMapper;
import main.Student;
import java.sql.*;
import java.util.function.*;

import org.junit.Test;
import org.junit.Before;

public class StudentMapperTest {
	StudentMapper mapper = null;

	@Before
	public void setUp(){
		mapper = new StudentMapper();
	}

	@Test
	public void findStatementTest(){
		String sql = mapper.findStatement("1");
	}

	void findByIdInSession(int id, Consumer<ResultSet> callback) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:university.sqlite3");
			statement = connection.createStatement();
			String sql = "SELECT id, name FROM students WHERE id=" + id;

			resultSet = statement.executeQuery(sql);
			if(callback != null) callback.accept(resultSet);
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
	}

	@Test
	public void findTest() throws Exception {
		findByIdInSession(1, rs -> {
			try {
				Student student = mapper.map(rs);
				assertNotNull(student);
				assertEquals(1, student.getId());
			} catch(Exception e) {
				System.out.println(e);
			}
		});
	}

}
