package dev.rpg.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.gfx.Assets;
import dev.rpg.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, 100);
		bounds.x = 2;
		bounds.y = 70;
		bounds.width = 60;
		bounds.height = 32;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x - handler.getGameViewer().getxOffset()), (int)(y - handler.getGameViewer().getyOffset()), width, height, null);
		
	}

}
