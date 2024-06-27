package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLJDTSConnection {
    public static Connection getSQLServerConnection(){
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "automation";
        String userName = "sa";
        String password = "huy123456.";
        return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
    }
    private static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password){
        Connection conn = null;
        try {
            // Khai báo class Driver cho SQL Server
            // Việc này cần thiết với Java 5
            // Java 6 tự động tìm kiếm Driver thích hợp - ko bắt buộc dòng này
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // Cấu trúc URL Connection dành cho SQL Server
            // Ví dụ: jdbc:jtds:sqlserver://localhost:1433/automation;instance=SQLEXPRESS
            String connectionURL = "jdbc:jtds:sqlserver://"+hostName+":1433/"+database+";instance="+sqlInstanceName;
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
