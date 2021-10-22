package estructuraDeDatos;

import metodos.Chequear;

public class Torneo 
{

	Equipo[] equipos;
	Fecha[] fixture;
	int cantEquipos;
	
	public Torneo(Equipo[] equipo)
	{
		this.equipos = equipo;
		Chequear.equipos(equipos);
		
		this.cantEquipos = this.equipos.length;
		this.fixture = new Fecha[cantEquipos - 1];
		this.generarFixture();
	}
	
	//Utilizo el algoritmo mostrado en: https://es.wikipedia.org/wiki/Sistema_de_todos_contra_todos
	private void generarFixture()
	{
		int i = 0;
		while (i < this.cantEquipos-1)
		{
			fixture[i] = new Fecha(equipos);
			
			this.modificarArreglo();
			i++;
		}
	}
	
	//Metodo auxiliar de generarFixture. Explicado detalladamente en el link a wikipedia.
	private void modificarArreglo()
	{
		Equipo auxiliar = equipos[this.cantEquipos-1];
		for (int i = this.cantEquipos-2; i >= 1; i--)
		{
			equipos[i+1] = equipos[i];
		}
		equipos[1] = auxiliar;
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
}
