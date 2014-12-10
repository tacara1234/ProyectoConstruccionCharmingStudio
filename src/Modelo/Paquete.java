package Modelo;

/**
 * Clase que modelará un paquete que ofrece la empresa CharmingStudio.
 *
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:23:47 p.m.
 */
public abstract class Paquete {

    int id;
    String nombre;
    protected float precio;

    /**
     * Inicializa un nuevo objeto de tipo paquete.
     *
     * @param idPaquete es el identificador asociado al paquete.
     * @param nombrePaquete que está asociado al identificador del mismo.
     * @param precioPaquete que se cobra por el paquete.
     */
    public Paquete(int idPaquete, String nombrePaquete, float precioPaquete) {
        this.id = idPaquete;
        this.nombre = nombrePaquete;
        this.precio = precioPaquete;
    }

    /**
     * Constructor Vacío. Java inicializa todos los atributos por nosotros; si
     * es String lo deja vacío, si es un número lo deja en 0, etc.
     */
    public Paquete() {
    }

    /**
     * Devuelve el Identificador del paquete.
     *
     * @return identificador (int).
     */
    public abstract int getIdPaquete();

    /**
     * Establece el id del paquete.
     *
     * @param id en formato de INT.
     */
    public abstract void setIdPaquete(int id);

    /**
     * Devuelve el precio del paquete.
     *
     * @return en formato de Float.
     */
    public abstract float getPrecio();

    /**
     * Establece el precio del paquete.
     *
     * @param precio en formato de INT.
     */
    public abstract void setPrecio(float precio);

    /**
     * Devuelve el Nombre del paquete.
     *
     * @return como cadena String
     */
    public abstract String getNombre();

    /**
     * Establece el nombre del paquete.
     *
     * @param nombre en formato de INT.
     */
    public abstract void setNombre(String nombre);

    /**
     * devuelve la información asociada a este objeto.
     *
     * @return en formato de String.
     */
    @Override
    public String toString() {
        return "Identificador: " + id + "\n"
                + "Nombre: " + nombre + "\n"
                + "Precio: " + precio;
    }
}
