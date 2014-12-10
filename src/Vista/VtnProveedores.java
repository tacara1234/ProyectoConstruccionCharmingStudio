/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorProveedores;
import Modelo.Proveedor;
import Modelo.Servicio;

import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class VtnProveedores extends javax.swing.JFrame {

    private static final int SI = 0;
    private static final int MOSTRAR_DOS_OPCIONES = 0;
    private static VtnProveedores instanciaDeVtnProveedores = new VtnProveedores();

    /**
     * Creates new form VtnProveedores
     */
    public VtnProveedores() {
        initComponents();
        //colocamos la ventana en el centro.
        setLocationRelativeTo(null);
    }

    public static VtnProveedores getInstanciaDeVtnProveedores() {
        return instanciaDeVtnProveedores;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProveedores = new javax.swing.JTable();
        btnMostrarProveedores = new javax.swing.JButton();
        txtNombreProveedor = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        tituloProveedores = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Proveedores");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        listaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "Telefono", "Correo", "Banquetera", "Carpa", "Luces", "Lugar", "Música"
            }
        ));
        jScrollPane1.setViewportView(listaProveedores);

        btnMostrarProveedores.setText("Buscar");
        btnMostrarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProveedoresActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tituloProveedores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloProveedores.setText("Proveedores");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrarProveedores)
                .addGap(395, 395, 395))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(btnModificar)
                                .addGap(54, 54, 54)
                                .addComponent(btnEliminar))
                            .addComponent(btnAgregar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(tituloProveedores)))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloProveedores)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarProveedores))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProveedorActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        VtnAgrega_oModificaProveedor vtnAgregaProveedores = VtnAgrega_oModificaProveedor.getInstanciaVtnAgregaoModificaProveedor();
        vtnAgregaProveedores.setTitle("Agregará un proveedor");
        vtnAgregaProveedores.setVisible(true);

        cerrarEstaVentana();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnMostrarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProveedoresActionPerformed

        /*Declaramos el controlador que busca los provs
         en la base de datos:                              */
        ControladorProveedores ctrlBuscaProveedores = new ControladorProveedores();
        String nombreProveedor = this.txtNombreProveedor.getText();
        try {
            /*El controlador, devuelve una lista con los provs que coincidieron con la búsqueda:*/
            LinkedList<Proveedor> listaDeProveedores
                    = ctrlBuscaProveedores.obtenerCoincidenciasPorNombre(nombreProveedor);
            llenarTablaDeDatos(listaDeProveedores);

        } catch (SQLException ex) {

            //si hay Excepción, mostramos el mensaje en pantalla:
            mostrarMensaje("Hubo un error: " + ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_btnMostrarProveedoresActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VtnPrincipal vtnRegreso = VtnPrincipal.getInstanciaDeVtnPrincipal();
        vtnRegreso.setVisible(true);
        cerrarEstaVentana();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //creamos un proveedor temporal, a partir del renglón seleccionado en la tabla:
        Proveedor proveedorTemporal = obtenerInformacionDeRenglonSelecccionado();

        /*Si el proveedor temporal fue nulo, entonces no se seleccionó
         alguno de la tabla, por eso nos interesa más cuando no
         sea nulo, es el caso más común:*/
        if (proveedorTemporal != null) {
            //obtenemos la instancia de la ventana: 
            VtnAgrega_oModificaProveedor vtnModificaProveedor
                    = VtnAgrega_oModificaProveedor.getInstanciaVtnAgregaoModificaProveedor();

            //Obtenemos el id del proveedor que se seleccionó en la tabla:
            String strId = String.valueOf(  proveedorTemporal.getIdPersona()  );

            /*El id del proveedor que aparece en la tabla, lo ponemos 
             en el JLabel de la siguiente Ventana: */
            vtnModificaProveedor.getLbId().setText(strId);
            //Obtenemos el nombre del prov que se seleccionó en la tabla:
            String nombre = proveedorTemporal.getNombrePersona();
            /*El nombre del prov que aparece en la tabla, lo ponemos 
             en el JTextField de la siguiente Ventana: */
            vtnModificaProveedor.getTxtNombreProveedor().setText(nombre);

            //Obtenemos la direccción del prov que se seleccionó en la tabla:
            String direccion = proveedorTemporal.getDireccionPersona();
            /*La dirección del provs que aparece en la tabla, lo ponemos 
             en el JTextField que le corresponde, de la siguiente Ventana: */
            vtnModificaProveedor.getTxtDireccionProveedor().setText(direccion);

            //Obtenemos el teléfono del prov que se seleccionó en la tabla:
            String telefono = proveedorTemporal.getTelefonoPersona();
            /*El teléfono del prov que aparece en la tabla, lo ponemos 
             en el JTextField que le corresponde, de la siguiente Ventana: */
            vtnModificaProveedor.getTxtTelefonoProveedor().setText(telefono);

            //Obtenemos el correo del cliente que se seleccionó en la tabla:
            String correo = proveedorTemporal.getCorreoPersona();
            /*El correo del cliente que aparece en la tabla, lo ponemos 
             en el JTextField que le corresponde, de la siguiente Ventana: */
            vtnModificaProveedor.getTxtCorreoProveedor().setText(correo);

            activarServiciosDeProveedor(proveedorTemporal.getServiciosQueProvee());

            //le ponemos el título a la ventana:
            vtnModificaProveedor.setTitle("Modificará la información de un proveedor");
            /*ponemos en verdadero un booleano, indicando que 
             se modificará un prov: */
            vtnModificaProveedor.setSeModificaraProveedor(true);
            //hacemos visible la ventana:
            vtnModificaProveedor.setVisible(true);

            //cerramos esta ventana:
            cerrarEstaVentana();
        } else {
            //quiere decir que el usuario no ha seleccionado algún prov
            //la tabla:
            mostrarMensaje("No seleccionaste algún proveedor de la tabla.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void activarServiciosDeProveedor(LinkedList<Servicio> servicio) {
        //Como estamos usando Singleton, entonces los cambios que se hagan aquí se conservarán:
        VtnAgrega_oModificaProveedor vtnModificaProveedor = VtnAgrega_oModificaProveedor.getInstanciaVtnAgregaoModificaProveedor();

        for (Servicio serv : servicio) {

            /*Para cada uno de los servicios del proveedor,
             activamos su correspondiente CheckBox
             y escribimos su costo en su textField*/
            if (serv.getServNombre().equals("Banquetera")) {
                vtnModificaProveedor.getCbBanqueteraEvento().setSelected(true);
                vtnModificaProveedor.getTxtBanqueterEvento().setText(Float.toString(serv.getCosto()));
                vtnModificaProveedor.getTxtBanqueterEvento().setEditable(true);
            }
            if (serv.getServNombre().equals("Iluminacion")) {
                vtnModificaProveedor.getCbLucesEvento().setSelected(true);
                vtnModificaProveedor.getTxtLucesEvento().setText(Float.toString(serv.getCosto()));
                vtnModificaProveedor.getTxtLucesEvento().setEditable(true);
            }
            if (serv.getServNombre().equals("Carpa")) {
                vtnModificaProveedor.getCbCarpaEvento().setSelected(true);
                vtnModificaProveedor.getTxtCarpaEvento().setText(Float.toString(serv.getCosto()));
                vtnModificaProveedor.getTxtCarpaEvento().setEditable(true);
            }
            if (serv.getServNombre().equals("Lugar")) {
                vtnModificaProveedor.getCbLugarEvento().setSelected(true);
                vtnModificaProveedor.getTxtLugarEvento().setText(Float.toString(serv.getCosto()));
                vtnModificaProveedor.getTxtLugarEvento().setEditable(true);
            }
            if (serv.getServNombre().equals("Musica")) {
                vtnModificaProveedor.getCbMusicaEvento().setSelected(true);
                vtnModificaProveedor.getTxtMusicaEvento().setText(Float.toString(serv.getCosto()));
                vtnModificaProveedor.getTxtMusicaEvento().setEditable(true);
            }
        }

    }


    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        /*Obtenemos el prov seleccionado de la tabla:*/
        Proveedor proveedorQueSeEliminara = obtenerInformacionDeRenglonSelecccionado();

        //checamos si se seleccionó algún prov de la tabla,
        //es decir, si no es nulo.
        if (proveedorQueSeEliminara != null) {
            //le preguntamos al prov si de verdad, desea eliminar el 
            //prov seleccionado:
            int opcionEliminar = JOptionPane.showConfirmDialog(null,
                    "Seguro desea eliminar el proveedor seleccionado?",
                    "Eliminará el proveedor. ",
                    MOSTRAR_DOS_OPCIONES
            );
            //si lo que escogió el usuario es igual a un "si"
            if (opcionEliminar == SI) {
                //creamos el controlador de prov:
                ControladorProveedores controlProveedor = new ControladorProveedores();

                try {
                    controlProveedor.eliminar(proveedorQueSeEliminara.getIdPersona());
                    mostrarMensaje("Proveedor eliminado");
                } catch (SQLException ex) {
                    mostrarMensaje("Proveedor no eliminado. Error: " + ex.getLocalizedMessage());
                }
            }
        } else {
            mostrarMensaje("No ha seleccionado algún proveedor de la tabla");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
//declaramos las constantes de las columnas, donde está la información:
    private static final int columnaId = 0, columnaNombre = 1, columnaDireccion = 2,
            columnaTelefono = 3, columnaCorreo = 4;

    private Proveedor obtenerInformacionDeRenglonSelecccionado() {
        //obtiene el número del renglón seleccionado en la tabla.
        int numDeRenglonSeleccionado = this.listaProveedores.getSelectedRow();

        /*Si es negativo, quiere decir que ningún renglón ha sido seleccionado:*/
        if (numDeRenglonSeleccionado < 0) {
            return null;
        }

        //obtenemos la información del renglón seleccionado.
        int id = (int) listaProveedores.getValueAt(numDeRenglonSeleccionado, columnaId);
        String nombre = (String) listaProveedores.getValueAt(numDeRenglonSeleccionado, columnaNombre);
        String direccion = (String) listaProveedores.getValueAt(numDeRenglonSeleccionado, columnaDireccion);
        String telefono = (String) listaProveedores.getValueAt(numDeRenglonSeleccionado, columnaTelefono);
        String correo = (String) listaProveedores.getValueAt(numDeRenglonSeleccionado, columnaCorreo);

        Proveedor prov = new Proveedor(id, nombre, direccion, telefono, correo);

        ControladorProveedores controladorProv = new ControladorProveedores();
        try {
            
            LinkedList<Servicio> serviciosDeProveedor
                    = controladorProv.encontrarServiciosDelProveedor(id);
            prov.setServiciosQueProvee(serviciosDeProveedor);
            
        } catch (SQLException ex) {
            mostrarMensaje("Error con la conexión de la BD. " + ex.getLocalizedMessage());
        }

        return prov;
    }

    private void llenarTablaDeDatos(LinkedList<Proveedor> listaDeProveedores) {

        //Declaramos las columnas:        
        Object columnasDeDatos[] = new Object[10];

        //obtenemos el modelo default de la tabla:
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) this.listaProveedores.getModel();

        limpiarTabla();

        if (listaDeProveedores == null) {
            return;
        }

        //agregamos a cada columna los datos que le corresponden:
        for (Proveedor proveedor : listaDeProveedores) {
            columnasDeDatos[columnaId] = proveedor.getIdPersona();
            columnasDeDatos[columnaNombre] = proveedor.getNombrePersona();
            columnasDeDatos[columnaDireccion] = proveedor.getDireccionPersona();
            columnasDeDatos[columnaTelefono] = proveedor.getTelefonoPersona();
            columnasDeDatos[columnaCorreo] = proveedor.getCorreoPersona();

            columnasDeDatos = (Object[]) verificarServiciosDeProveedor(proveedor.getServiciosQueProvee(),
                    columnasDeDatos);

            //agregamos los datos de cada columna en cada renglón:
            modeloDeLaTabla.addRow(columnasDeDatos);
        }

        //establecemos a nuestra tabla, el modelo que tenía:
        this.listaProveedores.setModel(modeloDeLaTabla);

    }

    private static final int columnaBanquetera = 5;
    private static final int columnaCarpa = 6;
    private static final int columnaIluminacion = 7;
    private static final int columnaLugar = 8;
    private static final int columnaMusica = 9;

    private Object verificarServiciosDeProveedor(LinkedList<Servicio> servicios, Object[] datos) {
        //Establecemos en "No" la columnas, ya que si hay un servicio, solo se ponen en si.
        datos = inicializarColumnas(datos);
        
        
        for (Servicio cada : servicios) {
            switch (cada.getServNombre()) {
                case "Banquetera":
                    datos[columnaBanquetera] = "Si";
                    break;
                case "Carpa":
                    datos[columnaCarpa] = "Si";
                    break;
                case "Iluminacion":
                    datos[columnaIluminacion] = "Si";
                    break;
                case "Lugar":
                    datos[columnaLugar] = "Si";
                    break;
                case "Musica":
                    datos[columnaMusica] = "Si";
                    break;
            }
        }
        return datos;
    }

    private Object[] inicializarColumnas(Object[] datos) {
        for (int i = columnaBanquetera; i <= columnaMusica; i++) {
            datos[i] = "No";
        }
        return datos;
    }

    private void limpiarTabla() {
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) this.listaProveedores.getModel();
        for (int i = 0; i < listaProveedores.getRowCount(); i++) {
            modeloDeLaTabla.removeRow(0);
            i -= 1;
        }
    }

    private void cerrarEstaVentana() {
        borrarDatos();
        this.dispose();
    }

    private void borrarDatos() {
        this.txtNombreProveedor.setText("");
        llenarTablaDeDatos(null);

    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Cuidado", 0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VtnProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnProveedores().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarProveedores;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaProveedores;
    private javax.swing.JLabel tituloProveedores;
    private javax.swing.JTextField txtNombreProveedor;
    // End of variables declaration//GEN-END:variables
}
