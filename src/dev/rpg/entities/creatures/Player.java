package dev.rpg.entities.creatures;

import java.awt.Graphics;

import dev.rpg.RPG;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	private RPG rpg;
	private static final int MOVE_DELTA = 3;
	
	public Player(RPG rpg, float x, float y) {
		super(x, y);
		this.rpg = rpg;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		if(rpg.getInputManager().up) {
			y -= MOVE_DELTA;
		}
		if(rpg.getInputManager().down) {
			y += MOVE_DELTA;
		}
		if(rpg.getInputManager().left) {
			x -= MOVE_DELTA;
		}
		if(rpg.getInputManager().right) {
			x += MOVE_DELTA;
		}
	}
	
	public void moveUp() {
		y -= MOVE_DELTA;
	}
	
	public void moveDown() {
		y += MOVE_DELTA;
	}
	
	public void moveLeft() {
		x -= MOVE_DELTA;
	}
	
	public void moveRight() {
		x += MOVE_DELTA;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
	}

}
