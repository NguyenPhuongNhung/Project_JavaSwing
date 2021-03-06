/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_management;

import Main_Screen.Home;
import javax.swing.JFrame;
import com.mysql.jdbc.integration.c3p0.MysqlConnectionTester;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tuan.nguyen1
 */
public class Give_Book extends javax.swing.JFrame {
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;
    private ResultSetMetaData resultSetMetaData;
    private Object ex;
    
    /**
     * Creates new form Give_Book
     */
    public Give_Book() throws SQLException {
        try {
            // Tao truy cap cho driver 
            Class.forName("com.mysql.jdbc.Driver");
            // Tao lenh truy cap den co so du lieu
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Book_Menagement_Project?user=root&password=");
            // De new mot cau lenh
            statement = connection.createStatement();
            initComponents();
            hienthibang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hienthibang() throws SQLException {
        // cau lenh thuc hien:
        String Sql = null;
        String give = tfGivebook.getText();
        String cbGivebook  = this.cbGive.getSelectedItem().toString();
        if(cbGivebook.equals("IdReader")){
            Sql = "Select borrow.ID_READER,borrow.ID_BOOK,bookInfor.BookName,bookInfor.Type,bookInfor.Author,\n" +
            "borrow.DATE_BORROWED,borrow.DATE_GIVE,borrow.NOTES from BOOK_INFORMATION_BORROWED as borrow,\n" +
            "Book_Information as bookInfor where borrow.ID_BOOK = bookInfor.ID_BOOK and borrow.ID_READER ='"+give+"'";
        } else if(cbGivebook.equals("IDBook")){
            Sql = "Select borrow.ID_READER,borrow.ID_BOOK,bookInfor.BookName,bookInfor.Type,bookInfor.Author,\n" +
            "borrow.DATE_BORROWED,borrow.DATE_GIVE,borrow.NOTES from BOOK_INFORMATION_BORROWED as borrow,\n" +
            "Book_Information as bookInfor where borrow.ID_BOOK = bookInfor.ID_BOOK and borrow.ID_BOOK ='"+give+"'";
        }
        // De new mot cau lenh
        statement = connection.createStatement();
        // Thuc hien cau lenh va result lay ve ket qua : 
        resultSet = statement.executeQuery(Sql);
        // lay meta Data
        resultSetMetaData = resultSet.getMetaData();
        // tao mot model cho bang :
        DefaultTableModel model = new DefaultTableModel();
        // lay ve so cot cua bang
        int demcolum = resultSetMetaData.getColumnCount();
        // lay tieu de colum :
        Object[] tieude = new Object[demcolum];
        for (int i = 0; i < demcolum; i++) {
            tieude[i] = resultSetMetaData.getColumnName(i + 1);
        }
        // add model vao bang
        Table.setModel(model);
        // Tieu de cho bang :
        model.setColumnIdentifiers(tieude);
        // Noi dung cho bang
        while (resultSet.next() != false) {
            Object[] noidung = new Object[demcolum];
            for (int i = 0; i < demcolum; i++) {
                noidung[i] = resultSet.getString(i + 1);
            }
            model.addRow(noidung);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tfGivebook = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbGive = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        OK = new javax.swing.JButton();
        Return = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Message = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Adjourn = new javax.swing.JComboBox<>();
        Update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(197, 239, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("   "));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(197, 239, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Return Book", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 30))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Give by :");

        cbGive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IDBook", "IdReader", " " }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Enter Information : ");

        OK.setBackground(new java.awt.Color(51, 255, 255));
        OK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        Return.setBackground(new java.awt.Color(51, 255, 255));
        Return.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Return.setText("Return");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        Home.setBackground(new java.awt.Color(51, 255, 255));
        Home.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tfGivebook, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbGive, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(101, 101, 101))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGive, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGivebook, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 420, 240));

