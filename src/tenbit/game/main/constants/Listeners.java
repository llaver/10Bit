package tenbit.game.main.constants;

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

public class Listeners {
	public static MouseEvent mMoved;
	public static MouseEvent mDrag;
	public static MouseEvent mClick;
	public static MouseEvent mPressed;
	public static MouseEvent mReleased;
	public static MouseWheelEvent mwEvent;
	public int x;
	
	
	
	public Listeners() {
		mMoved = null;
		mDrag = null;
		mClick = null;
		mPressed = null;
		mReleased = null;
		mwEvent = null;
	}
	public Listeners(MouseEvent cl, MouseEvent dr, MouseEvent mv, MouseEvent mr, MouseEvent pr) {
		mClick = cl;
		mDrag = dr;
		mMoved = mv;
		mReleased = mr;
		mPressed = pr;
	}
	public Listeners(MouseWheelEvent mw) {
		mwEvent = mw;
	}
}
