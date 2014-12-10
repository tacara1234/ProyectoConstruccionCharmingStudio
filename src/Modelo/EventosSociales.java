package Modelo;

import java.util.Date;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:34:14 p.m.
 */
public class EventosSociales {

    private int idEvento;
    private int idCliente;
    private int idMD;
    private String Fecha;
    private int idEmpleado;
    private float PrecioTotal;


    public EventosSociales(int idEvento, int idCliente, int idMD, String fecha,
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

    @Override
    public String toString() {
        return "EventosSociales{" + "idEvento=" + idEvento + ", idCliente=" + idCliente + ", idMD=" + idMD + ", Fecha=" + Fecha + ", idEmpleado=" + idEmpleado + ", PrecioTotal=" + PrecioTotal + '}';
    }

}
