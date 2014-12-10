package Modelo;

/**
 * Clase que modela a una persona en la vida real.
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:15:46 p.m.
 */
public class Empleado extends Persona {

    private float empDesempenio;
    private float empSueldo;

    private static final int ID_POR_DEFECTO = 0;

    private static final String SIN_NOMBRE = "";
    private static final String SIN_DIRECCCION = "";
    private static final String SIN_TELEFONO = "";
    private static final String SIN_CORREO = "";

    /**
     * Crea un nuevo objeto de tipo Empleado, pero todo está en nulo.
     */
    public Empleado() {
        super(ID_POR_DEFECTO, SIN_NOMBRE, SIN_DIRECCCION, SIN_TELEFONO, SIN_CORREO);
        this.empDesempenio = 0;
        this.empSueldo = 0;
    }

    /**
     * Este constructor inicializa un nuevo objeto de tipo empleado, con sus
     * respectivos atributos.
     *
     * @param id es el identificador único de este objeto.
     * @param nombre es el nombre asociado a este objeto en la BD
     * @param direccion es la dirección asociada a este objeto en la BD
     * @param telefono asociado a este objeto
     * @param correo asociado a este objeto
     * @param desempenio asociado a este objeto de tipo empleado
     * @param sueldo que tendrá el empleado.
     */
    public Empleado(int id, String nombre, String direccion, String telefono, String correo, float desempenio, float sueldo) {
        super(id, nombre, direccion, telefono, correo);
        this.empDesempenio = desempenio;
        this.empSueldo = sueldo;

    }

    /**
     * Devuelve el desempeño actual del cliente.
     *
     * @return desempeño.
     */
    public float getEmpDesempenio() {
        return empDesempenio;
    }

    /**
     * Devuelve el sueldo actual del empleado.
     *
     * @return sueldo.
     */
    public float getEmpSueldo() {
        return empSueldo;
    }

    /**
     * Establece el desempeño del empleado actual.
     *
     * @param empDesempenio
     */
    public void setEmpDesempenio(float empDesempenio) {
        this.empDesempenio = empDesempenio;
    }

    /**
     * Establece el sueldo del empleado actual.
     *
     * @param empSueldo
     */
    public void setEmpSueldo(float empSueldo) {
        this.empSueldo = empSueldo;
    }

    /**
     * Establece el correo de esta persona.
     *
     * @param correoPersona asociada a este objeto.
     */
    @Override
    public void setCorreoPersona(String correoPersona) {
        super.setCorreoPersona(correoPersona); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Establece el teléfono de esta persona.
     *
     * @param telefonoPersona asociada a este objeto.
     */
    @Override
    public void setTelefonoPersona(String telefonoPersona) {
        super.setTelefonoPersona(telefonoPersona); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Establece la dirección de esta persona.
     *
     * @param direccionPersona asociada a este objeto.
     */
    @Override
    public void setDireccionPersona(String direccionPersona) {
        super.setDireccionPersona(direccionPersona); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Establece el nombre de esta persona.
     *
     * @param nombrePersona asociada a este objeto.
     */
    @Override
    public void setNombrePersona(String nombrePersona) {
        super.setNombrePersona(nombrePersona); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Establece el ID de esta persona.
     *
     * @param IdPersona asociada a este objeto.
     */
    @Override
    public void setIdPersona(int IdPersona) {
        super.setIdPersona(IdPersona); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * obtiene el correo de esta persona.
     *
     * @return en formato de String.
     */
    @Override
    public String getCorreoPersona() {
        return super.getCorreoPersona(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * obtiene el telefono de esta persona.
     *
     * @return en formato de String.
     */
    @Override
    public String getTelefonoPersona() {
        return super.getTelefonoPersona(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * obtiene el Direccion de esta persona.
     *
     * @return en formato de String.
     */
    @Override
    public String getDireccionPersona() {
        return super.getDireccionPersona(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * obtiene el nombre de esta persona.
     *
     * @return en formato de String.
     */
    @Override
    public String getNombrePersona() {
        return super.getNombrePersona(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * obtiene el Id de esta persona.
     *
     * @return en formato de String.
     */
    @Override
    public int getIdPersona() {
        return super.getIdPersona(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Regresa el ID y nombre del empleado.
     *
     * @return en formato de String
     */
    public String obtenerInfoBasicoDeEmpleado() {

        return "" + getIdPersona() + " " + getNombrePersona();
    }

    /**
     * obtiene toda la información asociada a este objeto.
     *
     * @return en formato de String.
     */
    @Override
    public String toString() {
        return "Empleado{" + super.toString() + " empDesempenio=" + empDesempenio + ", empSueldo=" + empSueldo + '}';
    }

}
