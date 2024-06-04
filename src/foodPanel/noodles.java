package foodPanel;

import GUI.Dashboard;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.MySQL;

public class noodles extends javax.swing.JPanel {

    String searchQuery = ("SELECT `id` FROM `kot` ORDER BY `id` DESC");
    String commonQuery = ("SELECT `name`,`price` FROM `food_item` ");

    public noodles() {
        initComponents();
        egg_nood();
        chicken_nood();
        mix_nood();
    }

    private void egg_nood() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='16'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel1.setText(foodname + " | " + foodprice);
            }
        } catch (SQLException e) {
            Dashboard.log.warning(e.toString());
        }
    }

    private void chicken_nood() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='17'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel2.setText(foodname + " | " + foodprice);
            }
        } catch (SQLException e) {
            Dashboard.log.warning(e.toString());
        }
    }

    private void mix_nood() {
        try {
            ResultSet rs = MySQL.execute(commonQuery + " WHERE`id` ='18'");
            if (rs.next()) {
                String foodname = rs.getString("name");
                String foodprice = rs.getString("price");
                jLabel3.setText(foodname + " | " + foodprice);
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
        jImagePanel4 = new main.JImagePanel();
        jLabel2 = new javax.swing.JLabel();
        jImagePanel3 = new main.JImagePanel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jImagePanel1.setFitToPanel(true);
        jImagePanel1.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/egg_noodles.jpg"))); // NOI18N
        jImagePanel1.setSmoothRendering(true);
        jImagePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel1MouseClicked(evt);
            }
        });
        jImagePanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(52, 73, 94));
        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Egg Noodles");
        jLabel1.setOpaque(true);
        jImagePanel1.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel1);

        jImagePanel4.setFitToPanel(true);
        jImagePanel4.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/chicken_noodle.jpeg"))); // NOI18N
        jImagePanel4.setSmoothRendering(true);
        jImagePanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel4MouseClicked(evt);
            }
        });
        jImagePanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(52, 73, 94));
        jLabel2.setFont(new java.awt.Font("DinaminaUniWeb", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chicken Noodles");
        jLabel2.setOpaque(true);
        jImagePanel4.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel4);

        jImagePanel3.setFitToPanel(true);
        jImagePanel3.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/mixed_noodle.jpeg"))); // NOI18N
        jImagePanel3.setSmoothRendering(true);
        jImagePanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jImagePanel3MouseClicked(evt);
            }
        });
        jImagePanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setBackground(new java.awt.Color(52, 73, 94));
        jLabel3.setFont(new java.awt.Font("DinaminaUniWeb", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mixed Noodles");
        jLabel3.setOpaque(true);
        jImagePanel3.add(jLabel3, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel3);
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
                        + "VALUES('" + nextID + "','16','1')");

                JOptionPane.showMessageDialog(this, "Egg Noodles Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel1MouseClicked

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
                        + "VALUES('" + nextID + "','17','1')");

                JOptionPane.showMessageDialog(this, "Chicken Noodles Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel4MouseClicked

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
                        + "VALUES('" + nextID + "','18','1')");

                JOptionPane.showMessageDialog(this, "Mixed Noodles Added", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Dashboard.log.warning(e.toString());
        }
    }//GEN-LAST:event_jImagePanel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.JImagePanel jImagePanel1;
    private main.JImagePanel jImagePanel3;
    private main.JImagePanel jImagePanel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
