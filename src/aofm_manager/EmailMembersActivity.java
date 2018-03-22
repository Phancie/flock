/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aofm_manager;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author REUBEN
 */
public class EmailMembersActivity extends javax.swing.JFrame {
    JProgressBar pbar = new JProgressBar();
    static String editMemberId = "";
    String backupEmail;
    boolean requestOnlineBackup  = false;
    /**
     * Creates new form emailMembersActivity
     */
    public EmailMembersActivity() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("flock_icon.jpg")));
        super.setTitle("Flock [Email Your Members List]");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerLbl = new javax.swing.JLabel();
        recLbl = new javax.swing.JLabel();
        recField = new javax.swing.JTextField();
        nameLbl = new javax.swing.JLabel();
        nameFld = new javax.swing.JTextField();
        sendBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        allMemItem = new javax.swing.JMenuItem();
        activeMemItem = new javax.swing.JMenuItem();
        passiveMemItem = new javax.swing.JMenuItem();
        outreachMemItem = new javax.swing.JMenuItem();
        cellMeetingItem = new javax.swing.JMenuItem();
        sundayMeetingItem = new javax.swing.JMenuItem();
        newMemMenu = new javax.swing.JMenu();
        newMemItem = new javax.swing.JMenuItem();
        existMemItem = new javax.swing.JMenuItem();
        cellDataItem = new javax.swing.JMenuItem();
        sunDataItem = new javax.swing.JMenuItem();
        statMenu = new javax.swing.JMenu();
        statMitem = new javax.swing.JMenuItem();
        othersMenu = new javax.swing.JMenu();
        amgcMailItem = new javax.swing.JMenuItem();
        emailMembers = new javax.swing.JMenuItem();
        backupMenu = new javax.swing.JMenu();
        localBackupItem = new javax.swing.JMenuItem();
        onlineBackupItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        headerLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        headerLbl.setText("Email Your The List Of Your Cell Members");

        recLbl.setText("Recipient's Email");

        nameLbl.setText("Your Name");

        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        allMemItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        allMemItem.setText(" All Members");
        allMemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allMemItemActionPerformed(evt);
            }
        });
        jMenu1.add(allMemItem);

        activeMemItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        activeMemItem.setText("Active Members");
        activeMemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeMemItemActionPerformed(evt);
            }
        });
        jMenu1.add(activeMemItem);

        passiveMemItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        passiveMemItem.setText("Passive Members");
        passiveMemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passiveMemItemActionPerformed(evt);
            }
        });
        jMenu1.add(passiveMemItem);

        outreachMemItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        outreachMemItem.setText("Outreach List");
        outreachMemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outreachMemItemActionPerformed(evt);
            }
        });
        jMenu1.add(outreachMemItem);

        cellMeetingItem.setText("Cell Meeting Attendance");
        cellMeetingItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cellMeetingItemActionPerformed(evt);
            }
        });
        jMenu1.add(cellMeetingItem);

        sundayMeetingItem.setText("Sunday Meeting Attendance");
        sundayMeetingItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sundayMeetingItemActionPerformed(evt);
            }
        });
        jMenu1.add(sundayMeetingItem);

        jMenuBar1.add(jMenu1);

        newMemMenu.setText("Edit");

        newMemItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        newMemItem.setText("Add New Member");
        newMemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMemItemActionPerformed(evt);
            }
        });
        newMemMenu.add(newMemItem);

        existMemItem.setText("Update Member's Info");
        existMemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existMemItemActionPerformed(evt);
            }
        });
        newMemMenu.add(existMemItem);

        cellDataItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        cellDataItem.setText("Add Cell Meeting Data");
        newMemMenu.add(cellDataItem);

        sunDataItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        sunDataItem.setText("Add Sunday Service Data");
        sunDataItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunDataItemActionPerformed(evt);
            }
        });
        newMemMenu.add(sunDataItem);

        jMenuBar1.add(newMemMenu);

        statMenu.setText("Statistics");

        statMitem.setText("Generate Annual Statistics");
        statMitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statMitemActionPerformed(evt);
            }
        });
        statMenu.add(statMitem);

        jMenuBar1.add(statMenu);

        othersMenu.setText("Others");

        amgcMailItem.setText("Email AMGC");
        amgcMailItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amgcMailItemActionPerformed(evt);
            }
        });
        othersMenu.add(amgcMailItem);

        emailMembers.setText("Email Your Members List");
        emailMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailMembersActionPerformed(evt);
            }
        });
        othersMenu.add(emailMembers);

        backupMenu.setText("Backup");

        localBackupItem.setText("Local Backup");
        localBackupItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localBackupItemActionPerformed(evt);
            }
        });
        backupMenu.add(localBackupItem);

        onlineBackupItem.setText("Online Backup(Email)");
        onlineBackupItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlineBackupItemActionPerformed(evt);
            }
        });
        backupMenu.add(onlineBackupItem);

        othersMenu.add(backupMenu);

        jMenuBar1.add(othersMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sendBtn)
                                .addContainerGap(194, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameFld, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(recField))
                                .addGap(19, 19, 19))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(headerLbl)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(sendBtn)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        if(nameFld.getText().isEmpty() || recField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields", "Email Message", 0);
            return;
        }
        if(!validate(recField.getText())){
            JOptionPane.showMessageDialog(null, "Enter a valid email", "Email Message", 0);
            return;
        }
        
        new MainWorker().execute();
    }//GEN-LAST:event_sendBtnActionPerformed

    private void allMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allMemItemActionPerformed
        // TODO add your handling code here:
        AllMembersActivity ama = new AllMembersActivity();
        ama.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_allMemItemActionPerformed

    private void activeMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeMemItemActionPerformed
        // TODO add your handling code here:
        ActiveMembersActivity acma = new ActiveMembersActivity();
        acma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_activeMemItemActionPerformed

    private void passiveMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passiveMemItemActionPerformed
        // TODO add your handling code here:
        PassiveMembersActivity pma = new PassiveMembersActivity();
        pma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_passiveMemItemActionPerformed

    private void outreachMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outreachMemItemActionPerformed
        // TODO add your handling code here:
        OutreachMembersActivity oma = new OutreachMembersActivity();
        oma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_outreachMemItemActionPerformed

    private void cellMeetingItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cellMeetingItemActionPerformed
        // TODO add your handling code here:
        CellDetailsActivity cda = new CellDetailsActivity();
        cda.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cellMeetingItemActionPerformed

    private void sundayMeetingItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayMeetingItemActionPerformed
        // TODO add your handling code here:
        SundayDetailsActivity sda = new SundayDetailsActivity();
        sda.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sundayMeetingItemActionPerformed

    private void newMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMemItemActionPerformed
        // TODO add your handling code here:
        AllMembersActivity.editMemberId = "";
        MainActivity ma = new MainActivity();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newMemItemActionPerformed

    private void existMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existMemItemActionPerformed
        // TODO add your handling code here:

        int flag = 1;
        while(flag ==1){

            JTextField idField = new JTextField();
            Object [] obj = {"Enter Member's ID:\n\n",idField};
            Object stringArray[]={"OK","Cancel"};
            int dialog = JOptionPane.showOptionDialog(null, obj, "Enter Member's ID", JOptionPane.YES_NO_OPTION,3, null, stringArray, obj);
            if(dialog==JOptionPane.YES_OPTION){
                //FLAG IS SET TO 0 HERE SO THAT IT DOESN'T RE RUN EVEN WHEN CONDITION IS FALSE
                flag = 0;
                editMemberId = idField.getText();
                if(editMemberId.length()!=0)
                {
                    try{
                        String userName  = "root";
                        String passWord = "";
                        String url = "jdbc:mysql://localhost:3306/aofm_db";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
                        String query = "select * from register where id ="+editMemberId;
                        System.err.println(query);
                        PreparedStatement pstmt = con.prepareStatement(query);
                        ResultSet rset = pstmt.executeQuery();
                        String id="";
                        String fname = "";
                        while(rset.next()){
                            id = rset.getString("id");
                            fname = rset.getString(2);
                        }
                        if(!id.isEmpty()){
                            flag = 0;
                            AllMembersActivity.editMemberId = editMemberId ;
                            MainActivity ma = new MainActivity();
                            ma.setVisible(true);
                            this.setVisible(false);

                        }else{
                            JOptionPane.showMessageDialog(null, "ID is invalid. Please enter a valid ID","ID Error",0);
                            flag = 1;
                        }

                    }catch(Exception e){}

                }
                else if(editMemberId.length()==0){
                    JOptionPane.showMessageDialog(null, "No ID Entered", "Member ID", 0);
                    flag = 1;
                }
            }else{
                flag = 0;
            }

        }
    }//GEN-LAST:event_existMemItemActionPerformed

    private void sunDataItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunDataItemActionPerformed
        // TODO add your handling code here:
        SundayAttendanceActivity saa = new SundayAttendanceActivity();
        saa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sunDataItemActionPerformed

    private void statMitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statMitemActionPerformed
        // TODO add your handling code here:
        StatDataActivity sda = new StatDataActivity();
        sda.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_statMitemActionPerformed

    private void amgcMailItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amgcMailItemActionPerformed
        // TODO add your handling code here:
        EmailActivity ea = new EmailActivity();
        ea.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_amgcMailItemActionPerformed

    private void emailMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailMembersActionPerformed
        // TODO add your handling code here:
        EmailMembersActivity ema = new EmailMembersActivity();
        ema.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_emailMembersActionPerformed

    private void localBackupItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localBackupItemActionPerformed
        //backupDb();
        new MainWorker().execute();
    }//GEN-LAST:event_localBackupItemActionPerformed

    private void onlineBackupItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlineBackupItemActionPerformed
        // TODO add your handling code here:
        int flag = 1;
        while(flag==1){
            JTextField emailField = new JTextField();
            Object [] obj = {"Enter Your Email:\n\n",emailField};
            Object stringArray[]={"OK","Cancel"};
            int dialog = JOptionPane.showOptionDialog(null, obj, "Enter Member's ID", JOptionPane.YES_NO_OPTION,3, null, stringArray, obj);
            if(dialog==JOptionPane.YES_OPTION){
                //FLAG IS SET TO 0 HERE SO THAT IT DOESN'T RE RUN EVEN WHEN CONDITION IS FALSE
                flag = 0;
                backupEmail = emailField.getText();
                if(!backupEmail.isEmpty()){
                    if(validate(backupEmail)){
                        requestOnlineBackup = true;
                        new MainWorker().execute();

                    }else{
                        JOptionPane.showMessageDialog(null,"Enter a valid email", "Online Backup Message", 0);
                        flag = 1;
                    }
                }
            }else{
                flag = 0;
            }
        }
    }//GEN-LAST:event_onlineBackupItemActionPerformed

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
            return matcher.find();
    }
    
    
    class MainWorker extends SwingWorker<Integer, Integer>{
        
        @Override
        protected Integer doInBackground() throws Exception
        {
            pbar.setStringPainted(true);
            pbar.setIndeterminate(true);
            writeDbToFile wd = new writeDbToFile();
            String attachments[] = {"c:\\Flock_Management_System\\identities.txt"}; 
        
            // Recipient's email ID needs to be mentioned. 
            //String to = "busben97@gmail.com"; 
            // Sender's email ID needs to be mentioned 
            String from = "flockmanagment@gmail.com"; 
            //final String username = "manishaspatil";
            //change accordingly 
            final String password = "psalm231";
            //change accordingly 
            // Assuming you are sending email through relay.jangosmtp.net 
            Properties props = System.getProperties();
            String host = "smtp.gmail.com";
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", password);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            // Get the Session object. 
            Session session = Session.getInstance(props, new javax.mail.Authenticator() 
            { 
                @Override
                protected PasswordAuthentication getPasswordAuthentication() 
                { 
                    return new PasswordAuthentication(from, password);
                }
            });

            try 
            { 
            // Create a default MimeMessage object. 
            Message message = new MimeMessage(session); 
            // Set From: header field of the header. 
            message.setFrom(new InternetAddress(from)); // Set To: header field of the header.

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recField.getText())); 
            // Set Subject: header field 
            message.setSubject("CELL MEMBERS LIST"); 
            // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart(); 
            // Now set the actual message 
            String messageBody = "Hello,\nPlease find the attached file of "+nameFld.getText()+"\'s cell members list .\nNB: This email is automated please do not reply as you may not get any feedback.\n\nThank You.\nThe Flock Team";
            messageBodyPart.setText(messageBody); 
            // Create a multipar message 
            Multipart multipart = new MimeMultipart(); 
            // Set text message part 
            multipart.addBodyPart(messageBodyPart); 
            // Part two is attachment 
            for(int i = 0; i < attachments.length; i++)
            {
                
                messageBodyPart = new MimeBodyPart(); 
                String filename = attachments[i]; 
                DataSource source = new FileDataSource(filename); 
                messageBodyPart.setDataHandler(new DataHandler(source)); 
                messageBodyPart.setFileName(filename); 
                multipart.addBodyPart(messageBodyPart); 
                System.out.println(filename);
            }
            // Send the complete message parts 
            message.setContent(multipart); 
            // Send message 
            Transport.send(message); 
            JOptionPane.showMessageDialog(null,"Email sent Successfully!", "Email Message", 1); 
            recField.setText("");
            nameFld.setText("");
        } 
        catch (MessagingException e) 
        { 
            JOptionPane.showMessageDialog(null, "An error occured while sending email.\nPlease make there is an active internet connection","Email Message", 0);
            throw new RuntimeException(e);    
        }
            return 42;
        }

        @Override
        protected void done()
        {
            pbar.setIndeterminate(false);
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmailMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmailMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmailMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmailMembersActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem activeMemItem;
    private javax.swing.JMenuItem allMemItem;
    private javax.swing.JMenuItem amgcMailItem;
    private javax.swing.JMenu backupMenu;
    private javax.swing.JMenuItem cellDataItem;
    private javax.swing.JMenuItem cellMeetingItem;
    private javax.swing.JMenuItem emailMembers;
    private javax.swing.JMenuItem existMemItem;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem localBackupItem;
    private javax.swing.JTextField nameFld;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JMenuItem newMemItem;
    private javax.swing.JMenu newMemMenu;
    private javax.swing.JMenuItem onlineBackupItem;
    private javax.swing.JMenu othersMenu;
    private javax.swing.JMenuItem outreachMemItem;
    private javax.swing.JMenuItem passiveMemItem;
    private javax.swing.JTextField recField;
    private javax.swing.JLabel recLbl;
    private javax.swing.JButton sendBtn;
    private javax.swing.JMenu statMenu;
    private javax.swing.JMenuItem statMitem;
    private javax.swing.JMenuItem sunDataItem;
    private javax.swing.JMenuItem sundayMeetingItem;
    // End of variables declaration//GEN-END:variables
}
