/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLases.Mesero;
import CLases.Pedido;
import CLases.Plato;
import CLases.PlatoPedido;
import static GUI.RegistrarPedido.ArrayPlatos;
import static GUI.RegistrarPedido.objPedido;
import Logica.LogMenu;
import Logica.LogPedido;
import Logica.LogPlato;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.cert.CRLReason;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Lopez
 */
public class AgregarPlato extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarPlato
     */
    static ArrayList<Pedido> ArrayPedidos = new ArrayList<>();
    static ArrayList<Plato> ArrayPlatos = new ArrayList<>();
    static ArrayList<PlatoPedido> ArrayPlatoPedidos = new ArrayList<>();

    static Plato auxPlato = new Plato();
    static Pedido objPedido = new Pedido();
    static Pedido objPedidoAux = new Pedido();

    static LogPedido objLogPedido = new LogPedido();
    static LogPlato objLogPlato = new LogPlato();
    static LogMenu objLogMenu = new LogMenu();
    
    Pedido objNumeroPedido = new Pedido();

    int rowSel = -1;
    //Mesero mesero;

    public AgregarPlato(/*Mesero mesero*/) throws IOException, FileNotFoundException, ClassNotFoundException {
        //this.mesero = mesero;
        objLogPedido.LeerPedido(ArrayPedidos);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldBusquedaPedido = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePedidoAdicionales = new javax.swing.JTable();
        jTextFieldNumeroMesa = new javax.swing.JTextField();
        jTextFieldTiempoApr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonAgregarPlato1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePlatosdisponibles = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPlatoAgregar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerCantidad = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jButtonAgregarPlato2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaObservacion = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Plato a Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 230, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldBusquedaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBusquedaPedidoActionPerformed(evt);
            }
        });
        jTextFieldBusquedaPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBusquedaPedidoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldBusquedaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 80, -1));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel2.setText("Platos del pedido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setText("Numero de Pedido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTablePedidoAdicionales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTablePedidoAdicionales);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 130));

        jTextFieldNumeroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroMesaActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 170, -1));

        jTextFieldTiempoApr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTiempoAprActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTiempoApr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 170, -1));

        jLabel8.setText("Numero de Mesa:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel12.setText("Tiempo Aproximado:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 120, -1));

        jButtonAgregarPlato1.setText("Agregar adicionales");
        jButtonAgregarPlato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPlato1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarPlato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 480, 470));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePlatosdisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePlatosdisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePlatosdisponiblesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePlatosdisponibles);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 120));

        jLabel4.setText("Platos disponibles");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jTextFieldPlatoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlatoAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldPlatoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 160, -1));

        jLabel5.setText("Cantidad:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jSpinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jSpinnerCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSpinnerCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(jSpinnerCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        jLabel10.setText("Plato por agregar");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jButtonAgregarPlato2.setText("Agregar Plato");
        jButtonAgregarPlato2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPlato2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAgregarPlato2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, -1, -1));

        jTextAreaObservacion.setColumns(20);
        jTextAreaObservacion.setRows(5);
        jScrollPane4.setViewportView(jTextAreaObservacion);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 310, -1));

        jLabel11.setText("Observacion:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 510, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBusquedaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBusquedaPedidoActionPerformed

    private void jTextFieldPlatoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlatoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlatoAgregarActionPerformed

    private void jButtonAgregarPlato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPlato1ActionPerformed
        try {
            // TODO add your handling code here:
            BuscarPedido();
        } catch (IOException ex) {
            Logger.getLogger(AgregarPlato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarPlato.class.getName()).log(Level.SEVERE, null, ex);
        }

        jSpinnerCantidad.getValue();
        int valorSpinner = (Integer) jSpinnerCantidad.getValue();
        String Observacion = jTextAreaObservacion.getText();

        //ArrayPlatoPedidos.removeAll(ArrayPlatoPedidos);
        objLogPedido.agregarPlatoPedido(objPedidoAux, auxPlato, valorSpinner, 1, Observacion);

        int numeroMesa = Integer.parseInt(this.jTextFieldNumeroMesa.getText());
        objPedido.setNumeroMesa(numeroMesa);

        System.out.println(ArrayPedidos.indexOf(objPedido));
        ArrayPedidos.set(ArrayPedidos.indexOf(objPedido), objPedidoAux);
        System.out.println(objPedidoAux);
        try {
            objLogPedido.EscribirPedido(ArrayPedidos);
        } catch (IOException ex) {
            Logger.getLogger(AgregarPlato.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonAgregarPlato1ActionPerformed

    private void jButtonAgregarPlato2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPlato2ActionPerformed
        // TODO add your handling code here:

        jSpinnerCantidad.getValue();
        int valorSpinner = (Integer) jSpinnerCantidad.getValue();
        String Observacion = jTextAreaObservacion.getText();

        ArrayPlatoPedidos.removeAll(ArrayPlatoPedidos);

        objLogPedido.agregarPlatoPedido(objPedidoAux, auxPlato, valorSpinner, 1, Observacion);
        objLogPedido.calcularTiempoAprox(objPedidoAux);

        this.jTextFieldTiempoApr.setText(String.valueOf(objPedido.getTiempoAproximado()));
        jTablePedidoAdicionales.removeAll();
        Object columnas[] = {"Nombre Plato", "Cantidad", "Observacion"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTablePedidoAdicionales.setModel(modelo);

        for (PlatoPedido objLogPedidoAux : objPedido.getListaPlatoPedido()) {
            PlatoPedido objPedidoPla = objLogPedidoAux;
            String NewValor[] = {
                objPedidoPla.getPlato().getNombre(),
                String.valueOf(objPedidoPla.getCantidad()),
                objPedidoPla.getObservacion()
            };
            System.out.println(objPedidoPla);
            modelo.addRow(NewValor);

        }

    }//GEN-LAST:event_jButtonAgregarPlato2ActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
            // TODO add your handling code here:

            BuscarPedido();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AgregarPlato.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTablePedidoAdicionales.removeAll();
        Object columnas[] = {"Nombre Plato", "Cantidad", "Observacion"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTablePedidoAdicionales.setModel(modelo);

        if (objLogPedido.CompararPedido(objPedido, objNumeroPedido)) {

            for (PlatoPedido objPlatoPedido : objPedido.getListaPlatoPedido()) {
                PlatoPedido objPlatoPedidoAux = objPlatoPedido;
                String NewValor[] = {
                    objPlatoPedidoAux.getPlato().getNombre(),
                    String.valueOf(objPlatoPedidoAux.getCantidad()),
                    objPlatoPedidoAux.getObservacion()
                };
                modelo.addRow(NewValor);
            }

        }
        ListarPlatos();


    }//GEN-LAST:event_jButtonBuscarActionPerformed

    public void BuscarPedido() throws IOException, FileNotFoundException, ClassNotFoundException {
        int busquedaPedido = Integer.parseInt(jTextFieldBusquedaPedido.getText());
        objNumeroPedido.setNumeroPedido(busquedaPedido);
        ArrayPedidos.clear();
        objLogPedido.LeerPedido(ArrayPedidos);
        LogPedido objLogPedidoAux = new LogPedido();
        objPedido = objLogPedidoAux.BuscarPedido(ArrayPedidos, objNumeroPedido);
        System.out.println("/////");
        System.out.println(objPedido);
        objPedidoAux = objPedido;
        System.out.println("@@@@@@@");
        System.out.println(objPedidoAux);
    }

    public void ListarPlatos() {
        try {
            ArrayPlatos.removeAll(ArrayPlatos);
            objLogPlato.LeerPlatos(ArrayPlatos);
            ArrayPlatos = objLogMenu.MenuActivo().getListaPlatosMenu();

            jTablePlatosdisponibles.removeAll();
            Object columnas[] = {"Nombre", "Descripcion", "Coste", "tiempo"};
            DefaultTableModel modelo = new DefaultTableModel(null, columnas);
            jTablePlatosdisponibles.setModel(modelo);
            for (Plato objAux : ArrayPlatos) {
                Plato objPlato = objAux;
                String NewValor[] = {
                    objPlato.getNombre(),
                    objPlato.getDescripcion(),
                    String.valueOf(objPlato.getCosto()),
                    String.valueOf(objPlato.getTiempo())
                };
                modelo.addRow(NewValor);
            }

        } catch (IOException ex) {
            Logger.getLogger(AgregarPlato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarPlato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jTextFieldBusquedaPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaPedidoKeyTyped
        // TODO add your handling code here:

        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldBusquedaPedidoKeyTyped

    private void jSpinnerCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinnerCantidadKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jSpinnerCantidadKeyTyped

    private void jTablePlatosdisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlatosdisponiblesMouseClicked
        // TODO add your handling code here:
        rowSel = jTablePlatosdisponibles.getSelectedRow();

        auxPlato = ArrayPlatos.get(rowSel);

        this.jTextFieldPlatoAgregar.setText(jTablePlatosdisponibles.getValueAt(rowSel, 0).toString());

    }//GEN-LAST:event_jTablePlatosdisponiblesMouseClicked

    private void jTextFieldNumeroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroMesaActionPerformed

    private void jTextFieldTiempoAprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTiempoAprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTiempoAprActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarPlato1;
    private javax.swing.JButton jButtonAgregarPlato2;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinnerCantidad;
    private javax.swing.JTable jTablePedidoAdicionales;
    private javax.swing.JTable jTablePlatosdisponibles;
    private javax.swing.JTextArea jTextAreaObservacion;
    private javax.swing.JTextField jTextFieldBusquedaPedido;
    private javax.swing.JTextField jTextFieldNumeroMesa;
    private javax.swing.JTextField jTextFieldPlatoAgregar;
    private javax.swing.JTextField jTextFieldTiempoApr;
    // End of variables declaration//GEN-END:variables
}
