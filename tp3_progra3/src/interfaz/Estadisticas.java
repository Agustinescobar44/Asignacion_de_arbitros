package interfaz;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import estructuraDeDatos.Torneo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class Estadisticas {

	private JFrame frame;
	private JTable table;
	private String pathAImagenFondo ="tp3_progra3\\src\\imagenes\\cancha.jpg"; 
	private String fuentePrincipal= "Leelawadee UI";
	private JTable tablaArbitros;


	/**
	 * Create the application.
	 */
	public Estadisticas(Torneo torneo, final Frame ventanaPrincipal, String[] nombres) {
		try {
			Utilidades.setearFuente(fuentePrincipal, 16);
		} catch (Exception e) {
			System.out.println(e);
		}
		

		frame = new JFrame();
		int anchoFrame=800;
		int altoFrame = 600;
		int altoScrollRecurrencia = 200;
		int anchoScrollRecurrencia = 750;
		
		frame.setBounds(100, 100, anchoFrame, altoFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				frame.dispose();
			}
		});
		botonVolver.setBounds(41, 11, 183, 35);
		frame.getContentPane().add(botonVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 68, anchoScrollRecurrencia, altoScrollRecurrencia);
		frame.getContentPane().add(scrollPane);
		
		String[][] data = new String[torneo.getCantEquipos()][5];
		String[] encabezado= {"Equipo" , "Arbitro + recurrente" ,"Veces", "Arbitro - recurrente" , "Veces"};
		
		if(nombres.length == 0)
			setData(torneo , data ) ;
		else {
			setData(torneo, data , nombres);
		}
		
		table = new JTable(data , encabezado);
		configurarJTable(table);
		
		scrollPane.setViewportView(table);
		
		JScrollPane scrollTablaArbitros = new JScrollPane();
		scrollTablaArbitros.setBounds(20, 354, anchoScrollRecurrencia, 185);
		frame.getContentPane().add(scrollTablaArbitros);
		
		String[][] dataArbitros = new String[torneo.getCantArbitros()][2];
		for(int i=0; i<torneo.getCantArbitros() ; i++) {
			dataArbitros[i][0]=nombres[i];
			dataArbitros[i][1]=""+cantEquiposPorArbitro(i,torneo);
		}
		
		String[] encabezadoArbitros= {"Arbitro" , "Cantidad de Equipos distintos dirigidos"};
		
		tablaArbitros = new JTable(dataArbitros, encabezadoArbitros);
		configurarJTable(tablaArbitros);
		scrollTablaArbitros.setViewportView(tablaArbitros);
	
		Utilidades.agregarImagenDeFondo(frame ,pathAImagenFondo);
	}


	private int cantEquiposPorArbitro(int arbitro, Torneo torneo) {
		Map<Integer, Set<String>> datos=torneo.getEquiposPorArbitro();
		int ret=0;
		for(@SuppressWarnings("unused") String Equipo:datos.get(arbitro)) {
			ret++;
		}
		return ret;
	}


	private void configurarJTable(JTable table) {
		JTableHeader header = table.getTableHeader(); 
		
		header.setOpaque(false);
		header.setBackground(new Color(0, 128, 0));
		header.setFont(new Font(fuentePrincipal, Font.BOLD, 12));
		
		table.setCellSelectionEnabled(false);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
	}


	private void setData(Torneo torneo, String[][] data, String[] nombres) {
		String[] listaDeEquipos = torneo.getListaDeEquipos();
		for (int i = 0; i < data.length; i++) {
			int[] listaDeArbitros = torneo.getArbitrosEquipo(listaDeEquipos[i]);
			data[i][0] = listaDeEquipos[i];
			data[i][1] = nombres[arbitroMasRecurente(listaDeArbitros)];
			data[i][2] = ""+torneo.getArbitrosEquipo(listaDeEquipos[i])[arbitroMasRecurente(listaDeArbitros)];
			data[i][3] = nombres[arbitroMenosRecurrente(listaDeArbitros)];
			data[i][4] = ""+torneo.getArbitrosEquipo(listaDeEquipos[i])[arbitroMenosRecurrente(listaDeArbitros)];
			
		}
		
	}

	private void setData(Torneo torneo, String[][] data) {
		String[] listaDeEquipos = torneo.getListaDeEquipos();
		for (int i = 0; i < data.length; i++) {
			int[] listaDeArbitros = torneo.getArbitrosEquipo(listaDeEquipos[i]);
			data[i][0] = listaDeEquipos[i];
			data[i][1] = arbitroMasRecurente(listaDeArbitros)+"";
			data[i][2] = arbitroMenosRecurrente(listaDeArbitros)+"";
			
		}
		
	}

	private int arbitroMenosRecurrente(int[] listaDeArbitros) {
		int ret = -1;
		for (int i = 0; i < listaDeArbitros.length-1; i++) {
			if(ret == -1)
				ret = i;
			if(listaDeArbitros[i]>listaDeArbitros[i+1])
				ret = i+1;
		}
		return ret;
	}

	private int arbitroMasRecurente(int[] listaDeArbitros) {
		int ret = -1;
		for (int i = 0; i < listaDeArbitros.length-1; i++) {
			if(ret == -1)
				ret = i;
			if(listaDeArbitros[i]<listaDeArbitros[i+1])
				ret = i+1;
		}
		return ret;
	}
	

	public void setVisible() {
		frame.setVisible(true);
	}
}
