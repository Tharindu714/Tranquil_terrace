/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontOffice;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author maleesha
 */
public class Auxiliary_service extends javax.swing.JPanel {

    /**
     * Creates new form Auxiliary_service
     */
    public Auxiliary_service() {
        initComponents();
        loadservice();
    }

    public void loadservice() {

        try {
            ResultSet stresultSet = MySQL.execute("SELECT * FROM `laundry_aux` "
                    + "INNER JOIN `customer_visit_hotel` ON `laundry_aux`.`customer_visit_hotel_id`=`customer_visit_hotel`.`id` ");

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            while (stresultSet.next()) {

                Vector<String> vector = new Vector<>();

                vector.add(stresultSet.getString("id"));
                vector.add(stresultSet.getString("customer_visit_hotel.customer_nic/passport"));
                vector.add(stresultSet.getString("service_description"));
                vector.add(stresultSet.getString("price_added"));

                model.addRow(vector);
                jTable2.setModel(model);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void reset() {
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField2.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Laundry & Auxiliary service");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jButton8.setBackground(new java.awt.Color(245, 71, 104));
        jButton8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("remove  service deteils");
        jButton8.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton8.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(52, 73, 94));
        jButton12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("add service to customer");
        jButton12.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton12.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton12.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(18, 173, 193));
        jButton7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("update service");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton7.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("customer NIC");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 20, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 20, 0, 0);
        jPanel3.add(jTextField1, gridBagConstraints);

        jLabel3.setText("laundry Service description  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 20, 0, 0);
        jPanel3.add(jLabel3, gridBagConstraints);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "service id", "customer ", "service description", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 492;
        gridBagConstraints.ipady = 267;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 26, 13, 25);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 183;
        gridBagConstraints.ipady = 75;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 0, 0);
        jPanel3.add(jScrollPane2, gridBagConstraints);

        jLabel4.setText("price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 0, 0);
        jPanel3.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 20, 13, 0);
        jPanel3.add(jTextField2, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please Select Row", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {

            String id = String.valueOf(jTable2.getValueAt(selectedRow, 0));

            try {
                MySQL.execute("DELETE FROM `laundry_aux` WHERE `id`= '" + id + "'");
                JOptionPane.showMessageDialog(this, "successfully Remove",
                        "information", JOptionPane.INFORMATION_MESSAGE);
                

                loadservice();
                reset();

                jTable2.setEnabled(true);
                jButton12.setEnabled(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        String nop = jTextField1.getText();
        String description = jTextArea1.getText();
        String price = jTextField2.getText();

        if (nop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Your NIC Or Passport", "Warning", JOptionPane.ERROR_MESSAGE);

        } else if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Discription", "Warning", JOptionPane.ERROR_MESSAGE);

        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Price", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `customer`"
                        + "WHERE `nic/passport`='" + nop + "'");

                if (resultSet.next()) {

                    MySQL.execute("INSERT INTO `laundry_aux` (`service_description`,`price_added`,`customer_visit_hotel_id`)\n"
                            + "VALUES ('" + description + "','" + price + "',(SELECT `id` FROM `customer_visit_hotel` "
                            + "WHERE `customer_nic/passport` = '" + nop + "'));");

                    JOptionPane.showMessageDialog(this, "successfully registered",
                            "information", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "This customer has not registered", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                loadservice();
                reset();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select row", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {

            String id = String.valueOf(jTable2.getValueAt(selectedRow, 0));

            String nop = jTextField1.getText();
            String desciption = jTextArea1.getText();
            String price = jTextField2.getText();

            if (nop.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Your NIC or Passport", "Warning", JOptionPane.ERROR_MESSAGE);

            } else if (desciption.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Desciption ", "Warning", JOptionPane.ERROR_MESSAGE);

            } else if (price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter price ", "Warning", JOptionPane.ERROR_MESSAGE);

            } else {

                try {
                    MySQL.execute("UPDATE `laundry_aux` SET"
                            + " `service_description` = '" + desciption + "',"
                            + " `price_added` = '" + price + "' "
                            + " WHERE `id` = '" + id + "'"
                    );
                    JOptionPane.showMessageDialog(this, "successfully UPDATE",
                            "information", JOptionPane.INFORMATION_MESSAGE);

                    loadservice();
                    reset();

                    jTable2.setEnabled(true);
                    jButton7.setEnabled(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {

            jTable2.setEnabled(false);
            jButton12.setEnabled(false);

            int selectedRow = jTable2.getSelectedRow();

            String nop = String.valueOf(jTable2.getValueAt(selectedRow, 1));
            jTextField1.setText(nop);

            String service_description = String.valueOf(jTable2.getValueAt(selectedRow, 2));
            jTextArea1.setText(service_description);

            String price_added = String.valueOf(jTable2.getValueAt(selectedRow, 3));
            jTextField2.setText(price_added);

        }

    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
