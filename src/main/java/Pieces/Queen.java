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
        return false;
    }

}
