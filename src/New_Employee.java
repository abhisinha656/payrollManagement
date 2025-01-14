import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;

public class New_Employee extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Choice c1;

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidMobileNo(String str) {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }

    New_Employee() {
        super("New Employee");
        setSize(600, 650);
        setLocation(200, 100);
        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(new GridLayout(8, 2, 10, 40));

        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        p1.add(l1);
        p1.add(t1);

        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("other");

        l2 = new JLabel("Gender");
        p1.add(l2);
        p1.add(c1);

        l3 = new JLabel("Address");
        t3 = new JTextField(15);
        p1.add(l3);
        p1.add(t3);

        l4 = new JLabel("State");
        t4 = new JTextField(15);
        p1.add(l4);
        p1.add(t4);

        l5 = new JLabel("City");
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);

        l6 = new JLabel("Email");
        t6 = new JTextField(15);
        p1.add(l6);
        p1.add(t6);

        l7 = new JLabel("Phone");
        t7 = new JTextField(15);
        p1.add(l7);
        p1.add(t7);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);

        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.png"))), "West");
        add(p1, "Center");

        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();
        if (n.equals("") || a.equals("") || s.equals("") || c.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all details...");
        } else if (!isValidMobileNo(p)) {
            JOptionPane.showMessageDialog(null, "Phone No Invalid....");
        } else if (!isValidEmail(e)) {
            JOptionPane.showMessageDialog(null, "Email Invalid....");
        } else {
            String qry = "insert into employee values(null,'" + n + "','" + g + "','" + a + "','" + s + "','" + c
                    + "','" + e + "','" + p + "')";
            try {
                Conn c1 = new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Employee Created successfully");
                this.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new New_Employee();
    }

}
