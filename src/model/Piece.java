package model;

public class Piece {

	private Block block;
	int sens = 0;//de 0 à 3
	int posX;
	int posY;
	
	public void sensSuivant(){
		sens++;
		if(sens>3){
			sens = 0;
		}
	}
	
	public void sensPrecedent(){
		sens--;
		if(sens<0){
			sens=3;
		}
	}
	
}
