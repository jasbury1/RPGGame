package dev.rpg.entities.creatures;

import java.awt.Graphics;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import dev.rpg.Handler;
import dev.rpg.entities.creatures.player_status_threads.HungerLoss;
import dev.rpg.gfx.Assets;
import dev.rpg.hud.PlayerStatusDisplay;
import dev.rpg.worlds.World;

public class Player extends Creature{

	private static final int MOVE_DELTA = 3;
	private static final int PLAYER_MAX_HEALTH = 150;
	private static final int PLAYER_MAX_HUNGER = 150;
	private static final int PLAYER_MAX_HEAT = 150;
	private World world;
	private int hunger, heat;
	private float armor;
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean playerAlive = true;
	//HUD
	private PlayerStatusDisplay playerStatusDisplay;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 21;
		bounds.y = 32;
		bounds.width = 28;
		bounds.height = 32;
		world = handler.getWorld();
		health = PLAYER_MAX_HEALTH;
		hunger = PLAYER_MAX_HUNGER;
		heat = PLAYER_MAX_HEAT;
		armor = 1;

		playerStatusDisplay = new PlayerStatusDisplay(this);

		//Threads to change hunger and heat
		HungerLoss hungerLoss = new HungerLoss(this);
		Thread thread = new Thread(hungerLoss);
		thread.start();
	}

	@Override
	public void update() {
		lock.lock();
		try {
		/*if(rpg.getInputManager().up) {
			y -= MOVE_DELTA;
		}*/

			getInput();
			move();
			handler.getGameViewer().centerOnEntity(this);
		} finally {
			lock.unlock();
		}
		
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

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)(x - handler.getGameViewer().getxOffset()), (int)(y - handler.getGameViewer().getyOffset()), width, height, null);

		/* Uncomment to see hitbox
		g.setColor(Color.red);
		g.fillRect((int)(x + bounds.x - handler.getGameViewer().getxOffset()), 
				(int)(y + bounds.y - handler.getGameViewer().getyOffset()),
				bounds.width, bounds.height);
				*/
		playerStatusDisplay.render(g);
	}

	public void takeDamage(int damageAmount) {
		lock.lock();
		try {
			health -= damageAmount / armor;
			if(health < 0) {
				health = 0;
				playerAlive = false;
			}
		} finally {
			lock.unlock();
		}
	}

	public void heal(int healAmount) {
		lock.lock();
		try {
			health += healAmount;
			if(health > PLAYER_MAX_HEALTH) {
				health = PLAYER_MAX_HEALTH;
			}
		} finally {
			lock.unlock();
		}
	}

	//Manual movement functions
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

	public void gainHunger(int hungerGained) {
		lock.lock();
		try {
			hunger += hungerGained;
			if (hunger > PLAYER_MAX_HUNGER) {
				hunger = PLAYER_MAX_HUNGER;
			}
		} finally {
			lock.unlock();
		}
	}

	public void loseHunger(int hungerLost) {
		lock.lock();
		try {
			hunger -= hungerLost;
			if (hunger < 0) {
				hunger = 0;
				this.takeDamage(1);
			}
		} finally {
			lock.unlock();
		}
	}
	/* TODO need to add time to the world and calculate a temperature based on what time it is
	public void adjustHeat() {
		if(heat < handler.getWorld().getTemperature()) {
			gainHeat(1);
		}
		else if (heat > handler.getWorld().getTemperature()) {
			loseHeat(1);
		}
	}
	*/
	public void gainHeat(int heatGained) {
		lock.lock();
		try {
			heat += heatGained;
			if (heat > PLAYER_MAX_HEAT) {
				heat = PLAYER_MAX_HEAT;
			}
		} finally {
			lock.unlock();
		}
	}

	public void loseHeat(int heatLost) {
		lock.lock();
		try {
			heat -= heatLost;
			if (heat < 0) {
				heat = 0;
				this.takeDamage(1);
			}
		} finally {
			lock.unlock();
		}
	}

	public int getHunger() {
		lock.lock();
		try {
			return hunger;
		} finally {
			lock.unlock();
		}
	}

	public int getHeat() {
		lock.lock();
		try {
			return heat;
		} finally {
			lock.unlock();
		}
	}

	public boolean getPlayerAlive() {
		return playerAlive;
	}

	public ReentrantLock getLock() {
		return lock;
	}

	public Condition getCondition() {
		return condition;
	}
}
