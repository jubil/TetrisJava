import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import modLoader.RessourceLoader;


public class Test {

	public static RessourceLoader rl = new RessourceLoader();
	
	public static void main(String[] args) {
		System.out.println("Classe de test");
		
		try {
			ImageIO.write(rl.backgroundImage, "png", new File("screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
