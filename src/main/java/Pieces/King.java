package Pieces;

import Game.Board;
import Game.Coordinate;

public class King extends Piece {

    public King(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        int diffFiles = Math.abs(dest.getFile() - source.getFile());
        int diffRanks = Math.abs(dest.getRank() - source.getRank());
        if(diffFiles <= 1 && diffRanks <= 1 && !dest.equals(source)) return true;
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        return new Coordinate[]{source, dest};
    }

}
