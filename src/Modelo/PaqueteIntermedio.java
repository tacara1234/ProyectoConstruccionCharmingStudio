package Modelo;

/**
 * Modela el paquete intermedio que la empresa ofrece.
 *
 * @author Lalo
 * @version 2.0
 * @created 16-nov-2014 11:43:40 a.m.
 */
public class PaqueteIntermedio extends PaqueteBasico {

    private Proveedor provCarpa;

    /**
     * Inicializa un nuevo objeto del paquete intermedio.
     */
    public PaqueteIntermedio() {
        provCarpa = null;
    }

    /**
     *
     * Inicializa un nuevo objeto de tipo paquete intermedio.
     *
     * @param id es el identificador único del paquete.
     * @param nombre en formato de String de este paquete.
     * @param precio el precio de este paquete.
     * @param proveedorBanquetera asociado a este paquete.
     * @param proveedorIluminacion asociado a este paquete
     * @param provCarpa asociado a esta carpa.
     */
    public PaqueteIntermedio(int id, String nombre, float precio, Proveedor proveedorBanquetera,
            Proveedor proveedorIluminacion, Proveedor provCarpa) {
        super(id, nombre, precio, proveedorBanquetera, proveedorIluminacion);
        this.provCarpa = provCarpa;
    }

    /**
     * Devuelve el precio del paquete intermedio.
     *
     * @return precio.
     */
    @Override
    public float getPrecio() {
        return super.getPrecio();
    }

    /**
     * Establece el precio del paquete intermedio.
     *
     * @param precio
     */
    @Override
    public void setPrecio(float precio) {
        super.setPrecio(precio);
    }

    /**
     * Devuelve el Nombre del paquete.
     *
     * @return como cadena String
     */
    @Override
    public String getNombre() {
        return super.getNombre();
    }

    /**
     * Establece el nombre del paquete.
     *
     * @param nombre en formato de INT.
     */
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    /**
     * establece el ID del paquete.
     *
     * @param id en formato de int.
     */
    @Override
    public void setIdPaquete(int id) {
        super.setIdPaquete(id);
    }

    /**
     * devuelve el id del paquete asociada a este objeto.
     *
     * @return el objeto proveedor .
     */
    @Override
    public int getIdPaquete() {
        return super.getIdPaquete();
    }

    /**
     * devuelve el proveedor de la carpa asociada a este objeto.
     *
     * @return el objeto proveedor .
     */
    public Proveedor getProvCarpa() {
        return provCarpa;
    }

    /**
     * Establece el proveedor asociado a este paquete.
     *
     * @param provCarpa
     */
    public void setProvCarpa(Proveedor provCarpa) {
        this.provCarpa = provCarpa;
    }

    /**
     * devuelve la información asociada a este objeto.
     *
     * @return en formato de String.
     */
    @Override
    public String toString() {
        return "Paquete Intermedio:" + "\n"
                + super.toString() + "\n"
                + "Proveedor de la Carpa: " + provCarpa;
    }

}
