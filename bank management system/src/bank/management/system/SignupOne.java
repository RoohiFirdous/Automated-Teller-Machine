package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class SignupOne extends JFrame implements ActionListener{
   
    
    JLabel formno,persondetails,name,fname,dob,gender,email,marital,city,address,state, pincode;
    JTextField nametf,fnametf,dobtf,emailtf,addresstf,citytf,statetf, pincodetf;
    JRadioButton male,female,other, single,married;
    JButton next;
    JDateChooser dateChooser;
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String random = "" + Math.abs(first4);
   
    SignupOne(){
        
        
        
        setLayout(null);
        
        //setTitle("NEW ACCOUNT APPLICATION FORM");
        
        
       /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 100, 100);
        add(l11);
        */
        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35));
        formno.setBounds(140, 20, 600,40);
        add(formno);
        
        persondetails = new JLabel("Page 1: Personal Details");
        persondetails.setFont(new Font("Raleway", Font.BOLD, 22));
        persondetails.setBounds(290, 80, 600,30);
        add(persondetails);
        
        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 80,30);
        add(name);
        
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 14));
        nametf.setBounds(300,140,400, 30);
        add(nametf);
        
        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametf.setBounds(300, 190, 400, 30);
        add(fnametf);
        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
	//dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	dateChooser.setForeground(new Color(105, 105, 105));
	dateChooser.setBounds(300, 240, 400, 30);
	add(dateChooser);
        
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other= new JRadioButton("Other");
        other.setBounds(570,290,160,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtf.setBounds(300, 340, 400, 30);
        add(emailtf);
        
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        single= new JRadioButton("Single");
        single.setBounds(300,390,60,30);
        single.setBackground(Color.WHITE);
        add(single);
        
        married= new JRadioButton("Married");
        married.setBounds(450,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(single);
        maritalgroup.add(married);
        
        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametf.setBounds(300, 140, 400, 30);
        add(fnametf);
        
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway", Font.BOLD, 14));
        addresstf.setBounds(300, 440, 400, 30);
        add(addresstf);
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 14));
        citytf.setBounds(300, 490, 400, 30);
        add(citytf);
        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 14));
        statetf.setBounds(300, 540, 400, 30);
        add(statetf);
        
        pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodetf = new JTextField();
        pincodetf.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodetf.setBounds(300, 590, 400, 30);
        add(pincodetf);
        
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
        
        String formno = random;
        String name = nametf.getText();
        String fname = fnametf.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        } else if(female.isSelected()){
            gender="Female";
        } else if(other.isSelected()){
            gender="Other";
        }
        
        String email = emailtf.getText();
        String marital = null;
        if(single.isSelected()){
            marital="Single";
        } else if(married.isSelected()){
            marital="Married";
        }
        
        String address= addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pincode = pincodetf.getText();
        
        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c= new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
   
    public static void main(String args[]){
        new SignupOne();
    }
}