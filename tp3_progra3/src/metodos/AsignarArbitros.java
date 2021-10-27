package metodos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import estructuraDeDatos.Torneo;

public class AsignarArbitros {
	
	private static Map<String, Equipo> equipos;
	
	private static void conseguirEquipos(Torneo torneo ) {
		Fecha fecha  = torneo.getFecha(0);
		equipos = new HashMap<>();
		for(Partido partido : fecha.getPartidos()) {
			equipos.put(partido.getEquipo1().getNombre(), partido.getEquipo1());
			equipos.put(partido.getEquipo2().getNombre(), partido.getEquipo2());
		}

	}
	
	// Asigno los arbitos para cada fecha del torneo desde un json
	public static void asignarArbitros(String nombre) {
		Torneo t = Jsons.leerTorneoDeJson(nombre);
		conseguirEquipos(t);
		for (Fecha fecha : t.getFechas()) {
			asignarArbitrosAFecha(fecha);
		}
	}
	// Asigno los arbitos para cada fecha del torneo
	public static void asignarArbitros(Torneo t) {
		conseguirEquipos(t);
		for (Fecha fecha : t.getFechas()) {
			asignarArbitrosAFecha(fecha);
		}
	}

	//le asigno arbitro a cada partido de la fecha
	public static void asignarArbitrosAFecha(Fecha f) {
		Set<Integer> arbitrosMarcados = new HashSet<Integer>();
		for (Partido partido : f.getPartidos()) {
			asignarArbitroAPartido(partido,arbitrosMarcados);
		}
	}
	
	/*le asigno un arbitro al partido, que no haya sido marcado antes
		aca es donde va la logica y lo que hay que pensar en grupo 
	*/
	public static void asignarArbitroAPartido(Partido partido,Set<Integer> arbitrosMarcados) {
		Equipo equipoa = partido.getEquipo1();
		Equipo equipob = partido.getEquipo2();
		
		int promedio = 100000000; //temporal
		int arbitroElegido = -1;
		
		for (int i = 0 ; i< equipoa.arbitros.length ; i++) {
			
			if(equipoa.arbitros[i] + equipob.arbitros[i] < promedio && !arbitrosMarcados.contains(i)) { 
				arbitroElegido = i;
				promedio = equipoa.arbitros[i] + equipob.arbitros[i];
			}
		}
		if(arbitroElegido <0) {
			throw new RuntimeException("No se pudo asignar el arbitro");
		}
		partido.setArbitro(arbitroElegido);
		arbitrosMarcados.add(arbitroElegido);

	}
	
	
	
}
