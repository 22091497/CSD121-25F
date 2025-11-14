package tictactoe.players;

import java.util.List;
import java.util.Random;

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
