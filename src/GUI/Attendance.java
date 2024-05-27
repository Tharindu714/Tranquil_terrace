/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.UserBean;

/**
 *
 * @author DS
 */
public class Attendance extends javax.swing.JFrame {

    public HashMap<String, UserBean> userMap = new HashMap<>();
    public Vector<UserBean> userVector = new Vector<>();

    /**
     * Creates new form Attendance
     */
    public Attendance() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        loadWorkSchedule("");
    }

    private String percentage(String userId) {

        try {

            String date = new SimpleDateFormat("yyyy-MM").format(new Date());

            ResultSet workSchedule = MySQL.execute("SELECT COUNT(*) FROM `work_schedule` WHERE `status_id`='1' AND `employee_id`='" + userId + "' AND `date` LIKE '" + date + "%'");
            ResultSet Attendance = MySQL.execute("SELECT COUNT(*) FROM `staff_attendence` WHERE  `employee_id`='" + userId + "' AND `date` LIKE '" + date + "%'");

            workSchedule.next();
            Attendance.next();

            if (Attendance.getInt("COUNT(*)") != 0 && workSchedule.getInt("COUNT(*)") != 0) {
                double percentage = (Attendance.getDouble("COUNT(*)") / workSchedule.getDouble("COUNT(*)")) * 100;

                return percentage + " %";
            }

            return "0%";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private void clearData() {
        emFullName.setText("");
        emMobile1.setText("");
        emPercentage.setText("");
        emType.setText("");

        attendanceHistory.clearSelection();
        attendanceTable.clearSelection();

        DefaultTableModel tableModel = (DefaultTableModel) attendanceHistory.getModel();
        tableModel.setRowCount(0);

        DefaultTableModel tablModel = (DefaultTableModel) attendanceTable.getModel();
        tableModel.setRowCount(0);

    }

    
    private void loadWorkSchedule(String queary) {

        try {

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String hour = new SimpleDateFormat("HH").format(new Date());

            ResultSet rs = MySQL.execute("SELECT * FROM `work_schedule` "
                    + "INNER JOIN `employee` \n"
                    + "ON `employee`.`id`=`work_schedule`.`employee_id`\n"
                    + "INNER JOIN `employee_type` ON "
                    + "`employee_type`.`id`=`employee`.`employee_type_id`"
                    + "INNER JOIN `status` ON"
                    + "`status`.`id`=`work_schedule`.`status_id`"
                    + " WHERE  "
                    + " `work_schedule`.`status_id`!='1' AND"
                    + "`work_schedule`.`date`='" + date + "' AND " + queary + " ' " + date + " 0" + (Integer.parseInt(hour) + 1) + ":00:00' \n"
                    + " BETWEEN `work_schedule`.`on_time` AND `work_schedule`.`off_time`"
                    + "ORDER BY `work_schedule`.`date` DESC");

            DefaultTableModel tableModel = (DefaultTableModel) attendanceTable.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("work_schedule.id"));
                v.add(rs.getString("employee.id"));
                v.add(rs.getString("on_time"));
                v.add(rs.getString("off_time"));

                UserBean bean = new UserBean();

                bean.setScheduleId(rs.getString("work_schedule.id"));
                bean.setUserName(rs.getString("employee.id"));
                bean.setMobile(rs.getString("mobile"));
                bean.setFullName(rs.getString("first_name") + " " + rs.getString("last_name"));
                bean.setUserRole(rs.getString("employee_type.type"));
                bean.setPercentage(percentage(rs.getString("employee.id")));
                bean.setStatus(rs.getString("status.type"));

                if (rs.getString("work_schedule.status_id").equals("1")) {
                    v.add(rs.getString("status.type"));
                } else {
                    v.add(rs.getString("status.type"));
                }

                tableModel.addRow(v);
                userMap.put(rs.getString("work_schedule.id"), bean);
                userVector.add(bean);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        emFullName = new javax.swing.JLabel();
        emType = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        emPercentage = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        emMobile1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        employeeId = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        offTime = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        attendanceHistory = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();

        timePicker1.set24hourMode(false);
        timePicker1.setName(""); // NOI18N
        timePicker1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                timePicker1FocusLost(evt);
            }
        });
        timePicker1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timePicker1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timePicker1MouseReleased(evt);
            }
        });
        timePicker1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timePicker1PropertyChange(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(52, 73, 94));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 50));

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
        jLabel1.setText("TRANQUIL TERRACE | Employee Attendance");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1484, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        attendanceTable.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        attendanceTable.setForeground(new java.awt.Color(255, 255, 255));
        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Work Schedule Id", "Employee Id", "Start Time", "Off time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendanceTable.setSelectionBackground(new java.awt.Color(245, 71, 104));
        attendanceTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        attendanceTable.setShowGrid(false);
        attendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendanceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(attendanceTable);
        if (attendanceTable.getColumnModel().getColumnCount() > 0) {
            attendanceTable.getColumnModel().getColumn(0).setResizable(false);
            attendanceTable.getColumnModel().getColumn(1).setResizable(false);
            attendanceTable.getColumnModel().getColumn(2).setResizable(false);
            attendanceTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel36.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Employee Full Name : ");

        emFullName.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emFullName.setForeground(new java.awt.Color(255, 255, 255));
        emFullName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emFullName.setText("User Full Name");

        emType.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emType.setForeground(new java.awt.Color(255, 255, 255));
        emType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emType.setText("Employee Type");

        jLabel39.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Employee Type : ");

        jLabel40.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Attendance percentage : ");

        emPercentage.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emPercentage.setForeground(new java.awt.Color(255, 255, 255));
        emPercentage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emPercentage.setText("100%");

        jLabel42.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Mobile");

        emMobile1.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emMobile1.setForeground(new java.awt.Color(255, 255, 255));
        emMobile1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emMobile1.setText("075XXXXXXX");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(245, 71, 104));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/HR-attendance.png"))); // NOI18N
        jButton1.setText("   Authorized");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        employeeId.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        employeeId.setForeground(java.awt.Color.white);
        employeeId.setPreferredSize(new java.awt.Dimension(64, 35));
        employeeId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeIdMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                employeeIdMouseReleased(evt);
            }
        });
        employeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdActionPerformed(evt);
            }
        });
        employeeId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeIdKeyReleased(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText(" Employee User Name");

        offTime.setEditable(false);
        offTime.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        offTime.setText("Off Time");
        offTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                offTimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                offTimeFocusLost(evt);
            }
        });
        offTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                offTimeMouseReleased(evt);
            }
        });
        offTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offTimejTextField2ActionPerformed(evt);
            }
        });
        offTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                offTimeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                offTimeKeyTyped(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Select Off Time");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(11, 11, 11)
                        .addComponent(emFullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 916, Short.MAX_VALUE)
                        .addComponent(jLabel42)
                        .addGap(11, 11, 11)
                        .addComponent(emMobile1)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(11, 11, 11)
                        .addComponent(emPercentage))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(11, 11, 11)
                        .addComponent(emType))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel37)))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(offTime, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(emFullName)
                    .addComponent(jLabel42)
                    .addComponent(emMobile1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(emType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(emPercentage))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(753, 200));

        attendanceHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "On time", "Off Time", "Attend"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(attendanceHistory);
        if (attendanceHistory.getColumnModel().getColumnCount() > 0) {
            attendanceHistory.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel17.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Employee Attendance History");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(587, 587, 587)
                .addComponent(jLabel17)
                .addContainerGap(612, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4))
        );

        jPanel3.add(jPanel8);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

  
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

