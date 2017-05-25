package co.usa.edu.controlador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.usa.edu.modelo.AdministradorArca;
import co.usa.edu.modelo.Arca;
import co.usa.edu.modelo.UsuarioComprador;

public class ControladorArcaTest {
	
	AdministradorArca administradorarca;
	ControladorArca controladorarca;
	UsuarioComprador usuariocomprador;
	Arca arcaejemplo;
	int idArca;

	@Before
	public void setUp(){
		controladorarca = new ControladorArca();
		usuariocomprador = new UsuarioComprador();
	}
	
	@Test
	public void testDeberiaDarExceptionSiNull() {
		try{
			controladorarca.insertarSaldo(0);
		}
		catch(IllegalArgumentException e){
			
		}
		catch( Exception e ){
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeberiaDarExceptionSiesNegativo() {
		try{
			controladorarca.insertarSaldo(-1);
		}
		catch(IllegalArgumentException e){
			
		}
		catch( Exception e ){
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeberiainsertarsaldode500SiLaEntradaEs500() {
		aciertodelprocesoInsertarSaldo(500, 500);
	}
	
	@Test
	public void testDeberiamodificarDenominacionDe500SiLaEntradaEs10000() {
		aciertodelprocesoModificacionDenominacion(true, 1,10000);
	}
	@Test
	public void testModificacionDePiezas50SilaEntradaes100() {
		aciertodelprocesoModificacionPiezas(true, 1,100);
	}
	
	public void aciertodelprocesoInsertarSaldo(int result, int saldoingresado){
		assertEquals(result, controladorarca.insertarSaldo(saldoingresado));
	}
	
	public void aciertodelprocesoModificacionDenominacion(boolean result, int idArca, int valorentrada){
		assertEquals(result, controladorarca.modificarDenominacion(idArca, valorentrada));
	}
	
	public void aciertodelprocesoModificacionPiezas(boolean result, int idArca, int valorentrada){
		assertEquals(result, controladorarca.modificarPiezas(idArca, valorentrada));
	}

}
