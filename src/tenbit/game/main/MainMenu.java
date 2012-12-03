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

import tenbit.game.main.constants.*;
import tenbit.game.main.info.Info;
import tenbit.game.main.window.*;

public class MainMenu extends MouseInputAdapter  {
	private MouseXY mClick;
	private MouseXY mMove = new MouseXY();
	private MouseXY mDrag = new MouseXY();
	private int width = RunClass.jWidth;
	private int height = RunClass.jHeight;
	private int x;
	private int y;
	private boolean test = false;
	private boolean run = false;
	private MouseEvent move = Listeners.mMoved;
	private MouseEvent click = Listeners.mClick;
	private MouseEvent drag = Listeners.mDrag;
	private String currentMenu;
	
	Info info = new Info();
	Info mousepos;
	
	public MainMenu() {
		x = -1;
		y = -1;
		currentMenu = "Loading";	
		try {
			MenuImages mi = new MenuImages();
		} catch (IOException e) {
		} 
	}
	public MainMenu(boolean start) {
		currentMenu = "Main Menu";
		run = start;
		mouseMoved(move);
		mouseDragged(drag);
		mouseClicked(click);
		currentMenu = "Loading";
		//System.out.println(backGround.getWidth() + "   " + backGround.getHeight());
		
	}
	public void paint(Graphics window) {
		width = RunClass.jWidth;
		height = RunClass.jHeight;
		Graphics g = window;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(MenuImages.backImg, 0, 0, width, height, 0, 0, 1200, 800, null);
		mousepos = new Info(true, 1);
	    mousepos.paint(window);
    	g2.drawImage(MenuImages.logoBlack, (width / 4), (height / 8), null);
		g2.drawImage(MenuImages.logoWhite, (width / 4), (height / 12), null);
		g2.drawImage(MenuImages.textNoHover, 245, 250, null);
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
			if(currentMenu.contains("Main Menu")) {
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
