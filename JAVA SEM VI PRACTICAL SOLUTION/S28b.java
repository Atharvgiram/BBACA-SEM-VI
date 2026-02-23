import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class S28b extends JFrame implements ActionListener {

    JComboBox<String> combo;
    JTable table;
    Vector<Vector<Object>> data;
    Vector<String> columns;

    public S28b() {

        setLayout(null);

        JLabel lbl = new JLabel("Select Emp No");
        lbl.setBounds(50, 30, 100, 30);
        add(lbl);

        combo = new JComboBox<>();
        combo.addItem("101");
        combo.addItem("102");
        combo.addItem("103");
        combo.setBounds(160, 30, 150, 30);
        add(combo);

        columns = new Vector<>();
        columns.add("ENo");
        columns.add("EName");
        columns.add("Salary");

        data = new Vector<>();

        table = new JTable(data, columns);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 80, 400, 120);
        add(sp);

        combo.addActionListener(this);

        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        data.clear();   // clear previous data

        String eno = (String) combo.getSelectedItem();

        Vector<Object> row = new Vector<>();

        if(eno.equals("101")) {
            row.add("101");
            row.add("Atharv Giram");
            row.add(100000);
        }
        else if(eno.equals("102")) {
            row.add("102");
            row.add("Rahul");
            row.add(60000);
        }
        else if(eno.equals("103")) {
            row.add("103");
            row.add("Sneha");
            row.add(55000);
        }

        data.add(row);
        table.updateUI();   // refresh table
    }

    public static void main(String[] args) {
        new S28b();
    }
}
