package connector;

import javax.sql.DataSource;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnection {
    public DataSource dataSource;

    public DatabaseConnection() {
        try {
            dataSource = getDataSource();
        } catch (Exception err) {
        }
    }

    private DataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("127.0.0.1");
        ds.setPort(33061);
        ds.setDatabaseName("student_result_management_system");
        ds.setUser("root");
        ds.setPassword("password");
        ds.setUseSSL(false);
        ds.setAllowPublicKeyRetrieval(true);

        return ds;
    }
}