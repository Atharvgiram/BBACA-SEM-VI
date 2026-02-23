import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class S23a extends JFrame {

    JTable table;
    DefaultTableModel model;

    public S23a() {

        setTitle("College Details");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        model.addColumn("CID");
        model.addColumn("CName");
        model.addColumn("Address");
        model.addColumn("Year");

        table = new JTable(model);
        add(new JScrollPane(table));

        loadData();

        setVisible(true);
    }

    public void loadData() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "Atharv",
                    "123"   // replace with your password
            );

            String sql = "SELECT * FROM COLLEGE_INFO";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("CID"),
                        rs.getString("CNAME"),
                        rs.getString("ADDRESS"),
                        rs.getInt("YEAR")
                });
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public static void main(String[] args) {
        new S23a();
    }
}
