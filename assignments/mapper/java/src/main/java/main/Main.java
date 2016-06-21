package main;
import java.sql.*;
import java.util.Arrays;


public class Main{

    public static void main(String[] args){
        System.out.println("main package main");
        try{
            Connection dbConnection = getDBConnection();
            ResultSet result = getStudentTable(dbConnection);
        } catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static Connection getDBConnection(){
        Connection connection = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:universit.sqlite3");
            System.out.println("Opened database successfully");
        } catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return connection;
    }

    public static ResultSet getStudentTable(Connection dbConnection){
        try{
            dbConnection.setAutoCommit(false);
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name, department from students");

        } catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return resultSet;
    }
}
