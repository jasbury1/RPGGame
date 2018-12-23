package dev.rpg.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	//load everything in the game
	private static final int width = 32, height = 32;
	
	public static BufferedImage sand, grass, player, water;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/testSpriteSheet.png"));
		
		sand = sheet.crop(0,  0,  width, height);
		grass = sheet.crop(width, 0, width, height);
		player = sheet.crop(width * 2, 0, width, height);
		water = sheet.crop(width * 3, 0, width, height);
	}
}
