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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuan.nguyen1
 */
public class Borrow_Book extends javax.swing.JFrame {
    /*private Statement statement;
    private ResultSet resultSet;
    private Connection connection;
    private ResultSetMetaData resultSetMetaData;
    private PreparedStatement preparedStatement ;
    private Object ex;
   */
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;
    private ResultSetMetaData resultSetMetaData;
    private Object ex;
    private PreparedStatement preparedStatement ;
     ButtonGroup gender;
    private Object rs;
     
    public Borrow_Book() throws SQLException {
        setTitle("Borrow Book");
        try {
            // Tao truy cap cho driver 
            Class.forName("com.mysql.jdbc.Driver");
            // Tao lenh truy cap den co so du lieu
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Book_Menagement_Project?user=root&password=");
            // De new mot cau lenh
            statement = connection.createStatement();
            initComponents();
            ngaymuon.setCalendar(Calendar.getInstance());
            ngaytra.setCalendar(Calendar.getInstance());
            hienthibang();
            showbookborrowed();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sign_Up.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
public void hienthibang() throws SQLException {
        // cau lenh thuc hien:
        String sqlStmt = "Select * from READER ";
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
        TTND.setModel(model);
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
    
    public void showbookborrowed() throws SQLException {
        // cau lenh thuc hien:
        String sqlStmt = "Select borrow.STT,borrow.ID_READER,borrow.ID_BOOK,bookInfor.BookName,bookInfor.Type,bookInfor.Author,\n" +
            "borrow.DATE_BORROWED,borrow.DATE_GIVE,borrow.NOTES from BOOK_INFORMATION_BORROWED as borrow,\n" +
            "Book_Information as bookInfor where borrow.ID_BOOK = bookInfor.ID_BOOK ";
        
        
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
        tbTTSach.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TTND = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTTSach = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfIDdocgia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfTendocgia = new javax.swing.JTextField();
        cbLop = new javax.swing.JComboBox<>();
        tfEmail = new javax.swing.JTextField();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        lbemail = new javax.swing.JLabel();
        lbten = new javax.swing.JLabel();
        lbdocgia = new javax.swing.JLabel();
        gioitinh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ngaymuon = new com.toedter.calendar.JDateChooser();
        ngaytra = new com.toedter.calendar.JDateChooser();
        tfIDSach = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbIDsach = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btCancel = new javax.swing.JButton();
        btHome = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        update = new javax.swing.JButton();
        tfNotes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TTND.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TTND.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Reader", "Reader Name", "Class", "Gender", "Email"
            }
        ));
        TTND.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTNDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TTND);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 310, 220));

        tbTTSach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbTTSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Stt", "Id Reader", "Id Book", "Book Name", "Type", "Author", "Date Borrow", "Date Give", "Notes"
            }
        ));
        tbTTSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTTSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbTTSach);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 680, 220));

        jPanel1.setBackground(new java.awt.Color(197, 239, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "READER INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 330, 250));

        jPanel2.setBackground(new java.awt.Color(197, 239, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "READER INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 700, 250));

        jPanel4.setBackground(new java.awt.Color(197, 239, 247));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "READER INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("ID READER");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("RADER NAME");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("CLASS");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("GENDER");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("EMAIL");

        cbLop.setBackground(new java.awt.Color(197, 239, 247));
        cbLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PNV 19 A", "PNV 19 B", "PNV 20 A", "PNV 20 B", "PNV 21 A", "PNV 21 B", "Other", " " }));
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });

        rdMale.setText("MALE");
        rdMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaleActionPerformed(evt);
            }
        });

        rdFemale.setText("FEMALE");
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });

        lbemail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbemail.setForeground(new java.awt.Color(255, 0, 0));

        lbten.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbten.setForeground(new java.awt.Color(255, 0, 0));

        lbdocgia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbdocgia.setForeground(new java.awt.Color(255, 0, 0));

        gioitinh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        gioitinh.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rdMale, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rdFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(lbten, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfTendocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbdocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfIDdocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(lbemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIDdocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lbdocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTendocgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbten, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdMale)
                            .addComponent(rdFemale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(tfEmail)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbemail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 300));

        jPanel5.setBackground(new java.awt.Color(197, 239, 247));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BOOK  INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        ngaymuon.setBackground(new java.awt.Color(197, 239, 247));

        ngaytra.setBackground(new java.awt.Color(197, 239, 247));

        tfIDSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDSachActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("DATE GIVE");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("NOTES");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("DATE BORROW");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("ID BOOK");

        lbIDsach.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbIDsach.setForeground(new java.awt.Color(255, 0, 0));

        jPanel3.setBackground(new java.awt.Color(197, 239, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOOL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        btCancel.setBackground(new java.awt.Color(0, 204, 204));
        btCancel.setText("CANCEL");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btHome.setBackground(new java.awt.Color(0, 204, 204));
        btHome.setText("HOME");
        btHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHomeActionPerformed(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(0, 204, 204));
        btAdd.setText("ADD");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 204, 204));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btHome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        tfNotes.setBackground(new java.awt.Color(197, 239, 247));
        tfNotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Broken", "Old", "New" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbIDsach, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(tfIDSach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ngaytra, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(tfNotes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(83, 83, 83)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIDSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIDsach, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 700, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  public  int dinhDangEmail(String Email){
        Pattern pt1=Pattern.compile(".+@.+\\.[a-zA-Z]+");
              Matcher mc1=pt1.matcher(Email);
           if(!mc1.find())     {        
             return 1;  
              }
        return 0;
   }
    
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String dateborrow = dateformat.format(ngaymuon.getDate());
        String dategive = dateformat.format(ngaytra.getDate());
        
        lbdocgia.setText("");
        lbten.setText("");
        gioitinh.setText("");
        lbemail.setText("");
        lbIDsach.setText("");
        
        
        if (tfIDdocgia.getText().equals("")) {
            lbdocgia.setText("Enter ID Reader ! ");
            tfIDdocgia.requestFocus();
        } else if (tfTendocgia.getText().equals("")) {
            lbten.setText("Enter Reader Name ! ");
            tfTendocgia.requestFocus();
        }else if (!rdMale.isSelected() && !rdFemale.isSelected()) {
            gioitinh.setText("Check Gender ! ");
             
        }else if (tfEmail.getText().equals("")) {
            lbemail.setText("Enter Email ! ");
            tfEmail.requestFocus();
        }else if(dinhDangEmail(tfEmail.getText())==1){
           lbemail.setText(" Please enter correct email ");
           tfEmail.requestFocus();
        }
        else if (tfIDSach.getText().equals("")) {
            lbIDsach.setText("Enter ID Book ! ");
            tfIDSach.requestFocus();
        }else if((checkIDBookBorowed( tfIDSach.getText())==1 )){
            JOptionPane.showMessageDialog(rootPane, "This book borrowed. Choice another book ! ", "ERROR", JOptionPane.ERROR_MESSAGE);
            tfIDSach.requestFocus();
        }
        else if (checkIDBookinInfor( tfIDSach.getText())==1 ) {
                if(IDREADER(tfIDdocgia.getText())==1){
                   
                        String sql = " Insert into BOOK_INFORMATION_BORROWED Values("+ "default,'" + tfIDdocgia.getText()+ "','"
                            + tfIDSach.getText() + "','"
                            + dateborrow +"','"
                            + dategive +"','"
                            + tfNotes.getSelectedItem().toString()+"'"+ ")";               
                            try{
                                statement.executeUpdate(sql); 
                                //System.out.println(query);    
                                showbookborrowed();
                            }catch (SQLException ex) {
                                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            String sqlStmt = "UPDATE Book_Information SET "
                                        + "NOTES='"+"Borrowed"+"'where ID_Book ='"+ tfIDSach.getText().toString() +"'";;
                            try{
                                statement.executeUpdate(sqlStmt); 
                                
                            }catch (SQLException ex) {
                                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
                            }       
                                    
                }else if(IDREADER(tfIDdocgia.getText())==0){
                        String query = " Insert into READER Values("+ "'" + tfIDdocgia.getText()+ "','"
                                    + tfTendocgia.getText() + "','"
                                    + cbLop.getSelectedItem().toString()+ "','" 
                                    + (rdMale.isSelected()? " Male" : "FeMale" )+ "','"
                                    + tfEmail.getText()+"'"+ ")";               
                         try{
                            statement.executeUpdate(query); 
                            //System.out.println(query);    
                            hienthibang();
                            showbookborrowed();
                        }catch (SQLException ex) {
                            Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                        String sql = " Insert into BOOK_INFORMATION_BORROWED Values("+ "default,'" + tfIDdocgia.getText()+ "','"
                            + tfIDSach.getText() + "','"
                            + dateborrow +"','"
                            + dategive +"','"
                            + tfNotes.getSelectedItem().toString()+"'"+ ")";               
                            try{
                                statement.executeUpdate(sql); 
                                //System.out.println(query);    
                                showbookborrowed();
                            }catch (SQLException ex) {
                                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        String sqlStmt = "UPDATE Book_Information SET "
                                        + "NOTES='"+"Borowed"+"'where ID_Book ='"+ tfIDSach.getText().toString() +"'";;
                            try{
                                statement.executeUpdate(sqlStmt); 
                                
                            }catch (SQLException ex) {
                                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
                            }     
                }
        }
        else{  
            JOptionPane.showMessageDialog(rootPane, "This Book does not exist in library ! Please choise another book !", "ERROR", JOptionPane.ERROR_MESSAGE);
            tfIDSach.requestFocus();
        }
           
    }//GEN-LAST:event_btAddActionPerformed

    public int checkIDBookinInfor(String Idbook){
        String idbook = tfIDSach.getText();
        String sql = "SELECT  ID_Book from Book_Information";
            try {
                this.statement = this.connection.prepareStatement(sql);
                ResultSet resultSet = this.statement.executeQuery(sql);
                int count = 0;
                while (resultSet.next()){
                    if (resultSet.getString("ID_Book").equals(idbook)) {
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
    
     public int checkIDBookBorowed(String Idbook){
        String idbook = tfIDSach.getText();
        String sql = "SELECT  ID_Book from BOOK_INFORMATION_BORROWED";
            try {
                this.statement = this.connection.prepareStatement(sql);
                ResultSet resultSet = this.statement.executeQuery(sql);
                int count = 0;
                while (resultSet.next()){
                    if (resultSet.getString("ID_BOOK").equals(idbook)) {
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
    
    public int IDREADER(String idreader){
        String iddocgia = tfIDdocgia.getText();
        String sql = "SELECT  ID_READER from READER";
            try {
                this.statement = this.connection.prepareStatement(sql);
                ResultSet resultSet = this.statement.executeQuery(sql);
                int count = 0;
                while (resultSet.next()){
                    if (resultSet.getString("ID_READER").equals(iddocgia)) {
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
    
    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        int  a = JOptionPane.showConfirmDialog(rootPane, "Are you sure to exit ?", "Exit", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btCancelActionPerformed

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        gender = new ButtonGroup();
        gender.add(rdMale);
        gender.add(rdFemale);
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        gender = new ButtonGroup();
        gender.add(rdMale);
        gender.add(rdFemale);
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void TTNDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTNDMouseClicked
        int click = TTND.getSelectedRow();
        
        try{
            String guestEdit=(TTND.getModel().getValueAt(click,3).toString());
                    
                if(guestEdit.equals("Male"))
                {
                    rdMale.setSelected(true); rdFemale.setSelected(false);
                    
                }
                else if(guestEdit.equals("Female"))
                {
                    rdMale.setSelected(false); 
                    rdFemale.setSelected(true);
                }
                    
        }catch(Exception ex){
                ex.printStackTrace();
        }          
        
        
        
        String docgia = (String) TTND.getValueAt(click, 0);
        String tendocgia = (String) TTND.getValueAt(click, 1);
        String email = (String) TTND.getValueAt(click, 4);

        tfIDdocgia.setText(docgia);
        tfTendocgia.setText(tendocgia);
        tfEmail.setText(email);

    }//GEN-LAST:event_TTNDMouseClicked

    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");


    private void tbTTSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTTSachMouseClicked
        DefaultTableModel s = (DefaultTableModel) tbTTSach.getModel();
        int click = tbTTSach.getSelectedRow();
        
        try {
           Date dateborrow = new SimpleDateFormat("yyyy-MM-dd").parse((String)s.getValueAt(click, 6).toString());
           ngaymuon.setDate(dateborrow);
           Date dateGive = new SimpleDateFormat("yyyy-MM-dd").parse((String)s.getValueAt(click, 7).toString());
           ngaytra.setDate(dateGive);
        } catch (ParseException ex) {
           Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        String idbook = (String) tbTTSach.getValueAt(click, 2);
        tfIDSach.setText(idbook);
       
    }//GEN-LAST:event_tbTTSachMouseClicked

    private void cbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLopActionPerformed

    private void tfIDSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDSachActionPerformed

    private void btHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHomeActionPerformed
        Home home = new Home();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
        
    }//GEN-LAST:event_btHomeActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(TTND.getSelectedRow() == -1)
        {
            if(TTND.getRowCount()==0){
                JOptionPane.showMessageDialog(rootPane, " Table is empty");
            }else{
                JOptionPane.showMessageDialog(rootPane, "  You must select a product");
            }
        }else{ 
            try {
                String sqlStmt = "UPDATE READER SET "
                        + "NAME_READER = '"+ tfTendocgia.getText().toString()
                        + "', CLASS ='" + cbLop.getSelectedItem().toString()
                        + "',GENDER = '"+ (rdMale.isSelected()? " Male" : "FeMale" )
                        + "',EMAIL = '"+ tfEmail.getText().toString()
                        + "' where ID_READER ='" + tfIDdocgia.getText().toString() +"'";
                //System.out.println(sqlStmt);
                JOptionPane.showMessageDialog(rootPane, "Update Successful ");
                statement.executeUpdate(sqlStmt);
                hienthibang(); 
            } catch (SQLException Ex) {
                Logger.getLogger(Book_Infor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrow_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Borrow_Book().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Borrow_Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TTND;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btHome;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JLabel gioitinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbIDsach;
    private javax.swing.JLabel lbdocgia;
    private javax.swing.JLabel lbemail;
    private javax.swing.JLabel lbten;
    private com.toedter.calendar.JDateChooser ngaymuon;
    private com.toedter.calendar.JDateChooser ngaytra;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTable tbTTSach;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfIDSach;
    private javax.swing.JTextField tfIDdocgia;
    private javax.swing.JComboBox<String> tfNotes;
    private javax.swing.JTextField tfTendocgia;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
