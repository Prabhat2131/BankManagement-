import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {

 JButton deposit,withdrawl, ministatement,pinchange, fastcash,balanceenquiry,exit;
String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 730,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,730);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(170, 270, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


      deposit = new JButton("Deposit");
      deposit.setBounds(140, 388, 140, 25);
      deposit.addActionListener((ActionListener) this);
     image.add( deposit );

     withdrawl = new JButton("Cash Withdrawl");
     withdrawl.setBounds(285, 388, 140, 25);
     withdrawl.addActionListener((ActionListener) this);
     image.add( withdrawl);

     fastcash  = new JButton("Fast Cash");
     fastcash .setBounds(140, 420, 140, 25);
    fastcash.addActionListener((ActionListener) this);
     image.add( fastcash );


     
     ministatement = new JButton("Mini Statement");
     ministatement .setBounds(285, 420, 140, 25);
    ministatement.addActionListener((ActionListener) this);
     image.add(ministatement );

     
     pinchange = new JButton("Pin Change");
     pinchange.setBounds(140, 452, 140, 25);
    pinchange.addActionListener((ActionListener) this);
     image.add(pinchange);

     balanceenquiry = new JButton("Balance Enquiry");
     balanceenquiry.setBounds(285, 452, 140, 25);
     balanceenquiry.addActionListener((ActionListener) this);
     image.add(balanceenquiry);

     exit = new JButton("Exit");
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
    System.exit(0);
   }
   else if(ae.getSource()== deposit){
    setVisible(false);
    new Deposit(pinnumber).setVisible(true);
   }
   else if(ae.getSource()== withdrawl){
    setVisible(false);
    new Withdrawl(pinnumber).setVisible(true);
   }
   else if(ae.getSource()== fastcash){
    setVisible(false);
    new FastCash(pinnumber).setVisible(true);
   }
   else if(ae.getSource()== pinchange){
    setVisible(false);
    new PinChange(pinnumber).setVisible(true);
   }
   else if(ae.getSource()== balanceenquiry){
    setVisible(false);
    new BalanceEnquiry(pinnumber).setVisible(true);
   }
   else if(ae.getSource()== ministatement){
  
    new MiniStatement(pinnumber).setVisible(true);

    }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
