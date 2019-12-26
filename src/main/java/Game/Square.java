package Game;

import Pieces.Piece;

public class Square {
    private Piece piece;
    private Coordinate coordinate;

    public Square(Piece piece, Coordinate coordinate) {
        this.piece = piece;
        this.coordinate = coordinate;
    }

    public Square(Coordinate coordinate){
        this(null, coordinate);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void releaseSquare() {
        piece = null;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getPieceString() {
        if (piece == null) {
            return " ";
        }
        return piece.toString();
    }

}
