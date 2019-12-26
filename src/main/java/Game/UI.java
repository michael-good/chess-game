package Game;

import Exceptions.InvalidMoveException;

import java.util.Scanner;

public class UI {
    private static String namePlayer1;
    private static String namePlayer2;

    public static void main(String[] args) {
        String namePlayer1, namePlayer2, move;
        Scanner in = new Scanner(System.in);
        MoveParser inputParser = new MoveParser();
        Coordinate coordinate = null;

        System.out.println("Welcome to Chess Game!" + "\n");
        System.out.println("Input name of first player: ");
        namePlayer1 = in.nextLine();
        System.out.println("Input name of second player: ");
        namePlayer2 = in.nextLine();
        Game game = new Game(namePlayer1, namePlayer2);
        game.startGame();
        System.out.println("\n" + game.getTurn().getName() + " starts playing! Make your move in the 'A5' format:");
        boolean isGameNotOver = true;
        while(isGameNotOver) {
            while(coordinate == null) {
                move = in.nextLine();
                try {
                    coordinate = inputParser.parseInputMove(move);
                } catch (InvalidMoveException e) {
                    System.err.println(e.getMessage());
                }
            }
            game.passTurn();
            game.getBoard().printBoard();
            System.out.println("\n" + game.getTurn().getName() + " make your move in the 'A5' format:");
            coordinate = null;
        }
    }
}
