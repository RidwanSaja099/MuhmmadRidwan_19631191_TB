
package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

 


public class penjualan extends javax.swing.JFrame {
koneksi koneksi = new koneksi();
 private DefaultTableModel model;
  String tampilan = "yyy-MM-dd";
  SimpleDateFormat    fm = new SimpleDateFormat(tampilan);
 
 private void autonumber(){
        try{
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM pembelian ORDER BY id_pen DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()){
                String NoBarang = r.getString("id_pen").substring(2);
                String BR = "" + (Integer.parseInt(NoBarang) + 1);
                String Nol = "";
                
                if(BR.length()==1){
                    Nol = "00";
                }else if(BR.length()==2){
                    Nol = "0";
                }else if(BR.length()==3){
                    Nol = "";
                }
                
                tIDpen.setText("ID" + Nol + BR);
                
            }else{
                tIDpen.setText("ID001");
            }
            r.close();
            s.close();
        }catch(Exception e){
            System.out.println("autonumber error");
        }
 }
 
 public void bersih(){
     
     tIDpen.setText("");
     lJudul.setText("-");
     tJumlah.setText("");
     lIdBuku.setText("-");
     lTotal.setText("-");
     tTanggal.setDateFormatString("");
     lH.setText("-");
     lStok.setText("-");
 }

      
 
