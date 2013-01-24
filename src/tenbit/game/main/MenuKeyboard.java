package tenbit.game.main;

import java.io.File;
import java.io.IOException;
import java.lang.Object.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.awt.Point;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.Component;
import java.awt.Font;

import tenbit.game.main.constants.*;
import tenbit.game.main.info.Info;
import tenbit.game.main.info.MousePos;
import tenbit.game.main.window.*;

public class MenuKeyboard implements KeyListener, Observer, Observable {
	
	private ArrayList<Observer> obsList;
	KeyEvent kp = Listeners.kPressed;
	KeyEvent kr = Listeners.kReleased;
	KeyEvent kt = Listeners.kTyped;	
	
	public void keyPressed(KeyEvent e) {
		updateKey(e);
	}
	
	@Override
	public void notifyObserversKey(KeyEvent keyEvent) {
		for(Observer obs : obsList){
			obs.updateKey(keyEvent);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0){
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	@Override
	public void notifyObserversMouse(MouseEvent mouseEvent) {
	}
	@Override
	public void updateKey(KeyEvent keyEvent) {
	}
	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		
	}
	
}
