package Controlador;

import Vista.VtnReporGanancias;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @created 19-sep-2014 02:35:55 p.m.
 */
public class ControladorReporGanancias {

    public ControladorReporGanancias() {

    }

    /**
     * Calcula el monto total de todos los eventos que se han realizado
     *
     * @param datosTabla es el modelo de la tabla de donde se van obtener los
     * datos
     * @return el total de las ganancias obtenidas
     */
    public float calcularGananciasTotales(DefaultTableModel datosTabla) {
        float gananciasTotales = 0;
        int numeroDeFilas = datosTabla.getRowCount();
        for (int fila = 0; fila < numeroDeFilas; fila++) {

            gananciasTotales = gananciasTotales + (float) datosTabla.getValueAt(fila, 2);
        }
        return gananciasTotales;
    }

    private final int enero = 1;
    private final int febrero = 2;
    private final int marzo = 3;
    private final int abril = 4;
    private final int mayo = 5;
    private final int junio = 6;
    private final int julio = 7;
    private final int agosto = 8;
    private final int septiembre = 9;
    private final int octubre = 10;
    private final int noviembre = 11;
    private final int diciembre = 12;

    /**
     * Calcula el mes con en el que se gano mas dinero
     *
     * @param datosTabla es el modelo de la tabla que contiene los datos que se
     * usaran en el calculo
     * @return el mes con mas ganancias
     */
    public String calcularMesConMasGanancias(DefaultTableModel datosTabla) {

        float[] gananaciasDelMes = new float[12];

        String mesConMasGanancias = "";
        gananaciasDelMes[0] = obtenerGananciasDelMes(datosTabla, enero);
        gananaciasDelMes[1] = obtenerGananciasDelMes(datosTabla, febrero);
        gananaciasDelMes[2] = obtenerGananciasDelMes(datosTabla, marzo);
        gananaciasDelMes[3] = obtenerGananciasDelMes(datosTabla, abril);
        gananaciasDelMes[4] = obtenerGananciasDelMes(datosTabla, mayo);
        gananaciasDelMes[5] = obtenerGananciasDelMes(datosTabla, junio);
        gananaciasDelMes[6] = obtenerGananciasDelMes(datosTabla, julio);
        gananaciasDelMes[7] = obtenerGananciasDelMes(datosTabla, agosto);
        gananaciasDelMes[8] = obtenerGananciasDelMes(datosTabla, septiembre);
        gananaciasDelMes[9] = obtenerGananciasDelMes(datosTabla, octubre);
        gananaciasDelMes[10] = obtenerGananciasDelMes(datosTabla, noviembre);
        gananaciasDelMes[11] = obtenerGananciasDelMes(datosTabla, diciembre);

        float gananciaMayor = obtenerGananciaMayor(gananaciasDelMes);

        for (int numeroDeMes = 0; numeroDeMes < 12; numeroDeMes++) {
            if (gananciaMayor == gananaciasDelMes[numeroDeMes]) {
                mesConMasGanancias = obtenerMesPorNumero(numeroDeMes + 1);
            }
        }

        return mesConMasGanancias;
    }

    /**
     * Calcula el mes con menos ganancias
     *
     * @param datosTabla es el modelo de la tabla que contiene los datos que se
     * usaran en el calculo
     * @return el mes con menos ganancias
     */
    public String CalcularMesConMenosGanancias(DefaultTableModel datosTabla) {

        float[] gananciasDelmes = new float[12];
        String mesConMenosGanancias = "";
        gananciasDelmes[0] = obtenerGananciasDelMes(datosTabla, enero);
        gananciasDelmes[1] = obtenerGananciasDelMes(datosTabla, febrero);
        gananciasDelmes[2] = obtenerGananciasDelMes(datosTabla, marzo);
        gananciasDelmes[3] = obtenerGananciasDelMes(datosTabla, abril);
        gananciasDelmes[4] = obtenerGananciasDelMes(datosTabla, mayo);
        gananciasDelmes[5] = obtenerGananciasDelMes(datosTabla, junio);
        gananciasDelmes[6] = obtenerGananciasDelMes(datosTabla, julio);
        gananciasDelmes[7] = obtenerGananciasDelMes(datosTabla, agosto);
        gananciasDelmes[8] = obtenerGananciasDelMes(datosTabla, septiembre);
        gananciasDelmes[9] = obtenerGananciasDelMes(datosTabla, octubre);
        gananciasDelmes[10] = obtenerGananciasDelMes(datosTabla, noviembre);
        gananciasDelmes[11] = obtenerGananciasDelMes(datosTabla, diciembre);

        float gananciaMenor = obtenerGananciaMenor(gananciasDelmes);

        for (int numeroDeMes = 0; numeroDeMes < 12; numeroDeMes++) {
            if (gananciaMenor == gananciasDelmes[numeroDeMes]) {
                mesConMenosGanancias = obtenerMesPorNumero(numeroDeMes + 1);
            }
        }

        return mesConMenosGanancias;
    }

