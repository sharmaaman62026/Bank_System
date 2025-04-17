
package ATM_Management;
import java.sql.*;
public class Connection_mysql {
    Connection c;
    Statement s;
   public  Connection_mysql(){
        try{
          c=DriverManager.getConnection("jdbc:mysql:///ATM_Management","root","Nhipata@123");
          s= c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
