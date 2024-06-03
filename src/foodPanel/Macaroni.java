/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package foodPanel;

/**
 *
 * @author Tharindu
 */
public class Macaroni extends javax.swing.JPanel {

    /**
     * Creates new form Macaroni
     */
    public Macaroni() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jImagePanel1 = new main.JImagePanel();
        jLabel1 = new javax.swing.JLabel();
        jImagePanel4 = new main.JImagePanel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jImagePanel1.setCenterImage(true);
        jImagePanel1.setFitToPanel(true);
        jImagePanel1.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/cheese_macaroni.jpeg"))); // NOI18N
        jImagePanel1.setSmoothRendering(true);
        jImagePanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(52, 73, 94));
        jLabel1.setFont(new java.awt.Font("DinaminaUniWeb", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cheese Macaroni");
        jLabel1.setOpaque(true);
        jImagePanel1.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel1);

        jImagePanel4.setCenterImage(true);
        jImagePanel4.setFitToPanel(true);
        jImagePanel4.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/food_img/prawn_cheese_macaroni.jpeg"))); // NOI18N
        jImagePanel4.setSmoothRendering(true);
        jImagePanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(52, 73, 94));
        jLabel2.setFont(new java.awt.Font("DinaminaUniWeb", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Prawn Cheese Macaroni");
        jLabel2.setOpaque(true);
        jImagePanel4.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        add(jImagePanel4);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private main.JImagePanel jImagePanel1;
    private main.JImagePanel jImagePanel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
