/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorEmpleado;
import Modelo.Empleado;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class VtnEmpleados extends javax.swing.JFrame {

    private static VtnEmpleados instanciaDeVtnEmpleados = new VtnEmpleados();
    //declaración de constantes:
    private final int SI = 0;
    private final int MOSTRAR_DOS_OPCIONES = 0;

    /**
     * Creates new form VtnEmpleados
     */
    public VtnEmpleados() {
        initComponents();
        //colocamos la ventana en el centro.
        setLocationRelativeTo(null);
    }

    public static VtnEmpleados getInstanciaDeVtnEmpleados() {
        return instanciaDeVtnEmpleados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JTable();
        btnMostrarEmpleados = new javax.swing.JButton();
        txtNombreEmpleado = new javax.swing.JTextField();
        btnRegresarVtnPrincipal = new javax.swing.JButton();
        btnModificarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Empleados");

        btnAgregarEmpleado.setText("Agregar");
        btnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadoActionPerformed(evt);
            }
        });

        listaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Correo", "Telefono", "Direccion", "Desempeño", "Sueldo"
            }
        ));
        listaEmpleados.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                listaEmpleadosVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(listaEmpleados);

        btnMostrarEmpleados.setText("Buscar");
        btnMostrarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarEmpleadosActionPerformed(evt);
            }
        });

        txtNombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmpleadoActionPerformed(evt);
            }
        });

        btnRegresarVtnPrincipal.setText("Regresar");
        btnRegresarVtnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarVtnPrincipalActionPerformed(evt);
            }
        });

        btnModificarEmpleado.setText("Modificar");
        btnModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Empleados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrarEmpleados))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnModificarEmpleado)
                                .addGap(39, 39, 39)
                                .addComponent(btnAgregarEmpleado)
                                .addGap(51, 51, 51)
                                .addComponent(btnEliminarEmpleado)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(545, 545, 545))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresarVtnPrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarEmpleados))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarEmpleado)
                    .addComponent(btnAgregarEmpleado)
                    .addComponent(btnEliminarEmpleado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnRegresarVtnPrincipal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpleadoActionPerformed

    private void btnRegresarVtnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarVtnPrincipalActionPerformed
        VtnPrincipal vtnRegreso = VtnPrincipal.getInstanciaDeVtnPrincipal();
        vtnRegreso.setVisible(true);
        cerrarEstaVentana();
    }//GEN-LAST:event_btnRegresarVtnPrincipalActionPerformed

    private void btnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformed

        VtnAgrega_oModificaEmpleados vtnAgregaEmpleados = VtnAgrega_oModificaEmpleados.getInstanciaVtnAgregaoModificaEmpleado();
        vtnAgregaEmpleados.setTitle("Agregará un empleado");
        vtnAgregaEmpleados.setVisible(true);

        cerrarEstaVentana();
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformed

    //VERIFICAR SI ESTE LLENADOeScORRECTO
    private void btnMostrarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEmpleadosActionPerformed

        /*Declaramos el controlador que busca los empleados
         en la base de datos:                              */
        String nombreEmpleado = this.txtNombreEmpleado.getText();
        ControladorEmpleado ctrlEmpleado = new ControladorEmpleado();
        
        DefaultTableModel modeloDeLaTabla = ctrlEmpleado.obtenerListaActualizadaDeEmpleados(this.listaEmpleados,nombreEmpleado);
        this.listaEmpleados.setModel(modeloDeLaTabla);

    }//GEN-LAST:event_btnMostrarEmpleadosActionPerformed

    private void btnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoActionPerformed
        //creamos un empleado temporal, a partir del renglón seleccionado en la tabla:
        Empleado empleadoTemporal = obtenerInformacionDeRenglonSelecccionado();

        /*Si el empleado temporal fue nulo, entonces no se seleccionó
         alguno de la tabla, por eso nos interesa más cuando no
         sea nulo, es el caso más común:*/
        if (empleadoTemporal != null) {
            //obtenemos la instancia de la ventana: 
            VtnAgrega_oModificaEmpleados vtnModificaEmpleado = VtnAgrega_oModificaEmpleados.getInstanciaVtnAgregaoModificaEmpleado();

            //Obtenemos el id del empleado que se seleccionó en la tabla:
            String id = Integer.toString(empleadoTemporal.getIdPersona());
            /*El id del empleado que aparece en la tabla, lo ponemos 
             en el JTextField de la siguiente Ventana: */
            vtnModificaEmpleado.getTxtIdEmpleado().setText(id);

            //Obtenemos el nombre del empleado que se seleccionó en la tabla:
            String nombre = empleadoTemporal.getNombrePersona();
            /*El nombre del empleado que aparece en la tabla, lo ponemos 
             en el JTextField de la siguiente Ventana: */
            vtnModificaEmpleado.getTxtNombreEmpleado().setText(nombre);

            //Obtenemos la direccción del empleado que se seleccionó en la tabla:
            String direccion = empleadoTemporal.getDireccionPersona();
            /*La dirección del empleado que aparece en la tabla, lo ponemos 
             en el JTextField que le corresponde, de la siguiente Ventana: */
            vtnModificaEmpleado.getTxtDireccionEmpleado().setText(direccion);

            //Obtenemos el teléfono del empleado que se seleccionó en la tabla:
            String telefono = empleadoTemporal.getTelefonoPersona();
            /*El teléfono del empleado que aparece en la tabla, lo ponemos 
             en el JTextField que le corresponde, de la siguiente Ventana: */
            vtnModificaEmpleado.getTxtTelefonoEmpleado().setText(telefono);

            //Obtenemos el correo del empleado que se seleccionó en la tabla:
            String correo = empleadoTemporal.getCorreoPersona();
            /*El correo del empleado que aparece en la tabla, lo ponemos 
             en el JTextField que le corresponde, de la siguiente Ventana: */
            vtnModificaEmpleado.getTxtCorreoEmpleado().setText(correo);

            //Obtenemos el sueldo del empleado que se seleccionó en la tabla:
            float sueldo = empleadoTemporal.getEmpSueldo();
            /*El correo del empleado que aparece en la tabla, lo ponemos 
             en el JTextField que le corresponde, de la siguiente Ventana: */
            vtnModificaEmpleado.getTxtSueldoEmpleado().setText(Float.toString(sueldo));

            //Obtenemos el sueldo del empleado que se seleccionó en la tabla:
            float desempenio = empleadoTemporal.getEmpDesempenio();

            establecerDesempenioEnVtnEmpleados(desempenio, vtnModificaEmpleado);

            //le ponemos el título a la ventana:
            vtnModificaEmpleado.setTitle("Modificará la información de un empleado");
            /*ponemos en verdadero un booleano, indicando que 
             se modificará un empleado: */
            vtnModificaEmpleado.setSeModificaraEmpleado(true);
            //hacemos visible la ventana:
            vtnModificaEmpleado.setVisible(true);

            vtnModificaEmpleado.setEmpleadoDeLaTabla(empleadoTemporal);

            //cerramos esta ventana:
            cerrarEstaVentana();
        } else {
            //quiere decir que el usuario no ha seleccionado algún empleado
            //la tabla:
            mostrarMensajeEnPantalla("No seleccionaste algún empleado de la tabla.");
        }

    }//GEN-LAST:event_btnModificarEmpleadoActionPerformed

    private void establecerDesempenioEnVtnEmpleados(float desempenio, VtnAgrega_oModificaEmpleados vtnModificaEmpleado) {
        if (desempenio == vtnModificaEmpleado.getValCbDesempenio1()) {

            vtnModificaEmpleado.getCbDesempenio1().setSelected(true);
        }
        if (desempenio == vtnModificaEmpleado.getValCbDesempenio2()) {

            vtnModificaEmpleado.getCbDesempenio2().setSelected(true);
        }
        if (desempenio == vtnModificaEmpleado.getValCbDesempenio3()) {

            vtnModificaEmpleado.getCbDesempenio3().setSelected(true);
        }

        if (desempenio == vtnModificaEmpleado.getValCbDesempenio4()) {

            vtnModificaEmpleado.getCbDesempenio4().setSelected(true);
        }

        if (desempenio == vtnModificaEmpleado.getValCbDesempenio5()) {

            vtnModificaEmpleado.getCbDesempenio5().setSelected(true);
        }
    }

    private Empleado obtenerInformacionDeRenglonSelecccionado() {
        //obtiene el número del renglón seleccionado en la tabla.
        int numDeRenglonSeleccionado = this.listaEmpleados.getSelectedRow();

        /*Si es negativo, quiere decir que ningún renglón ha sido seleccionado:*/
        if (numDeRenglonSeleccionado < 0) {
            return null;
        }

        //declaramos las constantes, de las columnas donde está la información:
        int columnaId = 0;
        int columnaNombre = 1;
        int columnaDireccion = 2;
        int columnaTelefono = 3;
        int columnaCorreo = 4;
        int columnaDesempenio = 5;
        int columnaSueldo = 6;

        //obtenemos la información del renglón seleccionado.
        int id = (int) listaEmpleados.getValueAt(numDeRenglonSeleccionado, columnaId);
        String nombre = (String) listaEmpleados.getValueAt(numDeRenglonSeleccionado, columnaNombre);
        String direccion = (String) listaEmpleados.getValueAt(numDeRenglonSeleccionado, columnaDireccion);
        String telefono = (String) listaEmpleados.getValueAt(numDeRenglonSeleccionado, columnaTelefono);
        String correo = (String) listaEmpleados.getValueAt(numDeRenglonSeleccionado, columnaCorreo);
        float desempenio = (float) listaEmpleados.getValueAt(numDeRenglonSeleccionado, columnaDesempenio);
        float sueldo = (float) listaEmpleados.getValueAt(numDeRenglonSeleccionado, columnaSueldo);

        //regresamos el empelado.
        return new Empleado(id, nombre, direccion, telefono, correo, desempenio, sueldo);

    }

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        /*Obtenemos el empleado seleccionado de la tabla:*/
       // int idEmpleadoQueSeEliminara = obtenerIdEmpleadoAEliminar();
        int idEmpleadoQueSeEliminara = obtenerInformacionDeRenglonSelecccionado().getIdPersona();

        //checamos si se seleccionó algún empleado de la tabla,
        //es decir, si no es nulo.
        if (idEmpleadoQueSeEliminara >= 0) {
            //le preguntamos al empleado si de verdad, desea eliminar el 
            //empleado seleccionado:
            int opcionEliminar = JOptionPane.showConfirmDialog(null,
                    "Seguro desea eliminar el empleado seleccionado?",
                    "Eliminará el empleado. ",
                    MOSTRAR_DOS_OPCIONES);
            //si lo que escogió el usuario es igual a un "si"
            if (opcionEliminar == SI) {
                //creamos el controlador de empleados:
                ControladorEmpleado controlEmpleado = new ControladorEmpleado();

                try {
                    controlEmpleado.eliminar(idEmpleadoQueSeEliminara);
                    mostrarMensajeEnPantalla("Empleado eliminado");
                } catch (SQLException ex) {
                    mostrarMensajeEnPantalla("Empleado no eliminado. Error: " + ex.getLocalizedMessage());
                }
            }
        } else {
            mostrarMensajeEnPantalla("No ha seleccionado algún empleado de la tabla");
        }
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void listaEmpleadosVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_listaEmpleadosVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_listaEmpleadosVetoableChange

    private void limpiarLista() {
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) this.listaEmpleados.getModel();
        for (int i = 0; i < listaEmpleados.getRowCount(); i++) {
            modeloDeLaTabla.removeRow(0);
            i -= 1;
        }
    }

    private void cerrarEstaVentana() {
        borrarCampos();
        this.dispose();
    }

    private void borrarCampos() {
        this.txtNombreEmpleado.setText("");
        limpiarLista();
    }

    private void mostrarMensajeEnPantalla(String mensaje) {
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
            java.util.logging.Logger.getLogger(VtnEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnEmpleados().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JButton btnMostrarEmpleados;
    private javax.swing.JButton btnRegresarVtnPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaEmpleados;
    private javax.swing.JTextField txtNombreEmpleado;
    // End of variables declaration//GEN-END:variables
}
