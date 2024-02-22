import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField amount;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("I_con/atmlogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        text.setBounds(168, 220, 400, 20);
        image.add(text);

         amount = new JTextField();
         amount.setBounds(170, 250, 320, 25);
         amount.setFont(new Font("Arial", Font.BOLD,20 ));
         image.add(amount);


         withdraw = new JButton("Withdraw");
         withdraw.setBackground(Color.white);
         withdraw.setForeground(Color.black);
         withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
         withdraw.setBounds(340, 370, 150, 30);
         withdraw.addActionListener(this);
        image.add(withdraw);


         back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(340, 415, 150, 30);
        back.addActionListener(this);
        image.add( back);


        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){


        if(ae.getSource()== withdraw ){

String number =amount.getText();
Date date = new Date();


if(number.equals("")){
    JOptionPane.showMessageDialog(null, "please the amount you want to  withdraw");

}else{
    try{
        Conn conn=new Conn();
        String query ="insert into bank values ('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
    conn.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "tk " +number+ "deposit successfully");
    setVisible(false);
    new Transactions(pinnumber).setVisible(true);
    }catch(Exception e){

        System.out.println(e);

    }
}
  }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
