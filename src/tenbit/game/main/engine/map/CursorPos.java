package tenbit.game.main.engine.map;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import tenbit.game.main.Observer;

public class CursorPos implements Observer {
	private static int currentTile;

	public CursorPos() {
		currentTile = 0;
	}
	public static int getCursorPos() {
		
		return currentTile;
	}

	@Override
	public void updateKey(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateClick(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

}
