package co.usa.edu.vista;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author JEAV
 */
class AdministradorVista {
    private static PanelUsuario panelUsuario;
    private static PanelUsuarioAdministrativo panelUsuarioAdministrativo;
    ArrayList<String> listaProductos;

    public AdministradorVista(ArrayList<String> productos) {
        listaProductos = productos;
        panelUsuario = new PanelUsuario();
        panelUsuarioAdministrativo = new PanelUsuarioAdministrativo();
    }
    
    public JPanel mostrarPanelUsuario(){
        cargarProductos();
        cargarDisplay("0, ");
        return panelUsuario;
    }
    
    public JPanel mostrarPanelUsuarioAdministrativo(String contraseña){
        boolean acceso = panelUsuarioAdministrativo.servicioUsuarioAdministrativo.comprobarContraseña(contraseña);
        if(acceso){
            return panelUsuarioAdministrativo;
        }
        return panelUsuario;
    }   
    
    public void cargarDisplay(String mensje){
        String[] informacion = mensje.split(",");
        panelUsuario.panelDisplay.saldo.setText(informacion[0]);
        panelUsuario.panelDisplay.infoMensaje.setText(informacion[1]);
    }
    
    public void cargarProductos(){
        for (int i = 0; i < listaProductos.size(); i++) {
            PanelProducto nuevoProducto = new PanelProducto();
            int indicePrimeraComa = listaProductos.get(i).indexOf(",", 0);
            int indiceSegundaComa = listaProductos.get(i).indexOf(",", indicePrimeraComa);
            nuevoProducto.codigo.setText(listaProductos.get(i).substring(0, indicePrimeraComa));
            nuevoProducto.nombre.setText(listaProductos.get(i).substring(indicePrimeraComa, indiceSegundaComa));
            nuevoProducto.setVisible(true);
            if(i%2 != 0){
                nuevoProducto.setBounds(20, nuevoProducto.getHeight()*i+20, nuevoProducto.getWidth(), nuevoProducto.getHeight());
            }else{
                nuevoProducto.setBounds(nuevoProducto.getWidth()+20, nuevoProducto.getHeight()*i+20, nuevoProducto.getWidth(), nuevoProducto.getHeight());
            }
            panelUsuario.add(nuevoProducto);
        }
    }
}

