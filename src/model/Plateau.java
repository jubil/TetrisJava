package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import modLoader.RessourceLoader;

public class Plateau {

	private Case[][] casesSolides;
	private Piece pieceTombante;
	private Piece pieceHold;
	private Piece[] piecesAttente;

	private int width;
	private int height;

	public Plateau() {
		this(10, 20);
	}

	public Plateau(File predefini) {
		try {
			BufferedImage bi = ImageIO.read(predefini);
			width = bi.getWidth();
			height = bi.getHeight();

			casesSolides = new Case[width][height];
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					CouleurBlock c = CouleurBlock.intToCouleurBlock(bi.getRGB(i, j));
					casesSolides[i][j] = new Case(c);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Attention : Avoir un plateau avec une taille différente nécéssiterais la
	// création de nouveaux backgrounds
	private Plateau(int width, int height) {
		this.width = width;
		this.height = height;

		casesSolides = new Case[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				casesSolides[i][j] = new Case();
			}
		}
	}

	// TODO Ajouter l'affichage de la piece
	public BufferedImage getPlateauImage() {
		BufferedImage imgBackground = RessourceLoader.backgroundImage;
		BufferedImage imgPlateau = new BufferedImage(imgBackground.getWidth(),
				imgBackground.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = imgPlateau.createGraphics();

		g2d.drawImage(imgBackground, 0, 0, null);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (casesSolides[x][y].getCouleur() != null) {
					g2d.drawImage(
							casesSolides[x][y].getCouleur().getImageCase(
									RessourceLoader.getInstance()),
							x * 17 + 236, y * 17 + 93, null);
				}
			}
		}
		g2d.dispose();
		return imgPlateau;
	}

	// Fonction de debug
	public void saveScreen() {
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (casesSolides[i][j].getCouleur() != null) {
					bi.setRGB(i, j, casesSolides[i][j].getCouleur()
							.getSimpleColorValue());
				}
			}
		}
		try {
			ImageIO.write(bi, "png", new File("DebugPlateau.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
