import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdraw, fastcash, ministatement, pinchange,balanceenquiry, exit;
    String pinnumber;

    public Transactions( String pinnumber) {
        this.pinnumber=pinnumber;
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("I_con/atmlogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

// creating level

JLabel text=new JLabel("please select your transaction ");
text.setBounds(190 ,200,700,35);
text.setFont(new Font("Raleway",Font.BOLD,20));
text.setForeground(Color.WHITE);
image.add(text);// image.add use koesi karon ami image ar opur ba text ta nite cai

//creating depoisit button
 deposit= new JButton("Deposit");
deposit.setBounds(160,315,130,30);
deposit.addActionListener(this);
image.add(deposit);

// creatin cash withdram button

 withdraw= new JButton("Cash Withdraw");
withdraw.setBounds(380,315,130,30);
withdraw.addActionListener(this);
image.add(withdraw);

// creatin cash firstcash button

 fastcash = new JButton("Fast Cash");
fastcash.setBounds(160,350,130,30);
fastcash.addActionListener(this);
image.add(fastcash);


 ministatement = new JButton("Mini Statement");
ministatement.setBounds(380,350,130,30);
ministatement.addActionListener(this);
image.add(ministatement);


pinchange = new JButton("Pin Change");
pinchange.setBounds(160,385,130,30);
pinchange.addActionListener(this);
image.add(pinchange);

 balanceenquiry = new JButton("Balance Enquiry");
balanceenquiry .setBounds(380,385,130,30);
balanceenquiry.addActionListener(this);
image.add(balanceenquiry );


 exit = new JButton("Exit");
exit .setBounds(380,420,130,30);
exit.addActionListener(this);
image.add(exit);


        setSize(900, 900);
        setLocation(300, 0);
       setUndecorated(true);// use kora hoyese fram ar opur a kono border bha cross jate ma thake exit use kore cross ar  kaj hobr
        setVisible(true);
    }


// over writing the function


public void actionPerformed(ActionEvent ae){
if(ae.getSource()==exit){
    System.exit(0);
}else if(ae.getSource()== deposit){
    setVisible(false);
    new Deposit(pinnumber).setVisible(true);
}else if(ae.getSource()== withdraw){
    setVisible(false);
    new Withdrawl(pinnumber).setVisible(true);
}else if(ae.getSource()==fastcash){
    setVisible(false);
    new FastCash(pinnumber).setVisible(true);
}
else if(ae.getSource()==pinchange){
    setVisible(false);
    new PinChange(pinnumber).setVisible(true);
}else if(ae.getSource()==balanceenquiry){
    setVisible(false);
    new BalanceEnquiry(pinnumber).setVisible(true);
}else if(ae.getSource()==ministatement){
    //setVisible(false);
    new MiniStatement(pinnumber).setVisible(true);
}

}

    public static void main(String[] arg) {
        new Transactions("");
    }
}
