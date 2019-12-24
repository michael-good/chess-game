package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public class Queen extends Piece {

    public Queen(PieceColor color) {
        super(color);
    }

    @Override
    public void isValidMovement(Coordinate source, Coordinate dest) throws NoPieceMoveException {
    }

}
