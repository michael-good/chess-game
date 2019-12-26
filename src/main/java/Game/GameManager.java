package Game;

import Exceptions.InvalidMoveException;
import Pieces.Piece;

public class GameManager {

    Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void movePiece(Coordinate source, Coordinate dest) throws InvalidMoveException {
        Piece sourcePiece = game.getBoard().getSquare(source).getPiece();
        Piece destPiece = game.getBoard().getSquare(dest).getPiece();

        // Check source is valid
        if(sourcePiece == null)
            throw new InvalidMoveException("There is no piece on the source square provided... Please, try again");
        if(sourcePiece.getColor() != game.getTurn().getColor())
            throw new InvalidMoveException("Selected piece does not belong to you... Please, try again");

        // Check if the movement is valid
        boolean isValidMovement = sourcePiece.isValidMovement(source, dest);
        boolean isCapture = false;

        // Check if is capture
        if(destPiece != null) {
            if (sourcePiece.getColor() != destPiece.getColor()) {
                isCapture = true;
            }
        }

        // Check if path is free
        Coordinate[] path = sourcePiece.getPath(source, dest);
        for(Coordinate coord : path) {
            if(game.getBoard().getSquare(coord).isOccupied()) {
                if (!(game.getBoard().getSquare(coord).getPiece().equals(sourcePiece) ||
                        game.getBoard().getSquare(coord).getPiece().equals(destPiece))) {
                    throw new InvalidMoveException("Wrong move... Please, try again");
                }
            }
        }

        // Make the move
        if(isValidMovement) {
            game.getBoard().getSquare(source).releaseSquare();
            if(isCapture) {
                game.getBoard().getSquare(dest).releaseSquare();
                game.getBoard().getSquare(dest).setPiece(sourcePiece);
            } else if(!game.getBoard().getSquare(dest).isOccupied())
                game.getBoard().getSquare(dest).setPiece(sourcePiece);
        } else {
            throw new InvalidMoveException("Movement is not valid for the selected piece... Please, try again");
        }
    }

    public boolean checkForCheck() {
        return false;
    }
}
