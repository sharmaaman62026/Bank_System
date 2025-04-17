
package ATM_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Signup2 extends JFrame implements ActionListener{
    JComboBox Religiontext,Categorytext,EducationText,OccupationText;
    JRadioButton yes,No;
    JLabel Additional_Details,Religion,Category,Income,Educational,Occupation,PanCard,Aadhar,SeniorCitizen,ExistingAccount;
    JTextField IncomeText,Pantext,AddharText,ExistingText;
    JButton Next;
    String App_Number;
    Signup2(String App_Number){
        this.App_Number=App_Number;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        Additional_Details= new JLabel("Page 2: Additional Details");
        Additional_Details.setFont(new Font("Osward",Font.BOLD,25));
        Additional_Details.setBounds(180,50,300,30);
        add(Additional_Details);
        
        
        Religion= new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,15));
        Religion.setBounds(50,120,200,30);
        add(Religion);
        
        String Religionvalue[]={"Hinduism","Islam","Chirstianity","Sikhism","Judasim"};
        Religiontext= new JComboBox(Religionvalue);
        Religiontext.setBackground(Color.WHITE);
        Religiontext.setBounds(200,120,400,30);
        add(Religiontext);
        
        Category= new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,15));
        Category.setBounds(50,160,100,30);
        add(Category);
        
        String Categoryvalue[]={"GENERAL","OBC","SC","ST","OTHERS"};
        Categorytext= new JComboBox(Categoryvalue);
        Categorytext.setBackground(Color.WHITE);
        Categorytext.setBounds(200,160,400,30);
        add(Categorytext);
        
        Income= new JLabel("Income");
        Income.setFont(new Font("Raleway",Font.BOLD,15));
        Income.setBounds(50,200,100,30);
        add(Income);
        
        IncomeText= new JTextField();
        IncomeText.setFont(new Font("Arival",Font.BOLD,15));
        IncomeText.setBounds(200,200,400,30);
        add(IncomeText);
        
        Educational= new JLabel("Educational:");
        Educational.setFont(new Font("Raleway",Font.BOLD,15));
        Educational.setBounds(50,240,100,30);
        add(Educational);
        
        String Educationvalue[]={"Non-Graduation","Graduation","Matric","Post-Graduation","OTHERS"};
        EducationText= new JComboBox(Educationvalue);
        EducationText.setFont(new Font("Raleway",Font.BOLD,15));
        EducationText.setBounds(200,240,400,30);
        add(EducationText);
       
        Occupation= new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,15));
        Occupation.setBounds(50,280,100,30);
        add(Occupation);
        
        String Occupationvalue[]={"Salaried","Self-Empolyed","Bussiness","Student","Retired","Others"};
        OccupationText= new JComboBox(Occupationvalue);
        OccupationText.setFont(new Font("Raleway",Font.BOLD,15));
        OccupationText.setBounds(200,280,400,30);
        add(OccupationText);
        
        PanCard= new JLabel("Pan Number:");
        PanCard.setFont(new Font("Raleway",Font.BOLD,15));
        PanCard.setBounds(50,320,100,30);
        add(PanCard);
        
        Pantext= new JTextField();
        Pantext.setFont(new Font("Raleway",Font.BOLD,15));
        Pantext.setBounds(200,320,400,30);
        add(Pantext);
        
        Aadhar= new JLabel("Aadhar Number:");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        Aadhar.setBounds(50,360,200,30);
        add(Aadhar);
        
        AddharText= new JTextField();
        AddharText.setFont(new Font("Raleway",Font.BOLD,15));
        AddharText.setBounds(200,360,400,30);
        add(AddharText);
        
        SeniorCitizen= new JLabel("Senior Citizen:");
        SeniorCitizen.setFont(new Font("Raleway",Font.BOLD,15));
        SeniorCitizen.setBounds(50,400,200,30);
        add(SeniorCitizen);
        
        yes= new JRadioButton("YES");
        yes.setBackground(Color.WHITE);
        yes.setBounds(200,400,70,30);
        add(yes);
        
        No= new JRadioButton("NO");
        No.setBackground(Color.WHITE);
        No.setBounds(270,400,70,30);
        add(No);
        
        ButtonGroup SeniorCit= new ButtonGroup();
        SeniorCit.add(yes);
        SeniorCit.add(No);
        
        ExistingAccount= new JLabel("ExistingAccount:");
        ExistingAccount.setFont(new Font("Raleway",Font.BOLD,15));
        ExistingAccount.setBounds(50,440,200,30);
        add(ExistingAccount);
        
        ExistingText= new JTextField();
        ExistingText.setFont(new Font("Raleway",Font.BOLD,15));
        ExistingText.setBounds(200,440,400,30);
        add(ExistingText);
        
        Next= new JButton("NEXT");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setFont(new Font("Raleway",Font.BOLD,15));
        Next.setBounds(500,500,100,30);
        Next.addActionListener(this);
        add(Next);
            
        setVisible(true);
        setSize(800,700);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args){
        new Signup2("");
    }
     @Override
    public void actionPerformed(ActionEvent e) {
       String Religio_Name= (String)Religiontext.getSelectedItem();
       String Category_Name= (String)Categorytext.getSelectedItem();
       String Income_Value= IncomeText.getText();
       String Education_details= (String)EducationText.getSelectedItem();
       String Occupation_details= (String)OccupationText.getSelectedItem();
       String Pan_Details= Pantext.getText();
       String Aadhar_Details = AddharText.getText();
       String Senior_Citizen= null;
       if(yes.isSelected()){
           Senior_Citizen="yes";
       }
       else if(No.isSelected()){
           Senior_Citizen= "No";
       }
       String Exitising_Details= ExistingText.getText();
       try{
           Connection_mysql c= new Connection_mysql();
           String query= "insert into signup2 values ('"+App_Number+"','"+Religio_Name+"','"+Category_Name+"','"+Income_Value+"','"+Education_details+"','"+Occupation_details+"','"+Pan_Details+"','"+Aadhar_Details+"','"+Senior_Citizen+"','"+Exitising_Details+"')";
           c.s.executeUpdate(query);
           setVisible(false);
           new Signup3(App_Number).setVisible(true);
       }
       catch(Exception b){
          System.out.println(b);        
       }
    }
}
