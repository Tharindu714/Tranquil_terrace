
package foodPanel;

import GUI.Dashboard;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.MySQL;

public class Chicken extends javax.swing.JPanel {

   String searchQuery = ("SELECT `id` FROM `kot` ORDER BY `id` DESC");
    String commonQuery = ("SELECT `name`,`price` FROM `food_item` ");
    
    public Chicken() {
        initComponents();
        pepper_chicken();
        chicken_steak();
        roasted_chicken();
    }

   private void pepper_chicken() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='27'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel2.setText(foodname + " | " + foodprice);
            }
        } catch (SQLException e) {
            Dashboard.log.warning(e.toString());
        }
    }

    private void chicken_steak() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='28'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel3.setText(foodname + " | " + foodprice);
            }
        } catch (SQLException e) {
            Dashboard.log.warning(e.toString());
        }
    }

    private void roasted_chicken() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='29'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel1.setText(foodname + " | " + foodprice);
            }
        } catch (SQLException e) {
            Dashboard.log.warning(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jImagePanel3 = new main.JImagePanel();
        jLabel2 = new javax.swing.JLabel();
        jImagePanel4 = new main.JImagePanel();
        jLabel3 = new javax.swing.JLabel();
        jImagePanel2 = new main.JImagePanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jImagePanel3.setCenterImage(true);
        jImagePanel3.setFitToPanel(true);
        jImagePanel3.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/Pepper Chicken .jpeg"))); // NOI18N
        jImagePanel3.setSmoothRendering(true);
        jImagePanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel3MouseClicked(evt);
            }
        });
        jImagePanel3.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(52, 73, 94));
        jLabel2.setFont(new java.awt.Font("DinaminaUniWeb", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pepper Chicken");
        jLabel2.setOpaque(true);
        jLabel2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel2PropertyChange(evt);
            }
        });
        jImagePanel3.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel3);

        jImagePanel4.setCenterImage(true);
        jImagePanel4.setFitToPanel(true);
        jImagePanel4.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/chicken_steak.jpeg"))); // NOI18N
        jImagePanel4.setSmoothRendering(true);
        jImagePanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel4MouseClicked(evt);
            }
        });
        jImagePanel4.setLayout(new java.awt.BorderLayout());

        jLabel3.setBackground(new java.awt.Color(52, 73, 94));
        jLabel3.setFont(new java.awt.Font("DinaminaUniWeb", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Chicken Steak");
        jLabel3.setOpaque(true);
        jImagePanel4.add(jLabel3, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel4);

        jImagePanel2.setCenterImage(true);
        jImagePanel2.setFitToPanel(true);
        jImagePanel2.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/roasted_chicken.jpeg"))); // NOI18N
        jImagePanel2.setSmoothRendering(true);
        jImagePanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel2MouseClicked(evt);
            }
        });
        jImagePanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(52, 73, 94));
        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Roasted Chicken");
        jLabel1.setOpaque(true);
        jImagePanel2.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void jImagePanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jImagePanel3MouseClicked
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
                        + "VALUES('" + nextID + "','27','1')");

                JOptionPane.showMessageDialog(this, "Pepper Chicken Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel3MouseClicked

    private void jImagePanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jImagePanel4MouseClicked
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
                        + "VALUES('" + nextID + "','28','1')");

                JOptionPane.showMessageDialog(this, "Chicken Steak Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel4MouseClicked

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
                        + "VALUES('" + nextID + "','29','1')");

                JOptionPane.showMessageDialog(this, "Roasted Chicken Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel2MouseClicked

    private void jLabel2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.JImagePanel jImagePanel2;
    private main.JImagePanel jImagePanel3;
    private main.JImagePanel jImagePanel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
