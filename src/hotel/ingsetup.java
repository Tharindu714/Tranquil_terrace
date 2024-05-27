package hotel;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author maleesha
 */
public class ingsetup extends javax.swing.JPanel {

    String query = ("SELECT *FROM `item`\n"
            + "INNER JOIN `item_unit` ON `item`.`item_unit_id` = `item_unit`.`id`\n");

    HashMap<String, String> UnitMap = new HashMap<>();
    HashMap<String, String> itemMap = new HashMap<>();
    HashMap<String, String> foodMap = new HashMap<>();

    public ingsetup() {
        initComponents();
        loadKStock(query + "ORDER BY `item`.`id` ASC");
        seting();
        foodLoad();
        loadUnits();
    }

    private void loadKStock(String query) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("name"));
                v.add(resultSet.getString("min_qty"));
                v.add(resultSet.getString("current_qty"));
                v.add(resultSet.getString("item_unit.unit"));
                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void foodLoad() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `id`,`name` FROM `food_item`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                foodMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox2.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void seting() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `item`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                UnitMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox1.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadUnits() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `item_unit`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("unit"));
                itemMap.put(resultSet.getString("unit"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox3.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setPreferredSize(new java.awt.Dimension(225, 565));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select Food Product");
        jLabel9.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select Item Name");

        jComboBox1.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox1.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Set Portion");

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(102, 102, 102));
        jButton12.setText("Add Ingredient");
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
        jButton13.setText("Update Ingredient");
        jButton13.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton13.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton13.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox2.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Current QTY");

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Minimum QTY");

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jComboBox3.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox3.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Item Unit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField3))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addGap(8, 8, 8)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addGap(8, 8, 8)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Food ", "Minimum QTY", "Current QTY", "Item Unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionBackground(new java.awt.Color(245, 71, 104));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(52, 73, 94));

        jLabel6.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TRANQUIL TERRACE | Ingredient Setup");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        String foodname = jComboBox2.getSelectedItem().toString();
        String ing = jComboBox1.getSelectedItem().toString();
        String unitid = jComboBox3.getSelectedItem().toString();

        String qty = jFormattedTextField1.getText();
        String c_qty = jFormattedTextField2.getText();
        String m_qty = jFormattedTextField3.getText();

        double m = Double.parseDouble(m_qty);
        double c = Double.parseDouble(c_qty);

        double current = m - c;

        if (foodname.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please enter food name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (ing.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select ingrediant Quantity", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (unitid.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select the unit", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the Portion", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (c_qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the Current Qty", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (m_qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the Minimum Qty", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                MySQL.execute("INSERT INTO "
                        + "`item`(`name`,`min_qty`,`current_qty`,`item_unit_id`)"
                        + "VALUES('" + ing + "','" + m_qty + "','" + c_qty + "','" + itemMap.get(unitid) + "')");

                MySQL.execute("INSERT INTO "
                        + "`ingrediant`(`qty`,`food_item_id`)"
                        + "VALUES('" + qty + "','" + foodMap.get(foodname) + "')");

            } catch (Exception e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "New Food item Added Successfully", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            reset();
            loadKStock(query + "ORDER BY `item`.`id` ASC");
            seting();
            foodLoad();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
        String foodname = jComboBox2.getSelectedItem().toString();
        String ing = jComboBox1.getSelectedItem().toString();
        String unitid = jComboBox3.getSelectedItem().toString();
        String id = jTable2.getValueAt(selectedRow, 0).toString();

        String qty = jFormattedTextField1.getText();
        
        double m_qty = Double.parseDouble(jTable2.getValueAt(selectedRow, 3).toString());
        double c_qty = Double.parseDouble(jFormattedTextField2.getText());
        double newqty = m_qty - c_qty;
        jFormattedTextField3.setText(String.valueOf(newqty));
        
        String Snew = jFormattedTextField3.getText();

        if (foodname.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please enter food name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (ing.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select ingrediant Quantity", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (unitid.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select the unit", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the Portion", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                MySQL.execute("UPDATE `ingrediant` SET "
                        + "`qty` = '" + qty + "' WHERE `food_item_id` = '" + foodMap.get(foodname) + "'");

                MySQL.execute("UPDATE `item` SET "
                        + "`current_qty` = '" + c_qty + "' ,"
                        + "`min_qty` = '" + Snew + "' "
                        + "WHERE `id` = '" + id + "'");

            } catch (Exception e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "Portion Updated Successfully", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            reset();
            loadKStock(query + "ORDER BY `item`.`id` ASC");
            seting();
            foodLoad();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            oneclick();
        } else if (evt.getClickCount() == 2) {
            reset();
            loadKStock(query + "ORDER BY `item`.`id` ASC");
            seting();
            foodLoad();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        try {
            String foodname = jComboBox2.getSelectedItem().toString();
            MySQL.execute("INSERT INTO "
                    + "`ingrediant`(`qty`,`food_item_id`)"
                    + "VALUES('0','" + foodMap.get(foodname) + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jFormattedTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyReleased

    }//GEN-LAST:event_jFormattedTextField2KeyReleased

    private void oneclick() {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
            String name = jTable2.getValueAt(selectedRow, 1).toString();
//            String m_qty = jTable2.getValueAt(selectedRow, 2).toString();
            String c_qty = jTable2.getValueAt(selectedRow, 3).toString();
            String unit = jTable2.getValueAt(selectedRow, 4).toString();

            jComboBox1.setSelectedItem(name);
            jFormattedTextField2.setText(c_qty);
            jComboBox3.setSelectedItem(unit);

            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
            jFormattedTextField3.setEnabled(false);
            jButton12.setEnabled(false);
        }
    }

    private void reset() {
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jFormattedTextField3.setText("");
        jFormattedTextField3.setEnabled(true);
        jComboBox1.setSelectedItem(0);
        jComboBox2.setSelectedItem(0);
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jComboBox3.setEnabled(true);
        jButton12.setEnabled(true);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
