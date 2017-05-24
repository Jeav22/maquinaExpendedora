package co.usa.edu.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class AdministradorArca {
	
    private static ArrayList<Arca> arca;

    public AdministradorArca() {    	
    	arca = new  ArrayList<>();    	
    }
    
    public boolean modificarDenominacionArca (int id, int denominacion){
    	for (int i = 0; i < arca.size(); i++) {
            if(id==arca.get(i).getIdArca()){
                arca.get(i).setDenominacion(denominacion);
                return true;
            }			
        }
        return false;
    }
    
    public boolean modificarCantidadPiezasArca (int id, int piezas){
    	for (int i = 0; i < arca.size(); i++) {
            if(id==arca.get(i).getIdArca()){
                arca.get(i).setPiezas(piezas);
                return true;
            }			
        }
        return false; 
    }
 
    public int GuardarSaldoArca (int denominacion){
 	for (int i = 0; i < arca.size(); i++) {
            if(denominacion==arca.get(i).getDenominacion() && arca.get(i).getCantidadMaximaPiezas() > arca.get(i).getPiezas()){
                arca.get(i).setPiezas(arca.get(i).getPiezas()+1);
                return arca.get(i).getDenominacion();
            }
        }
        return 0;
    }
                
    public ArrayList<String> ListarArcas (){
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < arca.size(); i++) {
            String informacionarca= arca.get(i).getIdArca()+","+arca.get(i).getDenominacion()+","+arca.get(i).getPiezas()+","+arca.get(i).getCantidadMaximaPiezas(); 
            lista.add(informacionarca);
        }
        return lista;
    }
        
    public int darVueltas (int saldoUsuario, int valorProducto){
        int vueltas = valorProducto-saldoUsuario;
        int cambio = 0;
        Collections.sort(arca,new Comparator<Arca>() {
            public int compare(Arca a, Arca a1) {
                return new Integer(a1.getDenominacion()).compareTo(new Integer(a.getDenominacion()));
            }                
        });
        for (int i = 0; i < arca.size(); i++) {
            if(vueltas >= arca.get(i).getDenominacion()){                   
                int contadordearcas = 0;
                for (int j = i; j < arca.size(); j++) {
                    if(arca.get(j).getDenominacion()== arca.get(i).getDenominacion()){
                        contadordearcas ++;
                    }else {
                        break;
                    }
                }
                if(contadordearcas > 1){                    
                    if(arca.get(i).getCantidadMaximaPiezas()!=arca.get(i).getPiezas()){
                        vueltas = vueltas - arca.get(i).getDenominacion();
                        cambio= cambio+ arca.get(i).getDenominacion();
                        arca.get(i).setPiezas(arca.get(i).getPiezas()-1);
                    }
                }else{
                    vueltas = vueltas - arca.get(i).getDenominacion();
                    cambio= cambio+ arca.get(i).getDenominacion();
                    arca.get(i).setPiezas(arca.get(i).getPiezas()-1);
                } 
            }
        }            
        return cambio;             
    }
}