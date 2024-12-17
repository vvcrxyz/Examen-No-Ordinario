/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import entidades.ReservaEntidad;
import java.awt.FlowLayout;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.awt.Desktop;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 *
 * @author limon
 */
public class FrmConsultaArea extends javax.swing.JFrame {

    DateTimePicker dateTimePicker = new DateTimePicker();
    DateTimePicker dateTimePicker2 = new DateTimePicker();
    
    /**
     * Creates new form FrmConsultaArea
     */
    public FrmConsultaArea() {
        initComponents();
        
        fldFechaInicio.setLayout(new FlowLayout());
        fldFechaInicio.add(dateTimePicker);
        fldFechaFin.setLayout(new FlowLayout());
        fldFechaFin.add(dateTimePicker2);
    }
    
      // Set the file path for the report
    String reportFilePath = "Reporte Consulta Area.pdf";

    public void generarReporteArea(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
    if (fechaInicio == null || fechaFin == null) {
        JOptionPane.showMessageDialog(this, "Las fechas no pueden ser nulas.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String tipoMesaSeleccionado = comboBoxTipoMesa.getSelectedItem().toString();
    int capacidadMinima = 0;
    int capacidadMaxima = 0;

    // Determinar el rango de capacidad de la mesa según la opción seleccionada
    switch (tipoMesaSeleccionado) {
        case "Pequeña":
            capacidadMinima = 1;
            capacidadMaxima = 2;
            break;
        case "Mediana":
            capacidadMinima = 3;
            capacidadMaxima = 4;
            break;
        case "Grande":
            capacidadMinima = 5;
            capacidadMaxima = Integer.MAX_VALUE;  // Sin límite superior
            break;
        default:
            JOptionPane.showMessageDialog(this, "Tipo de mesa no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
    EntityManager em = emf.createEntityManager();

    try {
        // JPQL corregido para incluir el filtro por fecha y número de personas
        String jpql = "SELECT r FROM ReservaEntidad r " +
                      "WHERE r.fechaHoraReserva BETWEEN :fechaInicio AND :fechaFin " +
                      "AND r.numPersonas BETWEEN :capacidadMinima AND :capacidadMaxima";

        TypedQuery<ReservaEntidad> query = em.createQuery(jpql, ReservaEntidad.class);
        query.setParameter("fechaInicio", Timestamp.valueOf(fechaInicio));
        query.setParameter("fechaFin", Timestamp.valueOf(fechaFin));
        query.setParameter("capacidadMinima", capacidadMinima);
        query.setParameter("capacidadMaxima", capacidadMaxima);

        List<ReservaEntidad> reservas = query.getResultList();

        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron reservas con los filtros seleccionados.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Generar PDF
        PdfWriter writer = new PdfWriter(reportFilePath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("Historial de Reservas por Área del Restaurante").setBold().setFontSize(18));
        document.add(new Paragraph("Filtros Aplicados:\n" +
                "Fecha Inicio: " + fechaInicio.toString() +
                "\nFecha Fin: " + fechaFin.toString() +
                "\nTipo de Mesa: " + tipoMesaSeleccionado));

        // Usar SimpleDateFormat para el formato de la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        document.add(new Paragraph("\nListado de Reservas:"));
        for (ReservaEntidad reserva : reservas) {
            // Convertir Calendar a Date
            Calendar fechaReservaCalendar = reserva.getFechaHoraReserva();
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
            document.add(new Paragraph(reservaInfo));
        }

        document.close();
        JOptionPane.showMessageDialog(this, "Reporte generado en: " + reportFilePath, "Reporte generado", JOptionPane.INFORMATION_MESSAGE);

        // Abrir el PDF automáticamente
        File file = new File(reportFilePath);
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        } else {
            JOptionPane.showMessageDialog(this, "El archivo PDF está listo pero no se pudo abrir automáticamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        em.close();
        emf.close();
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

        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JLabel();
        comboBoxTipoMesa = new javax.swing.JComboBox<>();
        fldFechaInicio = new javax.swing.JPanel();
        fldFechaFin = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("MingLiU-ExtB", 1, 64)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Consulta area");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnRegresar.png"))); // NOI18N
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Fecha final");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha inicial");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tamaño de mesa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGenerarReporte.png"))); // NOI18N
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseClicked(evt);
            }
        });
        getContentPane().add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        comboBoxTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeña", "Mediana", "Grande" }));
        getContentPane().add(comboBoxTipoMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 110, 50));
        getContentPane().add(fldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 350, 40));
        getContentPane().add(fldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 350, 40));

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

    private void btnGenerarReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteMouseClicked
        // TODO add your handling code here:
        // Obtener los valores del formulario
        LocalDateTime fechaInicio = dateTimePicker.getDateTimePermissive();
        LocalDateTime fechaFin = dateTimePicker2.getDateTimePermissive();
        String tipoMesa = comboBoxTipoMesa.getSelectedItem().toString();
        

        // Llamar a la función para generar el reporte
        generarReporteArea(fechaInicio, fechaFin);
    }//GEN-LAST:event_btnGenerarReporteMouseClicked

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGenerarReporte;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JComboBox<String> comboBoxTipoMesa;
    private javax.swing.JPanel fldFechaFin;
    private javax.swing.JPanel fldFechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
