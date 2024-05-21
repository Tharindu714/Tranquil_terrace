package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author user
 */
public class Hotel_Stock_Management extends javax.swing.JFrame {

    HashMap<String, String> catMap = new HashMap<>();
    HashMap<String, String> DeptMap = new HashMap<>();
    HashMap<String, String> statusMap = new HashMap<>();

    public Hotel_Stock_Management() {
        initComponents();
        loadCatagory();
        loadDepartment();
        loadStatus();
        loadEquipment("SELECT * FROM `hotel_eq`"
                + "INNER JOIN `department` ON `hotel_eq`.`department_id` = `department`.id "
                + "INNER JOIN `eq_category` ON `hotel_eq`.`eq_category_id` = `eq_category`.id "
                + "INNER JOIN `eq_status` ON `hotel_eq`.`eq_status_id` = `eq_status`.id ORDER BY `hotel_eq`.`id` ASC");
        setExtendedState(MAXIMIZED_BOTH);
    }

    private void loadEquipment(String query) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("name"));
                v.add(resultSet.getString("eq_category.name"));
                v.add(resultSet.getString("department.name"));
                v.add(resultSet.getString("eq_status.status"));
                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadCatagory() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `eq_category`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                catMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox3.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDepartment() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `department`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                DeptMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox2.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStatus() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `status`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("type"));
                statusMap.put(resultSet.getString("type"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox1.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField1.setText("");
        jTextField1.setEditable(true);

        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);

        jTable1.clearSelection();
        jButton1.setEnabled(true);
        jTextField1.grabFocus();
    }

    private void oneClick() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {

            String eq_name = jTable1.getValueAt(selectedRow, 1).toString();
            jTextField1.setText(eq_name);
            jTextField1.setEnabled(false);

            String category = jTable1.getValueAt(selectedRow, 2).toString();
            jComboBox3.setSelectedItem(category);

            String dept = jTable1.getValueAt(selectedRow, 3).toString();
            jComboBox2.setSelectedItem(dept);

            String status = jTable1.getValueAt(selectedRow, 4).toString();
            jComboBox1.setSelectedItem(status);

            jButton1.setEnabled(false);
        }
    }

    private void commons() {
        reset();
        loadCatagory();
        loadDepartment();
        loadStatus();
        loadEquipment("SELECT * FROM `hotel_eq`"
                + "INNER JOIN `department` ON `hotel_eq`.`department_id` = `department`.id "
                + "INNER JOIN `eq_category` ON `hotel_eq`.`eq_category_id` = `eq_category`.id "
                + "INNER JOIN `eq_status` ON `hotel_eq`.`eq_status_id` = `eq_status`.id ORDER BY `hotel_eq`.`id` ASC");
    }

    private void DeleteCategory() {
        try {
            int selectedRow = jTable1.getSelectedRow();
            String id = jTable1.getValueAt(selectedRow, 0).toString();

            if (JOptionPane.showConfirmDialog(this, "Do you Want to Delete this Selected Equipment Permenatly", "This can not be undone",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                MySQL.execute("DELETE FROM `hotel_db`.`hotel_eq` WHERE  `id`='" + id + "'");
                JOptionPane.showMessageDialog(this, "Equipment Deleted Successfully", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                commons();
            } else {
                JOptionPane.showMessageDialog(this, "Equipment was not deleted", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                commons();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANQUIL TERRACE | Hotel Stock Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton6)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(225, 400));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Equipment Name");

        jTextField1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jTextField1.setForeground(java.awt.Color.white);

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Catagory");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Department");

        jComboBox1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox1.setForeground(java.awt.Color.white);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Active", "Inactive" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(245, 71, 104));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Add New Equipment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(52, 73, 94));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update Selected Equipment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Status");

        jComboBox2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox2.setForeground(java.awt.Color.white);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Administrator", "Reception", "Back Office", "Kitchen", " ", " ", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox3.setForeground(java.awt.Color.white);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Electronic Items", "Bedding & Linnens", "Furniture Items", "Appliances", "Bathroom Amentities", "Decor Items", "Stationary & Information", "Maintenance Tools", " ", " ", " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", " Name", "Catagory", "Department", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(245, 71, 104));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String eqname = jTextField1.getText();
        String catagory = jComboBox3.getSelectedItem().toString();
        String department = jComboBox2.getSelectedItem().toString();
        String status = jComboBox1.getSelectedItem().toString();

        if (eqname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the equipment name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (catagory.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please Select the Catagory", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (department.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please Select the Specific Department", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (status.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please Select the Item Status", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `hotel_eq`"
                        + "WHERE `name`='" + eqname + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "This Equipment is Already Added", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {
                    MySQL.execute("INSERT INTO "
                            + "`hotel_eq`(`name`,`eq_category_id`,`department_id`,`eq_status_id`)"
                            + "VALUES('" + eqname + "','" + catMap.get(catagory) + "','" + DeptMap.get(department) + "','" + statusMap.get(status) + "')");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "Equipment Added Successfully", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            commons();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow != -1) {
                String id = jTable1.getValueAt(selectedRow, 0).toString();
                String catagory = jComboBox3.getSelectedItem().toString();
                String department = jComboBox2.getSelectedItem().toString();
                String status = jComboBox1.getSelectedItem().toString();

                if (catagory.equals(0)) {
                    JOptionPane.showMessageDialog(this, "Please Upadate the Catagory", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (department.equals(0)) {
                    JOptionPane.showMessageDialog(this, "Please Update the Specific Department", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (status.equals(0)) {
                    JOptionPane.showMessageDialog(this, "Please Update the Item Status", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    try {
                        MySQL.execute("UPDATE `hotel_eq` "
                                + "SET `department_id`='" + DeptMap.get(department) + "',"
                                + "`eq_category_id`='" + catMap.get(catagory) + "',"
                                + "`eq_status_id`='" + statusMap.get(status) + "'"
                                + "WHERE `id`='" + id + "'");

                        JOptionPane.showMessageDialog(this, "Equipment Updated Successfully", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                        commons();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select the equipment", "Message", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 1) {
            oneClick();
        } else if (evt.getClickCount() == 2) {
            DeleteCategory();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
