package tenbit.game.main.engine.map;

import java.awt.Shape;

public class Layout {
	private Shape[] tiles = Tiles.tiles;
	private Shape[] mobiles;
	private Shape[] immobiles;
	private int mobile;
	private int immobile;
	
	public Layout() {
		mobile = 4;
		immobile = 4;
	}
	public Layout(int mobile, int immobile) {
		this.mobile = mobile;
		this.immobile = immobile;
	}
	public void genItems() {
		mobiles = new Shape[mobile];
		immobiles = new Shape[immobile];
		
		//Generate Mobiles
		for(int i = 0; i < mobile; i++) {
			mobiles[i] = tiles[(int) (Math.random() * 449)];	
		}		
		//Generate Immobiles
		for(int i = 0; i < immobile; i++) {
			immobiles[i] = tiles[(int) (Math.random() * 449)];	
		}

	}
	public Shape[] getMobile() {
		
		return mobiles;
	}
	public Shape[] getImmobile() {
		return immobiles;
	}
}
