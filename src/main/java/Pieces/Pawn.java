package Pieces;

import Game.Board;
import Game.Coordinate;

public class Pawn extends Piece {

    public Pawn(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        if(dest.getX() < 0 || dest.getX() > 7 || source.equals(dest)) {
            return false;
        }

        if(!board.getSquare(dest).isOccupied()) {
            // First move
            if (Math.abs(dest.getX() - source.getX()) == 2 && dest.getY() == source.getY() &&
                    (source.getX() == 1 || source.getX() == 6)) {
                if (this.color == PieceColor.BLACK &&
                        !board.getSquare(new Coordinate(source.getX() + 1, source.getY())).isOccupied()) {
                    return dest.getX() > source.getX();
                }
                if (this.color == PieceColor.WHITE &&
                        !board.getSquare(new Coordinate(source.getX() - 1, source.getY())).isOccupied()) {
                    return dest.getX() < source.getX();
                }
            }

            // Normal move
            if (Math.abs(dest.getX() - source.getX()) == 1 && dest.getY() == source.getY()) {
                if (this.color == PieceColor.BLACK) {
                    return dest.getX() > source.getX();
                }
                if (this.color == PieceColor.WHITE) {
                    return dest.getX() < source.getX();
                }
            }
        }

        // Capture move
        if(Math.abs(dest.getX() - source.getX()) == 1 && Math.abs(dest.getY() - source.getY()) == 1 &&
                board.getSquare(dest).isOccupied()) {
            if(this.color == PieceColor.BLACK) {
                return dest.getX() > source.getX() && board.getSquare(dest).getPiece().getColor() == PieceColor.WHITE;
            }
            if(this.color == PieceColor.WHITE) {
                return dest.getX() < source.getX() && board.getSquare(dest).getPiece().getColor() == PieceColor.BLACK;
            }
        }

        // TODO: Promotion

        // TODO: En passant
        return false;
    }

    public Coordinate[] getPath(Coordinate source, Coordinate dest) {
        if(source.getY() != dest.getY()) {
            return new Coordinate[]{source, dest};
        } else {
            int pathLength = Math.abs(dest.getX() - source.getX()) + 1;
            Coordinate[] path = new Coordinate[pathLength];
            for(int i = 0; i < pathLength; i++) {
                if(this.color == PieceColor.BLACK) {
                    path[i] = new Coordinate(source.getX() + i, source.getY());
                } else if(this.color == PieceColor.WHITE) {
                    path[i] = new Coordinate(source.getX() - i, source.getY());
                }
            }
            return path;
        }
    }

}
