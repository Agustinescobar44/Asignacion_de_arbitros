package metodos;

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
		if(partido < 0 || partido > limite-1)
			throw new IllegalArgumentException("Los partidos estan entre el 0 y el " + (limite-1) + ".");
	}
	
	public static void equipos(Equipo[] equipos)
	{
		if(equipos.length % 2 == 1)
			throw new IllegalArgumentException("El torneo solo admite una cantidad de equipos par.");
		for (Equipo equipo : equipos)
		{
			if (equipo == null)
				throw new RuntimeException("La lista de equipos no es valida.");
		}
	}
	
	public static void fecha(int a, int limite)
	{
		if (a < 0)
			throw new IllegalArgumentException("No existen fechas negativas.");
		if (a >= limite)
			throw new IllegalArgumentException("Solo hay " + (limite - 1) + "fechas.");
	}

}
