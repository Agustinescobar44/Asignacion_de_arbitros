package interfaz;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Utilidades {

	static void agregarImagenDeFondo(JFrame frame , ImageIcon imagen) {
		ImageIcon imagenDeFondo = escalarImagen(frame.getHeight(), frame.getWidth(), imagen);
		
		JLabel labelFondo = new JLabel("");
		
		labelFondo.setIcon(imagenDeFondo);
		labelFondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(labelFondo);
	}
	
	private static ImageIcon escalarImagen(int alto,int ancho, ImageIcon imagen) {
		//transgformo la imagenicon a image para escalar
		Image tempImage = imagen.getImage();
				
		//la escalo
		Image tempCambiada = tempImage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
				
		//retorno la image como imageicon
		return (new ImageIcon(tempCambiada));
	}
	static void mostrarComponentes(ArrayList<JComponent> componentes) {
		for (JComponent jComponent : componentes) {
			jComponent.setVisible(true);
		}
	}
	static void ocultarComponentes(ArrayList<JComponent> componentes) {
		for (JComponent jComponent : componentes) {
			jComponent.setVisible(false);
		}
	}
}
