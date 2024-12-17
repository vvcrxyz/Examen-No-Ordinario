/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import com.github.lgooddatepicker.components.DateTimePicker;
import dto.ClienteDTO;
import dto.ReservaDTO;
import dto.RestauranteDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import logica.ClienteNegocio;
import logica.Encriptado;
import logica.MesaNegocio;
import logica.ReservaNegocio;

/**
 *
 * @author limon
 */
public class FrmReserva extends javax.swing.JFrame {

    ClienteNegocio clienteNegocio = new ClienteNegocio();
    DateTimePicker dateTimePicker = new DateTimePicker();
    ReservaNegocio reservaNegocio = new ReservaNegocio();
    MesaNegocio mesaNegocio = new MesaNegocio();
    RestauranteDTO restaurante = new RestauranteDTO();
    
    /**
     * Creates new form FrmReserva
     */
    public FrmReserva() {
        initComponents();
        
        
        this.fldFecha.addDateChangeListener(d -> {
            if (d.getNewDate().isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(
                        this,
                        //"No se pudo obtener la informacion de las mesas en la base de datos.",
                        "La fecha no debe ser anterior a la actual.",
                        "Error - Fecha erronea",
                        JOptionPane.ERROR_MESSAGE
                );
                fldFecha.setDate(LocalDate.now());
            }
        });

       this.fldHora.addTimeChangeListener(t -> {
            LocalTime horaApertura = restaurante.getHoraApertura();
            LocalTime horaCierre = restaurante.getHoraCierre();
            LocalTime horaSeleccionada = t.getNewTime();

            if (horaSeleccionada.isBefore(horaApertura)) {
                fldHora.setTime(horaApertura);
                JOptionPane.showMessageDialog(
                        this,
                        "La hora seleccionada es antes de la hora de apertura del restaurante.",
                        "Error - Hora no permitida",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (horaSeleccionada.isAfter(horaCierre.minusHours(1))) {
                fldHora.setTime(horaCierre.minusHours(1));
                JOptionPane.showMessageDialog(
                        this,
                        "La hora seleccionada es después de la hora de cierre del restaurante.",
                        "Error - Hora no permitida",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            fldHora.setTime(horaSeleccionada);
        });


        llenarBoxNombreCompleto(clienteNegocio.buscarClientes());
    }
    private void llenarBoxNombreCompleto(List<ClienteDTO> clientes) {
        comboBoxNombreCompleto.removeAllItems();

        // Agregar los nombres completos al ComboBox
        for (ClienteDTO cliente : clientes) {
            comboBoxNombreCompleto.addItem(cliente.getNombreCompleto());
        }

        // Listener para actualizar el teléfono según el cliente seleccionado
        comboBoxNombreCompleto.addActionListener(evt -> {
            int selectedIndex = comboBoxNombreCompleto.getSelectedIndex();
            if (selectedIndex >= 0) {
                ClienteDTO clienteSeleccionado = clientes.get(selectedIndex);
                String telefonoEncriptado = clienteSeleccionado.getTelefono();

                try {
                    // Desencriptar el teléfono utilizando la clave proporcionada
                    String telefonoDesencriptado = Encriptado.decrypt(telefonoEncriptado, "1234567890123456"); // Asegúrate de usar la misma clave
                    campoTextoTelefono.setText(telefonoDesencriptado);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al desencriptar el teléfono: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void limpiarFormulario() {
        comboBoxNombreCompleto.setSelectedIndex(0);
        campoTextoTelefono.setText("");
        dateTimePicker.clear();
        comboBoxUbicacion.setSelectedIndex(0);
        spinPersonas.setValue(1);
    }
   

    private double calcularCostoReserva(int numPersonas) {
        if (numPersonas <= 2) {
            return 300; // Mesa pequeña.
        } else if (numPersonas <= 4) {
            return 500; // Mesa mediana.
        } else {
            return 700; // Mesa grande.
        }
    }
    
    private String generarCodigoMesa(String ubicacion, int capacidad) {
    // Asegurarse de que la ubicación no sea nula o vacía
    if (ubicacion == null || ubicacion.isEmpty()) {
        throw new IllegalArgumentException("Ubicación no puede ser nula o vacía.");
    }

    // Asegurarse de que la capacidad sea válida
    if (capacidad <= 0) {
        throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
    }

    // Generar código de mesa
    String codigoUbicacion = ubicacion.substring(0, 3).toUpperCase();
    String capacidadMesa = String.valueOf(capacidad);
    int numeroUnico = obtenerNumeroUnico();
    String numeroUnicoFormateado = String.format("%03d", numeroUnico);

    return codigoUbicacion + "-" + capacidadMesa + "-" + numeroUnicoFormateado;
}

    
    private int numeroReserva = 1; // Este número debe persistir, por ejemplo en una base de datos o archivo

    private int obtenerNumeroUnico() {
        // Incrementar el número de reserva
        return numeroReserva++;
    }

    private Calendar convertirLocalDateTimeACalendar(LocalDateTime fechaHora) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(fechaHora.getYear(), fechaHora.getMonthValue() - 1, fechaHora.getDayOfMonth(),
                     fechaHora.getHour(), fechaHora.getMinute(), fechaHora.getSecond());
        return calendar;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxUbicacion = new javax.swing.JComboBox<>();
        spinPersonas = new com.toedter.components.JSpinField();
        btnGuardar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxNombreCompleto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        campoTextoTelefono = new javax.swing.JTextField();
        fldFecha = new com.github.lgooddatepicker.components.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        fldHora = new com.github.lgooddatepicker.components.TimePicker();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoReserva.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, 610));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnRegresar.png"))); // NOI18N
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("MingLiU-ExtB", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Reserva");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ubicacion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("No. personas");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        comboBoxUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terraza", "General", "Ventana" }));
        getContentPane().add(comboBoxUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 100, 50));

        spinPersonas.setMaximum(8);
        spinPersonas.setMinimum(1);
        getContentPane().add(spinPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 70, 30));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGuardar.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre Completo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        getContentPane().add(comboBoxNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 280, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefono");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 20));

        campoTextoTelefono.setEditable(false);
        campoTextoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(campoTextoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 200, 40));
        getContentPane().add(fldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 220, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Hora");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));
        getContentPane().add(fldHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 120, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmMesas.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        // TODO add your handling code here:
        FrmInicio frm = new FrmInicio();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        
         try {
        String nombreCompleto = comboBoxNombreCompleto.getSelectedItem() != null 
                                ? comboBoxNombreCompleto.getSelectedItem().toString() 
                                : null;
        String telefono = campoTextoTelefono.getText();

        if (nombreCompleto == null || nombreCompleto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un nombre válido.");
            return;
        }

        if (telefono == null || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un teléfono válido.");
            return;
        }

        // Obtener la fecha y hora seleccionadas
        LocalDate fechaSeleccionada = fldFecha.getDate();
        LocalTime horaSeleccionada = fldHora.getTime();

        if (fechaSeleccionada == null || horaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha y hora válidas.");
            return;
        }

        // Combinar fecha y hora seleccionada
        LocalDateTime fechaHoraReserva = LocalDateTime.of(fechaSeleccionada, horaSeleccionada);

        // Convertir a zona horaria fija (Hermosillo)
        ZoneId zonaHermosillo = ZoneId.of("America/Hermosillo");
        ZonedDateTime fechaHoraHermosillo = fechaHoraReserva.atZone(zonaHermosillo);

        // Validar que no sea anterior a la hora actual
        if (fechaHoraHermosillo.isBefore(ZonedDateTime.now(zonaHermosillo))) {
            JOptionPane.showMessageDialog(this, "La fecha y hora de la reserva no puede ser anterior al momento actual en Hermosillo.");
            return;
        }

        // Obtener otros datos del formulario
        String ubicacion = comboBoxUbicacion.getSelectedItem().toString();
        int numPersonas = spinPersonas.getValue();

        String codigoMesa = generarCodigoMesa(ubicacion, numPersonas);

        // Calcular costo de la reserva
        double costoReserva = calcularCostoReserva(numPersonas);

        // Convertir LocalDateTime a Calendar (para compatibilidad)
        Calendar fechaHoraCalendar = convertirLocalDateTimeACalendar(fechaHoraHermosillo.toLocalDateTime());

        // Crear reserva
        long id = 1; // ID temporal, ajusta según tu lógica
        ReservaDTO reserva = new ReservaDTO(
            id, nombreCompleto, telefono, fechaHoraCalendar, ubicacion, numPersonas, costoReserva, codigoMesa
        );

        // Guardar en la base de datos
        reservaNegocio.guardarReserva(reserva);

        JOptionPane.showMessageDialog(this, "Reserva guardada exitosamente:\nCódigo de mesa: " + codigoMesa 
                                      + "\nCosto: $" + costoReserva
                                      + "\nZona horaria: Hermosillo");

        // Limpiar formulario
        limpiarFormulario();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar la reserva: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void campoTextoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoTelefonoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_campoTextoTelefonoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JTextField campoTextoTelefono;
    private javax.swing.JComboBox<String> comboBoxNombreCompleto;
    private javax.swing.JComboBox<String> comboBoxUbicacion;
    private com.github.lgooddatepicker.components.DatePicker fldFecha;
    private com.github.lgooddatepicker.components.TimePicker fldHora;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.components.JSpinField spinPersonas;
    // End of variables declaration//GEN-END:variables
}
