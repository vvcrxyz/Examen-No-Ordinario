package utilerias;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 * Esta clase implementa un editor de celdas personalizado para JTable, donde se utiliza un botón como componente
 * que puede ser editado dentro de la tabla. El botón se agrega en la celda y ejecuta una acción cuando se hace clic en él.
 * 
 * El editor proporciona la funcionalidad para definir una acción personalizada al hacer clic en el botón de una celda
 * y notificar el evento correspondiente.
 * 
 * @author Santi
 */
public class ButtonEditor implements TableCellEditor {

    private final JButton button;
    private int row;
    private ActionListener actionListener;

    /**
     * Constructor que inicializa un botón con el texto especificado y asigna un ActionListener para manejar los eventos.
     * 
     * @param text El texto que se mostrará en el botón.
     * @param actionListener El ActionListener que se activará cuando se haga clic en el botón.
     */
    public ButtonEditor(String text, ActionListener actionListener) {
        this.button = new JButton(text);
        this.actionListener = actionListener;
        this.button.addActionListener((ActionEvent evt) -> {
            // Ejecuta la acción proporcionada al hacer clic en el botón.
            this.actionListener.actionPerformed(
                new ActionEvent(this.button, ActionEvent.ACTION_PERFORMED, this.row + "")
            );
        });
    }
    
    /**
     * Devuelve el componente (botón) que será usado como editor de celda.
     * 
     * @param table La tabla que contiene la celda.
     * @param value El valor de la celda (no utilizado en este caso).
     * @param isSelected Indica si la celda está seleccionada (no utilizado en este caso).
     * @param row El índice de la fila.
     * @param column El índice de la columna.
     * @return El componente (botón) que se usará como editor de celda.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return this.button;
    }

    /**
     * Retorna el valor de la celda. En este caso, siempre devuelve true ya que el botón no modifica datos.
     * 
     * @return El valor de la celda, siempre devuelve true.
     */
    @Override
    public Object getCellEditorValue() {
        return true;
    }

    /**
     * Indica si la celda es editable. En este caso, siempre devuelve true ya que el botón es editable.
     * 
     * @param anEvent El evento asociado al intento de editar la celda.
     * @return true, ya que el botón es siempre editable.
     */
    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    /**
     * Indica si se debe seleccionar la celda. En este caso, siempre devuelve true.
     * 
     * @param anEvent El evento asociado a la selección de la celda.
     * @return true, ya que siempre se selecciona la celda.
     */
    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    /**
     * Detiene la edición de la celda. En este caso, siempre devuelve true para finalizar la edición.
     * 
     * @return true para detener la edición.
     */
    @Override
    public boolean stopCellEditing() {
        return true;
    }

    /**
     * Cancela la edición de la celda. No realiza ninguna acción en este caso.
     */
    @Override
    public void cancelCellEditing() {}

    /**
     * Agrega un CellEditorListener. No se utiliza en este caso, pero se proporciona para cumplir con la interfaz.
     * 
     * @param l El CellEditorListener que se desea agregar.
     */
    @Override
    public void addCellEditorListener(CellEditorListener l) {}

    /**
     * Elimina un CellEditorListener. No se utiliza en este caso, pero se proporciona para cumplir con la interfaz.
     * 
     * @param l El CellEditorListener que se desea eliminar.
     */
    @Override
    public void removeCellEditorListener(CellEditorListener l) {}
}
