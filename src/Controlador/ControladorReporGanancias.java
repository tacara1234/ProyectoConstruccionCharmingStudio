package Controlador;

import static java.sql.JDBCType.DATE;
import static java.util.Calendar.DATE;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:35:55 p.m.
 */
public class ControladorReporGanancias implements AdministraReportes {

    private Date fecha;

    public ControladorReporGanancias() {

    }

    @Override
    public Object generaReportes() {
        return null;
    }

    /**
     *
     * @param vector
     * @return
     */
    @Override
    public boolean exportaReportes(Object vector) {
        return false;
    }

    public float calcularMontoTotal(DefaultTableModel datosTabla) {
        float montoTotal = 0;
        //DefaultTableModel datosTabla = (DefaultTableModel) this.listaEventos.getModel();
        //System.out.println("row count " + datosTabla.getRowCount());
        //System.out.println("Va a entrar");
        for (int indice = 0; indice < datosTabla.getRowCount(); indice++) {

            montoTotal = montoTotal + (float) datosTabla.getValueAt(indice, 2);
        }
        return montoTotal;
    }

    public String CalcularMesConMasVentas(DefaultTableModel datosTabla) {
        int enero = 1;
        int febrero = 2;
        int marzo = 3;
        int abril = 4;
        int mayo = 5;
        int junio = 6;
        int julio = 7;
        int agosto = 8;
        int septiembre = 9;
        int octubre = 10;
        int noviembre = 11;
        int diciembre = 12;

        float[] ventasDelmes = new float[12];

        String mesConMasVentas = "";
        ventasDelmes[0] = obtenerVentasDelMes(datosTabla, enero);
        ventasDelmes[1] = obtenerVentasDelMes(datosTabla, febrero);
        ventasDelmes[2] = obtenerVentasDelMes(datosTabla, marzo);
        ventasDelmes[3] = obtenerVentasDelMes(datosTabla, abril);
        ventasDelmes[4] = obtenerVentasDelMes(datosTabla, mayo);
        ventasDelmes[5] = obtenerVentasDelMes(datosTabla, junio);
        ventasDelmes[6] = obtenerVentasDelMes(datosTabla, julio);
        ventasDelmes[7] = obtenerVentasDelMes(datosTabla, agosto);
        ventasDelmes[8] = obtenerVentasDelMes(datosTabla, septiembre);
        ventasDelmes[9] = obtenerVentasDelMes(datosTabla, octubre);
        ventasDelmes[10] = obtenerVentasDelMes(datosTabla, noviembre);
        ventasDelmes[11] = obtenerVentasDelMes(datosTabla, diciembre);
        //System.out.println("ventas dic" + diciembreVentas);

        float gananciaMayor = obtenerGananciaMayor(ventasDelmes);

        for (int i = 0; i < 12; i++) {
            if (gananciaMayor == ventasDelmes[i]) {
                mesConMasVentas = obtenerMesPorNumero(i + 1);
            }
        }

        return mesConMasVentas;
    }

    public String CalcularMesConMenosVentas(DefaultTableModel datosTabla) {
        int enero = 1;
        int febrero = 2;
        int marzo = 3;
        int abril = 4;
        int mayo = 5;
        int junio = 6;
        int julio = 7;
        int agosto = 8;
        int septiembre = 9;
        int octubre = 10;
        int noviembre = 11;
        int diciembre = 12;

        float[] ventasDelmes = new float[12];

        String mesConMenosVentas = "";
        ventasDelmes[0] = obtenerVentasDelMes(datosTabla, enero);
        ventasDelmes[1] = obtenerVentasDelMes(datosTabla, febrero);
        ventasDelmes[2] = obtenerVentasDelMes(datosTabla, marzo);
        ventasDelmes[3] = obtenerVentasDelMes(datosTabla, abril);
        ventasDelmes[4] = obtenerVentasDelMes(datosTabla, mayo);
        ventasDelmes[5] = obtenerVentasDelMes(datosTabla, junio);
        ventasDelmes[6] = obtenerVentasDelMes(datosTabla, julio);
        ventasDelmes[7] = obtenerVentasDelMes(datosTabla, agosto);
        ventasDelmes[8] = obtenerVentasDelMes(datosTabla, septiembre);
        ventasDelmes[9] = obtenerVentasDelMes(datosTabla, octubre);
        ventasDelmes[10] = obtenerVentasDelMes(datosTabla, noviembre);
        ventasDelmes[11] = obtenerVentasDelMes(datosTabla, diciembre);
        //System.out.println("ventas dic" + diciembreVentas);

        float gananciaMenor = obtenerGananciaMenor(ventasDelmes);

        for (int i = 0; i < 12; i++) {
            if (gananciaMenor == ventasDelmes[i]) {
                mesConMenosVentas = obtenerMesPorNumero(i + 1);
            }
        }

        return mesConMenosVentas;
    }

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

    private float obtenerGananciaMenor(float[] ganancias) {
        float gananciaMenor = ganancias[0];
        //float resultado = 0;
        for (int i = 1; i < ganancias.length; i++) {
            if (ganancias[i] < gananciaMenor) {
                gananciaMenor = ganancias[i];
            }
        }
        return gananciaMenor;
    }

    private float obtenerVentasDelMes(DefaultTableModel datosTabla, int mes) {
        //DefaultTableModel datosTabla = (DefaultTableModel) this.listaEventos.getModel();
        float totalVentaDelMes = 0;
        for (int indice = 0; indice < datosTabla.getRowCount(); indice++) {
            StringTokenizer token = new StringTokenizer((String) datosTabla.getValueAt(indice, 1).toString(), "-");
            token.nextToken();
            int mesAcomparar = Integer.parseInt(token.nextToken());
            if (mes == mesAcomparar) {
                totalVentaDelMes = totalVentaDelMes + (float) datosTabla.getValueAt(indice, 2);
            }
        }

        return totalVentaDelMes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
