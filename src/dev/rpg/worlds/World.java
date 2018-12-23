package dev.rpg.worlds;

import java.awt.Graphics;

import dev.rpg.RPG;
import dev.rpg.tiles.Tile;
import dev.rpg.util.Utils;

public class World {

	private RPG rpg;
	//measured in tiles
	private int width, height;
	private int spawnX, spawnY;
	//tiles and positions
	private int[][] tiles;
	
	public World(RPG rpg, String path) {
		this.rpg = rpg;
		loadWorld(path);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		//Limit rendering to what the user can "see"
		int xStart = (int)(Math.max(0, rpg.getGameViewer().getxOffset() / Tile.TILE_WIDTH));
		int xEnd = (int)(Math.min(width, (rpg.getGameViewer().getxOffset() + rpg.getWidth()) / Tile.TILE_WIDTH + 1));
		int yStart = (int)(Math.max(0, rpg.getGameViewer().getyOffset() / Tile.TILE_HEIGHT));
		int yEnd = (int)(Math.min(height, (rpg.getGameViewer().getyOffset() + rpg.getHeight()) / Tile.TILE_HEIGHT + 1));
		
		for(int y = yStart; y < yEnd; ++y) {
			for(int x = xStart; x < xEnd; ++x) {
				getTile(x, y).render(g,  (int)(x * Tile.TILE_WIDTH - rpg.getGameViewer().getxOffset()),  
						(int)(y * Tile.TILE_HEIGHT - rpg.getGameViewer().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.waterTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; ++y) {
			for(int x = 0; x < width; ++x) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
			}
		}
		
	}
	
}
