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
		
		String[] diezEquipos = crear10Equipos();
		String[] cuatroEquipos = crear4Equipos();
		String[] diezYSeisEquipos = crear16Equipos();

		Torneo torneoDe16 = new Torneo(diezYSeisEquipos);
		Torneo torneoDe10 = new Torneo(diezEquipos);
		Torneo torneoDe4 = new Torneo(cuatroEquipos);
		Jsons.generarJSON("Torneo con 16 equipos", torneoDe16);
		Jsons.generarJSON("Torneo con 10 equipos", torneoDe10);
		Jsons.generarJSON("Torneo con 4 equipos", torneoDe4);
	
	}
	
	private static String[] crear10Equipos() {
		return new String[]{"Boca", "River", "Independiente", "Racing", "San Lorenzo", "Huracan", "Central", "Newells", "Gimnasia", "Estudiantes"};
	}
	private static String[] crear16Equipos() {
		return new String[]{"Boca", "River", "Independiente", "Racing", "San Lorenzo", "Huracan", "Central", "Newells", "Gimnasia", "Estudiantes"
				, "Colon", "Union", "Los pumas", "San Miguel", "Talleres" , "Sacachispas"};
	}
	private static String[] crear4Equipos() {
		return new String[]{"Boca", "River", "Independiente", "Racing"};
	}

}
