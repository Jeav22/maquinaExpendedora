package co.usa.edu.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class AdministradorArca {
	
    private static ArrayList<Arca> arca;

    public AdministradorArca() {    	
    	arca = new  ArrayList<>(); 

        Arca arca100 = new Arca();
        arca100.setIdArca(1);
        arca100.setDenominacion(100);
        arca100.setPiezas(50);
        arca100.setCantidadMaximaPiezas(100);
        Arca arca200 = new Arca();
        arca200.setIdArca(2);
        arca200.setDenominacion(200);
        arca200.setPiezas(50);
        arca200.setCantidadMaximaPiezas(100);
        Arca arca500 = new Arca();
        arca500.setIdArca(3);
        arca500.setDenominacion(500);
        arca500.setPiezas(50);
        arca500.setCantidadMaximaPiezas(100);
        Arca arca1000 = new Arca();
        arca1000.setIdArca(4);
        arca1000.setDenominacion(1000);
        arca1000.setPiezas(50);
        arca1000.setCantidadMaximaPiezas(100);
        Arca arca2000 = new Arca();
        arca2000.setIdArca(5);
        arca2000.setDenominacion(2000);
        arca2000.setPiezas(50);
        arca2000.setCantidadMaximaPiezas(100);
        Arca arca5000 = new Arca();
        arca5000.setIdArca(6);
        arca5000.setDenominacion(5000);
        arca5000.setPiezas(50);
        arca5000.setCantidadMaximaPiezas(100);
        Arca arca10000 = new Arca();
        arca10000.setIdArca(7);
        arca10000.setDenominacion(10000);
        arca10000.setPiezas(50);
        arca10000.setCantidadMaximaPiezas(100);
        Arca arca20000 = new Arca();
        arca20000.setIdArca(8);
        arca20000.setDenominacion(20000);
        arca20000.setPiezas(50);
        arca20000.setCantidadMaximaPiezas(100);
        Arca arca50000 = new Arca();
        arca50000.setIdArca(9);
        arca50000.setDenominacion(50000);
        arca50000.setPiezas(50);
        arca50000.setCantidadMaximaPiezas(100);
        
        arca.add(arca100);
        arca.add(arca200);
        arca.add(arca500);
        arca.add(arca1000);
        arca.add(arca2000);
        arca.add(arca5000);
        arca.add(arca10000);
        arca.add(arca20000);
        arca.add(arca50000);
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
        
    public String darVueltas (int saldoUsuario, int valorProducto){
        int vueltas = saldoUsuario-valorProducto;
        System.out.println("vueltas: "+vueltas);
        int cambio = 0;
        String mensajevueltas="";
        if(vueltas<100){
            mensajevueltas = "Saldo insuficiente";
        }else{
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
                            mensajevueltas=mensajevueltas+arca.get(i).getDenominacion()+"\n";
                            vueltas = vueltas - arca.get(i).getDenominacion();
                            cambio= cambio+ arca.get(i).getDenominacion();
                            arca.get(i).setPiezas(arca.get(i).getPiezas()-1);
                        }
                    }else{
                        mensajevueltas=mensajevueltas+arca.get(i).getDenominacion()+"\n";
                        vueltas = vueltas - arca.get(i).getDenominacion();
                        cambio= cambio+ arca.get(i).getDenominacion();
                        arca.get(i).setPiezas(arca.get(i).getPiezas()-1);
                    } 
                }
            }     
        }
        return mensajevueltas+"\nTotal: "+cambio;             
    }
}