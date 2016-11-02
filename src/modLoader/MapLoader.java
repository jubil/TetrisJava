package modLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapLoader {
	
	private static final String MAP_FOLDER = "/map/";
	
	private static MapLoader instance;
	public static BufferedImage[] maps;
	
	public MapLoader(){
		System.out.println("MapLoader : START");
		File dossierMap = new File(getClass().getClassLoader().getResource("map").getFile());
		
		maps = new BufferedImage[dossierMap.listFiles().length];
		
		for(int i = 0; i < dossierMap.listFiles().length; i++){
			System.out.println("load "+dossierMap.listFiles()[i].getName());
			try {
				maps[i] = ImageIO.read(RessourceLoader.class.getResourceAsStream(MAP_FOLDER + dossierMap.listFiles()[i].getName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		instance = this;
		System.out.println("MapLoader : OK");
	}

	public static MapLoader getInstance() {
		return instance;
	}
	
}
