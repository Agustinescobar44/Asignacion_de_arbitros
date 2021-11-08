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

	static void todosConArbitroDiferente(Torneo torneo) {
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

	static void asignarArbitro(Torneo t) {
		assertEquals(0, t.getFecha(0).getPartido(0).getArbitro());
		assertEquals(1, t.getFecha(0).getPartido(1).getArbitro());
		assertEquals(0, t.getFecha(1).getPartido(0).getArbitro());
		assertEquals(1, t.getFecha(1).getPartido(1).getArbitro());
		assertEquals(0, t.getFecha(2).getPartido(0).getArbitro());
		assertEquals(1, t.getFecha(2).getPartido(1).getArbitro());
	}
	
	
}
