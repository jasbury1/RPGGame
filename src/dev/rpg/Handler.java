/*
 * A way of passing around both the rpg object and the world
 * Uselful for collision detection and general class organization
 */

package dev.rpg;

import dev.rpg.gfx.Viewer;
import dev.rpg.input.InputManager;
import dev.rpg.worlds.World;

public class Handler {
	private RPG rpg;
	private World world;

	public Handler(RPG rpg) {
		this.rpg = rpg;
	}
	
	public int getWidth() {
		return rpg.getWidth();
	}
	
	public int getHeight() {
		return rpg.getHeight();
	}
	
	public InputManager getInputManager() {
		return rpg.getInputManager();
	}
	
	public Viewer getGameViewer() {
		return rpg.getGameViewer();
	}
	
	public RPG getRpg() {
		return rpg;
	}

	public void setRpg(RPG rpg) {
		this.rpg = rpg;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
