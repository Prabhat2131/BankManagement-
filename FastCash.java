import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

 JButton deposit,withdrawl, ministatement,pinchange, fastcash,balanceenquiry,exit;
String pinnumber;
FastCash(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 730,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,730);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(170, 270, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


      deposit = new JButton("Rs 100");
      deposit.setBounds(140, 388, 140, 25);
      deposit.addActionListener((ActionListener) this);
     image.add( deposit );

     withdrawl = new JButton("Rs 500");
     withdrawl.setBounds(285, 388, 140, 25);
     withdrawl.addActionListener((ActionListener) this);
     image.add( withdrawl);

     fastcash  = new JButton("Rs 1000");
     fastcash .setBounds(140, 420, 140, 25);
    fastcash.addActionListener((ActionListener) this);
     image.add( fastcash );


     
     ministatement = new JButton("Rs 2000");
     ministatement .setBounds(285, 420, 140, 25);
    ministatement.addActionListener((ActionListener) this);
     image.add(ministatement );

     
     pinchange = new JButton("Rs 5000");
     pinchange.setBounds(140, 452, 140, 25);
    pinchange.addActionListener((ActionListener) this);
     image.add(pinchange);

     balanceenquiry = new JButton("Rs 10000");
     balanceenquiry.setBounds(285, 452, 140, 25);
     balanceenquiry.addActionListener((ActionListener) this);
     image.add(balanceenquiry);

     exit = new JButton("Back");
     exit.setBounds(285, 484, 140, 25);
    exit.addActionListener((ActionListener) this);
     image.add(exit);

        setSize(750,730);
        setLocation(300,0);
       // setUndecorated(true);
        setVisible(true);
      
        
    }

    public void actionPerformed(ActionEvent ae){
   if(ae.getSource()==exit){
    setVisible(false);
    new Transactions(pinnumber).setVisible(true);
   }
   else {
    String amount = ((JButton)ae.getSource()).getText().substring(3); // Rs 500
    Conn c = new Conn();
    try{
     ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+ pinnumber+"'");
     int balance = 0;
     while(rs.next()){
        if(rs.getString("type").equals("Deposit")){
            balance += Integer.parseInt(rs.getString("amount"));
        } else{
            balance -= Integer.parseInt(rs.getString("amount"));
        }

     }
      if(ae.getSource() != exit && balance< Integer.parseInt(amount)){
        JOptionPane.showMessageDialog(null, "Insufficient balance");
        return;

      }
      Date date = new Date();
      String query = "insert into bank values('"+ pinnumber + "','"+ date + "','Withdrawl', '"+amount+"')";
      c.s.executeUpdate(query);
      JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
      setVisible(false);
      new Transactions(pinnumber).setVisible(true);
    } catch(Exception e){
        System.out.println(e);
    }
   }
   

    }


    public static void main(String[] args) {
        new FastCash("");
    }
}
