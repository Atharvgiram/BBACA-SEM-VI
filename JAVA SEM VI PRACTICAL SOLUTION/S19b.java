import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class S19b extends JFrame implements ActionListener {

    JTextField txtRno, txtName, txtPer;
    JButton btnShow;

    public S19b() {

        setTitle("First Record Display");
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Roll No:"));
        txtRno = new JTextField();
        add(txtRno);

        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Percentage:"));
        txtPer = new JTextField();
        add(txtPer);

        btnShow = new JButton("Show");
        btnShow.addActionListener(this);
        add(btnShow);

        setSize(350, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "Atharv",
                    "123"   // replace with your password
            );

            String sql = "SELECT * FROM STUD_INFO WHERE ROWNUM = 1";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtRno.setText(String.valueOf(rs.getInt(1)));
                txtName.setText(rs.getString(2));
                txtPer.setText(String.valueOf(rs.getDouble(3)));
            } else {
                JOptionPane.showMessageDialog(this, "No Record Found");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public static void main(String[] args) {
        new S19b();
    }
}
