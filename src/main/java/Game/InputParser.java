package Game;

import Exceptions.InvalidMoveException;

public class InputParser {

    String move;

    public InputParser() {}

    public Coordinate[] parseInputMove(String inputMove) throws InvalidMoveException{
        move = inputMove.toLowerCase();
        isInputMoveValid();
        int file_source = Character.getNumericValue(move.charAt(0)) - Character.getNumericValue('a');
        int rank_source = Character.getNumericValue(move.charAt(1));
        int file_dest = Character.getNumericValue(move.charAt(3)) - Character.getNumericValue('a');
        int rank_dest = Character.getNumericValue(move.charAt(4));
        isOuputMoveValid(file_source, rank_source);
        isOuputMoveValid(file_dest, rank_dest);
        return new Coordinate[]{new Coordinate(file_source, rank_source - 1),
                new Coordinate(file_dest, rank_dest - 1) };
    }

    private void isInputMoveValid() throws InvalidMoveException {
        if(move.length() != 5)
            throw new InvalidMoveException("Wrong input length...Please, try again");
        if(!Character.isLetter(move.charAt(0)) || !Character.isLetter(move.charAt(3)))
            throw new InvalidMoveException("First character must be a letter...Please, try again");
        if(!Character.isDigit(move.charAt(1)) || !Character.isDigit(move.charAt(4)))
            throw new InvalidMoveException("Second character must be a number...Please, try again");
    }

    private void isOuputMoveValid(int file, int rank) throws InvalidMoveException {
        if(file < 0 || file > 7)
            throw new InvalidMoveException("File must be a letter between 'A' and 'H'...Please, try again");
        if(rank < 1 || rank > 8)
            throw new InvalidMoveException("Rank must be a number between 1 and 8...Please, try again");
    }

}
