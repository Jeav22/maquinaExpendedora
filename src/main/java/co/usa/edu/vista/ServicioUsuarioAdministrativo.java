package co.usa.edu.vista;

import co.usa.edu.controlador.ControladorArca;
import co.usa.edu.controlador.ControladorProducto;
import co.usa.edu.controlador.ControladorUsuario;
import java.awt.event.ActionEvent;

public class ServicioUsuarioAdministrativo {

    private static ControladorUsuario controladordeusuario;
    private static ControladorProducto controladordeproducto;
    private static ControladorArca controladordearca;

    public ServicioUsuarioAdministrativo() {
        controladordearca = new ControladorArca();
        controladordeproducto = new ControladorProducto();
        controladordeusuario = new ControladorUsuario();
    }
    
    public boolean comprobarContraseña(ActionEvent evt, String contraseña) {
        return controladordeusuario.verificarContraseña(contraseña);
    }

    public boolean modificarNombreProducto(ActionEvent evt, String idProdcuto, String nombreProducto) {
        return controladordeproducto.modificarNombre(idProdcuto, nombreProducto);
    }

    public boolean modificarExistenciProducto(ActionEvent evt, String idProducto, int existencias) {
        return controladordeproducto.modificarExistencias(idProducto, existencias);
    }

    public boolean modificarPrecioProducto(ActionEvent evt, String idProducto, int precioProducto) {
        return controladordeproducto.modificarprecioProducto(idProducto, precioProducto);
    }
	
    public boolean modificarDenominacionArca(ActionEvent evt, int idArca, int denominacion) {
        return controladordearca.modificarDenominacion(idArca, denominacion);
    }	

    public boolean modificarPiezas(ActionEvent evt, int idArca, int piezas) {
        return controladordearca.modificarPiezas(idArca, piezas);
    }

}
