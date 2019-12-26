
import Exceptions.InvalidMoveException;
import Game.Coordinate;
import Game.InputParser;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InputParserTest extends TestCase {

    public InputParserTest(String str) {
        super(str);
    }

    @Test
    public void validInputIsSendAndShouldPass() {
        InputParser parser = new InputParser();
        String message = "A5:A6";
        Coordinate[] coordinate= new Coordinate[2];

        try {
            coordinate = parser.parseInputMove(message);
        } catch(Exception e){
            e.printStackTrace();
        }

        Assertions.assertTrue(coordinate[0].equals(new Coordinate(0, 4)));
        Assertions.assertTrue(coordinate[1].equals(new Coordinate(0, 5)));
    }

    @Test
    public void inputOfSizeOneShouldNotBeAccepted() {
        InputParser parser = new InputParser();
        String message = "B:5";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Wrong input length...Please, try again"));
    }

    @Test
    public void inputHasNotALetterInTheFirstPosition() {
        InputParser parser = new InputParser();
        String message = "55:B2";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("First character must be a letter...Please, try again"));
    }

    @Test
    public void inputHasNotANumberInTheSecondPosition() {
        InputParser parser = new InputParser();
        String message = "A3:AA";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Second character must be a number...Please, try again"));
    }

    @Test
    public void inputHasFileOutOfRange() {
        InputParser parser = new InputParser();
        String message = "J5:A3";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("File must be a letter between 'A' and 'H'...Please, try again"));
    }

    @Test
    public void inputHasStrangeSymbolAsFileShouldNotPass() {
        InputParser parser = new InputParser();
        String message = "*5:A6";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("First character must be a letter...Please, try again"));
    }

    @Test
    public void inputHasNumberInSecondPositionOutOfRangeUpperBound() {
        InputParser parser = new InputParser();
        String message = "B9:B8";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Rank must be a number between 1 and 8...Please, try again"));
    }

    @Test
    public void inputHasNumberInSecondPositionOutOfRangeLowerBound() {
        InputParser parser = new InputParser();
        String message = "A3:C0";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Rank must be a number between 1 and 8...Please, try again"));
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new InputParserTest("validInputIsSendAndShouldPass"));
        suite.addTest(new InputParserTest("inputOfSizeOneShouldNotBeAccepted"));
        suite.addTest(new InputParserTest("inputHasNotALetterInTheFirstPosition"));
        suite.addTest(new InputParserTest("inputHasNotANumberInTheSecondPosition"));
        suite.addTest(new InputParserTest("inputHasFileOutOfRange"));
        suite.addTest(new InputParserTest("inputHasStrangeSymbolAsFileShouldNotPass"));
        suite.addTest(new InputParserTest("inputHasNumberInSecondPositionOutOfRangeUpperBound"));
        suite.addTest(new InputParserTest("inputHasNumberInSecondPositionOutOfRangeLowerBound"));
        return suite;
    }
}
