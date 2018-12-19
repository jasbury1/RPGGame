package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.RPG;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
		
	//CLASS
	
	protected RPG rpg;
	
	public State (RPG rpg) {
		this.rpg = rpg;
	}
	
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}
