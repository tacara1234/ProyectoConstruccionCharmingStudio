package Controlador.DAO;

import Modelo.EventosSociales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:36:23 p.m.
 */
public class DAOEventos {

    Connection Conexion;

    public DAOEventos() {
        try {
            Conexion = ConexionBaseDatos.getInstancia().getConexionBD();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param eventoA_Guardar
     * @throws java.sql.SQLException
     */
    public void agregarEvento(EventosSociales eventoA_Guardar) throws SQLException {

    }

    /**
     * Agrega un nuevo evento a la tabla de eventos.
     *
     * @param idCliente
     * @param idMesasDulces
     * @param Fecha
     * @param PrecioTotal
     * @param idEmpleado
     * @param idPaquetes
     * @param idProveedor
     * @param idServicios
     * @return
     * @throws SQLException
     */
    //claveCliente, claveMesaDulces, fechaEvento,precioEvento, claveEmpleado
    public int agregarElementoA_TablaEventoSocial(int idCliente, int idMesasDulces, String Fecha,
            float PrecioTotal, int idEmpleado) throws SQLException {

        Statement sentenciaDeInsercion = Conexion.createStatement();

        //boolean seAgregoElemento = 
        sentenciaDeInsercion.execute("INSERT INTO charmingstudio.eventos "
                + "(`idCliente`,`idMesaDulces`,`Fecha`,`PrecioTotal`,`idEmpleado`)"
                + "VALUES("
                + "'" + idCliente + "',"
                + "'" + idMesasDulces + "',"
                + "'" + Fecha + "',"
                + "'" + PrecioTotal + "',"
                + "'" + idEmpleado + "')");

        int id = obtenerIdEvento(idCliente, idMesasDulces, PrecioTotal, idEmpleado, Fecha);

        return id;
    }
    private static final int columnaId = 1;
    private static final int columnaIdCliente = 2;
    private static final int columnaIdMD = 3;
    private static final int columnaFecha = 4;
    private static final int columnaPrecioTotal = 5;
    private static final int columnaIdEmpleado = 6;

    public LinkedList obtenerTodosLosEventos() throws SQLException {

        Statement sentenciaDeBusquedaDeEventos = Conexion.createStatement();
        ResultSet BusquedaDeEventos = sentenciaDeBusquedaDeEventos.
                executeQuery("SELECT *  FROM charmingstudio.eventos");

        if (BusquedaDeEventos.wasNull()) {
            return null;
        }

        LinkedList<EventosSociales> eventos = new LinkedList<>();

        while (BusquedaDeEventos.next()) {

            //agregamos c/evento a la lista:
            eventos.add(new EventosSociales(BusquedaDeEventos.getInt(columnaId),
                    BusquedaDeEventos.getInt(columnaIdCliente),
                    BusquedaDeEventos.getInt(columnaIdMD),
                    BusquedaDeEventos.getDate(columnaFecha),
                    BusquedaDeEventos.getFloat(columnaPrecioTotal),
                    BusquedaDeEventos.getInt(columnaIdEmpleado)));
            //System.out.println("precio " + BusquedaDeEventos.getFloat(columnaPrecioTotal));
        }
        return eventos;

    }

    private int obtenerIdEvento(int idCliente, int idMesasDulces,
            float PrecioTotal, int idEmpleado, String strFecha) throws SQLException {

        Statement sentenciaDeInsercion = Conexion.createStatement();

        ResultSet id = sentenciaDeInsercion.executeQuery("SELECT * FROM charmingstudio.eventos WHERE "
                + "`idCliente` = " + idCliente
                + " AND `idMesaDulces` = " + idMesasDulces
                + " AND `PrecioTotal`= " + PrecioTotal
                + " AND `idEmpleado` = " + idEmpleado
                + " AND `Fecha`= '" + strFecha + "'");
        /**
         * SELECT * FROM charmingstudio.eventos WHERE `idCliente` = 1 AND
         * `idMesaDulces` = 1 AND `PrecioTotal`= 5700 AND `idEmpleado` = 1 AND
         * `Fecha` = '2014-11-27'
         *
         */

        id.next();
        System.out.println("El id es: "+id.getInt("idEvento"));

        return id.getInt("idEvento");
    }

    /**
     *
     * @param fecha
     * @param nombreEvento
     * @return
     */
    
    public boolean eliminarEvento(int idEvento) throws SQLException {
        boolean seEliminoEvento = false;
        Statement sentenciaEliminaEvento = Conexion.createStatement();
        sentenciaEliminaEvento.executeUpdate("DELETE FROM "
                + "charmingstudio.eventos WHERE idEvento= '" + idEvento + "'");

        seEliminoEvento = true;

        return seEliminoEvento;
    
    }
    

    /**
     *
     * @param fecha
     * @return
     */
    public EventosSociales buscarEventos(Date fecha) {
        return null;
    }

    /**
     *
     * @param fecha
     * @param nombreCliente
     * @return
     */
    public boolean modificarEvento(Date fecha, String nombreCliente) {
        return false;
    }

    public float calculaPrecioTotal(EventosSociales evento) throws SQLException {
        float precioTotal = 0;

        precioTotal = precioTotal + evento.getPrecioTotal();
        return precioTotal;
    }
    
}
