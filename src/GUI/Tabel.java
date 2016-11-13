package GUI;

import Database.Database;
import Function.Format;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Tabel extends javax.swing.JFrame {

    public Tabel() {
        initComponents();
        Database.koneksi(); //koneksi ke database
        
        try {
            addRow("income"); //tambah data di tab income
            addRow("expense"); //tambah data di tab expense
        } catch (ParseException ex) {
            Logger.getLogger(Tabel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addRow(String table) throws ParseException{
        String query = "SELECT * FROM " + table;
        
        try {
            Database.rs = Database.st.executeQuery(query); //ambil data dari database
            
            Format f = new Format(); //instance buat format rupiah dan tanggal
            
            int counter = 0; //angka identifier 
            while(Database.rs.next()){
                counter++; 
               
                //ambil data kolom apa aja yang ada di $table
                DefaultTableModel model = table.equals("income") ? (DefaultTableModel) 
                        tIncome.getModel() : (DefaultTableModel) tExpense.getModel(); 
                
                model.addRow(new Object[]{ //tambah data
                    counter, 
                    f.formatTanggal(Database.rs.getString("date")), 
                    Database.rs.getString(table.equals("income") ? "type" : "name"), 
                    f.formatRupiah(Database.rs.getDouble("amount"))
                });
            }
        } catch (SQLException | NumberFormatException ex ) {
            System.out.println(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tPanel = new javax.swing.JTabbedPane();
        pIncome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tIncome = new javax.swing.JTable();
        pExpense = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tExpense = new javax.swing.JTable();
        pButton = new javax.swing.JPanel();
        bKembali = new javax.swing.JButton();
        bKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaction Record");
        setResizable(false);

        tIncome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE", "TYPE", "AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tIncome.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tIncome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tIncome.setFocusable(false);
        tIncome.setRequestFocusEnabled(false);
        tIncome.getTableHeader().setResizingAllowed(false);
        tIncome.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tIncome);
        if (tIncome.getColumnModel().getColumnCount() > 0) {
            tIncome.getColumnModel().getColumn(0).setResizable(false);
            tIncome.getColumnModel().getColumn(0).setPreferredWidth(1);
            tIncome.getColumnModel().getColumn(1).setResizable(false);
            tIncome.getColumnModel().getColumn(1).setPreferredWidth(3);
            tIncome.getColumnModel().getColumn(2).setResizable(false);
            tIncome.getColumnModel().getColumn(2).setPreferredWidth(3);
            tIncome.getColumnModel().getColumn(3).setResizable(false);
            tIncome.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        javax.swing.GroupLayout pIncomeLayout = new javax.swing.GroupLayout(pIncome);
        pIncome.setLayout(pIncomeLayout);
        pIncomeLayout.setHorizontalGroup(
            pIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        pIncomeLayout.setVerticalGroup(
            pIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pIncomeLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tPanel.addTab("Pemasukan", pIncome);

        tExpense.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE", "PRODUCT NAME", "AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tExpense.setAutoscrolls(false);
        tExpense.setFocusable(false);
        tExpense.getTableHeader().setResizingAllowed(false);
        tExpense.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tExpense);
        if (tExpense.getColumnModel().getColumnCount() > 0) {
            tExpense.getColumnModel().getColumn(0).setResizable(false);
            tExpense.getColumnModel().getColumn(1).setResizable(false);
            tExpense.getColumnModel().getColumn(2).setResizable(false);
            tExpense.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout pExpenseLayout = new javax.swing.GroupLayout(pExpense);
        pExpense.setLayout(pExpenseLayout);
        pExpenseLayout.setHorizontalGroup(
            pExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        pExpenseLayout.setVerticalGroup(
            pExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExpenseLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        tPanel.addTab("Pengeluaran", pExpense);

        bKembali.setText("Kembali");
        bKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKembaliActionPerformed(evt);
            }
        });

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pButtonLayout = new javax.swing.GroupLayout(pButton);
        pButton.setLayout(pButtonLayout);
        pButtonLayout.setHorizontalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bKeluar)
                .addContainerGap())
        );
        pButtonLayout.setVerticalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bKeluar)
                .addComponent(bKembali))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPanel)
                    .addComponent(pButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(602, 244));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKembaliActionPerformed
        new MainMenu().setVisible(true); //buka frame main menu
        dispose(); //tutup frame
    }//GEN-LAST:event_bKembaliActionPerformed

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        dispose(); //tutup aplikasi
    }//GEN-LAST:event_bKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bKembali;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pButton;
    private javax.swing.JPanel pExpense;
    private javax.swing.JPanel pIncome;
    private javax.swing.JTable tExpense;
    private javax.swing.JTable tIncome;
    private javax.swing.JTabbedPane tPanel;
    // End of variables declaration//GEN-END:variables
}
