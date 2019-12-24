package Game;

import java.util.Scanner;

public class UI {
    private static String namePlayer1;
    private static String namePlayer2;

    public static void main(String[] args) {
        System.out.println("Welcome to Chess Game!" + "\n");
        System.out.println("Input name of first player: ");
        String namePlayer1, namePlayer2;
        Scanner in = new Scanner(System.in);
        namePlayer1 = in.nextLine();
        System.out.println("Input name of second player: ");
        namePlayer2 = in.nextLine();
        Game game = new Game(namePlayer1, namePlayer2);
        game.startGame();
    }
}
