/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.DAOServicios;
import Modelo.Servicio;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class ControladorServicios {

    DAOServicios dao;

    /**
     * Inicializa un nuevo objeto con el Dao del servicio, para poder manipular
     * la información que se necesite.
     */
    public ControladorServicios() {
        dao = new DAOServicios();
    }

    /**
     * Método encargado de pedirle al Dao de servicio, que devuelva la
     * información de un servicio asociado a un nombre.
     *
     * @param nombreServicio del servicio a encontrar en la BD.
     * @return un Objeto de tipo servicio, con la información de la BD
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public Servicio obtenerServicioPorNombre(String nombreServicio) throws SQLException {

        return dao.encontrarServicioPorNombre(nombreServicio);

    }

    /**
     * Método encargado de encontrar en la BD la información de un servicio
     * asociado a un identificador único.
     *
     * @param idServicio es el identificador del servicio a encontrar (int).
     * @return el objeto de tipo servicio con la información de la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public Servicio obtenerServicioPorID(int idServicio) throws SQLException {

        return dao.encontrarServicioPorID(idServicio);

    }

}
