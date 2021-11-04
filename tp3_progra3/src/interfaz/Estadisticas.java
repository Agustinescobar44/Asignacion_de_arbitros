package interfaz;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import estructuraDeDatos.Torneo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Estadisticas {

	private JFrame frame;
	private JTable table;



	/**
	 * Create the application.
	 */
	public Estadisticas(Torneo torneo, Frame ventanaPrincipal, String[] nombres , ImageIcon imagenDefondo) {
		frame = new JFrame();
		int anchoFrame=800;
		int altoFrame = 600;
		frame.setBounds(100, 100, anchoFrame, altoFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				frame.setVisible(false);
			}
		});
		botonVolver.setBounds(41, 11, 183, 35);
		frame.getContentPane().add(botonVolver);
		
		JScrollPane scrollPane = new JScrollPane();
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
		
		scrollPane.setViewportView(table);
	
		JLabel labelFondo = new JLabel("");
				
		labelFondo.setIcon(imagenDefondo);
		labelFondo.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(labelFondo);
		
		frame.setVisible(false);
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
