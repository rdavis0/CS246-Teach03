package hyer;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("jake", 5, 4, 6);

        Game game = new Game(player);
        game.saveGame();
        Game newGame = game.loadGame("game.txt");
        System.out.println(game.player.gold);
    }
}
