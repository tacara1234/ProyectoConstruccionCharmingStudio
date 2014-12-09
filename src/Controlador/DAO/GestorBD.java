package Controlador.DAO;

import Modelo.Persona;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Clase encargada de proporcionar los métodos comunes a todos los DAOs
 * encargados de la conexión con la BD.
 *
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:33:52 p.m.
 */
public abstract class GestorBD {

    protected ConexionBaseDatos BaseDeDatos;

    /**
     * Este método agrega un nuevo objeto de tipo Persona a la Base de Datos.
     *
     * @param persona es el objeto que tiene toda la información a ser
     * almacenada en la BD.
     * @return verdadero o falso, dependiendo de si pudo agregar (o no) el
     * elemento a la BD.
     * @throws java.sql.SQLException en caso de que no se haya podido conectar a
     * la BD.
     */
    public abstract boolean agregarElementoATabla(Persona persona) throws SQLException;

    /**
     * Elimina la información de un elemento Persona en la BD, a partir del
     * Identificador único que se le pase.
     *
     * @param idPersona identificador de la tupla en la BD que se desea
     * eliminar.
     * @return verdadero o falso, dependiendo de si se pudo o no eliminar la
     * información de la BD.
     * @throws java.sql.SQLException en caso de algún error con la conexión en
     * la BD.
     */
    public abstract boolean eliminarElementoPorID(int idPersona) throws SQLException;

    /**
     * Metodo encargado de buscar las tuplas que coincidan con la columna de
     * nombre de las tablas de las que se derivan los objetos Persona.
     *
     * @param nombrePersona es el nombre que se buscará en la BD para obtener
     * todas las tuplas que coincidan.
     * @return Una lista simple con la información de los Objetos que
     * coincidieron en la BD.
     * @throws java.sql.SQLException en caso de algún error con la Conexión de
     * la BD.
     */
    public abstract LinkedList obtenerCoincidenciasDeBD(String nombrePersona) throws SQLException;

    /**
     * Este método modifica la información que hay en la BD sobre algún objeto
     * de tipo Persona.
     *
     * @param persona es el objeto que tiene toda la NUEVA información a ser
     * almacenada en la BD.
     * @return verdadero o falso, dependiendo de si pudo agregar (o no) el
     * elemento a la BD.
     * @throws java.sql.SQLException en caso de que no se haya podido conectar a
     * la BD.
     */
    public abstract boolean modificarElemento(Persona persona) throws SQLException;

}
