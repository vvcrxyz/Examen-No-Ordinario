/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import Presentacion.FrmEditarMesa;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author limon
 */
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private JButton button;
    private int row;
    private JTable table;
    private String action;

    public ButtonEditor(JTable table, String text, String action) {
        this.table = table;
        this.action = action;
        this.button = new JButton(text);
        button.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Identificar la acción del botón
        if (action.equals("Editar")) {
            editarMesa(row);
        } else if (action.equals("Eliminar")) {
            eliminarMesa(row);
        }
        fireEditingStopped(); // Para detener la edición después de ejecutar la acción
    }

    private void editarMesa(int row) {
        // Lógica para editar
        String codigoMesa = (String) table.getValueAt(row, 0);
        JOptionPane.showMessageDialog(table, "Editar mesa: " + codigoMesa);
        // Aquí puedes abrir un formulario de edición o realizar acciones adicionales
        FrmEditarMesa frm = new FrmEditarMesa();
        frm.setVisible(true);
    }

    private void eliminarMesa(int row) {
        // Lógica para eliminar
        String codigoMesa = (String) table.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(table, "¿Seguro que deseas eliminar la mesa " + codigoMesa + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Eliminar la mesa de la lista y actualizar la tabla
            ((DefaultTableModel) table.getModel()).removeRow(row);
        }
    }
}
