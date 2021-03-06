package co.usa.edu.modelo;

import java.util.ArrayList;

public class AdministradorProducto {

    public static ArrayList<Producto> producto;

    public AdministradorProducto() {
        producto = new  ArrayList<>();
        
        Producto oreo = new Producto();
        oreo.setIdProducto("A1");
        oreo.setNombreProducto("Galleta Oreo");
        oreo.setExistencias(10);
        oreo.setPrecioProducto(2800);
        
        Producto cocacola = new Producto();
        cocacola.setIdProducto("A2");
        cocacola.setNombreProducto("Coca-Cola");
        cocacola.setExistencias(10);
        cocacola.setPrecioProducto(3000);
        
        Producto chocorramo = new Producto();
        chocorramo.setIdProducto("B1");
        chocorramo.setNombreProducto("Chocorramo");
        chocorramo.setExistencias(10);
        chocorramo.setPrecioProducto(2100);
        
        Producto gansito = new Producto();
        gansito.setIdProducto("B2");
        gansito.setNombreProducto("Gansito");
        gansito.setExistencias(10);
        gansito.setPrecioProducto(1500);
        
        producto.add(oreo);
        producto.add(cocacola);
        producto.add(chocorramo);
        producto.add(gansito);
    }
    
    public boolean modificarNombre (String idProducto, String nombre){
    	for (int i = 0; i < producto.size(); i++) {
            if(producto.get(i).getIdProducto().equals(idProducto)){
                if (!producto.get(i).getNombreProducto().equals(nombre)){
                    producto.get(i).setNombreProducto(nombre);
                    return true;
                }
            }	
        }
    	return false;
    }
    
    public boolean modificarExistencia (String idProducto, int existencia){
        for (int i = 0; i < producto.size(); i++) {
            if(producto.get(i).getIdProducto().equalsIgnoreCase(idProducto)){
                if(producto.get(i).getExistencias()!=existencia){
                	producto.get(i).setExistencias(existencia);
                	return true;
                }
            }			
        }
        return false;
    }
    
    public boolean modificarPrecio (String idProducto, int precio){
        for (int i = 0; i < producto.size(); i++) {
            if(producto.get(i).getIdProducto().equals(idProducto)){
                if(producto.get(i).getPrecioProducto()!=precio){
                    producto.get(i).setPrecioProducto(precio);
                    return true;
                }
            }			
        }
        return false;
    }
		
    public ArrayList<String> ListarProductos (){
        ArrayList<String> listaProductos = new ArrayList<>();
        for (int i = 0; i < producto.size(); i++) {
            String informacionproducto= producto.get(i).getIdProducto()+","+producto.get(i).getNombreProducto()+","+producto.get(i).getExistencias()+","+producto.get(i).getPrecioProducto(); 
            listaProductos.add(informacionproducto);
        }
        return listaProductos;
    }
		
    public boolean crearProducto (String producto){
        Producto nuevoproducto = new Producto();
        String [] informacionproducto = producto.split(",");
        nuevoproducto.setIdProducto(informacionproducto[0]);
        nuevoproducto.setNombreProducto(informacionproducto[1]);
        nuevoproducto.setExistencias(Integer.parseInt(informacionproducto[2]));
        nuevoproducto.setPrecioProducto(Integer.parseInt(informacionproducto[3]));
        return true; 
    }
		
    public boolean eliminarProducto (String idProducto){
        for (int i = 0; i < producto.size(); i++) {
            if(idProducto==producto.get(i).getIdProducto()){
                producto.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public int buscarPrecioProducto(String idProducto){
        for (int i = 0; i < producto.size(); i++) {
            if(producto.get(i).getIdProducto().equalsIgnoreCase(idProducto)){
                return producto.get(i).getPrecioProducto();
            }
        }
        return -1;
    }

	public int obtenerExistenciasProducto(String idProducto) {
        for (int i = 0; i < producto.size(); i++) {
            if(producto.get(i).getIdProducto().equalsIgnoreCase(idProducto)){
                return producto.get(i).getExistencias();
            }
        }
        return -1;
	}
}
