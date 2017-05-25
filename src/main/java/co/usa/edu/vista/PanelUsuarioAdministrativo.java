package co.usa.edu.vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author JEAV
 */
public class PanelUsuarioAdministrativo extends javax.swing.JPanel {

    private ServicioArca servicioArca;
    private ServicioProducto servicioProducto;
    public ServicioUsuarioAdministrativo servicioUsuarioAdministrativo;
    private ArrayList<String> listaArcas;
    private ArrayList<String> listaProductos;
    
    public PanelUsuarioAdministrativo() {
        servicioArca = new ServicioArca();
        servicioProducto = new ServicioProducto();
        servicioUsuarioAdministrativo = new ServicioUsuarioAdministrativo();
        initComponents();
        listaArcas = servicioArca.cargarArcas();
        listaProductos = servicioProducto.cargarProductos();
        modificarArca.addActionListener((java.awt.event.ActionEvent evt) -> {
            int idArca = Integer.parseInt(labelIdArca.getText().substring(9));
            int nuevaDenominacion = Integer.parseInt(denominacionArca.getItemAt(denominacionArca.getSelectedIndex()));
            int nuevasPiezas = Integer.parseInt(piezasArca.getText());
            boolean comprobanteDenominacion = servicioUsuarioAdministrativo.modificarDenominacionArca(evt, idArca, nuevaDenominacion);
            boolean comprobantePiezas = servicioUsuarioAdministrativo.modificarPiezas(evt, idArca, nuevasPiezas);
            String mensaje = "Cambio denominacion: "+comprobanteDenominacion+"\nCambio cantidad de piezas: "+comprobantePiezas;
            JOptionPane.showMessageDialog(arcasPanel, mensaje, "Comprobante de Cambios", 2);
            listaArcas = servicioArca.cargarArcas();
        });
        modificarProducto.addActionListener((java.awt.event.ActionEvent evt) -> {
            String idProducto = labelIdProducto.getText().substring(13);
            String nuevoNombre = nombreProducto.getText();
            int nuevoPrecio = Integer.parseInt(precioProducto.getText());
            int nuevasExistencias = Integer.parseInt(existenciasProducto.getText());
            boolean comprobanteNuevoNombre = servicioUsuarioAdministrativo.modificarNombreProducto(evt, idProducto, nuevoNombre);
            boolean comprobanteNuevoPrecio = servicioUsuarioAdministrativo.modificarPrecioProducto(evt, idProducto, nuevoPrecio);
            boolean comprobanteNuevasExistencias = servicioUsuarioAdministrativo.modificarExistenciProducto(evt, idProducto, nuevasExistencias);
            String mensaje = "Cambio nombre: "+comprobanteNuevoNombre+"\nCambio precio: "+comprobanteNuevoPrecio+"\nCambio existencias: "+comprobanteNuevasExistencias;
            JOptionPane.showMessageDialog(arcasPanel, mensaje, "Comprobante de Cambios", 2);
            listaProductos = servicioProducto.cargarProductos();
        });
        arcas.addListSelectionListener((ListSelectionEvent e) -> {
            int indiceArca = arcas.getSelectedIndex();
            int indicePrimeraComa = listaArcas.get(indiceArca).indexOf(",", 0);
            int indiceSegundaComa = listaArcas.get(indiceArca).indexOf(",", indicePrimeraComa);
            int indiceTerceraComa = listaArcas.get(indiceArca).indexOf(",", indiceSegundaComa);
            labelIdArca.setText("Id Arca: "+listaArcas.get(indiceArca).substring(0, indicePrimeraComa));
            String denominacion= "$"+listaArcas.get(indiceArca).substring(indicePrimeraComa, indiceSegundaComa);
            int indiceDenominacion = -1;
            for (int i = 0; i < denominacionArca.getSize().hashCode(); i++) {
                if(denominacion.equalsIgnoreCase(denominacionArca.getItemAt(i))){
                    indiceDenominacion = i;
                }
            }
            denominacionArca.setSelectedIndex(indiceDenominacion);
            piezasArca.setText(listaArcas.get(indiceArca).substring(indiceSegundaComa, indiceTerceraComa));
        });
        productos.addListSelectionListener((ListSelectionEvent e) -> {
            String idProdcto = productos.getSelectedValue();
            int indiceProducto = productos.getSelectedIndex();
            int indicePrimeraComa = listaProductos.get(indiceProducto).indexOf(",", 0);
            int indiceSegundaComa = listaProductos.get(indiceProducto).indexOf(",", indicePrimeraComa);
            int indiceTerceraComa = listaProductos.get(indiceProducto).indexOf(",", indiceSegundaComa);
            labelIdProducto.setText("Id Producto: "+idProdcto);
            nombreProducto.setText(listaProductos.get(indiceProducto).substring(indicePrimeraComa, indiceSegundaComa));
            existenciasProducto.setText(listaProductos.get(indiceProducto).substring(indiceSegundaComa, indiceTerceraComa));
            precioProducto.setText(listaProductos.get(indiceProducto).substring(indiceTerceraComa));
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arcaProducto = new javax.swing.JTabbedPane();
        arcasPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arcas = new javax.swing.JList<>();
        labelDenominacionArca = new javax.swing.JLabel();
        labelIdArca = new javax.swing.JLabel();
        piezasArca = new javax.swing.JTextField();
        denominacionArca = new javax.swing.JComboBox<>();
        labelPiezasArca = new javax.swing.JLabel();
        modificarArca = new javax.swing.JButton();
        productosPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productos = new javax.swing.JList<>();
        labelIdProducto = new javax.swing.JLabel();
        labelNombreProducto = new javax.swing.JLabel();
        labelPrecioProducto = new javax.swing.JLabel();
        labelExistenciasProducto = new javax.swing.JLabel();
        modificarProducto = new javax.swing.JButton();
        nombreProducto = new javax.swing.JTextField();
        precioProducto = new javax.swing.JTextField();
        existenciasProducto = new javax.swing.JTextField();

        arcas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = (String[]) servicioArca.cargarArcas().toArray();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(arcas);

        labelDenominacionArca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDenominacionArca.setText("Denominacion: ");

        labelIdArca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelIdArca.setText("Id Arca:");

        piezasArca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        denominacionArca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        denominacionArca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$100", "$200", "$500", "$1000", "$2000", "$5000", "$10000", "$20000", "$50000" }));

        labelPiezasArca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPiezasArca.setText("Cantidad de Piezas:");

        modificarArca.setText("Modificar");

        javax.swing.GroupLayout arcasPanelLayout = new javax.swing.GroupLayout(arcasPanel);
        arcasPanel.setLayout(arcasPanelLayout);
        arcasPanelLayout.setHorizontalGroup(
            arcasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arcasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(arcasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(arcasPanelLayout.createSequentialGroup()
                        .addGroup(arcasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelPiezasArca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDenominacionArca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(arcasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarArca, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(denominacionArca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(piezasArca))
                        .addGap(23, 23, 23))
                    .addGroup(arcasPanelLayout.createSequentialGroup()
                        .addComponent(labelIdArca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        arcasPanelLayout.setVerticalGroup(
            arcasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arcasPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelIdArca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(arcasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDenominacionArca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(denominacionArca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(arcasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPiezasArca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(piezasArca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(modificarArca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, arcasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        arcaProducto.addTab("Arcas", arcasPanel);

        productos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(productos);

        labelIdProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelIdProducto.setText("Id Producto:");

        labelNombreProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombreProducto.setText("Nombre:");

        labelPrecioProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPrecioProducto.setText("Precio: ");

        labelExistenciasProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelExistenciasProducto.setText("Existencias: ");

        modificarProducto.setText("Modificar");

        nombreProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        precioProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        existenciasProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout productosPanelLayout = new javax.swing.GroupLayout(productosPanel);
        productosPanel.setLayout(productosPanelLayout);
        productosPanelLayout.setHorizontalGroup(
            productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productosPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(productosPanelLayout.createSequentialGroup()
                                .addComponent(labelIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(productosPanelLayout.createSequentialGroup()
                                .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labelPrecioProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelExistenciasProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(labelNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(precioProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(existenciasProducto, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())))
                    .addGroup(productosPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(modificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        productosPanelLayout.setVerticalGroup(
            productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productosPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(productosPanelLayout.createSequentialGroup()
                        .addComponent(labelIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombreProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPrecioProducto))
                        .addGap(18, 18, 18)
                        .addGroup(productosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelExistenciasProducto)
                            .addComponent(existenciasProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(modificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        arcaProducto.addTab("Productos", productosPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(arcaProducto)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(arcaProducto, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane arcaProducto;
    private javax.swing.JList<String> arcas;
    private javax.swing.JPanel arcasPanel;
    private javax.swing.JComboBox<String> denominacionArca;
    private javax.swing.JTextField existenciasProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDenominacionArca;
    private javax.swing.JLabel labelExistenciasProducto;
    private javax.swing.JLabel labelIdArca;
    private javax.swing.JLabel labelIdProducto;
    private javax.swing.JLabel labelNombreProducto;
    private javax.swing.JLabel labelPiezasArca;
    private javax.swing.JLabel labelPrecioProducto;
    private javax.swing.JButton modificarArca;
    private javax.swing.JButton modificarProducto;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JTextField piezasArca;
    private javax.swing.JTextField precioProducto;
    private javax.swing.JList<String> productos;
    private javax.swing.JPanel productosPanel;
    // End of variables declaration//GEN-END:variables
}
