package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Check_Rooms extends javax.swing.JFrame {

    HashMap<String, String> roomMap = new HashMap<>();
    HashMap<String, String> statusMap = new HashMap<>();
    HashMap<String, String> cusMap = new HashMap<>();
    HashMap<String, String> mobileMap = new HashMap<>();

    String query = ("SELECT * FROM `room_assigned_customer` INNER JOIN `rooms` ON"
            + "`room_assigned_customer`.`id` = `rooms`.`id`"
            + "INNER JOIN `room_status` \n"
            + "ON `rooms`.`room_status_id` = `room_status`.`id` INNER JOIN `customer_visit_hotel` \n"
            + "ON `room_assigned_customer`.`id` = `customer_visit_hotel`.`id`"
            + "INNER JOIN `customer` ON `customer_visit_hotel`.`customer_nic/passport` = `customer`.`nic/passport`");

    public Check_Rooms() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadroomNo();
        loadroomStatus();
        loadCustomer();
        loadCustomerMob();
    }

    private void loadRooms(String query) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("rooms.room_name"));
                v.add(resultSet.getString("customer.full_name"));
                v.add(resultSet.getString("customer.nic/passport"));
                v.add(resultSet.getString("customer.mobile"));
                v.add(resultSet.getString("room_status.status"));
                v.add(resultSet.getString("room_assigned_customer.from_date"));
                v.add(resultSet.getString("room_assigned_customer.to_date"));
                model.addRow(v);
            }
        } catch (Exception e) {
                       Dashboard.log.warning(e.toString());
        }

    }

    private void IDSearch() {
        int sortIndex = jComboBox1.getSelectedIndex();

        if (sortIndex == 0) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");

        } else if (sortIndex == 1) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`id` DESC");

        } else if (sortIndex == 2) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`id` ASC");
        }
    }

    private void timeSearch() {
        int sortIndex = jComboBox2.getSelectedIndex();

        if (sortIndex == 0) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");

        } else if (sortIndex == 1) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` ASC");

        } else if (sortIndex == 2) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");

        } else if (sortIndex == 3) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`to_date` ASC");

        } else if (sortIndex == 4) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`to_date` DESC");
        }
    }

    private void loadroomNo() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `room_name`,`id` FROM `rooms`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("room_name"));
                roomMap.put(resultSet.getString("room_name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox3.setModel(comboBoxModel);

        } catch (Exception e) {
                       Dashboard.log.warning(e.toString());

        }
    }

    private void roomSearch() {
        String rooms = jComboBox3.getSelectedItem().toString();

        if (rooms.equals(0)) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");

        } else {
            loadRooms(query + "WHERE `rooms`.`room_name`='" + rooms + "' ");
        }
    }

    private void loadroomStatus() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `room_status`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("status"));
                statusMap.put(resultSet.getString("status"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox4.setModel(comboBoxModel);

        } catch (Exception e) {
                       Dashboard.log.warning(e.toString());

        }
    }

    private void roomStatsus() {
        String roomsstatus = jComboBox4.getSelectedItem().toString();

        if (roomsstatus.equals(0)) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");

        } else {
            loadRooms(query + "WHERE `room_status`.`status`='" + roomsstatus + "' ");
        }
    }

    private void loadCustomer() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `full_name`,`nic/passport` FROM `customer`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("full_name"));
                cusMap.put(resultSet.getString("full_name"), resultSet.getString("nic/passport"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox6.setModel(comboBoxModel);

        } catch (Exception e) {
                       Dashboard.log.warning(e.toString());

        }
    }

    private void loadCustomerMob() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `mobile`,`nic/passport` FROM `customer`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("mobile"));
                mobileMap.put(resultSet.getString("mobile"), resultSet.getString("nic/passport"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox5.setModel(comboBoxModel);

        } catch (Exception e) {
                        Dashboard.log.warning(e.toString());

        }
    }

    private void SearchMobile() {
        String mobile = jComboBox5.getSelectedItem().toString();

        if (mobile.equals(0)) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");

        } else {
            loadRooms(query + "WHERE `customer`.`mobile`='" + mobile + "' ");
        }
    }

    private void searchCustomer() {
        String customer = jComboBox6.getSelectedItem().toString();

        if (customer.equals(0)) {
            loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");

        } else {
            loadRooms(query + "WHERE `customer`.`full_name`='" + customer + "' ");
        }
    }

    private void loadUI() {
        loadRooms(query + "ORDER BY `room_assigned_customer`.`from_date` DESC");
        loadroomNo();
        loadroomStatus();
        loadCustomer();
        loadCustomerMob();
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(52, 73, 94));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel4.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TRANQUIL TERRACE | Rooms History");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(18, 173, 193));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/view-detail.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order By ID");

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
        jLabel2.setText("Order By Time");

        jComboBox2.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "From Date ASC", "From Date DESC", "To Date ASC", "To Date DESC", " " }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Order by Room");

        jComboBox3.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Room Status");

        jComboBox4.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
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

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Customer name");

        jComboBox6.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer Mobile");

        jComboBox5.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 300));

        jTable1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Room Name", "Customer Name", "NIC/Passport No", "Mobile", "Status", "From Date", "To Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(245, 71, 104));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        IDSearch();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        timeSearch();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        roomSearch();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        roomStatsus();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadUI();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        searchCustomer();
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        SearchMobile();
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you need to Print Room History Report?", "Confirm Alert",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                HashMap<String, Object> map = new HashMap<>();

                String reportPath = "src//reports//roomHistory.jasper";

                JRDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, map, dataSource);
                JasperViewer.viewReport(jasperPrint, false);

            } catch (Exception e) {
                            Dashboard.log.warning(e.toString());

            }
        } else {
            loadUI();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Check_Rooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
