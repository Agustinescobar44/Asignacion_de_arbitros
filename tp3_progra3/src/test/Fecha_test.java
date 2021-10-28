package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import estructuraDeDatos.Fecha;



public class Fecha_test {
	@Test
	public void cantidadDePartidos_test() 
	{
		String[] equipos = generarEquipos(6);
		Fecha fecha = new Fecha(equipos);
		
		assertEquals(fecha.getCantPartidos(), 3);		
	}
	
	@Test
	public void partidosDeLaFecha_test()
	{
		String[] equipos = generarEquipos(4);
		Fecha fecha = new Fecha(equipos);
		
		String eq1 = fecha.getPartido(0).getEquipo1();
		String eq2 = fecha.getPartido(0).getEquipo2();
		String eq3 = fecha.getPartido(1).getEquipo1();
		String eq4 = fecha.getPartido(1).getEquipo2();
		
		assertEquals(fecha.getCantPartidos(), 2);
		assertNotEquals(eq1, eq3);
		assertNotEquals(eq1, eq4);
		assertNotEquals(eq2, eq3);
		assertNotEquals(eq2, eq4);		
	}

	
	@Test (expected = IllegalArgumentException.class)
	public void partidoExcedido_test()
	{
		String[] equipos = generarEquipos(10);
		Fecha fecha = new Fecha(equipos);
		
		fecha.getPartido(5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void partidoNegativo_test()
	{
		String[] equipos = generarEquipos(10);
		Fecha fecha = new Fecha(equipos);
		
		fecha.getPartido(-1);
	}
	
	
	static String[] generarEquipos(int cantEquipos)
	{
		String[] equipos = new String[cantEquipos];
		
		for (int i = 0; i < cantEquipos; i++)
		{
			String equipo = Integer.toString(i + 1);
			equipos[i] = equipo;
		}
		
		return equipos;
	}

}
