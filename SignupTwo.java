

import javax.swing.*;
import java.awt.*;

import java.sql.Statement;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class SignupTwo extends JFrame implements ActionListener{

JTextField pan, aadhar;
JButton next;
String formno;
JComboBox<String> religion,category,occupation,education,income,seniorcitizen,existingaccount;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
     
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


     JLabel additionalDetails = new JLabel("Page 2: Additional Details");
     additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
     additionalDetails.setBounds(290, 80, 400, 30);
     add(additionalDetails);

     
     JLabel name = new JLabel("Religion: ");
     name.setFont(new Font("Raleway", Font.BOLD,22));
     name.setBounds(100, 140, 100, 30);
     add(name);
      String ValReligion[]={"Hindu", "Muslim", "Sikh", "Christian", "Other"};
      religion=new JComboBox<>(ValReligion);
     religion.setBounds(350,140,400,30);
     religion.setBackground(Color.white);
     add(religion);
     
   
     
     JLabel fname = new JLabel("Category: ");
     fname.setFont(new Font("Raleway", Font.BOLD,22));
     fname.setBounds(100, 190, 200, 30);
     add(fname);

     String Valcategory[]={"Gen", "Ews", "Obc", "Sc/St", "Other"};
     category=new JComboBox<>(Valcategory);
     category.setBounds(350,190,400,30);
     category.setBackground(Color.white);
     add(category);

    
     JLabel dob = new JLabel("Income");
     dob.setFont(new Font("Raleway", Font.BOLD,22));
     dob.setBounds(100, 240, 200, 30);
     add(dob);

     String Incomecategory[]={"Null", "Upto 3 lac", "3 lac-5 lac", "5 lac- 8 lac", "Above 8 lac"};
     income=new JComboBox<>(Incomecategory);
     income.setBounds(350,240,400,30);
     income.setBackground(Color.white);
     add(income);
   

     JLabel gender = new JLabel("Educational ");
     gender.setFont(new Font("Raleway", Font.BOLD,22));
     gender.setBounds(100, 290, 140, 30);
     add(gender);

     

     JLabel email = new JLabel("Qualification: ");
     email .setFont(new Font("Raleway", Font.BOLD,22));
     email .setBounds(100, 315 ,200, 30);
     add( email );

     String Educationalval[]={"Null","High School", "Intermediate", "Graduation", "Post Graduation", "Others"};
     education=new JComboBox<>(Educationalval);
     education.setBounds(350,300,400,30);
     education.setBackground(Color.white);
     add(education);


     JLabel marital = new JLabel("Occupation: ");
     marital .setFont(new Font("Raleway", Font.BOLD,22));
     marital.setBounds(100, 390, 200, 30);
     add( marital);
     
     
     String Occupationalval[]={"Student","Govt Employee","Self Business","Others"};
      occupation=new JComboBox<>(Occupationalval);
     occupation.setBounds(350,390,400,30);
     occupation.setBackground(Color.white);
     add( occupation);

     JLabel address = new JLabel("Pan No: ");
     address.setFont(new Font("Raleway", Font.BOLD,22));
     address.setBounds(100, 440, 200, 30);
     add( address);

     pan = new JTextField();
     pan.setFont(new Font("Raleway", Font.BOLD,14));
     pan.setBounds(350,440,400,30);
    add( pan);

     JLabel city = new JLabel("Aadhar No: ");
     city.setFont(new Font("Raleway", Font.BOLD,22));
     city.setBounds(100, 490, 200, 30);
     add( city);

     aadhar = new JTextField();
     aadhar.setFont(new Font("Raleway", Font.BOLD,14));
     aadhar.setBounds(350,490,400,30);
    add(aadhar);

     JLabel state = new JLabel("Senior Citizen: ");
     state.setFont(new Font("Raleway", Font.BOLD,22));
     state.setBounds(100, 540, 200, 30);
     add( state);

     String Seniorval[]={"Yes","No"};
     seniorcitizen=new JComboBox<>(Seniorval);
     seniorcitizen.setBounds(350,540,400,30);
     seniorcitizen.setBackground(Color.white);
     add( seniorcitizen);


     JLabel pincode = new JLabel("Existing Account: ");
     pincode.setFont(new Font("Raleway", Font.BOLD,22));
     pincode.setBounds(100, 590, 200, 30);
     add( pincode);

     String Accountval[]={"Yes","No"};
      existingaccount =new JComboBox<>(Accountval);
     existingaccount.setBounds(350,590,400,30);
     existingaccount.setBackground(Color.white);
     add( existingaccount);

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

 String sreligion= (String) religion.getSelectedItem();
 String scategory = (String) category.getSelectedItem(); 
 String sincome = (String) income.getSelectedItem();
 String seducation =(String) education.getSelectedItem();
 String soccupation = (String) occupation.getSelectedItem();
 String sseniorcitizen = (String) seniorcitizen.getSelectedItem();
 String sexistingaccount= (String) existingaccount.getSelectedItem();
 

 
  

String span = pan.getText();
String saadhar = aadhar.getText();



try{
 
 Connection con;
 Statement s;
 
   Class.forName("com.mysql.jdbc.Driver");
            String prabhat1234="prabhat1234";
            
            con=DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem","root","prabhat1234");
            s=con.createStatement();
    String query = "insert into signuptwo values('"+ formno+"' ,'"+ sreligion +"' ,'"+ scategory +"' ,'"+sincome +"' ,'"+ seducation+"' ,'"+ soccupation +"' ,'"+ span +"' ,'"+ saadhar +"' ,'"+ sseniorcitizen +"' ,'"+ sexistingaccount +"' )";
  s.executeUpdate(query);
// signup3 object
 setVisible(false);
 new SignupThree(formno).setVisible(true);
 
} catch (Exception e){
  System.out.println(e);
}

}






     public static void main(String[] args) {
        new SignupTwo("");

    } 
}

