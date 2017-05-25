package co.usa.edu.controlador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.usa.edu.modelo.AdministradorProducto;
import co.usa.edu.modelo.Producto;

public class ControladorProductoTest {

	AdministradorProducto administradorproducto;
	ControladorProducto controladorproducto;
	Producto productoejemplo; 
	String idProducto;
	String idProducto2;
	String idProducto3;
	String idProducto4;
	
	
	@Before
	public void setUp(){
		administradorproducto = new AdministradorProducto();
		controladorproducto = new ControladorProducto();
	}

	@Test
	public void testDeberiaDarExceptionSiNull() {
		try{
			controladorproducto.buscarPrecioProducto(idProducto2);
		}
		catch(IllegalArgumentException e){
			
		}
		catch( Exception e ){
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeberiaDarExceptionSiEsNegativo() {
		try{
			controladorproducto.buscarPrecioProducto(idProducto3);
		}
		catch(IllegalArgumentException e){
			
		}
		catch( Exception e ){
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeberiaDarExceptionSiEsCaracterIncorrecto() {
		try{
			controladorproducto.buscarPrecioProducto(idProducto4);
		}
		catch(IllegalArgumentException e){
			
		}
		catch( Exception e ){
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testDeberiamodificarDenominacionDe500SiLaEntradaEs10000() {
		aciertodelprocesoModificacionExistencias(true, "A1",10000);
	}	
	@Test
	public void testDeberiamodificarNombreDeChocolateSiLaEntradaEsPanela() {
		aciertodelprocesoModificacionNombre(true, "A1","Panela");
	}
	@Test
	public void testDeberiamodificarPrecioDe1000SiLaEntradaEs2000() {
		aciertodelprocesoModificacionPrecio(true, "A1",2000);
	}
	
	public void aciertodelprocesoModificacionExistencias(boolean result, String idProducto, int valorentrada){
		assertEquals(result, controladorproducto.modificarExistencias(idProducto, valorentrada));
	}
	
	public void aciertodelprocesoModificacionNombre(boolean result, String idProducto, String valorentrada){
		assertEquals(result, controladorproducto.modificarNombre(idProducto, valorentrada));
	}
	
	public void aciertodelprocesoModificacionPrecio(boolean result, String idProducto, int valorentrada){
		assertEquals(result, controladorproducto.modificarprecioProducto(idProducto, valorentrada));
	}
}
