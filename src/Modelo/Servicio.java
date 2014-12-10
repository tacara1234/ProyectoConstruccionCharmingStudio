package Modelo;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:21:37 p.m.
 */
public class Servicio {

    private int id;
    private String servNombre;
    private float costo;

    /**
     * Establece un nuevo objeto de tipo servicio, con sus respectivos
     * atributos.
     *
     * @param id
     * @param nombre
     */
    public Servicio(int id, String nombre) {
        this.id = id;
        this.servNombre = nombre;
        this.costo = 0;
    }

    /**
     * Crea un nuevo objeto de tipo servicio, con sus siguientes parámetros:
     *
     * @param id
     * @param servNombre
     * @param costo
     */
    public Servicio(int id, String servNombre, float costo) {
        this.id = id;
        this.servNombre = servNombre;
        this.costo = costo;
    }

    /**
     *Crea servicio sin clave asignada
     * @param nombre
     * @param costo
     */
    public Servicio(String nombre, float costo) {
        this.id = 0;
        this.servNombre = nombre;
        this.costo = costo;
    }

    /**
     *Constructor vacío
     */
    public Servicio() {
        
    }

    /**
     *Devuelve costo del servicio
     * @return
     */
    public float getCosto() {
        return costo;
    }

    /**
     *Establece costo del servicio
     * @param costo
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     *obtiene nombre del servicio
     * @return
     */
    public String getServNombre() {
        return servNombre;
    }

    /**
     *establece nombre  del servicio
     * @param servNombre
     */
    public void setServNombre(String servNombre) {
        this.servNombre = servNombre;
    }

    /**
     *Obtiene id del servicio
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *establece id del servicio
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Servicio: " + "Id: " + id + " Nombre de servicio: " + servNombre
                + " Costo: " + costo;
    }

}
