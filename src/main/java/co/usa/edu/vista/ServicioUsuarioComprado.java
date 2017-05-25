package co.usa.edu.vista;

import co.usa.edu.controlador.ControladorUsuario;

public class ServicioUsuarioComprado {
    
    ControladorUsuario controladordeusuarios;

    public ServicioUsuarioComprado() {
        controladordeusuarios = new ControladorUsuario();
    }

    public void agregarSaldo(int saldo) {
        controladordeusuarios.insertarSaldo(saldo);
    }

    public void cancelarCompra(int saldo) {
        controladordeusuarios.cancelarCompra(saldo);
    }

    public void confirmar(String codigoProducto) {
        controladordeusuarios.verificarContraseña(codigoProducto);
    }
}
