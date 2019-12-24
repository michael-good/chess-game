package Pieces;

import Exceptions.NoPieceMoveException;
import Game.Board;
import Game.Coordinate;

public class Rook extends Piece {

    public Rook(PieceColor color, Board board) {
        super(color, board);
    }

    @Override
    public boolean isValidMovement(Coordinate source, Coordinate dest) {
        /*
        if(!(row1 == row2 || col1==col2)){
            String msg = String.format("The movement of the rook from (%d,%d) to (%d,%d) is not legal", row1, col1, row2, col2);
            throw new NoPieceMoveException(msg);
        }
        */
        return false;
    }

}
