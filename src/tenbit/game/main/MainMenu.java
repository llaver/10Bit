package tenbit.game.main;

import java.lang.Object.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.Component;
import java.awt.Font;

import tenbit.game.main.window.*;

public class MainMenu extends MouseInputAdapter  {
	private MouseXY mClick = new MouseXY();
	private MouseXY mMove = new MouseXY();
	private int x;
	private int y;
	private boolean test = false;
	private MouseEvent click, drag, move;
	
	
	public MainMenu() {
		x = -1;
		y = -1;
	}
	
	public void paint(Graphics window) {
		Graphics g = window;
		g.setColor(Color.CYAN);
		g.drawRect(150, 250, 200, 100);
		g.clearRect(30, 3, 30, 32); 
		g.drawString("Testing!", 225, 225);
		g.drawString("X: ", 15, 15);
		g.drawString(Integer.toString(x), 35, 15);
		g.drawString("Y: ", 15, 35);
		g.drawString(Integer.toString(y), 35, 35);
		g.setColor(Color.BLACK);
		if(test) {
			g.setColor(Color.BLACK);
			g.clearRect(151, 251, 198, 348);
			g.clearRect(224, 224, 150, 75);
			g.setColor(Color.CYAN);
			g.drawString("It Worked!", 225, 225);
		} 
	}
	 
	@Override
	public void mouseMoved(MouseEvent e) {
		mMove = new MouseXY(e);
		x = mMove.getX();
		y = mMove.getY();
		System.out.println("mouseMoved() in mm");
	}

	//TODO Change to the correct coordinates
	@Override
	public void mouseClicked(MouseEvent e) {
		mClick = new MouseXY(e);
		//Campaign
		if((mClick.getX() >= 150 && mClick.getX() <= 350) && (mClick.getY() >= 250 && mClick.getY() <= 350)) {
			/*
			 * Change the options to Load Game, Save Game, and back
			 * Check X and Y for options
			 * if Load Game give saved games and again check for choice
			 * Start Game by calling Campaign 
			 */
			test = true;
		}
		//Skirmish
		if((mClick.getX() >= -1 && mClick.getX() <= -1) && (mClick.getY() >= -1 && mClick.getY() <= -1)) {
			/*
			 * Give Skirmish mode options
			 */
		}
		//Settings
		if((mClick.getX() >= -1 && mClick.getX() <= -1) && (mClick.getY() >= -1 && mClick.getY() <= -1)) {
			/*
			 * Call Options 
			 */
		}
		//Exit Game
		if((mClick.getX() >= -1 && mClick.getX() <= -1) && (mClick.getY() >= -1 && mClick.getY() <= -1)) {
			/*
			 * Exit the game 
			 */
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
