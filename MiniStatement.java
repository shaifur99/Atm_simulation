import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

    public MiniStatement(String pinnumber) {
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel back = new JLabel("Bangladesh Bank");
        back.setBounds(150, 20, 100, 20);
        add(back);

        JLabel card = new JLabel("");
        card.setBounds(20, 80, 300, 20);
        add(card);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("cardnumber").substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            StringBuilder miniText = new StringBuilder(mini.getText());
            while (rs.next()) {
                miniText.append("<html>").append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount") + "<br><br><html>");
            }
            mini.setText(miniText.toString());

        } catch (Exception e) {
            System.out.println(e);
        }
        mini.setBounds(20, 140, 400, 200);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
