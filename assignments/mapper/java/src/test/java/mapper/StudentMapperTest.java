package mapper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;
import main.Main;
import mapper.StudentMapper;
import main.Student;
import java.sql.*;

import org.junit.Test;
import org.junit.Before;

public class StudentMapperTest{
    StudentMapper mapper = null;

    @Before
    public void setUp(){
        mapper = new StudentMapper();
        
    }

    @Test
    public void findStatementTest(){
        String sql = mapper.findStatement("1");
    }

    @Test
    public void findTest(){
        Student student = mapper.find(1);
        assertEquals(1, student.getId());
        student = mapper.find(2);
        assertEquals(2, student.getId());
    }
    
}
