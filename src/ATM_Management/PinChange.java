
package ATM_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    String PinNumber;
    JPasswordField pin,repin;
    JLabel headtext,pintext;
    JButton back,change;
    PinChange(String PinNumber){
        this.PinNumber= PinNumber;
         setLayout(null);
         setTitle("Section Pin Change");
        
         ImageIcon im= new ImageIcon(ClassLoader.getSystemResource("logo/atm.jpg"));
         Image bgim= im.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
         ImageIcon atmim= new ImageIcon(bgim);
         JLabel ims= new JLabel(atmim);
         ims.setBounds(0,0,800,800);
         add(ims);
         
         headtext= new JLabel("CHANGE YOUR PIN");
         headtext.setBounds(230,270,400,30);
         headtext.setForeground(Color.WHITE);
         ims.add(headtext);
         
         pintext= new JLabel("New Pin:");
         pintext.setBounds(150,335,100,30);
         pintext.setForeground(Color.WHITE);
         ims.add(pintext);
         
         
         pin= new JPasswordField();
         pin.setBounds(250,335,150,30);
         pin.setFont(new Font("Arival",Font.BOLD,25));
         pin.setForeground(Color.BLACK);
         ims.add(pin);
         
         pintext= new JLabel("Re-Enter Pin:");
         pintext.setBounds(150,370,120,30);
         pintext.setForeground(Color.WHITE);
         ims.add(pintext);
         
         repin= new JPasswordField();
         repin.setBounds(250,370,150,30);
         repin.setFont(new Font("Arival",Font.BOLD,25));
         repin.setForeground(Color.BLACK);
         ims.add(repin);
         
         change= new JButton("Change");
         change.setBounds(350,430,100,25);
//         change.setFont(new Font("Arival",Font.BOLD,25));
          change.addActionListener(this);
         change.setForeground(Color.BLACK);
         ims.add(change);
         
         back= new JButton("Back");
         back.setBounds(350,460,100,25);
//         back.setFont(new Font("Arival",Font.BOLD,25));
         back.addActionListener(this);
         back.setForeground(Color.BLACK);
         ims.add(back);
         
         
         
        
         setVisible(true);
         setLocation(350,10);
         setSize(800,785);
         getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args){
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Pintextfield= pin.getText();
        String retextfield= repin.getText();
        if(e.getSource()==back){
            setVisible(false);
            new Signin(PinNumber).setVisible(true);
        }
        else{
                try{
                    Connection_mysql c= new Connection_mysql();
                    if(!Pintextfield.equals(retextfield)){
                        JOptionPane.showMessageDialog(null, "Entered Pin doesnot match. Please re-enter");
                        return;
                    }
                    if(Pintextfield.equals("")){
                        JOptionPane.showMessageDialog(null, "Enter the Pin");
                        return;
                    }
                    if(retextfield.equals("")){
                        JOptionPane.showMessageDialog(null, "Enter the Re-enter Pin");
                        return;
                    }
                    String query= "update bank set Pin = '"+retextfield+"'where Pin= '"+PinNumber+"'";
                    String query1= "update login set Pin_Number = '"+retextfield+"'where Pin_Number= '"+PinNumber+"'";
                    String query2= "update signup3 set Pin_Number = '"+retextfield+"'where Pin_Number= '"+PinNumber+"'";
                    
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                    setVisible(false);
                    new Signin(PinNumber).setVisible(true);
                }
                catch(Exception g){
                    System.out.println(g);
                }
        }
    }
}
