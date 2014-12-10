package Modelo;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:13:33 p.m.
 */
public class Persona {

    private int idPersona;
    private String nombrePersona;
    private String direccionPersona;
    private String telefonoPersona;
    private String correoPersona;

    /**
     * Establece un nuevo objeto de tipo persona, con sus respectivos atributos.
     *
     * @param id del objeto Persona.
     * @param nombre que se agregará en la BD.
     * @param direccion del objeto que se agregará a la BD.
     * @param telefono asociada a esta persona.
     * @param correo asociada a esta persona.
     */
    public Persona(int id, String nombre, String direccion, String telefono, String correo) {
        this.idPersona = id;
        this.nombrePersona = nombre;
        this.direccionPersona = direccion;
        this.telefonoPersona = telefono;
        this.correoPersona = correo;
    }

    /**
     * Devuelve el ID asociado a este objeto.
     *
     * @return un entero.
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * devuelve el nombre asociado a este objeto Persona.
     *
     * @return En formato de String.
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * Devuelve la dirección asociada a este objeto Persona.
     *
     * @return en formato de String.
     */
    public String getDireccionPersona() {
        return direccionPersona;
    }

    /**
     * El teléfono asociado a este objeto Persona.
     *
     * @return en formato de String.
     */
    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    /**
     * El correo asociado a este objeto Persona.
     *
     * @return en formato de String.
     */
    public String getCorreoPersona() {
        return correoPersona;
    }

    /**
     * Establece el Identificador de la persona.
     *
     * @param IdPersona único asociado a este objeto.
     */
    public void setIdPersona(int IdPersona) {
        this.idPersona = IdPersona;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombrePersona que estará asociado a este objeto. (En String).
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * Establece la dirección asociada a este objeto.
     *
     * @param direccionPersona en formato de String.
     */
    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    /**
     * Establece el teléfono asociada a este objeto.
     *
     * @param telefonoPersona en formato de String.
     */
    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    /**
     * Establece el correo asociada a este objeto.
     *
     * @param correoPersona en formato de String.
     */
    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }
    /**
     * Muestra la información asociada a este objeto.
     * @return en formato de String, todos los atributos de esta clase.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombrePersona + "Direccion:" + direccionPersona + telefonoPersona + correoPersona;
    }

}
