package FrontOffice;

import GUI.Dashboard;
import java.io.InputStream;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author maleesha
 */
public class invoice extends javax.swing.JPanel {

    /**
     * Creates new form invoice
     */
    public invoice() {
        initComponents();
        load_payment();
        loadt();
        loadtable();
        loaddeteils();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Invoice for guest");

        jLabel2.setText("jLabel1");

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel15.setText("invoice no");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jLabel3.setText("Customer NIC /  PASSPORT");

        jTextField1.setText("851246793V");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel4.setText("allowcated room");

        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "service id ", "discription", "price", "service date"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(245, 71, 104));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel5.setText("Auxiliary service");

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel7.setText("food service");

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel8.setText("other service");

        jPanel2.setPreferredSize(new java.awt.Dimension(818, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 6, -1, -1));

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jLabel26.setText("total");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, 20));

        jLabel39.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("0.00");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 50, 80, -1));

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jLabel27.setText("Payment method");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox1MouseReleased(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 100, 30));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 117, 30));

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jLabel28.setText("paid amount");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jLabel29.setText("balence");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 60, -1));

        jLabel37.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("0.00");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 120, 90, -1));

        jButton1.setBackground(new java.awt.Color(52, 73, 94));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        jButton1.setText("print invoice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 220, 32));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jLabel13.setText("select invoice");

        jComboBox2.setBackground(new java.awt.Color(52, 73, 94));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox2FocusGained(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });

        jButton2.setText("load bill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private String ntime;

    private double totle;
    private double balnce;

    private void loadt() {
        Thread t = new Thread(() -> {
            while (true) {
                LocalDateTime myDateObj = LocalDateTime.now();

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                String formattedDate = myDateObj.format(myFormatObj);
                ntime = formattedDate;

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }

        });
        t.start();
    }

    private void reset() {
        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        tgbc.setRowCount(0);
        jTextField1.setText("");
        jComboBox1.setSelectedItem(0);
        jComboBox2.setSelectedItem(0);
        jTextField5.setText("");
        jProgressBar1.setValue(0);
        jProgressBar2.setValue(0);
        jProgressBar4.setValue(0);
        jProgressBar5.setValue(0);
        load_bill();
        totle = 0.00;
        balnce = 0.00;
        jLabel14.setText("");
        repaint();
        revalidate();

    }

    private void loaddeteils() {

        String id = jComboBox2.getSelectedItem().toString();
        String nic = jTextField1.getText();
        jLabel14.setText(id);

        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        tgbc.setRowCount(0);

        try {
            System.out.println(id);
            ResultSet result = MySQL.execute("SELECT DISTINCT * FROM `room_assigned_customer` INNER JOIN `rooms` ON `room_assigned_customer`.`rooms_id` = `rooms`.`id` WHERE `customer_visit_hotel_id` = '" + id + "' ");

            while (result.next()) {
                String room = result.getString("rooms_id");
                String roomname = result.getString("room_name");

                String to_date = result.getString("to_date");

                Vector vtc = new Vector();
                vtc.add(room);
                vtc.add(roomname);
                vtc.add(to_date);

            }
        } catch (Exception e) {
        }
    }

    private void loadtable() {
        String id = jComboBox2.getSelectedItem().toString();
        jLabel14.setText(id);

        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        tgbc.setRowCount(0);
        load_o_service();
        load_A_service();
        load_f_service();

        try {

            ResultSet result = MySQL.execute("SELECT DISTINCT * FROM `room_assigned_customer` INNER JOIN `rooms` ON `room_assigned_customer`.`rooms_id` = `rooms`.`id` WHERE `customer_visit_hotel_id` = '" + id + "' ");

            while (result.next()) {
                String room = result.getString("rooms_id");
                String roomname = result.getString("room_name");
                String to_date = result.getString("from_date");
                String price = result.getString("price");

                Vector vtc = new Vector();
                vtc.add("Room : Rreq" + room);
                vtc.add(roomname);
                vtc.add(price);
                vtc.add(to_date);

                tgbc.addRow(vtc);

                jProgressBar4.setValue(100);

            }

        } catch (Exception e) {
        }

    }

    private void load_o_service() {

        String id = jComboBox2.getSelectedItem().toString();
        jLabel14.setText(id);

        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        System.out.println(id);
        try {
            System.out.println(id);
            ResultSet result = MySQL.execute("SELECT * FROM `other_services` WHERE `customer_visit_hotel_id`='" + id + "'");

            while (result.next()) {
                String serviceid = result.getString("id");
                String service = result.getString("service");

                String price = result.getString("price");
                String to_date = "room time";

                Vector vtc = new Vector();
                vtc.add("service :sreq" + serviceid);
                vtc.add(service);
                vtc.add(price);
                vtc.add(to_date);

                tgbc.addRow(vtc);

                jProgressBar5.setValue(100);

            }
        } catch (Exception e) {
        }

    }

    private void load_A_service() {
        String id = jComboBox2.getSelectedItem().toString();
        jLabel14.setText(id);

        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        System.out.println(id);
        try {
            System.out.println(id);
            ResultSet result = MySQL.execute("SELECT * FROM `laundry_aux` WHERE `customer_visit_hotel_id`='" + id + "'");

            while (result.next()) {

                String serviceid = result.getString("id");
                String service = result.getString("service_description");

                String price = result.getString("price_added");
                String to_date = "room time";

                Vector vtc = new Vector();
                vtc.add("service :LOreq" + serviceid);
                vtc.add(service);
                vtc.add(price);
                vtc.add(to_date);

                tgbc.addRow(vtc);

                jProgressBar2.setValue(100);

            }
        } catch (Exception e) {
        }
    }

    private void load_f_service() {
        String id = jComboBox2.getSelectedItem().toString();
        jLabel14.setText(id);

        DefaultTableModel tgbc = (DefaultTableModel) jTable1.getModel();
        System.out.println(id);
        try {
            System.out.println(id);
            ResultSet result = MySQL.execute("SELECT DISTINCT * FROM `kot` INNER JOIN `kot_has_food` ON `kot`.`id` =`kot_has_food`.`kot_id` INNER JOIN `food_item` ON"
                    + "`kot_has_food`.`food_item_id` = `food_item`.`id` WHERE `customer_visit_hotel_id` = '" + id + "' ");

            while (result.next()) {

                String to_date = result.getString("ordered_time");;
                double price = result.getDouble("price");

                String serviceid = result.getString("id");
                String service = result.getString("name");

                int qty = result.getInt("qty");

                double totala = price * qty;

                String stu = Double.toString(price);

                Vector vtc = new Vector();
                vtc.add(" food:For65" + serviceid);
                vtc.add(service + "  (" + price + "*" + qty + ") ");
                vtc.add(totala);
                vtc.add(stu);

                tgbc.addRow(vtc);

                jProgressBar1.setValue(100);

            }
        } catch (Exception e) {
        }

    }

    private void load_payment() {

        try {
            jComboBox1.removeAllItems();
            Vector v = new Vector();

            ResultSet resultset = MySQL.execute("SELECT `method` FROM  `payement_method` WHERE `id`!='3'");

            while (resultset.next()) {
                String method = resultset.getString("method");

                v.add(method);

                DefaultComboBoxModel def = new DefaultComboBoxModel(v);

                jComboBox1.setModel(def);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cal() {
        balnce = 0;
        totle = 0;
        int rowc = jTable1.getRowCount();

        for (int i = 0; i < rowc; i++) {
            String ooo = String.valueOf(jTable1.getValueAt(i, 2));
            totle += Double.parseDouble(ooo);
        }

        jLabel39.setText(String.valueOf(totle));

    }

    private void calbalence() {
        String payamount = jTextField5.getText();

        balnce = totle - Double.parseDouble(payamount);
        jLabel37.setText(String.valueOf(balnce));

    }

    private void load_bill() {
        String nic = jTextField1.getText();
        jComboBox2.removeAllItems();
        Vector v = new Vector();
        try {
            ResultSet result = MySQL.execute("SELECT `id` FROM `customer_visit_hotel` WHERE `customer_nic/passport` = '" + nic + "' AND `payment_method_id` = '3'");
            if (result.next()) {
                while (result.next()) {

                    String id = result.getString("id");
                    v.add(id);
                    DefaultComboBoxModel def = new DefaultComboBoxModel(v);
                    jComboBox2.setModel(def);

                }
            } else {

                JOptionPane.showMessageDialog(this, "plese enter Correct nic", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        cal();

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox2FocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        load_bill();
        printin();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        calbalence();
    }//GEN-LAST:event_jTextField5KeyReleased

    private void printin() {
        try {
            HashMap< String, Object> map = new HashMap<>();

            InputStream reportPath = Dashboard.class.getResourceAsStream("/reports/table.jasper");

            JRDataSource datas = new JRTableModelDataSource(jTable1.getModel());
            JasperPrint jdbc = JasperFillManager.fillReport(reportPath, map, datas);
            JasperViewer.viewReport(jdbc, false);

        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    private void insert() {
        String tid = jComboBox2.getSelectedItem().toString();

        String combo = jComboBox1.getSelectedItem().toString();
        String paid = jTextField5.getText();
        double out = Double.parseDouble(paid);

        if (combo.contentEquals("Card")) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }

        try {
            ResultSet rest = MySQL.execute("SELECT `id` FROM `payement_method` WHERE method ='" + combo + "'");
            if (rest.next()) {
                int id = rest.getInt("id");

                MySQL.execute("UPDATE `customer_visit_hotel` SET `total` = '" + totle + "',`payment_method_id` ='" + id + "' WHERE id = '" + tid + "'");

            }
        } catch (Exception e) {
        }
        reset();

    }

    private void Pus() {
        String combo = jComboBox1.getSelectedItem().toString();
        String value = Double.toString(totle);

        if (combo.contentEquals("Card")) {
            jTextField5.setText(value);
            jTextField5.setEditable(false);
        } else {
            jTextField5.setText("");
            jTextField5.setEditable(true);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: ; printin();
        insert();
        String method = jComboBox1.getSelectedItem().toString();

        String amount = jTextField5.getText().toString();
        try {
            HashMap< String, Object> map = new HashMap<>();

            map.put("Parameter1", ntime);
            map.put("Parameter2", method);
            map.put("Parameter3", totle);
            map.put("Parameter4", amount);

            map.put("Parameter5", balnce);

            InputStream reportPath = Dashboard.class.getResourceAsStream("/reports/tabletu.jasper");

            JRDataSource datas = new JRTableModelDataSource(jTable1.getModel());
            JasperPrint jdbc = JasperFillManager.fillReport(reportPath, map, datas);
            JasperViewer.viewReport(jdbc, false);

        } catch (Exception e) {
            e.printStackTrace();;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField5KeyPressed

    private void jComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseReleased
        // TODO add your handling code here:
        Pus();
    }//GEN-LAST:event_jComboBox1MouseReleased

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        loadtable();
        repaint();
        revalidate();
    }//GEN-LAST:event_jComboBox2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    private void toString(double totle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
