package dev.rpg.entities.creatures.player_status_threads;
import dev.rpg.entities.creatures.Player;

public class HeatAdjust implements Runnable {

    private Player player;

    public HeatAdjust(Player player) {
        this.player = player;
    }

    public void run() {
        /* TODO need to add time to the world and calculate a temperature based on what time it is
        try {
            while (player.getPlayerAlive()) {
                Thread.sleep(3000);
                player.adjustHeat();
            }
        } catch (InterruptedException e) {
            System.out.println("'" + e + "' caught in HungerLoss thread. HungerLoss thread will discontinue now.");
        }
        */
    }

}
