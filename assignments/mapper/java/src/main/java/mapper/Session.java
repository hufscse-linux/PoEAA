package mapper;
import java.sql.*;

public class Session {
    public Session(Connection connection) throws Exception {
        this.connection = connection;
    }

    public Query createQuery(Class clazz) {
        Query query = new Query(connection, clazz);
        return query;
    }
    public void close() throws Exception {
        connection.close();
    }

    private Connection connection;
}
