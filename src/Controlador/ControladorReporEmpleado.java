package Controlador;

import Vista.VtnReporEmpleados;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:36:04 p.m.
 */
public class ControladorReporEmpleado {

    public ControladorReporEmpleado() {
        
    }

    
    public boolean generaReporte(TableModel modeloConDatos) {
        FileOutputStream out = null;
        try {
            // TODO add your handling code here:
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet("new sheet");
            Row row = null;
            Cell cell = null;
            TableModel auxModeloConDatos = modeloConDatos;
            
            exportaReportes(sheet, auxModeloConDatos);
              
            out = new FileOutputStream("reporteEmpleados.xls");
            wb.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VtnReporEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VtnReporEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     *
     * @param sheet
     * @param tableModel
     * @return 
     */
    
    public boolean exportaReportes(Sheet sheet, TableModel tableModel) {
        boolean exportadoCorrectamente = false;
        crearEncabezados(sheet,tableModel);
        poblarExcel(sheet, tableModel);
        exportadoCorrectamente = true;
        
        return exportadoCorrectamente;
    }

    public DefaultTableModel obtenerModeloConDatos (JTable modelo){
        ControladorEmpleado unControlador = new ControladorEmpleado();

        try {
            LinkedList listaDeEmpleados = unControlador.buscarTodosLosEmpleadosConVentas();

            Object columnasDeDatos[] = new Object[4];

            //obtenemos el modelo default de la tabla:
            DefaultTableModel modeloDeLaTabla = (DefaultTableModel) modelo.getModel();
            
            if (listaDeEmpleados != null) {
                //agregamos a cada columna los datos que le corresponden:
                for (int dato = 0; dato < listaDeEmpleados.size(); dato = dato + 4) {
                    columnasDeDatos[0] = listaDeEmpleados.get(dato);
                    columnasDeDatos[1] = listaDeEmpleados.get(dato + 1);
                    columnasDeDatos[2] = listaDeEmpleados.get(dato + 2);
                    columnasDeDatos[3] = listaDeEmpleados.get(dato + 3);

                    //agregamos los datos de cada columna en cada renglón:
                    modeloDeLaTabla.addRow(columnasDeDatos);

                }
            } else {
                /*El else no es necesario, pero fue considerado.*/
            }
            return modeloDeLaTabla;

        } catch (SQLException ex) {
            Logger.getLogger(VtnReporEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void crearEncabezados(Sheet sheet, TableModel tableModel) {
        Row row = sheet.createRow(0);
        Cell cell = null;
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                cell =  row.createCell(i);
                cell.setCellValue(tableModel.getColumnName(i));
            }
    }

    private void poblarExcel(Sheet sheet, TableModel tableModel) {
        Row row;
        Cell cell;
        for (int i = 1; i < tableModel.getRowCount()+1; i++) {
                row = sheet.createRow(i);
                for (int j = 0; j <  tableModel.getColumnCount(); j++) {
                    cell =  row.createCell(j);
                    String dinero = (j>1)? "$":"";
                    cell.setCellValue(dinero + (String)tableModel.getValueAt(i-1, j));
                }
            } 
    }
}
