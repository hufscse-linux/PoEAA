package example.reflection;

import java.lang.reflect.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MakeStringAndPrintToStdoutTest {
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
    }
}
