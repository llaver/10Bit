package tenbit.game.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import tenbit.game.main.constants.*;
import tenbit.game.main.engine.map.Map;
import tenbit.game.main.info.Info;

public class RunClass extends JPanel implements KeyListener, Runnable
{
	private boolean[] keys;

	private int x;
	private int y;
	
	private int cred = 0;
	
	private MouseEvent event1;
	private MouseEvent event2;
	private MouseEvent event3;
	private MouseEvent event4;
	private MouseEvent event5;
	private MouseWheelEvent wheelEvent1;
	
	public static int jWidth;
	public static int jHeight;
	public static boolean isPressed = false;
	public static boolean isClicked = false;
	
	Info info = new Info();
	Info mousepos;
	MainMenu menu = new MainMenu();
	Listeners ml = new Listeners();
	Listeners mwl = new Listeners();
	Map map = new Map();

	public RunClass(JFrame par) 
	{
		jWidth = getWidth();
		jHeight = getHeight();
		this.addKeyListener(this);
		new Thread(this).start();
		HandlerClass hc = new HandlerClass();
		addMouseListener(hc);
	    addMouseMotionListener(hc);
	    WheelClass wc = new WheelClass();
	    addMouseWheelListener(wc);
	    menu = new MainMenu(true);
	    menu.checkButtons();
	}

	private void setEvent(MouseEvent e1, MouseEvent e2, MouseEvent e3, MouseEvent e4, MouseEvent e5) {
		event1 = e1;
		event2 = e2;
		event3 = e3;
		event4 = e4;
		event5 = e5;
	}
	private void setWheelEvent(MouseWheelEvent mwe1) {
		wheelEvent1 = mwe1;
	}
	
	public void paint( Graphics window )
	{
		jWidth = getWidth();
		jHeight = getHeight();
		final Graphics2D g2d = (Graphics2D) window;
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(MenuImages.backImg, 0, 0, 800, 600, 0, 0, 1200, 900, null);
        ml = new Listeners(event1, event2, event3, event4, event5);
        mwl = new Listeners(wheelEvent1);
	    //menu.paint(window);
        mousepos = new Info(true, 1);
	    mousepos.paint(window);
        map.paint(window);
	}
        @Override
        public void run()
        {
            try
            {
   		while(true)
   		{
                    Thread.currentThread().sleep(1);
                    repaint();
                }
         
            } catch(InterruptedException e) {
            }
  	}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    private class HandlerClass extends MouseInputAdapter {
    	private MouseEvent me1;
    	private MouseEvent me2;
    	private MouseEvent me3;
    	private MouseEvent me4;
    	private MouseEvent me5;

		@Override
		public void mouseClicked(MouseEvent e1) {
			me1 = e1;
			isClicked = true;
			updateSize();
		}

		@Override
		public void mouseDragged(MouseEvent e2) {
			me2 = e2;
			updateSize();
		}

		@Override
		public void mouseMoved(MouseEvent e3) {
			me3 = e3;
			updateSize();
		}
		@Override
		public void mouseReleased(MouseEvent e4) {
			me4 = e4;
			isPressed = false;
			updateSize();
		}
		@Override
		public void mousePressed(MouseEvent e5) {
			me5 = e5;
			isPressed = true;
			updateSize();
		}
		private void updateSize() {
			setEvent(me1, me2, me3, me4, me5);
		}
    }
    private class WheelClass implements MouseWheelListener {
    	private MouseWheelEvent we1;
    	
		@Override
		public void mouseWheelMoved(MouseWheelEvent mwe1) {
			we1 = mwe1;
			map.setWheelInfo(true, mwe1.getWheelRotation());
			System.out.println(mwe1.getWheelRotation());
			updateEvent();
		}
		private void updateEvent() {
			setWheelEvent(we1);
		}
    }
}

