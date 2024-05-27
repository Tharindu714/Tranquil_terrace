package hotel;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class ingsetup extends javax.swing.JPanel {

    private int ftid;

    public ingsetup() {
        initComponents();
        seting();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(225, 615));

        jPanel1.setPreferredSize(new java.awt.Dimension(225, 615));

        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ingrediant setup");

        jLabel9.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("search food product");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(52, 73, 94));
        jButton12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("add ingrediant");
        jButton12.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton12.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton12.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(245, 71, 104));
        jButton13.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("update ingrediant");
        jButton13.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton13.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton13.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("select ingrediant");

        jComboBox1.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("set size");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(52, 73, 94));
        jButton1.setText("view table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jTable2.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "food ", "select ingrediant", "set size", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 591;
        gridBagConstraints.ipady = 397;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 0, 16);
        jPanel4.add(jScrollPane2, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 607;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 21, 16);
        jPanel4.add(jPanel2, gridBagConstraints);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        String foodname = jTextField1.getText();
        String ing = jComboBox1.getSelectedItem().toString();
        String qty = jTextField2.getText();
        double qqq = Double.parseDouble(qty);

        if (foodname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter food name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (ing.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select food gategory", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter price", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                ResultSet rest = MySQL.execute("SELECT `id` FROM `item` WHERE `iname`='" + ing + "' ");
                ResultSet frest = MySQL.execute("SELECT `id` FROM `food_item` WHERE `name`='" + foodname + "' ");
                if (rest.next()) {

                    if (frest.next()) {
                        int id = rest.getInt("id");
                        int fid = frest.getInt("id");

                        MySQL.execute("INSERT INTO `ingrediant` (`food_item_id`,`ing_item`,`qty`) VALUES ('" + fid + "','" + id + "','" + qqq + "');");

                    }

                }

            } catch (Exception e) {
            }
            reset();

        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void oneclick() {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
            String name = jTable2.getValueAt(selectedRow, 0).toString();
            String ing = jTable2.getValueAt(selectedRow, 1).toString();
            String qty = jTable2.getValueAt(selectedRow, 2).toString();
            String id = jTable2.getValueAt(selectedRow, 3).toString();

            jTextField1.setText(name);
            jComboBox1.setSelectedItem(ing);
            jTextField2.setText(qty);
            ftid = Integer.parseInt(id);

        }

    }

    private void reset() {
        jTextField1.setText("");
        jComboBox1.setSelectedItem(0);
        jTextField2.setText("");

        DefaultTableModel tgbc = (DefaultTableModel) jTable2.getModel();
        tgbc.setRowCount(0);

    }


    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        String foodname = jTextField1.getText();
        String ing = jComboBox1.getSelectedItem().toString();
        String qty = jTextField2.getText();
        double qqq = Double.parseDouble(qty);

        if (foodname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter food name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (ing.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select food gategory", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter price", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                ResultSet rest = MySQL.execute("SELECT `id` FROM `item` WHERE `iname`='" + ing + "' ");
                ResultSet frest = MySQL.execute("SELECT `id` FROM `food_item` WHERE `name`='" + foodname + "' ");
                if (rest.next()) {

                    if (frest.next()) {
                        int id = rest.getInt("id");
                        int fid = frest.getInt("id");

                        MySQL.execute("UPDATE  `ingrediant` SET `food_item_id`='" + fid + "', `ing_item`='" + id + "', `qty`='" + qqq + "' WHERE `id`='" + ftid + "' ");

                    }

                }

            } catch (Exception e) {
            }
            reset();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        loadtdata();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loaddata();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            oneclick();
        } else if (evt.getClickCount() == 2) {
            reset();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void seting() {
        try {
            jComboBox1.removeAllItems();
            Vector v = new Vector();

            ResultSet resultset = MySQL.execute("SELECT `iname` FROM  `item`");

            while (resultset.next()) {
                String iato = resultset.getString("iname");

                System.out.println(iato);
                v.add(iato);

                DefaultComboBoxModel def = new DefaultComboBoxModel(v);
                jComboBox1.setModel(def);
            }
        } catch (Exception e) {

        }

    }

    private void loaddata() {

        String foodname = jTextField1.getText();
        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable2.getModel();
            tgbc.setRowCount(0);

            ResultSet rest = MySQL.execute("SELECT * FROM `food_item` WHERE `name` LIKE '" + foodname + "%'");

            while (rest.next()) {

                int id = rest.getInt("id");
                String name = rest.getString("name");
                String nulll = "";

                Vector vtc = new Vector();

                vtc.add(name);
                vtc.add(nulll);

                vtc.add(nulll);
                vtc.add(nulll);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }

    }

    private void loadtdata() {

        String foodname = jTextField1.getText();
        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable2.getModel();
            tgbc.setRowCount(0);

            ResultSet rest = MySQL.execute("SELECT DISTINCT * FROM "
                    + "ingrediant INNER JOIN food_item ON "
                    + "ingrediant.food_item_id = food_item.id INNER JOIN item ON"
                    + " ingrediant.ing_item =item.id  WHERE `name` LIKE '" + foodname + "%'");

            while (rest.next()) {

                int id = rest.getInt("id");
                String name = rest.getString("name");
                String iname = rest.getString("iname");
                String qty = rest.getString("qty");

                Vector vtc = new Vector();

                vtc.add(name);
                vtc.add(iname);

                vtc.add(qty);
                vtc.add(id);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }
    }

    private void load_c() {
        try {
            jComboBox1.removeAllItems();
            Vector v = new Vector();

            ResultSet resultset = MySQL.execute("SELECT `category` FROM  `food_category`");

            while (resultset.next()) {
                String cato = resultset.getString("category");

                System.out.println(cato);
                v.add(cato);

                DefaultComboBoxModel def = new DefaultComboBoxModel(v);
                jComboBox1.setModel(def);
            }
        } catch (Exception e) {

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
