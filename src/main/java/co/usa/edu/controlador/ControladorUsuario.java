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
        String compra;
        int saldo= administradorUsuarioComprador.obtenerSaldo();
        if(precio<0){
            compra="Producto no encontrado\nSaldo :"+saldo;
        }
        boolean b=controladorProducto.modificarExistencias(IdProducto, controladorProducto.obtenerExistencias(IdProducto)-1);
        compra=controladorArca.darVueltas(saldo, precio);
        int s=Integer.parseInt(compra.substring(compra.lastIndexOf(":")+2));
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