package co.usa.edu.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdministradorUsuarioCompradorTest {
	
	AdministradorUsuarioComprador administradorUsuarioComprador;
	
	@Before
	public void setUp() throws Exception {
		administradorUsuarioComprador = new AdministradorUsuarioComprador();
	}

	@Test
	public void testAñadirSaldo20000() {
		assertEquals(20000, administradorUsuarioComprador.añadirSaldo(20000));
	}
	

	@Test
	public void testDeberiaDar11000AlAñadirSaldo10000ConSaldoPrevioDe1000() {
		administradorUsuarioComprador.añadirSaldo(1000);
		assertEquals(11000, administradorUsuarioComprador.añadirSaldo(10000));
	}
	

	@Test
	public void testDeberiaDarCeroAlReiniciarSaldo() {
		administradorUsuarioComprador.añadirSaldo(1000);
		assertEquals(11000, administradorUsuarioComprador.añadirSaldo(10000));
		assertEquals(0, administradorUsuarioComprador.reiniciarSaldo());
	}
	

	@Test
	public void testDeberiaDar600SiObtengoSaldoDe600() {
		administradorUsuarioComprador.añadirSaldo(500);
		administradorUsuarioComprador.añadirSaldo(100);
		assertEquals(600, administradorUsuarioComprador.obtenerSaldo());
	}
}
