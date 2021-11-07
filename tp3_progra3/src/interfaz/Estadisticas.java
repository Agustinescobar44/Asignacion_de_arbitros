package interfaz;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import estructuraDeDatos.Torneo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class Estadisticas {

	private JFrame frame;
	private JTable table;
	private String pathAImagenFondo ="tp3_progra3\\src\\imagenes\\cancha.jpg"; 
	private Font fuentePrincipal= new Font("Leelawadee UI", Font.PLAIN, 16);


	/**
	 * Create the application.
	 */
	public Estadisticas(Torneo torneo, final Frame ventanaPrincipal, String[] nombres) {
		frame = new JFrame();
		int anchoFrame=800;
		int altoFrame = 600;
		frame.setBounds(100, 100, anchoFrame, altoFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonVolver.setFont(fuentePrincipal);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				frame.dispose();
			}
		});
		botonVolver.setBounds(41, 11, 183, 35);
		frame.getContentPane().add(botonVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(fuentePrincipal);
		scrollPane.setBounds(44, 68, 663, 337);
		frame.getContentPane().add(scrollPane);
		
		String[][] data = new String[torneo.getCantEquipos()][3];
		String[] encabezado= {"Equipo" , "Arbitro mas recurrente" , "Arbitro menos recurrente"};
		
		if(nombres.length == 0)
			setData(torneo , data ) ;
		else {
			setData(torneo, data , nombres);
		}
		
		table = new JTable(data , encabezado);
		JTableHeader header = table.getTableHeader(); 
		
		header.setFont(fuentePrincipal.deriveFont(Font.BOLD));
		header.setOpaque(false);
		header.setBackground(new Color(0, 128, 0));
		
		table.setCellSelectionEnabled(false);
		table.setFont(fuentePrincipal);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		
		scrollPane.setViewportView(table);
	
		Utilidades.agregarImagenDeFondo(frame ,pathAImagenFondo);
	}


	private void setData(Torneo torneo, String[][] data, String[] nombres) {
		String[] listaDeEquipos = torneo.getListaDeEquipos();
		for (int i = 0; i < data.length; i++) {
			int[] listaDeArbitros = torneo.getArbitrosEquipo(listaDeEquipos[i]);
			data[i][0] = listaDeEquipos[i];
			data[i][1] = nombres[arbitroMasRecurente(listaDeArbitros)];
			data[i][2] = nombres[arbitroMenosRecurrente(listaDeArbitros)];
			
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
