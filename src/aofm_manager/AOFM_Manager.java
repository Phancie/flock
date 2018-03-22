/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aofm_manager;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author REUBEN
 */
public class AOFM_Manager {
    boolean requestOnlineBackup = false;
    /**
     */


    public static void backupDb(){
 
        try{
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "C:\\wamp\\bin\\mysql\\mysql5.5.24\\bin\\mysqldump -e -u root -h localhost aofm_db > c:\\Flock_Management_System\\backup.sql"); //1 & 3

            Process exec = builder.start();
            int retCode = exec.waitFor();
            if (retCode != 0) { //4
                // something went wrong
                InputStream errorStream = exec.getErrorStream();
                byte[] buffer = new byte[errorStream.available()];
                errorStream.read(buffer);

                System.out.println(new String(buffer));
                
                JOptionPane.showMessageDialog(null, "Backup was not able to complete. Contact developer if problem persits", "Backup Message", 0);
            }
            else{
                //JOptionPane.showMessageDialog(null, "Backup Successful", "Backup Message", 1);
            }
        }catch(Exception e){
            System.err.println(e);
        }
        

    }  
    
    
    
    
}
