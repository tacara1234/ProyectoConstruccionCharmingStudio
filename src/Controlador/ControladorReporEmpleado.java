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

    /**
     * Genera el reporte, inicializa las variables que se usaran y llama a exporta reportes que se
     * encarga de escribir en el Excel.
     * @param modeloConDatos
     * @return 
     */
    public boolean generaReporte(TableModel modeloConDatos) {
        boolean exportadoCorrectamente = false;
        FileOutputStream out = null;
        try {
            // TODO add your handling code here:
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet("new sheet");
            TableModel auxModeloConDatos = modeloConDatos;
            
            exportadoCorrectamente = llenarDatosDeReporte(sheet, auxModeloConDatos);
              
            out = new FileOutputStream("ReporteEmpleados.xls");
            wb.write(out);
            out.close();
            return exportadoCorrectamente;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VtnReporEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VtnReporEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exportadoCorrectamente;
    }

    /**
     * Funcion que se encarga de llamar a otras funciones que estan divididas, una llena los encabezados
     * del Excel, y la otra lo pobla de datos.
     * @param sheet
     * @param tableModel
     * @return 
     */
    
    private boolean llenarDatosDeReporte(Sheet sheet, TableModel tableModel) {
        boolean exportadoCorrectamente = false;
        llenarExcelDeDatos(sheet,tableModel);
        exportadoCorrectamente = true;
        
        return exportadoCorrectamente;
    }

    /**
     * Funcion que obtiene una tabla vacía, y llama al controlador de empleados para buscar
     * a los empleados con las ventas, llena el modelo de la tabla con esos datos, y se los
     * regresa a la vista para que pueda desplegarlo.
     * @param modelo
     * @return 
     */
    
    private final int numDeColumnasDeDatos = 4;
    public DefaultTableModel obtenerModeloConDatos (JTable modelo){
        ControladorEmpleado unControlador = new ControladorEmpleado();

        try {
            LinkedList listaDeEmpleados = unControlador.buscarTodosLosEmpleadosConVentas();

            Object columnasDeDatos[] = new Object[numDeColumnasDeDatos];

            //obtenemos el modelo default de la tabla:
            DefaultTableModel modeloDeLaTabla = (DefaultTableModel) modelo.getModel();
            
            if (listaDeEmpleados != null) {
                //agregamos a cada columna los datos que le corresponden:
                for (int indiceDelDato = 0; indiceDelDato < listaDeEmpleados.size(); indiceDelDato = indiceDelDato + 4) {
                    columnasDeDatos[0] = listaDeEmpleados.get(indiceDelDato);
                    columnasDeDatos[1] = listaDeEmpleados.get(indiceDelDato + 1);
                    columnasDeDatos[2] = listaDeEmpleados.get(indiceDelDato + 2);
                    columnasDeDatos[3] = listaDeEmpleados.get(indiceDelDato + 3);

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
    
    /**
     * Pone los datos en las filas y columnas correspondientes del excel
     * @param sheet es la hoja de excel en la cual se estan poniendo los datos
     * @param tableModel es el modelo de la tabla de la cual se obtienen los datos
     */
    private void llenarExcelDeDatos(Sheet sheet, TableModel tableModel) {
        Row row = sheet.createRow(0);
        Cell cell = null;
        int numeroDeColumnas = tableModel.getColumnCount();
            for (int columna = 0; columna < numeroDeColumnas; columna++) {
                cell =  row.createCell(columna);
                cell.setCellValue(tableModel.getColumnName(columna));
            }
            int numeroDeFilas = tableModel.getRowCount();
            for (int fila = 1; fila < numeroDeFilas+1; fila++) {
                row = sheet.createRow(fila);
                for (int columna = 0; columna <  numeroDeColumnas; columna++) {
                    cell =  row.createCell(columna);
                    
                    String signoDinero = (columna>1)? "$":"";
                    String cantidad = (String)tableModel.getValueAt(fila-1, columna);
                    cell.setCellValue(signoDinero + cantidad);
                }
            }
    }

    
}
