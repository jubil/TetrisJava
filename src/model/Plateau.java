package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plateau {

	private Case[][] cases;
	
	private int width;
	private int height;
	
	public Plateau(){
		this(10, 20);
	}
	
	public Plateau(int width, int height){
		this.width = width;
		this.height = height;
		
		cases = new Case[width][height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				cases[i][j] = new Case(true);
			}
		}
	}

	//Fonction de debug
	public void saveScreen(){
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				if(cases[i][j].getCouleur() != null){
					bi.setRGB(i, j, cases[i][j].getCouleur().getSimpleColorValue());
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
