package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.BasicStroke;
import org.jfree.chart.plot.CategoryPlot;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import model.MySQL;
import javax.swing.SwingUtilities;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Salary_Charts extends javax.swing.JFrame {

    public Salary_Charts() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setPreferredSize(new java.awt.Dimension(841, 60));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(52, 73, 94));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton14.setContentAreaFilled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("DinaminaUniWeb", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TRANQUIL TERRACE | Overall Salary Chart");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setPreferredSize(new java.awt.Dimension(864, 50));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/stats.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/graph-curve.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2jButton3ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/chart-pie-alt.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(641, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        emp_salary salary_Charts = new emp_salary();
        salary_Charts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton6jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6jButton1ActionPerformed

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {

            ResultSet resultSet = MySQL.execute("SELECT `employee`.`first_name`, `employee`.`last_name`, DATE_FORMAT(`salary`.`from_date`, '%Y-%m') AS month, SUM(`salary`.`salary`) AS `monthly_salary` FROM `salary` "
                    + "INNER JOIN `employee` ON `salary`.`employee_id` = `employee`.`id` GROUP BY `employee`.`id`, month");

            while (resultSet.next()) {
                double monthlySalary = resultSet.getDouble("monthly_salary");
                String month = resultSet.getString("month");

                dataset.setValue(monthlySalary, "Salary", month);

            }

            JFreeChart chart1 = ChartFactory.createBarChart("Employee Salary", "Month", "Salary", dataset);
            chart1.setBackgroundPaint(new Color(255, 255, 255));
            chart1.getCategoryPlot().setBackgroundPaint(new Color(0, 0, 0, 0));

            BarRenderer barRenderer = (BarRenderer) chart1.getCategoryPlot().getRenderer();

            barRenderer.setSeriesPaint(0, Color.decode("#F54768"));

            ChartPanel chartPanel = new ChartPanel(chart1);

            jPanel1.removeAll();
            jPanel1.add(chartPanel, BorderLayout.CENTER);
            jPanel1.revalidate();
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
           
            ResultSet resultSet = MySQL.execute("SELECT employee_type.type, AVG(salary.salary) AS average_salary "
                    + "FROM employee "
                    + "JOIN employee_type ON employee.employee_type_id = employee_type.id "
                    + "JOIN salary ON employee.id = salary.employee_id "
                    + "GROUP BY employee_type.type");

           
            while (resultSet.next()) {
                String employeeType = resultSet.getString("type");
                double averageSalary = resultSet.getDouble("average_salary");

                dataset.setValue(employeeType, averageSalary);
            }

         
            JFreeChart pieChart = ChartFactory.createPieChart("Average Salary by Employee Type", dataset, true, true, false);
            pieChart.setBackgroundPaint(new Color(255, 255, 255));
            PiePlot piePlot = (PiePlot) pieChart.getPlot();
            piePlot.setBackgroundPaint(new Color(255, 255, 255)); 

            for (Object keyObj : dataset.getKeys()) {
                Comparable<?> key = (Comparable<?>) keyObj;
                switch (key.toString()) {
                    case "Administrator":
                        piePlot.setSectionPaint(key, Color.decode("#F54768"));
                        break;
                    case "Receptionist":
                        piePlot.setSectionPaint(key, Color.decode("#FDD037"));
                        break;
                    case "HR":
                        piePlot.setSectionPaint(key, Color.decode("#34495E")); 
                        break;
                    case "Kitchen Operator":
                        piePlot.setSectionPaint(key, Color.decode("#36B64F"));
                        break;
                    default:
                        piePlot.setSectionPaint(key, Color.decode("#7F7F7F"));
                        break;
                }
            }
            piePlot.setLabelFont(new Font("DinaminaUniWeb ", Font.PLAIN, 14)); 
            piePlot.setLabelBackgroundPaint(new Color(255, 255, 255, 255));
            piePlot.setLabelOutlinePaint(null);
            ChartPanel pieChartPanel = new ChartPanel(pieChart);

            jPanel1.removeAll(); 
            
            jPanel1.add(pieChartPanel, BorderLayout.CENTER);
            jPanel1.revalidate(); 
            jPanel1.repaint();
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {

            ResultSet resultSet = MySQL.execute("SELECT `employee`.`first_name`, `employee`.`last_name`, DATE_FORMAT(`salary`.`from_date`, '%Y-%m') AS month, SUM(`salary`.`salary`) AS `monthly_salary` FROM `salary` "
                    + "INNER JOIN `employee` ON `salary`.`employee_id` = `employee`.`id` GROUP BY `employee`.`id`, month");

            while (resultSet.next()) {
                double monthlySalary = resultSet.getDouble("monthly_salary");
                String month = resultSet.getString("month");

                dataset.setValue(monthlySalary, "Salary", month);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JFreeChart lineChart = ChartFactory.createLineChart("Employee Salary", "Month", "Salary", dataset);

        lineChart.setBackgroundPaint(new Color(255, 255, 255));
        CategoryPlot linePlot = lineChart.getCategoryPlot();
        linePlot.setBackgroundPaint(new Color(0, 0, 0, 0));

        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) linePlot.getRenderer();
        lineRenderer.setSeriesPaint(0, Color.decode("#F54768"));
        lineRenderer.setSeriesStroke(0, new BasicStroke(3.0f));
        ChartPanel lineChartPanel = new ChartPanel(lineChart);

        jPanel1.removeAll();
        jPanel1.add(lineChartPanel, BorderLayout.CENTER);
        jPanel1.revalidate();
        SwingUtilities.updateComponentTreeUI(this);
    }                                                

    private void jButton8jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8jButton2ActionPerformed
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {

            ResultSet resultSet = MySQL.execute("SELECT employee_type.type, AVG(salary.salary) AS average_salary "
                    + "FROM employee "
                    + "JOIN employee_type ON employee.employee_type_id = employee_type.id "
                    + "JOIN salary ON employee.id = salary.employee_id "
                    + "GROUP BY employee_type.type");

            while (resultSet.next()) {
                String employeeType = resultSet.getString("type");
                double averageSalary = resultSet.getDouble("average_salary");

                dataset.setValue(employeeType, averageSalary);
            }

            JFreeChart pieChart = ChartFactory.createPieChart("Average Salary by Employee Type", dataset, true, true, false);
            pieChart.setBackgroundPaint(new Color(255, 255, 255));
            PiePlot piePlot = (PiePlot) pieChart.getPlot();
            piePlot.setBackgroundPaint(new Color(255, 255, 255));

            for (Object keyObj : dataset.getKeys()) {
                Comparable<?> key = (Comparable<?>) keyObj;
                switch (key.toString()) {
                    case "Administrator":
                        piePlot.setSectionPaint(key, Color.decode("#46494B"));
                        break;
                    case "Receptionist":
                        piePlot.setSectionPaint(key, Color.decode("#FDD037"));
                        break;
                    case "HR":
                        piePlot.setSectionPaint(key, Color.decode("#12ADC1"));
                        break;
                    case "Kitchen Operator":
                        piePlot.setSectionPaint(key, Color.decode("#36B64F"));
                        break;
                    default:
                        piePlot.setSectionPaint(key, Color.decode("#F54768"));
                        break;
                }
            }
            piePlot.setLabelFont(new Font("DinaminaUniWeb ", Font.PLAIN, 14));
            piePlot.setLabelBackgroundPaint(new Color(0, 0, 0, 0));
            piePlot.setLabelOutlinePaint(null);
            ChartPanel pieChartPanel = new ChartPanel(pieChart);

            jPanel1.removeAll();
            jPanel1.add(pieChartPanel, BorderLayout.CENTER);
            jPanel1.revalidate();
            jPanel1.repaint();
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salary_Charts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
