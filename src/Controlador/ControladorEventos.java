/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.DAOEventos;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.EventosSociales;
import Modelo.MesaDeDulces;
import Modelo.Proveedor;
import Modelo.Servicio;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lalo
 */
public class ControladorEventos {

    private DAOEventos dao;

    public ControladorEventos() {
        dao = new DAOEventos();
    }

    /**
     * Se encarga de guardar un nuevo registro para un evento, actualiza los
     * paquetes ya que para cada evento se arma uno solo.
     *
     * @param claveCliente es el cliente asociado al evento.
     * @param claveEmpleado es el empleado encargado de llevar el evento.
     * @param claveMesaDulces es la mesa de dulces asociada al evento.
     * @param proveedores son los posibles proveedores que darán algún servicio.
     * Podría ser que solo un proveedor de todos los servicios que necesita.
     * @param clavePaquete Es el tipo de paquete que se usará en el evento 1 -
     * es el básico. 2 - es el intermedio. 3 - es el completo.
     * @param precioEvento es el precio que cobrará la empresa por todo.
     * @param fechaEvento es la fecha en que se realizará el evento.
     * @return
     * @throws java.sql.SQLException
     */
    public boolean agregarEvento(int claveCliente, int claveEmpleado, int claveMesaDulces,
            Object[] proveedores, int clavePaquete, float precioEvento,
            String fechaEvento) throws SQLException {

        boolean sePudoAgregarEvento = false;

        int idEvento = dao.agregarElementoA_TablaEventoSocial(claveCliente, claveMesaDulces,
                fechaEvento, precioEvento, claveEmpleado);

        //Se agrega la información de los paquetes a usar en el evento en la BD:
        agregarPaquetes(idEvento, clavePaquete, proveedores, fechaEvento);

        sePudoAgregarEvento = true;

        return sePudoAgregarEvento;
    }

    /**
     * Se encarga de actualizar la tabla de los paquetes que se arman cuando se
     * crea un nuevo evento. aSe recibe de la vista un arreglo que tiene la
     * información de la siguiente manera: [idProveedor,
     * nombreServicio,...,idProveedor, nombreServicio] ya que la vista no puede
     * devolver objetos.
     */
    private void agregarPaquetes(int idEvento, int clavePaquete,
            Object[] proveedoresConServicios, String strFecha) throws SQLException {

        ControladorPaquetes unControladorPaquetes = new ControladorPaquetes();
        int idProveedor = 0, idServicio = 0;
        String nombreServicio = "";

        for (int indice = 0; indice < proveedoresConServicios.length; indice += 2) {
            //obtenemos la información del arreglo:
            idProveedor = (int) proveedoresConServicios[indice];
            nombreServicio = (String) proveedoresConServicios[indice + 1];

            //encontramos el ID del servicio, a partir del nombre:
            idServicio = buscarIdServicioPorNombre(nombreServicio);

            //Actualizamos la información del paquete en la BD.
            unControladorPaquetes.agregarPaquetes(idEvento, clavePaquete, idProveedor, idServicio, strFecha);
        }
    }

    /**
     * Se encarga de retornar el ID del servicio que se busca, a partir del
     * nombre que se le pase.
     */
    private int buscarIdServicioPorNombre(String nombreServicio) throws SQLException {

        ControladorServicios controlador = new ControladorServicios();
        Servicio unServicio = controlador.obtenerServicioPorNombre(nombreServicio);

        return unServicio.getId();
    }

    /**
     * Método encargado de obtener la información de todos los empleados
     * registrados en la BD, solo devuelve el ID y nombre de cada empleado.
     *
     * @return un arreglo de String, donde cada fila es la información básica de
     * cada empleado.
     * @throws SQLException
     */
    public String[] obtenerInformacionBasicaEmpleado() throws SQLException {

        ControladorEmpleado controlEmpleado = new ControladorEmpleado();
        String[] datosEmpleados = controlEmpleado.obtenerInformacionBasicaEmpleados();

        return datosEmpleados;
    }

