
package ATM_Management;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Withdraw extends JFrame implements ActionListener{
        JLabel textmain,ims;
        JTextField amount;
        JButton WithdrawSave,Back;
        String PinNumber;
        Withdraw(String PinNumber){
        this.PinNumber= PinNumber;
        setLayout(null);
        ImageIcon dpbg= new ImageIcon(ClassLoader.getSystemResource("logo/atm.jpg"));
        Image im= dpbg.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
        ImageIcon mainbg= new ImageIcon(im);
        ims= new JLabel(mainbg);
        ims.setBounds(0,0,900,800);
        add(ims);
        
        
        textmain= new JLabel("Enter the amount you want to Withdraw");
        textmain.setBounds(210,300,400,30);
        textmain.setForeground(Color.WHITE);
        ims.add(textmain);
        
        
        amount= new JTextField();
        amount.setBounds(160,330,350,30);
        amount.setForeground(Color.BLACK);
        add(amount);
        
        WithdrawSave= new JButton("Withdraw");
        WithdrawSave.setBounds(380,430,130,25);
        WithdrawSave.setForeground(Color.BLACK);
        WithdrawSave.addActionListener(this);
        ims.add(WithdrawSave);
        
        Back= new JButton("Back");
        Back.setBounds(380,460,130,25);
        Back.setForeground(Color.BLACK);
        Back.addActionListener(this);
        ims.add(Back);
        
        setTitle("Deposit Section");
        setVisible(true);
        setSize(800,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args){
        new Withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==Back){
            setVisible(false);
            new Signin(PinNumber).setVisible(true);
        }
        else if(e.getSource()==WithdrawSave){
            String number= amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showConfirmDialog(null, "Please Enter the amount you want to Withdraw");
            }
            else{
                try{
                Connection_mysql c= new Connection_mysql();
                String query= "insert into bank values('"+PinNumber+"','"+date+"','Withdraw','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+number+"Withdraw Successfully");
                setVisible(false);
                new Signin(PinNumber).setVisible(true);
                }
                catch(Exception s){
                    System.out.println(s);
                }
            }
        }
    }
}
