package metodos;

import java.util.HashSet;
import java.util.Set;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import estructuraDeDatos.Torneo;

public class AsignarArbitros {
	
	static Set<Integer> arbitrosMarcados;
	
	// Asigno los arbitos para cada fecha del torneo
	public static void asignarArbitros(String path) {
		Torneo t = Jsons.leerTorneoDeJson(path);
		for (int i = 0; i < t.getCantFechas();i++) {
			asignarArbitrosAFecha(t.getFecha(i),t );
		}
	}
	public static void asignarArbitros(Torneo t) {
		for (int i = 0; i < t.getCantFechas();i++) {
			asignarArbitrosAFecha(t.getFecha(i), t);
		}
	}

	//le asigno arbitro a cada partido de la fecha
	public static void asignarArbitrosAFecha(Fecha f, Torneo t) {
		arbitrosMarcados = new HashSet<Integer>();
		for (Partido partido : f.getPartidos()) {
			asignarArbitroAPartido(partido,arbitrosMarcados, t);
		}
	}
	
	/*le asigno un arbitro al partido, que no haya sido marcado antes
		aca es donde va la logica y lo que hay que pensar en grupo 
	*/
	public static void asignarArbitroAPartido(Partido partido,Set<Integer> arbitrosMarcados, Torneo t) {
		String equipoa = partido.getEquipo1();
		String equipob = partido.getEquipo2();
		
		int promedio = 100000000; //temporal
		int arbitroElegido = -1;
		
		for (int i = 0 ; i< t.getCantEquipos()/2 ; i++) {
			
			int suma = t.getArbitrosEquipo(equipoa)[i] + t.getArbitrosEquipo(equipob)[i];
			
			if(suma < promedio && !arbitrosMarcados.contains(i)) { 
				arbitroElegido = i;
				promedio = suma;
			}
		}
		if(arbitroElegido ==-1) {
			throw new RuntimeException("No se pudo asignar el arbitro");
		}
		//partido.setArbitro(arbitroElegido);
		t.setArbitro(partido, arbitroElegido);
		arbitrosMarcados.add(arbitroElegido);

	}
	
	

}