    /**
     * Este método se encarga de encontrar todas las mesas de dulces registradas
     * en la BD, para que el usuario pueda escoger alguna.
     *
     * @return una lista simple con la información de las mesas.
     * @throws SQLException
     */
    public LinkedList<MesaDeDulces> encontrarMesasDeDulces() throws SQLException {

        ControladorMesaDeDulces ctrlMesa = new ControladorMesaDeDulces();
        LinkedList<MesaDeDulces> mesasEncontradas = ctrlMesa.buscarTodasMD();

        return mesasEncontradas;
    }

    /**
     * encuentra todos los proveedores que hay en la BD y retorna toda la
     * información asociada a ellos (servicios, costos, etc).
     *
     * @return lista simple con la información completa de los proveedores.
     * @throws SQLException
     */
    public LinkedList encontrarProveedores() throws SQLException {
        LinkedList<Proveedor> proveedores = new LinkedList();
        ControladorProveedores ctrlProv = new ControladorProveedores();

        proveedores = ctrlProv.obtenerTodosLosProveedoresConSusServicios();

        return proveedores;
    }

    /**
     * encuentra todos los proveedores que dan el Paquete básico, que hay en la
     * BD y retorna toda la información asociada a ellos (servicios, costos,
     * etc).
     *
     * @return lista simple con la información completa de los proveedores.
     * @throws SQLException
     */
    public LinkedList<Proveedor> encontrarProveedoresDePaqueteBasico() throws SQLException {
        LinkedList<Proveedor> proveedores = new LinkedList();
        ControladorProveedores ctrlProv = new ControladorProveedores();

        proveedores = ctrlProv.obtenerTodosLosProveedoresDeServicioBasico();

        return proveedores;
    }

    /**
     * encuentra todos los proveedores que dan el paquete Intermedio, que hay en
     * la BD y retorna toda la información asociada a ellos (servicios, costos,
     * etc).
     *
     * @return lista simple con la información completa de los proveedores.
     * @throws SQLException
     */
    public LinkedList<Proveedor> encontrarProveedoresDePaqueteIntermedio() throws SQLException {
        LinkedList<Proveedor> proveedores = new LinkedList();
        ControladorProveedores ctrlProv = new ControladorProveedores();

        proveedores = ctrlProv.obtenerTodosLosProveedoresDeServicioIntermedio();

        return proveedores;
    }

    /**
     * encuentra todos los proveedores que dan el paquete completo, que hay en
     * la BD y retorna toda la información asociada a ellos (servicios, costos,
     * etc).
     *
     * @return lista simple con la información completa de los proveedores.
     * @throws SQLException
     */
    public LinkedList<Proveedor> encontrarProveedoresDePaqueteCompleto() throws SQLException {
        LinkedList<Proveedor> proveedores = new LinkedList();
        ControladorProveedores ctrlProv = new ControladorProveedores();

        proveedores = ctrlProv.obtenerTodosLosProveedoresDeServicioCompleto();

        return proveedores;
    }

    /**
     * Faltra Javadoc.
     *
     * @param modelo
     * @param tipoDeLlenado
     * @return
     * @throws SQLException
     */
    public DefaultTableModel obtenerTodosLosEventos(DefaultTableModel modelo, int tipoDeLlenado) throws SQLException {
        //¿QUÉ SIGNIFICA EL 1?
        LinkedList<EventosSociales> listaDeEventos = dao.obtenerTodosLosEventos();
        if (tipoDeLlenado == 1) {
            return llenarListaDeDatosCompleta(listaDeEventos, modelo);
        } else {
            return llenarListaDeDatosParaReporte(listaDeEventos, modelo);

        }

    }
    private static final int columnaID = 0;
    private static final int columnaFechaReporte = 1;
    private static final int columnaPrecioTotal = 2;

