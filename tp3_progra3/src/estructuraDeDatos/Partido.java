package estructuraDeDatos;

import java.util.Objects;

public class Partido
{
	private String equipo1;
	private String equipo2;
	private int arbitro;
	
	public Partido(String equipo1, String equipo2)
	{
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	
	//Publico solo por tests.
	public void setArbitro(int arbitro)
	{
		this.arbitro = arbitro;
	}

	//A revisar por temas de encapsulamiento.
	public String getEquipo1()
	{
		return this.equipo1;
	}
	
	public String getEquipo2()
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Partido |equipo1=");
		builder.append(equipo1);
		builder.append(", equipo2=");
		builder.append(equipo2);
		builder.append(", arbitro=");
		builder.append(arbitro);
		builder.append("|");
		return builder.toString();
	}
	
	
}