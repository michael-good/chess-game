package Pieces;

import Game.Board;
import Game.Coordinate;

public class Knight extends Piece {

    public Knight(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        int diffFiles = Math.abs(dest.getFile() - source.getFile());
        int diffRanks = Math.abs(dest.getRank() - source.getRank());
        if(diffFiles + diffRanks == 3 && diffFiles != 0 && diffRanks != 0) return true;
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        return new Coordinate[]{source, dest};
    }

    @Override
    public String toString() {
        return "C";
    }

}
