
package ATM_Management;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class Signup1 extends JFrame implements ActionListener{
    long random;
    JLabel headerpage,headerpage1,name,fathername,DateofBirth,Gender,Email,MaritalStatus,Address,City,State,Pin;
    JTextField namefield,fatherfield,emailfield,Addressfield,Cityfield,Statefield,Pinfield;
    JDateChooser dateChooser;
    JRadioButton male,female,Married,UnMarried;
    JButton save;
    
    Signup1(){
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        Random ran= new Random();
        random = Math.abs((ran.nextLong()%9000L)+ 1000L);
        headerpage= new JLabel("APPLICATION FORM NO."+" "+random);
        headerpage.setFont(new Font("Raleway",Font.BOLD,33));
        headerpage.setBounds(170,25,550,33);
        add(headerpage);
        
        headerpage1= new JLabel("Page 1: Personal Details");
        headerpage1.setFont(new Font("Raleway",Font.BOLD,15));
        headerpage1.setBounds(250,60,400,30);
        add(headerpage1);
        
        name= new JLabel("Name:");
        name.setFont(new Font("Arival",Font.BOLD,20));
        name.setBounds(75,120,100,30);
        add(name);
        
        namefield = new JTextField();
        namefield.setBounds(260,120,400,30);
        add(namefield);
        
        fathername= new JLabel("Father's Name:");
        fathername.setFont(new Font("Arival",Font.BOLD,20));
        fathername.setBounds(75,160,160,30);
        add(fathername);
        
        fatherfield = new JTextField();
        fatherfield.setBounds(260,160,400,30);
        add(fatherfield);
        
        DateofBirth= new JLabel("Date of Birth:");
        DateofBirth.setFont(new Font("Arival",Font.BOLD,20));
        DateofBirth.setBounds(75,200,160,30);
        add(DateofBirth);
        
        dateChooser= new JDateChooser();
        dateChooser.setBounds(260,200,400,30);
        add(dateChooser);
        
        Gender= new JLabel("Gender:");
        Gender.setFont(new Font("Arival",Font.BOLD,20));
        Gender.setBounds(75,240,100,30);
        add(Gender);
        
        male= new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(260,240,100,30);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(380,240,100,30);
        add(female);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        Email= new JLabel("Email:");
        Email.setFont(new Font("Arival",Font.BOLD,20));
        Email.setBounds(75,280,210,30);
        add(Email);
        
        emailfield = new JTextField();
        emailfield.setBounds(260,280,400,30);
        add(emailfield);
        
        MaritalStatus= new JLabel("Marital Status:");
        MaritalStatus.setFont(new Font("Arival",Font.BOLD,20));
        MaritalStatus.setBounds(75,320,230,30);
        add(MaritalStatus);
        
        Married= new JRadioButton("Married");
        Married.setBackground(Color.WHITE);
        Married.setBounds(260,320,100,30);
        add(Married);
        
        UnMarried= new JRadioButton("UnMarried");
        UnMarried.setBackground(Color.WHITE);
        UnMarried.setBounds(380,320,100,30);
        add(UnMarried);
        
        
        
        ButtonGroup marriedgroup= new ButtonGroup();
        marriedgroup.add(Married);
        marriedgroup.add(UnMarried);
      
        
        
        Address= new JLabel("Address:");
        Address.setFont(new Font("Arival",Font.BOLD,20));
        Address.setBounds(75,360,100,30);
        add(Address);
        
        Addressfield = new JTextField();
        Addressfield.setBounds(260,360,400,30);
        add(Addressfield);
        
        City= new JLabel("City:");
        City.setFont(new Font("Arival",Font.BOLD,20));
        City.setBounds(75,400,100,30);
        add(City);
        
        Cityfield = new JTextField();
        Cityfield.setBounds(260,400,400,30);
        add(Cityfield);
        
        State= new JLabel("State:");
        State.setFont(new Font("Arival",Font.BOLD,20));
        State.setBounds(75,440,230,30);
        add(State);
        
        Statefield = new JTextField();
        Statefield.setBounds(260,440,400,30);
        add(Statefield);
        
        Pin= new JLabel("Pin Code:");
        Pin.setFont(new Font("Arival",Font.BOLD,20));
        Pin.setBounds(75,480,100,30);
        add(Pin);
        
        Pinfield = new JTextField();
        Pinfield.setBounds(260,480,400,30);
        add(Pinfield);
        
        save= new JButton("NEXT");
        save.setFont(new Font("Arival",Font.BOLD,20));
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(560,550,100,30);
        save.addActionListener(this);
        add(save);
        
        setVisible(true);
        setSize(800,700);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    
    public static void main(String[] args){
        new Signup1();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       String App_Number= ""+random;
       String App_Name = namefield.getText();
       String Father_Name= fatherfield.getText();
       String DOB= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
       String Gender_Details= null;
       if(male.isSelected()){
           Gender_Details= "Male";
       }
       else if(female.isSelected()){
           Gender_Details= "Female";
       }
       String Email_Details= emailfield.getText();
       String Married_Status= null;
       if(Married.isSelected()){
           Married_Status= "Married";
       }
       else if(UnMarried.isSelected()){
           Married_Status= "UnMarried";
       }
       String Address_Details= Addressfield.getText();
       String City_Details= Cityfield.getText();
       String State_Details= Statefield.getText();
       String Pin_Code= Pinfield.getText();
       try{
           if(App_Name.equals("")){
               JOptionPane.showMessageDialog(null, "Enter Your Name");
           }
           else{
               Connection_mysql c = new Connection_mysql();
               String query= "insert into signup values ('"+App_Number+"','"+App_Name+"','"+Father_Name+"','"+DOB+"','"+Gender_Details+"','"+Email_Details+"','"+Married_Status+"','"+Address_Details+"','"+City_Details+"','"+State_Details+"','"+Pin_Code+"')";
               c.s.executeUpdate(query);
               setVisible(false);
               new Signup2(App_Number).setVisible(true);
           }
       }
       catch(Exception v){
           System.out.println(v);
       }
    }
    
}
