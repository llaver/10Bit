package tenbit.game.main.window;

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

public class MouseXY {
	private MouseEvent mouse;
	private int x;
	private int y;
	
	public MouseXY() {
		
	}
	
	public MouseXY(MouseEvent e) {
		mouse = e;
		x = mouse.getX();
		y = mouse.getY();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;		
	}

}
