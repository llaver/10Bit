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

public class MainMenu implements Observer {
	private MouseXY mClick;
	private MouseXY mMove = new MouseXY();
	private MouseXY mDrag = new MouseXY();
	private int width = RunClass.jWidth;
	private int height = RunClass.jHeight;
	private int x;
	private int y;
	private boolean once = false;
	private boolean run = false;
	private MouseEvent move = Listeners.mMoved;
	private MouseEvent click = Listeners.mClick;
	private MouseEvent drag = Listeners.mDrag;
	private MouseEvent release = Listeners.mReleased;
	private String currentMenu;
	
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
	
	Info info = new Info();
	Info mousepos;
	
	public MainMenu() {
		x = -1;
		y = -1;
		currentMenu = "Loading";	
		try {
			MenuImages mi = new MenuImages();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public MainMenu(boolean start) {
		currentMenu = "Main Menu";
		run = start;
		currentMenu = "Loading";
	}
	public void paint(Graphics window) {
		width = RunClass.jWidth;
		height = RunClass.jHeight;
		x = MousePos.x;
		y = MousePos.y;
		Graphics g = window;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(MenuImages.backImg, 0, 0, width, height, 0, 0, 1200, 800, null);
		mousepos = new Info(true, 1);
	    mousepos.paint(window);
    	g2.drawImage(MenuImages.logoBlack, (width / 4) + 4, 0, null);
		g2.drawImage(MenuImages.logoWhite, (width / 4), 20, null);
		paintButtons(g2);
	}
	
	public void checkButtons() {
		File[] f = new File[5];
		titledButtons.keySet().toArray(f);
		for(int i = 0; i < f.length; i++) {
			File dir = f[i];
			for(int j = 0; j < dir.listFiles().length; j++) {
				if(dir.getName().contains("Leaderboard") && titledButtons.get(dir).iterator().hasNext()) {
					System.out.println("LB j:" + j + " i:" + i);
					lbButtons = dir.listFiles();
				}
				else if(dir.getName().contains("Load Game") && titledButtons.get(dir).iterator().hasNext()) {
					System.out.println("LG j:" + j + " i:" + i);
					lgButtons = dir.listFiles();
				}
				else if(dir.getName().contains("New Game") && titledButtons.get(dir).iterator().hasNext()) {
					System.out.println("NG j:" + j + " i:" + i);
					ngButtons = dir.listFiles();
				}
				else if(dir.getName().contains("Options") && titledButtons.get(dir).iterator().hasNext()) {
					System.out.println("OP j:" + j + " i:" + i);
					opButtons = dir.listFiles();
				}
				else if(dir.getName().contains("Quit Game") && titledButtons.get(dir).iterator().hasNext()) {
					System.out.println("QG j:" + j + " i:" + i);
					qgButtons = dir.listFiles();
				}
			}
		}
		try {
			for(int i = 0; i < f.length; i++) {
				for(int j = 0; j < 3; j++) {
					lbImages[j] = ImageIO.read(lbButtons[j]);
					lgImages[j] = ImageIO.read(lgButtons[j]);
					ngImages[j] = ImageIO.read(ngButtons[j]);
					opImages[j] = ImageIO.read(opButtons[j]);
					qgImages[j] = ImageIO.read(qgButtons[j]);
				}			
			}
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	protected void paintButtons(Graphics2D g2d) {
		g2d.drawImage(ngImages[1], 245, 160, null);
		g2d.drawImage(lgImages[1], 245, 245, null);
		g2d.drawImage(opImages[1], 245, 330, null);
		g2d.drawImage(lbImages[1], 245, 415, null);
		g2d.drawImage(qgImages[1], 245, 500, null);
		//Button are all 300x70
		if((x >= 245 && x <= 545) && !RunClass.isPressed) {
			if(y >= 160 && y <= 230) {
				g2d.drawImage(ngImages[2], 245, 160, null);
			}
			else if(y >= 245 && y <= 315) {
				g2d.drawImage(lgImages[2], 245, 245, null);
			}
			else if(y >= 330 && y <= 400) {
				g2d.drawImage(opImages[2], 245, 330, null);
			}
			else if(y >= 415 && y <= 485) {
				g2d.drawImage(lbImages[2], 245, 415, null);
			}
			else if(y >= 500 && y <= 570) {
				g2d.drawImage(qgImages[2], 245, 500, null);
			}
		} else if((x >= 245 && x <= 545) && RunClass.isPressed) {
			if(y >= 160 && y <= 230) {
				g2d.drawImage(ngImages[0], 245, 160, null);
			}
			else if(y >= 245 && y <= 315) {
				g2d.drawImage(lgImages[0], 245, 245, null);
			}
			else if(y >= 330 && y <= 400) {
				g2d.drawImage(opImages[0], 245, 330, null);
			}
			else if(y >= 415 && y <= 485) {
				g2d.drawImage(lbImages[0], 245, 415, null);
			}
			else if(y >= 500 && y <= 570) {
				g2d.drawImage(qgImages[0], 245, 500, null);
			}
		} else if((x >= 245 && x <= 545) && RunClass.isClicked) {
			if(y >= 160 && y <= 230) {
				g2d.drawImage(ngImages[1], 245, 160, null);
			}
			else if(y >= 245 && y <= 315) {
				g2d.drawImage(lgImages[1], 245, 245, null);
			}
			else if(y >= 330 && y <= 400) {
				g2d.drawImage(opImages[1], 245, 330, null);
			}
			else if(y >= 415 && y <= 485) {
				g2d.drawImage(lbImages[1], 245, 415, null);
			}
			else if(y >= 500 && y <= 570) {
				g2d.drawImage(qgImages[1], 245, 500, null);
			}
		}
	}
	
	public void campaignMenu() {
		
	}
	public void skirmishMenu() {
		
	}
	public void optionsMenu() {
		
	}
	public void exitMenu() {
		
	}
	public void exitGame() {
		System.exit(1);
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
