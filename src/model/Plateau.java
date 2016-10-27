package model;

public class Plateau {

	private Case[][] cases;
	
	public Plateau(){
		this(10, 20);
	}
	
	public Plateau(int x, int y){
		cases = new Case[x][y];
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				cases[i][j] = new Case();
			}
		}
		
	}
	
}
