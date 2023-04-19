import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JTextField pin , repin;
    JButton change,back;
  String pinnumber;
    PinChange(String pinnumber){
   this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 730,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,730);
        add(image);
     
        JLabel text = new JLabel("CHANGE YOUR PIN");
    text.setBounds(210, 270, 290, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


        JLabel pintext = new JLabel("NEW PIN");
        pintext.setBounds(140, 310, 180, 20);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,14));
        image.add(pintext);

       pin = new JTextField();
       pin.setBounds(280, 310, 145, 20);
       pin.setFont(new Font("Arial",Font.BOLD,14));
      image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New Pin");
        repintext.setBounds(140, 350, 180, 20);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,14));
        image.add(repintext);

      repin = new JTextField();
        repin.setBounds(280, 350, 145, 20);
        repin.setFont(new Font("Arial",Font.BOLD,14));
       image.add(repin);

       change = new JButton("CHANGE");
       change.setBounds(315, 457, 110, 25);
       change.addActionListener((ActionListener) this);
        image.add(change );
   
   
        back = new JButton("BACK");
       back.setBounds(315, 487, 110, 25);
        back.addActionListener((ActionListener) this);
       image.add( back);
        
    setSize(750,730);
    setLocation(300,0);
    setVisible(true);
}
    
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==change){
   try{
    String npin =pin.getText();
    String rpin =repin.getText();

    if(!npin.equals(rpin)&& !rpin.equals("")&& !npin.equals("")){
        JOptionPane.showMessageDialog(null, "Entered Pin does not match");
        return;
    }
    if(npin.equals("")){
        JOptionPane.showMessageDialog(null, "Please Enter New Pin ");
        return;
    }
    if(rpin.equals("")){
        JOptionPane.showMessageDialog(null, "Please Re-enter New Pin ");
        return;
    }

    Conn conn =new Conn();
    String query1= "update bank set pin= '"+rpin+"' where pin= '"+pinnumber+"'";
    String query2= "update login set pin= '"+rpin+"' where pin= '"+pinnumber+"'";
   String query3= "update signupthree set pin= '"+rpin+"' where pin= '"+pinnumber+"'";

    conn.s.executeUpdate(query1);
    conn.s.executeUpdate(query2);
    conn.s.executeUpdate(query3);

    JOptionPane.showMessageDialog(null, "Pin changed successfully");
    setVisible(false);
    new Transactions(rpin).setVisible(true);
}


    catch(Exception e){
    System.out.println(e);
   }
}else{
    setVisible(false);
    new Transactions(pinnumber).setVisible(true);
}


}
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
