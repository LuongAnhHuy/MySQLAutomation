package jdbcTest;

import jdbcConnection.SQLServerJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnection {
    public static void main(String[] args) throws SQLException {
        System.out.println("Get connection... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = SQLServerJDBC.getSQLServerConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();

        String sql = "SELECT EMP_ID, FIRST_NAME, LAST_NAME, DEPT_ID FROM [automation].[dbo].[EMPLOYEE];";

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về
        while (rs.next()) {
            // Di chuyển con trỏ xuống bản ghi kế tiếp.
            int empID = rs.getInt(1);
            String empFirstName = rs.getString(1);
            String empLastName = rs.getString("LAST_NAME");
            int deptID = rs.getInt("Dept_Id");

            System.out.println("--------------------");
            System.out.println("Emp Id:" + empID);
            System.out.println("Emp Firstname:" + empFirstName);
            System.out.println("Emp Lastname:" + empLastName);
            System.out.println("Department ID:" + deptID);
        }
        // Đóng kết nối
        conn.close();
        System.out.println("---------- Closed connection ----------");
    }
}
