package ATM_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Balanceenquiry extends JFrame implements ActionListener {

    JButton back;
    String PinNumber;

    Balanceenquiry(String PinNumber) {
        this.PinNumber = PinNumber;
        
        setLayout(null);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("logo/atm.jpg"));
        Image bgim = im.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon atmim = new ImageIcon(bgim);
        JLabel ims = new JLabel(atmim);
        ims.setBounds(0, 0, 800, 800);
        add(ims);

        back = new JButton("BACK");
        back.setBounds(350, 460, 100, 25);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        ims.add(back);

        Connection_mysql c = new Connection_mysql();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where Pin ='" + PinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception g) {
            System.out.println(g);
        }
        
        JLabel headertext= new JLabel("Your current Amount balance is Rs"+" "+balance);
         headertext.setBounds(150,300,400,30);
         headertext.setForeground(Color.WHITE);
         ims.add(headertext);
      

        setVisible(true);
        setTitle("MINISTATEMENT SECTION");
        setLocation(350, 10);
        setSize(800, 800);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new Balanceenquiry("");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new Signin(PinNumber).setVisible(true);
    }
}
