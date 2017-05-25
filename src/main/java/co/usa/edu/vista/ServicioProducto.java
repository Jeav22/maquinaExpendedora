
package co.usa.edu.vista;

import co.usa.edu.controlador.ControladorProducto;
import java.util.ArrayList;
/**
 *
 * @author JEAV
 */
public class ServicioProducto {
    
    private static ControladorProducto controladordeproducto;

    public ServicioProducto(){
        controladordeproducto = new ControladorProducto();
    }
    
    public ArrayList<String> cargarProductos(){
        return controladordeproducto.listarProductos();
    }
}

