package co.usa.edu.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdministradorArcaTest {
	
	AdministradorArca administradorArca;
	
		
	@Before
	public void setUp() throws Exception {
		administradorArca= new AdministradorArca();
	}

	@Test
	public void testDeberiaDarTrueSiSeLograModificarLaDenominacionDeArca1() {
		assertEquals(true, administradorArca.modificarDenominacionArca(1, 500));
	}

	@Test
	public void testDeberiaDarTrueSiSeLograModificarLaPiezaDeArca2() {
		assertEquals(true, administradorArca.modificarDenominacionArca(2, 60));
	}
	
	@Test
	public void testDeberiaDarFalseSiNoLograModificarLaPiezaDeUnArcaQueNoExiste() {
		assertEquals(false, administradorArca.modificarCantidadPiezasArca(11, 100));
	}
	
	@Test
	public void testDeberiaDarFalseSiNoLograModificarLaDenominacionDeUnArcaQueNoExiste() {
		assertEquals(false, administradorArca.modificarDenominacionArca(20, 200));
	}
	
	@Test
	public void testGuardarSaldoArca10000() {
		assertEquals(10000, administradorArca.GuardarSaldoArca(10000));
	}
	
	@Test
	public void testdarVueltasSiSeComprancon10000UnProductoDe1500() {
		int saldoUsuario=administradorArca.GuardarSaldoArca(10000);
		
		assertEquals("5000\n2000\n1000\n500\n\nTotal: 8500", administradorArca.darVueltas(saldoUsuario, 1500));
	}
}
