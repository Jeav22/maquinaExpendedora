
package co.usa.controlador;

import co.usa.edu.modelo.AdministradorProducto;
import java.util.ArrayList;


public class controladorProducto {
    
    AdministradorProducto administradorproducto;
    
        public controladorProducto() {
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
          
    
     
     
}
