package tenbit.game.main.engine.map;

public class Terrain {
	
	private int terrainType;
	private boolean isRandom = false;
	
	public Terrain() {
		terrainType = -1;
		
	}
	public void setTerrain(int choice) {
		
	}
	public void setTerrain(boolean random) {
		
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
}
