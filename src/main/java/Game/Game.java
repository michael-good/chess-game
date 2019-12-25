package Game;

import Pieces.PieceColor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player turn;
    private Map<Player, List> moveHistory = new HashMap<Player, List>();
    private Map<Player, PieceColor> selectedPieceColor = new HashMap<Player, PieceColor>();

    public Game(String namePlayer1, String namePlayer2) {
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }

    public void startGame() {
        assignPieceColorToPlayer();
        tellPlayersAssignedPieceColors();
        board = new Board();
        board.initializeBoard();
    }

    private void assignPieceColorToPlayer() {
        if(Math.random() > 0.5) {
            player1.setColor(PieceColor.WHITE);
            turn = player1;
            player2.setColor(PieceColor.BLACK);
        } else {
            player1.setColor(PieceColor.BLACK);
            player2.setColor(PieceColor.WHITE);
            turn = player2;
        }
    }

    private void tellPlayersAssignedPieceColors() {
        System.out.println(player1.getName() + " owns pieces of color " + player1.getColor().toString());
        System.out.println(player2.getName() + " owns pieces of color " + player2.getColor().toString());
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getTurn() {
        return turn;
    }

    public Player announceWinner() {
        return null;
    }

}
