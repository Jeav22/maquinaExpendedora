package co.usa.edu.vista;

import co.usa.edu.controlador.ControladorUsuario;

public class ServicioUsuarioComprado {
    
    ControladorUsuario controladordeusuarios;

    public ServicioUsuarioComprado() {
        controladordeusuarios = new ControladorUsuario();
    }

    public int agregarSaldo(int saldo) {
        return controladordeusuarios.insertarSaldo(saldo);
    }

    public String cancelarCompra(int saldo) {
        return controladordeusuarios.cancelarCompra(saldo);
    }

    public String comprar(String codigoProducto) {
        return controladordeusuarios.procesarCompra(codigoProducto, 0); //Mientras vemos
    }
}
