package test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Ignore;
import org.junit.Test;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import metodos.AsignarArbitros;

public class AsignarArbitrosTest {

	@Test  
	public void testAsignarArbitros4Equipos() {
		Equipo a = new Equipo("Boca", 2);
		Equipo b = new Equipo("river", 2);
		Equipo c = new Equipo("Independiente", 2);
		Equipo d = new Equipo("SanLorenzso", 2);
		Equipo[] equipos = {a,b,c,d};
		
		Fecha f = new Fecha(equipos);
		AsignarArbitros.asignarArbitrosAFecha(f);
		System.out.println(f.getPartidos());
		System.out.println("-------------");
		
		AsignarArbitros.asignarArbitrosAFecha(f);
		System.out.println(f.getPartidos());
		System.out.println("-------------");
		
		AsignarArbitros.asignarArbitrosAFecha(f);
		System.out.println(f.getPartidos());
	}
	
	@Test  
	public void testAsignarArbitros6Equipos() {
		Equipo a = new Equipo("Boca", 3);
		Equipo b = new Equipo("river", 3);
		Equipo c = new Equipo("Independiente", 3);
		Equipo d = new Equipo("SanLorenzso", 3);
		Equipo e = new Equipo("Independiente", 3);
		Equipo f = new Equipo("SanLorenzso",3);
		Equipo[] equipos = {a,b,c,d,e,f};
		
		Fecha fecha = new Fecha(equipos);
		AsignarArbitros.asignarArbitrosAFecha(fecha);
		System.out.println(fecha.getPartidos());
		System.out.println("-------------");
		
		AsignarArbitros.asignarArbitrosAFecha(fecha);
		System.out.println(fecha.getPartidos());
		System.out.println("-------------");
		
		AsignarArbitros.asignarArbitrosAFecha(fecha);
		System.out.println(fecha.getPartidos());
	}

	@Test 
	public void testAsignarArbitro() {
		Equipo a = new Equipo("Boca", 2);
		Equipo b = new Equipo("river", 2);
		a.arbitros[0] = 1;
		
		Partido partido = new Partido(a, b);
		
		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
		
		assertEquals(1, partido.getArbitro());
	}
	
	@Test 
	public void testAsignarArbitroMismoPeso() {
		Equipo equipoa = new Equipo("Boca", 2);
		Equipo equipoB = new Equipo("river", 2);
		equipoa.arbitros[0] = 1;
		equipoa.arbitros[1] = 1;
		
		Partido partido = new Partido(equipoa, equipoB);
		
		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
		
		assertEquals(0, partido.getArbitro());
		
	}
	
	@Test 
	public void testAsignarArbitroPrimeroMasPeso() {
		Equipo a = new Equipo("Boca", 2);
		Equipo b = new Equipo("river", 2);
		a.arbitros[0] = 1;
		b.arbitros[0] = 1;
		a.arbitros[1] = 1;
		
		Partido partido = new Partido(a, b);
		
		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
		
		assertEquals(1, partido.getArbitro());
		
	}
	
	@Test 
	public void testAsignarArbitroSegundoMasPeso() {
		Equipo a = new Equipo("Boca", 2);
		Equipo b = new Equipo("river", 2);
		a.arbitros[0] = 1;
		a.arbitros[1] = 1;
		b.arbitros[1] = 1;
		
		Partido partido = new Partido(a, b);

		AsignarArbitros.asignarArbitroAPartido(partido,new HashSet<Integer>());
		
		assertEquals(0, partido.getArbitro());

		
	}

}
