package metodos;

import java.util.HashSet;
import java.util.Set;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import estructuraDeDatos.Torneo;

public class AsignarArbitros {
	
	private static void chequearTorneo(Torneo t) {
		if(t.getCantEquipos() < 2)
			throw new IllegalArgumentException("los equipos deben ser mas de 1");
		if(t.getCantEquipos()%2 != 0)
			throw new IllegalArgumentException("Los equipos deben ser pares, este torneo tiene " + t.getCantEquipos() + " equipos");
		if(t.getCantFechas() != t.getCantEquipos()-1) 
			throw new IllegalArgumentException("la cantidad de fechas no es la correcta");
	}
	
	// Asigno los arbitos para cada fecha del torneo
	public static void asignarArbitros(String nombre) {
		Torneo t = Jsons.leerTorneoDeJson(nombre);

		chequearTorneo(t);
		
		for (int i = 0; i < t.getCantFechas();i++) {
			asignarArbitrosAFecha(t.getFecha(i),t );
		}
	}
	public static void asignarArbitros(Torneo t) {
		chequearTorneo(t);
		
		for (int i = 0; i < t.getCantFechas();i++) {
			asignarArbitrosAFecha(t.getFecha(i), t);
		}
	}

	//le asigno arbitro a cada partido de la fecha
	private static void asignarArbitrosAFecha(Fecha f, Torneo t) {
		Set<Integer> arbitrosMarcados = new HashSet<Integer>();
		for (Partido partido : f.getPartidos()) {
			asignarArbitroAPartido(partido,arbitrosMarcados, t);
		}
	}
	
	/*le asigno un arbitro al partido, que no haya sido marcado antes
		aca es donde va la logica y lo que hay que pensar en grupo 
	*/
	private static void asignarArbitroAPartido(Partido partido,Set<Integer> arbitrosMarcados, Torneo t) {
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
		t.setArbitro(partido, arbitroElegido);
		arbitrosMarcados.add(arbitroElegido);

	}
	
	

}
