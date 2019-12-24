package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Coordinate;

public class Pawn extends Piece {

    private boolean isFirstMove;

    public Pawn(PieceColor color) {
        super(color);
        isFirstMove = true;
    }

    @Override
    public void isValidMovement(Coordinate source, Coordinate dest) throws NoPieceMoveException {
        if(dest.getX() < 0 || dest.getX() > 7) {
            throw new NoPieceMoveException("Destination square outside board");
        }

        if(Math.abs(dest.getX() - source.getX()) > 0 && Math.abs(dest.getX() - source.getX()) <= 2 &&
                dest.getY() == source.getY() && isFirstMove) {
            isFirstMove = false;
            return;
        } else if(Math.abs(dest.getX() - source.getX()) == 1 && (Math.abs(dest.getY() - source.getY()) == 1)) {
            return;
        } else if(Math.abs(dest.getX() - source.getX()) == 1 && dest.getY() == source.getY()) {
            return;
        }
        throw new NoPieceMoveException("Invalid pawn movement");
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

}
