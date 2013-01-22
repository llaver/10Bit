package tenbit.game.main.engine.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tenbit.game.main.constants.MapImages;

public class Terrain {
	
	private int terrainType;
	private boolean isRandom = false;
	
	private BufferedImage terrainChoice;
	private BufferedImage rock = MapImages.rock;
	private BufferedImage grass = MapImages.grass;
	private BufferedImage snow = MapImages.snow;
	private BufferedImage dirt = MapImages.dirt;
	
	
	public Terrain() {
		terrainType = -1;
		checkType();
	}
	private void setTerrain() {
		if(!isRandom) {
			Double choice = Math.random() * 3;
			if(choice < 1.0) {
				terrainChoice = grass;
			} else if(choice >= 1.0 && choice < 2.0) {
				terrainChoice = snow;
			} else if(choice >= 2.0 && choice < 3.0) {
				terrainChoice = dirt;
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
