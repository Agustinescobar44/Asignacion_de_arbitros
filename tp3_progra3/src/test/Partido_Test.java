package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import estructuraDeDatos.*;

public class Partido_Test {
	@Test
	public void setArbitro_test() 
	{
		Partido partido = generarPartido();
		partido.setArbitro(0);
		
		assertEquals(partido.getEquipo1().partidosDirigidoPor(0), 1);
		assertEquals(partido.getEquipo2().partidosDirigidoPor(0), 1);
	}

	
	@Test
	public void getArbitro_test()
	{
		Partido partido = generarPartido();
		partido.setArbitro(0);
		
		assertEquals(partido.getArbitro(), 0);
	}
	
	@Test
	public void equals_test()
	{
		Equipo eq1 = new Equipo("1", 1);
		Equipo eq2 = new Equipo("2", 1);
		Equipo eq3 = new Equipo("3", 1);
		
		Partido partido1 = new Partido(eq1, eq2);
		Partido partido2 = new Partido(eq1, eq2);
		Partido partido3 = new Partido(eq2, eq1);
		Partido partido4 = new Partido(eq2, eq3);
		
		assertEquals(partido1, partido2);
		assertNotEquals(partido2, partido3);
		assertNotEquals(partido1, partido4);
	}
	
	private Partido generarPartido() 
	{
		Equipo eq1 = new Equipo("San Lorenzo", 1);
		Equipo eq2 = new Equipo("Huracan", 1);
		
		Partido partido = new Partido(eq1, eq2);
		return partido;
	}

}
