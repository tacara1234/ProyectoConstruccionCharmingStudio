/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.DAOMesaDeDulces;
import Modelo.MesaDeDulces;
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
public class ControladorMesaDeDulces {

    DAOMesaDeDulces dao = new DAOMesaDeDulces();

    public boolean agregarMD(MesaDeDulces mesaDulces) throws SQLException {

        return dao.agregarMD(mesaDulces);
    }

    public boolean eliminarMD(int idMesaDeDulces) throws SQLException {

        return dao.eliminarMD(idMesaDeDulces);
    }

    public LinkedList obtenerCoincidenciasPorNombre(String nombreMesaDeDulces) throws SQLException {

        return dao.buscarCoincidencias(nombreMesaDeDulces);
    }

    public boolean modificarMD(MesaDeDulces mesaDeDulcesAModificar) throws SQLException {

        return dao.modificarMD(mesaDeDulcesAModificar);
    }

    public MesaDeDulces buscarPorNombre(String nombreMesa) throws SQLException {

        return dao.buscarMesaPorNombre(nombreMesa);

    }

    public MesaDeDulces obtenerMDPorId(int idMD) throws SQLException {
        return dao.buscarMDPorId(idMD);
    }

    public LinkedList buscarTodasMD() throws SQLException {

        return dao.buscarTodasMD();

    }

    public DefaultTableModel obtenerListaActualizadaDeMesasDeDulces(JTable tabla, String nombre) {
        try {
            LinkedList<MesaDeDulces> listaDeMesaDeDulces = obtenerCoincidenciasPorNombre(nombre);
            DefaultTableModel modeloDeLaTabla = llenarListaDeMesaDeDulces(listaDeMesaDeDulces, tabla);
            return modeloDeLaTabla;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static final int columnaID = 0;
    private static final int columnaNombre = 1;
    private static final int columnaPrecio = 2;
    private static final int totalColumnas = 3;

    private DefaultTableModel llenarListaDeMesaDeDulces(LinkedList<MesaDeDulces> listaDeMesasDeDulces, JTable lista) {
        //Declaramos las columnas:
        Object renglonDeDatos[] = new Object[totalColumnas];

        //obtenemos el modelo default de la tabla:
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) lista.getModel();

        limpiarLista(lista);

        if (listaDeMesasDeDulces != null) {
            //agregamos a cada columna los datos que le corresponden:
            for (MesaDeDulces mesaDeDulces : listaDeMesasDeDulces) {
                renglonDeDatos[columnaID] = mesaDeDulces.getIdMesaDulces();
                renglonDeDatos[columnaNombre] = mesaDeDulces.getNombreDeMesa();
                renglonDeDatos[columnaPrecio] = mesaDeDulces.getPrecio();

                //agregamos los datos de cada columna en cada renglón:
                modeloDeLaTabla.addRow(renglonDeDatos);
            }
        } else {
            //se considera el else pero no es necesario                                           
        }
        //establecemos a nuestra tabla, el modelo que tenía:
        //tabla.setModel(modeloDeLaTabla);
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
