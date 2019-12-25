package Game;

import Exceptions.InvalidMoveException;

public class MoveParser {

    String move;

    public MoveParser() {}

    public Coordinate parseInputMove(String inputMove) throws InvalidMoveException{
        move = inputMove.toLowerCase();
        isInputValid();
        int file = Character.getNumericValue(move.charAt(0)) - Character.getNumericValue('a');
        int rank = Character.getNumericValue(move.charAt(1));
        isOuputValid(file, rank);
        return new Coordinate(file, rank - 1);
    }

    private void isInputValid() throws InvalidMoveException {
        if(move.length() != 2)
            throw new InvalidMoveException("Wrong input length...Please, try again");
        if(!Character.isLetter(move.charAt(0)))
            throw new InvalidMoveException("First character must be a letter...Please, try again");
        if(!Character.isDigit(move.charAt(1)))
            throw new InvalidMoveException("Second character must be a number...Please, try again");
    }

    private void isOuputValid(int file, int rank) throws InvalidMoveException {
        if(file < 0 || file > 7)
            throw new InvalidMoveException("File must be a letter between 'A' and 'H'...Please, try again");
        if(rank < 1 || rank > 8)
            throw new InvalidMoveException("Rank must be a number between 1 and 8...Please, try again");
    }

}
