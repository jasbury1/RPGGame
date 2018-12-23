package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.RPG;
import dev.rpg.entities.creatures.Player;
import dev.rpg.gfx.Assets;
import dev.rpg.tiles.Tile;
import dev.rpg.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;

	public GameState(RPG rpg) {
		super(rpg);
		player = new Player(rpg, 100, 100);
		world = new World(rpg, "res/worlds/world1.txt");
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		world.update();
		player.update();
			}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
	
	public Player getPlayer() {
		return player;
	}

}
