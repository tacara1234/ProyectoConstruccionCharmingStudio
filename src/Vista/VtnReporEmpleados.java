/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorReporEmpleado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Carlos
 */
public class VtnReporEmpleados extends javax.swing.JFrame {

    private static VtnReporEmpleados instanciaDeVtnReporEmpleados = new VtnReporEmpleados();

    /**
     * Creates new form VtnReporEmpleados
     */
    private VtnReporEmpleados() {
        initComponents();
        setLocationRelativeTo(null);
        listarEmpleados();
    }

    public static VtnReporEmpleados getInstanciaDeVtnReporEmpleados() {
        return instanciaDeVtnReporEmpleados;
    }

    private void cerrarEstaVentana() {
        //borrarDatos();
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExportarExcel = new javax.swing.JButton();
        btnRegresarVtnReportes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reporteTablaEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Reporte Empleados");

        btnExportarExcel.setText("Exportar a Excel");
        btnExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcelActionPerformed(evt);
            }
        });

        btnRegresarVtnReportes.setText("Regresar");
        btnRegresarVtnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarVtnReportesActionPerformed(evt);
            }
        });

        reporteTablaEmpleados.setAutoCreateRowSorter(true);
        reporteTablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Ordenar x Desempeño", "Ordernar x Sueldo", "Ordernar x Total Vendido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reporteTablaEmpleados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Reportes de los Empleados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExportarExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresarVtnReportes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 388, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarExcel)
                    .addComponent(btnRegresarVtnReportes))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarVtnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarVtnReportesActionPerformed
        VtnReportes vtnRegreso = VtnReportes.getInstanciaDeVtnReportes();
        vtnRegreso.setVisible(true);
        cerrarEstaVentana();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarVtnReportesActionPerformed

    private void btnExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcelActionPerformed

        ControladorReporEmpleado unControlador = new ControladorReporEmpleado();
        boolean exportadoCorrectamente = unControlador.generaReporte(this.reporteTablaEmpleados.getModel());
        if(exportadoCorrectamente){
            JOptionPane.showMessageDialog(null, "ExportadoCorrectamente. Nombre: ReporteEmpleados.xls");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error. Contacta al administrador.");
        }
        
    }//GEN-LAST:event_btnExportarExcelActionPerformed

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
            java.util.logging.Logger.getLogger(VtnReporEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnReporEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnReporEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnReporEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnReporEmpleados().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btnRegresarVtnReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reporteTablaEmpleados;
    // End of variables declaration//GEN-END:variables

    private void listarEmpleados() {
        limpiarTabla();
        ControladorReporEmpleado unControlador = new ControladorReporEmpleado();
        DefaultTableModel modeloConDatos = unControlador.obtenerModeloConDatos(this.reporteTablaEmpleados);
        this.reporteTablaEmpleados.setModel(modeloConDatos);
    }

    private void limpiarTabla() {
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) this.reporteTablaEmpleados.getModel();
        for (int i = 0; i < reporteTablaEmpleados.getRowCount(); i++) {
            modeloDeLaTabla.removeRow(0);
            i -= 1;
        }
    }

    

}
