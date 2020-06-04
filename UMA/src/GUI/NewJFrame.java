/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Lopez
 */
public class NewJFrame extends javax.swing.JFrame {

    RegistrarPlatos registrarPlatos = null;
    AdministrarMenus administrarMenus = null;

    /**
     * Creates new form NewJFrame
     */
    MeseroCargarMenu mCmenu;
    RegistrarPedido rPedido;

    DespachoPedidoCocinero dPedido = null;

    AgregarPlato agregarPlato;

    public NewJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuGerente = new javax.swing.JMenu();
        jMenuItemRegistrarPlatos = new javax.swing.JMenuItem();
        jMenuItemAdministrarMenu = new javax.swing.JMenuItem();
        jMenuCajero = new javax.swing.JMenu();
        jMenuMesero = new javax.swing.JMenu();
        jMenuItemCargarMenu = new javax.swing.JMenuItem();
        jMenuItemRegistroPedido = new javax.swing.JMenuItem();
        jMenuItemAgregarPlato = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuCocineroDespachoPedido = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1353, Short.MAX_VALUE)
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );

        jMenuGerente.setText("Gerente");

        jMenuItemRegistrarPlatos.setText("Registrar Platos");
        jMenuItemRegistrarPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarPlatosActionPerformed(evt);
            }
        });
        jMenuGerente.add(jMenuItemRegistrarPlatos);

        jMenuItemAdministrarMenu.setText("Administrar Menus");
        jMenuItemAdministrarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdministrarMenuActionPerformed(evt);
            }
        });
        jMenuGerente.add(jMenuItemAdministrarMenu);

        jMenuBar1.add(jMenuGerente);

        jMenuCajero.setText("Cajero");
        jMenuBar1.add(jMenuCajero);

        jMenuMesero.setText("Mesero");

        jMenuItemCargarMenu.setText("Cargar Menu");
        jMenuItemCargarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarMenuActionPerformed(evt);
            }
        });
        jMenuMesero.add(jMenuItemCargarMenu);

        jMenuItemRegistroPedido.setText("Registrar Pedido");
        jMenuItemRegistroPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistroPedidoActionPerformed(evt);
            }
        });
        jMenuMesero.add(jMenuItemRegistroPedido);

        jMenuItemAgregarPlato.setText("AgregarPlato");
        jMenuItemAgregarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarPlatoActionPerformed(evt);
            }
        });
        jMenuMesero.add(jMenuItemAgregarPlato);

        jMenuBar1.add(jMenuMesero);

        jMenu1.setText("Cocinero");

        jMenuCocineroDespachoPedido.setText("Despacho Pedido");
        jMenuCocineroDespachoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCocineroDespachoPedidoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCocineroDespachoPedido);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRegistrarPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarPlatosActionPerformed
        liberar();
        if (registrarPlatos == null) {
            registrarPlatos = new RegistrarPlatos();
            jDesktopPrincipal.add(registrarPlatos);
            Dimension desktopSize = this.getSize();
            Dimension FrameSize = registrarPlatos.getSize();
            registrarPlatos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            registrarPlatos.setVisible(true);
            this.jMenuItemRegistrarPlatos.setEnabled(true);
        }

    }//GEN-LAST:event_jMenuItemRegistrarPlatosActionPerformed

    private void jMenuCocineroDespachoPedidoActionPerformed(java.awt.event.ActionEvent evt) {
        liberar();
        if (dPedido == null) {
            try {
                dPedido = new DespachoPedidoCocinero();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDesktopPrincipal.add(dPedido);
            Dimension desktopSize = this.getSize();
            Dimension FrameSize = dPedido.getSize();
            dPedido.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            dPedido.setVisible(true);
            this.jMenuCocineroDespachoPedido.setEnabled(true);

        }
    }

    private void jMenuItemAgregarPlatoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (agregarPlato == null) {
            try {
                agregarPlato = new AgregarPlato();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDesktopPrincipal.add(agregarPlato);
            agregarPlato.setVisible(true);

        } else if (agregarPlato.isClosed()) {
            try {
                agregarPlato = new AgregarPlato();
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDesktopPrincipal.add(agregarPlato);
            agregarPlato.setVisible(true);
        }
    }


    private void jMenuItemAdministrarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdministrarMenuActionPerformed
        liberar();
        if (administrarMenus == null) {
            administrarMenus = new AdministrarMenus();
            jDesktopPrincipal.add(administrarMenus);
            Dimension desktopSize = this.getSize();
            Dimension FrameSize = administrarMenus.getSize();
            administrarMenus.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            administrarMenus.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemAdministrarMenuActionPerformed

    private void jMenuItemCargarMenuActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jMenuItemRegistroPedidoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        if (rPedido == null) {
            rPedido = new RegistrarPedido();
            jDesktopPrincipal.add(rPedido);
            rPedido.setVisible(true);

        } else if (rPedido.isClosed()) {
            rPedido = new RegistrarPedido();
            jDesktopPrincipal.add(rPedido);
            rPedido.setVisible(true);
        }

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
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    public void liberar() {
        if (registrarPlatos != null) {
            registrarPlatos.dispose();
            registrarPlatos = null;
        }
        if (administrarMenus != null) {
            administrarMenus.dispose();;
            administrarMenus = null;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCajero;
    private javax.swing.JMenuItem jMenuCocineroDespachoPedido;
    private javax.swing.JMenu jMenuGerente;
    private javax.swing.JMenuItem jMenuItem1;


    private javax.swing.JMenuItem jMenuItemAdministrarMenu;

    private javax.swing.JMenuItem jMenuItemAgregarPlato;
    private javax.swing.JMenuItem jMenuItemCargarMenu;
    private javax.swing.JMenuItem jMenuItemRegistrarPlatos;
    private javax.swing.JMenuItem jMenuItemRegistroPedido;
    private javax.swing.JMenu jMenuMesero;
    // End of variables declaration//GEN-END:variables
}
