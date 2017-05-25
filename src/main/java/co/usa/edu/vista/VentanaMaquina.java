package co.usa.edu.vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    private static JPanel panel;
    
    public VentanaMaquina() {
        initComponents();
        servicioProducto = new ServicioProducto();
        listaProductos = servicioProducto.cargarProductos();
        administradorVista = new AdministradorVista(listaProductos);
        panel = administradorVista.mostrarPanelUsuario();
        add(panel);
        setSize(panel.getWidth()+10, panel.getHeight()+80);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        menu = new javax.swing.JMenuBar();
        sesion = new javax.swing.JMenu();
        sesionAdministrador = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sesion.setText("Sesion");

        sesionAdministrador.setText("Iniciar Administrador");
        sesionAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesionAdministradorActionPerformed(evt);
            }
        });
        sesion.add(sesionAdministrador);

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
    }// </editor-fold>                        

    private void sesionAdministradorActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        contraseña="";
        if(sesionAdministrador.getText().equals("Iniciar Administrador")){
            contraseña = JOptionPane.showInputDialog(this, "Digite la Clave");
            sesionAdministrador.setText("Cerrar Administrador");
        }else{
            sesionAdministrador.setText("Iniciar Administrador");
        }
        remove(panel);
        repaint();	
        panel = administradorVista.mostrarPanelUsuarioAdministrativo(contraseña);
        panel.setVisible(true);
        panel.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        add(panel);
        setSize(panel.getWidth()+10, panel.getHeight()+100);
        setLocationRelativeTo(null);
        repaint();
        update(getGraphics());
    }                                                   

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMaquina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu sesion;
    private javax.swing.JMenuItem sesionAdministrador;
    // End of variables declaration                   
}
