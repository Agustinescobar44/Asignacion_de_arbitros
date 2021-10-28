package interfaz;

import estructuraDeDatos.Torneo;
import metodos.AsignarArbitros;
import metodos.Jsons;

public class Principal {
	

	
	static Torneo devolverTorneo() {
		Torneo t = Jsons.leerTorneoDeJson("prueba");
		AsignarArbitros.asignarArbitros(t);
		//System.out.println(t);
		return t;
	}

	public static void main(String[] args) {
		
		String[] equipos = {"Boca", "River", "Independiente", "Racing", "San Lorenzo", "Huracan", "Central", "Newells", "Gimnasia", "Estudiantes"};

		Torneo t = new Torneo(equipos);
		Jsons.generarJSON("prueba", t);
	
	}

}
