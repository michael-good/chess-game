package Pieces;

import Game.Board;
import Game.Coordinate;

public class Pawn extends Piece {

    public Pawn(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        if(source.equals(dest)) return false;

        // First move
        if (Math.abs(dest.getRank() - source.getRank()) == 2 && dest.getFile() == source.getFile() &&
                (source.getRank() == 1 || source.getRank() == 6)) {
            if (this.color == PieceColor.BLACK) {
                return dest.getRank() < source.getRank();
            }
            if (this.color == PieceColor.WHITE) {
                return dest.getRank() > source.getRank();
            }
        }

        // Normal move
        if (Math.abs(dest.getRank() - source.getRank()) == 1 && dest.getFile() == source.getFile()) {
            if (this.color == PieceColor.BLACK) {
                return dest.getRank() < source.getRank();
            }
            if (this.color == PieceColor.WHITE) {
                return dest.getRank() > source.getRank();
            }
        }

        // Capture move
        if(Math.abs(dest.getFile() - source.getFile()) == 1 && Math.abs(dest.getRank() - source.getRank()) == 1) {
            if (this.color == PieceColor.BLACK) {
                return dest.getRank() < source.getRank();
            }
            if (this.color == PieceColor.WHITE) {
                return dest.getRank() > source.getRank();
            }
        }

        // TODO: Promotion

        // TODO: En passant
        return false;
    }

    @Override
    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        if(source.getFile() != dest.getFile()) {
            return new Coordinate[]{source, dest};
        } else {
            int pathLength = Math.abs(dest.getRank() - source.getRank()) + 1;
            Coordinate[] path = new Coordinate[pathLength];
            for(int i = 0; i < pathLength; i++) {
                path[i] = new Coordinate(source.getFile(), Math.min(dest.getRank(), source.getRank()) + i);
            }
            return path;
        }
    }

    @Override
    public String toString() {
        return "P";
    }

}
