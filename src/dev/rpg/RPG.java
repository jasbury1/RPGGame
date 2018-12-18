package dev.rpg;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.rpg.display.Display;
import dev.rpg.gfx.ImageLoader;

public class RPG implements Runnable{
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics graphicsObject;
	
	private BufferedImage testImage;
	
	public RPG(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	//Called by the run function
	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/textures/boat.png");
	}
	
	//Called by our runtime loop (run function)
	private void update() {
		
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
		graphicsObject.drawImage(testImage,  20,  20,  null);
		
		//End of Drawing
		bs.show();
		graphicsObject.dispose();
	}
	
	public void run() {
		init();
		
		while(running) {
			update();
			render();
		}
		
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
