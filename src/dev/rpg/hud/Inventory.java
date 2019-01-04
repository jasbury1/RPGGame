package dev.rpg.hud;

import dev.rpg.entities.Entity;
import dev.rpg.entities.creatures.Player;

import java.awt.*;

public class Inventory {

    private Player player;
    private Entity[] inventory = new Entity[10];

    //TODO should we make the display slightly transparent?
    private Color backgroundColor = new Color(225, 198, 153);
    private Color borderColor = new Color(140, 116, 74);

    //TODO should use the width and height of the window to calculate coords rather than specific numbers (for window resizing purposes)
    private int xCoordinate = 125;
    private int yCoordinate = 530;
    private int width = 550;
    private int height = 50;

    public Inventory(Player player) {
        this.player = player;
    }

    public void render(Graphics g) {
        g.setColor(borderColor);
        g.fillRect(xCoordinate - 3, yCoordinate - 3, width + 6, height + 6);
        g.setColor(backgroundColor);
        g.fillRect(xCoordinate, yCoordinate, width, height);
    }
}
