import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class S15b extends JFrame implements ActionListener {

    JTextField txtRNo, txtName, txtPer, txtClass;
    JRadioButton rbMale, rbFemale;
    JButton btnSave;

    public S15b() {

        setTitle("Student Form");
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Roll No:"));
        txtRNo = new JTextField();
        add(txtRNo);

        add(new JLabel("Student Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Percentage:"));
        txtPer = new JTextField();
        add(txtPer);

        add(new JLabel("Gender:"));
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        JPanel p = new JPanel();
        p.add(rbMale);
        p.add(rbFemale);
        add(p);

        add(new JLabel("Class:"));
        txtClass = new JTextField();
        add(txtClass);

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        add(btnSave);

        setSize(400, 300);
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

            String gender = "";
            if (rbMale.isSelected())
                gender = "Male";
            else if (rbFemale.isSelected())
                gender = "Female";

            String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtRNo.getText()));
            ps.setString(2, txtName.getText());
            ps.setDouble(3, Double.parseDouble(txtPer.getText()));
            ps.setString(4, gender);
            ps.setString(5, txtClass.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Inserted Successfully");

            ps.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public static void main(String[] args) {
        new S15b();
    }
}