    private static final int numColumnasParaReporte = 3;

    private DefaultTableModel llenarListaDeDatosParaReporte(LinkedList<EventosSociales> listaDeEventos,
            DefaultTableModel modelo) throws SQLException {

        //Declaramos las columnas:
        Object columnasDeDatos[] = new Object[numColumnasParaReporte];

        if (listaDeEventos != null) {

            for (EventosSociales evento : listaDeEventos) {
                columnasDeDatos[columnaID] = evento.getIdEvento();
                columnasDeDatos[columnaFechaReporte] = evento.getFecha();
                columnasDeDatos[columnaPrecioTotal] = evento.getPrecioTotal();

                //agregamos los datos de cada columna en cada renglón:
                modelo.addRow(columnasDeDatos);
            }
        }//se considera el else pero no es necesario                                           

        //establecemos a nuestra tabla, el modelo que tenía:
        return modelo;

    }

    private static final int columnaCliente = 1;
    private static final int columnaMesaDeDulces = 2;
    private static final int columnaFechaDatosCompletos = 3;
    private static final int columnaPrecioTotalEvento = 4;
    private static final int columnaEmpleado = 5;
    private static final int numColumnasDeDatosCompletos = 6;


    /*QUÉ SIGNIFICAN LOS NÚMEROS DE ABAJO?*/
    private DefaultTableModel llenarListaDeDatosCompleta(LinkedList<EventosSociales> listaDeEventos,
            DefaultTableModel modelo) throws SQLException {
        //Declaramos las columnas:
        Object columnasDeDatos[] = new Object[numColumnasDeDatosCompletos];

        //Controladores:
        ControladorCliente ctrlCliente = new ControladorCliente();
        ControladorEmpleado ctrlEmpleado = new ControladorEmpleado();
        ControladorMesaDeDulces ctrlMesaDulces = new ControladorMesaDeDulces();

        if (listaDeEventos != null) {
            //agregamos a cada columna los datos que le corresponden:

            for (EventosSociales evento : listaDeEventos) {

                Cliente ClienteDelEvento = ctrlCliente.obtenerClientePorID(evento.getIdCliente());
                String nombreClienteDelEvento = ClienteDelEvento.getNombrePersona();

                Empleado ResponsableDelEvento = ctrlEmpleado.obtenerEmpleadoPorId(evento.getIdEmpleado());
                String nombreResponsableDelEvento = ResponsableDelEvento.getNombrePersona();

                MesaDeDulces mesaDeDulcesDelEvento = ctrlMesaDulces.obtenerMDPorId(evento.getIdMD());
                String nombreMesaDeDulcesDelEvento = mesaDeDulcesDelEvento.getNombreDeMesa();

                String colCliente = evento.getIdCliente() + " " + nombreClienteDelEvento;
                String colEmpleado = evento.getIdEmpleado() + " " + nombreResponsableDelEvento;
                String colMesaDeDulces = evento.getIdMD() + " " + nombreMesaDeDulcesDelEvento;
                //QUÉ SIGNIFICAN LOS NÚMEROS DE ABAJO?
                columnasDeDatos[columnaID] = evento.getIdEvento();
                columnasDeDatos[columnaCliente] = colCliente;
                columnasDeDatos[columnaMesaDeDulces] = colMesaDeDulces;
                columnasDeDatos[columnaFechaDatosCompletos] = evento.getFecha();

                columnasDeDatos[columnaPrecioTotalEvento] = evento.getPrecioTotal();
                columnasDeDatos[columnaEmpleado] = colEmpleado;

                //agregamos los datos de cada columna en cada renglón:
                modelo.addRow(columnasDeDatos);
            }
        }//se considera el else pero no es necesario                                           

        //establecemos a nuestra tabla, el modelo que tenía:
        return modelo;

    }

