package model;

import java.awt.image.BufferedImage;

import modLoader.RessourceLoader;

public enum CouleurBlock {

	ROUGE(0, 0xFFFF0000), ORANGE(1, 0xFFFFA500), JAUNE(2, 0xFFFFFF00), VERT(3, 0xFF00FF00), CYAN(4, 0xFF00FFFF),
	BLEU(5, 0xFF0000FF), VIOLET(6, 0xFF990099), GRIS(7, 0xFF808080), NOIR(8, 0xFF000000), OMBRE(9, 0x00000000);

	private int indexTileset;
	private int simpleColorValue;

	private CouleurBlock(int indexTileset, int simpleColorValue) {
		this.indexTileset = indexTileset;
		this.simpleColorValue = simpleColorValue;
	}

	public int getSimpleColorValue() {
		return simpleColorValue;
	}

	// Charge l'image correspondant à la couleur depuis le RessourceLoader
	public BufferedImage getImageCase(RessourceLoader rl) {
		return rl.getImageCase(indexTileset);
	}

}
