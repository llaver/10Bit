package tenbit.game.main.engine.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import tenbit.game.main.RunClass;

public class Map {
	
	private int mapLength;
	private int mapWidth;
	private int[][] grid;
	private boolean isRandom;
	private Layout layout;

	public Map() {		
		mapLength = 80;
		mapWidth = 60;
		createMap();
	}
	public Map(int l, int w) {
		mapLength = l;
		mapWidth = w;
		createMap();
	}
	public Map(boolean r) {
		isRandom = r;
		createMap();
	}
	private void createMap() {
		grid = new int[mapLength][mapWidth];
		Terrain terrain = new Terrain();
		layout = new Layout();
		//layout = new Layout(terrain);
		
	}
	public void setGrid(Graphics2D g2d) {
		for(int i = 0; i <= grid.length; i++) {
			g2d.drawLine(0, RunClass.jWidth, (RunClass.jHeight/ grid.length), (RunClass.jHeight/ grid.length));
		}
		for (int j = 0; j <= grid[0].length; j++) {
			
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.BLACK);
		setGrid(g2);
	}
	

}
