package example.reflection;

import java.lang.reflect.*;
import example.domain.*;
import example.domain.Student;

import org.junit.*;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.contrib.java.lang.system.*;

import java.util.*;
import java.sql.*;
import org.springframework.jdbc.core.*;
import org.sqlite.SQLiteDataSource;


public class MakeStringAndPrintToStdoutTest {


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void test1() throws Exception {
        Class<?> string_class = Class.forName("java.lang.String");
        Constructor<?> constructor = string_class.getConstructor(char[].class);
        String str = (String)constructor.newInstance("some string".toCharArray());
        
        assertThat("some string", is(str));

        Class<?> system_class = Class.forName("java.lang.System");

        Field out_field  = system_class.getField("out");
        Object out = out_field.get(null);
        Class<?> out_class = out.getClass();
        Method println = out_class.getMethod("println", String.class);
        println.invoke(out, str);
        assertEquals(str+"\n", systemOutRule.getLog());

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        out = out_field.get(null);
        out_class = out.getClass();
        println = out_class.getMethod("println", String.class);
        println.invoke(out, str);
        assertEquals(str+"\n", output.toString());
    }

    @Test
    public void testReflactionOfStudent() throws Exception {
        Class<?> studentClass = Class.forName("example.domain.Student");

        Field[] fields = studentClass.getDeclaredFields();

        boolean hasName = false;
        boolean hasDept = false;

        for (Field field : fields){
            String fieldName = field.getName();
            if (fieldName == "name"){
                hasName = true;
            }
            else if(fieldName == "department"){
                hasDept = true;
            }
        }

        assertTrue(hasName);
        assertTrue(hasDept);
    }

    @Test
    public void testMappingStudentsByReflaction() throws Exception{
        List<Student> students = getStudent();
    }

    public List<Student> getStudent() throws Exception {
        Class<?> studentClass = Class.forName("example.domain.Student");

        Field[] fields = studentClass.getDeclaredFields();

        String connctionString = "jdbc:sqlite:university.sqlite3";
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(connctionString);
        Connection conn = dataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select * from students");
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int colCount = rsMetaData.getColumnCount();
        for ( int i =0 ; i< colCount ; i ++){
            for ( Field field : fields){
                if (rsMetaData.getColumnName() == field.getName())

            }

        }
        

        return null;

    }

}
