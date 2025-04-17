
package ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener{
    JButton hund,fivhud,thehud,thuhud,fivethdud,tenhud,exit;
    JLabel headtext;
    String PinNumber;
     FastCash(String PinNumber){
         this.PinNumber= PinNumber;
//         System.out.println(PinNumber);
         setLayout(null);
         setTitle("Section FastCash");
         
         ImageIcon im= new ImageIcon(ClassLoader.getSystemResource("logo/atm.jpg"));
         Image bgim= im.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
         ImageIcon atmim= new ImageIcon(bgim);
         JLabel ims= new JLabel(atmim);
         ims.setBounds(0,0,800,800);
         add(ims);
         
         headtext= new JLabel("SELECT WITHDRAWL AMOUNT");
         headtext.setBounds(210,300,400,30);
         headtext.setForeground(Color.WHITE);
         ims.add(headtext);
         
         
        hund= new JButton("100");
        hund.setBounds(150,370,100,25);
        hund.setForeground(Color.BLACK);
        hund.addActionListener(this);
        ims.add(hund);
        

        fivhud= new JButton("500");
        fivhud.setBounds(350,370,100,25);
        fivhud.setForeground(Color.BLACK);
        fivhud.addActionListener(this);
        ims.add(fivhud);
         
        thehud= new JButton("1000");
        thehud.setBounds(150,400,100,25);
        thehud.setForeground(Color.BLACK);
        thehud.addActionListener(this);
        ims.add(thehud);
        
        thuhud= new JButton("2000");
        thuhud.setBounds(350,400,100,25);
        thuhud.setForeground(Color.BLACK);
        thuhud.addActionListener(this);
        ims.add(thuhud);
        
        fivethdud= new JButton("5000");
        fivethdud.setBounds(150,430,100,25);
        fivethdud.setForeground(Color.BLACK);
        fivethdud.addActionListener(this);
        ims.add(fivethdud);
        
        tenhud= new JButton("10000");
        tenhud.setBounds(350,430,100,25);
        tenhud.setForeground(Color.BLACK);
        tenhud.addActionListener(this);
        ims.add(tenhud);
        
        exit= new JButton("EXIT");
        exit.setBounds(350,460,100,25);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        ims.add(exit);
        
        
         setVisible(true);
         setLocation(350,10);
         setSize(800,785);
         getContentPane().setBackground(Color.WHITE);
     }
     public static void main(String[] args){
         new FastCash("");
     }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==exit){
          setVisible(false);
          new Signin(PinNumber).setVisible(true);
      }
      else
      {
          String amount= ((JButton)e.getSource()).getText();
          int balance=0;
          try{
              Connection_mysql c=new Connection_mysql();
              ResultSet rs = c.s.executeQuery("select * from bank where Pin ='"+PinNumber+"'");
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance+= Integer.parseInt(rs.getString("amount"));
                  }
                  else{
                      balance-=Integer.parseInt(rs.getString("amount"));
                  }
              }
              if(e.getSource()!=exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "Insufficient Balance");
                  return;
              }
              Date date= new Date();
              String query= "insert into bank values('"+PinNumber+"','"+date+"','Withdraw','"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "RS"+amount+"Debit Sucessfully");
              setVisible(false);
              new Signin(PinNumber).setVisible(true);
          }
          catch(Exception g){
              System.out.println(g);
          }
      }
    }
}