    /**
     * Obtiene el mes dependiendo del numero que se le pase (1-12)
     *
     * @param numeroDeMes es el mes que se desea obtener
     * @return el mes correspondiente al numero de este
     */
    private String obtenerMesPorNumero(int numeroDeMes) {
        switch (numeroDeMes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "";
        }
    }

    /**
     * Obtiene la ganancia mas grande de todos los meses
     *
     * @param ganancias son las ganancias de todos los meses
     * @return la mayor ganancia
     */
    private float obtenerGananciaMayor(float[] ganancias) {
        float gananciaMayor = ganancias[0];

        for (int numeroDeGanancia = 1; numeroDeGanancia < ganancias.length; numeroDeGanancia++) {
            if (ganancias[numeroDeGanancia] > gananciaMayor) {
                gananciaMayor = ganancias[numeroDeGanancia];
            }
        }
        return gananciaMayor;
    }

    /**
     * Obtiene la ganancia mas pequeña de todos los meses
     *
     * @param ganancias son las ganancias de todos los meses
     * @return la menor ganancia
     */
    private float obtenerGananciaMenor(float[] ganancias) {
        boolean sinGanancia = true;
        float gananciaMenor = -1;
        for (int numeroDeGanancia = 0; numeroDeGanancia < ganancias.length; numeroDeGanancia++) {
            if (ganancias[numeroDeGanancia] != 0) {
                if (sinGanancia) {
                    gananciaMenor = ganancias[numeroDeGanancia];
                    sinGanancia = false;
                }else {
                    if (gananciaMenor > ganancias[numeroDeGanancia]) {
                        gananciaMenor = ganancias[numeroDeGanancia];
                    }
                }
            }

        }
        return gananciaMenor;
    }

    /**
     * Obtiene las ganancias de un mes específico
     *
     * @param datosTabla es el modelo de la tabla que contiene los datos de
     * donde se obtendra la ganancia del mes
     * @param mes es el numero del mes que se quieren sus ganancias
     * @return las ganancia total de ese mes
     */
    private float obtenerGananciasDelMes(DefaultTableModel datosTabla, int mes) {
        float gananciaTotalDelMes = 0;
        int numeroDeFilas = datosTabla.getRowCount();
        for (int indice = 0; indice < numeroDeFilas; indice++) {
            String fecha = (String) datosTabla.getValueAt(indice, 1).toString();
            StringTokenizer separa = new StringTokenizer(fecha, "-");
            separa.nextToken();
            int mesAcomparar = Integer.parseInt(separa.nextToken());
            if (mes == mesAcomparar) {
                float gananciaDelEvento = (float) datosTabla.getValueAt(indice, 2);
                gananciaTotalDelMes = gananciaTotalDelMes + gananciaDelEvento;
            }
        }

        return gananciaTotalDelMes;
    }

