package Game;

import Pieces.PieceColor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Map<Player, List> moveHistory = new HashMap<Player, List>();
    private Map<Player, PieceColor> selectedPieceColor = new HashMap<Player, PieceColor>();

    public Game(String namePlayer1, String namePlayer2) {
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }

    public void startGame() {
        assignPieceColorToPlayer();
        board.initializeBoard();
    }

    private void assignPieceColorToPlayer() {
        if(Math.random() > 0.5) {
            player1.setColor(PieceColor.WHITE);
            player2.setColor(PieceColor.BLACK);
        } else {
            player1.setColor(PieceColor.BLACK);
            player2.setColor(PieceColor.WHITE);
        }
    }

    public Player announceWinner() {
        return null;
    }

}
