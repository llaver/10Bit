package tenbit.game.main.info;

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

import tenbit.game.main.constants.*;
import tenbit.game.main.window.*;

public class MousePos extends MouseInputAdapter {
	private MouseXY mMove = new MouseXY();
	private boolean isOn;
	private int x = -1;
	private int y = -1;
	Listeners lis = new Listeners();
	private MouseEvent move = lis.mMoved;
	private MouseEvent click = lis.mClick;
	private MouseEvent drag = lis.mDrag;
	
	
	public MousePos() {
		isOn = false;
	}
	public MousePos(boolean on) {
		isOn = on;
		mouseMoved(move);
	} 
	public void paint(Graphics window) {
		Graphics g = window;
		g.setColor(Color.CYAN);
		g.clearRect(30, 3, 30, 32);
		g.drawString("X: ", 15, 15);
		g.drawString(Integer.toString(x), 35, 15);
		g.drawString("Y: ", 15, 35);
		g.drawString(Integer.toString(y), 35, 35);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mMove = new MouseXY(e);
		x = mMove.getX();
		y = mMove.getY();
		System.out.println("mouseMoved() in mm");
	}
	

}
