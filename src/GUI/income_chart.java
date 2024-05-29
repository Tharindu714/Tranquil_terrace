package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.BasicStroke;
import org.jfree.chart.plot.CategoryPlot;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JFrame;
import model.MySQL;
import javax.swing.SwingUtilities;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


public class income_chart extends javax.swing.JFrame {

    String query = ("SELECT DATE_FORMAT(`customer_visit_hotel`.`check_out`, '%m-%d') \n"
            + "AS `Date`, SUM(`customer_visit_hotel`.`total`) \n"
            + "AS  `Daily Income`  FROM `customer_visit_hotel`\n"
            + "INNER JOIN `customer` ON `customer_visit_hotel`.`customer_nic/passport` = `customer`.`nic/passport`\n"
            + "GROUP BY `Date`;");

    public income_chart() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 60));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(52, 73, 94));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 30));

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
        jLabel8.setText("TRANQUIL TERRACE | Overall Income Chart");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 50));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/stats.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6jButton1ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LightIcons/graph-curve.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setPreferredSize(new java.awt.Dimension(35, 35));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(604, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Check_inv_list inv_chart = new Check_inv_list();
        inv_chart.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton6jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6jButton1ActionPerformed

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            ResultSet resultSet = MySQL.execute(query);
            while (resultSet.next()) {
                double DailyIncome = resultSet.getDouble("Daily Income");
                String date = resultSet.getString("Date");

                dataset.setValue(DailyIncome, "customer_visit_hotel", date);
            }

            JFreeChart chart1 = ChartFactory.createBarChart("Daily Hotel Income", "Date", "Daily Income", dataset);
            chart1.setBackgroundPaint(new Color(255, 255, 255));
            chart1.getCategoryPlot().setBackgroundPaint(new Color(0, 0, 0, 0));
            BarRenderer barRenderer = (BarRenderer) chart1.getCategoryPlot().getRenderer();
            barRenderer.setSeriesPaint(0, Color.decode("#F54768"));
            ChartPanel chartPanel = new ChartPanel(chart1);

            jPanel3.removeAll();
            jPanel3.add(chartPanel, BorderLayout.CENTER);
            jPanel3.revalidate();
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
                       Dashboard.log.warning(e.toString());

        }
    }//GEN-LAST:event_jButton6jButton1ActionPerformed

    private void jButton7jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7jButton3ActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {

            ResultSet resultSet = MySQL.execute("SELECT DATE_FORMAT(`customer_visit_hotel`.`check_out`, '%m-%d') \n"
                    + "AS `Date`, SUM(`customer_visit_hotel`.`total`) \n"
                    + "AS  `Daily Income`  FROM `customer_visit_hotel`\n"
                    + "INNER JOIN `customer` ON `customer_visit_hotel`.`customer_nic/passport` = `customer`.`nic/passport`\n"
                    + "GROUP BY `Date`;");

            while (resultSet.next()) {
                double DailyIncome = resultSet.getDouble("Daily Income");
                String date = resultSet.getString("Date");

                dataset.setValue(DailyIncome, "customer_visit_hotel", date);

            }

        } catch (Exception e) {
                       Dashboard.log.warning(e.toString());

        }

        JFreeChart lineChart = ChartFactory.createLineChart("Daily Hotel Income", "Date", "Daily Income", dataset);

        lineChart.setBackgroundPaint(new Color(255, 255, 255));
        CategoryPlot linePlot = lineChart.getCategoryPlot();
        linePlot.setBackgroundPaint(new Color(0, 0, 0, 0));

        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) linePlot.getRenderer();
        lineRenderer.setSeriesPaint(0, Color.decode("#F54768"));
        lineRenderer.setSeriesStroke(0, new BasicStroke(3.0f));
        ChartPanel lineChartPanel = new ChartPanel(lineChart);

        jPanel3.removeAll();
        jPanel3.add(lineChartPanel, BorderLayout.CENTER);
        jPanel3.revalidate();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jButton7jButton3ActionPerformed

    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new income_chart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
