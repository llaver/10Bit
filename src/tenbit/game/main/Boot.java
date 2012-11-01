/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tenbit.game.main;

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Color;


public class Boot extends JFrame 
{
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    
    public Boot() 
    {
        super("Boot");

	setSize(WIDTH, HEIGHT);
	setBackground(Color.BLACK);
        RunClass rc = new RunClass(this);
	((Component)rc).setFocusable(true);

        getContentPane().add( rc );
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        
    }
    
    public static void main( String args[] )
	{
		Boot run = new Boot();
	}
    
    
}
