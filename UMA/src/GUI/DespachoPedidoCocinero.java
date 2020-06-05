/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLases.Cocinero;
import CLases.Pedido;
import CLases.Plato;
import CLases.PlatoPedido;
import Logica.LogCocinero;
import Logica.LogColaPedido;
import Logica.LogPedido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author accel
 */
public class DespachoPedidoCocinero extends javax.swing.JInternalFrame {

    /**
     * Creates new form DespachoPedidoCocinero
     */
    Pedido objPedido = new Pedido();
    Pedido objPedidoActualizado = new Pedido();

    PlatoPedido objPlatoPedido = new PlatoPedido();
    PlatoPedido objPlatoPedido1 = new PlatoPedido();

    LogPedido objLogPedido = new LogPedido();
    LogCocinero objLogCocinero = new LogCocinero();
    LogColaPedido objLogColaPedido = new LogColaPedido();

    ArrayList<Pedido> ArrayPedidos = new ArrayList<Pedido>();
    ArrayList<Cocinero> ArrayCocinero = new ArrayList<Cocinero>();
    ArrayList<PlatoPedido> ArrayPlatosPedido = new ArrayList<PlatoPedido>();
    ArrayList<Cocinero> cocinerosLogueados = new ArrayList<Cocinero>();

    static int rowPedido = -1;

