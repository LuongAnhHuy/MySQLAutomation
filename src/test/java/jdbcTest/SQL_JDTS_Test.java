package jdbcTest;

import jdbcConnection.SQLJDTSConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL_JDTS_Test {
    static Connection conn;

    public static void main(String[] args) throws SQLException {
        // Lấy ra đối tượng Connection kết nối vào database.
        conn = SQLJDTSConnection.getSQLServerConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();
        // Insert data to table Branch
        String insertValue = """
                INSERT INTO [dbo].[BRANCH] ([ADDRESS],[CITY],[NAME],[STATE],[ZIP_CODE]) 
                VALUES ('270 Doi Can','Ha Noi','Huy','NEW','10000')
                """;
        int rowCount = statement.executeUpdate(insertValue);
        System.out.println("Row Count" + rowCount);

        String sql = """
                SELECT * 
                FROM [automation].[dbo].[BRANCH];
                """;

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về=
        while (rs.next()) {
            // Di chuyển con trỏ xuống bản ghi kế tiếp.
//            int empID = rs.getInt(1);
//            String empFirstName = rs.getString(2);
//            String empLastName = rs.getString("LAST_NAME");
//            int deptID = rs.getInt("Dept_Id");

            int branchID = rs.getInt(1);
            String address = rs.getString("ADDRESS");
            String city = rs.getString("CITY");
            String name = rs.getString("NAME");

            System.out.println("--------------------");
            System.out.println("Branch ID: " + branchID);
            System.out.println("Address: " + address);
            System.out.println("City: " + city);
            System.out.println("Name: " + name);


//            System.out.println("--------------------");
//            System.out.println("Emp Id:" + empID);
//            System.out.println("Emp Firstname:" + empFirstName);
//            System.out.println("Emp Lastname:" + empLastName);
//            System.out.println("Department ID:" + deptID);
        }
        // Đóng kết nối
        conn.close();
        System.out.println("---------- Closed connection ----------");
    }

}
