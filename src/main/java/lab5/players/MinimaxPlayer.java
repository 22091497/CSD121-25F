package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.PlayerToken;

public class MinimaxPlayer extends Player {

    private PlayerToken myToken;
    private PlayerToken opponentToken;

    public MinimaxPlayer(String name, PlayerToken myToken) {
        super(name);
        this.myToken = myToken;
        this.opponentToken = (myToken == PlayerToken.X) ? PlayerToken.O : PlayerToken.X;
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        int bestScore = Integer.MIN_VALUE;
        Position bestMove = null;

        for (Position move : currentBoard.getEmptyCells()) {
            Board newBoard = new Board(currentBoard);
            newBoard.placeNextToken(move, myToken);

            int score = minimax(newBoard, false);
            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private int minimax(Board board, boolean isMaximizing) {
        var status = board.getStatus();

        if (status == Board.Status.XWins) {
            return (myToken == PlayerToken.X) ? 10 : -10;
        } else if (status == Board.Status.OWins) {
            return (myToken == PlayerToken.O) ? 10 : -10;
        } else if (status == Board.Status.Draw) {
            return 0;
        }

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            for (Position move : board.getEmptyCells()) {
                Board newBoard = new Board(board);
                newBoard.placeNextToken(move, myToken);
                int eval = minimax(newBoard, false);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else { // Minimizing opponent's move
            int minEval = Integer.MAX_VALUE;
            for (Position move : board.getEmptyCells()) {
                Board newBoard = new Board(board);
                newBoard.placeNextToken(move, opponentToken);
                int eval = minimax(newBoard, true);
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }
}