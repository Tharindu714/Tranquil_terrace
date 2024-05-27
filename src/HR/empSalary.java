package HR;

import com.formdev.flatlaf.IntelliJTheme;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import GUI.Dashboard;

import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class empSalary extends javax.swing.JFrame {

    HashMap<String, String> empMap = new HashMap<>();

    private double salary = 0;
    private double advance = 0;
    private double due = 0;
    private double payment = 0;

    public empSalary() {
        initComponents();
        loadSalary("SELECT * FROM `salary_advance`"
                + "INNER JOIN `salary` ON `salary_advance`.`salary_id` = `salary`.id "
                + "INNER JOIN `employee` ON `salary`.`employee_id` = `employee`.id "
                + "INNER JOIN `employee_type` ON `employee`.`employee_type_id` = `employee_type`.id WHERE `employee_type_id`!='1' AND `employee_type_id`!='4'  ORDER BY `salary_advance`.`id` ASC");
        loadEmp();
        setExtendedState(MAXIMIZED_BOTH);
        genarateNextID();
        jTextField1.setEnabled(false);
        jFormattedTextField4.setEnabled(false);
        jButton3.setEnabled(false);
        dateChooser1.setEnabled(false);
    }

    private void generateSalary() {
        try {
            HashMap<String, Object> parameter = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

           

            parameter.put("username", jComboBox1.getSelectedItem());
            parameter.put("Designation", "Human Resource Officer");
            parameter.put("from_date", dateChooser1);
            parameter.put("to_date", dateChooser2);

            parameter.put("salary", jFormattedTextField1.getText());
            parameter.put("advance", jFormattedTextField2.getText());
            parameter.put("salary_due", jFormattedTextField3.getText());

            String reportPath = "src//reports//salarySheet.jasper";
            JRDataSource dataSource = new JREmptyDataSource();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameter, dataSource);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateAdvance() {
        try {
            HashMap<String, Object> parameter = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            String formattedStartDate = sdf.format(dateChooser3);

            parameter.put("username", jComboBox1.getSelectedItem());
            parameter.put("Designation", "Human Resource Officer");
            parameter.put("from_date", formattedStartDate);
            parameter.put("Redeemed_price", jFormattedTextField2.getText());

            String reportPath = "src//reports//salaryadvanceSheet.jasper";
            JRDataSource dataSource = new JREmptyDataSource();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameter, dataSource);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void salaryReport() {
        if (JOptionPane.showConfirmDialog(this, "Do you need to Print Salary History Report?", "Confirm Alert",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                HashMap<String, Object> map = new HashMap<>();

                String reportPath = "src//reports//salaryhistorySheet.jasper";

                JRDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
                JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, map, dataSource);
                JasperViewer.viewReport(jasperPrint, false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            commons();
            jButton3.setEnabled(false);
        }
    }

    private void calculate() {
//Settings begin part
        if (jFormattedTextField2.getText().isEmpty()) {
            advance = 0;
        } else {
            advance = Double.parseDouble(jFormattedTextField2.getText());
        }
        salary = Double.parseDouble(jFormattedTextField1.getText());

//Settings ending part
        payment = salary;
        due = salary - advance;
        jFormattedTextField3.setText(String.valueOf(due));
    }

    private void genarateNextID() {
        try {
            ResultSet resultset = MySQL.execute("SELECT `id` FROM `salary` ORDER BY `id` DESC");
            if (resultset.next()) {
                int id = resultset.getInt("id");
                int nextID = id + 1;
                jTextField1.setText(String.valueOf(nextID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadSalary(String query) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("employee.username"));
                v.add(resultSet.getString("salary.from_date"));
                v.add(resultSet.getString("salary.to_date"));
                v.add(resultSet.getString("salary.id"));
                v.add(resultSet.getString("salary.salary"));
                v.add(resultSet.getString("salary.salary_due"));
                v.add(resultSet.getString("advance"));
                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadEmp() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT `username`,`id` FROM `employee` WHERE `employee_type_id`!='4'  AND `employee_type_id`!='1'");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("username"));
                empMap.put(resultSet.getString("username"), resultSet.getString("id"));
            }

            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(v);
            jComboBox1.setModel(comboBoxModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void oneClick() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String username = jTable1.getValueAt(selectedRow, 1).toString();
            jComboBox1.setSelectedItem(username);
            jComboBox1.setEnabled(false);

            dateChooser1.setEnabled(false);
            dateChooser2.setEnabled(false);
            dateChooser3.setEnabled(true);

            String id = jTable1.getValueAt(selectedRow, 4).toString();
            jTextField1.setText(id);

            String salary = jTable1.getValueAt(selectedRow, 5).toString();
            jFormattedTextField1.setText(salary);
            jFormattedTextField1.setEnabled(false);

            String due = jTable1.getValueAt(selectedRow, 6).toString();
            jFormattedTextField3.setText(due);

            jFormattedTextField2.setText("0");

            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(true);
            SetRedeemedAdvance();
        }
    }

    private void reset() {
        jComboBox1.setEnabled(true);
        dateChooser1.setEnabled(true);
        dateChooser2.setEnabled(true);
        dateChooser3.setEnabled(false);
        jFormattedTextField1.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        jComboBox1.setSelectedItem(0);
        jFormattedTextField1.setText("0");
        jFormattedTextField2.setText("0");
        jFormattedTextField3.setText("0");
        jFormattedTextField4.setText("0");
        jTable1.clearSelection();
    }

    private void SetRedeemedAdvance() {
        double salary = Double.parseDouble(jFormattedTextField1.getText());
        double due = Double.parseDouble(jFormattedTextField3.getText());
        double redeem = salary - due;
        jFormattedTextField4.setText(String.valueOf(redeem));
    }

    private void commons() {
        loadSalary("SELECT * FROM `salary_advance`"
                + "INNER JOIN `salary` ON `salary_advance`.`salary_id` = `salary`.id "
                + "INNER JOIN `employee` ON `salary`.`employee_id` = `employee`.id "
                + "INNER JOIN `employee_type` ON `employee`.`employee_type_id` = `employee_type`.id WHERE `employee_type_id`!='1' AND `employee_type_id`!='4' ORDER BY `salary_advance`.`id` ASC");
        loadEmp();
        reset();
        genarateNextID();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        Date1 = new javax.swing.JTextField();
        Date2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        dateChooser1.setForeground(new java.awt.Color(0, 51, 102));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(Date);

        dateChooser2.setForeground(new java.awt.Color(0, 51, 102));
        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(Date1);

        dateChooser3.setForeground(new java.awt.Color(0, 51, 102));
        dateChooser3.setDateFormat("yyyy-MM-dd");
        dateChooser3.setTextRefernce(Date2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setPreferredSize(new java.awt.Dimension(225, 500));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Employee ");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Work Schedule Start Date");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Work Schedule End Date");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Salary");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Salary Advance");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField1.setText("0");

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.setText("0");
        jFormattedTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField2MouseClicked(evt);
            }
        });
        jFormattedTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Salary Due");

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField3.setText("0");

        jButton1.setBackground(new java.awt.Color(245, 71, 104));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/user-salary.png"))); // NOI18N
        jButton1.setText("    Salary Sheet");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(52, 73, 94));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/emp-salary.png"))); // NOI18N
        jButton2.setText(" Salary Reports");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Salary_ID");

        jTextField1.setText("1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Total Advance Redeemed");

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField4.setText("0");

        jButton3.setBackground(new java.awt.Color(52, 73, 94));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Salary Issued Date");

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

        Date1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        Date1.setForeground(java.awt.Color.white);

        Date2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        Date2.setForeground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jFormattedTextField1)
                                .addComponent(jFormattedTextField3)
                                .addComponent(jFormattedTextField4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Date2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Date1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(8, 8, 8))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 50));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

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
        jLabel1.setText("TRANQUIL TERRACE | Employee Salary Management");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(jButton6)
                .addContainerGap())
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

        jPanel3.add(jPanel4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setAlignmentX(RIGHT_ALIGNMENT);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Start Date", "End Date", "Salary ID", "Monthly Salary", "Salary Due", "Redeemed advance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(245, 71, 104));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
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

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jFormattedTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyReleased
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
        } else {
            calculate();
        }
    }//GEN-LAST:event_jFormattedTextField2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = jComboBox1.getSelectedItem().toString();
        String id = jTextField1.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

       

        String salary = jFormattedTextField1.getText();
        String advance = jFormattedTextField2.getText();
        String due = jFormattedTextField3.getText();

        if (username.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please Select the Employee Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (dateChooser1 == null) {
            JOptionPane.showMessageDialog(this, "Please Enter the start date of Work schedule", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (dateChooser2 == null) {
            JOptionPane.showMessageDialog(this, "Please Enter the final date of Work schedule", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Monthly Salary", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (advance.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Salary advance", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (due.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Salary Due", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            calculate();
            try {
                MySQL.execute("INSERT INTO "
                        + "`salary`(`salary`,`employee_id`,`from_date`,`to_date`,`salary_due`)"
                        + "VALUES('" + salary + "','" + empMap.get(username) + "','" + dateChooser1 + "','" + dateChooser2 + "','" + due + "')");

                MySQL.execute("INSERT INTO "
                        + "`salary_advance`(`advance`,`salary_id`)"
                        + "VALUES('" + advance + "','" + id + "')");

                JOptionPane.showMessageDialog(this, "Salary Added Successfully", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.showConfirmDialog(this, "Do you Want to Print Salary Sheet? ", "Confirmation Alert !",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    generateSalary();
                    commons();
                } else {
                    JOptionPane.showMessageDialog(this, "Salary sheet Print Cancelled", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                    commons();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 1) {
            oneClick();
        } else if (evt.getClickCount() == 2) {
            commons();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salaryReport();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField2MouseClicked

    }//GEN-LAST:event_jFormattedTextField2MouseClicked

    private void jFormattedTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyTyped

    }//GEN-LAST:event_jFormattedTextField2KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double due = Double.parseDouble(jFormattedTextField3.getText());
        double advance = Double.parseDouble(jFormattedTextField2.getText());
        String salary_id = jTextField1.getText();
        double advancing = due - advance;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String issuedjDate = sdf.format(dateChooser3);

        if (issuedjDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select the issued date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            double latest_advance = Double.parseDouble(jFormattedTextField4.getText());
           double advanceUpdate = latest_advance + advance;

            try {
                MySQL.execute("UPDATE `salary` SET "
                        + "`salary_due` = '" + advancing + "' WHERE `id` = '" + salary_id + "'");

                MySQL.execute("INSERT INTO "
                        + "`salary_advance`(`advance`,`salary_id`)"
                        + "VALUES('" + advanceUpdate + "','" + salary_id + "')");

                JOptionPane.showMessageDialog(this, "Salary Advance Updated Successfully", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.showConfirmDialog(this, "Do you Want to Print Salary Advance Sheet? ", "Confirmation Alert !",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    generateAdvance();
                    commons();
                    jButton3.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Salary Advance sheet Print Cancelled", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                    commons();
                    jButton3.setEnabled(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DateMouseClicked

    private void DateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateMouseReleased

    }//GEN-LAST:event_DateMouseReleased

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateActionPerformed

    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class
                .getResourceAsStream("/themes/Atom_One_DarkContrast.theme.json"));

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new empSalary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Date;
    private javax.swing.JTextField Date1;
    private javax.swing.JTextField Date2;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
