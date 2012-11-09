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

public abstract interface Character {
	
	abstract String getName();
	abstract int getLevel();
	abstract void setLevel();
	abstract void setName();
	abstract void move();
	abstract void equipItem(int eSlot);
	abstract void removeItem(int rSlot);
	abstract void getWorn(int wSlot);
	
}
