package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.sql.rowset.BaseRowSet;
import javax.swing.JButton;
import estructuraDeDatos.Torneo;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		
		JLabel lblFechaDelCalendario = new JLabel("Fecha del calendario de partidos:");
		lblFechaDelCalendario.setBounds(12, 12, 423, 15);
		frame.getContentPane().add(lblFechaDelCalendario);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 39, 423, 225);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400,400));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(408, 12, 3, 3);
		panel.add(scrollPane);
		
		
		Torneo torneo=Principal.devolverTorneo();
		int distanciaY=12;
		for(int i=0; i<torneo.getCantFechas(); i++) {
			JButton btnNewButton = new JButton("Fecha " + i);
			btnNewButton.setBounds(39, distanciaY, 117, 25);
			distanciaY+=40;
			panel.add(btnNewButton);
		}
		
		
		
		
		
		
	}
}
