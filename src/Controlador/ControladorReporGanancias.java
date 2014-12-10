package Controlador;

import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

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
        for (int indice = 0; indice < datosTabla.getRowCount(); indice++) {

            gananciasTotales = gananciasTotales + (float) datosTabla.getValueAt(indice, 2);
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

        for (int i = 0; i < 12; i++) {
            if (gananciaMayor == gananaciasDelMes[i]) {
                mesConMasGanancias = obtenerMesPorNumero(i + 1);
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
        //datosTabla.getValueAt(i, 1);
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
        //System.out.println("ventas dic" + diciembreVentas);

        float gananciaMenor = obtenerGananciaMenor(gananciasDelmes);

        for (int i = 0; i < 12; i++) {
            if (gananciaMenor == gananciasDelmes[i]) {
                mesConMenosGanancias = obtenerMesPorNumero(i + 1);
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
        //float resultado = 0;
        for (int i = 1; i < ganancias.length; i++) {
            if (ganancias[i] > gananciaMayor) {
                gananciaMayor = ganancias[i];
            }
        }
        return gananciaMayor;
    }

    /**
     * Obtiene la ganancia mas pequeña de todos los meses
     *
     * @param ganancias on las ganancias de todos los meses
     * @return la menor ganancia
     */
    private float obtenerGananciaMenor(float[] ganancias) {
        boolean band = false;
        float gananciaMenor = -1;        //float resultado = 0;
        for (int i = 0; i < ganancias.length; i++) {
            if (ganancias[i] == 0) {

            } else {
                if (band == false) {
                    gananciaMenor = ganancias[i];
                    band = true;
                } else {
                    if (gananciaMenor > ganancias[i]) {
                        gananciaMenor = ganancias[i];
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
        //DefaultTableModel datosTabla = (DefaultTableModel) this.listaEventos.getModel();
        float gananciaTotalDelMes = 0;
        for (int indice = 0; indice < datosTabla.getRowCount(); indice++) {
            StringTokenizer token = new StringTokenizer((String) datosTabla.getValueAt(indice, 1).toString(), "-");
            token.nextToken();
            int mesAcomparar = Integer.parseInt(token.nextToken());
            if (mes == mesAcomparar) {
                gananciaTotalDelMes = gananciaTotalDelMes + (float) datosTabla.getValueAt(indice, 2);
            }
        }

        return gananciaTotalDelMes;
    }

}
