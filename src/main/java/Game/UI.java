package Game;

import Exceptions.InvalidMoveException;

import java.util.Scanner;

public class UI {
    private static String namePlayer1;
    private static String namePlayer2;

    public static void main(String[] args) {
        String namePlayer1, namePlayer2, move, sourcePiece;
        Scanner in = new Scanner(System.in);
        InputParser inputParser = new InputParser();
        Coordinate dest = null;
        Coordinate source = null;
        Player winner = null;
        boolean notValidMove = true;

        System.out.println("Welcome to Chess Game!" + "\n");
        System.out.println("Input name of first player: ");
        namePlayer1 = in.nextLine();
        System.out.println("Input name of second player: ");
        namePlayer2 = in.nextLine();

        Game game = new Game(namePlayer1, namePlayer2);
        GameManager gameManager = new GameManager(game);
        gameManager.getGame().startGame();
        gameManager.getGame().getBoard().printBoard();
        System.out.println("\n" + gameManager.getGame().getTurn().getName() +
                " starts playing!");

        while(winner == null) {

            while(notValidMove) {
                System.out.println("\n" + gameManager.getGame().getTurn().getName() +
                        ", select a piece to move and its destination in the 'A2:A3' format:");
                move = in.nextLine();
                try {
                    Coordinate[] coordinate = inputParser.parseInputMove(move);
                    gameManager.movePiece(coordinate[0], coordinate[1]);
                    notValidMove = false;
                } catch (InvalidMoveException e) {
                    System.err.println(e.getMessage());
                }
            }
            gameManager.getGame().passTurn();
            gameManager.getGame().getBoard().printBoard();
            notValidMove = true;
            source = null;
            dest = null;
        }
    }
}
