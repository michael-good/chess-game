package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Board;
import Game.Coordinate;

public abstract class Piece {

    protected Board board;
    PieceColor color;

    public Piece (PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public abstract boolean isValidMovement(Coordinate source, Coordinate dest);
}
