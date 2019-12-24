package Pieces;

import Game.Board;
import Game.Coordinate;

public class King extends Piece {

    public King(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        return false;
    }

}