import java.sql.*;
import java.sql.DriverManager;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
      Class.forName("com.mysql.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem","root","prabhat1234");
               s=c.createStatement();
        }
        catch(Exception e){
        System.out.println(e);
        }
    }
}
