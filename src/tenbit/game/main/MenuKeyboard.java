package tenbit.game.main;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.Object.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.lang.Runnable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import tenbit.game.main.constants.*;
import tenbit.game.main.info.Info;
import tenbit.game.main.window.*;

public class MenuKeyboard implements KeyListener, Observer, Observable {
	
	private ArrayList<Observer> obsList;
	private int width;
	private int height;
	private int currentButton;
	private boolean isRunning;
	KeyEvent kp = Listeners.kPressed;
	KeyEvent kr = Listeners.kReleased;
	KeyEvent kt = Listeners.kTyped;
	
	public MenuKeyboard(){
		currentButton = 0;
	}
	
	public MenuKeyboard(boolean run){
		currentButton = 0;
		isRunning = run;
	}
	
	public void keyPressed(KeyEvent e) {
		updateKey(e);
	}
	
	public void paint(Graphics2D g2d){
		
		width = RunClass.jWidth;
		height = RunClass.jHeight;
		
		g2d.drawImage(MenuImages.backImg, 0, 0, width, height, 0, 0, 1200, 800, null);
		
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
