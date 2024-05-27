package HR;

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
import GUI.Dashboard;

/**
 *
 * @author DS
 */
public class HrMain extends javax.swing.JFrame {

    public HashMap<String, UserBean> userMap = new HashMap<>();
    public Vector<UserBean> userVector = new Vector<>();

    /**
     * Creates new form HrDashboard
     */
//    public HrMain() {
    public HrMain(String fullName, String mobile, String regDate, String lgTime, String percentage) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);

        hrFullName.setText(fullName);
        hrMobile.setText(mobile);
        HrPercentage.setText(percentage);
        hrRegDate.setText(regDate);
        hrLogTime.setText(lgTime);
        loadWorkSchedule("");
        loadStocks();
        loadDate();

    }

    private void loadDate() {

        String date = new SimpleDateFormat("yyyy-MMMM-dd EEEE").format(new Date());
        Dat.setText(date);

    }

    private void loadStocks() {
        try {

            ResultSet activeStck = MySQL.execute("SELECT COUNT(*) AS `qty`  FROM `item` WHERE `current_qty`>=1");
            activeStck.next();
            activeStock.setText(activeStck.getInt("qty") + " " + activeStock.getText());

            ResultSet outStck = MySQL.execute("SELECT COUNT(*) AS `qty`  FROM `item` WHERE `current_qty`=0");
            outStck.next();
            outStock.setText(outStck.getInt("qty") + " " + outStock.getText());

            ResultSet minimum = MySQL.execute("SELECT COUNT(*) AS `qty` FROM `item` WHERE `current_qty`>=`min_qty`");
            minimum.next();
            minimuStock.setText(minimum.getInt("qty") + " " + minimuStock.getText());

            ResultSet totalemp = MySQL.execute("SELECT COUNT(*) AS `qty` FROM `employee` WHERE `status`=1");
            totalemp.next();
            this.totalemp.setText(minimum.getInt("qty") + " " + this.totalemp.getText());

            ResultSet rooms = MySQL.execute("SELECT COUNT(*) AS `qty` FROM `rooms` WHERE `room_status_id`=1");
            rooms.next();
            AvailbleRooms.setText(rooms.getInt("qty") + " " + AvailbleRooms.getText());

            absentEmp();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void absentEmp() {
        try {
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            ResultSet workSchedule = MySQL.execute("SELECT COUNT(*) AS `qty`  FROM `work_schedule` WHERE `status_id`='1' AND `date`='" + date + "' ");
            workSchedule.next();
            ResultSet Attendance = MySQL.execute("SELECT COUNT(*) AS `qty` FROM `staff_attendence` WHERE  `date` ='" + date + "'");
            Attendance.next();

            int absentEmp = workSchedule.getInt("qty") - Attendance.getInt("qty");

            if (absentEmp < 0) {
                absentWorkers.setText(0 + " " + absentWorkers.getText());
            } else {
                absentWorkers.setText(absentEmp + " " + absentWorkers.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    private void loadAttendance(String userId) {

        try {

            String query = "SELECT * FROM `work_schedule` "
                    + "INNER JOIN `status` ON"
                    + "`status`.`id`=`work_schedule`.`status_id`"
                    + "WHERE `employee_id`='" + userId + "' ORDER BY `date` DESC ";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) WorkScheduleTable.getModel();
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

    private void clearData() {
        emFullName.setText("");
        emMobile1.setText("");
        emPercentage.setText("");
        emType.setText("");

        WorkScheduleTable.clearSelection();
        attendanceTable.clearSelection();

        DefaultTableModel tableModel = (DefaultTableModel) WorkScheduleTable.getModel();
        tableModel.setRowCount(0);

        DefaultTableModel tablModel = (DefaultTableModel) attendanceTable.getModel();
        tableModel.setRowCount(0);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        employeeId = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        WorkScheduleTable = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        emFullName = new javax.swing.JLabel();
        emType = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        emPercentage = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        emMobile1 = new javax.swing.JLabel();
        offTime = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        hrFullName = new javax.swing.JLabel();
        hrMobile = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        hrRegDate = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        hrLogTime = new javax.swing.JLabel();
        activeStock = new javax.swing.JButton();
        outStock = new javax.swing.JButton();
        minimuStock = new javax.swing.JButton();
        totalemp = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        HrPercentage = new javax.swing.JLabel();
        absentWorkers = new javax.swing.JButton();
        AvailbleRooms = new javax.swing.JButton();
        Dat = new javax.swing.JLabel();

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

        jPanel1.setPreferredSize(new java.awt.Dimension(225, 450));

        jButton1.setBackground(new java.awt.Color(52, 73, 94));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DashBoard");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(52, 73, 94));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Work Schedule");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(52, 73, 94));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Employee Management");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(52, 73, 94));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Food Management");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton4.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(52, 73, 94));
        jButton5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Rooms Management");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton5.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(52, 73, 94));
        jButton6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Stock Management");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton6.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(52, 73, 94));
        jButton11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Employee Attendance");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton11.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(52, 73, 94));
        jButton12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Employee Salary");
        jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton12.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(557, 557, 557))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TRANQUIL TERRACE | HR Dashboard");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65), 0));

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "work schedule Id", "Employee Id ", "On Time", "Off Time"
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
        attendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendanceTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                attendanceTableMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(attendanceTable);
        if (attendanceTable.getColumnModel().getColumnCount() > 0) {
            attendanceTable.getColumnModel().getColumn(0).setResizable(false);
            attendanceTable.getColumnModel().getColumn(1).setResizable(false);
            attendanceTable.getColumnModel().getColumn(2).setResizable(false);
            attendanceTable.getColumnModel().getColumn(3).setResizable(false);
        }

        employeeId.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        employeeId.setText("Employee Id");
        employeeId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeIdFocusLost(evt);
            }
        });
        employeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdjTextField2ActionPerformed(evt);
            }
        });
        employeeId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                employeeIdKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Work Schedule");

        WorkScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
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
        WorkScheduleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WorkScheduleTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(WorkScheduleTable);

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Employee Full Name : ");

        emFullName.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emFullName.setForeground(new java.awt.Color(255, 255, 255));
        emFullName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        emType.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emType.setForeground(new java.awt.Color(255, 255, 255));
        emType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel39.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Employee Type : ");

        jLabel40.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Attendance percentage : ");

        emPercentage.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emPercentage.setForeground(new java.awt.Color(255, 255, 255));
        emPercentage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton19.setBackground(new java.awt.Color(245, 71, 104));
        jButton19.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/HR-attendance.png"))); // NOI18N
        jButton19.setText("   Authorized");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Mobile :");

        emMobile1.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emMobile1.setForeground(new java.awt.Color(255, 255, 255));
        emMobile1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        offTime.setEditable(false);
        offTime.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(218, 218, 218))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addGap(11, 11, 11)
                                        .addComponent(emPercentage))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addGap(11, 11, 11)
                                        .addComponent(emMobile1))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel36)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel39)
                                                .addGap(11, 11, 11)
                                                .addComponent(emType)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emFullName))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(offTime, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52)
                                        .addComponent(jButton19)))
                                .addGap(0, 134, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(offTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(emFullName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(emType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(emPercentage))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(emMobile1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.add(jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65), 0));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel21.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("User name :");

        hrFullName.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        hrFullName.setForeground(new java.awt.Color(255, 255, 255));
        hrFullName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hrFullName.setText("User Full Name");

        hrMobile.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        hrMobile.setForeground(new java.awt.Color(255, 255, 255));
        hrMobile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hrMobile.setText("User Type");

        jLabel25.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("User Mobile :");

        jLabel22.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Registered Date :");

        hrRegDate.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        hrRegDate.setForeground(new java.awt.Color(255, 255, 255));
        hrRegDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hrRegDate.setText("Date");

        jLabel26.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Logged Time : ");

        hrLogTime.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        hrLogTime.setForeground(new java.awt.Color(255, 255, 255));
        hrLogTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hrLogTime.setText("Time");

        activeStock.setBackground(new java.awt.Color(0, 51, 51));
        activeStock.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        activeStock.setText("Active Stocks");

        outStock.setBackground(new java.awt.Color(0, 0, 51));
        outStock.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        outStock.setText("OutOf Stocks");
        outStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outStockActionPerformed(evt);
            }
        });

        minimuStock.setBackground(new java.awt.Color(51, 0, 51));
        minimuStock.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        minimuStock.setText("Minimum Stocks");
        minimuStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimuStockActionPerformed(evt);
            }
        });

        totalemp.setBackground(new java.awt.Color(51, 51, 0));
        totalemp.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        totalemp.setText("Total Employees");

        jLabel34.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Attendance Percentange : ");

        HrPercentage.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        HrPercentage.setForeground(new java.awt.Color(255, 255, 255));
        HrPercentage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HrPercentage.setText("100%");

        absentWorkers.setBackground(new java.awt.Color(0, 51, 51));
        absentWorkers.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        absentWorkers.setText("Absent workers ");

        AvailbleRooms.setBackground(new java.awt.Color(51, 0, 0));
        AvailbleRooms.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        AvailbleRooms.setText("Availble rooms");
        AvailbleRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailbleRoomsActionPerformed(evt);
            }
        });

        Dat.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        Dat.setForeground(new java.awt.Color(18, 173, 193));
        Dat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dat.setText("Day Time");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hrRegDate))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(activeStock, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(outStock, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minimuStock, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel21))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(hrFullName))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hrMobile))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hrLogTime))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(totalemp, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(absentWorkers, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AvailbleRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HrPercentage)))
                        .addGap(15, 18, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Dat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Dat)
                .addGap(88, 88, 88)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(hrFullName))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(hrMobile))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(hrRegDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(hrLogTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(HrPercentage))
                .addGap(95, 95, 95)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimuStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalemp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(absentWorkers, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AvailbleRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(351, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel6);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WorkSchedule ws = new WorkSchedule();
        ws.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EmployeeManagement em = new EmployeeManagement();
        em.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FoodItemManagement fd = new FoodItemManagement();
        fd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        EmpAttendance Attendance = new EmpAttendance();
        Attendance.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Salary salary = new Salary();
        salary.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void employeeIdjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdjTextField2ActionPerformed

    private void minimuStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimuStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimuStockActionPerformed

    private void AvailbleRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailbleRoomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AvailbleRoomsActionPerformed

    private void employeeIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeIdKeyReleased

        if (evt.getKeyCode() == 10) {

            loadAttendance(employeeId.getText());
            String key = "`employee`.`id`='" + employeeId.getText() + "' AND";
            loadWorkSchedule(key);

        } else {
            clearData();
        }


    }//GEN-LAST:event_employeeIdKeyReleased

    private void employeeIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdKeyTyped

    private void attendanceTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceTableMouseReleased


    }//GEN-LAST:event_attendanceTableMouseReleased

    private void attendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceTableMouseClicked

        int selectedRow = attendanceTable.getSelectedRow();

        if (evt.getClickCount() == 1 && selectedRow != -1) {

            String scheduleId = attendanceTable.getValueAt(selectedRow, 0).toString();
            loadBeanData(scheduleId);
            loadAttendance(employeeId.getText());

        }

    }//GEN-LAST:event_attendanceTableMouseClicked

    private void WorkScheduleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WorkScheduleTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_WorkScheduleTableMouseClicked

    private void outStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outStockActionPerformed

    private void employeeIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeIdFocusGained

        if (employeeId.getText().equals("Employee Id")) {
            employeeId.setText("");
        }

    }//GEN-LAST:event_employeeIdFocusGained

    private void employeeIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeIdFocusLost
        if (employeeId.getText().equals("")) {
            employeeId.setText("Employee Id");
        }
    }//GEN-LAST:event_employeeIdFocusLost

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        try {

            int selectedRow = attendanceTable.getSelectedRow();

            if (selectedRow != -1) {

                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

                String onTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                String EmployeeId = attendanceTable.getValueAt(selectedRow, 1).toString();

                if (offTime.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Select Off Time", "Error", JOptionPane.WARNING_MESSAGE);

                } else {

                    MySQL.execute("INSERT INTO `hotel_db`.`staff_attendence` (`date`, `on_time`, `off_time`, `employee_id`) "
                            + "VALUES ('" + date + "', '" + onTime + "', '" + offTime.getText() + "', '" + EmployeeId + "');");

                    System.out.println("hello");

                    MySQL.execute("UPDATE `hotel_db`.`work_schedule` SET `status_id`='1' WHERE  `id`='" + attendanceTable.getValueAt(selectedRow, 0).toString() + "'");

                    JOptionPane.showMessageDialog(this, "Attendance Marked", "successfully", JOptionPane.INFORMATION_MESSAGE);

                    loadAttendance("");
                    loadWorkSchedule("");
                    clearData();
                }

            } else {

                JOptionPane.showMessageDialog(this, "please Select Attendance", "warning", JOptionPane.WARNING_MESSAGE);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton19ActionPerformed

    private void offTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_offTimeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeFocusGained

    private void offTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_offTimeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeFocusLost

    private void offTimejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offTimejTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimejTextField2ActionPerformed

    private void offTimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_offTimeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeKeyReleased

    private void offTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_offTimeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeKeyTyped

    private void timePicker1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePicker1FocusLost

    }//GEN-LAST:event_timePicker1FocusLost

    private void timePicker1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timePicker1MouseClicked

    }//GEN-LAST:event_timePicker1MouseClicked

    private void timePicker1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timePicker1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_timePicker1MouseReleased

    private void timePicker1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timePicker1PropertyChange

        try {
            Date startTime = new SimpleDateFormat("hh:mm a").parse(timePicker1.getSelectedTime());
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            String time = new SimpleDateFormat("HH:mm:ss").format(startTime);
            offTime.setText(date + " " + time);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_timePicker1PropertyChange

    private void offTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offTimeMouseReleased

        timePicker1.showPopup(this, 100, 100);
        offTime.setText(timePicker1.getSelectedTime());
    }//GEN-LAST:event_offTimeMouseReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HrMain().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AvailbleRooms;
    private javax.swing.JLabel Dat;
    private javax.swing.JLabel HrPercentage;
    private javax.swing.JTable WorkScheduleTable;
    private javax.swing.JButton absentWorkers;
    private javax.swing.JButton activeStock;
    private javax.swing.JTable attendanceTable;
    private javax.swing.JLabel emFullName;
    private javax.swing.JLabel emMobile1;
    private javax.swing.JLabel emPercentage;
    private javax.swing.JLabel emType;
    private javax.swing.JTextField employeeId;
    private javax.swing.JLabel hrFullName;
    private javax.swing.JLabel hrLogTime;
    private javax.swing.JLabel hrMobile;
    private javax.swing.JLabel hrRegDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton minimuStock;
    private javax.swing.JTextField offTime;
    private javax.swing.JButton outStock;
    private com.raven.swing.TimePicker timePicker1;
    private javax.swing.JButton totalemp;
    // End of variables declaration//GEN-END:variables
}
