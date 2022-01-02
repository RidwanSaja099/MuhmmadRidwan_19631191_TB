
package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Input_Buku extends javax.swing.JFrame {
   koneksi koneksi = new koneksi();
   
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    String sql;
    private DefaultTableModel model;
    
     private void autonumber(){
       try{
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM input_buku ORDER BY kode_buku DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()){
                String NoBarang = r.getString("kode_buku").substring(2);
                String BR = "" + (Integer.parseInt(NoBarang) + 1);
                String Nol = "";
                
                if(BR.length()==1){
                    Nol = "00";
                }else if(BR.length()==2){
                    Nol = "0";
                }else if(BR.length()==3){
                    Nol = "";
                }
                
                tKode.setText("BK" + Nol + BR);
                
            }else{
                tKode.setText("BK001");
            }
            r.close();
            s.close();
        }catch(Exception e){
            System.out.println("autonumber error");
        }
    }
    
  public void bersih(){
      tKode.setText("");
      tNama.setText("");
      tTahun.setText("");
      tPenulis.setText("");
      tHarga .setText("");
      tStok .setText("");
      
      autonumber();
  }
  
  public void loadData(){
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
    
    public Input_Buku() {
            initComponents();
         this.setLocationRelativeTo(null);
         tKode.setEnabled(false);

         model = new DefaultTableModel();

         jTable2.setModel(model);
         model.addColumn("Kode Buku");
         model.addColumn("Judul Buku");
         model.addColumn("Jenis");
         model.addColumn("Penulis");
         model.addColumn("Tahun");
         model.addColumn("Harga");
         model.addColumn("Stok");

         loadData();
         autonumber();
         
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        cJenis = new javax.swing.JComboBox<>();
        tPenulis = new javax.swing.JTextField();
        tTahun = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tHarga = new javax.swing.JTextField();
        tStok = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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

        jLabel1.setText("Kode Buku");

        jLabel2.setText("Judul Buku");

        jLabel3.setText("Penulis");

        jLabel4.setText("Jenis");

        jLabel5.setText("Tahun Terbit");

        cJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novel ", "Cergam", "Komik", "Ensiklopedi", "Nomik", "Antologi", "Dongeng", "Biografi", "Catatan Harian", "Novelet", "Fotografi", "Karya Ilmiah", "Tafsir", "Kamus", "Panduan (how to)", "Atlas ", "Buku Ilmiah", "Teks ", "Majalah", "Buku Digital", " " }));
        cJenis.setToolTipText("");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBersih.setText("Clear");
        btnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");

        jLabel7.setText("Harga");

        jLabel8.setText("Stok");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBersih)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(keluar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tPenulis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(tKode, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tNama, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(tTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnTambah)
                    .addComponent(btnHapus)
                    .addComponent(btnBersih)
                    .addComponent(keluar))
                .addGap(2, 2, 2))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 380, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Form Tambah Data Buku");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 950, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String id = tKode.getText();
        String nama = tNama.getText();
        String jenis = (String)cJenis.getSelectedItem();
        String penulis = tPenulis.getText();
        String tahun = tTahun.getText();
        String harga = tHarga.getText();
        String stok = tStok.getText();
        
        try{
            Connection c = koneksi.getKoneksi();
            String sql = "insert into input_buku values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama);
            p.setString(3, jenis);
            p.setString(4, penulis);
            p.setString(5, tahun);
            p.setString(6, harga);
            p.setString(7, stok);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        }catch(SQLException e){
            System.out.println("Terjadi Kesalahan");
        }finally{
            loadData();
            bersih();
            autonumber();
        }
    
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int i = jTable2.getSelectedRow();
        if(i == -1){
            return;
        }
        String id = (String)model.getValueAt(i, 0);
        String nama = tNama.getText();
        String jenis = (String)cJenis.getSelectedItem();
        String penulis = tPenulis.getText();
        String tahun = tTahun.getText();
        String harga = tHarga.getText();
        String stok = tStok.getText();
        try{
            Connection c = koneksi.getKoneksi();
            String sql = "UPDATE input_buku SET judul = ?, jenis = ?,penulis= ?, tahun= ?, harga = ? WHERE kode_buku = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama);
            p.setString(2, jenis);
            p.setString(3, penulis);
            p.setString(4, tahun);
            p.setString(5, harga);
            p.setString(6, stok);
            p.setString(7, id);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Terubah");
            btnTambah.setEnabled(true);
            bersih();
        }catch(SQLException e){
            System.out.println("Update Error");
        }finally{
            loadData();
            autonumber();
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int i = jTable2.getSelectedRow();
        if(i == -1){
            return;
        }

        String id = (String)model.getValueAt(i, 0);

        int question = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION){
            try{
                Connection c = koneksi.getKoneksi();
                String sql = "DELETE FROM input_buku WHERE kode_buku = ?";
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

    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
        bersih();
        loadData();
        btnTambah.setEnabled(true);
        autonumber();
    }//GEN-LAST:event_btnBersihActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        btnTambah.setEnabled(false);
        int i = jTable2.getSelectedRow();
        if (i == -1){
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        tKode.setText(id);
        String nama = (String)model.getValueAt(i, 1);
        tNama.setText(nama);
        String jenis = (String)model.getValueAt(i, 2);
        cJenis.setSelectedItem(jenis);
        String penulis = (String)model.getValueAt(i, 3);
        tPenulis.setText(penulis);
        String tahun = (String)model.getValueAt(i, 4);
        tTahun.setText(tahun);
        String harga = (String)model.getValueAt(i, 5);
        tHarga.setText(harga);
        String stok = (String)model.getValueAt(i, 6);
        tStok.setText(stok);
    
    }//GEN-LAST:event_jTable2MouseClicked
 
      
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
                java.util.logging.Logger.getLogger(Input_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input_Buku().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tPenulis;
    private javax.swing.JTextField tStok;
    private javax.swing.JTextField tTahun;
    // End of variables declaration//GEN-END:variables
}
