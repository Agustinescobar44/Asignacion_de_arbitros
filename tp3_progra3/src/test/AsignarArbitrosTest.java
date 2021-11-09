package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import estructuraDeDatos.Torneo;
import metodos.AsignarArbitros;
import metodos.Jsons;

public class AsignarArbitrosTest {

	@Test (expected = IllegalArgumentException.class)
	public void testTorneoConEquiposImpar() {
		Torneo torneo = Jsons.leerTorneoDeJson("Torneo con 3 equipos");
		AsignarArbitros.asignarArbitros(torneo);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testTorneoSinEquipos() {
		Torneo torneo = Jsons.leerTorneoDeJson("Torneo sin equipos");
		AsignarArbitros.asignarArbitros(torneo);
	}
	
	@Test 
	public void testTodosLosEquiposTienenArbitro() {
		Torneo torneo = new Torneo(crear4Equipos());
		AsignarArbitros.asignarArbitros(torneo);
		Assert.todosConArbitro(torneo);
	}
	@Test 
	public void testTodosLosEquiposTienenArbitroDiferente() {
		Torneo torneo = new Torneo(crear4Equipos());
		AsignarArbitros.asignarArbitros(torneo);
		Assert.todosConArbitroDiferente(torneo);
	}
	
	@Test
	public void testArbitrosPrimeraFecha() {

		Torneo t=new Torneo(crear4Equipos());
		
		AsignarArbitros.asignarArbitros(t);
		Fecha fecha = t.getFecha(0);
		ArrayList<Partido> partidos = fecha.getPartidos();
		
		assertEquals(0, partidos.get(0).getArbitro());
		assertEquals(1, partidos.get(1).getArbitro());
	}
	
	@Test
	public void testAsignarArbitro() {
		Torneo t=new Torneo(crear4Equipos());
		
		AsignarArbitros.asignarArbitros(t);
		
		Assert.asignarArbitro(t);
	}
	
	private String[] crear4Equipos() {
		String a = "Boca";
		String b = "river";
		String c = "Independiente";
		String d = "Racing";
		String[] equipos = {a,b,c,d};
		return equipos;
	}

}
