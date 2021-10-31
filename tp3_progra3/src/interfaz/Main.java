package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;

import estructuraDeDatos.Torneo;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;


public class Main {

	private JFrame frame;
	final JScrollPane scrollPane;
	private JTextField textField;

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
		Torneo torneo=Principal.devolverTorneo();
		String[] nombres = new String[torneo.getCantFechas()/2+1];
		final ArrayList<JComponent> asignacionDenombres = new ArrayList<>();
		
		int anchoFrame=800;
		int altoFrame = 600;
		
		String pathAImagenFondo = "tp3_progra3\\src\\imagenes\\cancha.jpg";
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, anchoFrame, altoFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //centra la ventana
		
		
		//Interfaz de las fechas-----------------------------
		JLabel lblFechaDelCalendario = new JLabel("Fechas del calendario de partidos:");
		lblFechaDelCalendario.setForeground(Color.WHITE);
		lblFechaDelCalendario.setBounds(12, 12, 423, 15);
		frame.getContentPane().add(lblFechaDelCalendario);
		
		JPanel panelFechas = new JPanel();
		panelFechas.setBounds(12, 39, 325, 225);
		panelFechas.setLayout(null);
				
		int anchoDelScroll = anchoFrame/2;
		int altoDelScroll = altoFrame/2;
		scrollPane.setBounds(12, 39, anchoDelScroll, altoDelScroll);
		scrollPane.setViewportView(panelFechas);
		frame.getContentPane().add(scrollPane);
		
		//agrego botones con fecha
		int distanciaY=12;
		int alturaDelPanelFechas=200;
		for(int i=0; i<torneo.getCantFechas(); i++) {
			JButton btnNewButton = new JButton("Fecha " + (i+1));
			agregarActionListener(torneo, i, btnNewButton,nombres);
			
			if (i>6) {
				alturaDelPanelFechas+=90;
			}
			panelFechas.add(btnNewButton);
			btnNewButton.setBounds(anchoDelScroll/4-10, distanciaY, anchoDelScroll/2, 25);
			distanciaY+=40;
		}
		
		panelFechas.setPreferredSize(new Dimension(360,alturaDelPanelFechas));
		
		//Asignacion de arbitros------------------------
		
		JButton btnNewButton_1 = new JButton("Asignar nombre a los arbitros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!asignacionDenombres.get(0).isVisible())
					mostrarComponentes(asignacionDenombres);
				else {
					ocultarComponentes(asignacionDenombres);
				}
			}
		});
		btnNewButton_1.setBounds(442, 472, 293, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollDeAsginacion = new JScrollPane();
		scrollDeAsginacion.setBounds(464, 153, 254, 300);
		frame.getContentPane().add(scrollDeAsginacion);
		
		JPanel panelDeAsignacion = new JPanel();
		scrollDeAsginacion.setViewportView(panelDeAsignacion);
		panelDeAsignacion.setLayout(null);
		
		asignacionDenombres.add(scrollDeAsginacion);
		asignacionDenombres.add(panelDeAsignacion);
		
		JTextField[] listaTextFields = new JTextField[torneo.getCantFechas()/2+1];
		int posicionEnY = 5;
		int alturaPanelAsignacion=300;
		for (int i = 0; i < torneo.getCantFechas()/2+1; i++) {
			JLabel lblNewLabel = new JLabel("Nombre para aribtro numero" + i);
			lblNewLabel.setBounds(59, posicionEnY, 60, 14);
			panelDeAsignacion.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(108, posicionEnY, 86, 20);
			panelDeAsignacion.add(textField);
			listaTextFields[i] = textField;
			textField.setColumns(10);
			
			if(i>15) {
				alturaPanelAsignacion+=40;
			}
			posicionEnY += 30;
			
			asignacionDenombres.add(lblNewLabel);
			asignacionDenombres.add(textField);
		}
		
		JButton botonAsignarNombres = new JButton("Asignar Nombres");
		botonAsignarNombres.setBounds(108, posicionEnY + 30, 80, 20);
		panelDeAsignacion.add(botonAsignarNombres);
		
		botonAsignarNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				for(JTextField text : listaTextFields)
				{
					nombres[i] = text.getText();
					i++;
				}
				ocultarComponentes(asignacionDenombres);
			}
		});
		
		ocultarComponentes(asignacionDenombres);
		panelDeAsignacion.setPreferredSize(new Dimension(254,alturaPanelAsignacion));
		
		JLabel imagenDeFondo = new JLabel("");
		ImageIcon imagenDeCancha=escalarImagen(anchoFrame, altoFrame, new ImageIcon(pathAImagenFondo));
		
		
		imagenDeFondo.setIcon(imagenDeCancha);
		imagenDeFondo.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(imagenDeFondo);
	}

	private void agregarActionListener(final Torneo torneo, final int i, JButton btnNewButton , final String[] nombres) {
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PartidosDeFecha partidosDeFecha= new PartidosDeFecha(torneo.getFecha(i),frame, nombres,i);
				frame.setVisible(false);
				partidosDeFecha.setVisible();
			}
		});
	}
	
	private void mostrarComponentes(ArrayList<JComponent> componentes) {
			for (JComponent jComponent : componentes) {
				jComponent.setVisible(true);
			}
	}
	private void ocultarComponentes(ArrayList<JComponent> componentes) {
		for (JComponent jComponent : componentes) {
			jComponent.setVisible(false);
		}
	}
	private ImageIcon escalarImagen(int ancho , int alto, ImageIcon img) {
		//consigo el ancho y el alto del escalado
		
		//transgformo la imagenicon a image para escalar
		Image tempImage = img.getImage();
		
		//la escalo
		Image tempCambiada = tempImage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		
		//retorno la image como imageicon
		return (new ImageIcon(tempCambiada));
	}
}
