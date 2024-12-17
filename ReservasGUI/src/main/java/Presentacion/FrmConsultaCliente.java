/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import dto.ClienteDTO;
import dto.ReservaDTO;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.ClienteNegocio;
import logica.Encriptado;
import logica.ReservaNegocio;
import utilerias.ButtonEditor;
import utilerias.ButtonRenderer;



/**
 *
 * @author limon
 */
public class FrmConsultaCliente extends javax.swing.JFrame {

    DateTimePicker dateTimePicker = new DateTimePicker();
    DateTimePicker dateTimePicker2 = new DateTimePicker();
    ClienteNegocio clienteNegocio = new ClienteNegocio();
    ReservaNegocio reservaNegocio = new ReservaNegocio();
    /**
     * Creates new form FrmConsultaCliente
     */
    public FrmConsultaCliente() {
        initComponents();
        
        
        fldFechaReservaInicial.add(dateTimePicker);
       
        fldFechaReservaFinal.add(dateTimePicker2);
        
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
    
    private void generarPDF(ReservaDTO reserva) {
    try {
        // Crear un nombre único para el archivo PDF usando el id de la reserva
        String reportFilePath = "DetallesReserva_" + reserva.getId() + ".pdf";
        
        // Crear PdfWriter y PdfDocument
        PdfWriter writer = new PdfWriter(reportFilePath);
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Crear un Document (iText 7) para agregar contenido al PDF
        com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);

        // Usar SimpleDateFormat para el formato de la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        // Convertir Calendar a Date
        Calendar fechaReservaCalendar = reserva.getFechaHoraReserva(); // Aquí obtienes el objeto Calendar
        java.util.Date fechaReserva = fechaReservaCalendar.getTime(); // Convertir Calendar a Date

        // Formatear la fecha
        String fechaFormateada = sdf.format(fechaReserva);

        // Crear el texto para el reporte con la fecha formateada
        String reservaInfo = String.format("ID: %d | Fecha y Hora: %s | Cliente: %s | Personas: %d | Costo: %.2f | Ubicacion: %s | Codigo Mesa: %s",
                reserva.getId(),
                fechaFormateada, // Usamos la fecha formateada aquí
                reserva.getNombreCompleto(),
                reserva.getNumPersonas(),
                reserva.getCostoReserva(),
                reserva.getUbicacion(),
                reserva.getCodigoMesa());

        // Añadir la información al documento PDF
        document.add(new com.itextpdf.layout.element.Paragraph("Detalles de la Reserva"));
        document.add(new com.itextpdf.layout.element.Paragraph(reservaInfo));

        // Cerrar el documento
        document.close();

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(null, "PDF generado con éxito.");

        // Abrir el PDF automáticamente
        File file = new File(reportFilePath);
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        } else {
            JOptionPane.showMessageDialog(this, "El archivo PDF está listo pero no se pudo abrir automáticamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
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
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JLabel();
        fldFechaReservaInicial = new javax.swing.JPanel();
        campoTextoTelefono = new javax.swing.JTextField();
        comboBoxNombreCompleto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        fldFechaReservaFinal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
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

        jLabel2.setFont(new java.awt.Font("MingLiU-ExtB", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Consulta cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de reserva Final");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre completo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnMostrar.png"))); // NOI18N
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarMouseClicked(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, -1, -1));
        getContentPane().add(fldFechaReservaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 350, 40));

        campoTextoTelefono.setEditable(false);
        campoTextoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(campoTextoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 200, 40));

        getContentPane().add(comboBoxNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 280, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha de reserva Inicial");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));
        getContentPane().add(fldFechaReservaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 350, 40));

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Cliente", "Telefono", "Detalles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmMesas.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        // TODO add your handling code here:
        FrmConsultas frm = new FrmConsultas();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseClicked
// Obtener el nombre completo del cliente seleccionado
    String nombreCliente = (String) comboBoxNombreCompleto.getSelectedItem();

    // Obtener las fechas de reserva seleccionadas
    LocalDateTime fechaInicio = dateTimePicker.getDateTimePermissive();
    LocalDateTime fechaFin = dateTimePicker2.getDateTimePermissive();

    if (nombreCliente != null && fechaInicio != null && fechaFin != null) {
        // Llamar al negocio para obtener las reservas filtradas
        List<ReservaDTO> reservasFiltradas = reservaNegocio.buscarReservasPorClienteYFechas(nombreCliente, fechaInicio, fechaFin);

        // Llenar la tabla con las reservas filtradas
        DefaultTableModel model = (DefaultTableModel) tblCliente.getModel();
        model.setRowCount(0);  // Limpiar la tabla

        // Crear un ActionListener para el botón
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada (convertir el comando a número de fila)
                int row = Integer.parseInt(e.getActionCommand());
                ReservaDTO reservaSeleccionada = reservasFiltradas.get(row);

                // Llamar al método para generar el PDF con los detalles de la reserva
                generarPDF(reservaSeleccionada);
            }
        };

        // Agregar cada reserva como una fila en la tabla
        for (int i = 0; i < reservasFiltradas.size(); i++) {
            ReservaDTO reserva = reservasFiltradas.get(i);
            model.addRow(new Object[] {
                reserva.getNombreCompleto(),
                reserva.getTelefono(),
                "Ver Detalles"  // Esto será el texto del botón
            });

            // Asignar el ActionListener al botón de la columna "Detalles"
            ButtonEditor buttonEditor = new ButtonEditor("Ver Detalles", actionListener);
            tblCliente.getColumnModel().getColumn(2).setCellEditor(buttonEditor);
            tblCliente.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer("Ver Detalles", Color.GREEN));
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de búsqueda.");
    }
    }//GEN-LAST:event_btnMostrarMouseClicked

    private void campoTextoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoTelefonoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_campoTextoTelefonoActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnMostrar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JTextField campoTextoTelefono;
    private javax.swing.JComboBox<String> comboBoxNombreCompleto;
    private javax.swing.JPanel fldFechaReservaFinal;
    private javax.swing.JPanel fldFechaReservaInicial;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    // End of variables declaration//GEN-END:variables
}
