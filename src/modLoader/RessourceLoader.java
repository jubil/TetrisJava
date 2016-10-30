package modLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class RessourceLoader {

	private static RessourceLoader instance;
	
	public static String MOD_FOLDER;
	
	public static BufferedImage blockTileset;
	public static BufferedImage[] blocksCouleurs;
	
	public static BufferedImage backgroundImage;
	
	public RessourceLoader(){
		System.out.println("RessourceLoader : START");
		
		//Initialisation des chemin
		MOD_FOLDER = new File("mod").getAbsolutePath();
		
		//Charger la tileset des blocks
		try {
			blockTileset = ImageIO.read(new File(MOD_FOLDER + "/image/BlockTileset.png"));
		} catch (IOException e) {
			try {
				blockTileset = ImageIO.read(RessourceLoader.class.getResourceAsStream("/image/BlockTileset.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//Créer les couleurs de blocks
		blocksCouleurs = new BufferedImage[10];
		for(int i = 0; i < blocksCouleurs.length; i++){
			blocksCouleurs[i] = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
			for(int x = 0; x < 16; x++){
				for(int y = 0; y < 16; y++){
					blocksCouleurs[i].setRGB(x, y, blockTileset.getRGB(x+(i*16), y));
				}
			}
		}

		//Charger le background
		try {
			backgroundImage = ImageIO.read(new File(MOD_FOLDER + "/image/Background.png"));
		} catch (IOException e) {
			try {
				backgroundImage = ImageIO.read(RessourceLoader.class.getResourceAsStream("/image/Background.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//TODO Charger les maps
		
		//Fin du RessourceLoader
		instance = this;
		System.out.println("RessourceLoader : OK");
		new BlockLoader();
		
	}

	public BufferedImage getImageCase(int indexTileset) {
		return blocksCouleurs[indexTileset];
	}

	public static RessourceLoader getInstance() {
		return instance;
	}
	
}
