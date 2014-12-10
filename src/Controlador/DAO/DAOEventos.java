package Controlador.DAO;

import Modelo.EventosSociales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:36:23 p.m.
 */
public class DAOEventos {

    Connection Conexion;

    /**
     * Inicia una nueva conexión con la BD.
     */
    public DAOEventos() {
        try {
            Conexion = ConexionBaseDatos.getInstancia().getConexionBD();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Agrega la información de un nuevo evento, a la tabla de eventos en la BD y devuelve el ID
     * que el sistema manejador de la BD le asignó.
     *
     * @param idCliente es el identificador del cliente asociado al evento.
     * @param idMesasDulces es el identificador de la mesa de dulces que será
     * servida el día del evento.
     * @param Fecha es la fecha en que se llevará a cabo dicho evento
     * @param PrecioTotal es el precio total a cobrar por el evento.
     * @param idEmpleado es el identificador del empleado responsable a llevar a
     * cabo dicho evento.
     * @return el identificador del elemento agregado a la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public int agregarElementoA_TablaEventoSocial(int idCliente, int idMesasDulces, String Fecha,
            float PrecioTotal, int idEmpleado) throws SQLException {

        Statement sentenciaDeInsercion = Conexion.createStatement();
        sentenciaDeInsercion.execute("INSERT INTO charmingstudio.eventos "
                + "(`idCliente`,`idMesaDulces`,`Fecha`,`PrecioTotal`,`idEmpleado`)"
                + "VALUES("
                + "'" + idCliente + "',"
                + "'" + idMesasDulces + "',"
                + "'" + Fecha + "',"
                + "'" + PrecioTotal + "',"
                + "'" + idEmpleado + "')");

        int idEvento = obtenerID_Evento(idCliente, idMesasDulces, PrecioTotal, idEmpleado, Fecha);

        return idEvento;
    }
    private static final int columnaId = 1;
    private static final int columnaIdCliente = 2;
    private static final int columnaIdMD = 3;
    private static final int columnaFecha = 4;
    private static final int columnaPrecioTotal = 5;
    private static final int columnaIdEmpleado = 6;

    /**
     * Método encargado de devolver la información de todos los eventos que se
     * encuentran en la BD.
     *
     * @return una lista con los objetos eventos encontrados en la BD
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
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
                    BusquedaDeEventos.getString(columnaFecha),
                    BusquedaDeEventos.getFloat(columnaPrecioTotal),
                    BusquedaDeEventos.getInt(columnaIdEmpleado)));
        }
        return eventos;

    }

    private int obtenerID_Evento(int idCliente, int idMesasDulces,
            float PrecioTotal, int idEmpleado, String strFecha) throws SQLException {

        Statement sentenciaDeInsercion = Conexion.createStatement();

        ResultSet resultadoBusquedaID = sentenciaDeInsercion.executeQuery("SELECT * FROM charmingstudio.eventos WHERE "
                + "`idCliente` = " + idCliente
                + " AND `idMesaDulces` = " + idMesasDulces
                + " AND `PrecioTotal`= " + PrecioTotal
                + " AND `idEmpleado` = " + idEmpleado
                + " AND `Fecha`= '" + strFecha + "'");

        resultadoBusquedaID.next();
        return resultadoBusquedaID.getInt("idEvento");
    }

    /**
     * Método encargado de eliminar la información de un evento almacenado en la
     * BD.
     *
     * @param idEvento es el identificador del evento a eliminar.
     * @return verdadero o falso, dependiendo de si se pudo eliminar o no la
     * información de la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public boolean eliminarEvento(int idEvento) throws SQLException {
        boolean seEliminoEvento = false;
        Statement sentenciaEliminaEvento = Conexion.createStatement();
        sentenciaEliminaEvento.executeUpdate("DELETE FROM "
                + "charmingstudio.eventos WHERE idEvento= '" + idEvento + "'");
        //si llega hasta aquí, entonces si se eliminó el evento.
        seEliminoEvento = true;

        return seEliminoEvento;

    }
}
