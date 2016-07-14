package mapper;
import java.sql.*;
import javax.sql.*;

public class SessionFactory {
    public SessionFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Session createSession() throws Exception {
        return new Session(dataSource.getConnection());
    }
    private DataSource dataSource;
}
