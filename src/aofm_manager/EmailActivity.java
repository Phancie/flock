/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aofm_manager;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author REUBEN
 */
public class EmailActivity extends javax.swing.JFrame {
    static String editMemberId = "";
    /**
     * Creates new form EmailActivity
     */
    public EmailActivity() {
        initComponents();
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

        nameLbl = new javax.swing.JLabel();
        nameFld = new javax.swing.JTextField();
        emailLbl = new javax.swing.JLabel();
        emailFld = new javax.swing.JTextField();
        sendBtn = new javax.swing.JButton();
        yearLbl = new javax.swing.JLabel();
        yearChooser = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLbl.setText("Your Name:");

        emailLbl.setText("Recipient's Email");

        emailFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFldActionPerformed(evt);
            }
        });

        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        yearLbl.setText("Choose a year for the chart");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("EMAIL YOUR AMGC");

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

        cellMeetingItem.setText("Cell Meeting Attendace");
        cellMeetingItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cellMeetingItemActionPerformed(evt);
            }
        });
        jMenu1.add(cellMeetingItem);

        sundayMeetingItem.setText("Sunday Meeting Attendace");
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

        jMenuBar1.add(othersMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sendBtn)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLbl)
                            .addComponent(emailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailFld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(nameFld, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yearLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLbl))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailFld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(yearChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(sendBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFldActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        if(emailFld.getText().isEmpty() || nameFld.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Empty fields detected", "Email Message",0);
            return;
        }
        if(nameFld.getText().length()<3){
            JOptionPane.showMessageDialog(null, "Enter a valid name", "Email Message",0);
            return;
        }
        if(!validate(emailFld.getText())){
            JOptionPane.showMessageDialog(null, "Enter a valid recepient email", "Email Message",0);
            return;
        }
        mail m = new mail(nameFld.getText().trim() ,emailFld.getText().trim());
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

    private void newMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMemItemActionPerformed
        // TODO add your handling code here:
        MainActivity ma = new MainActivity();
        ma.setVisible(true);
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

    private void cellMeetingItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cellMeetingItemActionPerformed
        // TODO add your handling code here:
        CellDetailsActivity cda = new CellDetailsActivity();
        cda.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cellMeetingItemActionPerformed

    private void sundayMeetingItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayMeetingItemActionPerformed
        // TODO add your handling code here:
        SundayAttendanceActivity saa = new SundayAttendanceActivity();
        saa.setVisible(true);
        saa.setVisible(false);
    }//GEN-LAST:event_sundayMeetingItemActionPerformed

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
            return matcher.find();
    }
    
    public final void generateChart(){
        final String cell = "CELL MEETING";
        final String sun = "SUNDAY SERVICE";
        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try{
                    String userName  = "root";
                    String passWord = "";
                    String url = "jdbc:mysql://localhost:3306/aofm_db";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
                    PreparedStatement pstmt = con.prepareStatement("select * from cell_attendance where date like \'%"+yearChooser.getYear()+"%\'");
                    ResultSet rset = pstmt.executeQuery();
                    int x = 1;
                    int id = 0;
                    while(rset.next()){
                        dataset.addValue( rset.getInt("number") , cell , String.valueOf(x) );
                        id = rset.getInt("id");
                        x++;
                    }
                    
                    pstmt = con.prepareStatement("select * from sun_attendance where date like \'%"+yearChooser.getYear()+"%\'");
                    rset = pstmt.executeQuery();
                    int y = 1;
                    while(rset.next()){
                        dataset.addValue( rset.getInt("number") , sun , String.valueOf(y) );
                        id = rset.getInt("id");
                        y++;
                    }
                    if(id==0){
                        JOptionPane.showMessageDialog(null, "No data for the requested period", "Email Message", 2);
                        return;
                    }
                    JFreeChart barChart = ChartFactory.createBarChart( "Annual Micro-Church Growth Chart(AMGC)", "Weeks("+yearChooser.getYear()+")", "Attendance", dataset,
                    PlotOrientation.VERTICAL, true, true, false );
                    int width=1400; /* Width of the image */
                    int height=680; /* Height of the image */ 
                    File BarChart=new File( "c:\\Flock_Management_System\\AMGC.jpeg" );
                    ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
                    
                }catch(Exception e){}       
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
            java.util.logging.Logger.getLogger(EmailActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmailActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmailActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmailActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem activeMemItem;
    private javax.swing.JMenuItem allMemItem;
    private javax.swing.JMenuItem amgcMailItem;
    private javax.swing.JMenuItem cellDataItem;
    private javax.swing.JMenuItem cellMeetingItem;
    private javax.swing.JTextField emailFld;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JMenuItem existMemItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField nameFld;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JMenuItem newMemItem;
    private javax.swing.JMenu newMemMenu;
    private javax.swing.JMenu othersMenu;
    private javax.swing.JMenuItem outreachMemItem;
    private javax.swing.JMenuItem passiveMemItem;
    private javax.swing.JButton sendBtn;
    private javax.swing.JMenu statMenu;
    private javax.swing.JMenuItem statMitem;
    private javax.swing.JMenuItem sunDataItem;
    private javax.swing.JMenuItem sundayMeetingItem;
    private com.toedter.calendar.JYearChooser yearChooser;
    private javax.swing.JLabel yearLbl;
    // End of variables declaration//GEN-END:variables
}
