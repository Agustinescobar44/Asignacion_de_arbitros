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
	public void testAsignarArbitros() {
		Equipo a = new Equipo("Boca", 2);
		Equipo b = new Equipo("river", 2);
		Equipo c = new Equipo("Independiente", 2);
		Equipo d = new Equipo("SanLorenzso", 2);
		Equipo[] equipos = {a,b,c,d};
		
		Fecha f = new Fecha(equipos);
		f.agregarPartido(a, b);
		f.agregarPartido(c, d);
		AsignarArbitros.asignarArbitros(f);
		assertEquals(0, f.getPartido(0).getArbitro());
		assertEquals(1, f.getPartido(1).getArbitro());
		System.out.println(f.getPartido(0));
		System.out.println(f.getPartido(1));
		
		System.out.println("-------------");
		
		f = new Fecha(equipos);
		f.agregarPartido(a,c);
		f.agregarPartido(b,d);
		AsignarArbitros.asignarArbitros(f);
		assertEquals(0, f.getPartido(0).getArbitro());
		assertEquals(1, f.getPartido(1).getArbitro());
		System.out.println(f.getPartido(0));
		System.out.println(f.getPartido(1));
		System.out.println("-------------");
		
		f = new Fecha(equipos);
		f.agregarPartido(a,d);
		f.agregarPartido(b,c);
		AsignarArbitros.asignarArbitros(f);
		System.out.println(f.getPartido(0));
		System.out.println(f.getPartido(1));
		assertEquals(0, f.getPartido(0).getArbitro());
		assertEquals(1, f.getPartido(1).getArbitro());
		
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
