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

public class runClass extends JPanel implements KeyListener, Runnable
{
	private boolean[] keys;

	private int x;
	private int y;

	public runClass(JFrame par)
	{
		
		setBackground(Color.BLACK);

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}
	

	
	

        public void update(Graphics window)
        {
            paint(window);
        }

	public void paint( Graphics window )
	{
		
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
}
