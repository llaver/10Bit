/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
	
	public static int jWidth;
	public static int jHeight;
	
	MainMenu menu = new MainMenu();

	public RunClass(JFrame par)
	{
		jWidth = getWidth();
		jHeight = getHeight();
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
		HandlerClass hc = new HandlerClass();
		addMouseListener(hc);
	    addMouseMotionListener(hc); 
	}

	private void setEvent(MouseEvent e1, MouseEvent e2, MouseEvent e3) {
		event1 = e1;
		event2 = e2;
		event3 = e3;
	}
	
	public void paint( Graphics window )
	{
		jWidth = getWidth();
		jHeight = getHeight();
		final Graphics2D g2d = (Graphics2D) window;
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(MenuImages.backImg, 0, 0, 800, 600, 0, 0, 1200, 900, null);
    	g2d.drawImage(MenuImages.logoBlack, (getWidth() / 4), (getHeight() / 8), null);
		g2d.drawImage(MenuImages.logoWhite, (getWidth() / 4), (getHeight() / 12), null);
		
		Listeners l = new Listeners();
	    l = new Listeners(event1, event2, event3);
	    menu = new MainMenu(true);
	    menu.paint(window);
		    
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

		@Override
		public void mouseClicked(MouseEvent e1) {
			me1 = e1;
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
		void updateSize() {
			setEvent(me1, me2, me3);
		}
    }
}

