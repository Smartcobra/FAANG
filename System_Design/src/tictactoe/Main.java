package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.model.Bot;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.strategies.winingstrategies.WiningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        try {
            int size=3;
            List<Player> players = new ArrayList<>();
            players.add(new Player());
            players.add(new Bot());

            List<WiningStrategy> winingStrategies = new ArrayList<>();


            Game game = gameController.startGame(size,players,winingStrategies);
        }catch (Exception e){
            e.printStackTrace();
        }



        System.out.println("Hello world!");
    }
}