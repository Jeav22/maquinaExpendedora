package co.usa.edu.vista;

import co.usa.controlador.ControladorArca;
import java.util.ArrayList;

/**
 *
 * @author JEAV
 */
public class ServicioArca{
    
    ControladorArca controladordearca;

    public ServicioArca(){
        controladordearca = new ControladorArca();
    }
    
    public ArrayList<String> cargarArcas(){
        return controladordearca.listarArcas();
    }
}
