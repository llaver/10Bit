package tenbit.game.main.engine.map;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import tenbit.game.main.RunClass;

public class Tiles {
	
	private boolean tilesSet;
	private int[][] grid;
	public static Shape[] tiles;

	public Tiles() {
		tilesSet = false;
		tiles = new Shape[4800];
	}
	public void setGrid(int[][] g) {
		grid = g;
	}
	public void setTiles(Graphics2D g2d) {
		int num = 0;
		if(grid != null && !tilesSet) {
			for (int i = 0; i < grid.length / 2; i++) {
				int y, height;
				y = ((RunClass.jHeight/ grid.length) * i * 4);
				height = ((RunClass.jHeight/ grid.length) * (i + 1) * 4) - ((RunClass.jHeight/ grid.length) * i * 4);
				for(int j = 0; j < grid[0].length / 2; j++) {
					int x, width;
					x = ((RunClass.jWidth/ grid[0].length) * j * 2);
					width = ((RunClass.jWidth/ grid[0].length) * (j + 1) * 2) - ((RunClass.jWidth/ grid[0].length) * j * 2);
					tiles[num] = new Rectangle(x, y, width, height);
					num++;
				}
			}		
		}
		tilesSet = true;
	}
	public Shape[] getTiles() {
		return tiles;
	}
}
