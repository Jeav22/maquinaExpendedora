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

    public void modificarNombreProducto(String idProdcuto, String nombreProducto) {
        controladordeproducto.modificarNombre(idProdcuto, nombreProducto);
    }

    public void modificarExistenciProducto(String idProducto, int existencias) {
        controladordeproducto.modificarExistencias(idProducto, existencias);
    }

    public void modificarPrecioProducto(String idProducto, int precioProducto) {
        controladordeproducto.modificarprecioProducto(idProducto, precioProducto);
    }
	
    public void modificarDenominacionArca(int idArca, int denominacion) {
        controladordearca.modificarDenominacion(idArca, denominacion);
    }	

    public void modificarPiezas(int idArca, int piezas) {
        controladordearca.modificarPiezas(idArca, piezas);
    }

}
