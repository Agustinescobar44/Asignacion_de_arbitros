package estructuraDeDatos;

import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import metodos.Chequear;

public class Fecha {
	private ArrayList <Partido> partidos;
	//La posicion de la lista representa al arbitro. Su valor determina si está ocupado en esta fecha o no.
	private boolean[] arbitros;
	private Equipo[] equipos;
	private int cantPartidos;
	
	public Fecha (Equipo[] equipos)
	{
		this.partidos = new ArrayList<Partido>();
		this.arbitros = new boolean[equipos.length/2];
		this.equipos = equipos;
		this.generarFecha();
		this.cantPartidos = partidos.size();
	}
	
	private void generarFecha()
	{
		int i = 0;
		int j = equipos.length - 1;
		//Una fecha tiene la cantidad de equipos sobre dos partidos (n/2)
		while (this.partidos.size() < (equipos.length / 2))
		{
			//Aplico el algoritmo mostrado en: https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
			this.agregarPartido(equipos[i], equipos[j]);
			System.out.println(equipos[i] + " vs " + equipos[j]); //Solo para probar en main.
			i++;
			j--;

		}
	}
	
	//Metodo auxiliar de generarFecha.
	public void agregarPartido(Equipo eq1, Equipo eq2)
	{
		Partido partido = new Partido(eq1, eq2);
		this.partidos.add(partido);		
	}
	
	//Dado un partido le asigno un arbitro. Ademas, ese arbitro queda inhabilitado para dirigir otro partido
	//en esta misma fecha.
	public void setArbitro(int partido, int arbitro)
	{
		Chequear.partido(partido, this.cantPartidos);
		Chequear.arbitro(arbitro, this.cantPartidos);
		
		if(this.arbitros[arbitro] == false)
		{	
			this.partidos.get(partido).setArbitro(arbitro);
			this.arbitros[arbitro] = true;
		}
		else
			throw new RuntimeException("El arbitro ya está ocupado.");
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
	public void generarJSON(String archivo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		
		try {
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fecha [partidos=");
		builder.append(partidos);
		builder.append("]");
		return builder.toString();
	}
	
	

}
