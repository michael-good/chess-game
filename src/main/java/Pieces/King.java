package Pieces;

import Game.Board;
import Game.Coordinate;

public class King extends Piece {

    public King(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        if(board.getSquare(dest).isOccupied() &&
                this.color.equals(board.getSquare(dest).getPiece().getColor()))
            return false;
        int diffX = Math.abs(dest.getX() - source.getX());
        int diffY = Math.abs(dest.getY() - source.getY());
        if(diffX <= 1 && diffY <= 1 && !dest.equals(source)) return true;
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        return new Coordinate[]{source, dest};
    }

}
