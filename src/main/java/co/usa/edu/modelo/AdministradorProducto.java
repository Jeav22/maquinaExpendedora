package co.usa.edu.modelo;

import java.util.ArrayList;

public class AdministradorProducto {

    private ArrayList<Producto> producto;

    public AdministradorProducto() {
        producto = new  ArrayList<>();
    }
    
    public boolean modificarNombre (String idProducto, String nombre){
    	for (int i = 0; i < producto.size(); i++) {
            if(idProducto==producto.get(i).getIdProducto()){
                producto.get(i).setNombreProducto(nombre);
            }			
        }
    	return true;
    }
    
    public boolean modificarExistencia (String idProducto, int existencia){
        for (int i = 0; i < producto.size(); i++) {
            if(idProducto==producto.get(i).getIdProducto()){
                producto.get(i).setExistencias(existencia);
            }			
        }
        return true;
    }
    
    public boolean modificarPrecio (String idProducto, int precio){
        for (int i = 0; i < producto.size(); i++) {
            if(idProducto==producto.get(i).getIdProducto()){
                producto.get(i).setPrecioProducto(precio);
            }			
        }
        return true;
    }
		
    public ArrayList<String> ListarProductos (){
        ArrayList<String> listaProductos = new ArrayList<>();
        for (int i = 0; i < producto.size(); i++) {
            String informacionproducto= producto.get(i).getNombreProducto()+","+producto.get(i).getIdProducto()+","+producto.get(i).getExistencias()+","+producto.get(i).getPrecioProducto(); 
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
            if(idProducto==producto.get(i).getIdProducto()){
                return producto.get(i).getPrecioProducto();
            }
        }
        return -1;
    }
}
