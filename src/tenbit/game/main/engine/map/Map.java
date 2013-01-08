package tenbit.game.main.engine.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.sql.Timestamp;
import java.util.Date;

import tenbit.game.main.RunClass;
import tenbit.game.main.constants.Listeners;
import tenbit.game.main.constants.MenuImages;

public class Map {
	
	private double zoom = 1;
	private int mapLength;
	private int mapWidth;
	private int[][] grid;
	private Shape[] tile;
	private Layout layout;
	private boolean scroll = false;
	private int clicks = 0;

	public Map() {
		mapLength = 80;
		mapWidth = 60;
		createMap();
	}
	private void createMap() {
		grid = new int[mapLength][mapWidth];
		tile = new Shape[mapLength * mapWidth];
		//Terrain terrain = new Terrain();
		//layout = new Layout();
		//layout = new Layout(terrain);
		
	}
	public void setWheelInfo(boolean s, int c) {
		scroll = s;
		clicks = c;
	}
	private void setGrid(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		for(int i = 0; i <= grid[0].length / 2; i++) {
			g2d.drawLine((RunClass.jWidth/ grid[0].length) * i * 2, 0, (RunClass.jWidth/ grid[0].length) * i * 2, RunClass.jHeight);
		}
		for (int j = 0; j <= grid.length / 2; j++) {
			g2d.drawLine(0, (RunClass.jHeight/ grid.length) * j * 4, RunClass.jWidth, (RunClass.jHeight/ grid.length) * j * 4);
		}
	}
	private void setTile(Graphics2D g2d) {
		
	}
	
	private void checkZoom() {
		double startZoom = zoom;
		int zoomRoom = (int) ((2 - zoom) * 10);	
		if(clicks != 0 && scroll) {
			if(clicks < 0) {
				if(clicks + zoomRoom <= 0) {
					zoom = 2.0;
				} else {
					zoom = zoom - ((double)(clicks - zoomRoom) / 10);
				}
			} else if(clicks > 0) {
				if(clicks + zoomRoom >= 20) {
					zoom = 0;
				} else {
				zoom = zoom - ((double)(clicks + zoomRoom) / 10);
				}				
			}
		}
		clicks = 0;
		scroll = false;
	}
	
	public void paint(Graphics g) {
		Rectangle r = new Rectangle(0, 0, RunClass.jWidth, (RunClass.jHeight / 4 * 3) - 5);
		Area a = new Area(r);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D field = (Graphics2D) g2.create(0, 0, RunClass.jWidth, (RunClass.jHeight / 4 * 3) - 5);
		field.setColor(Color.BLACK);
		field.fill(field.getClip());
		g2.draw(r);
		setGrid(field);
		setTile(field);
 	}
}
