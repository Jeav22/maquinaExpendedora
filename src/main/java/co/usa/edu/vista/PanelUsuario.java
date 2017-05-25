package co.usa.edu.vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAV
 */
public class PanelUsuario extends javax.swing.JPanel {
    
    private static ServicioUsuarioComprado servicioUsuarioComprador;
    public PanelDisplay panelDisplay;
    private static ArrayList<PanelProducto> panelesProducto;
    
    public PanelUsuario() {
        panelDisplay = new PanelDisplay();
        panelesProducto = new ArrayList<>();
        servicioUsuarioComprador = new ServicioUsuarioComprado();
        initComponents();
        add(panelDisplay);
        panelDisplay.setVisible(true);
        panelDisplay.setBounds(labelCodigoProducto.getX(), 20, panelDisplay.getWidth(), panelDisplay.getHeight());
        
        agregarDinero.addActionListener((java.awt.event.ActionEvent evt) -> {
            int saldo= Integer.parseInt(dinero.getItemAt(dinero.getSelectedIndex()));
            int nuevoSaldo = servicioUsuarioComprador.agregarSaldo(evt, saldo);
            panelDisplay.saldo.setText(""+nuevoSaldo);
            panelDisplay.infoMensaje.setText("Se ha agregado $"+saldo+" \n al saldo...");
        });
        aceptar.addActionListener((java.awt.event.ActionEvent evt) -> {
            String idProducto = codigoProducto.getText();
            String cambio = servicioUsuarioComprador.comprar(evt, idProducto);
            String mensaje = "Codigo Producto: "+idProducto+"\n\nCambio recibido:\n"+cambio;
            JOptionPane.showMessageDialog(null, mensaje, "Compra", 2);
            // Falta actualizar Display----------------------------------------------------------------<-<-<-<-<-<---------
        });
        cancelar.addActionListener((java.awt.event.ActionEvent evt) -> {
            int saldo = Integer.parseInt(panelDisplay.saldo.getText()) ;
            String cambio = servicioUsuarioComprador.cancelarCompra(evt, saldo);
            String mensaje = "Saldo de usuario por compra cancelada:\n"+cambio;
            JOptionPane.showMessageDialog(null, mensaje, "Compra Cancelada", 2);
            panelDisplay.saldo.setText("0");
            panelDisplay.infoMensaje.setText("Saldo Retirado");
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigoProducto = new javax.swing.JLabel();
        codigoProducto = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        labelDinero = new javax.swing.JLabel();
        dinero = new javax.swing.JComboBox<>();
        agregarDinero = new javax.swing.JButton();

        labelCodigoProducto.setText("Codigo del producto:");

        aceptar.setText("Aceptar");

        cancelar.setText("Cancelar");

        labelDinero.setText("Agregar dinero: ");

        dinero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$100", "$200", "$500", "$1000", "$2000", "$5000", "$10000", "$20000", "$50000" }));

        agregarDinero.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(375, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCodigoProducto)
                        .addGap(18, 18, 18)
                        .addComponent(codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelDinero)
                                .addGap(18, 18, 18)
                                .addComponent(dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigoProducto)
                    .addComponent(codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(aceptar))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDinero)
                    .addComponent(dinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarDinero))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton agregarDinero;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigoProducto;
    private javax.swing.JComboBox<String> dinero;
    private javax.swing.JLabel labelCodigoProducto;
    private javax.swing.JLabel labelDinero;
    // End of variables declaration//GEN-END:variables
}
