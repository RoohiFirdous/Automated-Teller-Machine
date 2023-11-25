
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pinno;
    
    PinChange(String pinno){
        this.pinno = pinno;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 900, 900);
        add(l4);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(250,280,500,35);
        l4.add(l1);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(165,320,180,25);
        l4.add(l2);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(330,320,180,25);
        l4.add(t1);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(165,360,180,25);
        l4.add(l3);
             
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(330,360,180,25);
        l4.add(t2);
        
        b1 = new JButton("CHANGE");
        b1.setBounds(355,485,150,30);
        l4.add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("BACK");
        b2.setBounds(355,520,150,30);
        l4.add(b2);
        b2.addActionListener(this);
         
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{        
                String npin = t1.getText(); //new pin
                String rpin = t2.getText(); //re enter pin

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinno+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinno+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinno+"' ";

                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==b2){
                new Transactions(pinno).setVisible(true);
                setVisible(false);
            }
    }
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
