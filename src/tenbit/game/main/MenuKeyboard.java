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

public class MenuKeyboard extends MainMenu {
	
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
	
	private int width = RunClass.jWidth;
	private int height = RunClass.jHeight;
	
	private Map<File, Set<File>> titledButtons = MenuImages.allTitleButtons;
	private Map<File, Set<File>> titledImages = MenuImages.allTitleButtons;
		
	
	public void keyPressed(KeyEvent e) {
		
	    int key = e.getKeyCode();
	    
	    int picNum = 0;
	    
	    while(key != KeyEvent.VK_ENTER){
	     if(picNum>4 || picNum<0){
	    	 picNum = 0;
	     }
	     else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_LEFT) {
	    	 picNum--;
	     }
	     else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_RIGHT) {
	    	 picNum++;
	     }
	    }
	}
	public void paint(Graphics window) {
		width = RunClass.jWidth;
		height = RunClass.jHeight;
		Graphics g = window;
		Graphics2D g2 = (Graphics2D) g;
		//g2.drawImage(MenuImages.backImg, 0, 0, width, height, 0, 0, 1200, 800, null);
    	//g2.drawImage(MenuImages.logoBlack, (width / 4) + 4, 0, null);
		//g2.drawImage(MenuImages.logoWhite, (width / 4), 20, null);
	    g2.drawString(new Boolean(RunClass.isPressed).toString(), 110, 15);
		//paintButtons(g2);
	}
}
