package interfaz;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Torneo;
import metodos.AsignarArbitros;
import metodos.Jsons;

public class Principal {
	

	
	static Torneo devolverTorneo() {
		Torneo t = Jsons.leerTorneoDeJson("prueba");
		AsignarArbitros.asignarArbitros(t);
		System.out.println(t);
		return t;
	}

	public static void main(String[] args) {
		
		Equipo a = new Equipo("Boca", 2);
		Equipo b = new Equipo("river", 2);
		Equipo c = new Equipo("independiente", 2);
		Equipo d = new Equipo("San Lorenzo",2);
		
		Equipo[] equipos = {a,b,c,d};

		Torneo t = new Torneo(equipos);
		Jsons.generarJSON("equipos prueba", equipos);
	
	}

}
