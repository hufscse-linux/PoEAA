package mapper;
import java.sql.*;
import java.util.*;
import java.util.function.*;

public class Query{
    public Query(Connection connection, Class clazz){
        this.connection = connection;
        this.clazz = clazz;
    }
    public Query columns(List<String> columns) {
        this.columns = columns; 
        return this;
    }

    public Query table(String name) {
        this.tableName = name;
        return this; 
    }

    public Query where(List<String> conditions) {
        this.conditions = conditions;
        return this;
    }

    public Query mapper(Mapper mapper) {
        this.mapper = mapper;
        return this;
    }

    private String buildSql() {
        StringBuilder builder = new StringBuilder();
        builder.append("select ");
        builder.append(String.join(",", columns));
        builder.append(" from ");
        builder.append(tableName);
        builder.append(" where ");
        builder.append(String.join(" and ", conditions));
        return builder.toString();
    }

    public List execute() throws Exception{
        String sql = buildSql();
        Statement statement = null;
        ResultSet rs = null;
        List results = new ArrayList();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            if(null == mapper) throw new Exception("mapper is required");
            while(rs.next()) {
                Object o = mapper.map(rs);
                results.add(o);
            }
        } finally {
            if(null == rs) rs.close();
            if(null == statement) statement.close();
        }
        return results;
    };
    private Class clazz;
    private String tableName;
    private List<String> columns;
    private List<String> conditions;
    private Mapper mapper;
    private Connection connection;

}
