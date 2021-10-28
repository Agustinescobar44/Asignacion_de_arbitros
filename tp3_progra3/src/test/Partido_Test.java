package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import estructuraDeDatos.*;

public class Partido_Test {
	
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
		String eq1 = "1";
		String eq2 = "2";
		String eq3 = "3";
		
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
		String eq1 = "San Lorenzo";
		String eq2 = "Huracan";
		
		Partido partido = new Partido(eq1, eq2);
		return partido;
	}

}
