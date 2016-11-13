package GUI;

import Database.Database;
import Database.Session;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Income extends javax.swing.JFrame {

    public Income() {
        initComponents();
        Database.koneksi(); //koneksi ke database
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lAmbil = new javax.swing.JLabel();
        lJudul = new javax.swing.JLabel();
        tfJumlah = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rAtm = new javax.swing.JRadioButton();
        rOrtu = new javax.swing.JRadioButton();
        bSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ambil Uang");
        setResizable(false);

        lAmbil.setText("TOTAL AMBIL UANG");

        lJudul.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        lJudul.setText("INCOME");

        jLabel1.setText("SUMBER");

        bGroup1.add(rAtm);
        rAtm.setSelected(true);
        rAtm.setText("ATM");

        bGroup1.add(rOrtu);
        rOrtu.setText("ORANG TUA");

        bSubmit.setText("Submit");
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lJudul))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAmbil)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rOrtu, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(tfJumlah)
                            .addComponent(rAtm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bSubmit)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAmbil)
                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rAtm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rOrtu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSubmit)
                .addContainerGap())
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void bSubmitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        double jml    = Double.parseDouble(tfJumlah.getText()); //ambil jumlah uang yang diambil
        double dompet = Session.dompet + jml; //simpen jumlah uang di dompet yang baru
        double saldo  = rAtm.isSelected() ? Session.saldo - jml : Session.saldo; //simpen jumlah saldo yang baru
        
        String query = "UPDATE user SET dompet = ?, saldo = ? WHERE username = ?";
        
        try {
            PreparedStatement pr = Database.conn.prepareStatement(query);
            pr.setDouble(1, dompet);
            pr.setDouble(2, saldo);
            pr.setString(3, Session.username);
            
            if(pr.executeUpdate() == 1){
              JOptionPane.showMessageDialog(rootPane,"UPDATE SUKSES!");
              
              //update database untuk tabel
              String qUpdate = "INSERT INTO income (type, amount) VALUES (?,?)";
              PreparedStatement pr2 = Database.conn.prepareStatement(qUpdate);
              pr2.setString(1, rAtm.isSelected() ? "ATM" : "Orang Tua");
              pr2.setDouble(2, jml);
              pr2.execute();
              
              //simpen data yang baru di session
              Session.dompet = dompet;
              Session.saldo = saldo;
              
              Database.conn.close(); //tutup koneksi ke database
              
              dispose(); //tutup frame
            }
            else
              JOptionPane.showMessageDialog(rootPane, "Update gagal");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error!");
        }
    }                                       

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup bGroup1;
    private javax.swing.JButton bSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lAmbil;
    private javax.swing.JLabel lJudul;
    private javax.swing.JRadioButton rAtm;
    private javax.swing.JRadioButton rOrtu;
    private javax.swing.JTextField tfJumlah;
    // End of variables declaration                   
}
