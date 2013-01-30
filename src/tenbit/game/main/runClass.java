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
import tenbit.game.main.system.logging.SystemLogger;

public class RunClass extends JPanel implements Runnable, Observer {
	private boolean[] keys;
	
	//http://stackoverflow.com/questions/5131547/java-keylistener-in-separate-class

	private int x;
	private int y;
	
	private int cred = 0;
	
	//MouseEvents used throughout the game
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
	public static Setup setup;
	LoadLogos ll = new LoadLogos();

	public RunClass(JFrame par) 
	{
		jWidth = getWidth();
		jHeight = getHeight();
		new Thread(this).start();
		
		setup = new Setup();
		setup.addObserver(this);
		this.addKeyListener(setup);
		this.addMouseMotionListener(setup);
		this.addMouseListener(setup);
		addObservers();
		
	    menu = new MainMenu(true);
	    menu.checkButtons();
	    SystemLogger.createNewDir();
	}

	private void addObservers() {
		setup.addObserver(new MousePos());
		setup.addObserver(new Map());
		setup.addObserver(menu);
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
        ll.paint(window);
        //menu.paint(window);
        //map.paint(window);
        mousepos = new Info(true, 1);
	    mousepos.paint(window);
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
	public void updateKey(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMouse(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}

