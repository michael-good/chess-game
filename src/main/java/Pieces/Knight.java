package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        return false;
    }

}
