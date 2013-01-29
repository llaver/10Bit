package tenbit.game.main.engine.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.sql.Timestamp;
import java.util.Date;

import tenbit.game.main.Observer;
import tenbit.game.main.RunClass;
import tenbit.game.main.constants.Listeners;
import tenbit.game.main.constants.MenuImages;

public class Map implements Observer {
	
	Tiles t = new Tiles();
	Cursor c = new Cursor();
	Terrain terrain;
	
	private double zoom = 1;
	private int mapLength;
	private int mapWidth;
	private int[][] grid;
	private Shape[] tiles;
	private Layout layout;
	private boolean scroll = false;
	private boolean hasRun = false;
	private int clicks = 0;
	private int lol = 500;
	public static int currentTile = 0;

	public Map() {
		mapLength = 80;
		mapWidth = 60;
		createMap();
	}
	private void createMap() {
		grid = new int[mapLength][mapWidth];
		tiles = new Shape[4800];
		terrain = new Terrain();
		//layout = new Layout();
		//layout = new Layout(terrain);
		
	}
	public void setWheelInfo(boolean s, int c) {
		scroll = s;
		clicks = c;
	}
	private void firstRun(Graphics2D g2d) {
		if(!hasRun) {
			t.setGrid(grid);
			t.setTiles(g2d);
			tiles = Tiles.tiles;
			c = new Cursor(true);
			RunClass.setup.addObserver(c);
			hasRun = true;
		}
	}
	private void setGrid(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		for(int i = 0; i <= grid[0].length / 2; i++) {
			g2d.drawLine((RunClass.jWidth/ grid[0].length) * i * 2, 0, ((RunClass.jWidth/ grid[0].length) * i * 2), RunClass.jHeight);
		}
		for (int j = 0; j <= grid.length / 2; j++) {
			g2d.drawLine(0, (RunClass.jHeight/ grid.length) * j * 4, RunClass.jWidth - 13, (RunClass.jHeight/ grid.length) * j * 4);
		}
	}
	
	public void paint(Graphics g) {
		Rectangle r = new Rectangle(0, 0, RunClass.jWidth, (RunClass.jHeight / 4 * 3) - 5);
		Area a = new Area(r);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D field = (Graphics2D) g2.create(0, 0, RunClass.jWidth, (RunClass.jHeight / 4 * 3) - 5);
		field.setColor(Color.BLACK);
		field.fill(field.getClip());
		firstRun(field);
		g2.draw(r);
		setGrid(field);
		c = new Cursor();
		c.paint(g2);
		for(int i = 0; i < tiles.length; i++) {
			//g2.drawImage(Terrain.terrainChoice, (int) tiles[i].getBounds2D().getX(), (int) tiles[i].getBounds2D().getY(), (int) tiles[i].getBounds2D().getMaxX(), (int) tiles[i].getBounds2D().getMaxY(), 0, 0, (int) Terrain.terrainChoice.getWidth(), (int) Terrain.terrainChoice.getHeight(), null);
		}
		terrain.paintTerrain(g);
 	}
	@Override
	public void updateKey(KeyEvent keyEvent) {
		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT && currentTile > 0 && currentTile != 30 && currentTile != 60 && currentTile != 90 && currentTile != 120 && currentTile != 150 && currentTile != 180 && currentTile != 210 && currentTile != 240 && currentTile != 270 && currentTile != 300 && currentTile != 330 && currentTile != 360 && currentTile != 390 && currentTile != 420) {
			currentTile = currentTile - 1;
			System.out.println("lol" + currentTile);
		} else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && currentTile < 449 && currentTile != 29 && currentTile != 59 && currentTile != 89 && currentTile != 119 && currentTile != 149 && currentTile != 179 && currentTile != 209 && currentTile != 239 && currentTile != 269 && currentTile != 299 && currentTile != 329 && currentTile != 359 && currentTile != 389 && currentTile != 419 && currentTile != 449) {
			currentTile = currentTile + 1;
			System.out.println("lol" + currentTile);
		} else if(keyEvent.getKeyCode() == KeyEvent.VK_UP && currentTile > 29) {
			currentTile = currentTile - 30;
			System.out.println("lol" + currentTile);
		} else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN && currentTile < 420) {
			currentTile = currentTile + 30;
			System.out.println("lol" + currentTile);
		}
	}
	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
