package HR;

import com.formdev.flatlaf.IntelliJTheme;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.UserBean;
import model.Validation;
import GUI.Dashboard;

public class EmployeeManagement extends javax.swing.JFrame {

    public HashMap<String, UserBean> userMap = new HashMap<>();
    public HashMap<String, String> role = new HashMap<>();
    public HashMap<String, String> department = new HashMap<>();
    public HashMap<String, String> genderMap = new HashMap<>();
    public Vector<UserBean> userVector = new Vector<>();

    /**
     * Creates new form EmployeeManagement
     */
    public EmployeeManagement() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        employeeManagement("");
        loadRole();
        loadDepartments();
        loadGender();

    }

    private void loadGender() {

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {

                v.add(resultSet.getString("gender"));
                genderMap.put(resultSet.getString("id"), resultSet.getString("gender"));

            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            gender.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadDepartments() {

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `department`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {

                v.add(resultSet.getString("name"));
                department.put(resultSet.getString("name"), resultSet.getString("id"));

            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            depart.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadRole() {

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee_type`");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {

                v.add(resultSet.getString("type"));
                role.put(resultSet.getString("type"), resultSet.getString("id"));

            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            Role.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void employeeManagement(String Search) {

        try {

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String hour = new SimpleDateFormat("HH").format(new Date());

            ResultSet rs = MySQL.execute("SELECT * FROM `employee` INNER JOIN `department`  ON\n"
                    + "`department`.`id`=`employee`.`department_id`\n"
                    + "INNER JOIN `employee_type` ON \n"
                    + "`employee`.`employee_type_id`=`employee_type`.`id`\n"
                    + "INNER JOIN `status` ON \n"
                    + "`employee`.`status`=`status`.`id`\n"
                    + "INNER JOIN `gender` ON \n"
                    + "`employee`.`gender_id`=`gender`.`id` " + Search + " ORDER BY `registered_date` DESC ");

            DefaultTableModel tableModel = (DefaultTableModel) employeeTable.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("employee.id"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("status.type"));
                v.add(rs.getString("employee_type.type"));
                v.add(rs.getString("department.name"));

                UserBean bean = new UserBean();
//

                bean.setEmId(rs.getString("employee.id"));
                bean.setMobile(rs.getString("mobile"));
                bean.setFirst_name(rs.getString("first_name"));
                bean.setLast_name(rs.getString("last_name"));
                bean.setStatus(rs.getString("status.type"));
                bean.setUserRole(rs.getString("employee_type.type"));
                bean.setDepartment(rs.getString("department.name"));
                bean.setUserName(rs.getString("username"));
                bean.setRegDate(rs.getString("registered_date"));
                bean.setPassword(rs.getString("password"));
                bean.setGender(rs.getString("gender.gender"));

                if (rs.getString("employee.status").equals("1")) {
                    v.add(rs.getString("status.type"));
                } else {
                    v.add(rs.getString("status.type"));
                }
                tableModel.addRow(v);
                userMap.put(rs.getString("employee.id"), bean);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Mobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Role = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        depart = new javax.swing.JComboBox<>();
        gender = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        searchEmployee = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        regDate = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(52, 73, 94));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel4.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TRANQUIL TERRACE | Employee Mnagement");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(225, 400));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("First Name");

        firstName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        firstName.setForeground(java.awt.Color.white);

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Last Name");

        lastName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        lastName.setForeground(java.awt.Color.white);

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Mobile");

        Mobile.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        Mobile.setForeground(java.awt.Color.white);
        Mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("User Name");

        UserName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        UserName.setForeground(java.awt.Color.white);

        jButton1.setBackground(new java.awt.Color(245, 71, 104));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Register New Employee");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(52, 73, 94));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update Selected Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Role.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        Role.setForeground(java.awt.Color.white);
        Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Role");

        password.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        password.setForeground(java.awt.Color.white);

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Password");

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Department");

        depart.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        depart.setForeground(java.awt.Color.white);
        depart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departActionPerformed(evt);
            }
        });

        gender.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        gender.setForeground(java.awt.Color.white);
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("Gender");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Mobile, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lastName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        employeeTable.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        employeeTable.setForeground(new java.awt.Color(255, 255, 255));
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "First Name", "Last Name", "Mobile", "Status", "Role", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.setSelectionBackground(new java.awt.Color(245, 71, 104));
        employeeTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        employeeTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employeeTableFocusGained(evt);
            }
        });
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTable);
        if (employeeTable.getColumnModel().getColumnCount() > 0) {
            employeeTable.getColumnModel().getColumn(0).setResizable(false);
            employeeTable.getColumnModel().getColumn(1).setResizable(false);
            employeeTable.getColumnModel().getColumn(2).setResizable(false);
            employeeTable.getColumnModel().getColumn(3).setResizable(false);
            employeeTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setPreferredSize(new java.awt.Dimension(1061, 100));

        searchEmployee.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        searchEmployee.setForeground(java.awt.Color.white);
        searchEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchEmployeeKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Employee Id / User Name");

        jComboBox3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jComboBox3.setForeground(java.awt.Color.white);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Register Date : ");

        date.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        date.setText("Date");

        regDate.setFont(new java.awt.Font("DinaminaUniWeb", 0, 17)); // NOI18N
        regDate.setForeground(new java.awt.Color(255, 255, 255));
        regDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        regDate.setText("User Full Name");

        jLabel36.setFont(new java.awt.Font("DinaminaUniWeb", 1, 17)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Role : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(28, 28, 28)
                        .addComponent(date))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(65, 65, 65)
                        .addComponent(regDate)))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(searchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(date))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(regDate)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        HrSignIn hr = new HrSignIn();
        hr.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int selectedRow = employeeTable.getSelectedRow();
        Validation valid = new Validation();

        if (selectedRow == -1) {

            if (valid.emptyValue(firstName, "")) {

                JOptionPane.showMessageDialog(this, "Please Enter First Name", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (valid.emptyValue(lastName, "")) {

                JOptionPane.showMessageDialog(this, "Please Enter Last Name", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (valid.phoneNumberValidate(Mobile)) {

            } else if (valid.emptyValue(Role)) {

                JOptionPane.showMessageDialog(this, "Please Select Job Role", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (valid.emptyValue(depart)) {

                JOptionPane.showMessageDialog(this, "Please Select Department", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (valid.emptyValue(UserName, "")) {

                JOptionPane.showMessageDialog(this, "Please Enter User Name", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (!valid.is_Valid_Password(password)) {

                JOptionPane.showMessageDialog(this, "Invalid Password A-Z, a-z, 0-9 ", "Wrong", JOptionPane.ERROR_MESSAGE);
            } else {

                try {

                    String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

                    MySQL.execute("INSERT INTO `hotel_db`.`employee` (`first_name`, `last_name`, `mobile`, `username`, `password`, `status`, `registered_date`, `employee_type_id`, `gender_id`, `loggedtime`, `department_id`) "
                            + "VALUES ('" + firstName.getText() + "', '" + lastName.getText() + "', '" + Mobile.getText() + "', '" + UserName.getText() + "', '" + String.valueOf(password.getPassword()) + "', '1', '" + date
                            + "', '" + role.get(Role.getSelectedItem()) + "', '" + genderMap.get(gender.getSelectedItem()) + "', '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "', '" + department.get(depart.getSelectedItem()) + "');");

                    JOptionPane.showMessageDialog(this, firstName.getText() + " Success Fully Registerd", "Complete", JOptionPane.INFORMATION_MESSAGE);
                    employeeManagement("");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "this employee is already Exits", "Wrong", JOptionPane.ERROR_MESSAGE);
            clearData();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int selectedIndex = employeeTable.getSelectedRow();

        Validation valid = new Validation();

        if (selectedIndex != -1) {

            if (valid.phoneNumberValidate(Mobile)) {

            } else if (valid.emptyValue(Role)) {

                JOptionPane.showMessageDialog(this, "Please Select Job Role", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else if (valid.emptyValue(depart)) {

                JOptionPane.showMessageDialog(this, "Please Select Department", "Wrong", JOptionPane.ERROR_MESSAGE);

            } else {

                try {

                    try {

                        MySQL.execute("UPDATE `hotel_db`.`employee` "
                                + "SET `mobile`='" + Mobile.getText() + "', `employee_type_id`='" + role.get(Role.getSelectedItem()) + "', `department_id`='" + department.get(depart.getSelectedItem()) + "' WHERE  `id`='" + employeeTable.getValueAt(selectedIndex, 0) + "';");
                        JOptionPane.showMessageDialog(this, "Successfully", "Employee Details Updated ", JOptionPane.INFORMATION_MESSAGE);
                        employeeManagement("");
                        clearData();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "this employee is already Exits", "Wrong", JOptionPane.ERROR_MESSAGE);
            clearData();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void setDisable() {

        firstName.setEnabled(false);
        lastName.setEnabled(false);
        UserName.setEnabled(false);
        password.setEnabled(false);
        gender.setEnabled(false);

    }

    private void setEnable() {

        firstName.setEnabled(true);
        lastName.setEnabled(true);
        UserName.setEnabled(true);
        password.setEnabled(true);
        gender.setEnabled(true);

    }

    private void clearData() {

        firstName.setText("");
        lastName.setText("");
        Mobile.setText("");
        Role.setSelectedIndex(0);
        depart.setSelectedIndex(0);
        password.setText("");
        regDate.setText("");
        UserName.setText("");

        employeeTable.clearSelection();
        setEnable();

    }

    private void loadBeanData(String beanId) {

        UserBean bean = userMap.get(beanId);
        firstName.setText(bean.getFirst_name());
        lastName.setText(bean.getLast_name());
        Mobile.setText(bean.getMobile());
        password.setText(bean.getPassword());
        regDate.setText(bean.getRegDate());
        UserName.setText(bean.getUserName());

        Role.setSelectedItem(bean.getUserRole());
        depart.setSelectedItem(bean.getDepartment());
        gender.setSelectedItem(bean.getGender());

    }

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked

        int selectedRow = employeeTable.getSelectedRow();

        if (evt.getClickCount() == 1 && selectedRow != -1) {

            String employeeId = employeeTable.getValueAt(selectedRow, 0).toString();
            setDisable();
            loadBeanData(employeeId);
//            loadAttendance(employeeId.getText());

        }

    }//GEN-LAST:event_employeeTableMouseClicked

    private void MobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileActionPerformed

    private void RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void departActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departActionPerformed

    private void searchEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEmployeeKeyReleased

        String searchText = searchEmployee.getText();
        if (searchText.length() > 3) {

            try {

                employeeManagement("WHERE `first_name` LIKE '%" + searchText + "%' OR `username` Like '%" + searchText + "%' OR `employee`.`id` Like'%" + searchText + "%'");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (searchText.length() == 3) {
            employeeManagement("");

        }


    }//GEN-LAST:event_searchEmployeeKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        clearData();

    }//GEN-LAST:event_formMouseClicked

    private void employeeTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employeeTableFocusGained

        setDisable();
    }//GEN-LAST:event_employeeTableFocusGained

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Mobile;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel date;
    private javax.swing.JComboBox<String> depart;
    private javax.swing.JTable employeeTable;
    private javax.swing.JTextField firstName;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastName;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel regDate;
    private javax.swing.JTextField searchEmployee;
    // End of variables declaration//GEN-END:variables
}
