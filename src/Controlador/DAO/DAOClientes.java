package Controlador.DAO;

import Modelo.Persona;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Clase encargada de hacer la conexión con la Base de datos y manipular las
 * tablas correspondientes a los clientes.
 *
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:34:05 p.m.
 */
public class DAOClientes extends GestorBD {

    private Connection Conexion;

    /**
     * Crea una nueva instancia de esta clase, y a su vez una nueva conexión con
     * la Base de datos.
     */
    @SuppressWarnings({"static-access", "static-access"})
    public DAOClientes() {
        try {
            Conexion = BaseDeDatos.getInstancia().getConexionBD();
        } catch (SQLException ex) {
        }
    }

    /**
     * Este método se encarga de agregar un Elemento A la Tabla cliente en la
     * base de datos.
     *
     * @return verdadero o falso, dependiendo de si se pudo agregar el Elemento
     * o no a la base de datos.
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     * datos.
     */
    @Override
    public boolean agregarElementoATabla(Persona persona) throws SQLException {

        Cliente cliente = (Cliente) persona;
        Statement sentencia = Conexion.createStatement();
        boolean seAgregoCliente = false;
        if (!comprobarExistenciaElemento(cliente)) {
            sentencia.executeUpdate("INSERT INTO charmingstudio.cliente (`Nombre`, "
                    + "`Direccion`, `Telefono`, `Correo`)" + "VALUES("
                    + "'" + cliente.getNombrePersona() + "',"
                    + "'" + cliente.getDireccionPersona() + "',"
                    + "'" + cliente.getTelefonoPersona() + "',"
                    + "'" + cliente.getCorreoPersona() + "')");
            seAgregoCliente = true;
        }
        return seAgregoCliente;
    }

    /**
     * Método que se encarga de verificar si un objeto persona está en la base
     * de datos; regresa un booleano que está en verdadero cuando dicho cliente
     * está en la BD o un falso cuando no se encuentra en la BD.
     *
     * @param cliente es el objeto a comprobar su existencia en la BD.
     * @return verdadero o falso, dependiendo si dicha información se encuentra
     * almacenada en la BD.
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     */
    private boolean comprobarExistenciaElemento(Cliente cliente) throws SQLException {

        LinkedList<Cliente> listaDeClientes = obtenerCoincidenciasDeBD(cliente.getNombrePersona());
        boolean existeUsuario = false;

        if (listaDeClientes == null) {
            return existeUsuario;
        }

        //entonces la lista no es nula:
        for (Cliente clienteEnBD : listaDeClientes) {
            if (compararClientes(clienteEnBD, cliente)) {
                //si se cumple, entonces encontramos una coincidencia:
                existeUsuario = true;
                //rompemos el ciclo cuando encontramos coincidencia
                //pues no tiene caso de que siga recorriendo la lista de clientes.
                break;
            }
        }

        return existeUsuario;
    }

    /**
     * Esta función se encarga de comparar todos los campos de 2 clientes.
     *
     * @return boolean: true si son iguales en al menos un campo, falso de otro
     * modo.
     */
    private boolean compararClientes(Cliente clienteEncontradoEnBD, Cliente nuevoCliente) {
        //primero obtenemos ambos nombres:
        String nombrePrimerCliente = clienteEncontradoEnBD.getNombrePersona();
        String nombreSegundoCliente = nuevoCliente.getNombrePersona();

        if (nombrePrimerCliente.equalsIgnoreCase(nombreSegundoCliente)) {
            return true;
        } //el else fue considerado, pero no es necesario.

        //obtenemos las direcciones:
        String direccionPrimerCliente = clienteEncontradoEnBD.getDireccionPersona();
        String direccionSegundoCliente = nuevoCliente.getDireccionPersona();

        if (direccionPrimerCliente.equalsIgnoreCase(direccionSegundoCliente)) {
            return true;
        } //el else fue considerado, pero no es necesario.

        //obtenemos los teléfonos:
        String telefonoPrimerCliente = clienteEncontradoEnBD.getTelefonoPersona();
        String telefonoSegundoCliente = nuevoCliente.getTelefonoPersona();

        if (telefonoPrimerCliente.equalsIgnoreCase(telefonoSegundoCliente)) {
            return true;
        } //el else fue considerado, pero no es necesario.

        //obtenemos los correos::
        String correoPrimerCliente = clienteEncontradoEnBD.getCorreoPersona();
        String correoSegundoCliente = nuevoCliente.getCorreoPersona();

        if (correoPrimerCliente.equalsIgnoreCase(correoSegundoCliente)) {
            return true;
        } //el else fue considerado, pero no es necesario.

        /*Si llega hasta aquí, entonces los clientes son distintos:*/
        return false;
    }

