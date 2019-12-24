package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Board;
import Game.Coordinate;

public abstract class Piece {

    protected Board board;
    PieceColor color;

    public Piece (PieceColor color, Board board) {
        this.color = color;
        this.board = board;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public abstract boolean isValidMovement(Coordinate source, Coordinate dest);
}
