package co.usa.edu.vista;

import javax.swing.JOptionPane;

/**
 *
 * @author JEAV
 */
public class PanelUsuario extends javax.swing.JPanel {
    
    private static ServicioUsuarioComprado servicioUsuarioComprador;
    public PanelDisplay panelDisplay;
    
    public PanelUsuario() {
        initComponents();
    	setBounds(0, 0, 660, 407);
    	setVisible(true);
        panelDisplay = new PanelDisplay();
        servicioUsuarioComprador = new ServicioUsuarioComprado();
        panelDisplay.setVisible(true);
        panelDisplay.setBounds(getWidth()-panelDisplay.getWidth()-20, 0, panelDisplay.getWidth(), panelDisplay.getHeight());
        add(panelDisplay);
        aceptar.setEnabled(false);
        cancelar.setEnabled(false);
        agregarDinero.addActionListener((java.awt.event.ActionEvent evt) -> {
            int saldo= Integer.parseInt(dinero.getItemAt(dinero.getSelectedIndex()).substring(1));
            int nuevoSaldo = servicioUsuarioComprador.agregarSaldo(evt, saldo);
            panelDisplay.saldo.setText("Saldo: $"+nuevoSaldo);
            panelDisplay.infoMensaje.setText("Se ha agregado $"+saldo+" \n al saldo...");
            if(saldo!=0){
            	aceptar.setEnabled(true);
            	cancelar.setEnabled(true);
            }
        });
        aceptar.addActionListener((java.awt.event.ActionEvent evt) -> {
            String idProducto = codigoProducto.getText();
            String cambio = servicioUsuarioComprador.comprar(evt, idProducto);
            String mensaje="";
            if(!cambio.contains("Producto no encontrado")){
                mensaje = "Codigo Producto: "+idProducto+"\n\nCambio recibido:\n"+cambio;
            }else{
                mensaje= cambio;
            }
            JOptionPane.showMessageDialog(null, mensaje, "Compra", 2);
            String saldo= cambio.substring(cambio.lastIndexOf(":")+1);
            panelDisplay.saldo.setText("Saldo: $"+saldo.trim());
            if(saldo.equals("0")){
            	aceptar.setEnabled(false);
            	cancelar.setEnabled(false);
            }
            
            
        });
        cancelar.addActionListener((java.awt.event.ActionEvent evt) -> {
            String mensajeSaldo = panelDisplay.saldo.getText();
            int saldo = Integer.parseInt(mensajeSaldo.substring(mensajeSaldo.lastIndexOf("$")+1).trim()) ;
            String cambio = servicioUsuarioComprador.cancelarCompra(evt, saldo);
            String mensaje = "Saldo de usuario por compra cancelada:\n"+cambio;
            JOptionPane.showMessageDialog(null, mensaje, "Compra Cancelada", 2);
            panelDisplay.saldo.setText("Saldo: $0");
            panelDisplay.infoMensaje.setText("Saldo Retirado");
            cancelar.setEnabled(false);
            aceptar.setEnabled(false);
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
                .addContainerGap(365, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDinero)
                        .addGap(18, 18, 18)
                        .addComponent(dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregarDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(labelCodigoProducto)
                            .addGap(18, 18, 18)
                            .addComponent(codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 273, Short.MAX_VALUE)
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
                    .addComponent(agregarDinero)))
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    public javax.swing.JButton aceptar;
    private javax.swing.JButton agregarDinero;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigoProducto;
    private javax.swing.JComboBox<String> dinero;
    private javax.swing.JLabel labelCodigoProducto;
    private javax.swing.JLabel labelDinero;
    // End of variables declaration                   
}
