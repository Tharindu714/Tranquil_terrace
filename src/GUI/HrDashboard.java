/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import javax.swing.JFrame;

/**
 *
 * @author DS
 */
public class HrDashboard extends javax.swing.JFrame {

    /**
     * Creates new form HrDashboard
     */
    public HrDashboard() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel2.setLayout(new java.awt.GridLayout());

        jPanel5.setBackground(new java.awt.Color(52, 73, 94));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Human Resource Management");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(300, 645));
        jPanel3.setLayout(new java.awt.GridLayout(7, 1));

        jButton1.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jButton1.setText("Dashboard");
        jPanel3.add(jButton1);

        jButton2.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jButton2.setText("Employees");
        jPanel3.add(jButton2);

        jButton3.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jButton3.setText("Work schedule ");
        jPanel3.add(jButton3);

        jButton4.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jButton4.setText("Stock Management");
        jPanel3.add(jButton4);

        jButton5.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jButton5.setText("Rooms");
        jPanel3.add(jButton5);

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(jPanel1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
