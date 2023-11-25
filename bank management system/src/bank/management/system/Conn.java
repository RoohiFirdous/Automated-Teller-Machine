package bank.management.system;
import java.sql.*;

public class Conn{
    
    Connection c;
    Statement s;
    
    //constructor
    public Conn(){
        try{
            
            //Class.forName(com.mysql.cj.jdbc.Driver);
            //Create Connection
            //default it runs on local host 3306
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "Firdous@1016");
            //create statement
            s= c.createStatement();
            
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