    private static final int numColumnasDeProveedores = 4;
    private static final int columnaID_Proveedor = 0;
    private static final int columnaNombreProveedor = 1;
    private static final int columnaNombreServicio = 2;
    private static final int columnaCostoServicio = 3;

    /**
     * Este método es encargado de llenar una tabla de la Vista, con la
     * información que encuentre en la BD acerca de los proveedores.
     *
     * @param tipoPaquete que está asociado al evento para poder encontrar los
     * proveedores (Pueden ser: Básico, Intermedio o Completo).
     * @param modeloLista es el modelo de la lista (o tabla) que está en la
     * vista.
     * @return el modelo con los datos en él.
     * @throws SQLException en caso de no establecer conexión con la BD.
     */
    public DefaultTableModel llenarListaProveedores(String tipoPaquete, DefaultTableModel modeloLista) throws SQLException {
        LinkedList<Proveedor> ListaProveedores = new LinkedList<>();

        ListaProveedores = obtenerProveedoresSegunPaquete(tipoPaquete);

        Object[] renglonDeDatos = new Object[numColumnasDeProveedores];

        for (Proveedor unProveedor : ListaProveedores) {
            String nombreProveedor = unProveedor.getNombrePersona();
            int idProveedor = unProveedor.getIdPersona();
            LinkedList<Servicio> serviciosDeProveedor = unProveedor.obtenerServiciosQueProvee();

            for (Servicio unServicio : serviciosDeProveedor) {
                renglonDeDatos[columnaID_Proveedor] = idProveedor;
                renglonDeDatos[columnaNombreProveedor] = nombreProveedor;
                renglonDeDatos[columnaNombreServicio] = unServicio.getServNombre();
                renglonDeDatos[columnaCostoServicio] = unServicio.getCosto();
                modeloLista.addRow(renglonDeDatos);
            }
        }

        return modeloLista;
    }

    private LinkedList<Proveedor> obtenerProveedoresSegunPaquete(String tipoPaquete) throws SQLException {
        LinkedList<Proveedor> proveedores = new LinkedList<>();
        switch (tipoPaquete) {
            case "Basico":
                proveedores = encontrarProveedoresDePaqueteBasico();
                break;
            case "Intermedio":
                proveedores = encontrarProveedoresDePaqueteIntermedio();
                break;
            case "Completo":
                proveedores = encontrarProveedoresDePaqueteCompleto();
                break;
        }
        return proveedores;
    }

    private static final int numColumnasDeClientes = 5;

    private static final int columnaID_Cliente = 0;
    private static final int columnaNombre = 1;
    private static final int columnaDireccionCliente = 2;
    private static final int columnaTelefonoCliente = 3;
    private static final int columnaCorreoCliente = 4;

    /**
     * Este método es encargado de llenar una tabla de la Vista, con la
     * información que encuentre en la BD acerca de los empleados.
     *
     * @param nombreCliente a buscar en la BD.
     * @param modeloLista es el modelo de la lista (o tabla) que está en la
     * vista.
     * @return el modelo con los datos en él.
     * @throws SQLException en caso de no establecer conexión con la BD.
     */
    public DefaultTableModel llenarListaCliente(String nombreCliente, DefaultTableModel modeloLista) throws SQLException {

        LinkedList<Cliente> Clientes = obtenerInformacionClientesSegunNombre(nombreCliente);

        Object[] renglonDeDatos = new Object[numColumnasDeClientes];

        for (Cliente unCliente : Clientes) {
            renglonDeDatos[columnaID_Cliente] = unCliente.getIdPersona();
            renglonDeDatos[columnaNombre] = unCliente.getNombrePersona();
            renglonDeDatos[columnaDireccionCliente] = unCliente.getDireccionPersona();
            renglonDeDatos[columnaTelefonoCliente] = unCliente.getTelefonoPersona();
            renglonDeDatos[columnaCorreoCliente] = unCliente.getCorreoPersona();
            modeloLista.addRow(renglonDeDatos);
        }

        return modeloLista;
    }

