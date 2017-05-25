package co.usa.edu.vista;

import co.usa.edu.controlador.ControladorArca;
import co.usa.edu.controlador.ControladorProducto;
import co.usa.edu.controlador.ControladorUsuario;

public class ServicioUsuarioAdministrativo {

    ControladorUsuario controladordeusuario;
    ControladorProducto controladordeproducto;
    ControladorArca controladordearca;

    public ServicioUsuarioAdministrativo() {
        controladordearca = new ControladorArca();
        controladordeproducto = new ControladorProducto();
        controladordeusuario = new ControladorUsuario();
    }
    
    public boolean comprobarContraseña(String contraseña) {
        return controladordeusuario.verificarContraseña(contraseña);
    }

    public boolean modificarNombreProducto(String idProdcuto, String nombreProducto) {
        return controladordeproducto.modificarNombre(idProdcuto, nombreProducto);
    }

    public boolean modificarExistenciProducto(String idProducto, int existencias) {
        return controladordeproducto.modificarExistencias(idProducto, existencias);
    }

    public boolean modificarPrecioProducto(String idProducto, int precioProducto) {
        return controladordeproducto.modificarprecioProducto(idProducto, precioProducto);
    }
	
    public boolean modificarDenominacionArca(int idArca, int denominacion) {
        return controladordearca.modificarDenominacion(idArca, denominacion);
    }	

    public boolean modificarPiezas(int idArca, int piezas) {
        return controladordearca.modificarPiezas(idArca, piezas);
    }

}
