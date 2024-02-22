import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpone extends JFrame implements ActionListener {
    long random;
    JTextField nametexfiled, fnametexfiled, emailtexfiled, citytexfiled, addresstexfiled, statetexfiled, pintexfiled;
    JDateChooser dobChooser;
    JButton next;
    JRadioButton male, female, married, Unmarried, other;

    SignUpone() {
        setLayout(null);

        Random ran = new Random();

        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel fromno = new JLabel("Application From No :" + random);
        fromno.setFont(new Font("Raleway", Font.BOLD, 38));
        fromno.setBounds(140, 20, 600, 40);
        add(fromno);

        JLabel PersonalDetails = new JLabel("page 1: personal details ");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(290, 80, 400, 30);
        add(PersonalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nametexfiled = new JTextField();
        nametexfiled.setBounds(300, 140, 400, 30);
        nametexfiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(nametexfiled);

        JLabel fname = new JLabel("Father Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnametexfiled = new JTextField();
        fnametexfiled.setBounds(300, 190, 400, 30);
        fnametexfiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(fnametexfiled);

        JLabel Dob = new JLabel("Date of Birth :");
        Dob.setFont(new Font("Raleway", Font.BOLD, 22));
        Dob.setBounds(100, 240, 200, 30);
        add(Dob);

        dobChooser = new JDateChooser();
        dobChooser.setBounds(300, 240, 400, 30);
        dobChooser.setFont(new Font("Arial", Font.BOLD, 14));
        add(dobChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(female);
        gendergroup.add(male);

        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailtexfiled = new JTextField();
        emailtexfiled.setBounds(300, 340, 400, 30);
        emailtexfiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(emailtexfiled);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("married");
        married.setBounds(300, 390, 100, 30);
        add(married);

        Unmarried = new JRadioButton("Unmarried");
        Unmarried.setBounds(450, 390, 100, 30);
        add(Unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        add(other);

        ButtonGroup MaritalGroup = new ButtonGroup();
        MaritalGroup.add(Unmarried);
        MaritalGroup.add(married);
        MaritalGroup.add(other);

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addresstexfiled = new JTextField();
        addresstexfiled.setBounds(300, 440, 400, 30);
        addresstexfiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(addresstexfiled);

        JLabel City = new JLabel("City :");
        City.setFont(new Font("Raleway", Font.BOLD, 22));
        City.setBounds(100, 490, 200, 30);
        add(City);

        citytexfiled = new JTextField();
        citytexfiled.setBounds(300, 490, 400, 30);
        citytexfiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(citytexfiled);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        statetexfiled = new JTextField();
        statetexfiled.setBounds(300, 540, 400, 30);
        statetexfiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(statetexfiled);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pintexfiled = new JTextField();
        pintexfiled.setBounds(300, 590, 400, 30);
        pintexfiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintexfiled);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(600, 640, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String fromno = "" + random;
        String name = nametexfiled.getText();
        String fname = fnametexfiled.getText();
        String dob = ((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailtexfiled.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (Unmarried.isSelected()) {
            marital = "UnMarried";
        } else if (other.isSelected()) {
            marital = "other";
        }

        String address = addresstexfiled.getText();
        String City = citytexfiled.getText();
        String state = statetexfiled.getText();
        String pin = pintexfiled.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c=new Conn();
                String query="insert into signup values('"+fromno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+City+"','"+pin+"','"+state+"')";
             c.s.executeUpdate(query);

             setVisible(false);
new SignupTwo(fromno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpone();//constractter
    }
}

