package Pieces;

import Game.Board;
import Game.Coordinate;

public class Knight extends Piece {

    public Knight(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        int diffX = Math.abs(dest.getX() - source.getX());
        int diffY = Math.abs(dest.getY() - source.getY());
        if(diffX + diffY == 3 && diffX != 0 && diffY != 0) return true;
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        return new Coordinate[]{source, dest};
    }

}
