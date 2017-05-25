package co.usa.edu.vista;

import co.usa.edu.controlador.ControladorUsuario;
import java.awt.event.ActionEvent;

public class ServicioUsuarioComprado {
    
    private static ControladorUsuario controladordeusuarios;

    public ServicioUsuarioComprado() {
        controladordeusuarios = new ControladorUsuario();
    }

    public int agregarSaldo(ActionEvent evt, int saldo) {
        return controladordeusuarios.insertarSaldo(saldo);
    }

    public String cancelarCompra(ActionEvent evt, int saldo) {
        return controladordeusuarios.cancelarCompra(saldo);
    }

    public String comprar(ActionEvent evt, String codigoProducto) {
        return controladordeusuarios.procesarCompra(codigoProducto); 
    }
}