        jPanel3.setBackground(new java.awt.Color(197, 239, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20))); // NOI18N

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Reader", "Id Book", "Book Name", "Type", "Author", "Day Borrow", "Day Give", "Notes"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 890, 220));

        Message.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        Message.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(Message, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 370, 30));

        jPanel5.setBackground(new java.awt.Color(197, 239, 247));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adjourn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 30))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Time Adjourn:");

        Adjourn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 days", "5 days", "1 week", "2 weeks" }));

        Update.setBackground(new java.awt.Color(51, 255, 255));
        Update.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(Adjourn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adjourn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 370, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        Message.setText("");
        String give = tfGivebook.getText();
        String cbGivebook  = this.cbGive.getSelectedItem().toString();
        if(Table.getSelectedRow() == -1)
        {
            if(Table.getRowCount()==0){
                Message.setText("        Table is empty");
            }else{
                Message.setText("     You must select a product ");
            }
        }else{
            try{
                String caulenh = "Delete from BOOK_INFORMATION_BORROWED where ID_BOOK = '" + tfGivebook.getText()+"'";
                System.out.println(caulenh);
                statement.executeUpdate(caulenh);
                hienthibang();
            }catch(SQLException ex){
                Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE,null,ex);
            }
        }        
        
                            String sqlStmt = "UPDATE Book_Information SET "
                                        + "NOTES='"+"Not yet"+"'where ID_Book ='"+give.toString() +"'";;
                            try{
                                statement.executeUpdate(sqlStmt); 
                                
                            }catch (SQLException ex) {
                                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
                            }
        
        
    }//GEN-LAST:event_ReturnActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
       Home home = new Home();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

   String checkBug(String name) {
        String publisher = null;
        String give = tfGivebook.getText();
        String cbGivebook  = this.cbGive.getSelectedItem().toString();
        String Sql = null;
       try {
           Statement stmt = connection.createStatement();
           if(cbGivebook.equals("IDBook")){
                Sql = "Select * From BOOK_INFORMATION_BORROWED  Where ID_BOOK like '"+ give +"%'";
                ResultSet rls = stmt.executeQuery(Sql);
                while (rls.next()) {
                publisher = rls.getString("ID_BOOK");
                }
           }else if(cbGivebook.equals("IdReader")){
                Sql = "Select * From BOOK_INFORMATION_BORROWED  Where ID_READER like '"+ give +"%'";
                ResultSet rls = stmt.executeQuery(Sql);
                while (rls.next()) {
                publisher = rls.getString("ID_READER");
                }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return publisher;
   }
    
    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        Message.setText("");
        String give = tfGivebook.getText();
        String cbGivebook  = this.cbGive.getSelectedItem().toString();
        String Sql = null;
        if(give .equals("")){
            Message.setText("Please enter information into the box !");
        }else if (cbGivebook.equals("IdReader")){
            try {
                if(checkBug(give)== null ){
                    Message.setText("              This id does not exist !");
                }else{
                    Sql =  "Select borrow.ID_READER,borrow.ID_BOOK,bookInfor.BookName,bookInfor.Type,bookInfor.Author,\n" +
                        "borrow.DATE_BORROWED,borrow.DATE_GIVE,borrow.NOTES from BOOK_INFORMATION_BORROWED as borrow,\n" +
                        "Book_Information as bookInfor where borrow.ID_BOOK = bookInfor.ID_BOOK and borrow.ID_READER ='"+give+"'";               
                    PreparedStatement statement = connection.prepareStatement(Sql);
                    ResultSet rs = statement.executeQuery();
                    hienthibang();
                }    
            } catch (SQLException ex) {
                Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(cbGivebook.equals("IDBook")) {
            try {
                if(checkBug(give)== null ){
                    Message.setText("              This id does not exist!");
                }else{
                Sql =  "Select borrow.ID_READER,borrow.ID_BOOK,bookInfor.BookName,bookInfor.Type,bookInfor.Author,\n" +
                        "borrow.DATE_BORROWED,borrow.DATE_GIVE,borrow.NOTES from BOOK_INFORMATION_BORROWED as borrow,\n" +
                        "Book_Information as bookInfor where borrow.ID_BOOK = bookInfor.ID_BOOK and borrow.ID_BOOK ='"+give+"'";               
                        PreparedStatement statement = connection.prepareStatement(Sql);
                        ResultSet rs = statement.executeQuery();
                        hienthibang();
                }        
            } catch (SQLException ex) {
                Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
            
            
    }//GEN-LAST:event_OKActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int click = Table.getSelectedRow();
        String cbGivebook  = this.cbGive.getSelectedItem().toString();
        
        if (cbGivebook.equals("IdReader")){
            String data = (String) Table.getValueAt(click, 0);
            tfGivebook.setText(data);
        }else{
            String data = (String) Table.getValueAt(click, 1);
            tfGivebook.setText(data);
        }
        
    }//GEN-LAST:event_TableMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
       String giahan  = this.Adjourn.getSelectedItem().toString();
    String twodays="Adjuorned 2 days";
    String fivedays="Adjuorned 5 days";
    String oneweek="Adjuorned 1 week";
     String twoweek="Adjuorned 2 weeks";
        String updateSQL = null;
        
        if(giahan .equals("")){
            Message.setText("Please enter information ");
            tfGivebook.requestFocus();
        }else if (giahan.equals("2 days")){
            try {
             updateSQL =  "UPDATE  BOOK_INFORMATION_BORROWED SET  NOTES ='"+twodays+"'"
                     + "where ID_BOOK = '"+tfGivebook.getText()+"'";    
                System.out.println(updateSQL);
                PreparedStatement statement = connection.prepareStatement(updateSQL);
                 statement.executeUpdate(updateSQL);
                  hienthibang();
            } catch (SQLException ex) {
                Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (giahan.equals("5 days")) {
            try {
             updateSQL =  "UPDATE  BOOK_INFORMATION_BORROWED SET  NOTES ='"+fivedays+"'"
                     + " where ID_BOOK = '"+tfGivebook.getText()+"'" ;        
                PreparedStatement statement = connection.prepareStatement(updateSQL);
                statement.executeUpdate(updateSQL);
               hienthibang();
            } catch (SQLException ex) {
                Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        else if(giahan.equals("1 week"))
            try {
             updateSQL =  "UPDATE  BOOK_INFORMATION_BORROWED SET  NOTES ='"+oneweek+"'"
                     + "where ID_BOOK = '"+tfGivebook.getText()+"'";       
                PreparedStatement statement = connection.prepareStatement(updateSQL);
                 statement.executeUpdate(updateSQL);
              hienthibang();
            } catch (SQLException ex) {
                Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        else if(giahan.equals("2 weeks"))
            try {
             updateSQL =  "UPDATE  BOOK_INFORMATION_BORROWED SET NOTES ='"+twoweek+"'"
                     + "where ID_BOOK = '"+tfGivebook.getText()+"'";        
                PreparedStatement statement = connection.prepareStatement(updateSQL);
                 statement.executeUpdate(updateSQL);
               hienthibang();
            } catch (SQLException ex) {
                Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
    

    }//GEN-LAST:event_UpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Give_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Give_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Give_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Give_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Give_Book().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Give_Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Adjourn;
    private javax.swing.JButton Home;
    private javax.swing.JLabel Message;
    private javax.swing.JButton OK;
    private javax.swing.JButton Return;
    private javax.swing.JTable Table;
    private javax.swing.JButton Update;
    private javax.swing.JComboBox<String> cbGive;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfGivebook;
    // End of variables declaration//GEN-END:variables
}
