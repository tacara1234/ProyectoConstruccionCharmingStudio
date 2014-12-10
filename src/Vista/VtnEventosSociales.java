/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorEventos;
import Modelo.EventosSociales;
import java.sql.SQLException;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class VtnEventosSociales extends javax.swing.JFrame {

    private final int SI = 0;
    private final int MOSTRAR_DOS_OPCIONES = 0;
    private int tipoDellenado = 1;
    // private static VtnEventosSociales instanciaDeVtnEventosSociales = new VtnEventosSociales();

    /**
     * Creates new form VtnEventosSociales
     */
    public VtnEventosSociales() {
        initComponents();
        mostrarEventos();
        setLocationRelativeTo(null);
    }

    // public static VtnEventosSociales getInstanciaDeVtnEventosSociales() {
    //   return instanciaDeVtnEventosSociales;
    // }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevoEvento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEventos = new javax.swing.JTable();
        btnRegresarVtnPrincipal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarEventoSocial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Eventos");

        btnNuevoEvento.setText("Nuevo Evento");
        btnNuevoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEventoActionPerformed(evt);
            }
        });

        listaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id Evento", "id Cliente", "id MD", "Fecha", "Precio", "id Empleado"
            }
        ));
        jScrollPane1.setViewportView(listaEventos);

        btnRegresarVtnPrincipal.setText("Regresar");
        btnRegresarVtnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarVtnPrincipalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Eventos");

        btnEliminarEventoSocial.setText("Eliminar");
        btnEliminarEventoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEventoSocialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevoEvento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEliminarEventoSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresarVtnPrincipal)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(btnNuevoEvento)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresarVtnPrincipal)
                    .addComponent(btnEliminarEventoSocial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarEventos() {
        ControladorEventos ctrlEventos = new ControladorEventos();
        try {
            DefaultTableModel datosTabla = (DefaultTableModel) this.listaEventos.getModel();
            DefaultTableModel datosTablaCompleta = ctrlEventos.obtenerTodosLosEventos(datosTabla,tipoDellenado);
            this.listaEventos.setModel(datosTablaCompleta);

        } catch (SQLException ex) {
            Logger.getLogger(VtnEventosSociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnRegresarVtnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarVtnPrincipalActionPerformed
        // TODO add your handling code here:
        VtnPrincipal vtnRegreso = VtnPrincipal.getInstanciaDeVtnPrincipal();
        vtnRegreso.setVisible(true);
        cerrarEstaVentana();
    }//GEN-LAST:event_btnRegresarVtnPrincipalActionPerformed

    private void btnNuevoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEventoActionPerformed
        // TODO add your handling code here:
        vtnAgregaEventoSocial vtn = new vtnAgregaEventoSocial();
        vtn.setVisible(true);
        cerrarEstaVentana();

    }//GEN-LAST:event_btnNuevoEventoActionPerformed

    private void btnEliminarEventoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEventoSocialActionPerformed
        // TODO add your handling code here:
         /*Obtenemos el prov seleccionado de la tabla:*/
        int idEventoQueSeEliminara = obtenerInformacionDeRenglonSelecccionado().getIdEvento();

        //checamos si se seleccionó algún prov de la tabla,
        //es decir, si no es nulo.
        if (idEventoQueSeEliminara > 0) {
            //le preguntamos al prov si de verdad, desea eliminar el 
            //prov seleccionado:
            int opcionEliminar = JOptionPane.showConfirmDialog(null,
                    "Seguro desea eliminar el proveedor seleccionado?",
                    "Eliminará el proveedor. ",
                    MOSTRAR_DOS_OPCIONES);
            //si lo que escogió el usuario es igual a un "si"
            if (opcionEliminar == SI) {
                //creamos el controlador de prov:
                ControladorEventos controlEventos = new ControladorEventos();

                try {
                    controlEventos.eliminarEvento(idEventoQueSeEliminara);
                    mostrarMensajeEnPantalla("Evento eliminado");
                    limpiarTabla();
                    mostrarEventos();
                } catch (SQLException ex) {
                    mostrarMensajeEnPantalla("Evento no eliminado. Error: " + ex.getLocalizedMessage());
                }
            }
        } else {
            mostrarMensajeEnPantalla("No ha seleccionado algún evento de la tabla");
        }
    }//GEN-LAST:event_btnEliminarEventoSocialActionPerformed

        private void limpiarTabla() {
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) this.listaEventos.getModel();
        for (int i = 0; i < listaEventos.getRowCount(); i++) {
            modeloDeLaTabla.removeRow(0);
            i -= 1;
        }
    }
        
    private EventosSociales obtenerInformacionDeRenglonSelecccionado() {
        //obtiene el número del renglón seleccionado en la tabla.
        int numDeRenglonSeleccionado = this.listaEventos.getSelectedRow();

        /*Si es negativo, quiere decir que ningún renglón ha sido seleccionado:*/
        if (numDeRenglonSeleccionado < 0) {
            return null;
        }

        //declaramos las constantes, de las columnas donde está la información:
        int columnaId = 0;
        int columnaIdCliente = 1;
        int columnaIdMD = 2;
        int columnaFecha = 3;
        int columnaPrecio = 4;
        int columnaIdEmpleado = 5;


        //obtenemos la información del renglón seleccionado.
        int id = (int) listaEventos.getValueAt(numDeRenglonSeleccionado, columnaId);
        String strIdCliente = (String) listaEventos.getValueAt(numDeRenglonSeleccionado, columnaIdCliente);
        String idYmd = (String) listaEventos.getValueAt(numDeRenglonSeleccionado, columnaIdMD);
        Date fecha = (Date) listaEventos.getValueAt(numDeRenglonSeleccionado, columnaFecha);
        float precio = (float) listaEventos.getValueAt(numDeRenglonSeleccionado, columnaPrecio);
        String idYempleado = (String) listaEventos.getValueAt(numDeRenglonSeleccionado, columnaIdEmpleado);

        StringTokenizer token1 = new StringTokenizer(strIdCliente, " ");
        StringTokenizer token2 = new StringTokenizer(idYmd, " ");
        StringTokenizer token3 = new StringTokenizer(idYempleado, " ");
        int idCliente = Integer.parseInt(token1.nextToken());
        int idMD = Integer.parseInt(token2.nextToken());
        int idEmpleado = Integer.parseInt(token3.nextToken());

        

        //regresamos el EventoSocial.
        return new EventosSociales(id, idCliente, idMD, fecha.toString(), precio, idEmpleado);

    }

    private void mostrarMensajeEnPantalla(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Cuidado", 0);
    }

    private void cerrarEstaVentana() {
        //orrarDatos();
        this.dispose();
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
            java.util.logging.Logger.getLogger(VtnEventosSociales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnEventosSociales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnEventosSociales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnEventosSociales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnEventosSociales().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarEventoSocial;
    private javax.swing.JButton btnNuevoEvento;
    private javax.swing.JButton btnRegresarVtnPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaEventos;
    // End of variables declaration//GEN-END:variables
}
