package dev.rpg.gfx;

import dev.rpg.RPG;
import dev.rpg.entities.Entity;

public class Viewer {
	private float xOffset, yOffset;
	private RPG rpg;
	
	public Viewer(RPG rpg, float xOffset, float yOffset) {
		this.rpg = rpg;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void move(float xAmount, float yAmount) {
		xOffset += xAmount;
		yOffset += yAmount;
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - rpg.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - rpg.getHeight() / 2 + e.getHeight() / 2;
	}

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
