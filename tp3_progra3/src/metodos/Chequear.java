package metodos;

import java.util.Map;

import estructuraDeDatos.*;

public class Chequear {

	public static void arbitro(int arbitro, int limite)
	{
		if(arbitro < 0)
			throw new IllegalArgumentException("El arbitro" + arbitro + " no existe.");
		if (arbitro >= limite)
			throw new IllegalArgumentException("Solo hay " + (limite-1) + " arbitros.");
	}
	
	public static void partido(int partido, int limite)
	{
		if(partido < 0 || partido > limite)
			throw new IllegalArgumentException("Los partidos estan entre el 0 y el " + (limite) + ".");
	}
	
	public static void equipos(String[] equipos)
	{
		if (equipos == null)
			throw new RuntimeException("La lista no contiene equipos.");
		if(equipos.length % 2 == 1)
			throw new IllegalArgumentException("El torneo solo admite una cantidad de equipos par.");
		for (String equipo : equipos)
		{
			if (equipo == null)
				throw new RuntimeException("La lista de equipos no es valida.");
		}
	}
	
	public static void equiposDePartido(Partido partido, Map<String, int[]> equipos)
	{
		String eq1 = partido.getEquipo1();
		String eq2 = partido.getEquipo2();
		
		if (!equipos.containsKey(eq1))
			throw new IllegalArgumentException("El equipo " + eq1 + " no juega el torneo.");
		if (!equipos.containsKey(eq2))
			throw new IllegalArgumentException("El equipo " + eq2 + " no juega el torneo.");
	}
	
	public static void fecha(int a, int limite)
	{
		if (a < 0)
			throw new IllegalArgumentException("No existen fechas negativas.");
		if (a >= limite)
			throw new IllegalArgumentException("Solo hay " + (limite - 1) + "fechas.");
	}

}
