package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public void isValidMovement(Coordinate source, Coordinate dest) throws NoPieceMoveException {
    }

}
