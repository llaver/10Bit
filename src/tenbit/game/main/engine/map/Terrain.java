package tenbit.game.main.engine.map;

import java.awt.Graphics;

public class Terrain {
	
	private int terrainType;
	private boolean isRandom = false;
	
	
	public Terrain() {
		terrainType = -1;
		checkType();
		setTerrain();
	}
	private void setTerrain() {
		if(!isRandom) {
			Double choice = Math.random() * 3;
			if(choice < 1.0) {
				
			} else if(choice >= 1.0 && choice < 2.0) {
				
			} else if(choice >= 2.0 && choice < 3.0) {
				
			}
		}
	}
	private int getTerrain() {
		return terrainType;
	}
	private void checkType() {
		if(terrainType < 0) 
		{
			isRandom = true;
		}
		else {
			isRandom = false;
		}
	}
	private void paintTerrain(Graphics g) {
		
	}
}
