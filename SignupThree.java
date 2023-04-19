
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
public class SignupThree extends JFrame implements ActionListener{

JRadioButton r1,r2,r3,r4;
JCheckBox c1,c2,c3,c4,c5,c6,c7;
JButton submit,cancel;
String formno;
    SignupThree(String formno){
        this.formno =formno;
setLayout(null);

        JLabel l1 = new JLabel(" Page 3: `Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel accounttype = new JLabel(" Account Type");
        accounttype.setFont(new Font("Raleway",Font.BOLD,22));
        accounttype.setBounds(100,100,200,30);
        add(accounttype);

     r1 = new JRadioButton((String) "Saving Account");
     r1.setFont(new Font("Raleway",Font.BOLD,16));
     r1.setBackground(Color.white);
     r1.setBounds(100,140,170,20);
     add(r1);

     r2 = new JRadioButton((String) "Fixed Deposit Account");
     r2.setFont(new Font("Raleway",Font.BOLD,16));
     r2.setBackground(Color.white);
     r2.setBounds(350,140,250,20);
     add(r2);

     r3 = new JRadioButton((String) "Current Account");
     r3.setFont(new Font("Raleway",Font.BOLD,16));
     r3.setBackground(Color.white);
     r3.setBounds(100,180,170,20);
     add(r3);

     r4 = new JRadioButton((String) "Reccuring Deposit Account");
     r4.setFont(new Font("Raleway",Font.BOLD,16));
     r4.setBackground(Color.white);
     r4.setBounds(350,180,250,20);
     add(r4);

     ButtonGroup groupaccount = new ButtonGroup();
     groupaccount.add(r1);
     groupaccount.add(r2);
     groupaccount.add(r3);
     groupaccount.add(r4);

     
     JLabel card = new JLabel(" Card No");
     card.setFont(new Font("Raleway",Font.BOLD,22));
     card.setBounds(94,260,200,30);
     add(card);
     
     JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
     number.setFont(new Font("Raleway",Font.BOLD,22));
     number.setBounds(330,260,300,30);
     add(number);

      
     JLabel carddetails = new JLabel("Your 16 Digit Card No");
     carddetails.setFont(new Font("Raleway",Font.BOLD,12));
     carddetails.setBounds(100,290,300,20);
     add( carddetails);

     JLabel pin = new JLabel("PIN:");
     pin .setFont(new Font("Raleway",Font.BOLD,22));
     pin .setBounds(100,330,200,30);
     add(pin );
     
     JLabel pnumber = new JLabel("XXXX");
     pnumber.setFont(new Font("Raleway",Font.BOLD,22));
     pnumber.setBounds(330,330,300,30);
     add(pnumber);
     JLabel pindetails = new JLabel("Your 4 Digit Pin No");
     pindetails .setFont(new Font("Raleway",Font.BOLD,12));
     pindetails .setBounds(100,360,300,20);
     add( pindetails );

     
     JLabel services = new JLabel("Services Required:");
     services.setFont(new Font("Raleway",Font.BOLD,22));
     services.setBounds(100,410,300,30);
     add(services);

     c1 =new JCheckBox("ATM CARD");
     c1.setBackground(Color.WHITE);
     c1.setFont(new Font("Raleway", Font.BOLD,16));
     c1.setBounds(100,460,200,30);
     add(c1);

     c2 =new JCheckBox("Internet Banking");
     c2.setBackground(Color.WHITE);
     c2.setFont(new Font("Raleway", Font.BOLD,16));
     c2.setBounds(350,460,200,30);
     add(c2);

     

     c3 =new JCheckBox("Mobile Banking");
     c3.setBackground(Color.WHITE);
     c3.setFont(new Font("Raleway", Font.BOLD,16));
     c3.setBounds(100,510,200,30);
     add(c3);

     c4 =new JCheckBox("Email & SMS Alert");
     c4.setBackground(Color.WHITE);
     c4.setFont(new Font("Raleway", Font.BOLD,16));
     c4.setBounds(350,510,200,30);
     add(c4);

     c5 =new JCheckBox("Cheque Book");
     c5.setBackground(Color.WHITE);
     c5.setFont(new Font("Raleway", Font.BOLD,16));
     c5.setBounds(100,560,200,30);
     add(c5);

     c6 =new JCheckBox("E-Statement");
     c6.setBackground(Color.WHITE);
     c6.setFont(new Font("Raleway", Font.BOLD,16));
     c6.setBounds(350,560,200,30);
     add(c6);

     c7 =new JCheckBox("hereby declare that the above details are correct to the best of my knowledge");
     c7.setBackground(Color.WHITE);
     c7.setFont(new Font("Raleway", Font.BOLD,12));
     c7.setBounds(100,610,500,30);
     add(c7);

     submit = new JButton("SUBMIT");
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.setFont(new Font("Raleway", Font.BOLD,14));
     submit.setBounds(200,650,100,30);
     submit.addActionListener(this);
     add(submit);

     cancel = new JButton("CANCEL");
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.setFont(new Font("Raleway", Font.BOLD,14));
     cancel.setBounds(420,650,100,30);
     cancel.addActionListener(this);
     add(cancel);

     getContentPane().setBackground(Color.WHITE);

        setSize(850,750);
        setLocation(350,0);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype = null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }
            else if (r2.isSelected()){
                accounttype="Fixed Deposit Account";
            }
            else if (r3.isSelected()){
                accounttype="Current Account";
            }
            else if (r4.isSelected()){
                accounttype="Reccuring Deposit Account";
            }
         Random random = new Random();
         String cardnumber= ""+ Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
         String pinnumber= ""+ Math.abs((random.nextLong()%9000L) +1000L);

         String facility="";
         if(c1.isSelected()){
            facility= facility + "  ATM CARD";
         } if(c2.isSelected()){
            facility= facility + "  Internet Banking";
         }
         if(c3.isSelected()){
            facility= facility + "  Mobile Banking";
         }
         if(c4.isSelected()){
            facility= facility + "  Email & SMS Alert";
         }
         if(c5.isSelected()){
            facility= facility + "  Cheque Book";
         }
         if(c6.isSelected()){
            facility= facility + "  E-Statement";
         }
        
         try{
          if(accounttype.equals("")){
            JOptionPane.showMessageDialog(null, "Account Type IS REQUIRED");
          }
          else{
            Connection con;
            Statement s;
            
              Class.forName("com.mysql.jdbc.Driver");
                       String prabhat1234="prabhat1234";
                       
                       con=DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem","root","prabhat1234");
                       s=con.createStatement();
               String query1 = "insert into signupthree values('"+ formno+"' ,'"+ accounttype +"' ,'"+cardnumber +"' ,'"+pinnumber +"' ,'"+ facility+"' )";
               String query2 = "insert into login values('"+ formno+"' ,'"+cardnumber +"' ,'"+pinnumber +"' )";
               s.executeUpdate(query1);
               s.executeUpdate(query2);
             JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber +"\n Pin: " +pinnumber);
             setVisible(false);
             new Deposit(pinnumber).setVisible(false);
        
            }
         }catch(Exception e){
            System.out.println(e);
         }

        }
        else if(ae.getSource()== cancel){
         setVisible(false);
         new Login().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
    
}
