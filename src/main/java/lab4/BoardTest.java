package lab4;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
//
//    @Test
//    public void testInitialState() {
//        Board board = new Board();
//        // Check that all positions are initially empty
//        for (int row = 0; row < board.getRowCount(); row++) {
//            for (int col = 0; col < board.getColumnCount(); col++) {
//                assertNull(board.getPieceAt(row, col), "Expected position to be empty at start");
//            }
//        }
//    }
//
//    @Test
//    public void testAddPieceAndRetrieve() {
//        Board board = new Board();
//        board.placePiece(0, 0, Player.X);
//        assertEquals(Player.X, board.getPieceAt(0, 0));
//    }
//
//    @Test
//    public void testCannotPlaceOnOccupiedSpot() {
//        Board board = new Board();
//        board.placePiece(0, 0, Player.X);
//        Exception ex = assertThrows(IllegalArgumentException.class,
//                () -> board.placePiece(0, 0, Player.O));
//        assertTrue(ex.getMessage().toLowerCase().contains("occupied"));
//    }
//
//    @Test
//    public void testBoundaryConditions() {
//        Board board = new Board();
//        // Negative indices
//        assertThrows(IndexOutOfBoundsException.class, () -> board.getPieceAt(-1, 0));
//        assertThrows(IndexOutOfBoundsException.class, () -> board.getPieceAt(0, -1));
//        // Out-of-range indices
//        assertThrows(IndexOutOfBoundsException.class, () -> board.getPieceAt(board.getRowCount(), 0));
//        assertThrows(IndexOutOfBoundsException.class, () -> board.getPieceAt(0, board.getColumnCount()));
//    }
//
//    @Test
//    public void testResetBoard() {
//        Board board = new Board();
//        board.placePiece(0, 0, Player.X);
//        board.reset();
//        for (int row = 0; row < board.getRowCount(); row++) {
//            for (int col = 0; col < board.getColumnCount(); col++) {
//                assertNull(board.getPieceAt(row, col), "Expected position to be empty after reset");
//            }
//        }
//    }
//
//    @Test
//    public void testWinConditionRow() {
//        Board board = new Board();
//        for (int col = 0; col < board.getColumnCount(); col++) {
//            board.placePiece(0, col, Player.X);
//        }
//        assertTrue(board.checkWin(Player.X));
//    }
//
//    @Test
//    public void testNoFalseWinOnPartial() {
//        Board board = new Board();
//        board.placePiece(0, 0, Player.X);
//        assertFalse(board.checkWin(Player.X));
//    }

    // Add more tests for public methods as described by your JavaDoc
}