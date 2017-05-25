package co.usa.edu.controlador;

import co.usa.edu.modelo.AdministradorArca;
import java.util.ArrayList;

public class ControladorArca {
    
    AdministradorArca administradorarca;

    public ControladorArca() {
        administradorarca = new AdministradorArca();
    }
    
    public int insertarSaldo(int saldoingresado ){
        return administradorarca.GuardarSaldoArca(saldoingresado);
    }
    
    public boolean modificarPiezas(int idArca, int piezas){
        return administradorarca.modificarCantidadPiezasArca(idArca, piezas);
    }
    
    public boolean modificarDenominacion(int idArca, int denominacion){
        return administradorarca.modificarDenominacionArca(idArca, denominacion);
    }
    
    public String darVueltas(int saldoUsuario, int valorProducto){
        return administradorarca.darVueltas(saldoUsuario, valorProducto);
    }
    
    public ArrayList<String> listarArcas(){    
        return administradorarca.ListarArcas();
    }
}