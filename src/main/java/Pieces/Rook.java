package Pieces;

import Game.Board;
import Game.Coordinate;

public class Rook extends Piece {

    public Rook(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        int diffFiles = Math.abs(dest.getFile() - source.getFile());
        int diffRanks = Math.abs(dest.getRank() - source.getRank());
        if((diffFiles == 0 && diffRanks != 0) || (diffFiles != 0 && diffRanks == 0)) return true;
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        int pathLength = Math.max(Math.abs(dest.getFile() - source.getFile()), Math.abs(dest.getRank() - source.getRank())) + 1;
        Coordinate[] path = new Coordinate[pathLength];
        for(int i = 0; i < pathLength; i++) {
            if(dest.getFile() == source.getFile()) {
                path[i] = new Coordinate(source.getFile(), Math.min(dest.getRank(), source.getRank()) + i);
            } else if(dest.getRank() == source.getRank()) {
                path[i] = new Coordinate(Math.min(dest.getRank(), source.getFile()) + i, source.getRank());
            }
        }
        return path;
    }

}
