package dev.rpg.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.rpg.Handler;
import dev.rpg.entities.creatures.Player;

public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
	}
	
	public void update() {
		for(int i = 0; i < entities.size(); ++i) {
			Entity e = entities.get(i);
			e.update();
		}
		player.update();
	}

	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
		player.render(g);
	}
	
	public void addEntity(Entity newEntity) {
		entities.add(newEntity);
	}
	
	//GETTERS AND SETTERS
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
