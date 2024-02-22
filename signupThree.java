import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel; // Changed from cancle to cancel
    String formno, cardnumber, pinnumber;

    signupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details ");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account type ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 200, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account ");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        // To use this, any button can be selected
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number(16-digit):");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 300, 300, 30);
        add(card);

        JLabel Number = new JLabel("XXXX-XXXX-XXXX-4148");
        Number.setFont(new Font("Raleway", Font.BOLD, 22));
        Number.setBounds(360, 300, 300, 30);
        add(Number);

        JLabel pin = new JLabel("PIN No (4-digit) : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 350, 200, 30);
        add(pin);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pNumber.setBounds(360, 350, 300, 30);
        add(pNumber);

        JLabel services = new JLabel(" Services Required : ");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 400, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD ");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("raleway", Font.BOLD, 14));
        c1.setBounds(100, 450, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("raleway", Font.BOLD, 14));
        c2.setBounds(400, 450, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking ");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("raleway", Font.BOLD, 14));
        c3.setBounds(100, 500, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & Sms Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("raleway", Font.BOLD, 14));
        c4.setBounds(400, 500, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book ");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("raleway", Font.BOLD, 14));
        c5.setBounds(100, 550, 200, 30);
        add(c5);

        c6 = new JCheckBox(" E-statement ");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("raleway", Font.BOLD, 14));
        c6.setBounds(400, 550, 200, 30);
        add(c6);

        c7 = new JCheckBox(" I hereby declare that the above entered details are correct to the best of my knowledge ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("raleway", Font.BOLD, 10));
        c7.setBounds(100, 600, 500, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(300, 650, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(450, 650, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    // Function override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            Random random = new Random();
            cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = null;
            if (c1.isSelected()) {
                facility += "ATM card";
            } else if (c2.isSelected()) {
                facility += "Internet Banking";
            } else if (c3.isSelected()) {
                facility += "Mobile Banking";
            } else if (c4.isSelected()) {
                facility += "Email & Sms Alerts";
            } else if (c5.isSelected()) {
                facility += "Cheque Book";
            } else if (c6.isSelected()) {
                facility += "E-statement ";
            } else if (c7.isSelected()) {
                facility += "Declaration";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','" + accountType + "','"+ cardnumber + "','" + pinnumber + "','" + facility + "')";

                   String query2 = "insert into login values('" + formno + "','"+ cardnumber + "','" + pinnumber + "')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null," Card Number :"+ cardnumber +"\n pin :"+pinnumber );

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {

            setVisible(false);
             new Login().setVisible(true);
            
        }
    }

    public static void main(String arg[]) {
        new signupThree("");
    }
}
