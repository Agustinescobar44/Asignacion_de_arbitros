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
		
		int anchoFrame=400;
		int alto = 400;
		
		frame.setSize(new Dimension(anchoFrame,alto));
		
		centrarVentana(anchoFrame, alto, frame);
		
		
		JLabel lblFechaDelCalendario = new JLabel("Fecha del calendario de partidos:");
		lblFechaDelCalendario.setBounds(12, 12, 423, 15);
		frame.getContentPane().add(lblFechaDelCalendario);
		
		JPanel panelFechas = new JPanel();
		panelFechas.setBounds(12, 39, 423, 225);
		frame.getContentPane().add(panelFechas);
		panelFechas.setLayout(null);
		panelFechas.setPreferredSize(new Dimension(380,200));
		
		final JPanel panelPartidos = new JPanel();
		panelFechas.setBounds(12, 39, 423, 225);
		frame.getContentPane().add(panelFechas);
		panelFechas.setLayout(null);
		panelFechas.setPreferredSize(new Dimension(380,200));
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 380, 300);
		scrollPane.setViewportView(panelFechas);
		frame.add(scrollPane);
		
		Torneo torneo=Principal.devolverTorneo();
		
		int distanciaY=12;
		for(int i=0; i<torneo.getCantFechas(); i++) {
			JButton btnNewButton = new JButton("Fecha " + i);
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					scrollPane.setViewportView(panelPartidos);
				}
			});
			btnNewButton.setBounds(39, distanciaY, 117, 25);
			distanciaY+=40;
			panelFechas.add(btnNewButton);
		}
	}
	
	public void centrarVentana(int ancho , int alto , JFrame frame) {
		Dimension tamanioventana = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((tamanioventana.width/2)-(ancho/2), (tamanioventana.height/2)-(alto/2), ancho, alto);
	}
	
}
