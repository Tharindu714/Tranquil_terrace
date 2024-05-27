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

    private int ftid;

    String query = ("SELECT *FROM `ingrediant`\n" +
"INNER JOIN `food_item` ON `ingrediant`.`food_item_id` = `food_item`.`id`\n" +
"INNER JOIN (SELECT `kot_id`, `food_item_id`, `qty` FROM `kot_has_food`) AS `food_qty`\n" +
"ON `ingrediant`.`food_item_id` = `food_qty`.`food_item_id`");
    
    HashMap<String, String> UnitMap = new HashMap<>();

    public ingsetup() {
        initComponents();
        loadKStock(query + "ORDER BY `ingrediant`.`id` ASC");
        seting();
    }

    private void loadKStock(String query) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("food_item.name"));
                v.add(resultSet.getString("food_item.price"));
                v.add(resultSet.getString("qty"));
                v.add(resultSet.getString("food_qty.qty"));
                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        private void seting() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `id`,`name` FROM `item`");

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
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
        jLabel9.setText("Food Product");
        jLabel9.setPreferredSize(new java.awt.Dimension(200, 25));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select Ingredient QTY");

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

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

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
                    .addComponent(jTextField1)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(8, 8, 8)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(8, 8, 8)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Food ", "Food Price", "Ingredient QTY", "Set Portion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            oneclick();
        } else if (evt.getClickCount() == 2) {
            reset();
        }
    }//GEN-LAST:event_jTable2MouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
