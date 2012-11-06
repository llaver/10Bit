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
	public final MouseEvent mMoved;
	public final MouseEvent mDrag;
	public final MouseEvent mClick;
	
	
	
	public Listeners() {
		mMoved = null;
		mDrag = null;
		mClick = null;
		
	}
	public Listeners(MouseEvent cl, MouseEvent dr, MouseEvent mv) {
		mClick = cl;
		mDrag = dr;
		mMoved = mv;
		
	}	
}
