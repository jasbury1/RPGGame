package dev.rpg.entities;

import java.awt.Graphics;

import dev.rpg.RPG;

public abstract class Entity {
	
	protected RPG rpg;
	protected float x, y;
	protected int width, height;
	
	public Entity(RPG rpg, float x, float y, int width, int height) {
		this.rpg = rpg;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void render(Graphics g);

}
