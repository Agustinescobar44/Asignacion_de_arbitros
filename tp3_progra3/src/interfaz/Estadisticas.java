package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import estructuraDeDatos.Torneo;

public class Estadisticas {

	private JFrame frame;

	/**
	 * Create the application.
	 * @param torneo 
	 */
	public Estadisticas(Torneo torneo) {
		initialize(torneo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Torneo torneo) {
		frame = new JFrame();
		int anchoFrame = 800;
		int altoFrame = 600;
		frame.setBounds(100, 100, anchoFrame, altoFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //centra la ventana
		
		
		
		
		
		
	}

	public void setVisible() {
		frame.setVisible(true);
	}

}