    /**
     * Genera el reporte en base a los datos que se obtienen de la vista
     *
     * @param modeloConDatos es el modelo donde se encuentra la informacion
     * @param mejorMes es el dato del mejor mes
     * @param peorMes es el dato del peor mes
     * @param gananciaTotal es el dato de la ganancia total
     * @return si se genera correctamente el reporte (true)
     */
    public boolean generaReporte(TableModel modeloConDatos, String mejorMes, String peorMes, String gananciaTotal) {
        boolean exportadoCorrectamente = false;
        FileOutputStream out = null;
        try {
            // TODO add your handling code here:

            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet("Reporte Completo");

            DefaultTableModel modelo = (DefaultTableModel) modeloConDatos;
            exportadoCorrectamente = llenarDatosDeReporte(sheet, modelo, mejorMes, peorMes, gananciaTotal);

            out = new FileOutputStream("ReporteGanancias.xls");
            wb.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VtnReporGanancias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VtnReporGanancias.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exportadoCorrectamente;

    }

    /**
     * Llena todos los datos que tendra el reporte
     *
     * @param sheet la hoja del excel que tendra los datos
     * @param tableModel el modelo de la vista que tiene los datos
     * @param mejorMes el dato del mejor mes
     * @param peorMes el dato del peor mes
     * @param gananciaTotal el dato de la ganancia total
     * @return si se lleno el reporte de manera correcta
     */
    private boolean llenarDatosDeReporte(Sheet sheet, DefaultTableModel tableModel, String mejorMes, String peorMes, String gananciaTotal) {
        boolean pobladoCorrectamente = false;
        crearTitulo(sheet);
        crearEncabezados(sheet, tableModel);
        llenarExcelDeDatos(sheet, tableModel, mejorMes, peorMes, gananciaTotal);
        pobladoCorrectamente = true;

        return pobladoCorrectamente;
    }

    /**
     * Llena los datos del excel
     *
     * @param sheet es la hoja de excel que se llenara
     * @param tableModel es el modelo de la vista que tiene los datos
     * @param mejorMes el dato del mejor mes
     * @param peorMes el dato del peor mes
     * @param gananciaTotal el dato de la ganancia total
     */
    private void llenarExcelDeDatos(Sheet sheet, TableModel tableModel, String mejorMes, String peorMes, String gananciaTotal) {
        Row filaDatosDeLista;
        Cell celdaDatosDelista;
        int filaDeDatosDeLista = 2;
        int numeroDeFilas = tableModel.getRowCount();
        int numeroDeColumnas = tableModel.getColumnCount();
        for (int fila = 1; fila < numeroDeFilas + 1; fila++) {
            filaDatosDeLista = sheet.createRow(filaDeDatosDeLista);
            
            for (int j = 0; j < numeroDeColumnas; j++) {
                celdaDatosDelista = filaDatosDeLista.createCell(j);
                String dinero = (j > 1) ? "$" : "";
                celdaDatosDelista.setCellValue(dinero + String.valueOf(tableModel.getValueAt(fila - 1, j)));
            }
            filaDeDatosDeLista++;
        }

        Row filaDeMejorMes = sheet.createRow(tableModel.getRowCount() + 3);
        Row filaDePeorMes = sheet.createRow(tableModel.getRowCount() + 4);
        Row filaDeGananciaTotal = sheet.createRow(tableModel.getRowCount() + 6);

        Cell celdaDeDescripcion = filaDeMejorMes.createCell(1);
        Cell celdaDeMejorMes = filaDeMejorMes.createCell(2);
        Cell celdaDePeorMes = filaDePeorMes.createCell(2);
        Cell celdaDeGananciaTotal = filaDeGananciaTotal.createCell(2);

        celdaDeDescripcion = filaDeMejorMes.createCell(1);
        celdaDeDescripcion.setCellValue("Mejor Mes:");
        celdaDeMejorMes.setCellValue(mejorMes);

        celdaDeDescripcion = filaDePeorMes.createCell(1);
        celdaDeDescripcion.setCellValue("Peor Mes:");
        celdaDePeorMes.setCellValue(peorMes);

        celdaDeDescripcion = filaDeGananciaTotal.createCell(0);
        celdaDeDescripcion.setCellValue("Ganancia Total:");
        celdaDeGananciaTotal.setCellValue(gananciaTotal);

    }

    /**
     * Crea el título reporte
     *
     * @param sheet es la hoja de excel donde se establecerá el título
     */
    private void crearTitulo(Sheet sheet) {
        Row filaDelTitulo = sheet.createRow(0);
        Cell celdaDelTitulo = filaDelTitulo.createCell(0);

        celdaDelTitulo.setCellValue("Reporte Completo");

    }

    /**
     * Crea los encabezados del
     *
     * @param sheet
     * @param tableModel
     */
    private void crearEncabezados(Sheet sheet, TableModel tableModel) {

        Row filaDeEncabezadosDeLista = sheet.createRow(1);
        Cell celdaDeEncabezadosDeLista = null;
        int numeroDeColumnas = tableModel.getColumnCount();
        
        for (int columna = 0; columna < numeroDeColumnas; columna++) {
            celdaDeEncabezadosDeLista = filaDeEncabezadosDeLista.createCell(columna);
            celdaDeEncabezadosDeLista.setCellValue(tableModel.getColumnName(columna));
        }
    }
}
