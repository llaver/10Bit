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

public class MenuKeyboard extends MainMenu implements Observer {
	
	private ArrayList<Observer> obsList;
	private int currentButton;
	private boolean isRunning;
	KeyEvent kp = Listeners.kPressed;
	KeyEvent kr = Listeners.kReleased;
	KeyEvent kt = Listeners.kTyped;
	//Leaderboard
	private File[] lbButtons = new File[4];
	private BufferedImage[] lbImages = new BufferedImage[4];
	//Load Game
	private File[] lgButtons = new File[4];
	private BufferedImage[] lgImages = new BufferedImage[4];
	//New Game
	private File[] ngButtons = new File[4];
	private BufferedImage[] ngImages = new BufferedImage[4];
	//Options
	private File[] opButtons = new File[4];
	private BufferedImage[] opImages = new BufferedImage[4];
	//Quit Game
	private File[] qgButtons = new File[4];
	private BufferedImage[] qgImages = new BufferedImage[4];
	private Map<File, Set<File>> titledButtons = MenuImages.allTitleButtons;
	private Map<File, Set<File>> titledImages = MenuImages.allTitleButtons;
	
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
	
	public void paintButtons(Graphics2D g2d){
		
		if(currentButton==0)
			g2d.drawImage(ngImages[0], 245, 160, null);
		else if(currentButton==1)
			g2d.drawImage(lgImages[0], 245, 245, null);
		else if(currentButton==2)
			g2d.drawImage(opImages[0], 245, 330, null);
		else if(currentButton==3)
			g2d.drawImage(lbImages[0], 245, 415, null);
		else if(currentButton==4)
			g2d.drawImage(qgImages[0], 245, 500, null);
	}

	@Override
	public void updateKey(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}	
}
