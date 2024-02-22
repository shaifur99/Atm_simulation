import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    public FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("I_con/atmlogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(190, 200, 700, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("tk 500");
        deposit.setBounds(160, 315, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("tk 1000");
        withdraw.setBounds(380, 315, 130, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("tk 5000");
        fastcash.setBounds(160, 350, 130, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("tk 10000");
        ministatement.setBounds(380, 350, 130, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("tk 15000");
        pinchange.setBounds(160, 385, 130, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("tk 20000");
        balanceenquiry.setBounds(380, 385, 130, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Back");
        exit.setBounds(380, 420, 130, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if ((rs.getString("type").equals("Deposit"))) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values ('" + pinnumber + "','" + date + "','withdraw','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "TK " + amount + " Debited successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] arg) {
        new FastCash("");
    }
}
