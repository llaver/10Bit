package tenbit.game.main.engine.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import tenbit.game.main.RunClass;
import tenbit.game.main.constants.MenuImages;

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
		//Terrain terrain = new Terrain();
		//layout = new Layout();
		//layout = new Layout(terrain);
		
	}
	public void setGrid(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		for(int i = 0; i <= grid[0].length / 2; i++) {
			g2d.drawLine((RunClass.jWidth/ grid[0].length) * i * 2, 0, (RunClass.jWidth/ grid[0].length) * i * 2, RunClass.jHeight);
		}
		for (int j = 0; j <= grid.length / 2; j++) {
			g2d.drawLine(0, (RunClass.jHeight/ grid.length) * j * 4, RunClass.jWidth, (RunClass.jHeight/ grid.length) * j * 4);
		}
	}
	
	public void moveGrid(Graphics2D g2d) {
		
	}
	
	public void paint(Graphics g) {
		Rectangle r = new Rectangle(0, 0, RunClass.jWidth / 4 * 3, RunClass.jHeight / 4 * 3);
		Area a = new Area(r);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D field = (Graphics2D) g2.create(0, 0, RunClass.jWidth / 4 * 3, RunClass.jHeight / 4 * 3);
		g2.draw(r);
		//field.scale(2, 2);
		setGrid(field);
		//moveGrid(g2);
	}
	

}