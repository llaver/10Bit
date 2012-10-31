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
import java.awt.Component;
import java.awt.Font;

import tenbit.game.main.window.*;

public class MainMenu implements MouseListener {
	private MouseXY ms = new MouseXY();
	
	public MainMenu() {
		
		
	}

	//TODO Change to the correct coordinates
	@Override
	public void mouseClicked(MouseEvent e) {
		ms = new MouseXY(e);
		//Campaign
		if((ms.getX() >= -1 && ms.getX() <= -1) && (ms.getY() >= -1 && ms.getY() <= -1)) {
			/*
			 * Change the options to Load Game, Save Game, and back
			 * Check X and Y for options
			 * if Load Game give saved games and again check for choice
			 * Start Game by calling Campaign 
			 */
		}
		//Skirmish
		if((ms.getX() >= -1 && ms.getX() <= -1) && (ms.getY() >= -1 && ms.getY() <= -1)) {
			/*
			 * Give Skirmish mode options
			 */
		}
		//Settings
		if((ms.getX() >= -1 && ms.getX() <= -1) && (ms.getY() >= -1 && ms.getY() <= -1)) {
			/*
			 * Call Options 
			 */
		}
		//Exit Game
		if((ms.getX() >= -1 && ms.getX() <= -1) && (ms.getY() >= -1 && ms.getY() <= -1)) {
			/*
			 * Exit the game 
			 */
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
