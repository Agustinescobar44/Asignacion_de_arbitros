package estructuraDeDatos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import metodos.Chequear;

public class Torneo 
{
	String[] listaEquipos;
	Map<String, int[]> equipos;
	Fecha[] fixture;
	int cantEquipos;
	
	public Torneo(String[] nombres)
	{
		Chequear.equipos(nombres);
		
		this.cantEquipos = nombres.length;
		this.equipos = new HashMap<String, int[]>();
		this.listaEquipos = new String[this.cantEquipos];
		int i = 0;
		for (String s : nombres)
		{
			this.listaEquipos[i] = s;
			int[] arbitros = new int[this.cantEquipos/2];
			this.equipos.put(s, arbitros);
			i++;
		}
		this.fixture = new Fecha[cantEquipos-1];
		this.generarFixture();
	}

	//Aplico el algoritmo mostrado en: https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
	private void generarFixture()
	{
		int i = 0;
		while (i < this.cantEquipos-1)
		{
			fixture[i] = new Fecha(listaEquipos);
			
			this.modificarArreglo();
			i++;
		}
	}	
	private void modificarArreglo()
	{
		String auxiliar = listaEquipos[this.cantEquipos-1];
		for (int i = this.cantEquipos-2; i >= 0; i--)
		{
			listaEquipos[i+1] = listaEquipos[i];
		}
		listaEquipos[0] = auxiliar;
	}
	
	public void setArbitro(Partido partido, int arbitro)
	{
		Chequear.arbitro(arbitro, this.cantEquipos/2);
		Chequear.equiposDePartido(partido, equipos);
		
		String eq1 = partido.getEquipo1();
		String eq2 = partido.getEquipo2();
		partido.setArbitro(arbitro);
		equipos.get(eq1)[arbitro]++;
		equipos.get(eq2)[arbitro]++;
	}
	
	public int getCantFechas()
	{
		return this.fixture.length;
	}
	
	//A revisar por temas de encapsulamiento.
	public Fecha getFecha(int i)
	{
		Chequear.fecha(i, this.cantEquipos - 1);
		return this.fixture[i];
	}
	
	public int[] getArbitrosEquipo(String equipo)
	{
		if (this.equipos.containsKey(equipo))
			return this.equipos.get(equipo);
		else
			throw new IllegalArgumentException("El equipo " + equipo + "no juega este torneo.");
	}
	
	public int getCantEquipos()
	{
		return this.cantEquipos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(", fixture=");
		builder.append(Arrays.toString(fixture));

		return builder.toString();
	}
}
