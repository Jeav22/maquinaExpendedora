package co.usa.edu.vista;

/**
 *
 * @author JEAV
 */
public class VentanaMaquina extends javax.swing.JFrame {
    
    ServicioProducto servicioProducto;
    
    public VentanaMaquina() {
        servicioProducto = new ServicioProducto();
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
        sesion.add(iniciarAdministrador);

        cerrarAdministrador.setText("Cerrar Administrador");
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
