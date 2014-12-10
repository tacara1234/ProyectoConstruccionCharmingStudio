package Modelo;

/**
 * Clase que modelará lo relacionado a un evento social en la vida real.
 *
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:34:14 p.m.
 */
public class EventoSocial {

    private int idEvento;
    private int idCliente;
    private int idMD;
    private String Fecha;
    private int idEmpleado;
    private float PrecioTotal;

    /**
     *Inicializa un objeto de tipo Evento.
     * 
     * @param idEvento es el identificador único del evento a guardar.
     * @param idCliente es el identificador del cliente asociado a este evento
     * @param idMD es el identificador asociado a la mesa de dulces a usar en el evento,
     * en caso de que no haya se establece en 0.
     * @param fecha es la fecha en que se llevará a cabo el evento.
     * @param evtPrecioTotal es el precio que la empresa cobrará por sus servicios.
     * @param idEmpleado es el identificador del empleado responsable a organizar el evento.
     */
    public EventoSocial(int idEvento, int idCliente, int idMD, String fecha,
            float evtPrecioTotal, int idEmpleado) {
        this.idCliente = idCliente;
        this.idEvento = idEvento;
        this.idMD = idMD;
        this.Fecha = fecha;
        this.idEmpleado = idEmpleado;
        this.PrecioTotal = evtPrecioTotal;
    }

    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @return the idMD
     */
    public int getIdMD() {
        return idMD;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @return the PrecioTotal
     */
    public float getPrecioTotal() {
        return PrecioTotal;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @param idMD the idMD to set
     */
    public void setIdMD(int idMD) {
        this.idMD = idMD;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * puede que esta no sirva, no hace algo
     *
     * @param precio.
     */
    public void setPrecioTotal(float precio) {
        this.PrecioTotal = precio;
    }

    /** 
     * Obtiene la información asociada a esta clase.
     * @return
     */
    @Override
    public String toString() {
        return "Evento Social \n" + "idEvento=" + idEvento + ", idCliente=" + idCliente + 
                ", idMD=" + idMD + ", Fecha=" + Fecha + ", idEmpleado=" + idEmpleado +
                ", PrecioTotal=" + PrecioTotal ;
    }

}
