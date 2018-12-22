package dev.rpg.input;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.rpg.display.Display;
import dev.rpg.entities.creatures.Player;

public class KeyBinder {
	private Display display;
	private InputMap im;
	private ActionMap ap;
	private Player player;
	private InputManager inputManager;
	
	public KeyBinder(Display display, InputManager inputManager) {
		this.display = display;
		this.inputManager = inputManager;
		init();
	}
	
	private void init() {
		im = display.getComponent().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ap = display.getComponent().getActionMap();
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "up");
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "left");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "down");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right");

		ap.put("up",  new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("up pressed");
				//inputManager.setKey(KeyEvent.VK_W, true);
			}
		});
		
		ap.put("left",  new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("left pressed");
				inputManager.setKey(KeyEvent.VK_A, true);
			}

		});
		
		ap.put("down",  new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("down pressed");
				inputManager.setKey(KeyEvent.VK_S, true);
			}
		});
		
		ap.put("right",  new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("right pressed");
				inputManager.setKey(KeyEvent.VK_D, true);
			}
		});
	}
	
}
