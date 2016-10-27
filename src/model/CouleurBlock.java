package model;

import java.awt.image.BufferedImage;

import modLoader.RessourceLoader;

public enum CouleurBlock {
	
	ROUGE(0), ORANGE(1), JAUNE(2), VERT(3), CYAN(4), BLEU(5), VIOLET(6), GRIS(7), NOIR(8), OMBRE(9);
	
	private int indexTileset;
	
	private CouleurBlock(int indexTileset){
		this.indexTileset = indexTileset;
	}
	
	//Charge l'image correspondant à la couleur depuis le RessourceLoader
	public BufferedImage getImageCase(RessourceLoader rl){
		return rl.getImageCase(indexTileset);
	}
	
}
