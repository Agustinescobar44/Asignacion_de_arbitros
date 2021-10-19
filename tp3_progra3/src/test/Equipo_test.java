package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import estructuraDeDatos.*;

public class Equipo_test {
	@Test
	public void constructor_test() 
	{
		Equipo equipo = new Equipo("San Lorenzo", 10);
		
		assertEquals(equipo.toString(), "San Lorenzo");
		assertEquals(equipo.partidosDirigidoPor(9), 0);
	}
	
	@Test
	public void contadoDeArbitros_test()
	{
		Equipo equipo = new Equipo("San Miguel", 15);
		
		equipo.agregarPartido(2);
		equipo.agregarPartido(2);
		equipo.agregarPartido(14);
		
		assertEquals(equipo.partidosDirigidoPor(2), 2);
		assertEquals(equipo.partidosDirigidoPor(14), 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void consultaExcedida_test()
	{
		Equipo equipo = new Equipo("Independiente", 10);
		
		equipo.partidosDirigidoPor(10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void consultaNegativa_test()
	{
		Equipo equipo = new Equipo("Independiente", 10);
		
		equipo.partidosDirigidoPor(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarExcedido_test()
	{
		Equipo equipo = new Equipo("Independiente", 10);
		
		equipo.agregarPartido(10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarNegativo_test()
	{
		Equipo equipo = new Equipo("Independiente", 10);
		
		equipo.agregarPartido(-1);
	}
	
	@Test
	public void equals_test()
	{
		Equipo equipo1 = new Equipo("Velez Sarsfield", 2);
		Equipo equipo2 = new Equipo("Velez Sarsfield", 3);
		Equipo equipo3 = new Equipo("vELEZ sARSFIELD", 2);
		Equipo equipo4 = new Equipo("Belez Sarsfield", 2);
		
		assertEquals(equipo1, equipo2);
		assertEquals(equipo1, equipo3);
		assertNotEquals(equipo3, equipo4);
	}
}
