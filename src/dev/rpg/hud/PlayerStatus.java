package dev.rpg.hud;
import java.awt.*;

import dev.rpg.entities.creatures.Player;

public class PlayerStatus {

    private Player player;
    private Color backgroundColor = new Color(225, 198, 153);
    private Color borderColor = new Color(140, 116, 74);
    private Color emptyBarColor = new Color(196, 178, 147);
    private Color healthColor = new Color(229, 39, 67);
    private Color hungerColor = new Color(237, 138, 33);
    private Color playerWarmColor = new Color(32, 247, 114);
    private Color playerColdColor = new Color(19, 174, 216);
    private Color playerFreezingColor = new Color(23, 35, 168);
    private int xCoordinate = 10;
    private int yCoordinate = 10;
    private int width = 200;
    private int height = 100;

    public PlayerStatus(Player player) {
        this.player = player;
    }

    //@Override
    public void update() {
        // TODO Auto-generated method stub

    }

    //@Override
    public void render(Graphics g) {
        //Background
        g.setColor(borderColor);
        g.fillRect(xCoordinate-3, yCoordinate-3, width+6, height+6);
        g.setColor(backgroundColor);
        g.fillRect(xCoordinate, yCoordinate, width, height);

        //Health
        g.setFont(new Font("TimesRoman", Font.BOLD, 12));
        g.setColor(borderColor);
        g.drawString("Health : " + player.getHealth() + "/150", 15, 25);
        g.setColor(emptyBarColor);
        g.fillRect(xCoordinate + 20, yCoordinate + 20, 150, 10);
        g.setColor(healthColor);
        g.fillRect(xCoordinate + 20, yCoordinate + 20, player.getHealth(), 10);
        g.setColor(borderColor);
        g.drawRect(xCoordinate + 20, yCoordinate + 20, 150, 10);

        //Hunger
        g.setColor(borderColor);
        g.drawString("Hunger : " + player.getHunger() + "/150", 15, 55);
        g.setColor(emptyBarColor);
        g.fillRect(xCoordinate + 20, yCoordinate + 50, 150, 10);
        g.setColor(hungerColor);
        g.fillRect(xCoordinate + 20, yCoordinate + 50, player.getHunger(), 10);
        g.setColor(borderColor);
        g.drawRect(xCoordinate + 20, yCoordinate + 50, 150, 10);

        //Temperature
        g.setColor(borderColor);
        g.drawString("Heat : " + player.getHeat() + "/150", 15, 85);
        g.setColor(emptyBarColor);
        g.fillRect(xCoordinate + 20, yCoordinate + 80, 150, 10);
        if(player.getHeat() >= 100) {
            g.setColor(playerWarmColor);
        } else if (player.getHeat() >= 50) {
            g.setColor(playerColdColor);
        } else {
            g.setColor(playerFreezingColor);
        }
        g.fillRect(xCoordinate + 20, yCoordinate + 80, player.getHeat(), 10);
        g.setColor(borderColor);
        g.drawRect(xCoordinate + 20, yCoordinate + 80, 150, 10);
    }

}