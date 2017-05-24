package co.usa.controlador;

import co.usa.edu.modelo.AdministradorUsuarioAdministrativo;
import co.usa.edu.modelo.AdministradorUsuarioComprador;

/**
 *
 * @author JEAV
 */
public class ControladorUsuario {
    
    public AdministradorUsuarioAdministrativo adminUsuAdministrativo;
    public AdministradorUsuarioComprador adminUsuComprador;
    public ControladorArca controladorArca;
    public ControladorProducto controladorProducto;
    
    public ControladorUsuario(){
        adminUsuAdministrativo = new AdministradorUsuarioAdministrativo();
        adminUsuComprador = new AdministradorUsuarioComprador();
        controladorArca = new ControladorArca();
        controladorProducto = new ControladorProducto();
    }
	
    public int insertarSaldo(int saldoIngresado){
        adminUsuComprador.añadirSaldo(saldoIngresado);
	return saldoIngresado;	
    }
        
    public void procesarCompra(String IdProducto, int saldo){
        int precio = controladorProducto.buscarPrecioProducto(IdProducto);
        controladorArca.darVueltas(saldo, precio);
        adminUsuComprador.reiniciarSaldo();
    }
        
    public int cancelarCompra(int saldo){
        int vueltas = controladorArca.darVueltas(saldo, 0);
        adminUsuComprador.reiniciarSaldo();
        return vueltas; 
    }
	
    public boolean verificarContraseña(String contraseña){
        return adminUsuAdministrativo.ComprobarContraseña(contraseña);
    }
}