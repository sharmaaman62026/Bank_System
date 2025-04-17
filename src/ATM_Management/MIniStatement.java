
package ATM_Management;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class MIniStatement extends JFrame implements ActionListener {
    String PinNumber;
    MIniStatement(String PinNumber){
        this.PinNumber=PinNumber;
        setLayout(null);
        
        JLabel headertext= new JLabel();
        headertext.setBounds(20,140,400,200);
        add(headertext);
        
        JLabel bank = new JLabel("Welcome to NEW BANK OF INDIA");
        bank.setBounds(150,20,300,30);
        add(bank);
        
        JLabel mini= new JLabel();
        mini.setBounds(20,80,300,20);
        add(mini);
       
        JLabel displayamount= new JLabel();
        displayamount.setBounds(20,400,300,30);
        add(displayamount);
        
        try{
            Connection_mysql c= new Connection_mysql();
            ResultSet rs=c.s.executeQuery("select * from login where Pin_Number='"+2222+"'");
            while(rs.next()){
                mini.setText("Card Number: "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXXXXXXXXX");
                
            }
        }
        catch(Exception g){
            System.out.println(g);
        }
        
        try{
            int balance=0;
             Connection_mysql c= new Connection_mysql();
             ResultSet rs=c.s.executeQuery("select * from bank where Pin='"+2222+"'");
             while(rs.next()){
                 headertext.setText(headertext.getText()+ "<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                  if(rs.getString("type").equals("Deposit")){
                      balance+= Integer.parseInt(rs.getString("amount"));
                  }
                  else{
                      balance-=Integer.parseInt(rs.getString("amount"));
                  }
             }
             displayamount.setText("Your current balance amount is "+balance);
        }
        catch(Exception v){
            System.out.println(v);
        }

        
        setVisible(true);
        setTitle("MINISTATEMENT SECTION");
        setLocation(350,10);
        setSize(800,800);
        getContentPane().setBackground(Color.WHITE);
        
    }
    public static void main(String[] args){
        new MIniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
