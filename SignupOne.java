
import java.util.*;
import javax.swing.*;
import java.awt.*;

import java.sql.Statement;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class SignupOne extends JFrame implements ActionListener{
 long random;
JTextField nameTextField, fnameTextField , dobTextField , emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
JButton next;
JRadioButton male, female , unmarried, married;
JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);

        Random ran = new Random();
         random= (Math.abs((ran.nextLong()% 9000L)+1000L));

     JLabel formno= new JLabel("APPLICATION FORM NO. "+random);
     formno.setFont(new Font("Raleway", Font.BOLD,38));
     formno.setBounds(140, 20, 600, 40);
     add(formno);

     JLabel personDetails = new JLabel("Page 1: Personal Details");
     personDetails.setFont(new Font("Raleway", Font.BOLD,22));
     personDetails.setBounds(290, 80, 400, 30);
     add(personDetails);

     
     JLabel name = new JLabel("Name: ");
     name.setFont(new Font("Raleway", Font.BOLD,22));
     name.setBounds(100, 140, 100, 30);
     add(name);
     
     nameTextField = new JTextField();
     nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
    nameTextField.setBounds(350,140,400,30);
    add(nameTextField);
     
     JLabel fname = new JLabel("Father's Name: ");
     fname.setFont(new Font("Raleway", Font.BOLD,22));
     fname.setBounds(100, 190, 200, 30);
     add(fname);

    fnameTextField = new JTextField();
     fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
    fnameTextField.setBounds(350,190,400,30);
    add(fnameTextField);
     
      
     
     JLabel dob = new JLabel("Date of Birth");
     dob.setFont(new Font("Raleway", Font.BOLD,22));
     dob.setBounds(100, 240, 200, 30);
     add(dob);

   /*  JTextField dobTextField = new JTextField();
     dobTextField.setFont(new Font("Raleway", Font.BOLD,14));
     dobTextField.setBounds(350,240,400,30);
    add(dobTextField);*/

     dateChooser = new JDateChooser();
    dateChooser.setBounds(350,240,200,30);
    add(dateChooser);


     JLabel gender = new JLabel("Gender: ");
     gender.setFont(new Font("Raleway", Font.BOLD,22));
     gender.setBounds(100, 290, 140, 30);
     add(gender);

     male = new JRadioButton("Male");
     male.setBounds(350, 290, 60, 30);
     add(male);
     female = new JRadioButton("Female");
     female.setBounds(500, 290, 100, 30);
     add(female);

     ButtonGroup gendergroup = new ButtonGroup();
     gendergroup.add(male);
     gendergroup.add(female);

     JLabel email = new JLabel("Email Address: ");
     email .setFont(new Font("Raleway", Font.BOLD,22));
     email .setBounds(100, 340, 200, 30);
     add( email );

    emailTextField = new JTextField();
     emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
     emailTextField.setBounds(350,340,400,30);
    add(emailTextField);

     JLabel marital = new JLabel("Marital Status: ");
     marital .setFont(new Font("Raleway", Font.BOLD,22));
     marital.setBounds(100, 390, 200, 30);
     add( marital);
     
      unmarried = new JRadioButton("Unmarried");
     unmarried.setBounds(350, 390, 100, 30);
     add(unmarried);
      married = new JRadioButton("Maried");
     married.setBounds(500, 390, 100, 30);
     add(married);

     ButtonGroup maritalgroup = new ButtonGroup();
     maritalgroup.add(unmarried);
     maritalgroup.add(married);


     JLabel address = new JLabel("Address: ");
     address.setFont(new Font("Raleway", Font.BOLD,22));
     address.setBounds(100, 440, 200, 30);
     add( address);

     addressTextField = new JTextField();
     addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
     addressTextField.setBounds(350,440,400,30);
    add(addressTextField);

     JLabel city = new JLabel("City: ");
     city.setFont(new Font("Raleway", Font.BOLD,22));
     city.setBounds(100, 490, 200, 30);
     add( city);

     cityTextField = new JTextField();
     cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
     cityTextField.setBounds(350,490,400,30);
    add(cityTextField);

     JLabel state = new JLabel("State: ");
     state.setFont(new Font("Raleway", Font.BOLD,22));
     state.setBounds(100, 540, 200, 30);
     add( state);

    stateTextField = new JTextField();
     stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
     stateTextField.setBounds(350,540,400,30);
    add(stateTextField);

     JLabel pincode = new JLabel("Pincode: ");
     pincode.setFont(new Font("Raleway", Font.BOLD,22));
     pincode.setBounds(100, 590, 200, 30);
     add( pincode);

     pincodeTextField = new JTextField();
     pincodeTextField.setFont(new Font("Raleway", Font.BOLD,14));
     pincodeTextField.setBounds(350,590,400,30);
    add(pincodeTextField);

    JButton next = new JButton("Next");
    next.setBackground(Color.black);
    next.setForeground(Color.white);
    next.setFont(new Font("Raleway", Font.BOLD,14));
    next.setBounds(700,640,80,30);
    next.addActionListener(this);
    add(next);



        getContentPane().setBackground(Color.WHITE);
        setSize(850,720);
        setLocation(350,10);
        setVisible(true);

  }

public void actionPerformed(ActionEvent ae){
 String formno = " " + random; // long
 String name= nameTextField.getText(); // setText 
 String fname = fnameTextField.getText(); 
 String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
 String gender = null ;

 if(male.isSelected()){
    gender= "Male";
 }
 else if(female.isSelected()){
    gender= "Female";
 }

  String email = emailTextField.getText();
  String marital = null;

  
 if(unmarried.isSelected()){
    marital= "Unmarried";
 }
 else if(married.isSelected()){
    marital= "Married";
 }

String address = addressTextField.getText();
String city = cityTextField.getText();
String state = stateTextField.getText();
String pincode = pincodeTextField.getText();


try{
 if(name.equals("")){
    JOptionPane.showMessageDialog(null, "Name is required");
 }else{
 Connection con;
 Statement s;
 
   Class.forName("com.mysql.jdbc.Driver");
            String prabhat1234="prabhat1234";
            
            con=DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem","root","prabhat1234");
            s=con.createStatement();
    String query = "insert into signup values('"+ formno+"' ,'"+ name +"' ,'"+ fname +"' ,'"+ dob +"' ,'"+ gender +"' ,'"+ email +"' ,'"+ marital +"' ,'"+ address +"' ,'"+ city +"' ,'"+ pincode +"' ,'"+ state +"' )";
  s.executeUpdate(query);
  setVisible(false);
  new SignupTwo(formno).setVisible(true);


 }
} catch (Exception e){
  System.out.println(e);
}

}






     public static void main(String[] args) {
        new SignupOne();

    } 
}
