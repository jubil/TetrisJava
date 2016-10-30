package model;

import java.util.Random;

import modLoader.BlockLoader;

public class Piece {

	private Block block;
	int sens = 0;//de 0 à 3
	int posX;
	int posY;
	
	public Piece(){
		this(BlockLoader.blocks.get(new Random().nextInt(BlockLoader.blocks.size())));
	}
	
	public Piece(Block block){
		this(block, new Random().nextInt(4));
	}
	
	public Piece(Block block, int sens){
		this.block = block;
		this.sens = sens;
	}
	
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
