package model;

import java.util.Random;

public class Case {

	private CouleurBlock couleur;

	public Case(){
		this(false);
	}
	
	public Case(boolean randomColor){
		if(randomColor){
			couleur = CouleurBlock.values()[new Random().nextInt(CouleurBlock.values().length)];
		}
	}
	
	public CouleurBlock getCouleur() {
		return couleur;
	}

	public void setCouleur(CouleurBlock couleur) {
		this.couleur = couleur;
	}

}
