package tenbit.game.main.engine.character;

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

public class Player implements Character {
	private String name;
	private int level;
	
	public Player() {
		
	}
	public Player(String name) {
		
	}
	@Override
	public String getName() {
		return null;
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public void move() {
		int x = 0;
		x = x + 2;
	}

	@Override
	public void getWorn(int slot) {
		
	}

	@Override
	public void setLevel() {
		
	}

	@Override
	public void setName() {
		
	}

	@Override
	public void equipItem(int eSlot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(int rSlot) {
		// TODO Auto-generated method stub
		
	}

}
