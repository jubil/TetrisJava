package model;

import java.awt.image.BufferedImage;

public class Block {

	private String nom;
	private CouleurBlock couleur;

	// TODO ajouter une forme au block

	public Block(String nom, BufferedImage bi, CouleurBlock couleur) {
		this.nom = nom;
		this.couleur = couleur;

		// TODO Initialiser la forme au block
	}

	public String getNom() {
		return nom;
	}

	public CouleurBlock getCouleur() {
		return couleur;
	}

}
