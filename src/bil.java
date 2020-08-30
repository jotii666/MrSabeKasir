/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A S U S
 */


import java.text.*;
import java.lang.*;
import javax.swing.text.html.*;
import java.time.*;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.FontMetrics;


import java.awt.Color;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.*;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.EventListener;
import javax.swing.table.*;
import java.lang.NullPointerException;
import java.text.SimpleDateFormat;
import static javafx.application.Platform.exit;
import java.util.Date;  
import java.text.DateFormat;
import java.sql.*;
import java.util.*;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileNotFoundException;  
import java.io.OutputStream;  
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.CellStyle;  
import org.apache.poi.ss.usermodel.IndexedColors;

//
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.*;
import org.jfree.chart.ChartFrame;
import org.jfree.data.category.DefaultCategoryDataset;









public class bil extends javax.swing.JFrame {

    /**
     * Creates new form bil
     */
    public String pw ="";
    
    private Connection conk;
    private Statement sttk;
    
    private Connection con;
    private Statement stt;
    
    private Connection cont;
    private Statement sttt;
    private ResultSet rsst;
    
    private Connection cont1;
    private Statement sttt1;
    private ResultSet rsst1;
    
    //total hari
    private Connection conh;
    private Statement stth;
    private ResultSet rssh;
    
    //total bulan
    private Connection conb;
    private Statement sttb;
    private ResultSet rssb;
    
    //total tahun
    private Connection contt;
    private Statement stttt;
    private ResultSet rsstt;
    
//export hari
    private Connection coneh;
    private Statement stteh;
    private ResultSet rsseh;
        

//export bulan
    private Connection coneb;
    private Statement stteb;
    private ResultSet rsseb;
    
    private Connection coneb2;
    private Statement stteb2;
    private ResultSet rsseb2;
    
 ///grafik bulan
     private Connection conegb;
    private Statement sttegb;
    private ResultSet rssegb;
   
    ///grafik tahun
     private Connection conegb2;
    private Statement sttegb2;
    private ResultSet rssegb2;
    
    ///grafik mggu
     private Connection conegb3;
    private Statement sttegb3;
    private ResultSet rssegb3;
    
    ///grafik hari
     private Connection conegb4;
    private Statement sttegb4;
    private ResultSet rssegb4;
    
    //total grafikmhari
    private Connection c;
    private Statement s;
    private ResultSet r;
    
    
    
    public String pex;
    public int pix;
    
    
    public bil() {
        initComponents();
        tampiltabelinput();
        total();
        carithn();
        caribln();
        carihr();
        ex.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
       
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
            stt = con.createStatement();
            statm.setText("AKTIF");
            statm.setForeground(Color.green);
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal");
            statm.setText("TIDAK AKTIF");
            statm.setForeground(Color.red);
            
        }
        
    }
    
    
    
    
    
 void carihr(){
     

try{
// Mengambil data dari database

     DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
   Class.forName("com.mysql.jdbc.Driver");
   conh = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
   stth = conh.createStatement();
   rssh = stth.executeQuery("SELECT SUM(nominal) AS harini FROM `datapenjualan` WHERE DATE(`tanggal`) = CURDATE()");
  

if (rssh.next())
{
    double t = rssh.getDouble("harini");
    jLabel19.setText(kursIndonesia.format(t));
}
}
catch (Exception e){
}
}
 
