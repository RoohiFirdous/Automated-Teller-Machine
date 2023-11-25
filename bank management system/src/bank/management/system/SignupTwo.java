package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class SignupTwo extends JFrame implements ActionListener{
   
    long random;
    JLabel additionaldetails,religionl,categoryl,incomel,educationl,qualification,occupationl,passportl,sinl,senior, existing;
    JTextField passporttf, sintf;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox religion, category, income, education, occupation;
    String formno;
   
    SignupTwo(String formno){
        this.formno = formno;
        
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        
        additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 600,30);
        add(additionaldetails);
        
        religionl = new JLabel("Religion:");
        religionl.setFont(new Font("Raleway", Font.BOLD, 20));
        religionl.setBounds(100, 140, 100,30);
        add(religionl);
        
        String valReligion[] = {"Muslim","Christian","Hindu","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        categoryl = new JLabel("Category:");
        categoryl.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryl.setBounds(100, 190, 200, 30);
        add(categoryl);
        
        String valCategory[] = {"General", "OBC", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        incomel = new JLabel("Income:");
        incomel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomel.setBounds(100, 240, 200, 30);
        add(incomel);
        
        String valIncome[] = {"NULL", "<25000$", "25000$-50000$", ">50000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        educationl = new JLabel("Educational");
        educationl.setFont(new Font("Raleway", Font.BOLD, 20));
        educationl.setBounds(100, 290, 200, 30);
        add(educationl);
        
        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);
        
        String valEducation[] = {"High-School", "Associate", "Bachelor's", "Masters", "PHD"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        occupationl = new JLabel("Occupation:");
        occupationl.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationl.setBounds(100, 390, 200, 30);
        add(occupationl);
        
        String valOccupation[] = {"Business", "Salaried", "Self-Employed", "Student", "Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        passportl = new JLabel("Passport Number:");
        passportl.setFont(new Font("Raleway", Font.BOLD, 20));
        passportl.setBounds(100, 440, 200, 30);
        add(passportl);
        
        passporttf = new JTextField();
        passporttf.setFont(new Font("Raleway", Font.BOLD, 14));
        passporttf.setBounds(300, 440, 400, 30);
        add(passporttf);
        
        sinl = new JLabel("SIN:");
        sinl.setFont(new Font("Raleway", Font.BOLD, 20));
        sinl.setBounds(100, 490, 200, 30);
        add(sinl);
        
        sintf = new JTextField();
        sintf.setFont(new Font("Raleway", Font.BOLD, 14));
        sintf.setBounds(300, 490, 400, 30);
        add(sintf);
        
        senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno= new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorgroup= new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno= new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existinggroup= new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);  
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        } else if(sno.isSelected()){
            seniorcitizen="No";
        } 
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        } else if(eno.isSelected()){
            existingaccount="No";
        } 
        
        String spassport= passporttf.getText();
        String ssin = sintf.getText();
        
        try{
            Conn c= new Conn();
            String query= "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+spassport+"','"+ssin+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
   
    public static void main(String args[]){
        new SignupTwo("");
    }
}


