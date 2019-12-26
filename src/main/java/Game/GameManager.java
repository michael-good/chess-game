package Game;

import Pieces.Piece;

public class GameManager {

    Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void movePiece(Piece piece, Coordinate source, Coordinate dest) {

    }

    public boolean checkForCheck() {
        return false;
    }
}
