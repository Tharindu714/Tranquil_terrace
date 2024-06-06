/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HR;

import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.ui.FlatLabelUI;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.MySQL;
import model.Validation;
import GUI.Dashboard;

public class HrSignIn extends javax.swing.JFrame {

    Validation valid = new Validation();


    public HrSignIn() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        userName = new javax.swing.JTextField();
        userPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UserSignIn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/user(1).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/lock(1).png"))); // NOI18N
        jButton2.setContentAreaFilled(false);

        userName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        userName.setText("Username");
        userName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFocusLost(evt);
            }
        });
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNameKeyReleased(evt);
            }
        });

        userPassword.setFont(new java.awt.Font("Engravers MT", 0, 17)); // NOI18N
        userPassword.setText("UserPassword");
        userPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userPasswordFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel2.setText("Human Resource Management");

        jLabel3.setText("Tranquil Terrace Ella | Hotel Management System 2024");

        UserSignIn.setBackground(new java.awt.Color(245, 71, 104));
        UserSignIn.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        UserSignIn.setForeground(new java.awt.Color(255, 255, 255));
        UserSignIn.setText("  Sign In");
        UserSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserSignInActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo80px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userName)
                        .addComponent(userPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                        .addComponent(UserSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userName)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPassword))
                .addGap(18, 18, 18)
                .addComponent(UserSignIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Experince Comfort, Embrace Tranquility");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void userNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFocusGained

        if (userName.getText().equals("Username")) {
            userName.setText("");
        }
    }//GEN-LAST:event_userNameFocusGained

    private void userNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFocusLost

        if (userName.getText().equals("")) {
            userName.setText("Username");
        }

    }//GEN-LAST:event_userNameFocusLost

    private void userPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPasswordFocusGained

        if (String.valueOf(userPassword.getPassword()).equals("UserPassword")) {
            userPassword.setText("");
        }
    }//GEN-LAST:event_userPasswordFocusGained

    private void userPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPasswordFocusLost
        if (String.valueOf(userPassword.getPassword()).equals("")) {
            userPassword.setText("UserPassword");
        }
    }//GEN-LAST:event_userPasswordFocusLost

    private String percentage(String userId) {

        try {

            String date = new SimpleDateFormat("yyyy-MM").format(new Date());

            ResultSet workSchedule = MySQL.execute("SELECT COUNT(*) FROM `work_schedule` WHERE `status_id`='1' AND `employee_id`='" + userId + "' AND `date` LIKE '" + date + "%'");
            ResultSet Attendance = MySQL.execute("SELECT COUNT(*) FROM `staff_attendence` WHERE  `employee_id`='" + userId + "' AND `date` LIKE '" + date + "%'");

            workSchedule.next();
            Attendance.next();

            if (Attendance.getInt("COUNT(*)") != 0 && workSchedule.getInt("COUNT(*)") != 0) {
                double percentage = (Attendance.getDouble("COUNT(*)") / workSchedule.getDouble("COUNT(*)")) * 100;

                return percentage + "%";
            }

            return "0%";

        } catch (Exception e) {
                   Dashboard.log.warning(e.toString());

            return null;
        }

    }

    private void UserSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserSignInActionPerformed

        String user = userName.getText();
        String password = String.valueOf(userPassword.getPassword());

        if (valid.emptyValue(userName, "Username")) {

            JOptionPane.showMessageDialog(this, "Please Enter User Name", "warning", JOptionPane.WARNING_MESSAGE);

        } else if (valid.emptyValue(userPassword, "UserPassword")) {

            JOptionPane.showMessageDialog(this, "Please Enter Password", "warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                

                ResultSet rs = MySQL.execute("SELECT * FROM `employee` "
                        + "WHERE `userName`='" + user + "' AND `password`='" + password + "' ");

                if (rs.next()) {

                    if (rs.getString("employee_type_id").equals("4")) {

                        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                        MySQL.execute("UPDATE `employee` "
                                + "SET `loggedtime`='" + datetime + "'"
                                + "WHERE `username`='" + user + "'");

                        JOptionPane.showMessageDialog(this, "Login Successfully", "SUCCESSFULLY LOGIN", JOptionPane.INFORMATION_MESSAGE);

                        String mobile = rs.getString("mobile");
                        String fUll = rs.getString("first_name") +" "+ rs.getString("last_name");
                        String reg = rs.getString("registered_date");
                        String percent = percentage(rs.getString("employee.id"));

                        HrMain hrHome = new HrMain(fUll,mobile,reg,datetime,percent);
                        hrHome.setVisible(true);
                        this.dispose();

                    } else {

                        JOptionPane.showMessageDialog(this, "Access Denid from This Department", "Warning", JOptionPane.WARNING_MESSAGE);

                    }

                } else {

                    JOptionPane.showMessageDialog(this, "Invalid Login Details", "warning", JOptionPane.WARNING_MESSAGE);

                }

            } catch (Exception e) {
                            Dashboard.log.warning(e.toString());

            }
        }


    }//GEN-LAST:event_UserSignInActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void userNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyReleased


    }//GEN-LAST:event_userNameKeyReleased

    private void userNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrSignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UserSignIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField userName;
    private javax.swing.JPasswordField userPassword;
    // End of variables declaration//GEN-END:variables
}
