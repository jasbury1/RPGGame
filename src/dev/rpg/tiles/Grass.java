package dev.rpg.tiles;

import java.awt.image.BufferedImage;

import dev.rpg.gfx.Assets;

public class Grass extends Tile {

	public Grass(int id) {
		super(Assets.grass, id);
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
