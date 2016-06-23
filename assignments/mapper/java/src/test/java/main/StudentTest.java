package main;
import main.Student;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StudentTest {

    @Test
    public void studentTest(){
        Student student = new Student(1, "SunKyu", "CSE");
    }

    @Test
    public void studentNameTest(){
        Student student = new Student(1 , "SunKyu", "CSE");
        assertEquals(student.getName(), "SunKyu");

    }

}
