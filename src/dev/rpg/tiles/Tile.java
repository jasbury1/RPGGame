package dev.rpg.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile sandTile = new Sand(0);
	public static Tile grassTile = new Grass(1);
	public static Tile waterTile = new Water(2);
	
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public boolean isSolid() {
		return false;
	}
	
	//GETTERS AND SETTERS
	
	public int getId() {
		return id;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	
}
