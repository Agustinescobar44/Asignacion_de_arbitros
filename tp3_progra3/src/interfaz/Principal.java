package interfaz;

import estructuraDeDatos.Torneo;
import metodos.Jsons;

public class Principal {
	public static void main(String[] args) {
		
		generarJsonDelTorneo(crear16Equipos() , "Torneo con 16 equipos");
		generarJsonDelTorneo(crear10Equipos() , "Torneo con 10 equipos");
		generarJsonDelTorneo(crear4Equipos() , "Torneo con 4 equipos");
		
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal("Torneo con 10 equipos");
		ventanaPrincipal.setVisible();
	
	}
	
	private static void generarJsonDelTorneo(String[] equipos , String nombreJson) {
		Torneo t = new Torneo(equipos);
		Jsons.generarJSON(nombreJson, t);
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
