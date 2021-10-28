package test;

import static org.junit.Assert.assertEquals;

import estructuraDeDatos.Torneo;

public class Assert {

	static void cuatroEquipos(Torneo torneo){
		assertEquals(torneo.getFecha(0).getPartido(0).getArbitro(), 0);
		assertEquals(torneo.getFecha(0).getPartido(1).getArbitro(), 1);
		assertEquals(torneo.getFecha(1).getPartido(0).getArbitro(), 1);
		assertEquals(torneo.getFecha(1).getPartido(1).getArbitro(), 0);
		assertEquals(torneo.getFecha(2).getPartido(0).getArbitro(), 0);
		assertEquals(torneo.getFecha(2).getPartido(1).getArbitro(), 1);
	}
	static void seisEquipos(Torneo torneo){
		assertEquals(torneo.getFecha(0).getPartido(0).getArbitro(), 0);
		assertEquals(torneo.getFecha(0).getPartido(1).getArbitro(), 1);
		assertEquals(torneo.getFecha(0).getPartido(2).getArbitro(), 2);
		assertEquals(torneo.getFecha(1).getPartido(0).getArbitro(), 1);
		assertEquals(torneo.getFecha(1).getPartido(1).getArbitro(), 0);
		assertEquals(torneo.getFecha(1).getPartido(2).getArbitro(), 2);
		assertEquals(torneo.getFecha(2).getPartido(0).getArbitro(), 2);
		assertEquals(torneo.getFecha(2).getPartido(1).getArbitro(), 0);
		assertEquals(torneo.getFecha(2).getPartido(2).getArbitro(), 1);
		assertEquals(torneo.getFecha(3).getPartido(0).getArbitro(), 0);
		assertEquals(torneo.getFecha(3).getPartido(1).getArbitro(), 2);
		assertEquals(torneo.getFecha(3).getPartido(2).getArbitro(), 1);
		assertEquals(torneo.getFecha(4).getPartido(0).getArbitro(), 1);
		assertEquals(torneo.getFecha(4).getPartido(1).getArbitro(), 2);
		assertEquals(torneo.getFecha(4).getPartido(2).getArbitro(), 0);
	}
	
}
