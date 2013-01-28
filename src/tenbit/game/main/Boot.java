/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tenbit.game.main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.System;


public class Boot extends JFrame 
{
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    
    public Boot() 
    {
        super("Boot"); 
        
        setSize(WIDTH, HEIGHT);
        RunClass rc = new RunClass(this);
        ((Component)rc).setFocusable(true);
        System.out.println("Hello World! (:");
        
        
        getContentPane().add( rc );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);        
    }
    
    public static void main( String args[] )
	{
    	System.out.println("OS Name: " + System.getProperty("os.name") + "\t OS Version: " + System.getProperty("os.version"));
		Boot run = new Boot();
	}
    
    
}
