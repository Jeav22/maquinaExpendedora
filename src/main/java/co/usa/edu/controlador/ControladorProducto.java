package co.usa.edu.controlador;

import co.usa.edu.modelo.AdministradorProducto;
import java.util.ArrayList;

public class ControladorProducto {
    
    private static AdministradorProducto administradorproducto;
    
    public ControladorProducto(){
        administradorproducto= new AdministradorProducto();
    }
    
    public boolean modificarExistencias(String idProducto, int existencias){
        return administradorproducto.modificarExistencia(idProducto, existencias);
    }
    
    public boolean modificarNombre(String idProducto, String nombreProducto){
        return administradorproducto.modificarNombre(idProducto, nombreProducto);
    }
     
    public boolean modificarprecioProducto(String idProducto, int precio){
        return administradorproducto.modificarPrecio(idProducto, precio);
    }
      
    public ArrayList<String> listarProductos(){    
        return administradorproducto.ListarProductos();
    }
        
    public boolean crearProducto(String producto){
        return administradorproducto.crearProducto(producto);
    }
        
    public boolean eliminarProducto(String idproducto){
        return administradorproducto.eliminarProducto(idproducto);
    }

    int buscarPrecioProducto(String idProducto) {
        return administradorproducto.buscarPrecioProducto(idProducto);
    }
}
