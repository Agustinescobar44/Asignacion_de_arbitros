package metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Fecha;
import estructuraDeDatos.Torneo;

public class Principal {
	
	private static String path = "src\\archivos\\prueba";

	public static void main(String[] args) {
		
		Equipo[] equipos = new Equipo[6];
		Equipo a = new Equipo("Boca", 3);
		Equipo b = new Equipo("river", 3);
		Equipo c = new Equipo("independiente", 3);
		Equipo d = new Equipo("San Lorenzo", 3);
		Equipo e = new Equipo("Racing", 3);
		Equipo f = new Equipo("Sacachispas", 3);
		equipos[0] = a;
		equipos[1] = b;
		equipos[2] = c;
		equipos[3] = d;
		equipos[4] = e;
		equipos[5] = f;
		
		Torneo t = new Torneo(equipos);
		t.generarJSON(path);
		
	}

	public static Torneo leerFecha() {
		Gson gson= new Gson();
		Torneo ret = null; 
	
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			ret = gson.fromJson(br, Torneo.class);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ret;
	
	}
	
}
