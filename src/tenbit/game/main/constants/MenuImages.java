package tenbit.game.main.constants;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class MenuImages {
	
	public final File sprites = new File("10bit/Sprites/JPG or PNG/");
	public final File background = new File(sprites, "Menu Background.jpg");
	public final File menuBlack = new File(sprites, "Logo (black).png");
	public final File menuWhite = new File(sprites, "Logo (white).png");
	public final File menuOnHover = new File(sprites, "Textbox - On Hover.jpg");
	public final File menuNoHover = new File(sprites, "Textbox - No Hover.jpg");
	public final File menuHeld = new File(sprites, "Textbox - Mouse Held.jpg");
	
	public static BufferedImage backImg;
	public static BufferedImage logoBlack;
	public static BufferedImage logoWhite;
	public static BufferedImage textOnHover;
	public static BufferedImage textNoHover;
	public static BufferedImage textHeld;

	public MenuImages() throws IOException {
	    	backImg = ImageIO.read(background);
	    	logoBlack = ImageIO.read(menuBlack);
	    	logoWhite = ImageIO.read(menuWhite);
	    	textOnHover = ImageIO.read(menuOnHover);
	    	textNoHover = ImageIO.read(menuNoHover);
	    	textHeld = ImageIO.read(menuHeld);
	}

}
