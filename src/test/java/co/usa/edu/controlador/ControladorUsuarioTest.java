package co.usa.edu.controlador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControladorUsuarioTest {
	
	ControladorUsuario controladorUsuario;

	@Before
	public void setUp() throws Exception {
		controladorUsuario = new ControladorUsuario();
	}

	@Test
	public void testdeberiaDar500SiInserta500() {
		assertEquals(500, controladorUsuario.insertarSaldo(500));
	}
	
	@Test
	public void testdeberiaDar600SiInserta100TeniendoEnCuentaLoAnterior() {
		controladorUsuario.insertarSaldo(500);
		assertEquals(600, controladorUsuario.insertarSaldo(100));
	}
	
	@Test
	public void testdeberiaDarFalseSiContraseñaAVS12(){
		assertEquals(false, controladorUsuario.verificarContraseña("AVS12"));
	}
	
	@Test
	public void testdeberiaDarTrueSiContraseña123(){
		assertEquals(true, controladorUsuario.verificarContraseña("123"));
	}
	
	@Test
	public void testdeberiaDarVueltasSiCanceloConSaldoDe3200(){
		assertEquals("2000\n1000\n200\n\nTotal: 3200", controladorUsuario.cancelarCompra(3200));
	}

	@Test
	public void testdeberiaDarVueltasSiCanceloConSaldoDe5000(){
		assertEquals("5000\n\nTotal: 5000", controladorUsuario.cancelarCompra(5000));
	}

	@Test
	public void testdeberiaDarVueltasSiCanceloConSaldoDe0(){
		assertEquals("Saldo insuficiente\nTotal: 0", controladorUsuario.cancelarCompra(0));
	}
	
	@Test
	public void testdeberiaDarSaldoAlComprarGansitoConSaldo5000(){
		controladorUsuario.insertarSaldo(5000);
		assertEquals("2000\n1000\n500\n\nTotal: 3500", controladorUsuario.procesarCompra("B2"));
	}
	
	@Test
	public void testdeberiaDarSaldoAlComprarGansitoConSaldo1000(){
		controladorUsuario.insertarSaldo(1000);
		assertEquals("Saldo insuficiente\nTotal: 0", controladorUsuario.procesarCompra("B2"));
	}

	@Test
	public void testdeberiaDarSaldoAlComprarGansitoSinSaldo(){
		assertEquals("Saldo insuficiente\nTotal: 0", controladorUsuario.procesarCompra("B2"));
	}
}
