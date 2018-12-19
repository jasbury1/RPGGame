package dev.rpg.entities.creatures;

import java.awt.Graphics;

import dev.rpg.RPG;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	private RPG rpg;
	
	public Player(RPG rpg, float x, float y) {
		super(x, y);
		this.rpg = rpg;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(rpg.getKeyManager().up) {
			y -= 3;
		}
		if(rpg.getKeyManager().down) {
			y += 3;
		}
		if(rpg.getKeyManager().left) {
			x -= 3;
		}
		if(rpg.getKeyManager().right) {
			x += 3;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
	}

}
