package hyer;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Game {

    Player player;

    public Game(Player player) {
        this.player = player;
    }

    public void saveGame(){
        Gson gson = new Gson();
        String playerJson = gson.toJson(player);
        try {
            Files.writeString(Path.of("game.txt"), playerJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Game loadGame(String s){
        Gson gson = new Gson();
        String data = new String();
        File file = new File(s);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Player player = gson.fromJson(data, Player.class);
        Game game = new Game(player);
        return game;
    }
}
