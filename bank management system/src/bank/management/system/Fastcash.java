package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pinno;

    Fastcash(String pinno) {
        this.pinno = pinno;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(210,300,700,35);
        l3.add(l1);

        b1 = new JButton("$100");
        b1.setBounds(170,415,150,30);
        l3.add(b1);
        b1.addActionListener(this);
        
        
        b2 = new JButton("$500");
        b2.setBounds(355,415,150,30);
        l3.add(b2);
        b2.addActionListener(this);
        
        
        b3 = new JButton("$1000");
        b3.setBounds(170,450,150,30);
        l3.add(b3);
        b3.addActionListener(this);
              
        b4 = new JButton("$2000");
        b4.setBounds(355,450,150,30);
        l3.add(b4);
        b4.addActionListener(this);
        
        b5 = new JButton("$5000");
        b5.setBounds(170,485,150,30);
        l3.add(b5);
        b5.addActionListener(this);
        
        b6 = new JButton("$10000");
        b6.setBounds(355,485,150,30);
        l3.add(b6);
        b6.addActionListener(this);
        
        b7 = new JButton("BACK");
        b7.setBounds(355,520,150,30);
        l3.add(b7);
        b7.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pinno).setVisible(true);
            }else{
                String amount = ((JButton)ae.getSource()).getText().substring(1); //#100
                Conn c = new Conn();
                try{
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    } 
                    String num = "17";
                    if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    Date date = new Date();
                    String query = "insert into bank values('"+pinno+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$ "+amount+" Debited Successfully");              
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                    
                    
                }
                catch(Exception e){
                    System.out.println(e);
                    
                }      
            }
        

    }

    public static void main(String[] args) {
        new Fastcash("").setVisible(true);
    }
}

