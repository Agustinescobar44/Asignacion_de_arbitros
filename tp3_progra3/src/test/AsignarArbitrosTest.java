package test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import estructuraDeDatos.Torneo;
import metodos.AsignarArbitros;
import metodos.Jsons;

public class AsignarArbitrosTest {

//	@Test
//	public void testAsignarArbitrosATorneoDe4Equipos() {
//		Equipo[] equipos = crear4Equipos();
//		Torneo torneo = new Torneo(equipos);
//		AsignarArbitros.asignarArbitros(torneo);
//	}
//	@Test
//	public void testAsignarArbitrosATorneoDe4EquiposDesdeJson() {
//		Equipo[] equipos= Jsons.leerEquipoDeJson("equipos prueba"); 
//		Torneo torneo = new Torneo(equipos);
//		AsignarArbitros.asignarArbitros(torneo);
//	}
//	@Test 
//	public void testAsignarArbitrosATorneoDe6Equipos() {
//		Equipo[] equipos = crear6Equipos();
//		Torneo torneo = new Torneo(equipos);
//		AsignarArbitros.asignarArbitros(torneo);
//	}
//	
//	
//	
//	@Test  
//	public void testAsignarArbitrosAFecha4Equipos() {
//		Equipo[] equipos = crear4Equipos();
//		
//		Fecha f = new Fecha(equipos);
//		AsignarArbitros.asignarArbitrosAFecha(f);
//		assertEquals(0, f.getPartido(0).getArbitro());
//		assertEquals(1, f.getPartido(1).getArbitro());
//		
//	}
//	
//	@Test  
//	public void testAsignarArbitrosAFecha6Equipos() {
//		Equipo[] equipos = crear6Equipos();
//		
//		Fecha fecha = new Fecha(equipos);
//		AsignarArbitros.asignarArbitrosAFecha(fecha);
//		
//		assertEquals(0, fecha.getPartido(0).getArbitro());
//		assertEquals(1, fecha.getPartido(1).getArbitro());
//		assertEquals(2, fecha.getPartido(2).getArbitro());
//	}
//
//	@Test 
//	public void testAsignarArbitro() {
//		Equipo a = new Equipo("Boca", 2);
//		Equipo b = new Equipo("river", 2);
//		a.arbitros[0] = 1;
//		
//		Partido partido = new Partido(a, b);
//		
//		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
//		
//		assertEquals(1, partido.getArbitro());
//	}
//	
//	@Test 
//	public void testAsignarArbitroMismoPeso() {
//		Equipo equipoa = new Equipo("Boca", 2);
//		Equipo equipoB = new Equipo("river", 2);
//		equipoa.arbitros[0] = 1;
//		equipoa.arbitros[1] = 1;
//		
//		Partido partido = new Partido(equipoa, equipoB);
//		
//		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
//		
//		assertEquals(0, partido.getArbitro());
//		
//	}
//	
//	@Test 
//	public void testAsignarArbitroPrimeroMasPeso() {
//		Equipo a = new Equipo("Boca", 2);
//		Equipo b = new Equipo("river", 2);
//		a.arbitros[0] = 1;
//		b.arbitros[0] = 1;
//		a.arbitros[1] = 1;
//		
//		Partido partido = new Partido(a, b);
//		
//		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
//		
//		assertEquals(1, partido.getArbitro());
//		
//	}
//	
//	@Test 
//	public void testAsignarArbitroSegundoMasPeso() {
//		Equipo a = new Equipo("Boca", 2);
//		Equipo b = new Equipo("river", 2);
//		a.arbitros[0] = 1;
//		a.arbitros[1] = 1;
//		b.arbitros[1] = 1;
//		
//		Partido partido = new Partido(a, b);
//
//		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
//		
//		assertEquals(0, partido.getArbitro());
//
//		
//	}
//
//	private Equipo[] crear6Equipos() {
//		Equipo a = new Equipo("Boca", 3);
//		Equipo b = new Equipo("river", 3);
//		Equipo c = new Equipo("Independiente", 3);
//		Equipo d = new Equipo("SanLorenzso", 3);
//		Equipo e = new Equipo("Sacachispas", 3);
//		Equipo f = new Equipo("El trueno verde", 3);
//		Equipo[] equipos = {a,b,c,d,e,f};
//		return equipos;
//	}
//	private Equipo[] crear4Equipos() {
//		Equipo a = new Equipo("Boca", 2);
//		Equipo b = new Equipo("river", 2);
//		Equipo c = new Equipo("Independiente", 2);
//		Equipo d = new Equipo("SanLorenzso", 2);
//		Equipo[] equipos = {a,b,c,d};
//		return equipos;
//	}
}
