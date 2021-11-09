package interfaz;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import estructuraDeDatos.Fecha;
import estructuraDeDatos.Partido;
import estructuraDeDatos.Torneo;

import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class PartidosDeFecha {

	private JFrame frame;
	private JTable table;
	private String pathAImagenDeFondo = "tp3_progra3\\src\\imagenes\\cancha.jpg";
	private String fuentePrincipal= "Leelawadee UI";

	/**
	 * Create the application.
	 * @param fecha 
	 * @param ventanaPrincipal 
	 * @param nombres 
	 * @param imagenDeFondo 
	 */
	public PartidosDeFecha(final Fecha fecha, final JFrame ventanaPrincipal, final String[] nombres , int i , final Torneo t) {
		int anchoDelFrame = 800;
		int altoDelFrame = 600;
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		frame.setBounds(100, 100, anchoDelFrame, altoDelFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //centra la ventana
		frame.setResizable(false);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ventanaPrincipal.setVisible(true);
			}
		});
		botonVolver.setBounds(44, 15, 117, 46);
		frame.getContentPane().add(botonVolver);
		

		JLabel labelNumeroFecha = new JLabel("Partidos de Fecha: " + (i+1));
		
		labelNumeroFecha.setBounds(279, 15, 231, 42);
		labelNumeroFecha.setForeground(Color.WHITE);
		labelNumeroFecha.setFont(new Font(fuentePrincipal, Font.PLAIN, 20));
		frame.getContentPane().add(labelNumeroFecha);
		
		
		
		
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
		final ArrayList<String> partidos = new ArrayList<>();
		for (int j = 0; j < t.getFecha(i).getCantPartidos(); j++) {
			partidos.add("Partido: "+j);
		}
		scrollPane.setViewportView(table);

		
		final JSpinner spinnerPrimerPartido = new JSpinner();
		spinnerPrimerPartido.setModel(new SpinnerListModel(partidos));
		spinnerPrimerPartido.setBounds(121, 494, 123, 40);
		JFormattedTextField spinnerTextField= ((JSpinner.DefaultEditor) spinnerPrimerPartido.getEditor()).getTextField();
		spinnerTextField.setEditable(false);
		frame.getContentPane().add(spinnerPrimerPartido);
		
		final JSpinner spinnerSegundoPartido = new JSpinner();
		spinnerSegundoPartido.setBounds(262, 494, 123, 40);
		spinnerSegundoPartido.setModel(new SpinnerListModel(partidos));
		spinnerTextField= ((JSpinner.DefaultEditor) spinnerSegundoPartido.getEditor()).getTextField();
		spinnerTextField.setEditable(false);
		frame.getContentPane().add(spinnerSegundoPartido);
		
		
		JButton botonCambiarArbitro = new JButton("Cambiar Arbitro");
		botonCambiarArbitro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int spiner1 = partidos.indexOf(spinnerPrimerPartido.getValue());
				int spiner2 = partidos.indexOf(spinnerSegundoPartido.getValue());
				
				if(spiner1 != spiner2) {
					if (nombres.length<1) {
						int aux = fecha.getPartido(spiner1).getArbitro();
						table.setValueAt(""+fecha.getPartido(spiner2).getArbitro(), spiner1, 2);
						table.setValueAt(""+aux, spiner2, 2);
					}
					else {
						String aux = nombres[fecha.getPartido(spiner1).getArbitro()];
						table.setValueAt(nombres[fecha.getPartido(spiner2).getArbitro()], spiner1, 2);
						table.setValueAt(""+aux, spiner2, 2);
					}
					
					t.cambiarArbitro(fecha.getPartido(spiner1), fecha.getPartido(spiner2));
				}	
			}
		});
		botonCambiarArbitro.setBounds(410, 490, 212, 46);
		frame.getContentPane().add(botonCambiarArbitro);
		
		JLabel bordeDeCambiarArbitro = new JLabel("");
		bordeDeCambiarArbitro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), 
				"Cambiar arbitros entre partidos", 
				TitledBorder.CENTER, TitledBorder.TOP, 
				new Font(fuentePrincipal , Font.BOLD, 16), 
				new Color(255, 255, 255)));
		bordeDeCambiarArbitro.setBounds(104, 457, 535, 89);
		frame.getContentPane().add(bordeDeCambiarArbitro);
		Utilidades.agregarImagenDeFondo(frame, pathAImagenDeFondo);
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
