import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, clear,signup;
       JTextField cardTextField;
    JPasswordField pinTextField;

Login(){

    setTitle("Automated Teller Machine");
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank.jpg"));
  Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
  ImageIcon i3= new ImageIcon(i2);
    JLabel label= new JLabel(i3);
    label.setBounds(70, 10, 100, 100);
   add(label);
   
   JLabel text = new JLabel("Welcome to ATM");
   text.setFont(new Font("Osward", Font.BOLD, 38));
     text.setBounds(240, 40, 400, 40);
add(text);

  
JLabel cardno = new JLabel("Card No:");
cardno.setFont(new Font("Raleway", Font.BOLD, 30));
  cardno.setBounds(120, 150, 200, 30);
add(cardno);

 cardTextField = new JTextField();
  cardTextField.setBounds(300, 150, 250, 30);
  cardTextField.setFont(new Font("Arial",Font.BOLD,14));
add(cardTextField);



JLabel pin = new JLabel("Pin:");
pin.setFont(new Font("Raleway", Font.BOLD, 30));
  pin.setBounds(120, 220, 200, 30);

add(pin);

pinTextField = new    JPasswordField();
  pinTextField.setBounds(300, 220, 250, 30);
  pinTextField.setFont(new Font("Arial",Font.BOLD,14));
add(pinTextField);

 login= new JButton("SIGN IN");
login.setBounds(300, 300, 100, 30);
login.setBackground(Color.black);
login.setForeground(Color.white);
login.addActionListener(this);
add(login);

 clear= new JButton("CLEAR");
clear.setBounds(450, 300, 100, 30);
clear.setBackground(Color.black);
clear.setForeground(Color.white);
clear.addActionListener(this);
add(clear);

signup= new JButton("SIGN UP");
signup.setBounds(300, 350, 250, 30);
signup.setBackground(Color.black);
signup.setForeground(Color.white);
signup.addActionListener(this);
add(signup);

   getContentPane().setBackground((Color.white));


    setSize(800,480);
    setVisible(true);
    setLocation(350,100);

}
public void actionPerformed(ActionEvent ae){
   if(ae.getSource()==clear){
    cardTextField.setText("");
    pinTextField.setText("");


   }
  else if(ae.getSource()==login){

    Conn conn = new Conn();
   // Statement s;
    String cardnumber= cardTextField.getText();
    String pinnumber= pinTextField.getText();
     String query = "select* from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
     try{
      ResultSet rs = conn.s.executeQuery(query);
      if(rs.next()){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);

      } else{
        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
      }

     } catch(Exception e){
      System.out.println(e);
     }

  }

  else if(ae.getSource()==signup){
    setVisible(false);
    new SignupOne().setVisible(true);

  }
}





public static void main(String[] args) {
    
    new Login();
}
}
    