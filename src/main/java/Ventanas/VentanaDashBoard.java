/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

/**
 *
 * @author bran-
 */
public class VentanaDashBoard extends javax.swing.JFrame {

    /**
     * Creates new form VentanaDashBoard
     */
    public VentanaDashBoard() {
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

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        btnGestionClienteEntre = new javax.swing.JButton();
        btnControlAsistencia = new javax.swing.JButton();
        btnAdminPagos = new javax.swing.JButton();
        btnAsigEntre = new javax.swing.JButton();
        btnPlanesMembresia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DashBoard", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Shree Devanagari 714", 0, 18))); // NOI18N

        btnGestionClienteEntre.setText("Gestión de clientes y entrenadores");
        btnGestionClienteEntre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionClienteEntreActionPerformed(evt);
            }
        });

        btnControlAsistencia.setText("Control de Asistencia");
        btnControlAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlAsistenciaActionPerformed(evt);
            }
        });

        btnAdminPagos.setText("Administración de pagos");
        btnAdminPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminPagosActionPerformed(evt);
            }
        });

        btnAsigEntre.setText("Asig de Entrenadores");
        btnAsigEntre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsigEntreActionPerformed(evt);
            }
        });

        btnPlanesMembresia.setText("Planes Membresia");
        btnPlanesMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanesMembresiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAsigEntre, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(btnAdminPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnControlAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlanesMembresia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionClienteEntre, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGestionClienteEntre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPlanesMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnControlAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdminPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAsigEntre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionClienteEntreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionClienteEntreActionPerformed
        // TODO add your handling code here:
        VentanaRegistro gestionCliEntr = new VentanaRegistro();
        gestionCliEntr.setVisible(true);
        gestionCliEntr.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnGestionClienteEntreActionPerformed

    private void btnControlAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlAsistenciaActionPerformed
        VentanaControlDeAsistencia controlAsis = new VentanaControlDeAsistencia();
        controlAsis.setVisible(true);
        controlAsis.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnControlAsistenciaActionPerformed

    private void btnAdminPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminPagosActionPerformed
        VentanaAdminPagos adminPagos = new VentanaAdminPagos();
        adminPagos.setVisible(true);
        adminPagos.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAdminPagosActionPerformed

    private void btnAsigEntreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsigEntreActionPerformed
        VentanaGestionEntrenadores gestionEntre = new VentanaGestionEntrenadores();
        gestionEntre.setVisible(true);
        gestionEntre.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnAsigEntreActionPerformed

    private void btnPlanesMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanesMembresiaActionPerformed
       VentanaPlanesMembresia mem = new VentanaPlanesMembresia();
       mem.setVisible(true);
       mem.setLocationRelativeTo(null);
       this.dispose();
    }//GEN-LAST:event_btnPlanesMembresiaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminPagos;
    private javax.swing.JButton btnAsigEntre;
    private javax.swing.JButton btnControlAsistencia;
    private javax.swing.JButton btnGestionClienteEntre;
    private javax.swing.JButton btnPlanesMembresia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