try {

            int selectedRow = attendanceTable.getSelectedRow();

            if (selectedRow != -1 && attendanceTable.getValueAt(selectedRow, 4).toString() != "Active") {

                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

                String onTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                String EmployeeId = attendanceTable.getValueAt(selectedRow, 1).toString();

                if (offTime.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Select Off Time", "Error", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    MySQL.execute("INSERT INTO `hotel_db`.`staff_attendence` (`date`, `on_time`, `off_time`, `employee_id`) "
                            + "VALUES ('" + date + "', '" + onTime + "', '" + offTime + "', '" + EmployeeId + "');");

                    MySQL.execute("UPDATE `hotel_db`.`work_schedule` SET `status_id`='1' WHERE  `id`='" + attendanceTable.getValueAt(selectedRow, 0).toString() + "';');");

                    JOptionPane.showMessageDialog(this, "Attendance Marked", "successfully", JOptionPane.INFORMATION_MESSAGE);

                    loadAttendance("");
                }

            } else {

                JOptionPane.showMessageDialog(this, "Attendance Already Marked", "warning", JOptionPane.WARNING_MESSAGE);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void employeeIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeIdMouseClicked
//        jTextField5.setText(String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }//GEN-LAST:event_employeeIdMouseClicked

    private void employeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdActionPerformed

    private void attendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceTableMouseClicked

        int selectedRow = attendanceTable.getSelectedRow();

        if (evt.getClickCount() == 1 && selectedRow != -1) {

            String scheduleId = attendanceTable.getValueAt(selectedRow, 0).toString();
            loadBeanData(scheduleId);
            loadAttendance(employeeId.getText());

        }

    }//GEN-LAST:event_attendanceTableMouseClicked

     
    
    private void employeeIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeIdKeyReleased

        if (evt.getKeyCode() == 10) {

            loadAttendance(employeeId.getText());
            String key = "`employee`.`id`='" + employeeId.getText() + "' AND";
            loadWorkSchedule(key);

        } else {
            clearData();
        }


    }//GEN-LAST:event_employeeIdKeyReleased

    private void timePicker1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePicker1FocusLost

    }//GEN-LAST:event_timePicker1FocusLost

    private void timePicker1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timePicker1MouseClicked

    }//GEN-LAST:event_timePicker1MouseClicked

    private void timePicker1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timePicker1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_timePicker1MouseReleased

    private void timePicker1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timePicker1PropertyChange

