package Modelo;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:26:22 p.m.
 */
public class PaqueteBasico extends Paquete {

    private Proveedor proveedorBanquetera;
    private Proveedor proveedorIluminacion;

    /**
     * Constructor básico. Inicializamos en "nulo" los atributos.
     */
    public PaqueteBasico() {
        proveedorBanquetera = null;
        proveedorIluminacion = null;
    }

    /**
     * Inicializa un objeto con los siguientes atributos.
     *
     * @param id asociado al paquete.
     * @param nombre del paquete.
     * @param precio del paquete.
     * @param proveedorBanquetera asociado a este paquete.
     * @param proveedorIluminacion asociado a este paquete.
     */
    public PaqueteBasico(int id, String nombre, float precio,
            Proveedor proveedorBanquetera, Proveedor proveedorIluminacion) {
        super(id, nombre, precio);
        this.proveedorBanquetera = proveedorBanquetera;
        this.proveedorIluminacion = proveedorIluminacion;
    }

    /**
     * devuelve el id de este paquete.
     *
     * @return como entero.
     */
    @Override
    public int getIdPaquete() {
        return this.id;
    }

    /**
     * establece el ID del paquete.
     *
     * @param id en formato de int.
     */
    @Override
    public void setIdPaquete(int id) {
        this.id = id;
    }

    /**
     * Establece el precio total de este paquete.
     *
     * @return el precio en formato de Float.
     */
    @Override
    public float getPrecio() {
        return this.precio;
    }

    /**
     * Establece el precio del paquete.
     *
     * @param precio en formato de INT.
     */
    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el Nombre del paquete.
     *
     * @return como cadena String
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del paquete.
     *
     * @param nombre en formato de INT.
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * devuelve la información asociada a este objeto.
     *
     * @return en formato de String.
     */
    @Override
    public String toString() {
        return "Paquete Básico:" + "\n"
                + super.toString() + "\n"
                + "Proveedor de la Banquetera: " + proveedorBanquetera + "\n"
                + "Proveedor de la Iluminacion: " + proveedorIluminacion;
    }
}
