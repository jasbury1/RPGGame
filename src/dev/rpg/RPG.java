package dev.rpg;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.rpg.display.Display;
import dev.rpg.gfx.Assets;
import dev.rpg.gfx.ImageLoader;
import dev.rpg.gfx.SpriteSheet;

public class RPG implements Runnable{
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics graphicsObject;

	public RPG(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	//Called by the run function
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		
	}
	
	int x = 0;
	
	//Called by our runtime loop (run function)
	private void update() {
		x += 1;
	}
	
	//Called by our runtime loop (run function)
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphicsObject = bs.getDrawGraphics();
		
		//Clear the screen to prepare for drawing
		graphicsObject.clearRect(0, 0, width, height);
		
		//Drawing to the screen:
		graphicsObject.drawImage(Assets.face1, x, 10, null);
		
		//End of Drawing
		bs.show();
		graphicsObject.dispose();
	}
	
	public void run() {
		init();
		
		//amount of times to call rendering per second
		int fps = 60;
		
		//1 billion nanoseconds per second
		//calculate maximum maximum amount of times to run tick/render methods
		double timePerTick = 1_000_000_000 / fps;
		double delta = 0; //amount of time until calling render method
		long now; // Current time of our computer
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				//Time to tick and render
				update();
				render();
				ticks++;
				delta--;
			}
			
			//optional if for testing
			if(timer >= 1_000_000_000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start(); //calls the run method
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
