import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdrawl,back;
 String pinnumber;
 Withdrawl(String pinnumber){

    this.pinnumber=pinnumber;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(750, 730,Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,750,730);
    add(image);

    JLabel text = new JLabel("Enter the amount you want to Withdraw");
    text.setBounds(138, 270, 290, 20);
    text.setForeground(Color.white);
    text.setFont(new Font("System",Font.BOLD,16));
    image.add(text);

    amount = new JTextField();
    amount.setFont(new Font("Raleway",Font.BOLD,22));
    amount.setBounds(138, 320, 290, 25);
    image.add(amount);

    withdrawl = new JButton("Withdraw");
    withdrawl.setBounds(295, 457, 130, 25);
    withdrawl.addActionListener((ActionListener) this);
     image.add( withdrawl );

    back = new JButton("Back");
    back.setBounds(295, 487, 130, 25);
     back.addActionListener((ActionListener) this);
    image.add( back);

    setSize(750,730);
    setLocation(300,0);
    setVisible(true);
}

public void actionPerformed(ActionEvent ae){

    if(ae.getSource()==withdrawl){
        String number = amount.getText();
        Date date = new Date();
        if(number.equals("")){
            JOptionPane.showMessageDialog(null, " Please enter the amount you want to Withdraw");
        }else{
            try{
            Conn conn = new Conn();
            String query = " insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawl Successfully");
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
      
        } catch(Exception e){
            System.out.println(e);
        }
        
        
       }
    }
       else if (ae.getSource()== back){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);

       }
}




public static void main(String args[]){
    new Withdrawl("");

}


}
