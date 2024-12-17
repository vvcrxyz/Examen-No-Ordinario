package Util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Esta clase es un renderizador personalizado para botones dentro de una tabla JTable.
 * Permite agregar botones a las celdas de una tabla, con un texto y un color de fondo definidos por el usuario.
 * El renderizador asegura que cada celda en la tabla mostrará un botón con el aspecto y la funcionalidad deseada.
 * 
 * @author Santi
 */
public class ButtonRenderer implements TableCellRenderer {

    private final JButton button;
    
    /**
     * Constructor que inicializa un botón con el texto y el color de fondo especificados.
     * 
     * @param text El texto que se mostrará en el botón.
     * @param color El color de fondo del botón.
     */
    public ButtonRenderer(String text, Color color) {
        this.button = new JButton(text);
        this.button.setBackground(color);
    }
    
    /**
     * Implementación del método getTableCellRendererComponent de la interfaz TableCellRenderer.
     * Este método es llamado para obtener el componente que será utilizado para representar una celda de la tabla.
     * En este caso, se devuelve el botón configurado para la celda.
     * 
     * @param table La tabla que contiene la celda.
     * @param value El valor de la celda. Este valor no se utiliza en este caso, ya que siempre se muestra un botón.
     * @param isSelected Indica si la celda está seleccionada. No se usa en este caso.
     * @param hasFocus Indica si la celda tiene el foco. No se usa en este caso.
     * @param row El índice de la fila.
     * @param column El índice de la columna.
     * @return El componente a mostrar en la celda, que en este caso es un botón.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this.button;
    }
}
