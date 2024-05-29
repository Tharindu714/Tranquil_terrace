package FrontOffice;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
public class foododer extends javax.swing.JPanel {

    private String ntime;

    public foododer() {
        initComponents();

        loadmail();
        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        ntime = formattedDate;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("food order");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 129, 27));

        jLabel8.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("custemer nic");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 101, 27));

        jLabel10.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("select food");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 139, 27));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 120, 210, 30));

        jLabel11.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("quentity");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 139, 27));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 210, 30));

        jLabel13.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("request time");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 158, 139, 27));

        jLabel14.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("meal time");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 139, 27));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 203, 32));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 61, 800, 10));
        jPanel3.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 191, 190, 32));

        jLabel1.setText(" 0");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 28, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 120, 190, 30));

        add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jButton8.setBackground(new java.awt.Color(245, 71, 104));
        jButton8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("order now");
        jButton8.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton8.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(592, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ticket id", "customer", "product", "meal time", "request time", "status", "quentity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTable4.getColumnModel().getColumn(3).setResizable(false);
            jTable4.getColumnModel().getColumn(4).setResizable(false);
            jTable4.getColumnModel().getColumn(5).setResizable(false);
            jTable4.getColumnModel().getColumn(6).setResizable(false);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 749;
        gridBagConstraints.ipady = 274;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 15, 0, 0);
        jPanel5.add(jScrollPane4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 799;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 0);
        jPanel5.add(jSeparator2, gridBagConstraints);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void oneclick() {

        int selectedRow = jTable4.getSelectedRow();
        if (selectedRow != -1) {
            String id = jTable4.getValueAt(selectedRow, 0).toString();
            String food = jTable4.getValueAt(selectedRow, 2).toString();

            jTextField2.setText(food);
            jLabel1.setText(id);

            DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
            tgbc.setRowCount(0);

        }

    }

    HashMap<String, Integer> table = new HashMap<>();
    HashMap<String, Integer> food = new HashMap<>();

    private void doubleclick() {

        int selectedRow = jTable4.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) jTable4.getValueAt(selectedRow, 0);
            String nicu = jTable4.getValueAt(jTable4.getSelectedRow(), 1).toString();

            jTextField1.setText(nicu);
            this.table.put(nicu, id);

            DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
            tgbc.setRowCount(0);

        }

    }

    private void reset() {
        DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
        tgbc.setRowCount(0);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField1.setText("");
        jLabel1.setText("");
        jComboBox2.setSelectedItem(0);

    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        try {

            JOptionPane.showMessageDialog(this, "successfully",
                    "Order added successfull", JOptionPane.INFORMATION_MESSAGE);
            int rowc = jTable4.getRowCount();

            for (int i = 0; i < rowc; i++) {
//            int i = jTable4.getSelectedRow();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                String date = dtf.format(now);
                String maile = jTable4.getValueAt(i, 3).toString();
                String coustomer = jTable4.getValueAt(i, 1).toString();
                String time = jTable4.getValueAt(i, 4).toString();
                String foode = jTable4.getValueAt(i, 2).toString();
                String qty = jTable4.getValueAt(i, 6).toString();
                Integer qtyr = Integer.valueOf(qty);

                int id = table.get(coustomer);
                int foodid = food.get(foode);
                int maelid = this.mail.get(maile);

                MySQL.execute("INSERT INTO `kot`"
                        + " (`ordered_time`,`req_time`,`meal_time_id`,`kot_status_id`,`customer_visit_hotel_id`) VALUE"
                        + " ('" + date + "','" + time + "','" + maelid + "','1','" + id + "')  WHERE `customer_visit_hotel_id` = '" + id + "'");
                System.out.println("int sussce");
                ResultSet search = MySQL.execute("SELECT `id` FROM `kot` WHERE ordered_time = '" + date + "'");

                if (search.next()) {
                    System.out.println("search ok");

                    int kotid = search.getInt("id");
                    MySQL.execute("INSERT INTO `kot_has_food` (`kot_id`,`food_item_id`,`qty`) VALUE ('" + kotid + "','" + foodid + "','" + qtyr + "') ;");

                }

                System.out.println("ok");
            }

            DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
            tgbc.setRowCount(0);
            reset();

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        loaddata();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {

            oneclick();
            doubleclick();
        } else if (evt.getClickCount() == 3) {
            reset();
        } else if (evt.getClickCount() == 3) {

        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBox2KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        try {

            DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
            tgbc.setRowCount(0);
            String text = jTextField1.getText();

            ResultSet rest = MySQL.execute("SELECT `customer_nic/passport`,`id` FROM customer_visit_hotel WHERE `customer_nic/passport` LIKE '" + text + "%' AND payment_method_id = '3'");
            while (rest.next()) {
                int aInt = rest.getInt("id");
                String stu = rest.getString("customer_nic/passport");

                Vector vtc = new Vector();
                vtc.add(aInt);
                //                vtc.add(f_name);
                vtc.add(stu);
                vtc.add("");
                vtc.add("");
                vtc.add("");
                vtc.add("");
                vtc.add("");

                tgbc.addRow(vtc);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:

        String nic = jTextField1.getText();
        String food = jTextField2.getText();
        String qty = jTextField3.getText();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date startdate = jDateChooser1.getDate();
        String formattedStartDate = sdf.format(startdate);

        Object selectedItem = jComboBox2.getSelectedItem();

        DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
        tgbc.setRowCount(0);

        Vector vtc = new Vector();
        vtc.add("");
//                vtc.add(f_name);
        vtc.add(nic);
        vtc.add(food);
        vtc.add(selectedItem);
        vtc.add(formattedStartDate);
        vtc.add("Pending");
        vtc.add(qty);

        tgbc.addRow(vtc);


    }//GEN-LAST:event_jTextField3KeyReleased

//    private void loadcatogory() {
//        try {
//            jComboBox1.removeAllItems();
//            Vector v = new Vector();
//
//            ResultSet resultset = mysql.search("SELECT `category` FROM  `food_category`");
//
//            while (resultset.next()) {
//                String iato = resultset.getString("category");
//
//                System.out.println(iato);
//                v.add(iato);
//
//                DefaultComboBoxModel def = new DefaultComboBoxModel(v);
//                jComboBox1.setModel(def);
//            }
//        } catch (Exception e) {
//
//        }
//    }
    private void loaddata() {

        String foodname = jTextField2.getText();
        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable4.getModel();
            tgbc.setRowCount(0);

            ResultSet rest = MySQL.execute("SELECT * FROM `food_item` WHERE `name` LIKE '" + foodname + "%'");

            while (rest.next()) {

                int id = rest.getInt("id");
                String name = rest.getString("name");
                String nulll = "";
                this.food.put(name, id);

                Vector vtc = new Vector();

                vtc.add(id);

                vtc.add(nulll);

                vtc.add(name);
                vtc.add(nulll);
                vtc.add(nulll);
                vtc.add(nulll);
                vtc.add(nulll);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }

    }

    HashMap<String, Integer> mail = new HashMap<>();

    private void loadmail() {
        try {
            jComboBox2.removeAllItems();
            Vector v = new Vector();

            ResultSet resultset = MySQL.execute("SELECT * FROM  `meal_time`");

            while (resultset.next()) {
                String iato = resultset.getString("type");
                int ia = resultset.getInt("id");

                System.out.println(iato);
                v.add(iato);

                DefaultComboBoxModel def = new DefaultComboBoxModel(v);
                jComboBox2.setModel(def);

                this.mail.put(iato, ia);
            }
        } catch (Exception e) {

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
