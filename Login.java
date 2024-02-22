import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame  implements ActionListener {
    JButton  login,Clear,Signup;// global decleartion for excessing any where
    JTextField Cardtexfiled;
    JPasswordField Pintexfiled;
    Login(){

        setTitle("Automated Tiller Machine"); // set for fram titelname

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("I_con/banklogo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);// for image size get small 
        ImageIcon i3=new ImageIcon(i2);//image we cannot use inside image icon that why convart image from image icon
        JLabel label =  new JLabel(i3);
        label.setBounds(70, 10,100, 100);// add korte use kora hoise
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM ");// fram a text add korte 
        text.setFont(new Font("Osward",Font.BOLD,38));// change defoult font size
        text.setBounds(200,40,400,40);
        add(text);

        JLabel CardN0 = new JLabel("CARD NO : ");// fram a text add korte 
        CardN0.setFont(new Font("Relaway",Font.BOLD,25));// change defoult font size
        CardN0.setBounds(120,150,200,40);
        add(CardN0);

       Cardtexfiled=new JTextField(); // creating text filed
        Cardtexfiled.setBounds(300,150,230,35);
        Cardtexfiled.setFont(new Font("Arial",Font.BOLD,14));
        add(Cardtexfiled);

        JLabel pin = new JLabel("PIN : ");// fram a text add korte 
        pin.setFont(new Font("Relaway",Font.BOLD,25));// change defoult font size
        pin.setBounds(120,220,400,35);
        add(pin);

        Pintexfiled=new JPasswordField();//creating pi filed
        Pintexfiled.setBounds(300,220,230,35);
        Pintexfiled.setFont(new Font("Arial",Font.BOLD,14));
        add(Pintexfiled);
   
        login=new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);// use fore when press button we get informatin
        add(login);


         Clear=new JButton("Clear");
        Clear.setBounds(430,300,100,30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.white);
        Clear.addActionListener(this);// use fore when press button we get informatin
        add(Clear);


         Signup=new JButton("Sign Up");
        Signup.setBounds(300,350,230,30);
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.white);
        Signup.addActionListener(this);// use fore when press button we get informatin
        add(Signup);


        getContentPane().setBackground(Color.white);//use for background color change

        setSize(800,400);// for creating fram and daimention
        setVisible(true);//for fram showing
        setLocation(350,200);//using for fram open middel not properly but someting like  that
    }

    // use for implements ActionListener after lo login
    public void actionPerformed(ActionEvent ae){
if(ae.getSource() == Clear){
    Cardtexfiled.setText("");
    Pintexfiled.setText("");

}else if (ae.getSource() == login) {
    Conn conn = new Conn();
    String cardnumber = Cardtexfiled.getText();
    String pinnumber = Pintexfiled.getText();
    String query = "select * from login where cardnumber ='" + cardnumber + "' and pin = '" + pinnumber + "'";
    try (ResultSet rs = conn.s.executeQuery(query)) {
        if (rs.next()) {
            setVisible(false);
            new Transactions("pinnumber").setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect card Number or Pin");
        }
    } catch (Exception e) {
        e.printStackTrace();  // Print the stack trace for debugging purposes
    }
}else if(ae.getSource() ==   Signup){
setVisible(false);
new SignUpone().setVisible(true);
    
}
    }
    public static void main(String[] args) throws Exception {
        new Login();
    }
}
