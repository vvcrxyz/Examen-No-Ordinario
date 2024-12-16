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
    
       public void generarReporteArea(LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoMesa, String ubicacion) {
    // Set the file path for the report
    String reportFilePath = "Reporte Consulta Area.pdf";

    // Create a PdfWriter object and initialize the PdfDocument
    try (PdfWriter writer = new PdfWriter(reportFilePath)) {
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add title to the report
        document.add(new Paragraph("Reporte de Reservas por Área")
            .setBold()
            .setFontSize(20)
            .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER));

        // Add filter information
        document.add(new Paragraph("Fecha Inicio: " + fechaInicio.toString()));
        document.add(new Paragraph("Fecha Fin: " + fechaFin.toString()));
        document.add(new Paragraph("Tipo de Mesa: " + tipoMesa));
        document.add(new Paragraph("Ubicación: " + ubicacion));

        // Add the data from the database (this is where you query the database)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
        EntityManager em = emf.createEntityManager();

        // Construct a query to fetch reservations based on the filters
        String queryStr = "SELECT r FROM ReservaEntidad r WHERE r.fechaHoraReserva BETWEEN :fechaInicio AND :fechaFin "
            + "AND r.codigoMesa = :tipoMesa AND r.ubicacion = :ubicacion";  // Using codigoMesa and ubicacion
        TypedQuery<ReservaEntidad> query = em.createQuery(queryStr, ReservaEntidad.class);
        query.setParameter("fechaInicio", Timestamp.valueOf(fechaInicio));
        query.setParameter("fechaFin", Timestamp.valueOf(fechaFin));
        query.setParameter("tipoMesa", tipoMesa);  // Now this refers to codigoMesa
        query.setParameter("ubicacion", ubicacion);

        List<ReservaEntidad> reservas = query.getResultList();

        // Add the reservation details to the report
        for (ReservaEntidad reserva : reservas) {
            document.add(new Paragraph("Reserva ID: " + reserva.getId()));
            document.add(new Paragraph("Cliente: " + reserva.getNombreCompleto()));
            document.add(new Paragraph("Mesa: " + reserva.getCodigoMesa()));  // Use codigoMesa
            document.add(new Paragraph("Fecha y Hora: " + reserva.getFechaHoraReserva().toString()));
            document.add(new Paragraph("----------------------------------------------------"));
        }

        // Close the document
        document.close();

        // Provide feedback to the user
        JOptionPane.showMessageDialog(this, "Reporte generado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel5 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JLabel();
        comboBoxTipoMesa = new javax.swing.JComboBox<>();
        comboBoxUbicacion = new javax.swing.JComboBox<>();
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
        jLabel4.setText("Tipo de mesa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ubicación");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, -1));

        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGenerarReporte.png"))); // NOI18N
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseClicked(evt);
            }
        });
        getContentPane().add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        comboBoxTipoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeña", "Mediana", "Grande" }));
        getContentPane().add(comboBoxTipoMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 110, 50));

        comboBoxUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terraza", "General", "Ventana" }));
        getContentPane().add(comboBoxUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 110, 50));
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
        String ubicacion = comboBoxUbicacion.getSelectedItem().toString();

        // Llamar a la función para generar el reporte
        generarReporteArea(fechaInicio, fechaFin, tipoMesa, ubicacion);
    }//GEN-LAST:event_btnGenerarReporteMouseClicked

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
            java.util.logging.Logger.getLogger(FrmConsultaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConsultaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConsultaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConsultaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConsultaArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGenerarReporte;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JComboBox<String> comboBoxTipoMesa;
    private javax.swing.JComboBox<String> comboBoxUbicacion;
    private javax.swing.JPanel fldFechaFin;
    private javax.swing.JPanel fldFechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
