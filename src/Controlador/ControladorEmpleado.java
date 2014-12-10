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
        String[] infoBasicaEmpleados = copiarInformacion(empleados);

        return infoBasicaEmpleados;
    }

    private String[] copiarInformacion(LinkedList<Empleado> listaEmpleados) {
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
    
    public void llenarListaDeEmpleados(JTable tabla, String nombre){
        try {
            LinkedList<Empleado> listaDeEmpleados = obtenerCoincidenciasPorNombre(nombre);
            llenarListaDeDatos(listaDeEmpleados,tabla);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void llenarListaDeDatos(LinkedList<Empleado> listaDeEmpleados,JTable tabla) {
        //Declaramos las columnas:
        Object columnasDeDatos[] = new Object[7];

        //obtenemos el modelo default de la tabla:
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) tabla.getModel();

        limpiarLista(tabla);
        if (listaDeEmpleados != null) {
            //agregamos a cada columna los datos que le corresponden:
            for (Empleado empleado : listaDeEmpleados) {
                columnasDeDatos[0] = empleado.getIdPersona();
                columnasDeDatos[1] = empleado.getNombrePersona();
                columnasDeDatos[2] = empleado.getDireccionPersona();
                columnasDeDatos[3] = empleado.getTelefonoPersona();
                columnasDeDatos[4] = empleado.getCorreoPersona();
                columnasDeDatos[5] = empleado.getEmpDesempenio();
                columnasDeDatos[6] = empleado.getEmpSueldo();

                //agregamos los datos de cada columna en cada renglón:
                modeloDeLaTabla.addRow(columnasDeDatos);
            }
        } else {
            /*El else no es necesario, pero fue considerado.*/
        }
        //establecemos a nuestra tabla, el modelo que tenía:
        tabla.setModel(modeloDeLaTabla);

    }
     
         private void limpiarLista(JTable tabla) {
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modeloDeLaTabla.removeRow(0);
            i -= 1;
        }
    }
    
    
}
