package co.usa.edu.modelo;

import java.util.ArrayList;


public class AdministradorArca {
	
    private static ArrayList<Arca> arca;

 

    public AdministradorArca() {    	
    	arca = new  ArrayList<>();    	
    }
    
    public void modificarDenominacionArca (int id, int denominacion){
    	
    	for (int i = 0; i < arca.size(); i++) {
    		
    		if(id==arca.get(i).getIdArca()){
    			
    			arca.get(i).setDenominacion(denominacion);
    		}			
		}
    }
    
    public void modificarCantidadPiezasArca (int id, int piezas){
    	
    	for (int i = 0; i < arca.size(); i++) {
    		
    		if(id==arca.get(i).getIdArca()){
    			
    			arca.get(i).setPiezas(piezas);
    		}			
		}
    }
 
 	public void GuardarSaldoArca (int denominacion){
 	
 	for (int i = 0; i < arca.size(); i++) {
 		
 		if(denominacion==arca.get(i).getDenominacion() && arca.get(i).getCantidadMaximaPiezas() > arca.get(i).getPiezas()){
 			
 			arca.get(i).setPiezas(arca.get(i).getPiezas()+1);
 		   }			
		}
    }
 	
 	public ArrayList<String> ListarArcas (){
 		
 		ArrayList<String> lista = new ArrayList<>();
 		
 		for (int i = 0; i < arca.size(); i++) {
 		
 			String informacionarca= arca.get(i).getIdArca()+","+arca.get(i).getDenominacion()+","+arca.get(i).getPiezas()+","+arca.get(i).getCantidadMaximaPiezas(); 
 			lista.add(informacionarca);
 			
 			
 			
 		}
 		
 		return lista;
 		
 	}
 
 	
    
    
    
}