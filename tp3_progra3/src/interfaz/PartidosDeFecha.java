package interfaz;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class PartidosDeFecha {

	private JFrame frame;
	private JTable table;
	private String pathAImagenDeFondo = "tp3_progra3\\src\\imagenes\\cancha.jpg";


	/**
	 * Create the application.
	 * @param fecha 
	 * @param ventanaPrincipal 
	 * @param nombres 
	 * @param imagenDeFondo 
	 */
	public PartidosDeFecha(Fecha fecha, JFrame ventanaPrincipal, String[] nombres , int i ) {
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

		lblNewLabel.setBounds(137, 15, 178, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton botonCambiarArbitro = new JButton("Cambiar Arbitro");
		botonCambiarArbitro.setBounds(567, 527, 124, 23);
		frame.getContentPane().add(botonCambiarArbitro);
		
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
		

		String[] nombreDeColumnas = {"Local", "Visitante" , "Arbitro"};

		
		table = new JTable(data,nombreDeColumnas);
		table.setForeground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(new Color(0, 128, 0));
		table.setGridColor(Color.WHITE);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(50);
		
		scrollPane.setViewportView(table);
		
		ImageIcon imagenDeFondo = new ImageIcon(pathAImagenDeFondo);
		Utilidades.agregarImagenDeFondo(frame, imagenDeFondo);
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
			data[i][2] = p.getArbitro() + "";
		}
	}

	public void setVisible() {
		frame.setVisible(true);
	}
	
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	
}
