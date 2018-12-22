package dev.rpg.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	private InputManager inputManager;
	
	public KeyManager(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed");
		inputManager.setKey(e.getKeyCode(), true);	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
		inputManager.setKey(e.getKeyCode(), false);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}
	

}
