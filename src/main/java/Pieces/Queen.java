package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public class Queen extends Piece {

    public Queen(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        return false;
    }

}
