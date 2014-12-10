/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.DAOClientes;
import Modelo.Cliente;
import Modelo.Persona;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 * Clase encargada de la lógica de negocios referente a los clientes.
 *
 * @author Alejandro
 */
public class ControladorCliente implements ControladorPersona {

    DAOClientes dao = new DAOClientes();

    /**
     * Método encargado de agregar la información de un objeto Cliente a la BD.
     *
     * @param cliente es el objeto con la información a ser guardada en la BD.
     * @return verdadero o falso, dependiendo de si se pudo o no agregar la
     * información a la BD.
     * @throws SQLException en caso de la conexión con la BD no haya podido ser
     * establecida.
     */
    @Override
    public boolean agregar(Persona cliente) throws SQLException {

        return dao.agregarElementoATabla(cliente);

    }

    /**
     * Busca en la BD la tupla que coincida con el identificador que se le pasa
     * y devuelve toda la información de la tupla que está almacenada en la BD.
     *
     * @param idCliente es el identificador del objeto a ser encontrado en la
     * BD.
     * @return el objeto Cliente con la información Correspondiente.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    public Cliente obtenerClientePorID(int idCliente) throws SQLException {
        return dao.obtenerElementoPorID(idCliente);
    }

    /**
     * Método que elimina la información de un cliente que está almacenado en la
     * BD.
     *
     * @param IdCliente Es el identificador del cliente que se eliminará.
     * @return verdader o falso, dependiendo de si se agrega o no a la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    @Override
    public boolean eliminar(int IdCliente) throws SQLException {

        return dao.eliminarElementoPorID(IdCliente);

    }

    /**
     * Método que obtiene la información de varios clientes en la BD que
     * coincidan con el nombre.
     *
     * @param nombrePersona que será buscado en la BD.
     * @return una lista con la información de los objetos que coincidan en la
     * BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    @Override
    public LinkedList obtenerCoincidenciasPorNombre(String nombrePersona) throws SQLException {

        return dao.obtenerCoincidenciasDeBD(nombrePersona);
    }

    /**
     * Busca la información de los clientes en la BD y devuelve un objeto con la
     * información del cliente que coincida con el nombre en la BD.
     *
     * @param nombrePersona a buscar en la BD.
     * @return el objeto de tipo Cliente con la información almacenada en la BD.
     * @throws SQLException en caso de que no se establezca la conexión con la
     * BD.
     */
    @Override
    public Cliente obtenerPersonaPorNombre(String nombrePersona) throws SQLException {

        return dao.obtenerElementoPorNombre(nombrePersona);

    }

    /**
     * Función que actualiza la información de un cliente en la base de datos.
     *
     * @param persona que es el objeto cliente con las modificaciones ya hechas.
     * @return verdadero o falso, dependiendo de si se pudo modificarElemento la
     * información o no.
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     *
     */
    @Override
    public boolean modificar(Persona persona) throws SQLException {

        return dao.modificarElemento(persona);
    }

    /**
     * Función que obtiene la información de todos los clientes que se
     * encuentran en la BD.
     *
     * @return la lista con los objetos de los clientes encontrados en la BD.
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     *
     */
    public LinkedList obtenerTodosLosClientes() throws SQLException {

        return dao.obtenerTodosLosElementosDeTabla();

    }

    public DefaultTableModel obtenerModeloConDatosDeClientes(DefaultTableModel modeloTabla, String nombreCliente) throws SQLException {
        LinkedList<Cliente> listaDeClientes = obtenerCoincidenciasPorNombre(nombreCliente);

        DefaultTableModel modeloConDatos = llenarListaConDatos(modeloTabla, listaDeClientes);

        return modeloConDatos;
    }

    private DefaultTableModel llenarListaConDatos(DefaultTableModel modeloTabla, LinkedList<Cliente> listaDeClientes) {
        //Declaramos las columnas:
        Object columnasDeDatos[] = new Object[5];

        if (listaDeClientes != null) {
            //agregamos a cada columna los datos que le corresponden:
            for (Cliente cliente : listaDeClientes) {
                columnasDeDatos[0] = cliente.getIdPersona();
                columnasDeDatos[1] = cliente.getNombrePersona();
                columnasDeDatos[2] = cliente.getDireccionPersona();
                columnasDeDatos[3] = cliente.getTelefonoPersona();
                columnasDeDatos[4] = cliente.getCorreoPersona();

                //agregamos los datos de cada columna en cada renglón:
                modeloTabla.addRow(columnasDeDatos);
            }
        }//se considera el else pero no es necesario                                           
        return modeloTabla;
    }
}
