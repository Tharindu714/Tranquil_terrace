package GUI;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Splash extends javax.swing.JFrame {

    public Splash() {
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
                try {
          ;
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/T2.png"));
            this.setIconImage(imageIcon.getImage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Image loading error");
        }
        Thread th = new Thread(
                () -> {
                    for (int i = 0; i <= 100; i++) {
                        jProgressBar1.setValue(i);
                        try {
                            Thread.sleep(25);
                        } catch (Exception e) {
                                        Dashboard.log.warning(e.toString());

                        }
                    }
                    FirstDashboard d = new FirstDashboard();
                    d.setVisible(true);
                    this.dispose();
                }
        );
        th.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setEnabled(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar1.setForeground(new java.awt.Color(245, 71, 104));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 410, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/WELCOME !.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IntelliJTheme.setup(Dashboard.class.getResourceAsStream(
                "/themes/Atom_One_DarkContrast.theme.json"));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
