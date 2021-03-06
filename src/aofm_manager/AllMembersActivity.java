/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aofm_manager;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author REUBEN
 */
public class AllMembersActivity extends javax.swing.JFrame implements TableModelListener {
    final static int NO_OF_COLUMNS = 9;
    ArrayList<AllMembersDetails> allUserDetails = new ArrayList<>();
    static String editMemberId = ""; 
    boolean requestOnlineBackup  = false;
    String backupEmail = "";  
    JProgressBar progressBar;
    /**
     * Creates new form QueryActivity
     */
    public AllMembersActivity() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("flock_icon.jpg")));
        super.setTitle("Flock [All Members]");
        super.setExtendedState(MAXIMIZED_BOTH);
        allDetailsQuery();
        allMembersTable.getModel().addTableModelListener(AllMembersActivity.this);
        
        File dir = new File("c:\\Flock Management System");
        if (!dir.exists()) {
            dir.mkdir();
        }
        String path = new ImageIcon(AllMembersActivity.class.getResource("defaultImg.png")).toString();
        System.err.println(path);
        
    }
    
    private void allDetailsQuery(){
       
        try{
            String userName  = "root";
            String passWord = "";
            String url = "jdbc:mysql://localhost:3306/aofm_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pstmt = con.prepareStatement("select * from register where not status ='Outreach' ");
            ResultSet rset = pstmt.executeQuery();
            String searchCheck = "";
            allUserDetails.clear();
            while(rset.next()){
                String id = rset.getString("id");
                String fname = rset.getString("fname");
                String mname = rset.getString("mname");
                String lname = rset.getString("lname");
                String dob = rset.getString("dob");
                String phone = rset.getString("phone");
                String area = rset.getString("area");
                String status = rset.getString("status");
                searchCheck = id;
                AllMembersDetails amd= new AllMembersDetails(id, fname, mname, lname, dob, phone, area, status);
                
                allUserDetails.add(amd);
                addRowToTable();
             }
            if(searchCheck.equals("")){
                JOptionPane.showMessageDialog(this, "No member found", "Members Details", 2);
            }
                
        }catch(Exception e){
        
        }
    }
    
    public void addRowToTable(){
    
        DefaultTableModel model = (DefaultTableModel) allMembersTable.getModel();
        if (allMembersTable.getRowCount() > 0) {
                for (int i = allMembersTable.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
        Object rowData[] = new Object[NO_OF_COLUMNS];

        for(int x =0; x<allUserDetails.size();x++)
        {

            rowData[0]= x+1;
            rowData[1] = allUserDetails.get(x).getId();
            rowData[2]= allUserDetails.get(x).getFname();
            rowData[3]= allUserDetails.get(x).getMname();
            rowData[4]= allUserDetails.get(x).getLname();
            rowData[5]= allUserDetails.get(x).getDob();
            rowData[6]= allUserDetails.get(x).getPhone();
            rowData[7]= allUserDetails.get(x).getArea();
            rowData[8]= allUserDetails.get(x).getStatus();
            model.addRow(rowData);

        }
        
}

    public void updater(String tempCol, Object tempId, Object actVal) {
        try{
                //System.err.println("In updater");
                String userName  = "root";
                String passWord = "";
                String url = "jdbc:mysql://localhost:3306/aofm_db";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
                String query = "update register set "+tempCol+"=\'"+actVal+"\' where id ="+tempId;
                //System.err.println(query);
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.executeUpdate();
            }catch(Exception e){System.err.println("Error "+e);}
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        allMembersTable = new javax.swing.JTable();
        dp = new javax.swing.JLabel();
        viewAllBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        searchFld = new javax.swing.JTextField();
        searchCateg = new javax.swing.JComboBox();
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

        allMembersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "MEMBER ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "DATE OF BIRTH", "PHONE NUMBER", "AREA", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        allMembersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allMembersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(allMembersTable);
        if (allMembersTable.getColumnModel().getColumnCount() > 0) {
            allMembersTable.getColumnModel().getColumn(0).setMinWidth(70);
            allMembersTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            allMembersTable.getColumnModel().getColumn(1).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            allMembersTable.getColumnModel().getColumn(2).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            allMembersTable.getColumnModel().getColumn(3).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            allMembersTable.getColumnModel().getColumn(4).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            allMembersTable.getColumnModel().getColumn(5).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(5).setPreferredWidth(150);
            allMembersTable.getColumnModel().getColumn(6).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(6).setPreferredWidth(150);
            allMembersTable.getColumnModel().getColumn(7).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(7).setPreferredWidth(150);
            allMembersTable.getColumnModel().getColumn(8).setMinWidth(150);
            allMembersTable.getColumnModel().getColumn(8).setPreferredWidth(150);
        }

        dp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aofm_manager/defaultImg.png"))); // NOI18N

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

        searchCateg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Name", "Middle Name", "Last Name", "Phone Number","Member ID" }));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(dp)
                .addGap(87, 87, 87)
                .addComponent(viewAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewAllBtn)
                            .addComponent(searchBtn)
                            .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newMemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMemItemActionPerformed
        // TODO add your handling code here:
        AllMembersActivity.editMemberId = "";
        MainActivity ma = new MainActivity();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newMemItemActionPerformed

    private void allMembersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allMembersTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = allMembersTable.getSelectionModel().getMaxSelectionIndex();
        Object memberId = allMembersTable.getValueAt(selectedRow, 1);
        
        try{
            String userName  = "root";
            String passWord = "";
            String url = "jdbc:mysql://localhost:3306/aofm_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pstmt = con.prepareStatement("select image from register where id ="+memberId);
            ResultSet rset = pstmt.executeQuery();     
            while(rset.next()){ 
            InputStream is = rset.getBinaryStream("image");
            BufferedImage bimage = null;
            bimage =ImageIO.read(is);
            Image img = bimage;
            Image newImage = img.getScaledInstance(dp.getWidth(), dp.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ico = new ImageIcon(newImage);
            dp.setIcon(ico);
        }
        }catch(Exception e){}
    }//GEN-LAST:event_allMembersTableMouseClicked

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        // TODO add your handling code here:
        allDetailsQuery();
        dp.setIcon(new javax.swing.ImageIcon(getClass().getResource("defaultImg.png")));
        searchFld.setText("");
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        if(searchFld.getText().length()>0){
            
            
            try{
                
                String userName  = "root";
                String passWord = "";
                String url = "jdbc:mysql://localhost:3306/aofm_db";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection(url,userName,passWord);
                String colName="", searchVal = "";
                if(searchCateg.getSelectedIndex()==0){
                    colName = "fname"; 
                }
                if(searchCateg.getSelectedIndex()==1){
                    colName = "mname"; 
                }
                if(searchCateg.getSelectedIndex()==2){
                    colName = "lname"; 
                }
                if(searchCateg.getSelectedIndex()==3){
                    colName = "phone"; 
                }
                if(searchCateg.getSelectedIndex()==4){
                    colName = "id"; 
                }
                searchVal = searchFld.getText();
                String query = "select * from register where "+colName+" like \'%"+searchVal+"%\'";
                if(colName.equals("id")){
                    query = "select * from register where "+colName+" =\'"+searchVal+"\'";
                }
                System.err.println(query);
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rset = pstmt.executeQuery();
                allUserDetails.clear();
                String searchCheck = "";
                while(rset.next()){
                    String id = rset.getString("id");
                    String fname = rset.getString("fname");
                    String mname = rset.getString("mname");
                    String lname = rset.getString("lname");
                    String dob = rset.getString("dob");
                    String phone = rset.getString("phone");
                    String area = rset.getString("area");
                    String status = rset.getString("status");
                    searchCheck = fname;
                    AllMembersDetails amd = new AllMembersDetails(id, fname, mname, lname, dob, phone, area, status);
                    allUserDetails.add(amd);
                    addRowToTable();
                    
                }
                if(searchCheck.equals("")){
                    JOptionPane.showMessageDialog(this,"No results found","Search Results",2);
                }
                
                    //allUserDetails.clear();
            }catch(ClassNotFoundException | SQLException e){System.err.println("Error "+e);}
        }
    }//GEN-LAST:event_searchBtnActionPerformed

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

    private void amgcMailItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amgcMailItemActionPerformed
        // TODO add your handling code here:
        EmailActivity ea = new EmailActivity();
        ea.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_amgcMailItemActionPerformed

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
    
    private void emailMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailMembersActionPerformed
        // TODO add your handling code here:
            EmailMembersActivity ema = new EmailMembersActivity();
            ema.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_emailMembersActionPerformed

    
  
    
    class MainWorker extends SwingWorker<Integer, Integer>{
        
        @Override
        protected Integer doInBackground() throws Exception
        {
            progressBar.setStringPainted(true);
            progressBar.setIndeterminate(true);
            AOFM_Manager.backupDb();
            if(requestOnlineBackup == true){
                mailBackupFile mbf = new mailBackupFile(backupEmail);
            }
            
            return 42;
        }

        @Override
        protected void done()
        {
            try
            {
                JOptionPane.showMessageDialog(null, "Backup Successful", "Backup Message", 1); 
            }
            catch (Exception e)
            {
            }
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
            java.util.logging.Logger.getLogger(AllMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllMembersActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllMembersActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem activeMemItem;
    private javax.swing.JMenuItem allMemItem;
    private javax.swing.JTable allMembersTable;
    private javax.swing.JMenuItem amgcMailItem;
    private javax.swing.JMenu backupMenu;
    private javax.swing.JMenuItem cellDataItem;
    private javax.swing.JMenuItem cellMeetingItem;
    private javax.swing.JLabel dp;
    private javax.swing.JMenuItem emailMembers;
    private javax.swing.JMenuItem existMemItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem localBackupItem;
    private javax.swing.JMenuItem newMemItem;
    private javax.swing.JMenu newMemMenu;
    private javax.swing.JMenuItem onlineBackupItem;
    private javax.swing.JMenu othersMenu;
    private javax.swing.JMenuItem outreachMemItem;
    private javax.swing.JMenuItem passiveMemItem;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox searchCateg;
    private javax.swing.JTextField searchFld;
    private javax.swing.JMenu statMenu;
    private javax.swing.JMenuItem statMitem;
    private javax.swing.JMenuItem sunDataItem;
    private javax.swing.JMenuItem sundayMeetingItem;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {
       
    }
    
    
}