    /**
     * Método que se encarga de eliminarElementoPorID a una persona desde la
     * base de datos.
     *
     * @param idCliente
     * @return
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     */
    @Override
    public boolean eliminarElementoPorID(int idCliente) throws SQLException {
        boolean seEliminoCliente = false;
        Statement sentencia = Conexion.createStatement();
        sentencia.executeUpdate("DELETE FROM charmingstudio.cliente WHERE idCliente= '" + idCliente + "'");
        seEliminoCliente = true;

        return seEliminoCliente;
    }

    /**
     * Función que se encarga de buscar Coincidencias a uno o varios clientes,
     * dependiendo de los nombres, de la base de datos.
     *
     * @param nombrePersona que es el nombre de la persona a encontrar en la BD.
     * @return la lista de personas que coincidan con el nombre, si solo es una
     * regresa la lista con un solo cliente.
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     */
    @Override
    public LinkedList obtenerCoincidenciasDeBD(String nombrePersona) throws SQLException {

        Statement sentenciaDeBusquedaDeClientes = Conexion.createStatement();
        ResultSet resultadoBusquedaDeClientes = sentenciaDeBusquedaDeClientes.
                executeQuery("SELECT * FROM charmingstudio.cliente WHERE "
                        + "Nombre LIKE '%" + nombrePersona + "%'");

        /*En este caso, se espera que la búsqueda no siempre sea nula, por
         lo que nos interesa el negativo de las sentencia:*/
        if (!resultadoBusquedaDeClientes.wasNull()) {

            LinkedList<Cliente> clientes = new LinkedList<>();

            while (resultadoBusquedaDeClientes.next()) {

                //agregamos c/cliente a la lista:
                clientes.add(new Cliente(resultadoBusquedaDeClientes.getInt("idCliente"),
                        resultadoBusquedaDeClientes.getString("Nombre"),
                        resultadoBusquedaDeClientes.getString("Direccion"),
                        resultadoBusquedaDeClientes.getString("Telefono"),
                        resultadoBusquedaDeClientes.getString("Correo")));

            }
            return clientes;
        }
        return null;
    }

    /**
     * Método encargado de encontrar y devolver un elemento de la BD que
     * coincida con el nombre que se le pasa, si hay 2 elementos en la BD con el
     * mismo nombre, devolverá aquél que tenga el identificador de cliente más
     * cercano al 0.
     *
     * @param nombreCliente en formatod e String, para que el sistema manejador
     * de la BD haga la búsqueda.
     * @return un objeto de tipo cliente que contenga la información encontrada
     * en la BD.
     * @throws SQLException en caso de que no se haya podido establecer la
     * conexión con la BD.
     */
    public Cliente obtenerElementoPorNombre(String nombreCliente) throws SQLException {
        Statement sentenciaBuscaIdCliente = Conexion.createStatement();
        ResultSet busquedaIdCliente = sentenciaBuscaIdCliente.executeQuery("SELECT * FROM "
                + "charmingstudio.cliente WHERE Nombre ='" + nombreCliente + "'");
        busquedaIdCliente.next();

        Cliente cliente = new Cliente(busquedaIdCliente.getInt(1),
                busquedaIdCliente.getString(2),
                busquedaIdCliente.getString(3),
                busquedaIdCliente.getString(4),
                busquedaIdCliente.getString(5));

        return cliente;
    }

