/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BDLogica.LogMenu;
import BDLogica.LogPedido;
import BDLogica.LogPlato;
import BDLogica.LogPlatopedido;
import Entidades.Menu;
import Entidades.Pedido;
import Entidades.Plato;
import Entidades.Platopedido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Lopez
 */
public class RegistrarPedido extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarPedido
     */
    static List<Plato> ArrayPlatos;
    static List<Pedido> ArrayPedidos;
    static Collection<Platopedido> ArrayPlatoPedidos = new ArrayList<>();
    static LogPedido objLogPedido = new LogPedido();
    static Pedido objPedido = new Pedido();
    static LogPlato objLogPlato = new LogPlato();
    static Plato auxPlato = new Plato();
    static Menu objMenu = new Menu();
    static LogMenu objLogMenu = new LogMenu();
    static LogPlatopedido objLogPlatopedido = new LogPlatopedido();
    int rowSel = -1;
    Pedido objPedidoCalculo = new Pedido();

    //Mesero mesero;
    public RegistrarPedido(/*Mesero mesero*/) {
        //this.mesero = mesero;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombreMesero = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListaGeneral = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonBuscarNumero1 = new javax.swing.JButton();
        jButtonAgregarPlato1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSpinnerCantidadPlato = new javax.swing.JSpinner();
        jTextFieldPlatoAgregar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaObservacion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNumeroPedido3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePlatosPedido = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNumeroMesa = new javax.swing.JTextField();
        jTextFieldTiempoApr = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButtonCrearPedido1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setClosable(true);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setText("Registrar Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Lista de Platos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTextFieldNombreMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreMeseroActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNombreMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 660, 10));

        jTableListaGeneral.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableListaGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaGeneralMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableListaGeneral);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 470, 150));

        jLabel5.setText("Nombre del Mesero:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jButtonBuscarNumero1.setText("Cargar");
        jButtonBuscarNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarNumero1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jButtonAgregarPlato1.setText("Agregar Plato");
        jButtonAgregarPlato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPlato1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarPlato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        jLabel9.setText("Observacion:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, 20));

        jSpinnerCantidadPlato.setModel(new javax.swing.SpinnerNumberModel(1, 1, 8, 1));
        jPanel1.add(jSpinnerCantidadPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jTextFieldPlatoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlatoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPlatoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 160, -1));

        jLabel10.setText("Plato por agregar");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jTextAreaObservacion.setColumns(20);
        jTextAreaObservacion.setRows(5);
        jScrollPane4.setViewportView(jTextAreaObservacion);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 280, -1));

        jLabel7.setText("Numero de pedido:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTextFieldNumeroPedido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroPedido3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNumeroPedido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 750, 480));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Platos del Pedido");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTablePlatosPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTablePlatosPedido);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 470, 150));

        jLabel8.setText("Numero de Mesa:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jTextFieldNumeroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroMesaActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 170, -1));

        jTextFieldTiempoApr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTiempoAprActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldTiempoApr, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 170, -1));

        jLabel11.setText("Tiempo Aproximado:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, -1));

        jButtonCrearPedido1.setText("Crear Pedido");
        jButtonCrearPedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearPedido1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCrearPedido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 510, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreMeseroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreMeseroActionPerformed

    private void jButtonBuscarNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarNumero1ActionPerformed
        // TODO add your handling code here:
        LeerPedidos();
        Pedido objPedido = new Pedido();

        try {
            LeerPlatos();
        } catch (IOException ex) {
            Logger.getLogger(RegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonBuscarNumero1ActionPerformed

    private void jButtonAgregarPlato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPlato1ActionPerformed
        // TODO add your handling code here:
        jSpinnerCantidadPlato.getValue();
        int cantidad = (Integer) jSpinnerCantidadPlato.getValue();
        String observacion = jTextAreaObservacion.getText();

        //ArrayPlatoPedidos.removeAll(ArrayPlatoPedidos);

        Platopedido objPlatopedido = new Platopedido();
        objPlatopedido.setCantidad(cantidad);
        objPlatopedido.setEstado(1);
        objPlatopedido.setObservacion(observacion);
        objPlatopedido.setIdPlato(auxPlato);
        objPlatopedido.setIdPedido(objPedido);
                
        ArrayPlatoPedidos.add(objPlatopedido);
        
        //objPedido.setPlatopedidoCollection(ArrayPlatoPedidos);
        objPedidoCalculo.setPlatopedidoCollection(ArrayPlatoPedidos);
        objLogPedido.calcularTiempoAprox(objPedidoCalculo);

        this.jTextFieldTiempoApr.setText(String.valueOf(objPedidoCalculo.getTiempoAproximado()));

        ListarPlatoPedido();

    }//GEN-LAST:event_jButtonAgregarPlato1ActionPerformed

    private void jTextFieldNumeroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroMesaActionPerformed

    private void jTextFieldPlatoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlatoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlatoAgregarActionPerformed

    private void jTextFieldTiempoAprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTiempoAprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTiempoAprActionPerformed

    private void jTextFieldNumeroPedido3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroPedido3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroPedido3ActionPerformed

    private void jTableListaGeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaGeneralMouseClicked
        // TODO add your handling code here:
        rowSel = jTableListaGeneral.getSelectedRow();
        auxPlato = ArrayPlatos.get(rowSel);
        System.out.println(auxPlato);
        this.jTextFieldPlatoAgregar.setText(jTableListaGeneral.getValueAt(rowSel, 0).toString());
    }//GEN-LAST:event_jTableListaGeneralMouseClicked

    private void jButtonCrearPedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearPedido1ActionPerformed
        int numeroMesa = Integer.parseInt(this.jTextFieldNumeroMesa.getText());
        objPedido.setNumMesa(numeroMesa);
        objPedido.setEstado(1);
        objPedido.setTiempoAproximado(Double.parseDouble(this.jTextFieldTiempoApr.getText()));
        objLogPedido.create(objPedido);
        Pedido NuevoPedido = objLogPedido.findPedidoEntities().get(objLogPedido.findPedidoEntities().size() - 1);
        
        for(Platopedido objPlatopedidoAux : ArrayPlatoPedidos){
            objPlatopedidoAux.setIdPedido(NuevoPedido);
            objLogPlatopedido.create(objPlatopedidoAux);
        }
        
        System.out.println(ArrayPedidos);
        
    }//GEN-LAST:event_jButtonCrearPedido1ActionPerformed

    void LeerPedidos() {
        System.out.println("...");
        System.out.println(ArrayPlatos);
        int numeroPedido = 1;
        ArrayPedidos = objLogPedido.findPedidoEntities();
        numeroPedido = ArrayPedidos.get(ArrayPedidos.size() - 1).getNumeroPedido() + 1;
        objPedido.setNumeroPedido(numeroPedido);
        this.jTextFieldNumeroPedido3.setText(String.valueOf(numeroPedido));
    }

    void LeerPlatos() throws IOException, FileNotFoundException, ClassNotFoundException {     

        ArrayPlatos = objLogPlato.findPlatoEntities();
        ArrayPlatos = (List<Plato>) objLogMenu.MenuActivo().getPlatoCollection();
        jTableListaGeneral.removeAll();
        Object columnas[] = {"Nombre", "Descripcion", "Coste", "tiempo"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTableListaGeneral.setModel(modelo);
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
    }

    void ListarPlatoPedido() {
        jTablePlatosPedido.removeAll();

        Object columnas[] = {"Nombre Plato", "Cantidad", "Observacion"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTablePlatosPedido.setModel(modelo);

        for (Platopedido objLogPedidoAux : ArrayPlatoPedidos) {
            Platopedido objPedidoPla = objLogPedidoAux;
            String NewValor[] = {
                objPedidoPla.getIdPlato().getNombre(),
                String.valueOf(objPedidoPla.getCantidad()),
                objPedidoPla.getObservacion()
            };
            System.out.println(objPedidoPla);
            modelo.addRow(NewValor);

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarPlato1;
    private javax.swing.JButton jButtonBuscarNumero1;
    private javax.swing.JButton jButtonCrearPedido1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerCantidadPlato;
    private javax.swing.JTable jTableListaGeneral;
    private javax.swing.JTable jTablePlatosPedido;
    private javax.swing.JTextArea jTextAreaObservacion;
    private javax.swing.JTextField jTextFieldNombreMesero;
    private javax.swing.JTextField jTextFieldNumeroMesa;
    private javax.swing.JTextField jTextFieldNumeroPedido3;
    private javax.swing.JTextField jTextFieldPlatoAgregar;
    private javax.swing.JTextField jTextFieldTiempoApr;
    // End of variables declaration//GEN-END:variables
}
