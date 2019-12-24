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

        // First move
        if(Math.abs(dest.getX() - source.getX()) == 2 && dest.getY() == source.getY() &&
                (source.getX() == 1 || source.getX() == 6)) {
            if(this.color == PieceColor.BLACK) {
                return dest.getX() > source.getX();
            }
            if(this.color == PieceColor.WHITE) {
                return dest.getX() < source.getX();
            }
        }

        // Normal move
        if(Math.abs(dest.getX() - source.getX()) == 1 && dest.getY() == source.getY()) {
            if(this.color == PieceColor.BLACK) {
                return dest.getX() > source.getX();
            }
            if(this.color == PieceColor.WHITE) {
                return dest.getX() < source.getX();
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

        // TODO: Change by other piece when crosses the board

        // TODO: En passant
        return false;
    }

}
