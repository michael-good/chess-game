package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest){
        return false;
    }

}
