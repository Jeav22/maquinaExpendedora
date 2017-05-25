package co.usa.edu.vista;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author JEAV
 */
public class VentanaMaquina extends javax.swing.JFrame {
    
    private static ServicioProducto servicioProducto;
    private static AdministradorVista administradorVista;
    private static ArrayList<String> listaProductos;
    private static String contraseña;
    
    public VentanaMaquina() {
        servicioProducto = new ServicioProducto();
        listaProductos = servicioProducto.cargarProductos();
        administradorVista = new AdministradorVista(listaProductos);
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JMenuBar();
        sesion = new javax.swing.JMenu();
        iniciarAdministrador = new javax.swing.JMenuItem();
        cerrarAdministrador = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sesion.setText("Sesion");

        iniciarAdministrador.setText("Iniciar Administrador");
        iniciarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarAdministradorActionPerformed(evt);
            }
        });
        sesion.add(iniciarAdministrador);

        cerrarAdministrador.setText("Cerrar Administrador");
        cerrarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarAdministradorActionPerformed(evt);
            }
        });
        sesion.add(cerrarAdministrador);

        menu.add(sesion);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarAdministradorActionPerformed
        JPanel panel = administradorVista.mostrarPanelUsuarioAdministrativo(contraseña);
        panel.setVisible(true);
        add(panel);
    }//GEN-LAST:event_iniciarAdministradorActionPerformed

    private void cerrarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarAdministradorActionPerformed
        JPanel panel = administradorVista.mostrarPanelUsuario();
        panel.setVisible(true);
        add(panel);
    }//GEN-LAST:event_cerrarAdministradorActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMaquina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cerrarAdministrador;
    private javax.swing.JMenuItem iniciarAdministrador;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu sesion;
    // End of variables declaration//GEN-END:variables
}
