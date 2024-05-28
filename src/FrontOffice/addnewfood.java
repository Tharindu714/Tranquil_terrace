package FrontOffice;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;


/**
 *
 * @author maleesha
 */
public class addnewfood extends javax.swing.JPanel {

    private int fid;

    /**

     */
    public addnewfood() {
        initComponents();
        load_c();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(300, 300));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(240, 515));

        jLabel8.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("add new food ");

        jLabel9.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("food name");

        jLabel10.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("food category");

        jComboBox1.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("price");

        jButton12.setBackground(new java.awt.Color(52, 73, 94));
        jButton12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("add new food");
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
        jButton13.setText("update food");
        jButton13.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton13.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton13.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 102));
        jLabel13.setText("food id");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, 185, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jTable1.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "food name", "food category", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 504;
        gridBagConstraints.ipady = 480;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(39, 18, 76, 22);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        String foodname = jTextField3.getText();
        String foodcatogory = jComboBox1.getSelectedItem().toString();
        String foodprice = jTextField2.getText();
        double price = Double.parseDouble(foodprice);

        if (foodname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter food name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (foodcatogory.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select food gategory", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (foodprice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter price", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                ResultSet rest = MySQL.execute("SELECT `id` FROM `food_category` WHERE `category`='" + foodcatogory + "' ");
                if (rest.next()) {
                    int id = rest.getInt("id");
                    MySQL.execute("INSERT INTO `food_item` (`name`,`price`,`food_category_id`) VALUES ('" + foodname + "','" + price + "','" + id + "')");

                }

            } catch (Exception e) {
            }
            reset();

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void oneclick() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String name = jTable1.getValueAt(selectedRow, 1).toString();
            String cat = jTable1.getValueAt(selectedRow, 2).toString();
            String price = jTable1.getValueAt(selectedRow, 3).toString();
            String id = jTable1.getValueAt(selectedRow, 0).toString();

            jTextField3.setText(name);
            jComboBox1.setSelectedItem(cat);
            jTextField2.setText(price);
            jLabel13.setText(id);
            fid = Integer.parseInt(id);
            jButton12.setEnabled(false);

        }
    }

    private void reset() {
        jTextField3.setText("");
        jComboBox1.setSelectedItem(0);
        jTextField2.setText("");
        jLabel13.setText("food id ");
        jButton12.setEnabled(true);
        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        tgbc.setRowCount(0);

    }


    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        String foodname = jTextField3.getText();

        String foodcatogory = jComboBox1.getSelectedItem().toString();
        String foodprice = jTextField2.getText();
        double price = Double.parseDouble(foodprice);

        if (foodname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter food name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (foodcatogory.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please select food gategory", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (foodprice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter price", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                ResultSet rest = MySQL.execute("SELECT `id` FROM `food_category` WHERE `category`='" + foodcatogory + "' ");
                if (rest.next()) {
                    int id = rest.getInt("id");
                    MySQL.execute("UPDATE food_item SET `name`='" + foodname + "',`price`='" + price + "',`food_category_id`='" + id + "' WHERE `id` = '"+fid+"'");

                }

            } catch (Exception e) {
            }
            reset();

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        loaddata();
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            oneclick();
        } else if (evt.getClickCount() == 2) {
            reset();
        }
    }//GEN-LAST:event_jTable1MouseClicked

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

    private void loaddata() {

        String foodname = jTextField3.getText();
        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
            tgbc.setRowCount(0);

            ResultSet rest = MySQL.execute("SELECT DISTINCT * from food_item INNER JOIN food_category ON food_item.food_category_id = food_category.id WHERE `name` LIKE'" + foodname + "%'");

            while (rest.next()) {

                int id = rest.getInt("id");
                String name = rest.getString("name");
                String cname = rest.getString("category");
                String price = rest.getString("price");

                Vector vtc = new Vector();
                vtc.add(id);
                vtc.add(name);
                vtc.add(cname);
                vtc.add(price);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
