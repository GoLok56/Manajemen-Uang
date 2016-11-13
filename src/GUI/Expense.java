package GUI;

import Database.Database;
import Database.Session;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Expense extends javax.swing.JFrame {

    public Expense() {
        initComponents();
        Database.koneksi(); //koneksi ke database
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lJudul = new javax.swing.JLabel();
        lNama = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        lHarga = new javax.swing.JLabel();
        tfHarga = new javax.swing.JTextField();
        bBeli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BELI BARANG");
        setResizable(false);

        lJudul.setFont(new java.awt.Font("Garuda", 0, 18)); // NOI18N
        lJudul.setText("OUTCOME");

        lNama.setText("Nama Barang");

        lHarga.setText("Harga Barang");

        bBeli.setText("BELI");
        bBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBeliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNama)
                    .addComponent(lHarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lJudul)
                        .addGap(142, 142, 142))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNama)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lHarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBeli)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(386, 199));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBeliActionPerformed
        String nama   = tfNama.getText(); //ambil nama dari textfield
        double harga  = Double.parseDouble(tfHarga.getText()); //ambil harga
        double dompet = Session.dompet - harga; //simpen jumlah uang di dompet yang baru
        
        String query  = "UPDATE user SET dompet = ? WHERE username = ?";
        
        try{
            
            PreparedStatement pr = Database.conn.prepareStatement(query);
            pr.setDouble(1, dompet);
            pr.setString(2, Session.username);
            
            if(pr.executeUpdate() == 1){ 
              JOptionPane.showMessageDialog(rootPane,"UPDATE SUKSES!");
              
              //update database buat tabel
              String qUpdate = "INSERT INTO outcome (name, amount) VALUES (?,?)";
              PreparedStatement pr2 = Database.conn.prepareStatement(qUpdate);
              pr2.setString(1, nama);
              pr2.setDouble(2, harga);
              pr2.execute();
              
              Session.dompet = dompet; //simpet jumlah uang di dompet ke session
              
              Database.conn.close(); //tutup koneksi database
              
              dispose(); //tutup frame
            }
            else
              JOptionPane.showMessageDialog(rootPane, "Update gagal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error");
        }
    }//GEN-LAST:event_bBeliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBeli;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lHarga;
    private javax.swing.JLabel lJudul;
    private javax.swing.JLabel lNama;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfNama;
    // End of variables declaration//GEN-END:variables
}
