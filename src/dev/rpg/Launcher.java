package dev.rpg;

import dev.rpg.display.Display;

/*
 * This class just starts up the game
 */

public class Launcher {
	
	public static void main(String[] args) {
		System.out.println("Starting up the launcher..");
		RPG game = new RPG("TITLE GOES HERE", 800, 600);
		game.start();
	}

}
