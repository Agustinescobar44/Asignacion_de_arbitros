package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import estructuraDeDatos.Torneo;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Main {

	private JFrame frame;
	final JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		this.scrollPane = new JScrollPane();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //centra la ventana
		
		int anchoFrame=400;
		int alto = 400;
		
		frame.setSize(new Dimension(anchoFrame,alto));
		
		
		
		JLabel lblFechaDelCalendario = new JLabel("Fechas del calendario de partidos:");
		lblFechaDelCalendario.setBounds(12, 12, 423, 15);
		frame.getContentPane().add(lblFechaDelCalendario);
		
		JPanel panelFechas = new JPanel();
		panelFechas.setBounds(12, 39, 325, 225);
		panelFechas.setLayout(null);
		
		final JPanel panelPartidos = new JPanel();
		panelPartidos.setBounds(12, 39, 325, 225);
		panelPartidos.setLayout(null);
		panelPartidos.setPreferredSize(new Dimension(370,200));
		
		Torneo torneo=Principal.devolverTorneo();
		
		//agrego botones con fecha
		int distanciaY=12;
		int altoDelPanelFechas=200;
		for(int i=0; i<torneo.getCantFechas(); i++) {
			JButton btnNewButton = new JButton("Fecha " + i);
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cambiarVista(panelPartidos);
				}
			});
			
			if (i>6) {
				altoDelPanelFechas+=90;
			}
			panelFechas.add(btnNewButton);
			btnNewButton.setBounds(39, distanciaY, 117, 25);
			distanciaY+=40;
		}
		
		panelFechas.setPreferredSize(new Dimension(360,altoDelPanelFechas));
		
		scrollPane.setBounds(12, 39, 380, 300);
		scrollPane.setViewportView(panelFechas);
		
		frame.getContentPane().add(scrollPane);
	}
	
	private void cambiarVista(JPanel nuevo) {
		scrollPane.setViewportView(nuevo);
	}
	
}
