package tenbit.game.main.engine.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import tenbit.game.main.Observer;
import tenbit.game.main.constants.Listeners;

public class Cursor implements Observer {
	
	//http://stackoverflow.com/questions/5131547/java-keylistener-in-separate-class
	
	private Shape[] tiles = Tiles.tiles;
	private int currentTile = 0;
	private boolean isRunning;
	
	KeyEvent kp = Listeners.kPressed;
	KeyEvent kr = Listeners.kReleased;
	KeyEvent kt = Listeners.kTyped;
	
	public Cursor() {
		
	}
	public Cursor(boolean run) {
		isRunning = run;
	}
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.draw(tiles[currentTile]);
	}
	
	@Override
	public void updateKey(KeyEvent keyEvent) {
		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
			currentTile = currentTile - 1;
		} else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("lol" + currentTile);
			currentTile = currentTile + 1;
		}
	}
	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		
	}
	
}