void caribln(){

try{
// Mengambil data dari database

    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

    
   Class.forName("com.mysql.jdbc.Driver");
   conb = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
   sttb = conb.createStatement();
   rssb = sttb.executeQuery("SELECT SUM(nominal) AS blnini FROM `datapenjualan` WHERE month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
  

if (rssb.next())
{
    double t = rssb.getDouble("blnini");
    jLabel18.setText(kursIndonesia.format(t));
}
}
catch (Exception e){
}
}


void carithn(){

try{
// Mengambil data tahun dari database
DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

    Date now = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    String tggl = formatter.format(now);
   Class.forName("com.mysql.jdbc.Driver");
   contt = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
   stttt = contt.createStatement();
   rsstt = stttt.executeQuery("SELECT SUM(nominal) AS thnini FROM `datapenjualan` WHERE year(`tanggal`) = year(CURRENT_DATE())");
  

if (rsstt.next())
{
    double t = rsstt.getDouble("thnini");
    jLabel17.setText(kursIndonesia.format(t));
}
}
catch (Exception e){
}
}
    
    
    
    
    void tampiltabelinput(){
    DefaultTableModel tb= new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
    tb.addColumn("Tanggal");
    tb.addColumn("Jam");
    tb.addColumn("Nominal");
    
    jTable1.setModel(tb);

try{
// Mengambil data dari database
DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
   Class.forName("com.mysql.jdbc.Driver");
   cont1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
   sttt1 = cont1.createStatement();
   rsst1 = sttt1.executeQuery("SELECT * FROM datapenjualan");
   


while (rsst1.next())
{
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
tb.addRow(new Object[]{
rsst1.getDate("tanggal"),
rsst1.getTime("jam"),
kursIndonesia.format(rsst1.getInt("nominal")),
});
}
}catch (Exception e){
}
}

 void cari(){
    DefaultTableModel tb= new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
    tb.addColumn("Tanggal");
    tb.addColumn("Jam");
    tb.addColumn("Nominal");
    
    jTable1.setModel(tb);

try{
// Mengambil data dari database
 
   Class.forName("com.mysql.jdbc.Driver");
   cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
   sttt = cont.createStatement();
   rsst = sttt.executeQuery("SELECT * FROM datapenjualan WHERE tanggal like '%" +jTextField1.getText()+ "%'");
   


while (rsst.next())
{
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
tb.addRow(new Object[]{
rsst.getDate("tanggal"),
rsst.getTime("jam"),
rsst.getInt("nominal"),
});
}
}
catch (Exception e){
}
}
 
 
 void totalcari(){
     DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
int totalc = 0;
        for (int i=0; i<jTable1.getRowCount(); i++){
            totalc = totalc + Integer.parseInt(jTable1.getValueAt(i, 2).toString());
            jLabel10.setText(kursIndonesia.format(totalc));
            
        }
} 
 
 
 void total(){
try{
// Mengambil data dari database

DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
   Class.forName("com.mysql.jdbc.Driver");
   cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
   sttt = cont.createStatement();
   rsst = sttt.executeQuery("SELECT SUM(nominal) AS total FROM datapenjualan");
   


if (rsst.next())
{
    double t = rsst.getDouble("total");
    jLabel6.setText(kursIndonesia.format(t));
}
}
catch (Exception e){
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        statm = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        ca = new javax.swing.JCheckBox();
        ct = new javax.swing.JCheckBox();
        cb = new javax.swing.JCheckBox();
        ch = new javax.swing.JCheckBox();
        cc = new javax.swing.JCheckBox();
        ex = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Data Pemasukan");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tanggal", "Jam", "Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        jLabel3.setText("Status   :");

        statm.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        statm.setText("TIDAK AKTIF");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Masukan Tanggal (yyyy-mm-dd)");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pencarian :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Pengolahan Data");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TOTAL :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("     ");

        jButton2.setText("Refreh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Penjualan Hari ini :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Penjualan Bulan ini :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Penjualan Tahun ini :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Export Laporan Ke PDF");

        ca.setText("Minggu ini");
        ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caActionPerformed(evt);
            }
        });

        ct.setText("Tahun Ini");
        ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctActionPerformed(evt);
            }
        });

        cb.setText("Bulan Ini");
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        ch.setText("Hari Ini");
        ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActionPerformed(evt);
            }
        });

        cc.setText("Costum");
        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccActionPerformed(evt);
            }
        });

        ex.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ex.setText("EXPORT");
        ex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ex))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ct)
                        .addGap(33, 33, 33)
                        .addComponent(cb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ch)
                        .addGap(34, 34, 34)
                        .addComponent(ca, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct)
                    .addComponent(cb)
                    .addComponent(ch)
                    .addComponent(ca))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(ex, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cc)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jMenu1.setText("File");
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("Kembali");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Grafik");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenu3.add(jSeparator6);

        jMenuItem7.setText("Grafik Banding Harian");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);
        jMenu3.add(jSeparator7);

        jMenuItem8.setText("Grafik Total Harian");
        jMenu3.add(jMenuItem8);
        jMenu3.add(jSeparator8);

        jMenuItem4.setText("Grafik Mingguan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);
        jMenu3.add(jSeparator3);

        jMenuItem5.setText("Grafik Bulanan");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);
        jMenu3.add(jSeparator9);

        jMenuItem6.setText("Grafik Tahunan");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator10);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Pengaturan");
        jMenu2.add(jSeparator4);

        jMenuItem3.setText("Koneksi DBS");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator11);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(statm)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cari();
        totalcari();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tampiltabelinput();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caActionPerformed
        // TODO add your handling code here:
        pix=1;
        ct.setSelected(false);
        cb.setSelected(false);
        ch.setSelected(false);
        cc.setSelected(false);
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
       
        ex.setEnabled(true);
    }//GEN-LAST:event_caActionPerformed

    private void ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctActionPerformed
        // TODO add your handling code here:
        pix=2;
        ca.setSelected(false);
        cb.setSelected(false);
        ch.setSelected(false);
        cc.setSelected(false);
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
        
        ex.setEnabled(true);
    }//GEN-LAST:event_ctActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
        pix=3;
        ct.setSelected(false);
        ca.setSelected(false);
        ch.setSelected(false);
        cc.setSelected(false);
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
        
        ex.setEnabled(true);
    }//GEN-LAST:event_cbActionPerformed

    private void chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActionPerformed
        // TODO add your handling code here:
        pix=4;
        ct.setSelected(false);
        cb.setSelected(false);
        ca.setSelected(false);
        cc.setSelected(false);
        
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
        ex.setEnabled(true);
    }//GEN-LAST:event_chActionPerformed

    private void ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccActionPerformed
        // TODO add your handling code here:
        pix=5;
        ct.setSelected(false);
        cb.setSelected(false);
        ch.setSelected(false);
        ca.setSelected(false);
        jDateChooser1.setEnabled(true);
        jDateChooser2.setEnabled(true);
        ex.setEnabled(true);
        
        
    }//GEN-LAST:event_ccActionPerformed

    private void exActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exActionPerformed
        // TODO add your handling code here:
      if (pix==4) {
       
          try {
   Class.forName("com.mysql.jdbc.Driver");
   coneh = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
  String path="harian.jasper";
  Map parameter = new HashMap();
  JasperPrint print = JasperFillManager.fillReport(path,parameter, coneh);
  JasperViewer.viewReport(print, false);
} catch (Exception ex) {
  JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
}
        
        
      }
        else if (pix==3) {
            
            try {
   Class.forName("com.mysql.jdbc.Driver");
   coneb = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
  String path="bulanan.jasper";
  Map parameter = new HashMap();
  JasperPrint print = JasperFillManager.fillReport(path,parameter, coneb);
  JasperViewer.viewReport(print, false);
} catch (Exception ex) {
  JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
}
            
            
        }
        
        else if (pix==2) {
            
            try {
   Class.forName("com.mysql.jdbc.Driver");
   coneb = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
  String path="tahunan.jasper";
  Map parameter = new HashMap();
  JasperPrint print = JasperFillManager.fillReport(path,parameter, coneb);
  JasperViewer.viewReport(print, false);
} catch (Exception ex) {
  JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
}
            
            
        }
        
         else if (pix==5) {
            
            try {
                  
              java.sql.Date tgl1 = new java.sql.Date(jDateChooser1.getDate().getTime());
              java.sql.Date tgl2 = new java.sql.Date(jDateChooser2.getDate().getTime());
              
   Class.forName("com.mysql.jdbc.Driver");
   coneb = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
  String path="costum.jasper";
    @SuppressWarnings("rawtypes")
	                   Map hash = new HashMap(2);
	                   //Mengambil parameter dari ireport
	                 hash.put("tgl1",tgl1);
	                 hash.put("tgl2",tgl2);
                        
  JasperPrint print = JasperFillManager.fillReport(path,hash, coneb);
  JasperViewer.viewReport(print, false);
  
} catch (Exception ex) {
  JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
}
            
            
        }
         
         
         else if (pix==1) {
            
            try {
   Class.forName("com.mysql.jdbc.Driver");
   coneb = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
  String path="mingguan.jasper";
  Map parameter = new HashMap();
  JasperPrint print = JasperFillManager.fillReport(path,parameter, coneb);
  JasperViewer.viewReport(print, false);
} catch (Exception ex) {
  JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
}
            
            
        }
         
         
         
         
        
        else {
            ex.setEnabled(false);
        }
       
    
    }//GEN-LAST:event_exActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "\n"+"Aplikasi Mr.Sabe Kasir v.1.0" + "\n" + "\n" + "Code By : JotiiGanteng" + "\n" + "Email : Prajuritn@gmail.com" + "\n" + "WA/Tlp : 082370010342" + "\n" + "Copyright : 2020-2021" + "\n" + "Lisensi Berbayar Dilarang MengCopy-Paste    " + "\n" + "\n");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            // TODO add your handling code here:
            int jan = 0;
            int feb = 0;
            int mar = 0;
            int apr = 0;
            int mei = 0;
            int jun = 0;
            int jul = 0;
            int agu = 0;
            int sep = 0;
            int okt = 0;
            int nov = 0;
            int des = 0;
            //grafik bulanan
            Class.forName("com.mysql.jdbc.Driver");
            conegb = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
            sttegb = conegb.createStatement();
            rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 01 and year(`tanggal`) = year(CURRENT_DATE())");
            
            if (rssegb.next()) {
                jan = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 02 and year(`tanggal`) = year(CURRENT_DATE())");
        
        if (rssegb.next()) {
                feb = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 03 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                mar = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 04 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                apr = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 05 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                mei = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 06 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                jun = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 07 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                jul = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 08 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                agu = rssegb.getInt("total");  
            }
        
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 09 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                sep = rssegb.getInt("total");  
            }
        
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 10 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                okt = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 11 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                nov = rssegb.getInt("total");  
            }
        rssegb = sttegb.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE month(`tanggal`) = 12 and year(`tanggal`) = year(CURRENT_DATE())");
       
        if (rssegb.next()) {
                des = rssegb.getInt("total");  
            }
        
        
        
        DefaultCategoryDataset piedata=new DefaultCategoryDataset();
        piedata.setValue(jan  , "Januari", "Jan");
        piedata.setValue(feb  , "Februari", "Feb");
        piedata.setValue(mar  , "Maret", "Mar");
        piedata.setValue(apr  , "April", "Apr");
        piedata.setValue(mei  , "Mei", "Mei");
        piedata.setValue(jun  , "Juni", "Jun");
        piedata.setValue(jul  , "Juli", "Jul");
        piedata.setValue(agu  , "Agustus", "Agu");
        piedata.setValue(sep  , "September", "Sep");
        piedata.setValue(okt  , "Oktober", "Okt");
        piedata.setValue(nov  , "November", "Nov");
        piedata.setValue(des  , "Desember", "Des");
        
        JFreeChart chart =ChartFactory.createBarChart("Grafik Bulanan","Berdasarkan Bulan",                           "Total Penjualan Tiap Bulan", piedata);
        ChartFrame frame =new ChartFrame ("framechart",chart);
        frame.setVisible(true);
        
        frame.setBounds(500, 200, 900, 700);
        
        
        
        
        } catch (Exception e) {
            Logger.getLogger(bil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            // TODO add your handling code here:
            //grafik tahunan
            int seb = 0;
            int kem = 0;
            int ini = 0;
            
            Class.forName("com.mysql.jdbc.Driver");
            conegb2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
            sttegb2 = conegb2.createStatement();
            rssegb2 = sttegb2.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE year(`tanggal`) = year(CURRENT_DATE())-2");
        
            if (rssegb2.next()) {
                seb = rssegb2.getInt("total");
            }
        
            rssegb2 = sttegb2.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE year(`tanggal`) = year(CURRENT_DATE())-1");
        
            if (rssegb2.next()) {
                
                kem = rssegb2.getInt("total");
            }
            
            rssegb2 = sttegb2.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb2.next()) {
                ini = rssegb2.getInt("total");
            }
        
        
            
        DefaultCategoryDataset piedata=new DefaultCategoryDataset();
        piedata.setValue(seb  , "Tahun Sebelumnya", "Tahun Sebelumnya");
        piedata.setValue(kem  , "Tahun Kemarin", "Tahun Kemarin");
        piedata.setValue(ini  , "Tahun Ini", "Tahun Ini");
        
        
        JFreeChart chart =ChartFactory.createBarChart("Grafik Tahunan","Berdasarkan Tahun Tahun Sebelumnya",                           "Total Penjualan Tiap Tahun", piedata);
        ChartFrame frame =new ChartFrame ("framechart",chart);
        frame.setVisible(true);
        
        frame.setBounds(500, 200, 900, 700);
        
        
        
        
        
        } catch (Exception e) {
            Logger.getLogger(bil.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //grafik mingguan
        
        try {
            // TODO add your handling code here:
            //grafik tahunan
            int seb = 0;
            int kem = 0;
            int ini = 0;
            
            Class.forName("com.mysql.jdbc.Driver");
            conegb3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
            sttegb3 = conegb3.createStatement();
            rssegb3 = sttegb3.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE week(tanggal) = week(CURRENT_DATE())-2 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb3.next()) {
                seb = rssegb3.getInt("total");
            }
        
            rssegb3 = sttegb3.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE week(tanggal) = week(CURRENT_DATE())-1 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb3.next()) {
                
                kem = rssegb3.getInt("total");
            }
            
            rssegb3 = sttegb3.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE week(tanggal) = week(CURRENT_DATE()) and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb3.next()) {
                ini = rssegb3.getInt("total");
            }
        
        
            
        DefaultCategoryDataset piedata=new DefaultCategoryDataset();
        piedata.setValue(seb  , "Minggu Sebelumnya", "Minggu Sebelumnya");
        piedata.setValue(kem  , "Minggu Kemarin", "Minggu Kemarin");
        piedata.setValue(ini  , "Minggu Ini", "Minggu Ini");
        
        
        JFreeChart chart =ChartFactory.createBarChart("Grafik Mingguan","Berdasarkan Minggu Sebelumnya",                           "Total Penjualan Tiap Minggu", piedata);
        ChartFrame frame =new ChartFrame ("framechart",chart);
        frame.setVisible(true);
        
        frame.setBounds(500, 200, 900, 700);
        
        
        
        
        
        } catch (Exception e) {
            Logger.getLogger(bil.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        //grafik Harian
        try {
            // TODO add your handling code here:
            //grafik tahunan
            int seb = 0;
            int lusa = 0;
            int kem = 0;
            int ini = 0;
            
            Class.forName("com.mysql.jdbc.Driver");
            conegb4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
            sttegb4 = conegb4.createStatement();
            rssegb4 = sttegb4.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE day (tanggal) = day(CURRENT_DATE())-3 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb4.next()) {
                seb = rssegb4.getInt("total");
            }
        
            rssegb4 = sttegb4.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE day (tanggal) = day(CURRENT_DATE())-2 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb4.next()) {
                
                lusa = rssegb4.getInt("total");
            }
            
            rssegb4 = sttegb4.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE day (tanggal) = day(CURRENT_DATE())-1 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb4.next()) {
                kem = rssegb4.getInt("total");
            }
        
            rssegb4 = sttegb4.executeQuery("SELECT sum(nominal) as total FROM `datapenjualan` WHERE day (tanggal) = day(CURRENT_DATE()) and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (rssegb4.next()) {
                ini = rssegb4.getInt("total");
            }
        
            
        DefaultCategoryDataset piedata=new DefaultCategoryDataset();
        piedata.setValue(seb  , "4 Hari Yang Lalu ", "4 Hari Yang Lalu");
        piedata.setValue(lusa  , "Kemarin Lusa ", "Kemarin Lusa");
        piedata.setValue(kem  , "Kemarin ", "Kemarin");
        piedata.setValue(ini  , "Hari Ini ", "Hari Ini");
        
        JFreeChart chart =ChartFactory.createBarChart("Grafik Harian","Berdasarkan 4 Hari Sebelumnya",                           "Total Penjualan Tiap Hari", piedata);
        ChartFrame frame =new ChartFrame ("framechart",chart);
        frame.setVisible(true);
        
        frame.setBounds(500, 200, 900, 700);
        
        
        
        
        
        } catch (Exception e) {
            Logger.getLogger(bil.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        try {
            // TODO add your handling code here:
            
            //total harian
            int tgl1 = 0;
            int tgl2 = 0;
            int tgl3 = 0;
            int tgl4 = 0;
            int tgl5 = 0;
            int tgl6 = 0;
            int tgl7 = 0;
            int tgl8 = 0;
            int tgl9 = 0;
            int tgl10 = 0;
            int tgl11 = 0;
            int tgl12 = 0;
            int tgl13 = 0;
            int tgl14 = 0;
            int tgl15 = 0;
            int tgl16 = 0;
            int tgl17 = 0;
            int tgl18 = 0;
            int tgl19 = 0;
            int tgl20 = 0;
            int tgl21 = 0;
            int tgl22 = 0;
            int tgl23 = 0;
            int tgl24 = 0;
            int tgl25 = 0;
            int tgl26 = 0;
            int tgl27 = 0;
            int tgl28 = 0;
            int tgl29 = 0;
            int tgl30 = 0;
            int tgl31 = 0;
            
            
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
            s = c.createStatement();
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 01 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl1 = r.getInt("total");
            }
            
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 02 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl2 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 03 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl3 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 04 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl4 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 05 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl5 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 06 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl6 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 07 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl7 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 08 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl8 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 09 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl9 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 10 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl10 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 11 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl11 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 12 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl12 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 13 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl13 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 14 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl14 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 15 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl15 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 16 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl16 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 17 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl17 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 18 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl18 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 19 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl19 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 20 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl20 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 21 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl21 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 22 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl22 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 23 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl23 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 24 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl24 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 25 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl25 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 26 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl26 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 27 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl27 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 28 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl28 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 29 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl29 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 30 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl30 = r.getInt("total");
            }
            r = s.executeQuery("SELECT sum(nominal) as total FROM  `datapenjualan` WHERE day (tanggal) = 31 and month(`tanggal`) = month(CURRENT_DATE()) and year(`tanggal`) = year(CURRENT_DATE())");
        
            if (r.next()) {
                tgl2 = r.getInt("total");
            }
        
        DefaultCategoryDataset piedata=new DefaultCategoryDataset();
        piedata.setValue(tgl1  , "1 ", "1");
        piedata.setValue(tgl2  , "2 ", "2");
        piedata.setValue(tgl3  , "3 ", "3");
        piedata.setValue(tgl4  , "4 ", "4");
        piedata.setValue(tgl5  , "5 ", "5");
        piedata.setValue(tgl6  , "6 ", "6");
        piedata.setValue(tgl7  , "7 ", "7");
        piedata.setValue(tgl8  , "8 ", "8");
        piedata.setValue(tgl9  , "9 ", "9");
        piedata.setValue(tgl10  , "10 ", "10");
        piedata.setValue(tgl11  , "11 ", "11");
        piedata.setValue(tgl12  , "12 ", "12");
        piedata.setValue(tgl13  , "13 ", "13");
        piedata.setValue(tgl14  , "14 ", "14");
        piedata.setValue(tgl15  , "15 ", "15");
        piedata.setValue(tgl16  , "16 ", "16");
        piedata.setValue(tgl17  , "17 ", "17");
        piedata.setValue(tgl18  , "18 ", "18");
        piedata.setValue(tgl19  , "19 ", "19");
        piedata.setValue(tgl20  , "20 ", "20");
        piedata.setValue(tgl21  , "21 ", "21");
        piedata.setValue(tgl22  , "22 ", "22");
        piedata.setValue(tgl23  , "23 ", "23");
        piedata.setValue(tgl24  , "24 ", "24");
        piedata.setValue(tgl25  , "25 ", "25");
        piedata.setValue(tgl26  , "26 ", "26");
        piedata.setValue(tgl27  , "27 ", "27");
        piedata.setValue(tgl28  , "28 ", "28");
        piedata.setValue(tgl29  , "29 ", "29");
        piedata.setValue(tgl30  , "30 ", "30");
        piedata.setValue(tgl31  , "31", "31");
        
        JFreeChart chart =ChartFactory.createBarChart("Grafik Total Harian","Berdasarkan Jumlah Tanggan",                           "Total Penjualan Tiap Hari", piedata);
        ChartFrame frame =new ChartFrame ("Grafik",chart);
        frame.setVisible(true);
        
        frame.setBounds(1000, 1000, 1000, 1000);
        
        
        
        
        
        
        } catch (Exception e) {
            Logger.getLogger(bil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conk = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsabe" , "root" , pw);
            sttk = con.createStatement();
            JOptionPane.showMessageDialog(null,"Aktif");
            statm.setText("AKTIF");
            statm.setForeground(Color.green);

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal");
            statm.setText("TIDAK AKTIF");
            statm.setForeground(Color.red);

        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
   
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
            java.util.logging.Logger.getLogger(bil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ca;
    private javax.swing.JCheckBox cb;
    private javax.swing.JCheckBox cc;
    private javax.swing.JCheckBox ch;
    private javax.swing.JCheckBox ct;
    private javax.swing.JButton ex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel statm;
    // End of variables declaration//GEN-END:variables
}
