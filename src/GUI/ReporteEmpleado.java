/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entidades.Cocinero;
import Entidades.Menu;
import BDLogica.LogCocinero;
import BDLogica.LogPedido;
import BDLogica.LogFactura;
import Entidades.Cajero;

import Entidades.Factura;
import Entidades.Mesero;
import Entidades.Pedido;
import BDLogica.LogCajero;
import BDLogica.LogMesero;
import static GUI.AgregarPlato.objPedido;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ReporteEmpleado extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReporteEmpleado
     */
    List ArrayCocinero;
    List ArrayPedidos;
    List ArrayFacturas;
    Collection<Pedido> ArrayPedido = null;

    Cocinero objCocinero = null;
    Cajero objCajero = null;
    Mesero objMesero = null;

    LogCajero objLogCajero = new LogCajero();
    LogMesero objLogMesero = new LogMesero();
    LogCocinero objLogCocinero = new LogCocinero();
    LogPedido objLogPedido = new LogPedido();
    LogFactura objLogFactura = new LogFactura();

    public ReporteEmpleado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCedula = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pedido", "Calificacion", "Observacion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Ingresela cedula del Empleado");

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonBuscar))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar)
                            .addComponent(jLabel1))
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayFacturas = objLogFactura.findFacturaEntities();
        leerReporte();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        BuscarEmpleado();

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    public void leerReporte() {

        this.jTable1.removeAll();
        Object columnas[] = {"Pedido", "Calificacion", "Observacion"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTable1.setModel(modelo);
        System.out.println(ArrayFacturas);
        for (Object objAux : ArrayFacturas) {
            Factura objFactura = (Factura) objAux;
            String NewValor[] = {
                String.valueOf(objFactura.getIdPedido().getNumeroPedido()),
                objFactura.getIdFeedBack().getCalificacion(),
                objFactura.getIdFeedBack().getObservacion()
            };
            modelo.addRow(NewValor);
        }

    }

    public void ListarPedidoEmpleado() {

        this.jTable1.removeAll();
        Object columnas[] = {"Pedido", "Calificacion", "Observacion"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTable1.setModel(modelo);
        System.out.println(ArrayFacturas);
        for (Object objAux : ArrayFacturas) {

            Factura objFactura = (Factura) objAux;
            String NewValor[] = {
                String.valueOf(objFactura.getIdPedido().getNumeroPedido()),
                objFactura.getIdFeedBack().getCalificacion(),
                objFactura.getIdFeedBack().getObservacion()
            };
            modelo.addRow(NewValor);
        }
    }

    public void BuscarEmpleado() {
        objCocinero = objLogCocinero.BuscarCocinero(this.jTextFieldCedula.getText());
        
        objCajero = objLogCajero.BuscarCajero(this.jTextFieldCedula.getText());
        
        objMesero = objLogMesero.BuscarMesero(this.jTextFieldCedula.getText());
        
        if (objCocinero.getIdCocinero() != null) {
            ArrayPedido = objCocinero.getPedidoCollection();
            System.out.println("entro1");
        } else if (objCajero.getIdCajero() != null) {
            ArrayPedido = objCajero.getPedidoCollection();
            System.out.println("entro2");

        } else if (objMesero.getIdMesero() != null) {
            ArrayPedido = objMesero.getPedidoCollection();
            System.out.println("entro3");
        }
        BuscarFacturas();
        objCocinero = null;
        objCajero = null;
        objMesero = null;

    }

    void BuscarFacturas() {
        if (ArrayFacturas != null) {
            ArrayFacturas.clear();
        } else {
            ArrayFacturas = new ArrayList<Object>();
        }
        for (Pedido objauxPedido : ArrayPedido) {

            objPedido = objLogPedido.BuscarPedido(objauxPedido.getNumeroPedido());
            ArrayFacturas.addAll(objLogFactura.buscarFactura(objPedido));
//            ArrayFacturas.addAll(objPedido.getFacturaCollection());
        }
        ListarPedidoEmpleado();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCedula;
    // End of variables declaration//GEN-END:variables
}