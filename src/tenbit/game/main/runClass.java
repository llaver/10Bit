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

public class RunClass extends JPanel implements KeyListener, Runnable
{
	private boolean[] keys;

	private int x;
	private int y;

	public RunClass(JFrame par)
	{
		
		setBackground(Color.BLACK);

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
		
		HandlerClass hc = new HandlerClass();
		addMouseListener(hc);
	    addMouseMotionListener(hc);
	}
	
	private void callAll(Graphics window) {
		//Opening cutscene
		/* Opening cutscene/logos here */
		//Main Menu
		MainMenu mm = new MainMenu();
		mm.paint(window);
		
	}
	
	

    public void update(Graphics window)
    {
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
			
			
		}
    }
}

