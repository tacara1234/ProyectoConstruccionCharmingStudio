package Modelo;

/**
 * Clase que modela a un Cliente de la vida Real.
 * @author Lalo
 * @version 1.0
 * @created 19-sep-2014 01:18:06 p.m.
 */
public class Cliente extends Persona {

    /**
     * Este constructor inicializa un nuevo objeto de tipo cliente, con sus
     * respectivos atributos.
     *
     * @param id del cliente.
     * @param nombre del cliente
     * @param direccion del cliente
     * @param telefono del cliente
     * @param correo del cliente
     */
    public Cliente(int id, String nombre, String direccion, String telefono, String correo) {
        super(id, nombre, direccion, telefono, correo);
    }

    /**
     * Devuelve la información relacionada a este objeto.
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
