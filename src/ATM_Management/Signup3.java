
package ATM_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Signup3 extends JFrame implements ActionListener {
        JLabel Account_Details,Account_Type,Card_Details,Card_Info,Pin_Details,PinInfo,ServiceRequired,Card_Value,Pin_Value;
        JCheckBox Argument,atmcard,internetbanking,mobilebanking,email_sms_alert,chequebook,estatement;
        JButton  submit,Cancel;
        JRadioButton SavingAccount,FixedDeposit,CurrentAccount,RecurringDeposit;
        String App_Number;
    Signup3(String App_Number){
        this.App_Number= App_Number;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM: 3");
        
        Account_Details= new JLabel("Account Details");
        Account_Details.setFont(new Font("Osward",Font.BOLD,25));
        Account_Details.setBounds(230,50,300,30);
        add(Account_Details);
        
        Account_Type = new JLabel("Account Type:");
        Account_Type.setFont(new Font("Arival",Font.BOLD,23));
        Account_Type.setBounds(50, 100, 250, 30);
        add(Account_Type);
        
        SavingAccount = new JRadioButton("Saving Account");
        SavingAccount.setBounds(50, 140, 250, 30);
        SavingAccount.setBackground(Color.WHITE);
        SavingAccount.setFont(new Font("Arival",Font.BOLD,15));
        add(SavingAccount);
        
        FixedDeposit = new JRadioButton("Fixed Deposit Account");
        FixedDeposit.setBounds(330, 140, 300, 30);
        FixedDeposit.setBackground(Color.WHITE);
        FixedDeposit.setFont(new Font("Arival",Font.BOLD,15));
        add(FixedDeposit);
        
        CurrentAccount = new JRadioButton("Current Account");
        CurrentAccount.setBounds(50, 180, 250, 30);
        CurrentAccount.setBackground(Color.WHITE);
        CurrentAccount.setFont(new Font("Arival",Font.BOLD,15));
        add(CurrentAccount);
        
        RecurringDeposit = new JRadioButton("Recurring Deposit Account");
        RecurringDeposit.setBounds(330, 180, 300, 30);
        RecurringDeposit.setBackground(Color.WHITE);
        RecurringDeposit.setFont(new Font("Arival",Font.BOLD,15));
        add(RecurringDeposit);
        
        ButtonGroup Accountdetails= new ButtonGroup();
        Accountdetails.add(SavingAccount);
        Accountdetails.add(FixedDeposit);
        Accountdetails.add(CurrentAccount);
        Accountdetails.add(RecurringDeposit);
        
//        Card_Details = new JLabel("Card Number:");
//        Card_Details.setFont(new Font("Arival",Font.BOLD,23));
//        Card_Details.setBounds(50, 220, 300, 30);
//        add(Card_Details);
        
//        Card_Value= new JLabel("XXXX -XXXX -XXXX -4184"); 
//        Card_Value.setFont(new Font("Arival",Font.BOLD,19));
//        Card_Value.setBounds(290,220,330,30);
//        add(Card_Value);        
                 
//        Card_Info = new JLabel("Your 18 Digit Card Number");
//        Card_Info.setFont(new Font("Arival",Font.BOLD,10));
//        Card_Info.setBounds(50, 250, 330, 15);
//        add(Card_Info);
//        
//        Pin_Details = new JLabel("PIN:");
//        Pin_Details.setFont(new Font("Arival",Font.BOLD,23));
//        Pin_Details.setBounds(50, 280,50, 30);
//        add(Pin_Details);
//        
////        Pin_Value= new JLabel("XXXX"); 
////        Pin_Value.setFont(new Font("Arival",Font.BOLD,19));
////        Pin_Value.setBounds(290,280,100,30);
////        add(Pin_Value); 
//        
//        PinInfo = new JLabel("Your 4 Digit Pin Number");
//        PinInfo.setFont(new Font("Arival",Font.BOLD,10));
//        PinInfo.setBounds(50, 310, 330, 15);
//        add(PinInfo);
        
        
        ServiceRequired = new JLabel("Service Required");
        ServiceRequired.setFont(new Font("Arival",Font.BOLD,23));
        ServiceRequired.setBounds(50, 240, 330, 30);
        add(ServiceRequired);
        
        atmcard= new JCheckBox("ATM CARD");
        atmcard.setBackground(Color.WHITE);
        atmcard.setBounds(50,270,100,30);
        add(atmcard);
        
        internetbanking= new JCheckBox("INTERNET BANKING");
        internetbanking.setBackground(Color.WHITE);
        internetbanking.setBounds(330,270,200,30);
        add(internetbanking);
        
        mobilebanking= new JCheckBox("MOBILE BANKING");
        mobilebanking.setBackground(Color.WHITE);
        mobilebanking.setBounds(50,300,150,30);
        add(mobilebanking);
        
        
        email_sms_alert= new JCheckBox("EMAIL & SMS ALERTS");
        email_sms_alert.setBackground(Color.WHITE);
        email_sms_alert.setBounds(330,300,200,30);
        add(email_sms_alert);
        
        
        chequebook= new JCheckBox("CHEQUE BOOK");
        chequebook.setBackground(Color.WHITE);
        chequebook.setBounds(50,330,150,30);
        add(chequebook);
        
        
        estatement = new JCheckBox("E-STATEMENT");
        estatement.setBackground(Color.WHITE);
        estatement.setBounds(330,330,150,30);
        add(estatement);
        
        Argument= new JCheckBox("I hereby declares that the aboves entered details are correct to the best of my knowldege");
        Argument.setFont(new Font("Arival",Font.BOLD,15));
        Argument.setBackground(Color.white);
        Argument.setBounds(50,500,710,15);
        add(Argument);
        
        submit= new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(230,580,100,30);
        submit.addActionListener(this);
        add(submit);
        
        Cancel= new JButton("CANCEL");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(380,580,100,30);
        Cancel.addActionListener(this);
        add(Cancel);
        
        
        setVisible(true);
        setLocation(350,10);
        setSize(800,700);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args){
        new Signup3("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
           
        String Account= null;
        if(SavingAccount.isSelected()){
            Account= "SavingAccount";
        }
        else if(FixedDeposit.isSelected()){
            Account= "FixedDeposit";
        }
        else if(CurrentAccount.isSelected()){
            Account= "CurrentAccount";
        }
        else if(RecurringDeposit.isSelected()){
            Account= "RecurringDeposit";
        }
        Random random= new Random();
        String cardnumber= ""+ Math.abs((random.nextLong()%90000000L)+504093600000000000L);
        String pinnumber= ""+ Math.abs((random.nextLong()%9000L)+1000L);
        String facility= "";
         if(atmcard.isSelected()){
            Account= "atmcard";
        }
        else if(internetbanking.isSelected()){
            Account= "internetbanking";
        }
        else if(mobilebanking.isSelected()){
            Account= "mobilebanking";
        }
        else if(email_sms_alert.isSelected()){
            Account= "email_sms_alert";
        }
        else if(chequebook.isSelected()){
            Account= "chequebook";
        }
        else if(estatement.isSelected()){
            Account= "estatement";
        }
        else if(Argument.isSelected()){
            Account="Argument seleceted";
        }
        
        try{
            if(Account.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is Requried");
            }
            else{
            Connection_mysql c= new Connection_mysql();
            String query= "insert into signup3 values('"+App_Number+"','"+Account+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
            String query1= "insert into login values('"+App_Number+"','"+Account+"','"+cardnumber+"','"+pinnumber+"')";
            c.s.executeUpdate(query);
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin Number:"+pinnumber );
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            }
        }
        catch(Exception r){
            System.out.println(r);
        }
        }
        
        else if(e.getSource()==Cancel){
            setVisible(false);
            new Login_page().setVisible(true);
        }
        
    }
}
