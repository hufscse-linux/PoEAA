package mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import main.*;
import mapper.*;
import java.util.*;
import java.sql.*;
import java.util.function.*;

import org.junit.*;
import javax.sql.*;

public class StudentMapperTest {

    private static SessionFactory sessionFactory;
    @BeforeClass
    public static void setUpClass() {
        String connectionString = "jdbc:sqlite:university.sqlite3";
        org.sqlite.SQLiteDataSource dataSource = new org.sqlite.SQLiteDataSource();
        dataSource.setUrl(connectionString);
        sessionFactory = new SessionFactory(dataSource);
    }

    private Session session;
    @Before
    public void setUp() throws Exception {
        session = sessionFactory.createSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
	@Test
	public void findTest() throws Exception {
		final int id = 1;

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
