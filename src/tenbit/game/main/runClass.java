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
	
	private MouseEvent event1;
	private MouseEvent event2;
	private MouseEvent event3;
	
	MainMenu mm = new MainMenu();
	MainMenu menu = new MainMenu();

	public RunClass(JFrame par)
	{
		
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
		HandlerClass hc = new HandlerClass();
		addMouseListener(hc);
	    addMouseMotionListener(hc);
	    //if((event1 != null) && (event2 != null) && (event3 != null)) {
	    //}	    
	}

	private void setEvent(MouseEvent e1, MouseEvent e2, MouseEvent e3) {
		event1 = e1;
		event2 = e2;
		event3 = e3;
	}
	
	private void callAll(Graphics window) {
	}
	
	

    public void repaint(Graphics window)
    {
    	Graphics2D g2d = (Graphics2D) window;
    	g2d.drawImage(MenuImages.backImg, x, y, null);
    	g2d.drawImage(MenuImages.logoBlack, 200, 75, null);
		g2d.drawImage(MenuImages.logoWhite, 200, 50, null);
		paint(window);
		//callAll(window);
    	mm.paint(window);
    }

	public void paint( Graphics window )
	{
		//callAll(window);
		final Graphics2D g2d = (Graphics2D) window;
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(MenuImages.backImg, x, y, null);
    	g2d.drawImage(MenuImages.logoBlack, 200, 75, null);
		g2d.drawImage(MenuImages.logoWhite, 200, 50, null);
        if((event1 != null) && (event2 != null) && (event3 != null)) {
			Listeners l = new Listeners();
		    l = new Listeners(event1, event2, event3);
		    menu = new MainMenu(true);
		    menu.paint(window);
		    } else {
		    	mm.paint(window);
		    }
	}
        @Override
        public void run()
        {
            try
            {
   		while(true)
   		{
                    Thread.currentThread().sleep(5);
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
			if((me1 != null) && (me2 != null) && (me3 != null)) {
			//System.out.println((me1.getClickCount()) + ("  X: " + me2.getX() + "  Y: " + me2.getY()) + ("  X: " + me3.getX() + "  Y: " + me3.getY()) );
			setEvent(me1, me2, me3);
			} else {				
			}
		}
    }
}

