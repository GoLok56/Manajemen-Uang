package GUI;

import Database.Session;
import Function.Format;
import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        lJudul.setText(lJudul.getText() + " " + Session.name);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lJudul = new javax.swing.JLabel();
        bDompet = new javax.swing.JButton();
        bSaldo = new javax.swing.JButton();
        bIncome = new javax.swing.JButton();
        bExpense = new javax.swing.JButton();
        lDompet = new javax.swing.JLabel();
        lSaldo = new javax.swing.JLabel();
        lOutcome = new javax.swing.JLabel();
        lIncome = new javax.swing.JLabel();
        bKeluar = new javax.swing.JButton();
        lKeluar = new javax.swing.JLabel();
        bTabel = new javax.swing.JButton();
        lTabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manajemen Uang");

        lJudul.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        lJudul.setText("SELAMAT DATANG,");

        bDompet.setText("-");
        bDompet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDompetActionPerformed(evt);
            }
        });

        bSaldo.setText("-");
        bSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaldoActionPerformed(evt);
            }
        });

        bIncome.setText("-");
        bIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIncomeActionPerformed(evt);
            }
        });

        bExpense.setText("-");
        bExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExpenseActionPerformed(evt);
            }
        });

        lDompet.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lDompet.setText("CEK DOMPET");

        lSaldo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lSaldo.setText("CEK SALDO");

        lOutcome.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lOutcome.setText("ATUR PENGELUARAN");

        lIncome.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lIncome.setText("ATUR PEMASUKAN");

        bKeluar.setText("-");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        lKeluar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lKeluar.setText("KELUAR");

        bTabel.setText("-");
        bTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTabelActionPerformed(evt);
            }
        });

        lTabel.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lTabel.setText("CEK RECORD TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 150, Short.MAX_VALUE)
                .addComponent(lJudul)
                .addGap(92, 92, 92))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bDompet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lDompet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lIncome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lOutcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lTabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lKeluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bDompet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lDompet))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lIncome)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lSaldo))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lOutcome)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lTabel)
                        .addComponent(lKeluar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        lJudul.getAccessibleContext().setAccessibleName("SELAMAT DATANG, ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(426, 285));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        dispose(); //exit aplikasi
    }//GEN-LAST:event_bKeluarActionPerformed

    private void bTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTabelActionPerformed
        new Tabel().setVisible(true); //buka frame tabel
        dispose(); //tutup frame
    }//GEN-LAST:event_bTabelActionPerformed

    private void bDompetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDompetActionPerformed
        cekUsername("dompet"); //cek jumlah uang di dompet
    }//GEN-LAST:event_bDompetActionPerformed

    private void bSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaldoActionPerformed
        cekUsername("saldo"); //cek jumlah saldo
    }//GEN-LAST:event_bSaldoActionPerformed

    private void bIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIncomeActionPerformed
        new Income().setVisible(true); //buka frame income
    }//GEN-LAST:event_bIncomeActionPerformed

    private void bExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExpenseActionPerformed
        new Expense().setVisible(true); //buka frame expense
    }//GEN-LAST:event_bExpenseActionPerformed
    
    private void cekUsername(String checked){
        String username = JOptionPane.showInputDialog(rootPane, "MASUKKAN USERNAME ANDA!",
                "");
        
        Format f = new Format(); //instance buat format rupiah
        
        if(username.equals(Session.username)){ //cek username bener apa ga?
            
            //cek apa yang mau di cek? saldo? dompet?
            if(checked.equals("saldo")) 
                JOptionPane.showMessageDialog(rootPane, "SISA SALDO ANDA : " + 
                        f.formatRupiah(Session.saldo));
            else 
                JOptionPane.showMessageDialog(rootPane, "SISA UANG DI DOMPET ANDA : "
                        + f.formatRupiah(Session.dompet));
            
        }else
            JOptionPane.showMessageDialog(rootPane, "USERNAME SALAH, ANDA SIAPA?");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDompet;
    private javax.swing.JButton bExpense;
    private javax.swing.JButton bIncome;
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bSaldo;
    private javax.swing.JButton bTabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lDompet;
    private javax.swing.JLabel lIncome;
    private javax.swing.JLabel lJudul;
    private javax.swing.JLabel lKeluar;
    private javax.swing.JLabel lOutcome;
    private javax.swing.JLabel lSaldo;
    private javax.swing.JLabel lTabel;
    // End of variables declaration//GEN-END:variables
}
