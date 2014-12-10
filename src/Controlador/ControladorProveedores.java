package Controlador;

import Controlador.DAO.DAOProveedores;
import Modelo.Persona;
import Modelo.Proveedor;
import Modelo.Servicio;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Lalo
 */
public class ControladorProveedores implements ControladorPersona {

    DAOProveedores dao = new DAOProveedores();

    @Override
    public Proveedor obtenerPersonaPorNombre(String nombrePersona) throws SQLException {

        return dao.buscarPorNombre(nombrePersona);

    }

    @Override
    public boolean agregar(Persona proveedor) throws SQLException {
        //El parámetro es en específico de tipo proveedor, por lo que
        //creamos un objeto de tipo proveedor:
        Proveedor prov = (Proveedor) proveedor;

        return dao.agregarElementoATabla(prov);

    }

    @Override
    public boolean eliminar(int Proveedor) throws SQLException {

        return dao.eliminarElementoPorID(Proveedor);

    }

    @Override
    public boolean modificar(Persona persona) throws SQLException {

        return dao.modificarElemento(persona);
    }

    @Override
    public LinkedList obtenerCoincidenciasPorNombre(String nombrePersona) throws SQLException {

        return dao.obtenerCoincidenciasDeBD(nombrePersona);

    }

    /**
     * Encuentra todos los proveedores que proveen algún servicio, en primera
     * instancia están los proveedores que dan más barato, dicho servicio.
     * (TODAVÍA NO ESTÁ IMPLEMENTADO.)
     *
     * @param servicio, es el nombre del servicio.
     * @return
     * @throws SQLException
     */
    public LinkedList obtenerProveedoresDelServicio(String servicio) throws SQLException {

        return dao.obtenerProveedoresDelServicio(servicio);
    }

    /**
     * Método que se encarga de encontrar los servicios que un proveedor en
     * específico está ofreciendo; Los encuentra en la BD, a partir de la clave
     * del proveedor (ID).
     *
     * @param cveProveedor, único para cada proveedor.
     * @return la lista de servicios que ofrece dicho proveedor.
     * @throws SQLException, en caso de algún error con la conexión de la BD.
     */
    public LinkedList<Servicio> encontrarServiciosDelProveedor(int cveProveedor) throws SQLException {
        DAOProveedores daoProv = new DAOProveedores();

        LinkedList<Servicio> serviciosDeProveedor = daoProv.encontrarServiciosDelProveedor(cveProveedor);

        if (serviciosDeProveedor != null) {
            return serviciosDeProveedor;
        }

        return null;

    }

    public LinkedList<Proveedor> obtenerTodosLosProveedoresConSusServicios() throws SQLException {

        DAOProveedores daoProv = new DAOProveedores();
        LinkedList<Proveedor> proveedoresConServicios = daoProv.obtenerCoincidenciasDeBD("");

        return proveedoresConServicios;
    }

    public LinkedList<Proveedor> obtenerTodosLosProveedoresDeServicioBasico() throws SQLException {

        DAOProveedores daoProv = new DAOProveedores();
        LinkedList<Proveedor> proveedoresDeBanquetera = daoProv.obtenerProveedoresDelServicio("Banquetera");
        LinkedList<Proveedor> proveedoresDeCarpa = daoProv.obtenerProveedoresDelServicio("Carpa");

        proveedoresDeBanquetera = combinarServicios(proveedoresDeBanquetera, proveedoresDeCarpa);

        return proveedoresDeBanquetera;
    }

    public LinkedList<Proveedor> obtenerTodosLosProveedoresDeServicioIntermedio() throws SQLException {

        DAOProveedores daoProv = new DAOProveedores();
        LinkedList<Proveedor> proveedoresDeServicioBasico = obtenerTodosLosProveedoresDeServicioBasico();
        LinkedList<Proveedor> proveedoresDeIluminacion = daoProv.obtenerProveedoresDelServicio("Iluminacion");

        LinkedList<Proveedor> proveedoresDeServicioIntermedio = combinarServicios(proveedoresDeServicioBasico, proveedoresDeIluminacion);

        return proveedoresDeServicioIntermedio;
    }

    public LinkedList<Proveedor> obtenerTodosLosProveedoresDeServicioCompleto() throws SQLException {

        DAOProveedores daoProv = new DAOProveedores();
        LinkedList<Proveedor> proveedoresDeServicioIntermedio = obtenerTodosLosProveedoresDeServicioIntermedio();
        LinkedList<Proveedor> proveedoresDeMusica = daoProv.obtenerProveedoresDelServicio("Musica");
        LinkedList<Proveedor> proveedoresDeLugar = daoProv.obtenerProveedoresDelServicio("Lugar");
        
        LinkedList<Proveedor> proveedoresDeServicioCompleto = combinarServicios(proveedoresDeServicioIntermedio, proveedoresDeMusica);
        
        proveedoresDeServicioCompleto = combinarServicios(proveedoresDeServicioCompleto, proveedoresDeLugar);
        
        
        return proveedoresDeServicioCompleto;
    }

    
    private LinkedList<Proveedor> combinarServicios(LinkedList<Proveedor> proveedoresDePrimerServicio,
            LinkedList<Proveedor> proveedoresDeSegundoServicio) {

        for (Proveedor unProveedor : proveedoresDePrimerServicio) {
            for (Proveedor otroProveedor : proveedoresDeSegundoServicio) {
                if (unProveedor.getNombrePersona().equalsIgnoreCase(otroProveedor.getNombrePersona())) {
                    //Entonces ambos proveedores son iguales.
                    LinkedList<Servicio> servicios = otroProveedor.obtenerServiciosQueProvee();
                    for (Servicio unServicio : servicios) {
                        unProveedor.obtenerServiciosQueProvee().add(unServicio);
                    }
                }
            }
        }
        return proveedoresDePrimerServicio;
    }

}
