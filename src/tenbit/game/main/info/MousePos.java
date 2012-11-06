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
	} 
	public void paint() {
		
	}

}
