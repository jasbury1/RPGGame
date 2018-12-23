package dev.rpg.tiles;

import java.awt.image.BufferedImage;

import dev.rpg.gfx.Assets;

public class Water extends Tile {

	public Water(int id) {
		super(Assets.water, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
