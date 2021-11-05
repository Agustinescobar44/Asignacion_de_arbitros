package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;


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
		//variables--------------
		final Torneo torneo=Principal.devolverTorneo();
		final String[] nombres = new String[torneo.getCantFechas()/2+1];
		
		inicializarNombresArbitros(nombres);
		
		final ArrayList<JComponent> asignacionDenombresUI = new ArrayList<>();
		String pathAImagenFondo = "tp3_progra3\\src\\imagenes\\cancha.jpg";
		int anchoFrame=800;
		int altoFrame = 600;
		
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
		frame.setResizable(false);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnSalir.setBounds(594, 497, 160, 42);
		frame.getContentPane().add(btnSalir);
		
		//Interfaz de las fechas-----------------------------
		agregarPanelDeFechas(torneo, nombres, anchoFrame, altoFrame);
		
		
		
		//estadisticas--------------------------------------------------------
		
		JButton btnMuestraEstadisticas = new JButton("Mostrar Estadisticas");
		btnMuestraEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Estadisticas estadisticas = new  Estadisticas(torneo,frame,nombres);
				estadisticas.setVisible();
			}
		});
		
		btnMuestraEstadisticas.setBounds(40, 445, 325, 57);
		frame.getContentPane().add(btnMuestraEstadisticas);
		
		
		
		//Asignacion de nombres a los arbitros---------------------------------------------
		
		//alturaPanelAsignacion =cantidad de arbitros * tamaño del label + tamaño de los botones
		int altoPanelAsignacion=torneo.getCantEquipos()/2*40 + 20; 
		int anchoPanelAsignacion=254; 
		int altoScrollAsignacion = 300;
		int anchoScrollAsignacion = 300;
		
		final JTextField[] listaTextFields = new JTextField[torneo.getCantFechas()/2+1];
		
		JButton botonMenuAsignarNombres = new JButton("Asignar nombre a los arbitros");
		botonMenuAsignarNombres.setBounds(475, 16, 280, 57);
		frame.getContentPane().add(botonMenuAsignarNombres);
		botonMenuAsignarNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!asignacionDenombresUI.get(0).isVisible())
					Utilidades.mostrarComponentes(asignacionDenombresUI);
				else {
					Utilidades.ocultarComponentes(asignacionDenombresUI);
				}
			}
		});
		
		//xDelScrollAsignacion = x del boton de nombres + ancho del boton de nombres/2  (para centrado)
		int xDelScrollAsignacion = (475+280/2) - anchoScrollAsignacion/2;
		JScrollPane scrollDeAsginacion = new JScrollPane();
		scrollDeAsginacion.setBounds(xDelScrollAsignacion, 85, anchoScrollAsignacion, altoScrollAsignacion);
		frame.getContentPane().add(scrollDeAsginacion);
		
		
		JPanel panelDeAsignacion = new JPanel();
		scrollDeAsginacion.setViewportView(panelDeAsignacion);
		panelDeAsignacion.setLayout(null);
		panelDeAsignacion.setPreferredSize(new Dimension(anchoPanelAsignacion,altoPanelAsignacion));
		
		asignacionDenombresUI.add(scrollDeAsginacion);
		asignacionDenombresUI.add(panelDeAsignacion);

		int posicionEnY = 5;
		for (int i = 0; i < torneo.getCantFechas()/2+1; i++) {
			agregarLabelYTextfield(panelDeAsignacion, listaTextFields, posicionEnY, i,asignacionDenombresUI);
			posicionEnY +=30;
		}
		
		JButton botonAsignarNombres = new JButton("Asignar Nombres en orden");
		botonAsignarNombres.setBounds(30, posicionEnY + 30, 200, 20);
		botonAsignarNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarNombresArbitros(nombres);
				int i = 0;
				for(JTextField text : listaTextFields)
				{
				String aux=text.getText();
					if(aux.length()!=0) {
						nombres[i] = aux;
					}
					i++;
				}
				Utilidades.ocultarComponentes(asignacionDenombresUI);
			}
		});
		panelDeAsignacion.add(botonAsignarNombres);
		
		JButton botonAsignarAleatorio= new JButton("Asignar Nombres aleatorio");
		botonAsignarAleatorio.setBounds(30, posicionEnY + 60, 200, 20);		
		botonAsignarAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarNombresArbitros(nombres);
				int cantArbitros=(torneo.getCantEquipos()/2)-1;
				boolean[] arbitros=new boolean[cantArbitros];
				Random random=new Random();
				for(JTextField text : listaTextFields)
				{
				String aux=text.getText();
				int indiceElegido=random.nextInt(cantArbitros);
				if(aux.length()!=0) {
					while(arbitros[indiceElegido]==true) {
						indiceElegido=random.nextInt(cantArbitros);
					}
					nombres[indiceElegido] = aux;
					arbitros[indiceElegido]=true;
					}
				}
				Utilidades.ocultarComponentes(asignacionDenombresUI);
			}
		});
		panelDeAsignacion.add(botonAsignarAleatorio);
		
		
		
		
		
		Utilidades.ocultarComponentes(asignacionDenombresUI);
		ImageIcon imagenDeFondo = new ImageIcon(pathAImagenFondo);
		Utilidades.agregarImagenDeFondo(frame, imagenDeFondo);
	}

	private void agregarLabelYTextfield(JPanel panelDeAsignacion, final JTextField[] listaTextFields, int posicionEnY,
			int i , ArrayList<JComponent> asignacionDenombresUI) {
		
		int altoDelComponente = 20;
		
		JLabel numeroDeArbitro = new JLabel("Nombre arbitro: " + i);
		numeroDeArbitro.setBounds(30,posicionEnY, 180,altoDelComponente);
		
		
		JTextField nombreDelArbitro = new JTextField();
		nombreDelArbitro.setBounds(150,posicionEnY, 100,altoDelComponente); 
		listaTextFields[i] = nombreDelArbitro;
		nombreDelArbitro.setColumns(10);
		
		panelDeAsignacion.add(numeroDeArbitro);
		panelDeAsignacion.add(nombreDelArbitro);
		
		asignacionDenombresUI.add(numeroDeArbitro);
		asignacionDenombresUI.add(nombreDelArbitro);
	}

	private void agregarPanelDeFechas(final Torneo torneo, final String[] nombres, int anchoFrame, int altoFrame ) {
		JLabel lblFechaDelCalendario = new JLabel("Fechas del calendario de partidos:");
		lblFechaDelCalendario.setForeground(Color.WHITE);
		lblFechaDelCalendario.setBounds(12, 12, 423, 15);
		frame.getContentPane().add(lblFechaDelCalendario);
		
		JPanel panelFechas = new JPanel();
		panelFechas.setBounds(12, 39, 325, 225);
				
		int anchoDelScroll = anchoFrame/2;
		int altoDelScroll = altoFrame/2;
		scrollPane.setBounds(12, 39, anchoDelScroll, altoDelScroll);
		scrollPane.setViewportView(panelFechas);
		frame.getContentPane().add(scrollPane);
		
		//agrego botones con fecha

		int alturaDelPanelFechas=200;
		int anchoDelPanelFechas = 360; 
		for(int i=0; i<torneo.getCantFechas(); i++) {
			JButton botonDeFecha = new JButton("Fecha " + (i+1));
			actionListenerABotonFecha(torneo, i, botonDeFecha,nombres);
			panelFechas.add(botonDeFecha);
		}
		
		panelFechas.setPreferredSize(new Dimension(anchoDelPanelFechas,alturaDelPanelFechas));
		int columnas = 3 ;
		int filas= 0 ;
		panelFechas.setLayout(new GridLayout(filas, columnas, 0, 0));
	}

	private void inicializarNombresArbitros(final String[] nombres) {
		for(int i=0; i<nombres.length ; i++) {
			nombres[i]=Integer.toString(i);
		}
	}

	private void actionListenerABotonFecha(final Torneo torneo, final int i, JButton btnNewButton , final String[] nombres ) {
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PartidosDeFecha partidosDeFecha= new PartidosDeFecha(torneo.getFecha(i),frame, nombres,i);
				frame.setVisible(false);
				partidosDeFecha.setVisible();
			}
		});
	}
	
	//utilidades
	
	

}
