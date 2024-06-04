
package foodPanel;

import GUI.Dashboard;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.MySQL;


public class dessert extends javax.swing.JPanel {

    String searchQuery = ("SELECT `id` FROM `kot` ORDER BY `id` DESC");
    String commonQuery = ("SELECT `name`,`price` FROM `food_item` ");

    public dessert() {
        initComponents();
        watalappan();
        ice_cream();
    }

    private void watalappan() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='36'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel1.setText(foodname + " | " + foodprice);
            }
        } catch (SQLException e) {
            Dashboard.log.warning(e.toString());
        }
    }

    private void ice_cream() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='37'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel2.setText(foodname + " | " + foodprice);
            }
        } catch (SQLException e) {
            Dashboard.log.warning(e.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jImagePanel1 = new main.JImagePanel();
        jLabel1 = new javax.swing.JLabel();
        jImagePanel2 = new main.JImagePanel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jImagePanel1.setCenterImage(true);
        jImagePanel1.setFitToPanel(true);
        jImagePanel1.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/watalappan.jpg"))); // NOI18N
        jImagePanel1.setSmoothRendering(true);
        jImagePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel1MouseClicked(evt);
            }
        });
        jImagePanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(52, 73, 94));
        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Watalappan");
        jLabel1.setOpaque(true);
        jImagePanel1.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel1);

        jImagePanel2.setCenterImage(true);
        jImagePanel2.setFitToPanel(true);
        jImagePanel2.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/icecream.jpeg"))); // NOI18N
        jImagePanel2.setSmoothRendering(true);
        jImagePanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel2MouseClicked(evt);
            }
        });
        jImagePanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(52, 73, 94));
        jLabel2.setFont(new java.awt.Font("DinaminaUniWeb", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ice Cream");
        jLabel2.setOpaque(true);
        jImagePanel2.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void jImagePanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jImagePanel1MouseClicked
         String DateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            ResultSet resultset = MySQL.execute(searchQuery);
            if (resultset.next()) {
                int id = resultset.getInt("id");
                int nextID = id + 1;

                MySQL.execute("INSERT INTO "
                        + "`kot`(`id`,`req_time`,`kot_status_id`,`kot_customer_type_id`,`extra_item_added_id`)"
                        + "VALUES('" + nextID + "','" + DateTime + "','1','1','1')");

                MySQL.execute("INSERT INTO "
                        + "`kot_has_food`(`kot_id`,`food_item_id`,`qty`)"
                        + "VALUES('" + nextID + "','36','1')");

                JOptionPane.showMessageDialog(this, "Watalappan Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel1MouseClicked

    private void jImagePanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jImagePanel2MouseClicked
         String DateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            ResultSet resultset = MySQL.execute(searchQuery);
            if (resultset.next()) {
                int id = resultset.getInt("id");
                int nextID = id + 1;

                MySQL.execute("INSERT INTO "
                        + "`kot`(`id`,`req_time`,`kot_status_id`,`kot_customer_type_id`,`extra_item_added_id`)"
                        + "VALUES('" + nextID + "','" + DateTime + "','1','1','1')");

                MySQL.execute("INSERT INTO "
                        + "`kot_has_food`(`kot_id`,`food_item_id`,`qty`)"
                        + "VALUES('" + nextID + "','37','1')");

                JOptionPane.showMessageDialog(this, "Ice-cream Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.JImagePanel jImagePanel1;
    private main.JImagePanel jImagePanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
