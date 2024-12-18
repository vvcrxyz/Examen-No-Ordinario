/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import dto.ClienteDTO;
import java.util.Random;
import javax.swing.JOptionPane;
import logica.ClienteNegocio;
import logica.Encriptado;

/**
 *
 * @author limon
 */
public class FrmInicio extends javax.swing.JFrame {

    private ClienteNegocio clienteNegocio;
    
    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        clienteNegocio = new ClienteNegocio();
        
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

        btnReserva = new javax.swing.JLabel();
        btnMesa = new javax.swing.JLabel();
        btnConsultas = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        btnInsercion = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReserva.png"))); // NOI18N
        btnReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservaMouseClicked(evt);
            }
        });
        getContentPane().add(btnReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        btnMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnMesas.png"))); // NOI18N
        btnMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMesaMouseClicked(evt);
            }
        });
        getContentPane().add(btnMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        btnConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnConsultas.png"))); // NOI18N
        btnConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultasMouseClicked(evt);
            }
        });
        getContentPane().add(btnConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnSalir.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, -1));

        btnInsercion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnIncersion.png"))); // NOI18N
        btnInsercion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsercion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsercionMouseClicked(evt);
            }
        });
        getContentPane().add(btnInsercion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmMenu.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservaMouseClicked
        // TODO add your handling code here:
        FrmReserva frm = new FrmReserva();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReservaMouseClicked

    private void btnMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesaMouseClicked
        // TODO add your handling code here:
        FrmModuloMesas frm = new FrmModuloMesas();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMesaMouseClicked

    private void btnConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseClicked
        // TODO add your handling code here:
        FrmConsultas frm = new FrmConsultas();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultasMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnInsercionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsercionMouseClicked
        // TODO add your handling code here:
        Random random = new Random();
    String[] nombres = {"Nomar", "Alberto", "Bryan", "Nicole", "Ramon", "Melania", "Emigdia", "Luis", "Mario", "Omar"};
    String[] apellidos = {"Iribe", "Limon", "Quintero", "Corral", "Pérez", "Rascon", "Ortiz", "Mendoza", "Sanchez", "Navarro"};

    try {
        String secretKey = "1234567890123456";  // Clave secreta (debe ser de 16 caracteres para AES-128)

        for (int i = 0; i < 20; i++) {
            // Generar nombre completo aleatorio
            String nombreCompleto = nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];

            // Generar teléfono aleatorio con el formato "644-XXXXXXX"
            String telefono = "644-" + String.format("%07d", random.nextInt(10000000)); // Asegura 7 dígitos

            // Encriptar el número de teléfono
            String telefonoEncriptado = Encriptado.encrypt(telefono, secretKey);

            // Crear el ClienteDTO
            ClienteDTO cliente = new ClienteDTO(nombreCompleto, telefonoEncriptado);

            // Guardar el cliente a través de la lógica de negocio
            clienteNegocio.guardarCliente(cliente);
        }

        JOptionPane.showMessageDialog(this, "Se han insertado 20 clientes correctamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al insertar clientes: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnInsercionMouseClicked

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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnConsultas;
    private javax.swing.JLabel btnInsercion;
    private javax.swing.JLabel btnMesa;
    private javax.swing.JLabel btnReserva;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables
}
