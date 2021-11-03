package test;

import static org.junit.Assert.*;

import estructuraDeDatos.Torneo;

public class Assert {

	static void todosConArbitro(Torneo torneo){
		for(int i = 0 ; i<torneo.getCantFechas() ; i++) {
			for(int j = 0 ; j<torneo.getFecha(i).getCantPartidos() ; j++) {
				assertNotNull(torneo.getFecha(i).getPartido(j).getArbitro());
			}
		}
	}

	public static void todosConArbitroDiferente(Torneo torneo) {
		int cantArbitros = torneo.getCantEquipos()/2;
		int[] arbitrosMarcados = new int[cantArbitros];
		
		for(int i = 0 ; i<torneo.getCantFechas() ; i++) {
			arbitrosMarcados = new int[cantArbitros];
			for(int j = 0 ; j<torneo.getFecha(i).getCantPartidos() ; j++) {
				int arbitroDelPartido= torneo.getFecha(i).getPartido(j).getArbitro();
					arbitrosMarcados[arbitroDelPartido]+=1 ;
					
			}
			for (int j = 0; j < arbitrosMarcados.length; j++) {
				assertEquals(1, arbitrosMarcados[j]);
			}
		}
		
	}
	
	
}
