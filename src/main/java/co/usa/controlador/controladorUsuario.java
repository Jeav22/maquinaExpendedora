/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.controlador;

import co.usa.edu.modelo.AdministradorUsuarioAdministrativo;
import co.usa.edu.modelo.AdministradorUsuarioComprador;

/**
 *
 * @author JEAV
 */
public class controladorUsuario {
    
    public AdministradorUsuarioAdministrativo adminUsuAdministrativo;
    public AdministradorUsuarioComprador adminUsuComprador;
    public controladorArca controladorArca;
    public controladorProducto controladorProducto;
    
    public controladorUsuario(){
        adminUsuAdministrativo = new AdministradorUsuarioAdministrativo();
        adminUsuComprador = new AdministradorUsuarioComprador();
        controladorArca = new controladorArca();
        controladorProducto = new controladorProducto();
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