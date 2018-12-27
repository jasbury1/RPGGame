package dev.rpg.gfx;

import dev.rpg.Handler;
import dev.rpg.RPG;
import dev.rpg.entities.Entity;
import dev.rpg.tiles.Tile;

public class Viewer {
	private float xOffset, yOffset;
	private Handler handler;
	
	public Viewer(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void move(float xAmount, float yAmount) {
		xOffset += xAmount;
		yOffset += yAmount;
	}
	
	public void checkEdges() {
		if(xOffset < 0) {
			xOffset = 0;
		}
		else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
		}
		if(yOffset < 0) {
			yOffset = 0;
		}
		else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
		}
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkEdges();
	}

	
	//GETTERS AND SETTERS
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
