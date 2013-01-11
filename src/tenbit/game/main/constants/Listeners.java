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
	public static KeyEvent kPressed;
	public static KeyEvent kReleased;
	public static KeyEvent kTyped;
	
	//http://stackoverflow.com/questions/5131547/java-keylistener-in-separate-class
	
	public Listeners() {
		mMoved = null;
		mDrag = null;
		mClick = null;
		mPressed = null;
		mReleased = null;
		mwEvent = null;
		kPressed = null;
		kReleased = null;
		kTyped = null;
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
	public Listeners(KeyEvent kp, KeyEvent kr, KeyEvent kt) {
		kPressed = kp;
		kReleased = kr;
		kTyped = kt;
	}
}
