package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public class King extends Piece {

    public King(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        return false;
    }

}
