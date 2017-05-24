
package co.usa.edu.vista;

import co.usa.controlador.ControladorProducto;
import java.util.ArrayList;
/**
 *
 * @author JEAV
 */
public class ServicioProducto {
    
    ControladorProducto controladordeproducto;

    public ServicioProducto(){
        controladordeproducto = new ControladorProducto();
    }
    
    public ArrayList<String> cargarProductos(){
        return controladordeproducto.listarProductos();
    }
}