    /**
     * Función que actualiza la información de un cliente en la base de datos,
     * primero encuentra la persona a modificar para saber que exista en la base
     * de datos, posteriormente realiza las actualizaciones de la información.
     *
     * @param persona que es el objeto cliente con las modificaciones ya hechas.
     * @return verdadero o falso, dependiendo de si se pudo modificarElemento la
     * información o no.
     * @throws java.sql.SQLException, en caso de que la conexión con la base de
     * datos no se logre o cualquier otra excepción relacionada con la base de
     */
    @Override
    public boolean modificarElemento(Persona persona) throws SQLException {
        //el parámetro solo es de entrada:
        Cliente clienteA_modificar = (Cliente) persona;

        //en caso de que no haya el usuario en la BD. 
        Statement sentenciaDeActualizacionDeClientes = Conexion.createStatement();
        int actualizaInfoEmpleado
                = sentenciaDeActualizacionDeClientes.executeUpdate("UPDATE charmingstudio.cliente "
                        + "SET `Nombre` = '" + clienteA_modificar.getNombrePersona() + "'"
                        + ",`Direccion` = '" + clienteA_modificar.getDireccionPersona() + "'"
                        + ",`Telefono` = '" + clienteA_modificar.getTelefonoPersona() + "'"
                        + ",`Correo`= '" + clienteA_modificar.getCorreoPersona()
                        + "' WHERE `idCliente`='" + clienteA_modificar.getIdPersona() + "'");

        //devuelve si se pudo o no, modificarElemento el cliente:
        return (actualizaInfoEmpleado != 0);
    }

    /**
     * Devuelva una lista con la información de todas las tuplas que hay en la
     * Tabla Cliente.
     *
     * @return la lista de Tuplas (convertidas en Objetos) con la información de
     * los Clientes.
     * @throws SQLException en caso de que no se haya podido establecer la
     * conexión con la BD.
     */
    public LinkedList obtenerTodosLosElementosDeTablaCliente() throws SQLException {

        Statement sentenciaDeBusquedaDeClientes = Conexion.createStatement();
        ResultSet BusquedaDeClientes = sentenciaDeBusquedaDeClientes.
                executeQuery("SELECT * FROM charmingstudio.cliente");

        /*En este caso, se espera que la búsqueda no siempre sea nula, por
         lo que nos interesa el negativo de las sentencia:*/
        if (!BusquedaDeClientes.wasNull()) {

            LinkedList<Cliente> clientes = new LinkedList<>();

            while (BusquedaDeClientes.next()) {

                //agregamos c/cliente a la lista:
                clientes.add(new Cliente(BusquedaDeClientes.getInt(1),
                        BusquedaDeClientes.getString(2),
                        BusquedaDeClientes.getString(3),
                        BusquedaDeClientes.getString(4),
                        BusquedaDeClientes.getString(5)));

            }
            return clientes;
        }

        return null;
    }

    /**
     * Devuelve un objeto de la base de datos, con la información de un Cliente.
     *
     * @param idCliente es el identificador del cliente a buscar en la BD.
     * @return el objeto Cliente con la información almacenada en la BD.
     * @throws SQLException en caso de que no se pueda establecer la conexión
     * con la BD.
     */
    public Cliente obtenerElementoPorID(int idCliente) throws SQLException {

        Statement sentenciaBuscaliente = Conexion.createStatement();
        ResultSet busquedaCliente = sentenciaBuscaliente.executeQuery("SELECT * FROM "
                + "charmingstudio.cliente WHERE idCliente ='" + idCliente + "'");
        busquedaCliente.next();

        Cliente unCliente = new Cliente(busquedaCliente.getInt("idCliente"),
                busquedaCliente.getString("Nombre"),
                busquedaCliente.getString("Direccion"),
                busquedaCliente.getString("Telefono"),
                busquedaCliente.getString("Correo"));
        return unCliente;
    }

}//fin de la clase.
