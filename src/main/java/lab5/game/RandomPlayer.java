package lab5.game;

import java.util.List;
import java.util.Random;
import lab5.players.Player;
import lab5.game.Board;
import lab5.game.Position;



public class RandomPlayer extends Player {

    private static final Random rng = new Random();

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        List<Position> empty = currentBoard.getEmptyCells();
        return empty.get(rng.nextInt(empty.size())); // Pick random empty cell
    }
}
