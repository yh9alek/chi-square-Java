
package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author yh9pl
 */
public class Excel {
    public static DefaultTableModel cargar(JDialog formulario) {
        DefaultTableModel tableModel = new DefaultTableModel();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "csv", "xls", "xlsx");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(formulario);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(selectedFile);
                Workbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0);
                tableModel = Excel.loadSheetData(sheet);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(formulario, "Error al cargar el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return tableModel;
    }

    private static DefaultTableModel loadSheetData(Sheet sheet) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        // Cargar encabezados de columna
        Row headerRow = sheet.getRow(0);
        if (headerRow != null) {
            for (Cell cell : headerRow) {
                tableModel.addColumn(cell.toString());
            }

            // Cargar datos de las filas
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Object[] rowData = new Object[row.getLastCellNum()];
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            try { rowData[j] = (int)cell.getNumericCellValue();}
                            catch(Exception err) {}
                        }
                    }
                    tableModel.addRow(rowData);
                }
            }
        }
        return tableModel;
    }
}
