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
import tenbit.game.main.engine.map.Cursor;
import tenbit.game.main.engine.map.Map;
import tenbit.game.main.info.Info;
import tenbit.game.main.info.MousePos;

public class RunClass extends JPanel implements Runnable, Observer {
	private boolean[] keys;
	
	//http://stackoverflow.com/questions/5131547/java-keylistener-in-separate-class

	private int x;
	private int y;
	
	private int cred = 0;
	
	private MouseEvent event1;
	private MouseEvent event2;
	private MouseEvent event3;
	private MouseEvent event4;
	private MouseEvent event5;
	private MouseWheelEvent wheelEvent1;
	private KeyEvent keyEvent1;
	private KeyEvent keyEvent2;
	private KeyEvent keyEvent3;
	
	public static int jWidth;
	public static int jHeight;
	public static boolean isPressed = false;
	public static boolean isClicked = false;
	
	Info info = new Info();
	Info mousepos;
	MainMenu menu = new MainMenu();
	Listeners ml = new Listeners();
	Listeners mwl = new Listeners();
	Listeners kl = new Listeners();
	Map map = new Map();
	Setup setupInstance = new Setup();
	public static Setup setup;
	//LoadLogos ll = new LoadLogos();

	public RunClass(JFrame par) 
	{
		jWidth = getWidth();
		jHeight = getHeight();
		new Thread(this).start();
		HandlerClass hc = new HandlerClass();
		
		setup = new Setup();
		setup.addObserver(this);
		this.addKeyListener(setup);
		this.addMouseMotionListener(setup);
		this.addMouseListener(setup);
		addObservers();
		
		WheelClass wc = new WheelClass();
		keyHandler kh = new keyHandler();
		addMouseListener(hc);
	    addMouseMotionListener(hc);
	    addKeyListener(kh);
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
	private void setKeyEvent(KeyEvent ke1, KeyEvent ke2, KeyEvent ke3) {
		keyEvent1 = ke1;
		keyEvent2 = ke2;
		keyEvent3 = ke3;
	}
	private void addObservers() {
		setup.addObserver(new MousePos());
		setup.addObserver(new Map());
		//setup.addObserver(new Cursor());
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
        kl = new Listeners(keyEvent1, keyEvent2, keyEvent3);
        //ll.paint(window);
        //menu.paint(window);
        map.paint(window);
        mousepos = new Info(true, 1);
	    mousepos.paint(window);
	    //ll.paint(window);
        //menu.paint(window); 
        map.paint(window);
        mousepos = new Info(true, 1);
	    mousepos.paint(window); 
	    //window.drawImage(MenuImages.bbLogo, 50, 50, null);
		//System.out.println("1st loaded");
	    //window.drawImage(MenuImages.tbLogo, 0, 0, null);
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
			updateEvent();
		}
		private void updateEvent() {
			setWheelEvent(we1);
		}
    }
    private class keyHandler implements KeyListener {
    	private KeyEvent ke1;
    	private KeyEvent ke2;
    	private KeyEvent ke3;
    	
		@Override
		public void keyPressed(KeyEvent e1) {
			ke1 = e1;
			updateKeys();
		}

		@Override
		public void keyReleased(KeyEvent e2) {
			ke2 = e2;
			updateKeys();
		}
		
		@Override
		public void keyTyped(KeyEvent e3) {
			ke3 = e3;
			updateKeys();
		}
    	private void updateKeys() {
    		setKeyEvent(ke1, ke2, ke3);
    	}		
    }

	@Override
	public void updateKey(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}

