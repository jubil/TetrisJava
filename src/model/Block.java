package model;

import java.awt.image.BufferedImage;

public class Block {

	private String nom;
	private CouleurBlock couleur;
	
	private int taille;
	boolean[][][] rotations; //[NumRotation][CaseX][CaseY]

	public Block(String nom, BufferedImage bi, CouleurBlock couleur) {
		System.out.println("Ajout du block : " + nom);
		
		this.nom = nom;
		this.couleur = couleur;
		
		//Initialiser la forme au block
		taille = bi.getHeight();
		rotations = new boolean[4][taille][taille];
		for(int x = 0; x < taille; x++){
			for(int y = 0; y < taille; y++){
				rotations[0][x][y] = bi.getRGB(x, y) == 0xFF000000;
				rotations[1][x][y] = bi.getRGB(taille + x, y) == 0xFF000000;
				rotations[2][x][y] = bi.getRGB(taille * 2 + x, y) == 0xFF000000;
				rotations[3][x][y] = bi.getRGB(taille * 3 + x, y) == 0xFF000000;
			}
		}
		
	}

	public String getNom() {
		return nom;
	}

	public CouleurBlock getCouleur() {
		return couleur;
	}

	public int getTaille() {
		return taille;
	}
	
	public boolean[][] getForme(int sens){
		//FIX : Si le sens est invalide
		if(sens < 0 || sens > 3){
			return null;
		}
		
		boolean[][] ret = new boolean[taille][taille];
		for(int x = 0; x < taille; x++){
			for(int y = 0; y < taille; y++){
				ret[x][y] = rotations[sens][x][y];
			}
		}
		
		return ret;
	}
	

}
