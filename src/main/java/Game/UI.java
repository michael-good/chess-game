package Game;

import Exceptions.InvalidMoveException;

import java.util.Scanner;

public class UI {
    private static String namePlayer1;
    private static String namePlayer2;

    public static void main(String[] args) {
        String namePlayer1, namePlayer2, moveSource, moveDest, sourcePiece;
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
                        ", select a piece to move in the 'A5' format:");
                moveSource = in.nextLine();
                System.out.println("\n" + gameManager.getGame().getTurn().getName() +
                        ", make a move in the 'A5' format:");
                moveDest = in.nextLine();
                try {
                    source = inputParser.parseInputMove(moveSource);
                    dest = inputParser.parseInputMove(moveDest);
                    gameManager.movePiece(source, dest);
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
