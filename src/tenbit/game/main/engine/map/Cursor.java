package tenbit.game.main.engine.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyEvent;

import tenbit.game.main.constants.Listeners;

public class Cursor {
	
	private Shape[] tiles = Tiles.tiles;
	private int currentTile;
	
	KeyEvent kp = Listeners.kPressed;
	KeyEvent kr = Listeners.kReleased;
	KeyEvent kt = Listeners.kTyped;
	
	public Cursor() {
		currentTile = 0;
		
	}
	private void updateTile() {
		if(kp != null) {
		if(kp.getKeyCode() == KeyEvent.VK_LEFT) {
			currentTile--;
		} else if(kp.getKeyCode() == KeyEvent.VK_RIGHT) {
			currentTile++;
		}
		}
	}
	public void paint(Graphics2D g2d) {
		updateTile();
		g2d.setColor(Color.RED);
		g2d.draw(tiles[currentTile]);
	}
}
