package Game;

import Pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Square[][] squares;
    private List<Piece> removedPieces = new ArrayList<Piece>();

    public Board(){
        squares = new Square[8][8];
    }

    public void initializeBoard() {
        initializeBoardSquares();
        setBlackPieces();
        setWhitePieces();
    }

    private void initializeBoardSquares() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                squares[x][y] = new Square(new Coordinate(x, y));
            }
        }
    }

    private void setBlackPieces() {
        squares[0][0].setPiece(new Rook(PieceColor.BLACK));
        squares[0][1].setPiece(new Knight(PieceColor.BLACK));
        squares[0][2].setPiece(new Bishop(PieceColor.BLACK));
        squares[0][3].setPiece(new Queen(PieceColor.BLACK));
        squares[0][4].setPiece(new King(PieceColor.BLACK));
        squares[0][5].setPiece(new Bishop(PieceColor.BLACK));
        squares[0][6].setPiece(new Knight(PieceColor.BLACK));
        squares[0][7].setPiece(new Rook(PieceColor.BLACK));
        squares[1][0].setPiece(new Pawn(PieceColor.BLACK));
        squares[1][1].setPiece(new Pawn(PieceColor.BLACK));
        squares[1][2].setPiece(new Pawn(PieceColor.BLACK));
        squares[1][3].setPiece(new Pawn(PieceColor.BLACK));
        squares[1][4].setPiece(new Pawn(PieceColor.BLACK));
        squares[1][5].setPiece(new Pawn(PieceColor.BLACK));
        squares[1][6].setPiece(new Pawn(PieceColor.BLACK));
        squares[1][7].setPiece(new Pawn(PieceColor.BLACK));
    }

    private void setWhitePieces() {
        squares[7][0].setPiece(new Rook(PieceColor.WHITE));
        squares[7][1].setPiece(new Knight(PieceColor.WHITE));
        squares[7][2].setPiece(new Bishop(PieceColor.WHITE));
        squares[7][3].setPiece(new Queen(PieceColor.WHITE));
        squares[7][4].setPiece(new King(PieceColor.WHITE));
        squares[7][5].setPiece(new Bishop(PieceColor.WHITE));
        squares[7][6].setPiece(new Knight(PieceColor.WHITE));
        squares[7][7].setPiece(new Rook(PieceColor.WHITE));
        squares[6][0].setPiece(new Pawn(PieceColor.WHITE));
        squares[6][1].setPiece(new Pawn(PieceColor.WHITE));
        squares[6][2].setPiece(new Pawn(PieceColor.WHITE));
        squares[6][3].setPiece(new Pawn(PieceColor.WHITE));
        squares[6][4].setPiece(new Pawn(PieceColor.WHITE));
        squares[6][5].setPiece(new Pawn(PieceColor.WHITE));
        squares[6][6].setPiece(new Pawn(PieceColor.WHITE));
        squares[6][7].setPiece(new Pawn(PieceColor.WHITE));
    }

    public void movePiece(PieceColor color, int sourceX, int sourceY, int destX, int destY) {

    }

    public boolean checkForCheck() {
        return false;
    }

    public void removePiece(int sourceX, int sourceY) {
        squares[sourceX][sourceY].setPiece(null);
    }
}
