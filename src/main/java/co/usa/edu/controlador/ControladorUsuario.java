package co.usa.edu.controlador;

import co.usa.edu.modelo.AdministradorUsuarioAdministrativo;
import co.usa.edu.modelo.AdministradorUsuarioComprador;

/**
 *
 * @author JEAV
 */
public class ControladorUsuario{
    
    private static AdministradorUsuarioAdministrativo administradorUsuarioAdministrativo;
    private static AdministradorUsuarioComprador administradorUsuarioComprador;
    private static ControladorArca controladorArca;
    private static ControladorProducto controladorProducto;
    
    public ControladorUsuario(){
        administradorUsuarioAdministrativo = new AdministradorUsuarioAdministrativo();
        administradorUsuarioComprador = new AdministradorUsuarioComprador();
        controladorArca = new ControladorArca();
        controladorProducto = new ControladorProducto();
    }
	
    public int insertarSaldo(int saldoIngresado){
        administradorUsuarioComprador.añadirSaldo(saldoIngresado);
	return saldoIngresado;	
    }
        
    public String procesarCompra(String IdProducto, int saldo){
        int precio = controladorProducto.buscarPrecioProducto(IdProducto);
        String compra=controladorArca.darVueltas(saldo, precio);
        administradorUsuarioComprador.reiniciarSaldo();
        return compra;
    }
        
    public String cancelarCompra(int saldo){
        String vueltas = controladorArca.darVueltas(saldo, 0);
        administradorUsuarioComprador.reiniciarSaldo();
        return vueltas; 
    }
	
    public boolean verificarContraseña(String contraseña){
        return administradorUsuarioAdministrativo.ComprobarContraseña(contraseña);
    }
}