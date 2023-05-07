package tictactoe.model;

import tictactoe.exception.DuplicateSymbolsException;
import tictactoe.exception.MoreThanOneBotException;
import tictactoe.exception.PlayersCountDimensionMismatchException;
import tictactoe.strategies.winingstrategies.WiningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private  int nextMovePlayerIndex;
    private List<WiningStrategy> winingStrategies;

    private Game(int size, List<Player> players,List<WiningStrategy> winingStrategies){
        this.nextMovePlayerIndex=0;
        this.gameState=GameState.IN_PROGRESS;
        this.moves= new ArrayList<>();
        this.board = new Board(size);
        this.players=players;
        this.winingStrategies=winingStrategies;
    }


    public static Builder getBuilder() {
        return new Builder();
    }
    public static class  Builder{
        private List<Player> players = new ArrayList<>();
        private List<WiningStrategy> winingStrategies = new ArrayList<>();
        private int size;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWiningStrategies(List<WiningStrategy> winingStrategies) {
            this.winingStrategies = winingStrategies;
            return this;
        }

        public Builder addPlayer(Player player){   // provide builder class to add individual player
            this.players.add(player);
            return this;
        }

        public Builder addStrategy(WiningStrategy winingStrategy){
            this.winingStrategies.add(winingStrategy);
            return this;
        }

        private void validateBotCounts() throws MoreThanOneBotException {
            int botCount=0;
            for (Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount+=1;
                }
            }

            if(botCount>1) throw new MoreThanOneBotException();

        }
        private void validateDimensionAndPlayersCount() throws PlayersCountDimensionMismatchException {
           if(players.size() !=size-1){
               throw new PlayersCountDimensionMismatchException();
           }
        }

        public void validateUniqueSymbolsForPlayer() throws DuplicateSymbolsException {
             Map<Character,Integer> symbolCount= new HashMap<>();

             for(Player player:players){
                 if(!symbolCount.containsKey(player.getSymbol().getaChar())){
                     symbolCount.put(player.getSymbol().getaChar(),0);
                 }
                 symbolCount.put(player.getSymbol().getaChar(), symbolCount.get(player.getSymbol().getaChar())+1);

                 if(symbolCount.get(player.getSymbol().getaChar())>1){
                        throw new DuplicateSymbolsException();
                 }
             }
        }

        public Game build() throws MoreThanOneBotException, PlayersCountDimensionMismatchException, DuplicateSymbolsException {
            validateBotCounts();
            validateDimensionAndPlayersCount();
            validateUniqueSymbolsForPlayer();
            return new Game(size,players,winingStrategies);
        }


    }



    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WiningStrategy> getWiningStrategies() {
        return winingStrategies;
    }

    public void setWiningStrategies(List<WiningStrategy> winingStrategies) {
        this.winingStrategies = winingStrategies;
    }
}
