package tictactoe;

public class RandomPlayerTest {
    public static void main(String[] args) {}
    package tictactoe.players;

import tictactoe.Board;
import tictactoe.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class RandomPlayerTest {

        @Test
        void testRandomMoveIsLegal() {
            // Example: string for board setup: "XOX_O_X__"
            Board testBoard = new Board("XOX_O_X__");
            RandomPlayer player = new RandomPlayer("ComputerTest");

            Position move = player.pickNextMove(testBoard);

            // The index is unfilled for '_' chars. This board has empty at indices 3, 6, 8.
            assertTrue(testBoard.getEmptyCells().contains(move), "Move must be on an empty cell.");
        }

        // Add more tests as needed!
    }
}
