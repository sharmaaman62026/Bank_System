
package ATM_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signin extends JFrame implements ActionListener {
    JButton Deposit,Withdraw,FastWithdraw,Ministatemenet,Pinchange,Balanceenquiry,Exist;
    String PinNumber;
    Signin(String PinNumber){
        this.PinNumber= PinNumber;
        setLayout(null);
        ImageIcon bg= new ImageIcon(ClassLoader.getSystemResource("Logo/atm.jpg"));
        Image bgIm= bg.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon finalbg= new ImageIcon(bgIm);
        JLabel finbg= new JLabel(finalbg);
        finbg.setBounds(0,0,900,800);
        add(finbg);
        
        JLabel text= new JLabel("Please Select Transaction");
        text.setBounds(200,250,300,25);
        text.setForeground(Color.WHITE);
        finbg.add(text);
        
        Deposit= new JButton("Deposit");
        Deposit.setBounds(170,370,100,25);
        Deposit.setForeground(Color.BLACK);
        Deposit.addActionListener(this);
        finbg.add(Deposit);
        
        Withdraw= new JButton("Withdraw");
        Withdraw.setBounds(380,370,130,25);
        Withdraw.setForeground(Color.BLACK);
        Withdraw.addActionListener(this);
        finbg.add(Withdraw);
        
        FastWithdraw= new JButton("Fast Cash");
        FastWithdraw.setBounds(170,400,100,25);
        FastWithdraw.setForeground(Color.BLACK);
        FastWithdraw.addActionListener(this);
        finbg.add(FastWithdraw);
        
        Ministatemenet= new JButton("Mini Statement");
        Ministatemenet.setBounds(380,400,130,25);
        Ministatemenet.setForeground(Color.BLACK);
        Ministatemenet.addActionListener(this);
        finbg.add(Ministatemenet);
        
        Pinchange= new JButton("Pin Change");
        Pinchange.setBounds(170,430,100,25);
        Pinchange.setForeground(Color.BLACK);
        Pinchange.addActionListener(this);
        finbg.add(Pinchange);
        
        Balanceenquiry= new JButton("Balance Enquriy");
        Balanceenquiry.setBounds(380,430,130,25);
//        Balanceenquiry.setFont(new Font("Raleway",Font.BOLD,15));
        Balanceenquiry.setForeground(Color.BLACK);
        Balanceenquiry.addActionListener(this);
        finbg.add(Balanceenquiry);
        
        Exist = new JButton("Exist");
        Exist.setBounds(380,460,130,25);
        Exist.setForeground(Color.BLACK);
        Exist.addActionListener(this);
        finbg.add(Exist);
        
        setSize(800,800);
//        yeh tittle bar ko bhi hata deta hain...full covered ho gata hain ... yeh pura covered ho gata hain.. bground se yadi lagya hain tab;
//        setUndecorated(true);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Exist){
            setVisible(false);
            new Login_page().setVisible(true);
        }
        else if(e.getSource()==Deposit){
            setVisible(false);
            new Deposit(PinNumber).setVisible(true);
        }
        else if(e.getSource()==Withdraw){
            setVisible(false);
            new Withdraw(PinNumber).setVisible(true);
        }
        else if(e.getSource()==FastWithdraw){
            setVisible(false);
            new FastCash(PinNumber).setVisible(true);
        }
        else if(e.getSource()==Pinchange){
            setVisible(false);
            new PinChange(PinNumber).setVisible(true);
        }
        else if(e.getSource()==Balanceenquiry){
            setVisible(false);
            new Balanceenquiry(PinNumber).setVisible(true);
        }
        else if(e.getSource()==Ministatemenet){
            new MIniStatement(PinNumber).setVisible(true);
        }
        
    }
    public static void main(String[] args){
        new Signin("");
    }
}
