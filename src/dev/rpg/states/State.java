package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.Handler;
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
	
	protected Handler handler;
	
	public State (Handler handler) {
		this.handler = handler;
	}
	
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}
