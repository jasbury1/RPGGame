package dev.rpg.entities.creatures.player_status_threads;
import dev.rpg.entities.creatures.Player;

public class HungerLoss implements Runnable {

    private Player player;
    private static final int WAIT_TIME = 3000;

    public HungerLoss(Player player) {
        this.player = player;
    }

    public void run() {
        try {
            while (player.getPlayerAlive()) {
                Thread.sleep(WAIT_TIME);
                player.loseHunger(1);
            }
        } catch (InterruptedException e) {
            System.out.println("'" + e + "' caught in HungerLoss thread. HungerLoss thread will discontinue now.");
        }
    }

}
