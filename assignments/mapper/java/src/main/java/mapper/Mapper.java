package mapper;
import main.Student;
import java.sql.*;

public interface Mapper<TypeClass> {
    public TypeClass map(ResultSet rs) throws Exception;
}