public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM pembelian";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                Object[] o = new Object[6];
                o [0] = r.getString("id_pen");
                o [1] = r.getString("tanggal");
                o [2] = r.getString("kode_buku");
                o [3] = r.getString("jumlah");
                o [4] = r.getString("id");
                o [5] = r.getString("total");
               
                
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println("terjadi kesalahan");
        }
    }
 public void loadBarang(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM input_buku";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                Object[] o = new Object[7];
                o [0] = r.getString("kode_buku");
                o [1] = r.getString("judul");
                o [2] = r.getString("jenis");
                o [3] = r.getString("penulis");
                o [4] = r.getString("tahun");
                o [5] = r.getString("harga");
                o [6] = r.getString("stok");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println("terjadi kesalahan");
        }
    }
   
   public void tampilBarang(){
         model = new DefaultTableModel();

         jBarang.setModel(model);
         model.addColumn("Kode Buku");
         model.addColumn("Judul Buku");
         model.addColumn("Jenis");
         model.addColumn("Penulis");
         model.addColumn("Tahun");
         model.addColumn("Harga");
         model.addColumn("Stok");

         loadBarang();
     } 
 
    public void stoks() throws SQLException{
        Connection c = koneksi.getKoneksi();
        String stok = lH.getText();
        String jumlah = tJumlah.getText();
        String idb = lIdBuku.getText();
         int stokbaru = 0;
            int number1 = Integer.parseInt(stok);
            int number2 = Integer.parseInt(jumlah);
            
             if( number2 <= number1 ){
                 stokbaru  = number1 - number2;
                 String total = String.valueOf(stokbaru);
                 String sql = "UPDATE input_buku set stok = '" +total+"' where kode_buku = '"+idb+"' ";
                 PreparedStatement p = c.prepareStatement(sql);
                 p.executeUpdate();
             }else{
                      System.out.println("Maaf Persediaan tak cukup");
    }}
     
     public void tampilPenjualan(){
         model = new DefaultTableModel();

         jPenjualan.setModel(model);
         model.addColumn("ID Penjualan");
         model.addColumn("Tanggal");
         model.addColumn("Kode Buku");
         model.addColumn("Jumlah");
         model.addColumn("ID Pembeli");
         model.addColumn("Total");

         loadData();
         autonumber();
     }
    public penjualan() {
        initComponents();
        this.setLocationRelativeTo(null);
        tIDpen.setEnabled(false);
        
        tampilBarang();
        tampilPenjualan();
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        idP = new java.awt.Label();
        btnCari2 = new javax.swing.JButton();
        tIDpen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lIdBuku = new javax.swing.JLabel();
        lJudul = new javax.swing.JLabel();
        tJumlah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();
        lTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tTanggal = new com.toedter.calendar.JDateChooser();
        lH = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lStok = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jBarang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPenjualan = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID Pembelian");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        label1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label1.setText("ID Pembeli");

        idP.setText("-");

        btnCari2.setText("Cari");
        btnCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCari2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(idP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
                .addComponent(btnCari2)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari2)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 90));

        tIDpen.setEnabled(false);
        jPanel1.add(tIDpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 183, -1));

        jLabel3.setText("Kode Buku");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel4.setText("Judul");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel5.setText("Jumlah");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        lIdBuku.setText("-");
        jPanel1.add(lIdBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 110, -1));

        lJudul.setText("-");
        jPanel1.add(lJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 100, -1));
        jPanel1.add(tJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 53, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Total Harga");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });
        jPanel1.add(btnProses, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, -1));

        lTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lTotal.setText("-");
        jPanel1.add(lTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jLabel7.setText("Tanggal");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));
        jPanel1.add(tTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 190, -1));

        lH.setText("-");
        jPanel1.add(lH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 50, -1));

        jLabel9.setText("/ Buah");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jLabel10.setText("/");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 10, -1));

        lStok.setText("-");
        jPanel1.add(lStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 40, -1));

        jBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBarangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jBarang);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 790, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 380));

        jPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPenjualanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jPenjualan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 790, 130));

        jButton8.setText("Cetak Penjualan");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 570, -1, -1));

        jButton9.setText("Cetak Data Buku");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jButton3.setText("Tambah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Hapus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Batal");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Keluar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 790, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        
        
       String ha = lStok.getText();
       String Hi = tJumlah.getText();
       
         try
         {
             int number1 = Integer.parseInt(ha);
             int number2 = Integer.parseInt(Hi);
             
             int Jumlah = number1 * number2;
             String total = Integer.toString(Jumlah);
             lTotal.setText(total);
             
         }
         catch (NumberFormatException ex){
            ex.printStackTrace(); 
         }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                 try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("report2.jasper"), null, koneksi.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
          
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCari2ActionPerformed
        CariOrang orang = new CariOrang();
       orang.setVisible(true);
       orang.pack();
       dispose();
    }//GEN-LAST:event_btnCari2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        bersih();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBarangMouseClicked
        int i = jBarang.getSelectedRow();
       
            
        
        String id = jBarang.getValueAt(i, 0).toString();
        String judul = jBarang.getValueAt(i, 1).toString();
        String stok = jBarang.getValueAt(i, 5).toString();
        String harga = jBarang.getValueAt(i, 6).toString();
        
        lIdBuku.setText(id);
        lJudul.setText(judul);
        lStok.setText(stok);
        lH.setText(harga);

        
    }//GEN-LAST:event_jBarangMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String stok = lH.getText();
        
        String id = tIDpen.getText();
        String idb = lIdBuku.getText();
        String tanggal = String.valueOf(fm.format(tTanggal.getDate()));
        String idp = idP.getText();
        String jumlah = tJumlah.getText();
        String total = lTotal.getText();
 
        
        try{
            Connection c = koneksi.getKoneksi();
            String sql = "insert into pembelian values(?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, tanggal);
            p.setString(3, idb);
            p.setString(4, jumlah);
            p.setString(5, idp);
            p.setString(6, total);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        
            stoks();         
            
        }catch(SQLException e){
            System.out.println("Terjadi Kesalahan");
        }finally
        {
            loadData();
            bersih();
            autonumber();
        }
        

        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
  
                try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("report1.jasper"), null, koneksi.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      int i = jPenjualan.getSelectedRow();
        if(i == -1){
            return;
        }

        String id = (String)model.getValueAt(i, 0);

        int question = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION){
            try{
                Connection c = koneksi.getKoneksi();
                String sql = "DELETE FROM pembelian WHERE id_pen = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            }catch(SQLException e){
                System.out.println("Terjadi Kesalahan");
            }finally{
                loadData();
                bersih();
                autonumber();
            }
        }
        if(question == JOptionPane.CANCEL_OPTION){
        }  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPenjualanMouseClicked
        int i = jPenjualan.getSelectedRow();  
   
        String id = jPenjualan.getValueAt(i, 0).toString();
    

        tIDpen.setText(id);
       
    }//GEN-LAST:event_jPenjualanMouseClicked
    
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
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari2;
    private javax.swing.JButton btnProses;
    public java.awt.Label idP;
    private javax.swing.JTable jBarang;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jPenjualan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lH;
    private javax.swing.JLabel lIdBuku;
    private javax.swing.JLabel lJudul;
    private javax.swing.JLabel lStok;
    private javax.swing.JLabel lTotal;
    private java.awt.Label label1;
    private javax.swing.JTextField tIDpen;
    private javax.swing.JTextField tJumlah;
    private com.toedter.calendar.JDateChooser tTanggal;
    // End of variables declaration//GEN-END:variables
}
