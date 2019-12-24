package Game;

import Pieces.PieceColor;

public class Player {
    private String name;
    private PieceColor color;

    public Player(String name) {
        this.name = name;
        color = null;
    }

    public String getName() {
        return name;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }
}
