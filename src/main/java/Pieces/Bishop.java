package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Board;
import Game.Coordinate;

public class Bishop extends Piece {

    public Bishop(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest){
        int diffFiles = Math.abs(dest.getFile() - source.getFile());
        int diffRanks = Math.abs(dest.getRank() - source.getRank());
        if(diffFiles == diffRanks && !dest.equals(source)) return true;
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        int pathLength = Math.abs(dest.getFile() - source.getFile()) + 1;
        Coordinate[] path = new Coordinate[pathLength];
        int sign_files = Integer.signum(dest.getFile() - source.getFile());
        int sign_ranks = Integer.signum(dest.getRank() - source.getRank());
        for(int i = 0; i < pathLength; i++) {
            path[i] = new Coordinate(source.getFile() + sign_files*i, source.getRank() + sign_ranks*i);
        }
        return path;
    }
}
