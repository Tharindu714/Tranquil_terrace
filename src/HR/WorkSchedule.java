package HR;

import GUI.Dashboard;
import java.sql.Connection;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.UserBean;
import model.Validation;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.DriverManager;

public class WorkSchedule extends javax.swing.JFrame {

    public HashMap<String, UserBean> userMap = new HashMap<>();
    public Vector<UserBean> userVector = new Vector<>();

    public WorkSchedule() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        loadEmployee();
        loadworkSchedule("");
        department(dateDepart.getText());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        timePicker2 = new com.raven.swing.TimePicker();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        onTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        offTime = new javax.swing.JTextField();
        emEmId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        WorkScheduleTable = new javax.swing.JTable();
        emDep = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        emPercentage = new javax.swing.JLabel();
        emFullName = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        emUserName = new javax.swing.JLabel();
        emType = new javax.swing.JLabel();
        emMobile1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        dateDepart = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        departmentTable = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

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

        timePicker2.set24hourMode(false);
        timePicker2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timePicker2PropertyChange(evt);
            }
        });

        dateChooser1.setForeground(new java.awt.Color(0, 51, 102));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(Date);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(dateDepart);

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
        jLabel1.setText("TRANQUIL TERRACE | Work Schedule");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE)
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

        jPanel2.setPreferredSize(new java.awt.Dimension(225, 400));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Employee ID");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("On TIme");

        onTime.setEditable(false);
        onTime.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        onTime.setForeground(java.awt.Color.white);
        onTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onTimeFocusGained(evt);
            }
        });
        onTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTimeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onTimeMouseReleased(evt);
            }
        });
        onTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onTimeActionPerformed(evt);
            }
        });
        onTime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                onTimePropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Off Time");

        offTime.setEditable(false);
        offTime.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        offTime.setForeground(java.awt.Color.white);
        offTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offTimeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                offTimeMouseReleased(evt);
            }
        });
        offTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offTimeActionPerformed(evt);
            }
        });
        offTime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                offTimePropertyChange(evt);
            }
        });

        emEmId.setEditable(false);
        emEmId.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        emEmId.setForeground(java.awt.Color.white);
        emEmId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emEmIdMouseClicked(evt);
            }
        });
        emEmId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emEmIdActionPerformed(evt);
            }
        });
        emEmId.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                emEmIdPropertyChange(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Date");

        Date.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        Date.setForeground(java.awt.Color.white);
        Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DateMouseReleased(evt);
            }
        });
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(245, 71, 104));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Schedule");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(52, 73, 94));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Date)
                    .addComponent(emEmId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(offTime)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addGap(71, 71, 71))
                    .addComponent(onTime)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(emEmId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(onTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(offTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(477, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        WorkScheduleTable.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        WorkScheduleTable.setForeground(new java.awt.Color(255, 255, 255));
        WorkScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Employee ID", "Start Time", "Off time", "status", "date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        WorkScheduleTable.setSelectionBackground(new java.awt.Color(245, 71, 104));
        WorkScheduleTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        WorkScheduleTable.setShowGrid(false);
        WorkScheduleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WorkScheduleTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(WorkScheduleTable);
        if (WorkScheduleTable.getColumnModel().getColumnCount() > 0) {
            WorkScheduleTable.getColumnModel().getColumn(0).setResizable(false);
            WorkScheduleTable.getColumnModel().getColumn(1).setResizable(false);
            WorkScheduleTable.getColumnModel().getColumn(2).setResizable(false);
            WorkScheduleTable.getColumnModel().getColumn(4).setResizable(false);
        }

        emDep.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emDep.setForeground(new java.awt.Color(255, 255, 255));
        emDep.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emDep.setText("name");

        jLabel47.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Working Department : ");

        jLabel44.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Working Percentage  :");

        emPercentage.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emPercentage.setForeground(new java.awt.Color(255, 255, 255));
        emPercentage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emPercentage.setText("100%");

        emFullName.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emFullName.setForeground(new java.awt.Color(255, 255, 255));
        emFullName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emFullName.setText("User Full Name");

        jLabel36.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Employee Full Name : ");

        jLabel38.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Employee User Name : ");

        emUserName.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emUserName.setForeground(new java.awt.Color(255, 255, 255));
        emUserName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emUserName.setText("User Full Name");

        emType.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emType.setForeground(new java.awt.Color(255, 255, 255));
        emType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emType.setText("User Full Name");

        emMobile1.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        emMobile1.setForeground(new java.awt.Color(255, 255, 255));
        emMobile1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emMobile1.setText("075XXXXXXX");

        jLabel40.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Employee Role : ");

        jLabel43.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Employee Mobile : ");

        employeeTable.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        employeeTable.setForeground(new java.awt.Color(255, 255, 255));
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Employee", "Department", "Mobile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.setSelectionBackground(new java.awt.Color(245, 71, 104));
        employeeTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        employeeTable.setShowGrid(false);
        employeeTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employeeTableFocusLost(evt);
            }
        });
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(employeeTable);

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel43))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emMobile1)
                            .addComponent(emType)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emUserName))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emFullName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addComponent(emPercentage))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(18, 18, 18)
                        .addComponent(emDep)))
                .addGap(21, 21, 21))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jScrollPane1))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(emUserName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(emType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(emMobile1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel36)
                                .addComponent(emFullName))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44)
                                .addComponent(emPercentage)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(emDep))
                        .addGap(54, 54, 54)))
                .addGap(22, 22, 22))
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setText("Date");

        dateDepart.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        dateDepart.setForeground(java.awt.Color.white);
        dateDepart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateDepartMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dateDepartMouseReleased(evt);
            }
        });
        dateDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateDepartActionPerformed(evt);
            }
        });
        dateDepart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateDepartPropertyChange(evt);
            }
        });

        departmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Department", "Employees"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(departmentTable);
        if (departmentTable.getColumnModel().getColumnCount() > 0) {
            departmentTable.getColumnModel().getColumn(0).setResizable(false);
            departmentTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton7.setBackground(new java.awt.Color(245, 71, 104));
        jButton7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Select Date");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(18, 173, 193));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/view-detail.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(34, 34, 34)
                        .addComponent(dateDepart, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(125, 125, 125)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(dateDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadworkSchedule(String date) {

        try {

            String query = "SELECT * FROM `work_schedule` "
                    + "INNER JOIN `status` ON"
                    + "`status`.`id`=`work_schedule`.`status_id`"
                    + "INNER JOIN `employee` ON"
                    + "`employee`.`id`=`work_schedule`.`employee_id`"
                    + "WHERE `employee`.`employee_type_id`!='1' " + date + ""
                    + "ORDER BY `date` DESC,`on_time` ASC ";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) WorkScheduleTable.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("work_schedule.id"));
                v.add(rs.getString("employee.id"));
                v.add(rs.getString("on_time"));
                v.add(rs.getString("off_time"));

                if (rs.getString("work_schedule.status_id").equals("1")) {
                    v.add(rs.getString("status.type"));
                } else {
                    v.add(rs.getString("status.type"));
                }
                v.add(rs.getString("date"));

                tableModel.addRow(v);

            }

            department(dateDepart.getText());

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

    private void loadEmployee() {

        try {

            String query = "SELECT * FROM `employee` "
                    + "INNER JOIN `department` ON"
                    + "`department`.`id`=`employee`.`department_id`"
                    + "INNER JOIN `employee_type` ON"
                    + "`employee_type`.`id`=`employee`.`employee_type_id`"
                    + "INNER JOIN `status` ON"
                    + "`status`.`id`=`employee`.`status`"
                    + "WHERE `employee_type`.`type`!='Administrator'"
                    + "ORDER BY `employee`.`department_id` ASC ";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) employeeTable.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("employee.id"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("department.name"));
                v.add(rs.getString("mobile"));

                UserBean bean = new UserBean();

                bean.setEmId(rs.getString("employee.id"));
                bean.setUserName(rs.getString("employee.username"));
                bean.setMobile(rs.getString("mobile"));
                bean.setFullName(rs.getString("first_name") + " " + rs.getString("last_name"));
                bean.setUserRole(rs.getString("employee_type.type"));
                bean.setPercentage(percentage(rs.getString("employee.id")));
                bean.setStatus(rs.getString("status.type"));
                bean.setDepartment(rs.getString("department.name"));

                tableModel.addRow(v);
                userMap.put(rs.getString("employee.id"), bean);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadData(String beanId) {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        UserBean bean = userMap.get(beanId);
        emFullName.setText(bean.getFullName());
        emMobile1.setText(bean.getMobile());
        emPercentage.setText(bean.getPercentage());
        emType.setText(bean.getUserRole());
        emUserName.setText(bean.getUserName());
        emEmId.setText(bean.getEmId());
        emDep.setText(bean.getDepartment());

    }

    private void department(String date) {

        try {

            String query = "SELECT COUNT(*) AS qty,`department`.`name` FROM `work_schedule` \n"
                    + "INNER JOIN `employee` ON \n"
                    + "`employee`.`id`=`work_schedule`.`employee_id` \n"
                    + "INNER JOIN `department` ON `department`.`id`=`employee`.`department_id`\n"
                    + "WHERE `work_schedule`.`date`='" + date + "'\n"
                    + "GROUP BY  `department`.`name` ";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) departmentTable.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("name"));
                v.add(rs.getString("qty"));

                tableModel.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        department(dateDepart.getText());
        loadworkSchedule("AND `work_schedule`.`date`='" + dateDepart.getText() + "'");

    }//GEN-LAST:event_jButton7ActionPerformed

    private void dateDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateDepartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateDepartActionPerformed

    private void dateDepartMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateDepartMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dateDepartMouseReleased

    private void dateDepartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateDepartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dateDepartMouseClicked

    private void clearData() {

        emEmId.setText("");
        onTime.setText("");
        offTime.setText("");
        Date.setText("");
        WorkScheduleTable.clearSelection();
        employeeTable.clearSelection();

        emFullName.setText("");
        emUserName.setText("");
        emType.setText("");
        emMobile1.setText("");

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String employeeId = emEmId.getText();
        String OnTme = onTime.getText();
        String OffTme = offTime.getText();
        String date = Date.getText();
        boolean Found = false;

        int selectedRow = WorkScheduleTable.getSelectedRow();

        if (selectedRow != -1) {

            if (employeeId.equals(WorkScheduleTable.getValueAt(selectedRow, 1).toString())) {
                Found = true;
                System.out.println("true");
            } else {
                Found = false;
                System.out.println("false");
            }

            if (OnTme.equals(WorkScheduleTable.getValueAt(selectedRow, 2).toString()) && Found) {
                Found = true;
                System.out.println("true");
            } else {
                Found = false;
                System.out.println("false");

            }

            if (OffTme.equals(WorkScheduleTable.getValueAt(selectedRow, 3).toString()) && Found) {
                Found = true;
                System.out.println("true");
            } else {
                Found = false;
                System.out.println("false");

            }

            if (date.equals(WorkScheduleTable.getValueAt(selectedRow, 5).toString()) && Found) {
                Found = true;
                System.out.println("true");
            } else {
                Found = false;
                System.out.println("false");

            }

            if (!Found) {

                try {

                    MySQL.execute("UPDATE `hotel_db`.`work_schedule` "
                            + "SET `date`='" + date + "', `employee_id`='" + employeeId + "',"
                            + "`on_time`='" + OnTme + "', `off_time`='" + OffTme + "' "
                            + "WHERE  `id`='" + WorkScheduleTable.getValueAt(selectedRow, 0) + "'");
                    JOptionPane.showMessageDialog(this, "Schedule Updated", "Updated", JOptionPane.INFORMATION_MESSAGE);
                    loadworkSchedule("");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                JOptionPane.showMessageDialog(this, "Schedule has already Exsits", "Wrong", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(this, "Please Select First", "Wrong", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = WorkScheduleTable.getSelectedRow();

        if (selectedRow == -1) {

            String employeeId = emEmId.getText();
            String ontme = onTime.getText();
            String offtme = offTime.getText();
            String date = Date.getText();

            Validation valid = new Validation();

            if (valid.emptyValue(emEmId, "")) {

                JOptionPane.showMessageDialog(this, "Please Enter Employee Id or Select Employee", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (valid.emptyValue(onTime, "")) {

                JOptionPane.showMessageDialog(this, "Please Select Schedule Start Time", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (valid.emptyValue(offTime, "")) {

                JOptionPane.showMessageDialog(this, "Please Select Schedule End Time", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else {

                try {
                    MySQL.execute("INSERT INTO `hotel_db`.`work_schedule` (`date`, `employee_id`, `status_id`, `on_time`, `off_time`)"
                            + " VALUES ('" + date + "', '" + employeeId + "', '2', '" + ontme + "', '" + offtme + "');");

                    JOptionPane.showMessageDialog(this, "Schedule Activate Successfully", "Wrong", JOptionPane.INFORMATION_MESSAGE);

                    loadworkSchedule("");
                } catch (Exception e) {

                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Insert Faild", "Wrong", JOptionPane.ERROR_MESSAGE);

                }

            }
        } else {

            JOptionPane.showMessageDialog(this, "this Schedule already Exists, please make new Schedule", "Wrong", JOptionPane.ERROR_MESSAGE);
            clearData();

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateActionPerformed

    private void DateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateMouseReleased

    }//GEN-LAST:event_DateMouseReleased

    private void DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DateMouseClicked

    private void emEmIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emEmIdActionPerformed

    }//GEN-LAST:event_emEmIdActionPerformed

    private void emEmIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emEmIdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emEmIdMouseClicked

    private void offTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offTimeActionPerformed

    private void offTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offTimeMouseReleased

        timePicker2.showPopup(this, 100, 200);
        offTime.setText(timePicker2.getSelectedTime());
    }//GEN-LAST:event_offTimeMouseReleased

    private void offTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offTimeMouseClicked

    }//GEN-LAST:event_offTimeMouseClicked

    private void onTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onTimeActionPerformed

    }//GEN-LAST:event_onTimeActionPerformed

    private void onTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onTimeMouseReleased
        timePicker1.showPopup(this, 100, 100);
        onTime.setText(timePicker1.getSelectedTime());
    }//GEN-LAST:event_onTimeMouseReleased

    private void onTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_onTimeFocusGained

    }//GEN-LAST:event_onTimeFocusGained

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked

        int selectedRow = employeeTable.getSelectedRow();

        if (evt.getClickCount() == 1 && selectedRow != -1) {

            String employeeId = employeeTable.getValueAt(selectedRow, 0).toString();
            onTime.setText("");
            offTime.setText("");
            loadData(employeeId);

        }


    }//GEN-LAST:event_employeeTableMouseClicked


    private void WorkScheduleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WorkScheduleTableMouseClicked

        int selectedRow = WorkScheduleTable.getSelectedRow();

        if (evt.getClickCount() == 1 && selectedRow != -1) {

            String employeeId = WorkScheduleTable.getValueAt(selectedRow, 1).toString();
            loadData(employeeId);
            String ontTime = WorkScheduleTable.getValueAt(selectedRow, 2).toString();
            String offTTime = WorkScheduleTable.getValueAt(selectedRow, 3).toString();
            String date = WorkScheduleTable.getValueAt(selectedRow, 5).toString();

            this.onTime.setText(ontTime);
            this.offTime.setText(offTTime);
            this.Date.setText(date);

        }


    }//GEN-LAST:event_WorkScheduleTableMouseClicked

    private void timePicker1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timePicker1MouseClicked

    }//GEN-LAST:event_timePicker1MouseClicked

    private void offTimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_offTimePropertyChange

    }//GEN-LAST:event_offTimePropertyChange

    private void timePicker1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timePicker1PropertyChange

        try {
            Date startTime = new SimpleDateFormat("hh:mm a").parse(timePicker1.getSelectedTime());
            String time = new SimpleDateFormat("HH:mm:ss").format(startTime);
            onTime.setText(this.Date.getText() + " " + time);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_timePicker1PropertyChange

    private void timePicker1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timePicker1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_timePicker1MouseReleased

    private void timePicker1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePicker1FocusLost

    }//GEN-LAST:event_timePicker1FocusLost

    private void emEmIdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_emEmIdPropertyChange
    }//GEN-LAST:event_emEmIdPropertyChange

    private void onTimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_onTimePropertyChange

    }//GEN-LAST:event_onTimePropertyChange

    private void onTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onTimeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_onTimeMouseClicked

    private void timePicker2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timePicker2PropertyChange
        try {
            Date startTime = new SimpleDateFormat("hh:mm a").parse(timePicker2.getSelectedTime());
            String time = new SimpleDateFormat("HH:mm:ss").format(startTime);
            offTime.setText(this.Date.getText() + " " + time);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_timePicker2PropertyChange

    private void employeeTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeTableFocusLost


    }//GEN-LAST:event_employeeTableFocusLost

    private void employeeTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeTableFocusGained
        // TODO add your handling code here:
        WorkScheduleTable.clearSelection();
    }//GEN-LAST:event_employeeTableFocusGained

    private void dateDepartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateDepartPropertyChange

    }//GEN-LAST:event_dateDepartPropertyChange

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you need to Print Employee Work Schedule Report?", "Confirm Alert",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                HashMap<String, Object> map = new HashMap<>();

                InputStream reportPath = Dashboard.class.getResourceAsStream("/reports/work_schedule.jasper");

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "tharinduCHA@8754");

                JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, map, connection);
                JasperViewer.viewReport(jasperPrint, false);

            } catch (Exception e) {
                Dashboard.log.warning(e.toString());
            }
        } else {

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Date;
    private javax.swing.JTable WorkScheduleTable;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JTextField dateDepart;
    private javax.swing.JTable departmentTable;
    private javax.swing.JLabel emDep;
    private javax.swing.JTextField emEmId;
    private javax.swing.JLabel emFullName;
    private javax.swing.JLabel emMobile1;
    private javax.swing.JLabel emPercentage;
    private javax.swing.JLabel emType;
    private javax.swing.JLabel emUserName;
    private javax.swing.JTable employeeTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField offTime;
    private javax.swing.JTextField onTime;
    private com.raven.swing.TimePicker timePicker1;
    private com.raven.swing.TimePicker timePicker2;
    // End of variables declaration//GEN-END:variables
}
