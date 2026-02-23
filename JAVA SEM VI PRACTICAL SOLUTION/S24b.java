import java.sql.*;
import java.util.Scanner;

public class S24b {

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "Atharv",
                    "123"   // replace with your password
            );

            int ch;

            do {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Search");
                System.out.println("5. Display");
                System.out.println("6. Exit");
                System.out.print("Enter Choice: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1: insert(); break;
                    case 2: update(); break;
                    case 3: delete(); break;
                    case 4: search(); break;
                    case 5: display(); break;
                    case 6: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid Choice");
                }

            } while (ch != 6);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void insert() throws Exception {

        System.out.print("Enter ENo: ");
        int eno = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble(); sc.nextLine();

        System.out.print("Enter Designation: ");
        String desg = sc.nextLine();

        String sql = "INSERT INTO EMP_INFO VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, eno);
        ps.setString(2, name);
        ps.setDouble(3, sal);
        ps.setString(4, desg);

        ps.executeUpdate();
        System.out.println("Record Inserted.");
        ps.close();
    }

    static void update() throws Exception {

        System.out.print("Enter ENo to Update: ");
        int eno = sc.nextInt(); sc.nextLine();

        System.out.print("Enter New Salary: ");
        double sal = sc.nextDouble(); sc.nextLine();

        System.out.print("Enter New Designation: ");
        String desg = sc.nextLine();

        String sql = "UPDATE EMP_INFO SET SALARY=?, DESG=? WHERE ENO=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, sal);
        ps.setString(2, desg);
        ps.setInt(3, eno);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Record Updated.");
        else
            System.out.println("Employee Not Found.");

        ps.close();
    }

    static void delete() throws Exception {

        System.out.print("Enter ENo to Delete: ");
        int eno = sc.nextInt();

        String sql = "DELETE FROM EMP_INFO WHERE ENO=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, eno);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Record Deleted.");
        else
            System.out.println("Employee Not Found.");

        ps.close();
    }

    static void search() throws Exception {

        System.out.print("Enter ENo to Search: ");
        int eno = sc.nextInt();

        String sql = "SELECT * FROM EMP_INFO WHERE ENO=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, eno);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("ENo: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Salary: " + rs.getDouble(3));
            System.out.println("Designation: " + rs.getString(4));
        } else {
            System.out.println("Employee Not Found.");
        }

        rs.close();
        ps.close();
    }

    static void display() throws Exception {

        String sql = "SELECT * FROM EMP_INFO";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Employee Records ---");

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDouble(3) + " | " +
                    rs.getString(4)
            );
        }

        rs.close();
        ps.close();
    }
}
