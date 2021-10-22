package estructuraDeDatos;

import java.util.Arrays;
import java.util.Objects;


import metodos.Chequear;

public class Equipo 
{
	private String nombre;
	//Cada arbitro está representado por su posicion en el array y su
	//valor representa la cantidad de veces que dirigió a este equipo.
	public int[] arbitros;
	int cantArbitros;
	
	public Equipo(String nombre, int arbitros)
	{
		if(arbitros < 1)
			throw new IllegalArgumentException("No puede haber menos de un arbitro.");
		this.nombre = nombre;
		this.arbitros = new int[arbitros];
		this.cantArbitros = arbitros;
	}
	
	// Devuelvo la cantidad de partidos que fue dirigido por el arbitro i.
	public int partidosDirigidoPor(int i)
	{
		Chequear.arbitro(i, this.cantArbitros);
		return this.arbitros[i];
	}
	
	//Agrego un partido a la posicion del array que representa al arbitro.
	public void agregarPartido(int i)
	{
		Chequear.arbitro(i, this.cantArbitros);
		this.arbitros[i]++;
	}
	
	public String getNombre() {
		return this.nombre+"";
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipo [nombre=");
		builder.append(nombre);
		builder.append(", arbitros=");
		builder.append(Arrays.toString(arbitros));
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	//Un equipo es igual a otro si sus nombres son iguales.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre.toLowerCase(), other.nombre.toLowerCase());
	}
	
}
