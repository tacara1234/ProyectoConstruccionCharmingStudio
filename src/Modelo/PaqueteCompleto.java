package Modelo;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:30:27 p.m.
 */
public class PaqueteCompleto extends PaqueteIntermedio {

    private Proveedor proveedorLugar;
    private Proveedor proveedorMusica;

    /**
     * Constructor básico. Inicializamos en "nulo" los atributos.
     */
    public PaqueteCompleto() {
        proveedorLugar = null;
        proveedorMusica = null;
    }

    /**
     * Inicializa un objeto con los siguientes atributos.
     *
     * @param id asociado al paquete.
     * @param nombre del paquete.
     * @param precio del paquete.
     * @param proveedorBanquetera asociado a este paquete.
     * @param proveedorIluminacion asociado a este paquete.
     * @param provCarpa asociada a este paquete.
     * @param proveedorLugar asociada a este paquete.
     * @param proveedorMusica asociada a este paquete.
     */
    public PaqueteCompleto(int id, String nombre, float precio, Proveedor proveedorBanquetera,
            Proveedor proveedorIluminacion, Proveedor provCarpa, Proveedor proveedorLugar,
            Proveedor proveedorMusica) {
        super(id, nombre, precio, proveedorBanquetera, proveedorIluminacion, provCarpa);
        this.proveedorLugar = proveedorLugar;
        this.proveedorMusica = proveedorMusica;
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
     * Establece el precio del paquete completo.
     *
     * @param precio
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
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Establece el proveedor asociado a este paquete.
     *
     * @param provCarpa
     */
    @Override
    public void setProvCarpa(Proveedor provCarpa) {
        super.setProvCarpa(provCarpa); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * devuelve el proveedor de la carpa asociada a este objeto.
     *
     * @return el objeto proveedor .
     */
    @Override
    public Proveedor getProvCarpa() {
        return super.getProvCarpa(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * devuelve el id del paquete asociada a este objeto.
     *
     * @return el objeto proveedor .
     */
    @Override
    public int getIdPaquete() {
        return super.getIdPaquete(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * establece el ID del paquete.
     *
     * @param id en formato de int.
     */
    @Override
    public void setIdPaquete(int id) {
        super.setIdPaquete(id); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the proveedorLugar
     */
    public Proveedor getProveedorLugar() {
        return proveedorLugar;
    }

    /**
     * @return the proveedorMusica
     */
    public Proveedor getProveedorMusica() {
        return proveedorMusica;
    }

    /**
     * @param proveedorLugar the proveedorLugar to set
     */
    public void setProveedorLugar(Proveedor proveedorLugar) {
        this.proveedorLugar = proveedorLugar;
    }

    /**
     * @param proveedorMusica the proveedorMusica to set
     */
    public void setProveedorMusica(Proveedor proveedorMusica) {
        this.proveedorMusica = proveedorMusica;
    }

    /**
     * devuelve la información asociada a este objeto.
     *
     * @return en formato de String.
     */
    @Override
    public String toString() {
        return "Paquete Completo: " + "\n"
                + super.toString()
                + "Proveedor de Lugar: " + proveedorLugar
                + "Proveedor de Música: " + proveedorMusica;
    }

}
