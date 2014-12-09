/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Carlos
 */
public interface ControladorPersona {

    /**
     * Método encargado de agregar la información de un objeto persona en la BD.
     *
     * @param persona es el objeto a ser almacenado en la BD.
     * @return verdadero o falso dependiendo de si se pudo o no agregar a la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public boolean agregar(Persona persona) throws SQLException;

    /**
     * Elimina la información de un objeto Persona en la BD, a partir del
     * identificador que se le pase.
     *
     * @param idPersona es el identificador del objeto a ser eliminado de la BD.
     * @return verdadero o falso dependiendo de si se pudo o no eliminar de la
     * BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public boolean eliminar(int idPersona) throws SQLException;

    /**
     * Busca en la BD los objetos que coincidan con el nombre que se le pase,
     * para devolver una lista con la información de dichos objetos.
     *
     * @param nombrePersona a buscar en la BD.
     * @return lista de objetos que coinciden con el nombre de la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public LinkedList obtenerCoincidenciasPorNombre(String nombrePersona) throws SQLException;

    /**
     * Busca en la BD el objeto que coincida con el nombre que se le pase, para
     * devolver la información de la BD.
     *
     * @param nombrePersona a buscar en la BD.
     * @return objeto con la información de la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public Persona obtenerPersonaPorNombre(String nombrePersona) throws SQLException;

    /**
     * Función que actualiza la información de un objeto Persona en la base de
     * datos.
     *
     * @param persona que es el objeto Persona con las modificaciones ya hechas.
     * @return verdadero o falso, dependiendo de si se pudo modificarElemento la
     * información o no.
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     *
     */
    public boolean modificar(Persona persona) throws SQLException;
}
