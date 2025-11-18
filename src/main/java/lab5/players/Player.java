package lab5.players;

import lab5.game.Board;
import lab5.game.Position;

public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public abstract Position pickNextMove(Board currentBoard);
}