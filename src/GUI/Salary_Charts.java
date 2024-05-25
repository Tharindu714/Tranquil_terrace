package GUI;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.IntelliJTheme;
import java.awt.BasicStroke;
import org.jfree.chart.plot.CategoryPlot;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.MySQL;
import javax.swing.JOptionPane;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 50));

        jButton1.setText("Bar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Line");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle-xmark.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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

            chart1.getCategoryPlot().setBackgroundPaint(new Color(255, 255, 255));

            BarRenderer barRenderer = (BarRenderer) chart1.getCategoryPlot().getRenderer();
           
            barRenderer.setSeriesPaint(0, Color.decode("#3C3F41"));

            ChartPanel chartPanel = new ChartPanel(chart1);
          

            jPanel1.removeAll(); 
            jPanel1.add(chartPanel, BorderLayout.CENTER);
            jPanel1.revalidate(); 
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
        linePlot.setBackgroundPaint(new Color(255, 255, 255));

        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) linePlot.getRenderer();
        lineRenderer.setSeriesPaint(0, Color.decode("#34495E"));
        lineRenderer.setSeriesStroke(0, new BasicStroke(3.0f));
        ChartPanel lineChartPanel = new ChartPanel(lineChart);
        

        jPanel1.removeAll(); 
        jPanel1.add(lineChartPanel, BorderLayout.CENTER);
        jPanel1.revalidate();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
