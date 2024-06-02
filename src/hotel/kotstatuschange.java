package hotel;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class kotstatuschange extends javax.swing.JPanel {

    public kotstatuschange() {
        initComponents();
        load_fstatus();
        load_table();
        load_tablea();
        load_tableb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));
        jPanel3.setPreferredSize(new java.awt.Dimension(225, 615));

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("DinaminaUniWeb", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("food");

        jLabel7.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("status");

        jLabel6.setBackground(new java.awt.Color(255, 0, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("pending");

        jComboBox1.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("ticket id");

        jLabel8.setText("0");

        jButton12.setBackground(new java.awt.Color(245, 71, 104));
        jButton12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("update status");
        jButton12.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton12.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton12.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel6))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Incoming Order");
        jLabel3.setPreferredSize(new java.awt.Dimension(137, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 15, 0, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Procesing Order");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 15, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Complete Order");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        jTable4.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ticket id", "customer", "product", "id", "ordered time", "request time", "status", "quentity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
            jTable4.getColumnModel().getColumn(1).setResizable(false);
            jTable4.getColumnModel().getColumn(2).setResizable(false);
            jTable4.getColumnModel().getColumn(4).setResizable(false);
            jTable4.getColumnModel().getColumn(5).setResizable(false);
            jTable4.getColumnModel().getColumn(6).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 551;
        gridBagConstraints.ipady = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 0, 0);
        jPanel4.add(jScrollPane4, gridBagConstraints);

        jTable6.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ticket id", "customer", "product", "id", "ordered time", "request time", "status", "quentity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setResizable(false);
            jTable6.getColumnModel().getColumn(1).setResizable(false);
            jTable6.getColumnModel().getColumn(2).setResizable(false);
            jTable6.getColumnModel().getColumn(4).setResizable(false);
            jTable6.getColumnModel().getColumn(5).setResizable(false);
            jTable6.getColumnModel().getColumn(6).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 551;
        gridBagConstraints.ipady = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 39, 0);
        jPanel4.add(jScrollPane6, gridBagConstraints);

        jTable7.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ticket id", "customer", "product", "id", "ordered time", "request time", "status", "quentity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(0).setResizable(false);
            jTable7.getColumnModel().getColumn(1).setResizable(false);
            jTable7.getColumnModel().getColumn(2).setResizable(false);
            jTable7.getColumnModel().getColumn(4).setResizable(false);
            jTable7.getColumnModel().getColumn(5).setResizable(false);
            jTable7.getColumnModel().getColumn(6).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 551;
        gridBagConstraints.ipady = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(22, 10, 0, 6);
        jPanel4.add(jScrollPane7, gridBagConstraints);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String ing = jComboBox1.getSelectedItem().toString();
        String text = jLabel8.getText();
        int id = Integer.parseInt(text);
        System.out.println(ing);
        System.out.println(id);
        try {
            ResultSet rest = MySQL.execute("SELECT `id` FROM `kot_status` WHERE `status`='" + ing + "' ");
            if (rest.next()) {
                int aInt = rest.getInt("id");
                MySQL.execute("UPDATE `kot` SET `kot_status_id`='" + aInt + "' WHERE `id` = '" + id + "'");
            }
        } catch (Exception e) {
        }
        reset();
        load_table();
        load_tablea();
        load_tableb();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void oneclick() {
        reset();
        int selectedRow = jTable4.getSelectedRow();
        if (selectedRow != -1) {
            String id = jTable4.getValueAt(selectedRow, 0).toString();
            String fname = jTable4.getValueAt(selectedRow, 2).toString();
            String status = jTable4.getValueAt(selectedRow, 6).toString();

            jLabel8.setText(id);
            jComboBox1.setSelectedItem(status);
            jLabel2.setText(fname);
            jLabel6.setText(status);

        }

    }

    private void oneclicka() {
        reset();
        int selectedRow = jTable7.getSelectedRow();
        if (selectedRow != -1) {
            String id = jTable7.getValueAt(selectedRow, 0).toString();
            String fname = jTable7.getValueAt(selectedRow, 2).toString();
            String status = jTable7.getValueAt(selectedRow, 6).toString();

            jLabel8.setText(id);
            jComboBox1.setSelectedItem(status);
            jLabel2.setText(fname);
            jLabel6.setText(status);

        }

    }

    private void oneclickb() {
        reset();
        int selectedRow = jTable6.getSelectedRow();
        if (selectedRow != -1) {
            String id = jTable6.getValueAt(selectedRow, 0).toString();
            String fname = jTable6.getValueAt(selectedRow, 2).toString();
            String status = jTable6.getValueAt(selectedRow, 6).toString();

            jLabel8.setText(id);
            jComboBox1.setSelectedItem(status);
            jLabel2.setText(fname);
            jLabel6.setText(status);

        }

    }

    private void reset() {
        jLabel8.setText("");
        jComboBox1.setSelectedItem(0);
        jLabel2.setText("");
        jLabel6.setText("");
    }

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            oneclick();
        } else if (evt.getClickCount() == 2) {
            reset();
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            oneclicka();
        } else if (evt.getClickCount() == 2) {
            reset();
        }
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            oneclickb();
        } else if (evt.getClickCount() == 2) {
            reset();
        }
    }//GEN-LAST:event_jTable6MouseClicked

    private void load_fstatus() {
        try {
            jComboBox1.removeAllItems();
            Vector v = new Vector();

            ResultSet resultset = MySQL.execute("SELECT `status` FROM  `kot_status`");

            while (resultset.next()) {
                String fcato = resultset.getString("status");

                v.add(fcato);

                DefaultComboBoxModel def = new DefaultComboBoxModel(v);
                jComboBox1.setModel(def);
            }
        } catch (Exception e) {

        }

    }

    private void load_tablea() {
        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable7.getModel();
            tgbc.setRowCount(0);

            ResultSet rest = MySQL.execute("SELECT DISTINCT * FROM kot"
                    + " INNER JOIN kot_has_food ON kot.id=kot_has_food.kot_id "
                    + "INNER JOIN kot_status ON kot.kot_status_id = kot_status.id"
                    + " INNER JOIN customer_visit_hotel ON kot.customer_visit_hotel_id = customer_visit_hotel.id "
                    + "INNER JOIN food_item ON kot_has_food.food_item_id=food_item.id WHERE `status`='Received' OR `status`='Cooking' ");

            while (rest.next()) {

                int id = rest.getInt("id");
                String customer = rest.getString("customer_nic/passport");
                String name = rest.getString("name");

                String fooditem = rest.getString("food_item_id");

                String ordertime = rest.getString("ordered_time");
                String reqtime = rest.getString("req_time");
                String status = rest.getString("status");

                int qty = rest.getInt("qty");

                Vector vtc = new Vector();
                vtc.add(id);
                vtc.add(customer);
                vtc.add(name);

                vtc.add(fooditem);
                vtc.add(ordertime);
                vtc.add(reqtime);
                vtc.add(status);
                vtc.add(qty);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }
    }

    private void load_tableb() {
        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable6.getModel();
            tgbc.setRowCount(0);

            ResultSet rest = MySQL.execute("SELECT DISTINCT * FROM kot "
                    + "INNER JOIN kot_has_food ON kot.id=kot_has_food.kot_id"
                    + " INNER JOIN kot_status ON kot.kot_status_id = kot_status.id"
                    + " INNER JOIN customer_visit_hotel ON kot.customer_visit_hotel_id = customer_visit_hotel.id "
                    + "INNER JOIN food_item ON kot_has_food.food_item_id=food_item.id "
                    + "WHERE `status`='Prepared'");

            while (rest.next()) {

                int id = rest.getInt("id");
                String customer = rest.getString("customer_nic/passport");
                String name = rest.getString("name");

                String fooditem = rest.getString("food_item_id");

                String ordertime = rest.getString("ordered_time");
                String reqtime = rest.getString("req_time");
                String status = rest.getString("status");

                int qty = rest.getInt("qty");

                Vector vtc = new Vector();
                vtc.add(id);
                vtc.add(customer);
                vtc.add(name);

                vtc.add(fooditem);
                vtc.add(ordertime);
                vtc.add(reqtime);
                vtc.add(status);
                vtc.add(qty);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }
    }

    private void load_table() {
        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
            tgbc.setRowCount(0);

            ResultSet rest = MySQL.execute("SELECT DISTINCT * FROM kot "
                    + "INNER JOIN kot_has_food ON kot.id=kot_has_food.kot_id"
                    + " INNER JOIN kot_status ON kot.kot_status_id = kot_status.id"
                    + " INNER JOIN customer_visit_hotel ON kot.customer_visit_hotel_id = customer_visit_hotel.id "
                    + "INNER JOIN food_item ON kot_has_food.food_item_id=food_item.id "
                    + "WHERE `status`='Pending'");

            while (rest.next()) {

                int id = rest.getInt("id");
                String customer = rest.getString("customer_nic/passport");
                String name = rest.getString("name");

                String fooditem = rest.getString("food_item_id");

                String ordertime = rest.getString("ordered_time");
                String reqtime = rest.getString("req_time");
                String status = rest.getString("status");

                int qty = rest.getInt("qty");

                Vector vtc = new Vector();
                vtc.add(id);
                vtc.add(customer);
                vtc.add(name);

                vtc.add(fooditem);
                vtc.add(ordertime);
                vtc.add(reqtime);
                vtc.add(status);
                vtc.add(qty);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    // End of variables declaration//GEN-END:variables
}
