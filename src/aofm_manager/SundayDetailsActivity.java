/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aofm_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author REUBEN
 */
public class SundayDetailsActivity extends javax.swing.JFrame {
    final static int NO_OF_COLUMNS = 4;
    ArrayList<SunMeeting> sunMeetingDetails = new ArrayList<>();
    static String editMemberId = "";
    /**
     * Creates new form SundayDetailsActivity
     */
    public SundayDetailsActivity() {
        initComponents();
        super.setTitle("AOFM MANAGER[Sunday Meeting Details]");
        super.setExtendedState(MAXIMIZED_BOTH);
        allDetailsQuery();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public class SunMeeting{
        int id;
        String date;
        int attendance;
        float offering;

        public SunMeeting(int id, String date, int attendance) {
            this.id = id;
            this.date = date;
            this.attendance = attendance;
            
        }

        public int getId() {
            return id;
        }

        public String getDate() {
            return date;
        }

        public int getAttendance() {
            return attendance;
        }

       
        
    }
    
     private void allDetailsQuery(){
       
        try{
            String userName  = "root";
            String passWord = "";
            String url = "jdbc:mysql://localhost:3306/aofm_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pstmt = con.prepareStatement("select * from sun_attendance order by id desc");
            ResultSet rset = pstmt.executeQuery();
            int searchCheck = 0;
            sunMeetingDetails.clear();
            while(rset.next()){
                int id = rset.getInt("id");
                String date = rset.getString("date");
                int attendance = rset.getInt("number");
                
                SunMeeting sm= new SunMeeting(id, date, attendance);   
                searchCheck = id;
                sunMeetingDetails.add(sm);
                addRowToTable();
             }
            if(searchCheck == 0){
                JOptionPane.showMessageDialog(this,"No Sunday meeting details found","Search Results",2);
            }
               
        }catch(Exception e){
        
        }
    }
    
     public void addRowToTable(){
    
        DefaultTableModel model = (DefaultTableModel) cellMeetingTable.getModel();
        if (cellMeetingTable.getRowCount() > 0) {
                for (int i = cellMeetingTable.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
        Object rowData[] = new Object[NO_OF_COLUMNS];

        for(int x =0; x<sunMeetingDetails.size();x++)
        {

            rowData[0]= x+1;
            rowData[1] = sunMeetingDetails.get(x).getId();
            rowData[2]= sunMeetingDetails.get(x).getDate();
            rowData[3]= sunMeetingDetails.get(x).getAttendance();
            
            model.addRow(rowData);

        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewAllBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        cellMeetingTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        allMemItem = new javax.swing.JMenuItem();
        activeMemItem = new javax.swing.JMenuItem();
        passiveMemItem = new javax.swing.JMenuItem();
        outreachMemItem = new javax.swing.JMenuItem();
        newMemMenu = new javax.swing.JMenu();
        newMemItem = new javax.swing.JMenuItem();
        existMemItem = new javax.swing.JMenuItem();
        cellDataItem = new javax.swing.JMenuItem();
        sunDataItem = new javax.swing.JMenuItem();
        statMenu = new javax.swing.JMenu();
        statMitem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewAllBtn.setText("View All");
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        dateChooser.setToolTipText("Search a particular date");

        cellMeetingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "MEETING ID", "DATE", "ATTENDANCE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cellMeetingTable);

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
        outreachMemItem.setText("Outreach Member");
        outreachMemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outreachMemItemActionPerformed(evt);
            }
        });
        jMenu1.add(outreachMemItem);

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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewAllBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchBtn)
                        .addComponent(viewAllBtn)))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        // TODO add your handling code here:
        dateChooser.setDate(null);
        allDetailsQuery();

    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        if(dateChooser.getDate()!=null){
            try{
                String userName  = "root";
                String passWord = "";
                String url = "jdbc:mysql://localhost:3306/aofm_db";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
                PreparedStatement pstmt = con.prepareStatement("select * from sun_attendance where date =?");
                pstmt.setString(1, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
                ResultSet rset = pstmt.executeQuery();
                int searchCheck = 0;
                sunMeetingDetails.clear();
                while(rset.next()){
                    int id = rset.getInt("id");
                    String date = rset.getString("date");
                    int attendance = rset.getInt("number");
                    float offering = rset.getFloat("offering");

                    SunMeeting sm= new SunMeeting(id, date, attendance);
                    searchCheck = id;
                    sunMeetingDetails.add(sm);
                    addRowToTable();

                }
                if(searchCheck == 0){
                    JOptionPane.showMessageDialog(this,"No results found","Search Results",2);

                }

            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_searchBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SundayDetailsActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SundayDetailsActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SundayDetailsActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SundayDetailsActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SundayDetailsActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem activeMemItem;
    private javax.swing.JMenuItem allMemItem;
    private javax.swing.JMenuItem cellDataItem;
    private javax.swing.JTable cellMeetingTable;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JMenuItem existMemItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newMemItem;
    private javax.swing.JMenu newMemMenu;
    private javax.swing.JMenuItem outreachMemItem;
    private javax.swing.JMenuItem passiveMemItem;
    private javax.swing.JButton searchBtn;
    private javax.swing.JMenu statMenu;
    private javax.swing.JMenuItem statMitem;
    private javax.swing.JMenuItem sunDataItem;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables
}