package dev.rpg.input;

import java.awt.event.KeyEvent;

import dev.rpg.display.Display;

public class InputManager {
	private KeyManager km;
	private KeyBinder kb;
	private Display display;
	
	
	public boolean[] keys;
	public boolean up, down, left, right;
	
	
	public InputManager(Display display) {
		this.display = display;
		keys = new boolean[256];
		km = new KeyManager(this);
		//kb = new KeyBinder(display, this);
	}
	
	public void update() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}
	
	public void setKey(int index, boolean state) {
		keys[index] = state;
	}
	
	public boolean[] getKeys() {
		return keys;
	}
	
	public KeyManager getKeyManager() {
		return km;
	}
	
	public KeyBinder getKeyBinder() {
		return kb;
	}

}
