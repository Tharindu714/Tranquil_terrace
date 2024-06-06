package FrontOffice;

import java.awt.Color;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class Roomallocation extends javax.swing.JPanel {

    static boolean rms = true;

    public Roomallocation() {
        initComponents();
        loadhoteltype();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room Allocation");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(549, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jButton13.setBackground(new java.awt.Color(52, 73, 94));
        jButton13.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Allocate Now");
        jButton13.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton13.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton13.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel2.setText("customer nic");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setText("register now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("select room ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
        });

        jLabel4.setText("pax");

        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
        });

        jLabel5.setText("Check in ");

        jLabel7.setText("check out");

        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customer nic", "selected room", "room type", "pax", "check in", "check out", "price"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(245, 71, 104));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "room type" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jComboBox2MouseDragged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
        });
        jComboBox2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox2PropertyChange(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });

        jLabel6.setText("room type");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please Select in table", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            String nic = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String room = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
            String room_type = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();

            String checkin = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
            String checkout = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
            String pax = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
            String price = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();

            try {
                MySQL.execute("INSERT INTO `customer_visit_hotel` (`check_in`,`check_out`,`pax`,`total`,`customer_nic/passport`,`payment_method_id`) VALUE"
                        + " ('" + checkin + "','" + checkout + "','" + pax + "','" + price + "','" + nic + "','3')");

               MySQL.execute("INSERT INTO room_assigned_customer"
                        + " (from_date,customer_visit_hotel_id,to_date,rooms_id) "
                        + "VALUES ('" + checkin + "',"
                        + " (select id from customer_visit_hotel WHERE `customer_nic/passport`= '" + nic + "' AND `check_in` = '" + checkin + "'),"
                        + " '" + checkout + "',"
                        + " (SELECT `id` FROM `rooms` WHERE `room_name` = '" + room + "'))");
            } catch (Exception e) {
            }
            JOptionPane.showMessageDialog(this, "successfully allocate",
                    "sucess", JOptionPane.INFORMATION_MESSAGE);
            reset();

        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void set() {

        jTextField1.setText("");
        jTextField1.setEditable(false);
        jComboBox1.setSelectedItem(0);
        jComboBox2.setSelectedItem(0);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
        jFormattedTextField1.setText("");
        jFormattedTextField1.setEnabled(false);

    }

    private void trset() {

        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
        jFormattedTextField1.setText("");
        jFormattedTextField1.setEnabled(false);

    }

    private void tgset() {

        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jDateChooser2.setEnabled(true);

        jFormattedTextField1.setEnabled(true);

    }

    private void oneclick() {

        String nic = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();

        jTextField1.setText(nic);
        jTextField1.setEditable(true);
        jComboBox1.setSelectedItem(0);
        jComboBox2.setSelectedItem(0);
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jDateChooser2.setEnabled(true);
        jFormattedTextField1.setText("");
        jFormattedTextField1.setEnabled(true);

    }

    private void reset() {

        jTextField1.setText("");
        jTextField1.setEditable(true);
        jComboBox1.setSelectedItem(0);
        jComboBox2.setSelectedItem(0);
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jDateChooser2.setEnabled(true);
        jFormattedTextField1.setText("");
        jFormattedTextField1.setEnabled(true);
        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        tgbc.setRowCount(0);

    }

    private void loadtable() {

        try {
            DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
            tgbc.setRowCount(0);
            String room = jComboBox1.getSelectedItem().toString();
            String nic = jTextField1.getText();
            String roomtype = jComboBox2.getSelectedItem().toString();
            String pax = jFormattedTextField1.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date startdate = jDateChooser2.getDate();
            String formattedStartDate = sdf.format(startdate);

            Date enddate = jDateChooser1.getDate();
            String formattedEndDate = sdf.format(enddate);

            ResultSet rest = MySQL.execute("SELECT `price` FROM `rooms` WHERE `room_name`='" + room + "'");

            while (rest.next()) {

                String price = rest.getString("price");

                Vector vtc = new Vector();
                vtc.add(nic);
                vtc.add(room);
                vtc.add(roomtype);
                vtc.add(pax);
                vtc.add(formattedStartDate);
                vtc.add(formattedEndDate);
                vtc.add(price);

                tgbc.addRow(vtc);

            }

        } catch (Exception e) {
        }

    }

    private void loadhoteltype() {

        try {
            jComboBox2.removeAllItems();

            Vector v = new Vector();

            ResultSet resultset = MySQL.execute("SELECT `type` FROM  `room_type`");

            while (resultset.next()) {
                String type = resultset.getString("type");
                v.add(type);
                DefaultComboBoxModel def = new DefaultComboBoxModel(v);
                jComboBox2.setModel(def);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(jComboBox2.getSelectedItem().toString());
    }

    private void loadroom() {

        String roomtype = jComboBox2.getSelectedItem().toString();

        try {

            jComboBox1.removeAllItems();

            Vector v = new Vector();

            ResultSet resultset = MySQL.execute("SELECT `room_name` FROM `rooms` "
                    + "INNER JOIN `room_type`ON `rooms`.`room_type_id`=`room_type`.`id` WHERE `type`='" + roomtype + "'");

            while (resultset.next()) {
                String name = resultset.getString("room_name");

                v.add(name);
                DefaultComboBoxModel def = new DefaultComboBoxModel(v);
                jComboBox1.setModel(def);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String cuse = jTextField1.getText();
        try {
            ResultSet result = MySQL.execute("SELECT `nic/passport` FROM `customer` WHERE `nic/passport`='" + cuse + "'");
            if (result.next()) {
                jButton1.setEnabled(false);
                tgset();

            } else {
                jButton1.setEnabled(true);
                jButton1.setBackground(Color.red);
                trset();
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
        // TODO add your handling code here:
        loadroom();
    }//GEN-LAST:event_jComboBox2KeyReleased

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        // TODO add your handling code here:
        loadroom();
    }//GEN-LAST:event_jComboBox1FocusGained

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
        loadroom();
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseEntered

    private void jComboBox2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseDragged
        // TODO add your handling code here:
        loadroom();
    }//GEN-LAST:event_jComboBox2MouseDragged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox2PropertyChange
        // TODO add your handling code here:
        loadroom();
    }//GEN-LAST:event_jComboBox2PropertyChange

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased
        // TODO add your handling code here:
        loadtable();
        set();

    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            oneclick();
        } else if (evt.getClickCount() == 2) {
            reset();
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
