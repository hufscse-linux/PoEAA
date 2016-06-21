import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;
import main.Main;
import java.sql.*;

import org.junit.Test;
import org.junit.Before;

public class MainTest {

    private Connection dbconnection;

    @Before
    public void setUp(){
        this.dbconnection = Main.getDBConnection();
    }

    @Test
    public void getDBConnectionTest(){
        try{
            Connection connection = Main.getDBConnection();
            assertNotNull(connection);
        } catch (Exception e){

        }
    }

    @Test 
    public void getStudentTableTest(){
        try{
            ResultSet result = Main.getStudentTable(this.dbconnection);
            assertNotNull(result);
        } catch (Exception e){

        }
    }


}