    public DespachoPedidoCocinero() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.cocinerosLogueados = cocinerosLogueados;
        initComponents();
        CargarCombos();
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
        jTablePedidos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePlatosPedido = new javax.swing.JTable();
        jButtonActualizarPedidos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonPlatoProcesado = new javax.swing.JButton();
        jButtonDespacharPedido = new javax.swing.JButton();
        jComboBoxCocinero = new javax.swing.JComboBox<>();
        jButtonProcesarPedido = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero Pedido", "Estado", "TiempoPedido"
            }
        ));
        jScrollPane1.setViewportView(jTablePedidos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 112, -1, 145));

        jTablePlatosPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Estado", "Observacion", "Tiempo", "Cantidad"
            }
        ));
        jTablePlatosPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePlatosPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePlatosPedido);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 398, -1, 118));

        jButtonActualizarPedidos.setText("Actualizar Pedidos");
        jButtonActualizarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonActualizarPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel1.setText("Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, -1, -1));

        jLabel2.setText("Platos del pedido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 364, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("COCINA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jButtonPlatoProcesado.setText("Plato Procesado");
        jButtonPlatoProcesado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlatoProcesadoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPlatoProcesado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        jButtonDespacharPedido.setText("Despachar Pedido");
        jButtonDespacharPedido.setEnabled(false);
        jButtonDespacharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDespacharPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDespacharPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, -1, -1));

        getContentPane().add(jComboBoxCocinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 153, -1, -1));

        jButtonProcesarPedido.setText("Procesar Pedido");
        jButtonProcesarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcesarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProcesarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 275, -1, -1));

        jLabel5.setText("Cocinero a cargo del pedido");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 112, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarPedidosActionPerformed
        //String estado = null;
        if (objLogPedido.Existe()) {

            try {
                leerPedidos();
            } catch (IOException ex) {
                Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
            ActualizarTablaPedido();

        }
    }//GEN-LAST:event_jButtonActualizarPedidosActionPerformed

    private void jButtonPlatoProcesadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlatoProcesadoActionPerformed
        
        String estado = null;
        int row = -1;
        int row1 = -1;
        try {
            leerPedidos();
        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
//      
        row = jTablePlatosPedido.getSelectedRow();
        rowPedido = jTablePedidos.getSelectedRow();
        ArrayPlatosPedido = ArrayPedidos.get(rowPedido).getListaPlatoPedido();
        System.out.println(ArrayPlatosPedido);
        objPlatoPedido = ArrayPlatosPedido.get(row);
        objPlatoPedido.setEstado(3);
        objPedido = ArrayPedidos.get(rowPedido);
        System.out.println(objPedido);
//        System.out.println("a."+objAux);
//        System.out.println("b."+objPlatoPedido);
        ArrayPlatosPedido.set(ArrayPlatosPedido.indexOf(objPlatoPedido), objPlatoPedido);
//        System.out.println("2."+original);
//        objPedidoActualizado = objPedido;
        objPedidoActualizado.setListaPlatoPedido(ArrayPlatosPedido);
//        System.out.println("3."+original);
//        System.out.println(ArrayPedidos);
        System.out.println(ArrayPedidos.indexOf(objPedido));
        System.out.println(objPedidoActualizado);
        ArrayPedidos.set(ArrayPedidos.indexOf(objPedido), objPedidoActualizado);
        try {
            LogPedido.EscribirPedido(ArrayPedidos);

        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            leerPedidos();
        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object columnas[] = {"Nombre", "Estado", "Observacion", "Tiempo", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTablePlatosPedido.setModel(modelo);
        objPedido = ArrayPedidos.get(rowPedido);
        System.out.println(objPedido);

        for (PlatoPedido objPlatoPedido : objPedido.getListaPlatoPedido()) {
            if (objPlatoPedido.getEstado() == 1) {
                estado = "Registrado";
            } else if (objPlatoPedido.getEstado() == 2) {
                estado = "Cocinando";
            } else if (objPlatoPedido.getEstado() == 3) {
                estado = "Finalizado";
            }
            String NewValor[] = {
                objPlatoPedido.getPlato().getNombre(),
                estado,
                objPlatoPedido.getObservacion(),
                String.valueOf(objPlatoPedido.getPlato().getTiempo()),
                String.valueOf(objPlatoPedido.getCantidad())

            };
            System.out.println(objPlatoPedido);
            modelo.addRow(NewValor);

        }
        try {
            if(ComprobarPlatos(objPedido)){
                this.jButtonDespacharPedido.setEnabled(true);
            }else{
                this.jButtonDespacharPedido.setEnabled(false);
            };
        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonPlatoProcesadoActionPerformed

    private void jButtonProcesarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcesarPedidoActionPerformed
        String estado = null;
        try {
            leerPedidos();
        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTablePlatosPedido.removeAll();
        rowPedido = this.jTablePedidos.getSelectedRow();
        Pedido objAux = new Pedido();
        objAux = ArrayPedidos.get(rowPedido);
        objPedido = objAux;
        //System.out.println("---" + objAux);
        objAux.setEstado(2);
        //System.out.println("+++" + objAux);
//        ArrayPedidos.remove(ArrayPedidos.get(row));
//        ArrayPedidos.add(row, objAux);
//        
//        System.out.println("pedidos actualizados");
//        System.out.println(ArrayPedidos);
        ArrayPedidos.set(ArrayPedidos.indexOf(objPedido), objAux);
        try {
            objLogPedido.EscribirPedido(ArrayPedidos);
        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
        ActualizarTablaPedido();

        Object columnas[] = {"Nombre", "Estado", "Observacion", "Tiempo", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTablePlatosPedido.setModel(modelo);
        objPedido = ArrayPedidos.get(rowPedido);
        objPedidoActualizado = objPedido;

        for (PlatoPedido objPlatoPedido : objPedido.getListaPlatoPedido()) {
            if (objPlatoPedido.getEstado() == 1) {
                estado = "Registrado";
            } else if (objPlatoPedido.getEstado() == 2) {
                estado = "Cocinando";
            } else if (objPlatoPedido.getEstado() == 3) {
                estado = "Finalizado";
            }
            String NewValor[] = {
                objPlatoPedido.getPlato().getNombre(),
                estado,
                objPlatoPedido.getObservacion(),
                String.valueOf(objPlatoPedido.getPlato().getTiempo()),
                String.valueOf(objPlatoPedido.getCantidad())

            };
            System.out.println(objPlatoPedido);
            modelo.addRow(NewValor);

        }
        ArrayPlatosPedido = ArrayPedidos.get(rowPedido).getListaPlatoPedido();
        objPedido = objAux;
        try {
            if(ComprobarPlatos(objPedido)){
                this.jButtonDespacharPedido.setEnabled(true);
            }else{
                this.jButtonDespacharPedido.setEnabled(false);
            };
        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonProcesarPedidoActionPerformed

    private void jTablePlatosPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlatosPedidoMouseClicked


    }//GEN-LAST:event_jTablePlatosPedidoMouseClicked

    private void jButtonDespacharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDespacharPedidoActionPerformed
        int row = -1;
        row = jTablePedidos.getSelectedRow();
        Pedido objAux = new Pedido();
        objAux = ArrayPedidos.get(row);
        objAux.setEstado(3);
        ArrayPedidos.set(row, objAux);
        //ArrayPedidos.remove(row);
        objLogColaPedido.eliminarPedido(objAux);
        try {
            objLogPedido.EscribirPedido(ArrayPedidos);
        } catch (IOException ex) {
            Logger.getLogger(DespachoPedidoCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Pedido Despachado");
        ActualizarTablaPedido();


    }//GEN-LAST:event_jButtonDespacharPedidoActionPerformed
    public void leerPedidos() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayPedidos.clear();
        objLogPedido.LeerPedido(ArrayPedidos);
    }

    public void CargarCombos() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.jComboBoxCocinero.setModel(new DefaultComboBoxModel(LogCocinero.CargarCocinero().toArray()));

    }

    public void ActualizarTablaPedido() {
        String estado = null;
        this.jTablePedidos.removeAll();
        Object columnas[] = {"Numero de pedido", "Estado", "Tiempo Estimado(m)"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTablePedidos.setModel(modelo);
        for (Object objAux : ArrayPedidos) {
            Pedido objPedido = (Pedido) objAux;
            if (objPedido.getEstado() == 1) {
                estado = "Registrado";
            } else if (objPedido.getEstado() == 2) {
                estado = "Cocinando";
            } else if (objPedido.getEstado() == 3) {
                estado = "Despachado";
            } else if (objPedido.getEstado() == 4) {
                estado = "Pagando";
            } else if (objPedido.getEstado() == 5) {
                estado = "Finalizado";
            }
            String NewValor[] = {
                String.valueOf(objPedido.getNumeroPedido()),
                estado,
                String.valueOf(objPedido.getTiempoAproximado())
            };
            modelo.addRow(NewValor);
        }
    }

    public boolean ComprobarPlatos(Pedido pedido) throws IOException, FileNotFoundException, ClassNotFoundException {
        leerPedidos();
        for (PlatoPedido objPlatoPedido : pedido.getListaPlatoPedido()) {
            if (objPlatoPedido.getEstado() != 3) {
                return false;
            }
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizarPedidos;
    private javax.swing.JButton jButtonDespacharPedido;
    private javax.swing.JButton jButtonPlatoProcesado;
    private javax.swing.JButton jButtonProcesarPedido;
    private javax.swing.JComboBox<String> jComboBoxCocinero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTable jTablePlatosPedido;
    // End of variables declaration//GEN-END:variables
}
