package modLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class RessourceLoader {

	public static final String MOD_FOLDER = new File("mod").getAbsolutePath();
	
	public static BufferedImage blockTileset;
	public static BufferedImage[] blocksCouleurs;
	
	public RessourceLoader(){
		//Charger la tileset des blocks
		try {
			blockTileset = ImageIO.read(new File(MOD_FOLDER + "/image/BlockTileset.png"));
		} catch (IOException e) {
			e.printStackTrace();
			//TODO charger l'image de tileset depuis le jar (!= mod)
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
		
	}

	public BufferedImage getImageCase(int indexTileset) {
		return blocksCouleurs[indexTileset];
	}
	
}
