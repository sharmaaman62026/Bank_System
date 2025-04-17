package ATM_Management;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Login_page extends JFrame implements ActionListener {
    JButton clear,signin,signup;
    JTextField Cardtextfield;
    JPasswordField Pintextfield;
    
    
    Login_page(){
        setLayout(null);
        setTitle("NEW BANK OF INDIA");
        
        ImageIcon im= new ImageIcon(ClassLoader.getSystemResource("Logo/logo.jpg"));
        Image i2= im.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon logo= new ImageIcon(i2);
        JLabel imagelogo= new JLabel(logo);
        imagelogo.setBounds(70,10,100,100);
        add(imagelogo);
        
        JLabel text= new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,50,400,30);
        add(text);
        
        JLabel Cardtext= new JLabel("CARD NO: ");
        Cardtext.setFont(new Font("Raleway",Font.BOLD,22));
        Cardtext.setBounds(120,130,200,30);
        add(Cardtext);
        
        Cardtextfield= new JTextField();
        Cardtextfield.setBounds(250,130,200,30);
        add(Cardtextfield);
        
        JLabel PINTEXT= new JLabel("PIN: ");
        PINTEXT.setFont(new Font("Raleway",Font.BOLD,22));
        PINTEXT.setBounds(120,180,200,30);
        add(PINTEXT);
        
        Pintextfield= new JPasswordField();
        Pintextfield.setBounds(250,180,200,30);
        add(Pintextfield);
        
        
        signin= new JButton("SIGN IN");
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.setBounds(250,230,90,25);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setBounds(360,230,90,25);
        clear.addActionListener(this);
        add(clear);
        
        signup= new JButton("SIGN UP");
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setBounds(250,280,200,25);
        signup.addActionListener(this);
        add(signup);
       
       
        
        
        setVisible(true);
        setSize(700,400);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);
        
    }

    public static void main(String[] args) {
        new Login_page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
             Cardtextfield.setText("");
             Pintextfield.setText("");
        }
        else if(e.getSource()==signin){
            Connection_mysql c= new Connection_mysql();
            String CardNumber= Cardtextfield.getText();
            String PinNumber = Pintextfield.getText();
            String qurey= "Select * from login where Card_Number='"+CardNumber+"'and Pin_number='"+PinNumber+"'";
            try{
                ResultSet rs=   c.s.executeQuery(qurey);
              if(rs.next()){
                  setVisible(false);
                  new Signin(PinNumber).setVisible(true);
              }
              else{
                  JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
              }
            }
            catch(Exception s){
                System.out.println(s);
            }
                
        }
        else if(e.getSource()==signup){
            setVisible(false);
            new Signup1().setVisible(true);
            
        }
    }
}