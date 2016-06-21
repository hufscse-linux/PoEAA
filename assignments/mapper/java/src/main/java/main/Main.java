package main;
import java.sql.*;


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
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:universit.sqlite3");
        System.out.println("Opened database successfully");
        return connection;
    }

    public static ResultSet getStudentTable(Connection dbConnection){
        ResultSet resultSet = null;
        dbConnection.setAutoCommit(false);
        Statement statement = dbConnection.createStatement();

        

        return resultSet;
    }
}
