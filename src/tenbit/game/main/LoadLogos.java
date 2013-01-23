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
import java.lang.Runnable;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import tenbit.game.main.constants.*;
import tenbit.game.main.engine.map.Map;
import tenbit.game.main.info.Info;

public class LoadLogos {
<<<<<<< HEAD
	private int hasRun;
	
	public LoadLogos() {
		hasRun = 0;
=======
	private boolean hasRun;
	private boolean hasTwice;
	
	public LoadLogos() {
		hasRun = false;
		hasTwice = false;
>>>>>>> 9be3996cb1a6414ef8e9723b853918aec19aa6dd
	}
	
	private void loadImage(Graphics g, BufferedImage b) {
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(b,50,50,null);
		System.out.println("loadImage reached");
	}
	
	public void paint(Graphics g) {
<<<<<<< HEAD
		try {
			if(hasRun < 2) {
				loadImage(g, MenuImages.bbLogo);
				g.drawImage(MenuImages.bbLogo,50,50,null);
=======
		//Graphics2D g2d = (Graphics2D) g;
		try {
			if(hasRun == true && hasTwice == false) {
				//loadImage(g, MenuImages.bbLogo);
				g.drawImage(MenuImages.bbLogo, 50, 50, null);
>>>>>>> 9be3996cb1a6414ef8e9723b853918aec19aa6dd
				System.out.println("1st loaded");
				
				Thread.sleep(3000);
<<<<<<< HEAD
				
				loadImage(g, MenuImages.tbLogo);
=======
				//loadImage(g, MenuImages.tbLogo);
				g.drawImage(MenuImages.tbLogo, 50, 50, null);
>>>>>>> 9be3996cb1a6414ef8e9723b853918aec19aa6dd
				System.out.println("2nd loaded");
				
				Thread.sleep(3000);
<<<<<<< HEAD
				hasRun++;
=======
				hasTwice = true;
>>>>>>> 9be3996cb1a6414ef8e9723b853918aec19aa6dd
			}
			hasRun = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
//http://www.java2s.com/Code/Java/2D-Graphics-GUI/Fadeoutanimageimagegraduallygetmoretransparentuntilitiscompletelyinvisible.htm