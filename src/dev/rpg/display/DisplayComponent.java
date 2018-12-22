package dev.rpg.display;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class DisplayComponent extends JComponent{
	public void paint(Graphics g) {
	    g.setColor(Color.red);
	    g.fillOval(50, 10, 150, 150);
	  }

}
