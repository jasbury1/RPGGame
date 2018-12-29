package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.RPG;
import dev.rpg.entities.creatures.Player;
import dev.rpg.entities.statics.Tree;
import dev.rpg.gfx.Assets;
import dev.rpg.tiles.Tile;
import dev.rpg.worlds.World;

public class GameState extends State {
	
	//private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		world.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}


}
