package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Fecha;



public class Fecha_test {
	@Test
	public void cantidadDePartidos_test() 
	{
		Equipo[] equipos = generarEquipos(6);
		Fecha fecha = new Fecha(equipos);
		
		assertEquals(fecha.getCantPartidos(), 3);		
	}
	
	@Test
	public void partidosDeLaFecha_test()
	{
		Equipo[] equipos = generarEquipos(4);
		Fecha fecha = new Fecha(equipos);
		
		Equipo eq1 = fecha.getPartido(0).getEquipo1();
		Equipo eq2 = fecha.getPartido(0).getEquipo2();
		Equipo eq3 = fecha.getPartido(1).getEquipo1();
		Equipo eq4 = fecha.getPartido(1).getEquipo2();
		
		assertEquals(fecha.getCantPartidos(), 2);
		assertNotEquals(eq1, eq3);
		assertNotEquals(eq1, eq4);
		assertNotEquals(eq2, eq3);
		assertNotEquals(eq2, eq4);		
	}
	
	@Test
	public void arbitros_test()
	{
		Equipo[] equipos = generarEquipos(4);
		Fecha fecha = new Fecha(equipos);
		fecha.setArbitro(0, 0);
		fecha.setArbitro(1, 1);
		
		assertEquals(0, fecha.getPartido(0).getArbitro());
		assertEquals(1, fecha.getPartido(1).getArbitro());
	}
	
	@Test (expected = RuntimeException.class)
	public void arbitroOcupado_test()
	{
		Equipo[] equipos = generarEquipos(10);
		Fecha fecha = new Fecha(equipos);
		
		fecha.setArbitro(0, 0);
		fecha.setArbitro(1, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void arbitroExcedido_test()
	{
		Equipo[] equipos = generarEquipos(10);
		Fecha fecha = new Fecha(equipos);
		
		fecha.setArbitro(0, 5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void arbitroNegativo_test()
	{
		Equipo[] equipos = generarEquipos(10);
		Fecha fecha = new Fecha(equipos);
		
		fecha.setArbitro(0, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void partidoExcedido_test()
	{
		Equipo[] equipos = generarEquipos(10);
		Fecha fecha = new Fecha(equipos);
		
		fecha.setArbitro(5, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void partidoNegativo_test()
	{
		Equipo[] equipos = generarEquipos(10);
		Fecha fecha = new Fecha(equipos);
		
		fecha.setArbitro(-1, 0);
	}
	
	
	static Equipo[] generarEquipos(int cantEquipos)
	{
		Equipo[] equipos = new Equipo[cantEquipos];
		
		for (int i = 0; i < cantEquipos; i++)
		{
			Equipo equipo = new Equipo(Integer.toString(i + 1), cantEquipos);
			equipos[i] = equipo;
		}
		
		return equipos;
	}

}
