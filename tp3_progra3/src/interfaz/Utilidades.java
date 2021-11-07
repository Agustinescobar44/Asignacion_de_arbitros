package interfaz;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Utilidades {
	
	static void agregarImagenDeFondo(JFrame frame , ImageIcon imagen) {
		ImageIcon imagenDeFondo = escalarImagen(frame.getHeight(), frame.getWidth(), imagen);
		
		JLabel labelFondo = new JLabel("");
		
		labelFondo.setIcon(imagenDeFondo);
		labelFondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(labelFondo);
	}
	static void agregarImagenDeFondo(JFrame frame , String pathAImagen) {
		ImageIcon imagenDeFondo = escalarImagen(frame.getHeight(), frame.getWidth(), new ImageIcon(pathAImagen));
		
		JLabel labelFondo = new JLabel("");
		
		labelFondo.setIcon(imagenDeFondo);
		labelFondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(labelFondo);
	}
	
	static ImageIcon escalarImagen(int alto,int ancho, ImageIcon imagen) {
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

	static void setearFuente(String fuente , int tama�o) {
		UIManager.put("Button.font", new FontUIResource(new Font(fuente, Font.PLAIN, tama�o)));
		UIManager.put("Label.font", new FontUIResource(new Font(fuente, Font.PLAIN, tama�o)));
		UIManager.put("TextField.font", new FontUIResource(new Font(fuente, Font.PLAIN, tama�o)));
		UIManager.put("Table.font", new FontUIResource(new Font(fuente, Font.PLAIN, tama�o)));
		UIManager.put("TableHeader.font", new FontUIResource(new Font(fuente, Font.BOLD, tama�o)));
	}
}
