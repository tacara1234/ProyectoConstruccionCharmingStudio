package Controlador;

import Controlador.DAO.DAOEmpleados;
import Modelo.Empleado;
import Modelo.Persona;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class ControladorEmpleado implements ControladorPersona {

    DAOEmpleados dao = new DAOEmpleados();

    @Override
    public boolean agregar(Persona empleado) throws SQLException {

        return dao.agregarElementoATabla(empleado);

    }

    @Override
    public boolean eliminar(int idEmpleado) throws SQLException {

        return dao.eliminarElementoPorID(idEmpleado);
    }
    
     public Empleado obtenerEmpleadoPorId(int idEmpleado) throws SQLException{
        return dao.buscarEmpleadoPorId(idEmpleado);
    }

    /**
     * Método encargado de devolver un arreglo con la información básica (ID y
     * nombre) de cada empleado.
     *
     * @return arreglo de Strings, donde cada fila es solo la información básica
     * de cada empleado.
     * @throws SQLException
     */
    public String[] obtenerInformacionBasicaEmpleados() throws SQLException {
        LinkedList<Empleado> empleados = dao.obtenerTodosLosEmpleados();
        String[] infoBasicaEmpleados = convertirListaDeInformacionAstr(empleados);

        return infoBasicaEmpleados;
    }
    /**
     * Convierte la informacion basica de la lista de los empleados a string
     * @param listaEmpleados es la lista que contiene la informacion de la lista a convertire
     * @return los datos basicos de los empleados en string
     */
    private String[] convertirListaDeInformacionAstr(LinkedList<Empleado> listaEmpleados) {
        String[] datosBasicosEmpleados = new String[listaEmpleados.size()];
        int fila = 0;
        for (Empleado unEmpleado : listaEmpleados) {
            datosBasicosEmpleados[fila] = unEmpleado.obtenerInfoBasicoDeEmpleado();
            fila++;
        }

        return datosBasicosEmpleados;
    }

    /**
     *
     * @param nombrePersona
     * @return
     * @throws SQLException
     */
    @Override
    public LinkedList obtenerCoincidenciasPorNombre(String nombrePersona) throws SQLException {

        return dao.obtenerCoincidenciasDeBD(nombrePersona);
    }

    @Override
    public boolean modificar(Persona persona) throws SQLException {

        return dao.modificarElemento(persona);
    }

    @Override
    public Empleado obtenerPersonaPorNombre(String nombrePersona) throws SQLException {

        return dao.buscarPorNombre(nombrePersona);

    }

    public LinkedList buscarTodosLosEmpleados() throws SQLException {

        return dao.obtenerTodosLosEmpleados();

    }
    
    public LinkedList buscarTodosLosEmpleadosConVentas() throws SQLException {

        return dao.obtenerTodosLosEmpleadosConVentas();

    }
    
    public DefaultTableModel obtenerListaActualizadaDeEmpleados(JTable tabla, String nombre){
        try {
            LinkedList<Empleado> listaDeEmpleados = obtenerCoincidenciasPorNombre(nombre);
           DefaultTableModel modeloDeLaTabla =  llenarListaDeEmpleados(listaDeEmpleados,tabla);
           return modeloDeLaTabla;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
    
    
    
    private static final int columnaID = 0;
    private static final int columnaNombre = 1;
    private static final int columnaDireccion = 2;
    private static final int columnaTelefono = 3;
    
    private static final int columnaCorreo = 4;
    private static final int columnaDesempenio = 5;
    private static final int columnaSueldo = 6;
    private static final int totalColumnas = 7;
    
     private DefaultTableModel llenarListaDeEmpleados(LinkedList<Empleado> listaDeEmpleados,JTable lista) {
        //Declaramos las columnas:
        Object columnasDeDatos[] = new Object[totalColumnas];

        //obtenemos el modelo default de la tabla:
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) lista.getModel();

        limpiarLista(lista);
        if (listaDeEmpleados != null) {
            //agregamos a cada columna los datos que le corresponden:
            for (Empleado empleado : listaDeEmpleados) {
                columnasDeDatos[columnaID] = empleado.getIdPersona();
                columnasDeDatos[columnaNombre] = empleado.getNombrePersona();
                columnasDeDatos[columnaDireccion] = empleado.getDireccionPersona();
                columnasDeDatos[columnaTelefono] = empleado.getTelefonoPersona();
                columnasDeDatos[columnaCorreo] = empleado.getCorreoPersona();
                columnasDeDatos[columnaDesempenio] = empleado.getEmpDesempenio();
                columnasDeDatos[columnaSueldo] = empleado.getEmpSueldo();

                //agregamos los datos de cada columna en cada renglón:
                modeloDeLaTabla.addRow(columnasDeDatos);
            }
        } else {
            /*El else no es necesario, pero fue considerado.*/
        }

        return modeloDeLaTabla;
    }
     
         private void limpiarLista(JTable lista) {
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) lista.getModel();
        for (int i = 0; i < lista.getRowCount(); i++) {
            modeloDeLaTabla.removeRow(0);
            i -= 1;
        }
    }
    
    
}
