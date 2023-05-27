package tictactoe.controller;

import tictactoe.exception.DuplicateSymbolsException;
import tictactoe.exception.MoreThanOneBotException;
import tictactoe.exception.PlayersCountDimensionMismatchException;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.strategies.winingstrategies.WiningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int boardSize, List<Player> players, List<WiningStrategy> winingStrategies) throws PlayersCountDimensionMismatchException, DuplicateSymbolsException, MoreThanOneBotException {
    return Game.getBuilder().
            setPlayers(players)
            .setSize(boardSize)
            .setWiningStrategies(winingStrategies)
            .build();


    }

    public void makeMove(Game game){

    }

    public  void undo(Game game){

    }

    public void checkState(Game game){

    }

    public void getWinner(Game game){

    }

    public void printBoard(Game game){

    }
}
