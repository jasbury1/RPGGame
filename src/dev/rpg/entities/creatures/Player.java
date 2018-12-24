package dev.rpg.entities.creatures;

import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.RPG;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	private static final int MOVE_DELTA = 3;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void update() {
		/*if(rpg.getInputManager().up) {
			y -= MOVE_DELTA;
		}*/
		
		getInput();
		move();
		handler.getGameViewer().centerOnEntity(this);
		
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getInputManager().up) {
			yMove = -speed;
		}
		if(handler.getInputManager().down) {
			yMove = speed;
		}
		if(handler.getInputManager().left) {
			xMove = -speed;
		}
		if(handler.getInputManager().right) {
			xMove = speed;
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
		g.drawImage(Assets.player, (int)(x - handler.getGameViewer().getxOffset()), (int)(y - handler.getGameViewer().getyOffset()), width, height, null);
	}

}
