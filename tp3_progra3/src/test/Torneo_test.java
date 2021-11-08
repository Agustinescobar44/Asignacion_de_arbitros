package test;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import estructuraDeDatos.Torneo;

public class Torneo_test {

	@Test
	public void cantidad_equipos_test() 
	{
		Torneo t = generarTorneo(10);
		
		assertEquals(t.getCantEquipos(), 10);
	}
	
	@Test
	public void cantidad_fechas_test()
	{
		Torneo t = generarTorneo(50);
		
		assertEquals(t.getCantFechas(), 49);
	}
	
	@Test
	public void get_fecha_test()
	{
		Torneo t = generarTorneo(2);
		Fecha fecha = t.getFecha(0);
		
		assertEquals(fecha.getPartido(0).getEquipo1(), "1");
		assertEquals(fecha.getPartido(0).getEquipo2(), "2");
	}
	
	@Test
	public void set_arbitro_test()
	{
		Torneo t = generarTorneo(2);
		Partido partido = t.getFecha(0).getPartido(0);
		
		assertEquals(t.getArbitrosEquipo("1")[0], 0);
		assertEquals(t.getArbitrosEquipo("2")[0], 0);
		
		t.setArbitro(partido, 0);
		
		assertEquals(t.getArbitrosEquipo("1")[0], 1);
		assertEquals(t.getArbitrosEquipo("2")[0], 1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void arbitro_erroneo()
	{
		Torneo t = generarTorneo(20);
		Partido partido = t.getFecha(0).getPartido(0);
		t.setArbitro(partido, 11);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void equipos_impares_test()
	{
		@SuppressWarnings("unused")
		Torneo t = generarTorneo (5);
	}
	
	@Test (expected = RuntimeException.class)
	public void equipos_null()
	{
		String[] equipos = new String[0];
		@SuppressWarnings("unused")
		Torneo t = new Torneo(equipos);
	}
	
	@Test (expected = RuntimeException.class)
	public void equipo_null()
	{
		String[] equipos = new String[2];
		equipos[0] = "1";
		@SuppressWarnings("unused")
		Torneo t = new Torneo(equipos);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void get_fecha_excedida_test()
	{
		Torneo t = generarTorneo(10);
		t.getFecha(10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void get_fecha_negativa_test()
	{
		Torneo t = generarTorneo(2);
		t.getFecha(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void set_arbitro_partido_erroneo()
	{
		Torneo t = generarTorneo(10);
		Partido partido = new Partido("Boca", "River");
		
		t.setArbitro(partido, 0);
	}
	static Torneo generarTorneo(int cantEquipos)
	{
		String[] equipos = new String[cantEquipos];
		for (int i = 0; i < cantEquipos; i++)
		{
			equipos[i] = Integer.toString(i + 1);
		}
		
		Torneo ret = new Torneo(equipos);
		return ret;
	}
	
	@Test
	public void asignarEquipoAarbitro0() {
		String a = "Boca";
		String b = "river";
		String c = "Independiente";
		String d = "Racing";
		String[] equipos = {a,b,c,d};
		Torneo t=new Torneo(equipos);
		t.asignarEquipo("Boca", 0);
		t.asignarEquipo("river", 0);
		Map<Integer, Set<String>> aux= t.getEquiposPorArbitro();
		assertTrue(aux.get(0).contains("Boca"));
		assertTrue(aux.get(0).contains("river"));
	}
}
