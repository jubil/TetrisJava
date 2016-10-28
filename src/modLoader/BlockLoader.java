package modLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.Block;
import model.CouleurBlock;

public class BlockLoader {

	private int nbBlocks;
	
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	
	public BlockLoader(){
		this(true);
	}
	
	public BlockLoader(boolean blocksDeBase) {
		System.out.println("BlockLoader : START");
		
		//Dossier des block dans le mod
		File dossier = new File(RessourceLoader.MOD_FOLDER + "/block/");
		
		//Chargement des blocks de base
		if(blocksDeBase || !dossier.isDirectory()){
			BufferedImage bi;
			try {
				bi = ImageIO.read(RessourceLoader.class.getResourceAsStream("/block/BlockI.png"));
				blocks.add(new Block("I", bi, CouleurBlock.CYAN));
				bi = ImageIO.read(RessourceLoader.class.getResourceAsStream("/block/BlockJ.png"));
				blocks.add(new Block("J", bi, CouleurBlock.BLEU));
				bi = ImageIO.read(RessourceLoader.class.getResourceAsStream("/block/BlockL.png"));
				blocks.add(new Block("L", bi, CouleurBlock.ORANGE));
				bi = ImageIO.read(RessourceLoader.class.getResourceAsStream("/block/BlockO.png"));
				blocks.add(new Block("O", bi, CouleurBlock.JAUNE));
				bi = ImageIO.read(RessourceLoader.class.getResourceAsStream("/block/BlockS.png"));
				blocks.add(new Block("S", bi, CouleurBlock.VERT));
				bi = ImageIO.read(RessourceLoader.class.getResourceAsStream("/block/BlockT.png"));
				blocks.add(new Block("T", bi, CouleurBlock.VIOLET));
				bi = ImageIO.read(RessourceLoader.class.getResourceAsStream("/block/BlockZ.png"));
				blocks.add(new Block("Z", bi, CouleurBlock.ROUGE));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//Pour chaque image de block dans le mod
		if(dossier.isDirectory()){
			for(File f : dossier.listFiles()){
				try {
					blocks.add(new Block(f.getName().substring(0, f.getName().length()-4), ImageIO.read(f), CouleurBlock.NOIR));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("BlockLoader : OK");
	}
	
}
