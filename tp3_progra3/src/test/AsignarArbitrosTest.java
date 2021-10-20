package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Partido;

public class AsignarArbitrosTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAsignarArbitro() {
		Equipo a = new Equipo("Boca", 2);
		Equipo b = new Equipo("river", 2);
		
		Partido partido = new Partido(a, b);
		
		
		
	}

}
