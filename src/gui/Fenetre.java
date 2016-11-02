package gui;

import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modLoader.RessourceLoader;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	public final static int SCREEN_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
	public final static int SCREEN_HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	
	private JPanel contentPane;

	public Fenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		contentPane = new JPanel();
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(resize(RessourceLoader.backgroundImage, SCREEN_WIDTH, SCREEN_HEIGHT)));
		label.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		contentPane.add(label);
		
		setUndecorated(true);
		setVisible(true);
		//requestFocus();
	}
	
	//TODO A OPTIMISER
	private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
		int tmpW = img.getWidth() * newH / img.getHeight();	
		
	    Image tmp = img.getScaledInstance(tmpW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, (newW - tmpW) / 2, 0, null);
	    g2d.dispose();

	    return dimg;
	} 

	public void draw(){
		//TODO G�n�re l'image de l'�tat du jeu
	}
	
	public void drawOnScreen(){
		//TODO Affiche l'image du jeu � la bonne taille sur la fenetre.
	}
}
