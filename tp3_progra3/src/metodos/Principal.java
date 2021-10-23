package metodos;


import estructuraDeDatos.Equipo;
import estructuraDeDatos.Torneo;

public class Principal {
	
	private static String path = "src\\archivos\\prueba";

	public static void main(String[] args) {
		
		Equipo[] equipos = new Equipo[7];
		Equipo a = new Equipo("Boca", 3);
		Equipo b = new Equipo("river", 3);
		Equipo c = new Equipo("independiente", 3);
		Equipo d = new Equipo("San Lorenzo", 3);
		Equipo e = new Equipo("Racing", 3);
		Equipo f = new Equipo("Sacachispas", 3);
		Equipo g =new Equipo("Sacachispa", 3);
		equipos[0] = a;
		equipos[1] = b;
		equipos[2] = c;
		equipos[3] = d;
		equipos[4] = e;
		equipos[5] = f;
		equipos[6] =g;
		
		Torneo t = new Torneo(equipos);
		Jsons.generarJSON(path,t);
		
		
	}

	
	
}
