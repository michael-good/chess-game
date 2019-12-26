package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Board;
import Game.Coordinate;

public class Queen extends Piece {

    public Queen(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        int diffFiles = Math.abs(dest.getFile() - source.getFile());
        int diffRanks = Math.abs(dest.getRank() - source.getRank());
        if((diffFiles == 0 && diffRanks != 0) || (diffFiles != 0 && diffRanks == 0)) return true;
        if(diffFiles == diffRanks && !dest.equals(source)) return true;
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        int diffFiles = Math.abs(dest.getFile() - source.getFile());
        int diffRanks = Math.abs(dest.getRank() - source.getRank());
        Coordinate[] path = null;
        if((diffFiles == 0 && diffRanks != 0) || (diffFiles != 0 && diffRanks == 0)) {
            int pathLength = Math.max(Math.abs(dest.getFile() - source.getFile()),
                                Math.abs(dest.getRank() - source.getRank())) + 1;
            path = new Coordinate[pathLength];
            for (int i = 0; i < pathLength; i++) {
                if (dest.getFile() == source.getFile()) {
                    path[i] = new Coordinate(source.getFile(), Math.min(dest.getRank(), source.getRank()) + i);
                } else if (dest.getRank() == source.getRank()) {
                    path[i] = new Coordinate(Math.min(dest.getFile(), source.getFile()) + i, source.getRank());
                }
            }
        }
        if(diffFiles == diffRanks && !dest.equals(source)) {
            int pathLength = Math.abs(dest.getFile() - source.getFile()) + 1;
            path = new Coordinate[pathLength];
            int sign_files = Integer.signum(dest.getFile() - source.getFile());
            int sign_ranks = Integer.signum(dest.getRank() - source.getRank());
            for(int i = 0; i < pathLength; i++) {
                path[i] = new Coordinate(source.getFile() + sign_files*i, source.getRank() + sign_ranks*i);
            }
        }
        return path;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
