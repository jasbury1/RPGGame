package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.gfx.Assets;

public class GameState extends State {

	public GameState() {
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.face2, 0, 0, null);
		
	}

}
