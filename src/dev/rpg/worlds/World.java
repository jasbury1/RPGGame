package dev.rpg.worlds;

import java.awt.Graphics;
import java.time.LocalTime;

import dev.rpg.Handler;
import dev.rpg.RPG;
import dev.rpg.entities.EntityManager;
import dev.rpg.entities.creatures.Player;
import dev.rpg.entities.statics.Tree;
import dev.rpg.tiles.Tile;
import dev.rpg.util.Utils;
import dev.rpg.hud.PlayerStatusDisplay;

public class World {

	private Handler handler;
	//measured in tiles
	private int width, height;
	private int spawnX, spawnY;
	//tiles and positions
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	//HUD
	private PlayerStatusDisplay playerStatusDisplay;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		Player player = new Player(handler, 100, 100);
		entityManager = new EntityManager(handler, player);
		entityManager.addEntity(new Tree(handler, 9*64, 7 * 64));
		playerStatusDisplay = new PlayerStatusDisplay(player);
		
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void update() {
		entityManager.update();
		playerStatusDisplay.update();
	}
	
	public void render(Graphics g) {
		//Limit rendering to what the user can "see"
		int xStart = (int)(Math.max(0, handler.getGameViewer().getxOffset() / Tile.TILE_WIDTH));
		int xEnd = (int)(Math.min(width, (handler.getGameViewer().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1));
		int yStart = (int)(Math.max(0, handler.getGameViewer().getyOffset() / Tile.TILE_HEIGHT));
		int yEnd = (int)(Math.min(height, (handler.getGameViewer().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1));
		//loop to render view
		for(int y = yStart; y < yEnd; ++y) {
			for(int x = xStart; x < xEnd; ++x) {
				getTile(x, y).render(g,  (int)(x * Tile.TILE_WIDTH - handler.getGameViewer().getxOffset()),  
						(int)(y * Tile.TILE_HEIGHT - handler.getGameViewer().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
		//HUD
		playerStatusDisplay.render(g);
	}
	

	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			//Emergency default to prevent errors
			return Tile.waterTile;
		}
		
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
	
	//GETTERS AND SETTERS
	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
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

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
}
