import java.sql.*;
import java.util.Scanner;

public class S16b {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement psInsert = null;
        PreparedStatement psSelect = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "Atharv",
                    "123"   // replace with your password
            );

            // Insert 5 Records
            String insertSQL = "INSERT INTO STUD_MARKS VALUES (?, ?, ?)";
            psInsert = con.prepareStatement(insertSQL);

            for (int i = 1; i <= 5; i++) {

                System.out.println("\nEnter details for Student " + i);

                System.out.print("Roll No: ");
                int rno = sc.nextInt();
                sc.nextLine();  // clear buffer

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Percentage: ");
                double per = sc.nextDouble();

                psInsert.setInt(1, rno);
                psInsert.setString(2, name);
                psInsert.setDouble(3, per);

                psInsert.executeUpdate();
                System.out.println("Record Inserted Successfully.");
            }

            // Fetch Highest Percentage
            String selectSQL = 
                "SELECT * FROM STUD_MARKS WHERE PER = (SELECT MAX(PER) FROM STUD_MARKS)";

            psSelect = con.prepareStatement(selectSQL);
            rs = psSelect.executeQuery();

            System.out.println("\nStudent with Highest Percentage:");
            System.out.println("---------------------------------");

            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("RNO"));
                System.out.println("Name: " + rs.getString("SNAME"));
                System.out.println("Percentage: " + rs.getDouble("PER"));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (psInsert != null) psInsert.close();
                if (psSelect != null) psSelect.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
