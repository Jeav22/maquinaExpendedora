package co.usa.edu.vista;

import co.usa.edu.controlador.ControladorArca;
import java.util.ArrayList;

/**
 *
 * @author JEAV
 */
public class ServicioArca{
    
    private static ControladorArca controladordearca;

    public ServicioArca(){
        controladordearca = new ControladorArca();
    }
    
    public ArrayList<String> cargarArcas(){
        return controladordearca.listarArcas();
    }
}
