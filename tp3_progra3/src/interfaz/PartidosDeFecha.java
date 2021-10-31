package interfaz;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartidosDeFecha {

	private JFrame frame;
	private JTable table;


	/**
	 * Create the application.
	 * @param fecha 
	 * @param ventanaPrincipal 
	 * @param nombres 
	 */
	public PartidosDeFecha(Fecha fecha, JFrame ventanaPrincipal, String[] nombres , int i ) {
		initialize(fecha , ventanaPrincipal , nombres , i);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param fecha 
	 * @param ventanaPrincipal 
	 * @param nombres 
	 */
	private void initialize(Fecha fecha, final JFrame ventanaPrincipal, String[] nombres , int i) {
		int anchoDelFrame = 800;
		int altoDelFrame = 600;
		frame = new JFrame();
		frame.setBounds(100, 100, anchoDelFrame, altoDelFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //centra la ventana
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ventanaPrincipal.setVisible(true);
			}
		});
		botonVolver.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(botonVolver);
		
		JLabel lblNewLabel = new JLabel("Partidos de Fecha: " + (i+1));
		lblNewLabel.setBounds(137, 15, 118, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cambiar Arbitro");
		btnNewButton_1.setBounds(567, 527, 124, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 68, 663, 337);
		frame.getContentPane().add(scrollPane);
		
		String[][] data = new String[fecha.getCantPartidos()][3];
		
		if(nombres[0] == null) {
			asignarData(fecha, data);
		}
		else {
			asignarData(fecha, data , nombres);
		}
		
		String[] nombreDeColumnas = {"Equipo 1", "Equipo 2" , "Arbitro numero"};
		
		table = new JTable(data,nombreDeColumnas);
		scrollPane.setViewportView(table);
		
	}
	
	private void asignarData(Fecha fecha, String[][] data, String[] nombres) {
		for (int i = 0; i < data.length; i++) {
			Partido p =  fecha.getPartido(i);
			data[i][0] = p.getEquipo1();
			data[i][1] = p.getEquipo2();
			data[i][2] = nombres[p.getArbitro()];
		}
	}

	private void asignarData(Fecha fecha, String[][] data) {
		for (int i = 0; i < data.length; i++) {
			Partido p =  fecha.getPartido(i);
			data[i][0] = p.getEquipo1();
			data[i][1] = p.getEquipo2();
			data[i][2] = p.getArbitro()+"";
		}
	}

	public void setVisible() {
		frame.setVisible(true);
	}
}