    /**
     * Método encargado de devolver la información completa de un cliente, a
     * partir del nombre que se busque en la BD.
     *
     * @param nombre del cliente a encontrar en la BD.
     * @return lista simple con la información de todos los empleados.
     * @throws SQLException
     */
    public LinkedList<Cliente> obtenerInformacionClientesSegunNombre(String nombre) throws SQLException {

        ControladorCliente controlador = new ControladorCliente();
        LinkedList<Cliente> listaClientes = controlador.obtenerCoincidenciasPorNombre(nombre);

        return listaClientes;
    }

    private static final int numColumnasDeMesas = 3;
    private static final int columnaID_MesasDulces = 0;
    private static final int columnaNombreMesa = 1;
    private static final int columnaPrecioMesa = 2;

    /**
     * Este método es encargado de llenar una tabla de la Vista, con la
     * información que encuentre en la BD acerca de las mesas de dulces.
     *
     * @param modeloLista es el modelo de la lista (o tabla) que está en la
     * vista.
     * @return el modelo con los datos en él.
     * @throws SQLException en caso de no establecer conexión con la BD.
     */
    public DefaultTableModel llenarListaMesaDulces(DefaultTableModel modeloLista) throws SQLException {
        LinkedList<MesaDeDulces> mesas = encontrarMesasDeDulces();

        Object[] renglonDeDatos = new Object[numColumnasDeMesas];

        for (MesaDeDulces unaMesa : mesas) {

            renglonDeDatos[columnaID_MesasDulces] = unaMesa.getIdMesaDulces();
            renglonDeDatos[columnaNombreMesa] = unaMesa.getNombreDeMesa();
            renglonDeDatos[columnaPrecioMesa] = unaMesa.getPrecio();

            modeloLista.addRow(renglonDeDatos);
        }

        return modeloLista;
    }

    /**
     * Método encargado de Eliminar un evento de la BD, a partir del
     * Identificador que se le pase.
     *
     * @param idEvento es el identificador del evento a eliminar.
     * @return verdadero o falso, dependiendo de si se eliminó o no la
     * información de la BD.
     * @throws SQLException en caso de que no se haya podido conectar con la BD.
     */
    public boolean eliminarEvento(int idEvento) throws SQLException {

        return dao.eliminarEvento(idEvento);

    }

    /**
     * Método que comprueba la existencia de un evento en la BD.
     *
     * @param idCliente es el identificador del cliente a comparar en la BD.
     * @param idMesaDulces es el identificador de la Mesa de dulces a comparar
     * en la BD.
     * @param fecha es la fecha del evento a comparar en la BD.
     * @param idEmpleado es el identificador del resopnsable del evento.
     * @return verdadero o falso, dependiendo de si dicho evento existe.
     * @throws SQLException en caso de algún error con la conexión a la BD.
     */
    public boolean ExisteElEvento(int idCliente, int idMesaDulces, String fecha, int idEmpleado) throws SQLException {

        LinkedList<EventosSociales> listaDeEventos = dao.obtenerTodosLosEventos();

        if (listaDeEventos == null) {
            return false;//no existe el evento.
        }

        boolean existe = false;
        for (EventosSociales evento : listaDeEventos) {
            String fechaEvt = convertirFechaEnTexto(evento);
            //Ver si se puede hacer mas corta o refactorizar de alguna manera
            if (idCliente == evento.getIdCliente()
                    && idMesaDulces == evento.getIdMD()
                    && idEmpleado == evento.getIdEmpleado()
                    && fecha.equalsIgnoreCase(fechaEvt)) {
                existe = true;
            }
        }

        return existe;
    }

    private String convertirFechaEnTexto(EventosSociales evento) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEvt = formatter.format(evento.getFecha());

        return fechaEvt;
    }
}
