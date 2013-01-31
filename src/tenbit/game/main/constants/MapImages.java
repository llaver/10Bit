package tenbit.game.main.constants;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class MapImages {

	public final File terrain = new File("bin/tenbit/Sprites/JPG or PNG/Terrain/");
	
	public final File rockItem = new File(terrain, "Rock.jpg");
	public final File grassTerrain = new File(terrain, "Grass.jpg");
	public final File snowTerrain = new File(terrain, "Snow.jpg");
	public final File dirtTerrain = new File(terrain, "Logo (white).png");
	
	public static BufferedImage rock;
	public static BufferedImage grass;
	public static BufferedImage snow;
	public static BufferedImage dirt;
	
	public MapImages() {
		try {
			rock = ImageIO.read(rockItem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
