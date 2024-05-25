package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class Check_inv_list extends javax.swing.JFrame {

    String query = ("SELECT * FROM `customer_visit_hotel`\n"
            + "INNER JOIN `customer` ON `customer_visit_hotel`.`customer_nic/passport` = `customer`.`nic/passport`\n"
            + "INNER JOIN `payement_method` ON `customer_visit_hotel`.`payment_method_id` = `payement_method`.`id`\n");

    HashMap<String, String> payMap = new HashMap<>();
    HashMap<String, String> cushMap = new HashMap<>();
    HashMap<String, String> mobMap = new HashMap<>();

    public Check_inv_list() {
        initComponents();
        loadInv(query + "ORDER BY `customer_visit_hotel`.`id` ASC;");
        setExtendedState(MAXIMIZED_BOTH);
        loadPayment();
        loadCustomer();
        loadMobile();
    }

    private void loadInv(String query) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("customer_nic/passport"));
                v.add(resultSet.getString("customer.full_name"));
                v.add(resultSet.getString("customer.mobile"));
                v.add(resultSet.getString("total"));
                v.add(resultSet.getString("pax"));
                v.add(resultSet.getString("payement_method.method"));
                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadPayment() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `payement_method`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("method"));
                payMap.put(resultSet.getString("method"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox4.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCustomer() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `full_name`,`nic/passport` FROM `customer`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("full_name"));
                cushMap.put(resultSet.getString("full_name"), resultSet.getString("nic/passport"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox6.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMobile() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `mobile`,`nic/passport` FROM `customer`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("mobile"));
                mobMap.put(resultSet.getString("mobile"), resultSet.getString("nic/passport"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox5.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchCustomer() {
        String customer = jComboBox6.getSelectedItem().toString();

        if (customer.equals(0)) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`id` ASC");

        } else {
            loadInv(query + "WHERE `customer`.`full_name`='" + customer + "' ");
        }
    }

    private void SearchMobile() {
        String mobile = jComboBox5.getSelectedItem().toString();

        if (mobile.equals(0)) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`id` ASC");

        } else {
            loadInv(query + "WHERE `customer`.`mobile`='" + mobile + "' ");
        }
    }

    private void Searchpay() {
        String pay = jComboBox4.getSelectedItem().toString();

        if (pay.equals(0)) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`id` ASC");

        } else {
            loadInv(query + "WHERE `payement_method`.`method`='" + pay + "' ");
        }
    }

    private void IDSearch() {
        int sortIndex = jComboBox1.getSelectedIndex();

        if (sortIndex == 0) {
            loadInv(query);

        } else if (sortIndex == 1) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`id` DESC");

        } else if (sortIndex == 2) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`id` ASC");
        }
    }

    private void paxSearch() {
        int sortIndex = jComboBox2.getSelectedIndex();

        if (sortIndex == 0) {
            loadInv(query);

        } else if (sortIndex == 1) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`pax` DESC");

        } else if (sortIndex == 2) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`pax` ASC");
        }
    }

    private void totalSearch() {
        int sortIndex = jComboBox3.getSelectedIndex();

        if (sortIndex == 0) {
            loadInv(query);

        } else if (sortIndex == 1) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`total` DESC");

        } else if (sortIndex == 2) {
            loadInv(query + "ORDER BY `customer_visit_hotel`.`total` ASC");
        }
    }

    private void loadUI() {
        loadInv(query + "ORDER BY `customer_visit_hotel`.`id` ASC");
        loadPayment();
        loadCustomer();
        loadMobile();
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(52, 73, 94));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton14.setContentAreaFilled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TRANQUIL TERRACE | Invoice History");

        jButton4.setBackground(new java.awt.Color(18, 173, 193));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/view-detail.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NIC / Passport", "Customer Name", "Mobile", "Full amount", "PAX", "Payment Method"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(245, 71, 104));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(800, 60));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Invoice ID");

        jComboBox1.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "ID DESC", "ID ASC" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Guest Count");

        jComboBox2.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Pax DESC", "Pax ASC" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Full Amount");

        jComboBox3.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Amount DESC", "Amount ASC" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Card | Cash");

        jComboBox4.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Customer Mobile");

        jComboBox5.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Customer Name");

        jComboBox6.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(18, 173, 193));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/refresh.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        IDSearch();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        paxSearch();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        totalSearch();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        Searchpay();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        SearchMobile();
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        searchCustomer();
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadUI();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you need to Print Invoice History Report?", "Confirm Alert",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                HashMap<String, Object> map = new HashMap<>();

                String reportPath = "src//reports//invoice.jasper";

                JRDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, map, dataSource);
                JasperViewer.viewReport(jasperPrint, false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            loadUI();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Check_inv_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
