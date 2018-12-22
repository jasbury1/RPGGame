package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.RPG;
import dev.rpg.entities.creatures.Player;
import dev.rpg.gfx.Assets;

public class GameState extends State {
	
	private Player player;

	public GameState(RPG rpg) {
		super(rpg);
		player = new Player(rpg, 100, 100);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		player.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.face2, 0, 0, null);
		player.render(g);
	}
	
	public Player getPlayer() {
		return player;
	}

}
