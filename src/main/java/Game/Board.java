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
        for(int file = 0; file < 8; file++) {
            for(int rank = 0; rank < 8; rank++) {
                squares[file][rank] = new Square(new Coordinate(file, rank));
            }
        }
    }

    private void setBlackPieces() {
        squares[0][7].setPiece(new Rook(PieceColor.BLACK, this));
        squares[1][7].setPiece(new Knight(PieceColor.BLACK, this));
        squares[2][7].setPiece(new Bishop(PieceColor.BLACK, this));
        squares[3][7].setPiece(new Queen(PieceColor.BLACK, this));
        squares[4][7].setPiece(new King(PieceColor.BLACK, this));
        squares[5][7].setPiece(new Bishop(PieceColor.BLACK, this));
        squares[6][7].setPiece(new Knight(PieceColor.BLACK, this));
        squares[7][7].setPiece(new Rook(PieceColor.BLACK, this));
        squares[0][6].setPiece(new Pawn(PieceColor.BLACK, this));
        squares[1][6].setPiece(new Pawn(PieceColor.BLACK, this));
        squares[2][6].setPiece(new Pawn(PieceColor.BLACK, this));
        squares[3][6].setPiece(new Pawn(PieceColor.BLACK, this));
        squares[4][6].setPiece(new Pawn(PieceColor.BLACK, this));
        squares[5][6].setPiece(new Pawn(PieceColor.BLACK, this));
        squares[6][6].setPiece(new Pawn(PieceColor.BLACK, this));
        squares[7][6].setPiece(new Pawn(PieceColor.BLACK, this));
    }

    private void setWhitePieces() {
        squares[0][0].setPiece(new Rook(PieceColor.WHITE, this));
        squares[1][0].setPiece(new Knight(PieceColor.WHITE, this));
        squares[2][0].setPiece(new Bishop(PieceColor.WHITE, this));
        squares[3][0].setPiece(new Queen(PieceColor.WHITE, this));
        squares[4][0].setPiece(new King(PieceColor.WHITE, this));
        squares[5][0].setPiece(new Bishop(PieceColor.WHITE, this));
        squares[6][0].setPiece(new Knight(PieceColor.WHITE, this));
        squares[7][0].setPiece(new Rook(PieceColor.WHITE, this));
        squares[0][1].setPiece(new Pawn(PieceColor.WHITE, this));
        squares[1][1].setPiece(new Pawn(PieceColor.WHITE, this));
        squares[2][1].setPiece(new Pawn(PieceColor.WHITE, this));
        squares[3][1].setPiece(new Pawn(PieceColor.WHITE, this));
        squares[4][1].setPiece(new Pawn(PieceColor.WHITE, this));
        squares[5][1].setPiece(new Pawn(PieceColor.WHITE, this));
        squares[6][1].setPiece(new Pawn(PieceColor.WHITE, this));
        squares[7][1].setPiece(new Pawn(PieceColor.WHITE, this));
    }

    public void resetBoard() {
        initializeBoardSquares();       boolean isGameNotOver = true;
    }

    public void removePiece(Coordinate coordinate) {
        squares[coordinate.getFile()][coordinate.getRank()].setPiece(null);
    }

    public Square getSquare(Coordinate coordinate) {
        return squares[coordinate.getFile()][coordinate.getRank()];
    }

    public void printBoard(){
        System.out.print("\n" + "  ");
        for(int x = 0; x < 8; x++) {
            System.out.print("----");
        }
        System.out.print("\n");
        for (int y = 7; y >= 0; y--) {
            System.out.print(Integer.toString(y + 1) + " ");
            for(int x = 0; x < 8; x++) {
                System.out.print(ConsoleColors.RESET.value + "|" + ConsoleColors.RESET.value);
                if(squares[x][y].getPiece() != null && squares[x][y].getPiece().getColor().equals(PieceColor.WHITE)) {
                    System.out.print(ConsoleColors.YELLOW.value + " " + squares[x][y].getPieceString() + " " +
                            ConsoleColors.YELLOW.value);
                } else {
                    System.out.print(ConsoleColors.RESET.value + " " + squares[x][y].getPieceString() + " " +
                            ConsoleColors.RESET.value);
                }
            }
            System.out.print(ConsoleColors.RESET.value + "|" + ConsoleColors.RESET.value);
            System.out.print("\n");
            System.out.print("  ");
            for(int x = 0; x < 8; x++) {
                System.out.print("----");
            }
            System.out.print("\n");
        }
        System.out.print(" ");
        for(int x = 0; x < 8; x++) {
            System.out.print("   ");
            System.out.print((char)('A' + x));
        }
        System.out.print("\n");
    }
}
