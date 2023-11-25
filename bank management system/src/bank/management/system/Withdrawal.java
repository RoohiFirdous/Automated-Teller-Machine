
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pinno;
    
    Withdrawal(String pinno){
        this.pinno = pinno;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);
        
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS $10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(170,300,400,20);
        l3.add(l1);
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(190,400,400,20);
        l3.add(l2);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(170,350,320,25);
        l3.add(t1);
        
        b1 = new JButton("WITHDRAW");
        b1.setBounds(355,485,150,30);
        l3.add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("BACK");
        b2.setBounds(355,520,150,30);
        l3.add(b2);
        b2.addActionListener(this);
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            
            if(ae.getSource()==b1){
                
                String amount = t1.getText();
                Date date = new Date();
            
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn conn = new Conn(); 
                    String query = "insert into bank values('"+pinno+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                    conn.s.executeUpdate(query);
                    //ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                  /*  int balance = 0;
                    while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    } */
                    
                    
                    JOptionPane.showMessageDialog(null, "$ "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pinno).setVisible(true);
            }
        }catch(Exception e){
                System.out.println(e);
        }
            
    }  
    
    public static void main(String[] args){
        new Withdrawal("").setVisible(true);
    }
}

