import java.sql.*;
import java.util.Scanner;

public class S11b {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle XE
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "Atharv",
                    "123"   // replace with your password
            );

            // Input dates
            System.out.print("Enter Start Date (YYYY-MM-DD): ");
            String startDate = sc.nextLine();

            System.out.print("Enter End Date (YYYY-MM-DD): ");
            String endDate = sc.nextLine();

            // SQL Query
            String query = "SELECT PID, PNAME, QTY, RATE, AMOUNT, SALE_DATE " +
                           "FROM SALES " +
                           "WHERE SALE_DATE BETWEEN TO_DATE(?, 'YYYY-MM-DD') " +
                           "AND TO_DATE(?, 'YYYY-MM-DD')";

            ps = con.prepareStatement(query);
            ps.setString(1, startDate);
            ps.setString(2, endDate);

            rs = ps.executeQuery();

            System.out.println("\nSales Details Between Dates:");
            System.out.println("---------------------------------------------------------------");
            System.out.printf("%-5s %-15s %-5s %-8s %-10s %-12s\n",
                    "PID", "PName", "Qty", "Rate", "Amount", "Sale Date");
            System.out.println("---------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-15s %-5d %-8.2f %-10.2f %-12s\n",
                        rs.getInt("PID"),
                        rs.getString("PNAME"),
                        rs.getInt("QTY"),
                        rs.getDouble("RATE"),
                        rs.getDouble("AMOUNT"),
                        rs.getDate("SALE_DATE"));
            }

            System.out.println("---------------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
