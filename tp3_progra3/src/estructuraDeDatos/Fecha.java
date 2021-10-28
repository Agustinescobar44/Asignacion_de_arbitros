package estructuraDeDatos;

import java.util.ArrayList;

import metodos.Chequear;

public class Fecha {
	
	private ArrayList <Partido> partidos;
	private int cantPartidos;
	private String[] equipos;
	
	public Fecha (String[] equipos)
	{	
		this.equipos = equipos;
		this.partidos = new ArrayList<Partido>();
		this.generarFecha();
		this.cantPartidos = partidos.size();
		
		
	}
	
	private void generarFecha()
	{
		int i = 0;
		int j = equipos.length - 1;

		while (this.partidos.size() < (equipos.length / 2))
		{
			this.agregarPartido(equipos[i], equipos[j]);
			i++;
			j--;
		}
	}

	private void agregarPartido(String eq1, String eq2)
	{
		Partido partido = new Partido(eq1, eq2);
		this.partidos.add(partido);		
	}
	
	//Devuelvo el partido en la posicion "partido" de la lista. A revisar por temas de encapsulamiento.
	public Partido getPartido(int partido)
	{
		Chequear.partido(partido, this.cantPartidos);
		
		return this.partidos.get(partido);
	}
	
	public ArrayList<Partido> getPartidos(){
		return this.partidos;
	}
	
	public int getCantPartidos()
	{
		return this.cantPartidos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fecha [partidos=");
		builder.append(partidos);
		builder.append("]\n");
		return builder.toString();
	}
}
