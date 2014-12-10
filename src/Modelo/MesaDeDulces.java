package Modelo;

/**
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:35:48 p.m.
 */
public class MesaDeDulces {

    private String NombreDeMesa;
    private float PrecioMesa;
    private int idMesaDulces;

    public MesaDeDulces(int idMesaDulces, String nombre, float precio) {
        this.idMesaDulces = idMesaDulces;
        this.NombreDeMesa = nombre;
        this.PrecioMesa = precio;
    }

    public String getNombreDeMesa() {
        return NombreDeMesa;
    }

    public void setNombreDeMesa(String nombreMesa) {
        this.NombreDeMesa = nombreMesa;
    }

    public void setPrecio(float precio) {
        this.PrecioMesa = precio;
    }

    public float getPrecio() {
        return PrecioMesa;
    }

    public int getIdMesaDulces() {
        return idMesaDulces;
    }

    public void setIdMesaDulces(int idMesaDulces) {
        this.idMesaDulces = idMesaDulces;
    }
}