package co.usa.edu.vista;

/**
 *
 * @author JEAV
 */
public class PanelDisplay extends javax.swing.JPanel {

    public PanelDisplay() {
        initComponents();
        setVisible(true);
        setSize(264, 206);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        saldo = new javax.swing.JLabel();
        infoMensaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 240, 0));

        saldo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        saldo.setForeground(new java.awt.Color(255, 255, 255));

        infoMensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoMensaje.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    public javax.swing.JLabel infoMensaje;
    public javax.swing.JLabel saldo;
    // End of variables declaration                   
}
