import java.sql.*;

public class S20a {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide Employee ID as command line argument.");
            return;
        }

        int eno = Integer.parseInt(args[0]);

        try {
            // Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "Atharv",
                    "123"   // replace with your password
            );

            String sql = "DELETE FROM EMPLOYEE WHERE ENO = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, eno);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Record Deleted Successfully.");
            } else {
                System.out.println("Employee ID Not Found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
