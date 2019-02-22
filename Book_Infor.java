/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_management;

import Main_Screen.Home;
import com.mysql.jdbc.integration.c3p0.MysqlConnectionTester;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Book_Infor extends javax.swing.JFrame {

    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;
    private ResultSetMetaData resultSetMetaData;
    private Object ex;

    /**
     * Creates new form ThongTinSach
     */
    public Book_Infor() throws SQLException {
        setTitle("BOOK MANAGEMENT");
        try {
            // Tao truy cap cho driver 
            Class.forName("com.mysql.jdbc.Driver");
            // Tao lenh truy cap den co so du lieu
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Book_Menagement_Project?user=root&password=");
            // De new mot cau lenh
            statement = connection.createStatement();
            initComponents();
            // lay ngay mac dinh 
            ngayxuatban1.setCalendar(Calendar.getInstance());
            hienthibang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sign_Up.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hienthibang() throws SQLException {
        // cau lenh thuc hien:
        String sqlStmt = "Select * from Book_Information ";
        // De new mot cau lenh
        statement = connection.createStatement();
        // Thuc hien cau lenh va result lay ve ket qua : 
        resultSet = statement.executeQuery(sqlStmt);
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
        jTable.setModel(model);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbType1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfBookName1 = new javax.swing.JTextField();
        tfBookID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfAuthor = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        ngayxuatban1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btHome = new javax.swing.JButton();
        btHome1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(197, 239, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LIBRARY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Message.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Message.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(Message, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 390, 30));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Book", "Book Name", "Type", "Author", "Publish Date", "Status", "Notes"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 900, 290));

        jPanel2.setBackground(new java.awt.Color(197, 239, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INSERT INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 15))); // NOI18N

        cbType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comic", "Skill", "Textbook", "Magazine", "Autobiography", "Thriller", "Dictionary", "Cookery book", "Short story", "Reference book", "Psychology", " Foreign language" }));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("TYPE");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("BOOK NAME");

        tfBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBookIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("BOOK ID  ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("STATUS : ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("PUBLISH DATE");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("AUTHOR");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Broken", "Old", "New" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64)
                        .addComponent(cbType1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBookName1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfAuthor)
                    .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ngayxuatban1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfBookName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ngayxuatban1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbType1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 620, 200));

        jPanel3.setBackground(new java.awt.Color(197, 239, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOOL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N

        btAdd.setBackground(new java.awt.Color(0, 255, 255));
        btAdd.setText("ADD");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setBackground(new java.awt.Color(0, 255, 255));
        btUpdate.setText("UPDATE");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btHome.setBackground(new java.awt.Color(0, 255, 255));
        btHome.setText("Home");
        btHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHomeActionPerformed(evt);
            }
        });

        btHome1.setBackground(new java.awt.Color(0, 255, 255));
        btHome1.setText("Cancel");
        btHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHome1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btHome1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 170, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    
    String NXB ;
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        Message.setText("");
        String NXB = dateformat.format(ngayxuatban1.getDate());
        
        if (tfBookID.getText().equals("")) {
            Message.setText( "Book ID is Empty, Please Enter ! ");
            tfBookID.requestFocus();
        }else if (tfBookName1.getText().equals("")) {
            Message.setText("Book Name is Empty, Please Enter ! ");
            tfBookName1.requestFocus();
        }
        else if (tfAuthor.getText().equals("")) {
            Message.setText( "Author is Empty, Please Enter ! ");
            tfAuthor.requestFocus();
        } 
        else if(checkIDBook( tfBookID.getText())==1){
           Message.setText( "This ID Book existed ! ");
           tfBookID.requestFocus();
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Input Successful ! ");
            try {
                
                //statement.executeUpdate("Insert Into Book_Information Values  ( " + "default,'" + tfBookID.getText()
                statement.executeUpdate("Insert Into Book_Information Values(" 
                        + "'" + tfBookID.getText()
                        + "','" + tfBookName1.getText() 
                        + "','"+ cbType1.getSelectedItem().toString()
                        + "','" + tfAuthor.getText() 
                        + "','" + NXB
                        + "','"+ status.getSelectedItem().toString()
                        +"','Not yet'"+ ")");
                
                                 
                hienthibang();
            } catch (SQLException ex) {
                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btAddActionPerformed

    public int checkIDBook(String Email){
        String idsach = tfBookID.getText();
        String sql = "SELECT  ID_Book from Book_Information";
            try {
                this.statement = this.connection.prepareStatement(sql);
                ResultSet resultSet = this.statement.executeQuery(sql);
                int count = 0;
                while (resultSet.next()){
                    if (resultSet.getString("ID_Book").equals(idsach)) {
                        count=1;
                        if(count == 1){
                            return 1;
                        }
                        break;
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(Sign_In.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
    }
    
    
    private void btHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHomeActionPerformed
        Home home = new Home();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();

    }//GEN-LAST:event_btHomeActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        Message.setText("");
        String NXB = dateformat.format(ngayxuatban1.getDate());
        if(jTable.getSelectedRow() == -1)
        {
            if(jTable.getRowCount()==0){
                Message.setText(" Table is empty");
            }else{
                Message.setText(" You must select a product ");
            }
        }else{ 
            try {
                String sqlStmt = "UPDATE Book_Information SET "
                        + "BookName = '"+ tfBookName1.getText().toString()
                        + "', Type ='" + cbType1.getSelectedItem().toString()
                        + "',Author = '"+ tfAuthor.getText().toString()
                        + "',DatePublish = '"+ NXB
                        + "', Status = '" + status.getSelectedItem().toString()
                        + "' where ID_Book ='" + tfBookID.getText().toString() +"'";
                //System.out.println(sqlStmt);
                JOptionPane.showMessageDialog(rootPane, "Update Successful ");
                statement.executeUpdate(sqlStmt);
                hienthibang(); 
            } catch (SQLException Ex) {
                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }//GEN-LAST:event_btUpdateActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int click =  jTable.getSelectedRow();
        DefaultTableModel s = (DefaultTableModel) jTable.getModel();
        
        try {
           Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)s.getValueAt(click, 4).toString());
           ngayxuatban1.setDate(date);
       } catch (ParseException ex) {
           Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        String bookID = (String) jTable .getValueAt(click, 0);
        String bookName = (String) jTable .getValueAt(click, 1);
        String author = (String) jTable .getValueAt(click, 3);
      
        tfBookID.setText(bookID);
        tfBookName1.setText(bookName);
        tfAuthor.setText(author);
        //ngayxuatban1.setDateFormatString(ngayxuatban);
        //int bookID1 = (Integer) jTable .getValueAt(click, 5);
        //status.setSelectedItem(bookID1);
       
       
        
        
    }//GEN-LAST:event_jTableMouseClicked

    private void btHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHome1ActionPerformed
        int  a = JOptionPane.showConfirmDialog(rootPane, "Are you sure to exit ?", "Exit", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btHome1ActionPerformed

    private void tfBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBookIDActionPerformed

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
            java.util.logging.Logger.getLogger(Book_Infor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book_Infor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book_Infor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book_Infor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Book_Infor().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Message;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btHome;
    private javax.swing.JButton btHome1;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cbType1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private com.toedter.calendar.JDateChooser ngayxuatban1;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField tfAuthor;
    private javax.swing.JTextField tfBookID;
    private javax.swing.JTextField tfBookName1;
    // End of variables declaration//GEN-END:variables
}
