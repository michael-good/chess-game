package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public abstract class Piece {

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

    public abstract void isValidMovement(Coordinate source, Coordinate dest) throws NoPieceMoveException;
}
