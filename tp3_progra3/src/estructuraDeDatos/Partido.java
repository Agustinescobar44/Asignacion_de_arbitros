package estructuraDeDatos;

import java.util.Objects;

import metodos.Chequear;


public class Partido
{
	/**
	 * 
	 */
	//Cada partido tiene dos equipos y un arbitro.
	private Equipo equipo1;
	private Equipo equipo2;
	private int arbitro;
	
	public Partido(Equipo equipo1, Equipo equipo2)
	{
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	
	//Asigno un arbitro al partido y le sumo el arbitro a cada equipo.
	
	//Este método no deberia ser publico, deberia ser package private. Está en publico con el unico objetivo
	//de testearlo desde el paquete negocio_test.
	public void setArbitro(int arbitro)
	{
		Chequear.arbitro(arbitro, this.equipo1.cantArbitros);
		this.arbitro = arbitro;
		this.equipo1.agregarPartido(arbitro);
		this.equipo2.agregarPartido(arbitro);
	}

	//A revisar por temas de encapsulamiento.
	public Equipo getEquipo1()
	{
		return this.equipo1;
	}
	
	public Equipo getEquipo2()
	{
		return this.equipo2;
	}
	
	public int getArbitro()
	{
		return this.arbitro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipo1, equipo2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipo1, other.equipo1) && Objects.equals(equipo2, other.equipo2);
	}

	
}