package tenbit.game.main;

import java.io.File;
import java.io.IOException;
import java.lang.Object.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Point;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.Component;
import java.awt.Font;

import tenbit.game.main.constants.Listeners;
import tenbit.game.main.window.*;

public class MainMenu extends MouseInputAdapter  {
	private MouseXY mClick;
	private MouseXY mMove = new MouseXY();
	private int x;
	private int y;
	private boolean test = false;
	private boolean run = false;
	private MouseEvent move = Listeners.mMoved;
	private MouseEvent click = Listeners.mClick;
	private MouseEvent drag = Listeners.mDrag;
	private String currentMenu;
	
	private final File sprites = new File("10bit/Sprites/JPG or PNG/");
	private final File background = new File(sprites, "Menu Background.jpg");
	private final File menuBlack = new File(sprites, "Logo (black).png");
	private final File menuWhite = new File(sprites, "Logo (white).png");
	private final File menuOnHover = new File(sprites, "Textbox - On Hover.jpg");
	private final File menuNoHover = new File(sprites, "Textbox - No Hover.jpg");
	private final File menuHeld = new File(sprites, "Textbox - Mouse Held.jpg");
	private BufferedImage backImg;
	private BufferedImage logoBlack;
	private BufferedImage logoWhite;
	private BufferedImage textOnHover;
	private BufferedImage textNoHover;
	private BufferedImage textHeld;
	
	
	public MainMenu() {
		x = -1;
		y = -1;
		currentMenu = "Loading";
		try {
	    	backImg = ImageIO.read(background);
	    	logoBlack = ImageIO.read(menuBlack);
	    	logoWhite = ImageIO.read(menuWhite);
		} catch (IOException e) { e.printStackTrace();
		}
	}
	public MainMenu(boolean start) {
		currentMenu = "Main Menu";
		run = start;
		if(move != null && drag != null && click != null) {
			mouseMoved(move);
			mouseDragged(drag);
			mouseClicked(click);
		} else { }
	}
	public void paint(Graphics window) {
		Graphics g = window;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backImg, 0, 0, null);
		g2.drawImage(logoBlack, 200, 75, null);
		g2.drawImage(logoWhite, 200, 50, null);
		//g2.drawRect(160, 120, 460, 50);
		if(test) {
			g2.setBackground(Color.BLACK);
			g2.clearRect(151, 251, 198, 348);
			g2.clearRect(224, 224, 150, 75);
			g2.setColor(Color.CYAN);
			g2.drawString("It Worked!", 225, 225);
		} 
	}
	
	 
	@Override
	public void mouseMoved(MouseEvent e) {
		if(e != null) {
			mMove = new MouseXY(e);
			x = mMove.getX();
			y = mMove.getY();
		} else { }
	}

	//TODO Change to the correct coordinates
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e != null) {
			mClick = new MouseXY(e);
			if(currentMenu.contains("Main Menu")){
				//Campaign
				if((mClick.getX() >= 150 && mClick.getX() <= 350) && (mClick.getY() >= 250 && mClick.getY() <= 350)) {
					test = true;
					//currentMenu = "Campaign";
				}
				//Skirmish
				if((mClick.getX() >= -1 && mClick.getX() <= -1) && (mClick.getY() >= -1 && mClick.getY() <= -1)) {
					currentMenu = "Skirmish";
				}
				//Settings
				if((mClick.getX() >= -1 && mClick.getX() <= -1) && (mClick.getY() >= -1 && mClick.getY() <= -1)) {
					currentMenu = "Options";
				}
				//Exit Game
				if((mClick.getX() >= -1 && mClick.getX() <= -1) && (mClick.getY() >= -1 && mClick.getY() <= -1)) {
					System.exit(1);
				}
			} else if(currentMenu.contentEquals("Campaign")) {
				campaignMenu();
			} else if(currentMenu.contentEquals("Skirmish")) {
				skirmishMenu();
			} else if(currentMenu.contentEquals("Options")) {
				optionsMenu();
			} else if(currentMenu.contentEquals("Exit")) {
				exitMenu();
			} else if(currentMenu.contentEquals("Loading")) {
			} else if(currentMenu.contentEquals(null)) {
			}
		} else { }
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e != null) {
			
		} else { }
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
}
