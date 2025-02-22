package jdbcTest;

import jdbcConnection.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTest {
    static Connection conn;

    public static void main(String[] args) throws SQLException {
        conn = MySQLConnection.getMySQLConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();

        String insertValue = """
                insert into branch (ADDRESS, CITY, NAME ,STATE, ZIP_CODE)
                values ('Doi Can', 'Ha Noi', 'Huy Anh 1', 'NEW', '1000')
                """;
        statement.executeUpdate(insertValue);

        String sql = "select * from automationtest.branch";
//        String sql = "select Emp.EMP_ID, Emp.FIRST_NAME, Emp.LAST_NAME, Emp.DEPT_ID from employee Emp;";

        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
//            int empld = rs.getInt(1);
//            String empFirstName = rs.getString(2);
//            String empLastName = rs.getString("Last_Name");
//            int deptID = rs.getInt("Dept_Id");
//
//            System.out.println("===============");
//            System.out.println("Emp Id: " + empld);
//            System.out.println("Emp Firstname: " + empFirstName);
//            System.out.println("Emp Lastname: " + empLastName);
//            System.out.println("Department ID: " + deptID);

            String branchID = rs.getString("BRANCH_ID");
            String address = rs.getString("ADDRESS");
            String city = rs.getString("CITY");
            String name = rs.getString("NAME");

            System.out.println("--------------------");
            System.out.println("Branch ID: " + branchID);
            System.out.println("Address: " + address);
            System.out.println("City: " + city);
            System.out.println("Name: " + name);
        }
        conn.close();
        System.out.println("======= Closed connection =========");
    }
}