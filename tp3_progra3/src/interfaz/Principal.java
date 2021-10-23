package interfaz;

import estructuraDeDatos.Equipo;
import estructuraDeDatos.Torneo;
import metodos.AsignarArbitros;

public class Principal {
	
	private static Torneo inicializarTorneo() {
		Equipo[] equipos = new Equipo[8];
		Equipo a = new Equipo("Boca", 4);
		Equipo b = new Equipo("river", 4);
		Equipo c = new Equipo("independiente", 4);
		Equipo d = new Equipo("San Lorenzo", 4);
		Equipo e = new Equipo("Racing", 4);
		Equipo f = new Equipo("Sacachispas", 4);
		Equipo g =new Equipo("Sacachispa", 4);
		Equipo h =new Equipo("Sacachisp", 4);
		equipos[0] = a;
		equipos[1] = b;
		equipos[2] = c;
		equipos[3] = d;
		equipos[4] = e;
		equipos[5] = f;
		equipos[6] = g;
		equipos[7] = h;
		
		Torneo t = new Torneo(equipos);
		AsignarArbitros.asignarArbitros(t);
		return t;
	}
	
	static Torneo devolverTorneo() {
		Torneo s=inicializarTorneo();
		return s;
	}

	public static void main(String[] args) {
		

	}

}
