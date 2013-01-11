package tenbit.game.main.engine.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tenbit.game.main.constants.Listeners;

public class Cursor extends KeyAdapter {
	
	//http://stackoverflow.com/questions/5131547/java-keylistener-in-separate-class
	
	private Shape[] tiles = Tiles.tiles;
	private int currentTile;
	private boolean isRunning;
	
	KeyEvent kp = Listeners.kPressed;
	KeyEvent kr = Listeners.kReleased;
	KeyEvent kt = Listeners.kTyped;
	
	public Cursor() {
		currentTile = 0;
		
	}
	public Cursor(boolean run) {
		isRunning = run;
	}
	private void updateTile() {
		if(kp != null && isRunning) {
			if(kp.getKeyChar() == KeyEvent.VK_LEFT) {
				currentTile = currentTile - 1;
			} else if(kp.getKeyCode() == KeyEvent.VK_RIGHT) {
				currentTile = currentTile + 1;
			}
		}
	}
	public void paint(Graphics2D g2d) {
		updateTile();
		System.out.println(currentTile);
		g2d.setColor(Color.RED);
		g2d.draw(tiles[currentTile]);
	}
	@Override
	public void keyPressed(KeyEvent e1) {
		
	}

	@Override
	public void keyReleased(KeyEvent e2) {
	}
	
	@Override
	public void keyTyped(KeyEvent e3) {
	}
	
}
