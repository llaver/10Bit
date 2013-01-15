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
	private boolean hasRun;
	
	File f = new File("10Bit/src/tenbit/Sprites/JPG or PNG/Credits/");
	File f1 = new File(f, "BitBlit Logo/Final BitBlit Logo.png");
	File f2 = new File(f, "10bit Logo/Final 10bit Logo.png");
	
	private BufferedImage bbLogo;
	private BufferedImage tenbLogo;
	
	public LoadLogos() throws IOException {
		hasRun = false;
		bbLogo = ImageIO.read(f1);
		tenbLogo = ImageIO.read(f2);
	}
	
	private void loadImage(Graphics g, BufferedImage b) {
		
	}
	
	public void paint(Graphics g) {
		try {
			if(hasRun == false) {
				//loadImage(g, bbLogo);
				Thread.sleep(5000);
				//loadImage(g, tenbLogo);
				hasRun = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
//http://www.java2s.com/Code/Java/2D-Graphics-GUI/Fadeoutanimageimagegraduallygetmoretransparentuntilitiscompletelyinvisible.htm