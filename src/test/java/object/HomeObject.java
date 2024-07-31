package object;


import jdbcConnection.MySQLConnection;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HomeObject {

    public static int getEmployeeListNumberInDB() {
        ArrayList<String> listNumber = new ArrayList<>();
        String sql = """
                select * from automationtest.branch
                """;
        try {
            Connection conn = MySQLConnection.getMySQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listNumber.add(rs.getString("BRANCH_ID"));
                System.out.println(rs.getString("BRANCH_ID"));
            }
            System.out.println("SUM = " + listNumber.size());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listNumber.size();
    }

    static int countElementNumber = 8;

//    public static int getEmployeeListNumberInDB() throws SQLException {
//        String sql = """
//                select count(BRANCH_ID)
//                from automationtest.branch
//                """;
//            Connection conn = MySQLConnection.getMySQLConnection();
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()){
//                return rs.getInt(1);
//            }
//        return rs.getInt(1);
//    }

    public static void main(String[] args) {
        Assert.assertEquals(countElementNumber, getEmployeeListNumberInDB());
    }
}
