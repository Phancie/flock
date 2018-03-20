package aofm_manager;

import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public final class writeDbToFile
{
    private Formatter fmt;

    public writeDbToFile() {
        
        create();
        String tempId;
        try{
            String userName  = "root";
            String passWord = "";
            String url = "jdbc:mysql://localhost:3306/aofm_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pstmt = con.prepareStatement("select * from register where not status ='Outreach'  ");
            ResultSet rset = pstmt.executeQuery();
            int x = 1;
            while(rset.next()){
                tempId = String.valueOf(x)+"."+rset.getString("fname")+" "+rset.getString("mname")+" "+rset.getString("lname");
                write(tempId);
                x++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "An error occured while getting your members. Please make sure your server is running ", "Members List Error", 0);
        }
        
        closeFile();
    }
    
    
//     public static void main(String []args){
//        writeDbToFile w = new writeDbToFile();
//        w.create();
//        String tempId;
//        try{
//            String userName  = "root";
//            String passWord = "";
//            String url = "jdbc:mysql://localhost:3306/aofm_db";
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
//            PreparedStatement pstmt = con.prepareStatement("select * from register where not status ='Outreach'  ");
//            ResultSet rset = pstmt.executeQuery();
//            int x = 1;
//            while(rset.next()){
//                tempId = String.valueOf(x)+"."+rset.getString("fname")+" "+rset.getString("mname")+" "+rset.getString("lname");
//                w.write(tempId);
//                x++;
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "An error occured while getting your members. Please make sure your server is running ", "Members List Error", 0);
//        }
//        
//        w.closeFile();
//    }
    
    public void create()
    {
        
        try
        {
            File file = new File("C:\\Flock_Management_System\\identities.txt");
            if(file.exists()){
                file.delete();
            }
            FileWriter f = new FileWriter("C:\\Flock_Management_System\\identities.txt",true);
            fmt = new Formatter(f);
            //System.out.println("Successful");
        }
        catch(Exception e){}
        
    }
    public void write(String id)
    {
        fmt.format("%s\n",id);
    }
    
    public void closeFile()
    {
        fmt.close();
    }
    
    
}