//        try {
//            Date startTime = new SimpleDateFormat("hh:mm a").parse(timePicker1.getSelectedTime());
//            String time = new SimpleDateFormat("HH:mm:ss").format(startTime);
//            onTime.setText(this.Date.getText() + " " + time);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_timePicker1PropertyChange

    private void employeeIdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeIdMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdMouseReleased

    private void offTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_offTimeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeFocusGained

    private void offTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_offTimeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeFocusLost

    private void offTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offTimeMouseReleased

        timePicker1.showPopup(this, 100, 100);
        offTime.setText(timePicker1.getSelectedTime());
    }//GEN-LAST:event_offTimeMouseReleased

    private void offTimejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offTimejTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimejTextField2ActionPerformed

    private void offTimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_offTimeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeKeyReleased

    private void offTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_offTimeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeKeyTyped

    private void loadAttendance(String userId) {

        try {

            String query = "SELECT * FROM `work_schedule` "
                    + "INNER JOIN `status` ON"
                    + "`status`.`id`=`work_schedule`.`status_id`"
                    + "WHERE `employee_id`='" + userId + "' ORDER BY `date` DESC ";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) attendanceHistory.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("date"));
                v.add(rs.getString("on_time"));
                v.add(rs.getString("off_time"));

                if (rs.getString("work_schedule.status_id").equals("1")) {
                    v.add(rs.getString("status.type"));
                } else {
                    v.add(rs.getString("status.type"));
                }

                tableModel.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadBeanData(String beanId) {

        UserBean bean = userMap.get(beanId);
        emFullName.setText(bean.getFullName());
        emMobile1.setText(bean.getMobile());
        emPercentage.setText(bean.getPercentage());
        emType.setText(bean.getUserRole());
        employeeId.setText(bean.getUserName());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceHistory;
    private javax.swing.JTable attendanceTable;
    private javax.swing.JLabel emFullName;
    private javax.swing.JLabel emMobile1;
    private javax.swing.JLabel emPercentage;
    private javax.swing.JLabel emType;
    private javax.swing.JTextField employeeId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField offTime;
    private com.raven.swing.TimePicker timePicker1;
    // End of variables declaration//GEN-END:variables
}
