package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;

public class AsignarArbitros {
	
	static Fecha[] fechas = null;
	static Set<Integer> arbitrosMarcados;
	
	public static void asignarArbitros(String path) {
		fechas = Jsons.leerFechasDeJson(path);
		for(Fecha fecha : fechas) {
			asignarArbitroAFecha(fecha);
		}
	}

	public static void asignarArbitroAFecha(Fecha f) {
		arbitrosMarcados = new HashSet<Integer>();
		for (Partido partido : f.getPartidos()) {
			asignarArbitroAPartido(partido,arbitrosMarcados);
		}
	}
	
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
		if(arbitroElegido ==-1) {
			throw new RuntimeException("No se pudo asignar el arbitro");
		}
		partido.setArbitro(arbitroElegido);
		arbitrosMarcados.add(arbitroElegido);

	}
	
	
	
}
