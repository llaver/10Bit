/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenbit.game.main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

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
	MainMenu menu;
	
	Info info = new Info();
	Info mousepos;
	

	public RunClass(JFrame par)
	{
		
		setBackground(Color.BLACK);
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
		if((event1 != null) && (event2 != null) && (event3 != null)) {
			Listeners l = new Listeners();
		    l = new Listeners(event1, event2, event3);
		    //menu = new MainMenu(event1, event2, event3);
		    //menu.paint(window);
		    mousepos = new Info(true, 1);
		    mousepos.paint(window);
		    } else {
		    	mm.paint(window);
		    }
		}
	
	

    public void update(Graphics window)
    {
    	callAll(window);
        paint(window);
    }

	public void paint( Graphics window )
	{
			callAll(window);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
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
			System.out.println((me1.getClickCount()) + ("  X: " + me2.getX() + "  Y: " + me2.getY()) + ("  X: " + me3.getX() + "  Y: " + me3.getY()) );
			setEvent(me1, me2, me3);
			} else {				
			}
		}
    }
}

