/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import dao.MesaDAO;
import entidades.MesaEntidad;
import javax.swing.JOptionPane;

/**
 *
 * @author limon
 */
public class FrmInsertarMesa extends javax.swing.JFrame {

    /**
     * Creates new form FrmInsertarMesa
     */
    public FrmInsertarMesa() {
        initComponents();
    }

    private void agregarMesasPorTipo(MesaDAO mesaDAO, String cantidadStr, String tipo, String ubicacion) {
        if (cantidadStr != null && !cantidadStr.isEmpty()) {
            try {
                int cantidad = Integer.parseInt(cantidadStr);

                for (int i = 1; i <= cantidad; i++) {
                    String codigoMesa = generarCodigoMesa(tipo, ubicacion, i);
                    MesaEntidad mesa = new MesaEntidad(codigoMesa, tipo, determinarCapacidad(tipo), ubicacion);
                    mesaDAO.guardarMesa(mesa);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido para las mesas de tipo " + tipo + ".", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private String generarCodigoMesa(String tipo, String ubicacion, int indice) {
        // Se toma solo las tres primeras letras de la ubicación y tipo y se pasa a mayúsculas.
        String prefijoUbicacion = ubicacion.substring(0, 3).toUpperCase();
        String prefijoTipo = tipo.substring(0, 3).toUpperCase(); // Esto ya está bien, no es necesario cambiarlo.

        // Aquí estamos generando el código en el formato correcto: UBICACION-TIPO-INDICE
        return prefijoUbicacion + "-" + determinarCapacidad(tipo) + "-" + String.format("%03d", indice);
    }


    private int determinarCapacidad(String tipo) {
        switch (tipo) {
            case "Pequeña": return 2;
            case "Mediana": return 4;
            case "Grande": return 6;
            default: return 0;
        }
    }
    
    private void reiniciarCampos() {
        campoTextoPequeña.setText("");
        campoTextoMediana.setText("");
        campoTextoGrande.setText("");
        comboBoxUbicacion.setSelectedIndex(0); // Reinicia el ComboBox a su posición inicial
    }
    
    private boolean esNumeroValido(String texto) {
        if (texto.isEmpty()) return true; // Campo vacío no es un error aquí, ya se valida antes.
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxUbicacion = new javax.swing.JComboBox<>();
        campoTextoPequeña = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTextoMediana = new javax.swing.JTextField();
        campoTextoGrande = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnRegresar.png"))); // NOI18N
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("MingLiU-ExtB", 1, 64)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Insertar mesa");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ubicación");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        comboBoxUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terraza", "General", "Ventana" }));
        getContentPane().add(comboBoxUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 110, 50));
        getContentPane().add(campoTextoPequeña, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 50, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Pequeña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mediana");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));
        getContentPane().add(campoTextoMediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 50, 40));
        getContentPane().add(campoTextoGrande, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 50, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Grande");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAgregar.png"))); // NOI18N
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoMesa.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmMesas.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        // TODO add your handling code here:
        FrmGestionarMesa frm = new FrmGestionarMesa();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
        try {
        // Capturar los datos del formulario
        String ubicacion = (String) comboBoxUbicacion.getSelectedItem();
        String cantidadPequeña = campoTextoPequeña.getText().trim();
        String cantidadMediana = campoTextoMediana.getText().trim();
        String cantidadGrande = campoTextoGrande.getText().trim();

        // Validar que la ubicación esté seleccionada
        if (ubicacion == null || ubicacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una ubicación.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que al menos uno de los campos contenga un número
        if (cantidadPequeña.isEmpty() && cantidadMediana.isEmpty() && cantidadGrande.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese al menos una cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que los campos contengan solo números
        if (!esNumeroValido(cantidadPequeña) || !esNumeroValido(cantidadMediana) || !esNumeroValido(cantidadGrande)) {
            JOptionPane.showMessageDialog(this, "Ingrese solo números en los campos de cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear instancias de MesaEntidad y guardar en la base de datos
        MesaDAO mesaDAO = new MesaDAO();
        agregarMesasPorTipo(mesaDAO, cantidadPequeña, "Pequeña", ubicacion);
        agregarMesasPorTipo(mesaDAO, cantidadMediana, "Mediana", ubicacion);
        agregarMesasPorTipo(mesaDAO, cantidadGrande, "Grande", ubicacion);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Mesas agregadas exitosamente.");

        // Reiniciar los campos
        reiniciarCampos();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar las mesas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnAgregarMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JTextField campoTextoGrande;
    private javax.swing.JTextField campoTextoMediana;
    private javax.swing.JTextField campoTextoPequeña;
    private javax.swing.JComboBox<String> comboBoxUbicacion;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
