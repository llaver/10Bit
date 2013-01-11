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
	private int i;
	
	public LoadLogos() {
		i = 0;
	}
	
	private void w() {
		try {
			System.out.println("run " + i);
			Thread.sleep(5000);
			i++;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		if(i < 2) {
			if(i == 0) {
				w();
			}
			if(i == 1) {
				w();
			}
		}
	}
}
//http://www.java2s.com/Code/Java/2D-Graphics-GUI/Fadeoutanimageimagegraduallygetmoretransparentuntilitiscompletelyinvisible.htm