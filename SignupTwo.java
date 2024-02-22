import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField  pan, aedther;
    JDateChooser dobChooser;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category, income,  eduction,  occupation ;
    String formno;

    SignupTwo(String fromno) {
        this.formno=fromno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FROM PAGE -2");
        JLabel additionalDetails = new JLabel("page 2: Addtional details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[]={"Muslim","Hindu","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setFont(new Font("Arial", Font.BOLD, 14));
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category :");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcategory[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setFont(new Font("Arial", Font.BOLD, 14));
        category.setBackground(Color.WHITE);
        add(category);

        JLabel Dob = new JLabel("Income :");
        Dob.setFont(new Font("Raleway", Font.BOLD, 22));
        Dob.setBounds(100, 240, 200, 30);
        add(Dob);

        String incomecategory[]={"null","<1,50,000","2,50,000","5,00,000","upto-10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setFont(new Font("Arial", Font.BOLD, 14));
        income.setBackground(Color.WHITE);
        add(income);

        dobChooser = new JDateChooser();
        dobChooser.setBounds(300, 240, 400, 30);
        dobChooser.setFont(new Font("Arial", Font.BOLD, 14));
        add(dobChooser);

        JLabel gender = new JLabel("Eductional");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String EducationValues[]={"Non-Graduation","Gradution","Post-Gradution","Doctrate","Other"};
        eduction = new JComboBox(EducationValues);
        eduction.setBounds(300, 315, 400, 30);
        eduction.setFont(new Font("Arial", Font.BOLD, 14));
        eduction.setBackground(Color.WHITE);
        add(eduction);


        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String occupationValues[]={"Salaried","Saif-employed","Bussiness","Student","Retired"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setFont(new Font("Arial", Font.BOLD, 14));
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("Pan No :");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setBounds(300, 440, 400, 30);
        pan.setFont(new Font("Arial", Font.BOLD, 14));
        add(pan);

        JLabel Aedther = new JLabel("Aedher Number :");
        Aedther.setFont(new Font("Raleway", Font.BOLD, 22));
        Aedther.setBounds(100, 490, 200, 30);
        add(Aedther);

        aedther = new JTextField();
        aedther.setBounds(300, 490, 400, 30);
        aedther.setFont(new Font("Arial", Font.BOLD, 14));
        add(  aedther);

        JLabel state = new JLabel("Seniour CitiZen:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalgGroup=new ButtonGroup();
        maritalgGroup.add(syes);
        maritalgGroup.add(sno);


        JLabel pincode = new JLabel("Exisiting Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        eyes = new JRadioButton("yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
 
        ButtonGroup emaritalgGroup=new ButtonGroup();
        emaritalgGroup.add(eyes);
        emaritalgGroup.add(eno);

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
        String sreligion=(String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation=(String)eduction.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;

        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }

        String exisitingaccount = null;
        if (eyes.isSelected()) {
           exisitingaccount="Yes";
        } else if (eno.isSelected()) {
           exisitingaccount="No";
        }


        String span = pan.getText();
        String saadher= aedther.getText();


        try {
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadher+"','"+seniorcitizen+"','"+exisitingaccount+"')";//data insert query
                c.s.executeUpdate(query);

             //singup3 object
             setVisible(false);
             new signupThree(formno).setVisible(true);
            } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");//empty string
    }
}

