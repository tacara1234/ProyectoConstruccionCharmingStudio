package Controlador.DAO;

import Modelo.Persona;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 02:34:45 p.m.
 */
public class DAOEmpleados extends GestorBD {

    private Connection Conexion;

    public DAOEmpleados() {
        try {
            Conexion = ConexionBaseDatos.getInstancia().getConexionBD();
        } catch (SQLException ex) {
        }
    }

    /**
     *
     * @param persona
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public boolean agregar(Persona persona) throws SQLException {
        Empleado empleado = (Empleado) persona;

        Statement sentencia = Conexion.createStatement();
        boolean seAgregoEmpleado = false;;
        if (!existeEmpleado(empleado)) {
            sentencia.executeUpdate("INSERT INTO charmingstudio.empleado (`Nombre`, "
                    + "`Direccion`, `Telefono`, `Correo`, `Desempeno`, `Sueldo` )" + "VALUES("
                    + "'" + empleado.getNombrePersona() + "',"
                    + "'" + empleado.getDireccionPersona() + "',"
                    + "'" + empleado.getTelefonoPersona() + "',"
                    + "'" + empleado.getCorreoPersona() + "',"
                    + "'" + empleado.getEmpDesempenio() + "',"
                    + "'" + empleado.getEmpSueldo() + "')");
            seAgregoEmpleado = true;
        }
        return seAgregoEmpleado;
    }
    private static final int columnaIdEmpleado = 1;
    private static final int columnaNombre = 2;
    private static final int columnaDireccion = 3;
    private static final int columnaTelefono = 4;
    private static final int columnaCorreo = 5;
    private static final int columnaDesempeno = 6;
    private static final int columnaSueldo = 7;

    public Empleado buscarEmpleadoPorId(int idEmpleado) throws SQLException {

        Statement sentenciaBuscaEmpleado = Conexion.createStatement();
        ResultSet busquedaEmpleado = sentenciaBuscaEmpleado.executeQuery("SELECT * FROM "
                + "charmingstudio.empleado WHERE idEmpleado ='" + idEmpleado + "'");
        busquedaEmpleado.next();

        Empleado unEmpleado = new Empleado(busquedaEmpleado.getInt(columnaIdEmpleado),
                busquedaEmpleado.getString(columnaNombre),
                busquedaEmpleado.getString(columnaDireccion),
                busquedaEmpleado.getString(columnaTelefono),
                busquedaEmpleado.getString(columnaCorreo),
                busquedaEmpleado.getFloat(columnaDesempeno),
                busquedaEmpleado.getFloat(columnaSueldo));
        /*
         LinkedList<Servicio> servicios = encontrarServiciosDelProveedor(unProveedor.getIdPersona());
         unProveedor.setServiciosQueProvee(servicios);
         */
        return unEmpleado;
    }

    /**
     * Este método eliminará al empleado, pasándole el id único.
     *
     * @param idEmpleado
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public boolean eliminar(int idEmpleado) throws SQLException {
        boolean seEliminoEmpleado = false;

        Statement sentencia = Conexion.createStatement();

        sentencia.executeUpdate("DELETE FROM charmingstudio.empleado WHERE idEmpleado= '" + idEmpleado + "'");
        seEliminoEmpleado = true;
        return seEliminoEmpleado;

    }

    private boolean existeEmpleado(Empleado empleado) throws SQLException {

        LinkedList<Empleado> listaDeEmpleados = buscarCoincidencias(empleado.getNombrePersona());;
        boolean existeUsuario = false;
        if (listaDeEmpleados != null) {
            for (Empleado empleadoEnBD : listaDeEmpleados) {

                if (compararEmpleados(empleadoEnBD, empleado)) {
                    //si se cumple, entonces encontramos una coincidencia:
                    existeUsuario = true;
                    //rompemos el ciclo en caso de que haya más de un cliente
                    //con los mismos datos:
                    break;
                }
            }
        }/*el else fue considerado, pero no es usado.*/

        return existeUsuario;
    }

    private boolean compararEmpleados(Empleado empleadoEncontradoEnBD, Empleado empleadoA_modificar) {
        //primero obtenemos ambos nombres:
        String nombreEmpleadoEncontradoEnBD = empleadoEncontradoEnBD.getNombrePersona();
        String nombreEmpleadoA_modificar = empleadoA_modificar.getNombrePersona();
        //comparamos los nombres:
        if (nombreEmpleadoEncontradoEnBD.equalsIgnoreCase(nombreEmpleadoA_modificar)) {
            return true;
        }

        //obtenemos las direcciones:
        String direccionEmpleadoEncontradoEnBD = empleadoEncontradoEnBD.getDireccionPersona();
        String direccionEmpleadoA_modificar = empleadoA_modificar.getDireccionPersona();
        //comparamos las direcciones:
        if (direccionEmpleadoEncontradoEnBD.equalsIgnoreCase(direccionEmpleadoA_modificar)) {
            return true;
        }

        //obtenemos los teléfonos:
        String telefonoEmpleadoEncontradoEnBD = empleadoEncontradoEnBD.getTelefonoPersona();
        String telefonoEmpleadoA_modificar = empleadoA_modificar.getTelefonoPersona();
        if (telefonoEmpleadoEncontradoEnBD.equalsIgnoreCase(telefonoEmpleadoA_modificar)) {
            return true;
        }

        //obtenemos los correos::
        String correoEmpleadoEncontradoEnBD = empleadoEncontradoEnBD.getCorreoPersona();
        String correoEmpleadoA_modificar = empleadoA_modificar.getCorreoPersona();
        if (correoEmpleadoEncontradoEnBD.equalsIgnoreCase(correoEmpleadoA_modificar)) {
            return true;
        }

        //obtenemos los desempenios::
        float desempenioEmpleadoEncontradoEnBD = empleadoEncontradoEnBD.getEmpDesempenio();
        float desempenioEmpleadoA_modificar = empleadoA_modificar.getEmpDesempenio();
        if (desempenioEmpleadoEncontradoEnBD == desempenioEmpleadoA_modificar) {
            return true;
        }

        //obtenemos los sueldos::
        float sueldoEmpleadoEncontradoEnBD = empleadoEncontradoEnBD.getEmpSueldo();
        float sueldoEmpleadoA_modificar = empleadoA_modificar.getEmpSueldo();
        if (sueldoEmpleadoEncontradoEnBD == sueldoEmpleadoA_modificar) {
            return true;
        }

        /*Si llega hasta aquí, entonces los empleados son distintos:*/
        return false;
    }

    /**
     *
     * @param nombrePersona
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public LinkedList buscarCoincidencias(String nombrePersona) throws SQLException {
        Statement sentenciaDeBusquedaDeEmpleados = Conexion.createStatement();
        ResultSet busquedaEmpleado = sentenciaDeBusquedaDeEmpleados.executeQuery("SELECT * "
                + "FROM charmingstudio.empleado WHERE Nombre LIKE '%" + nombrePersona + "%'");
        if (!busquedaEmpleado.wasNull()) {
            //creamos la lista:
            LinkedList<Empleado> empleados = new LinkedList<>();

            while (busquedaEmpleado.next()) {
                //agregamos c/empleado a la lista:

                empleados.add(new Empleado(busquedaEmpleado.getInt(columnaIdEmpleado),
                        busquedaEmpleado.getString(columnaNombre),
                        busquedaEmpleado.getString(columnaDireccion),
                        busquedaEmpleado.getString(columnaTelefono),
                        busquedaEmpleado.getString(columnaCorreo),
                        busquedaEmpleado.getFloat(columnaDesempeno),
                        busquedaEmpleado.getFloat(columnaSueldo)));


            }
            return empleados;
        }
        return null;

    }

    /**
     * Funcion que se encarga de eliminar algún empleado. NO SE HA IMPLEMENTADO.
     *
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public boolean modificar(Persona persona) throws SQLException {
        //el parámetro solo es de entrada:
        Empleado empleadoA_modificar = (Empleado) persona;

        //en caso de que no haya el usuario en la BD. 
        Statement sentenciaDeActualizacionDeEmpleados = Conexion.createStatement();
        int actualizaInfoEmpleado = sentenciaDeActualizacionDeEmpleados.executeUpdate("UPDATE charmingstudio.empleado "
                + "SET `Nombre` = '" + empleadoA_modificar.getNombrePersona() + "'"
                + ",`Direccion` = '" + empleadoA_modificar.getDireccionPersona() + "'"
                + ",`Telefono` = '" + empleadoA_modificar.getTelefonoPersona() + "'"
                + ",`Correo`= '" + empleadoA_modificar.getCorreoPersona() + "'"
                + ",`Desempeno`= '" + empleadoA_modificar.getEmpDesempenio() + "'"
                + ",`Sueldo`= '" + empleadoA_modificar.getEmpSueldo()
                + "' WHERE `idEmpleado`='" + empleadoA_modificar.getIdPersona() + "'");

        boolean sePudoModificarInfoEmpleado = false;
        if (actualizaInfoEmpleado != 0) {
            sePudoModificarInfoEmpleado = true;
        }

        //devuelve si se pudo o no, modificar el empleado:
        return sePudoModificarInfoEmpleado;

    }

    public LinkedList obtenerTodosLosEmpleados() throws SQLException {

        Statement sentenciaDeBusquedaDeEmpleados = Conexion.createStatement();
        ResultSet busquedaEmpleado = sentenciaDeBusquedaDeEmpleados.
                executeQuery("SELECT * FROM charmingstudio.empleado");

        /*En este caso, se espera que la búsqueda no siempre sea nula, por
         lo que nos interesa el negativo de las sentencia:*/
        if (!busquedaEmpleado.wasNull()) {

            LinkedList<Empleado> empleados = new LinkedList<>();

            while (busquedaEmpleado.next()) {

                //agregamos c/cliente a la lista:
                empleados.add(new Empleado(busquedaEmpleado.getInt(columnaIdEmpleado),
                        busquedaEmpleado.getString(columnaNombre),
                        busquedaEmpleado.getString(columnaDireccion),
                        busquedaEmpleado.getString(columnaTelefono),
                        busquedaEmpleado.getString(columnaCorreo),
                        busquedaEmpleado.getFloat(columnaDesempeno),
                        busquedaEmpleado.getFloat(columnaSueldo)));
            }
            return empleados;
        }

        return null;
    }

    public Empleado buscarPorNombre(String nombreEmpleado) throws SQLException {
        Statement sentenciaBuscaEmpleado = Conexion.createStatement();
        ResultSet busquedaEmpleado = sentenciaBuscaEmpleado.executeQuery("SELECT * FROM "
                + "charmingstudio.empleado WHERE Nombre ='" + nombreEmpleado + "'");
        busquedaEmpleado.next();

        Empleado empleado = new Empleado(busquedaEmpleado.getInt(columnaIdEmpleado),
                        busquedaEmpleado.getString(columnaNombre),
                        busquedaEmpleado.getString(columnaDireccion),
                        busquedaEmpleado.getString(columnaTelefono),
                        busquedaEmpleado.getString(columnaCorreo),
                        busquedaEmpleado.getFloat(columnaDesempeno),
                        busquedaEmpleado.getFloat(columnaSueldo));

        return empleado;
    }

    public LinkedList obtenerTodosLosEmpleadosConVentas() throws SQLException {

        Statement sentenciaDeBusquedaDeEmpleados = Conexion.createStatement();
        ResultSet BusquedaDeEmpleados = sentenciaDeBusquedaDeEmpleados.
                executeQuery("SELECT empleado.Nombre, empleado.Desempeno, empleado.Sueldo, sum(eventos.PrecioTotal) as PrecioTotal from eventos INNER JOIN empleado on eventos.idEmpleado=empleado.idEmpleado GROUP BY eventos.idEmpleado ORDER BY PrecioTotal DESC");

        /*En este caso, se espera que la búsqueda no siempre sea nula, por
         lo que nos interesa el negativo de las sentencia:*/
        if (!BusquedaDeEmpleados.wasNull()) {

            LinkedList empleadosConVentas = new LinkedList();

            while (BusquedaDeEmpleados.next()) {

                //agregamos c/cliente a la lista:
                empleadosConVentas.add(BusquedaDeEmpleados.getString("Nombre"));
                empleadosConVentas.add(BusquedaDeEmpleados.getString("Desempeno"));
                empleadosConVentas.add(BusquedaDeEmpleados.getString("Sueldo"));
                empleadosConVentas.add(BusquedaDeEmpleados.getString("PrecioTotal"));
            }
            return empleadosConVentas;
        }

        return null;
    }
}
