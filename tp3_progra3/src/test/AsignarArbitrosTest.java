package test;

import static org.junit.Assert.assertTrue;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
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
	public void EquiposXArbitro() {
		Torneo t=new Torneo(crear4Equipos());
		t.asignarEquipo("Boca", 0);
		t.asignarEquipo("river", 0);
		Map<Integer, Set<String>> aux= t.getEquiposPorArbitro();
		assertTrue(aux.get(0).contains("Boca"));
		assertTrue(aux.get(0).contains("river"));
		
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
