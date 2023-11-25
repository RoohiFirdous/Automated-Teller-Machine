package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    
    Login(){
        setTitle("Automatic Teller Machine");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new JLabel("Welcome to Canada Bank ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 40, 600, 40);
        add(text);
        
        JLabel cardno=new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(120, 150, 600, 40);
        add(cardno);
        
        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,155,230,30);
        cardtextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtextfield);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(120, 200, 600, 40);
        add(pin);
        
        pintextfield = new JPasswordField();
        pintextfield.setBounds(300,205,230,30);
        pintextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintextfield);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){      
            if(ae.getSource()==clear){
                cardtextfield.setText("");
                pintextfield.setText("");              
            }else if(ae.getSource()==login){               
                Conn conn=new Conn();
                String cardno  = cardtextfield.getText();
                String pinno  = pintextfield.getText();
                String query  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pinno+"'";
                           
                try{
                    ResultSet rs = conn.s.executeQuery(query);                    
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinno).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }                   
                }
                catch(Exception e){
                    System.out.println(e); 
                }
                               
            }else if(ae.getSource()==signup){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
    }
        
    public static void main(String args[]){
        new Login().setVisible(true);
    }
    
}
