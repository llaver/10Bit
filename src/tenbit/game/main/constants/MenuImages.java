package tenbit.game.main.constants;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public final class MenuImages {
	
	public final File sprites = new File("10bit/src/tenbit/Sprites/JPG or PNG/");	
	public final File buttons = new File("10bit/src/tenbit/Sprites/JPG or PNG/Main Menu/Titled Buttons/");	
	
	private final File background = new File(sprites, "Main Menu/Menu Background.jpg");
	public final File menuBlack = new File(sprites, "Logo (black).png");
	public final File menuWhite = new File(sprites, "Logo (white).png");
	public final File menuOnHover = new File(sprites, "Main Menu/Untitled Textboxes/Textbox - On Hover.jpg");
	public final File menuNoHover = new File(sprites, "Main Menu/Untitled Textboxes/Textbox - No Hover.jpg");
	public final File menuHeld = new File(sprites, "Main Menu/Untitled Textboxes/Textbox - Mouse Held.jpg");
	
	public File[] titledButtonsDirectories;
	public static Map<File, Set<File>> allTitleButtons = new HashMap<File, Set<File>>();
	
	public static BufferedImage backImg;
	public static BufferedImage logoBlack;
	public static BufferedImage logoWhite;
	public static BufferedImage textOnHover;
	public static BufferedImage textNoHover;
	public static BufferedImage textHeld;
	
	public static BufferedImage[] menuButtons;

	public MenuImages() throws IOException {
		
		titledButtonsDirectories = buttons.listFiles();
		
		for (int i = 0; i < buttons.listFiles().length; i++) {
			Set<File> titledButtons = new HashSet<File>();
			
			File[] temp = new File[(int) titledButtonsDirectories[i].length()];
			
			System.out.println(titledButtonsDirectories[i].toString());
			temp = titledButtonsDirectories[i].listFiles();			
			for (int j = 0; j < titledButtonsDirectories[i].listFiles().length; j++) {
				titledButtons.add(temp[j]);
				System.out.println("\t" + temp[j].toString());
				
			}
			allTitleButtons.put(titledButtonsDirectories[i], titledButtons);
		}
		
	    	backImg = ImageIO.read(background);
	    	logoBlack = ImageIO.read(menuBlack);
	    	logoWhite = ImageIO.read(menuWhite);
	    	textOnHover = ImageIO.read(menuOnHover);
	    	textNoHover = ImageIO.read(menuNoHover);
	    	textHeld = ImageIO.read(menuHeld);
	}

}
