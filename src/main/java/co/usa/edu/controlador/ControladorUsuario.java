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
    public ControladorProducto controladorProducto;
    
    public ControladorUsuario(){
        administradorUsuarioAdministrativo = new AdministradorUsuarioAdministrativo();
        administradorUsuarioComprador = new AdministradorUsuarioComprador();
        controladorArca = new ControladorArca();
        controladorProducto = new ControladorProducto();
    }
	
    public int insertarSaldo(int saldoIngresado){
        return administradorUsuarioComprador.añadirSaldo(saldoIngresado);
    }
        
    public String procesarCompra(String IdProducto){
        int precio = controladorProducto.buscarPrecioProducto(IdProducto);
        System.out.println("precio: "+precio);
        int saldo= administradorUsuarioComprador.obtenerSaldo();
        String compra=controladorArca.darVueltas(saldo, precio);
        int s=Integer.parseInt(compra.substring(compra.lastIndexOf(":")+2));
        System.out.println("->"+s);
        if(precio<0){
            compra="Producto no encontrado\nSaldo :"+saldo;
        }
        if(!compra.contains("Saldo insuficiente")){
            administradorUsuarioComprador.reiniciarSaldo();
        }
        administradorUsuarioComprador.reiniciarSaldo();
        administradorUsuarioComprador.añadirSaldo(s);
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