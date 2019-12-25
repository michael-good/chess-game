
import Exceptions.InvalidMoveException;
import Game.Coordinate;
import Game.MoveParser;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MoveParserTest extends TestCase {

    public MoveParserTest(String str) {
        super(str);
    }

    @Test
    public void validInputIsSendAndShouldPass() {
        MoveParser parser = new MoveParser();
        String message = "A5";
        Coordinate coordinate = null;

        try {
            coordinate = parser.parseInputMove(message);
        } catch(Exception e){
            e.printStackTrace();
        }

        Assertions.assertTrue(coordinate.equals(new Coordinate(0, 4)));
    }

    @Test
    public void inputOfSizeOneShouldNotBeAccepted() {
        MoveParser parser = new MoveParser();
        String message = "B";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Wrong input length...Please, try again"));
    }

    @Test
    public void inputHasNotALetterInTheFirstPosition() {
        MoveParser parser = new MoveParser();
        String message = "55";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("First character must be a letter...Please, try again"));
    }

    @Test
    public void inputHasNotANumberInTheSecondPosition() {
        MoveParser parser = new MoveParser();
        String message = "AB";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Second character must be a number...Please, try again"));
    }

    @Test
    public void inputHasFileOutOfRange() {
        MoveParser parser = new MoveParser();
        String message = "J5";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("File must be a letter between 'A' and 'H'...Please, try again"));
    }

    @Test
    public void inputHasStrangeSymbolAsFileShouldNotPass() {
        MoveParser parser = new MoveParser();
        String message = "*5";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("First character must be a letter...Please, try again"));
    }

    @Test
    public void inputHasNumberInSecondPositionOutOfRangeUpperBound() {
        MoveParser parser = new MoveParser();
        String message = "B9";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Rank must be a number between 1 and 8...Please, try again"));
    }

    @Test
    public void inputHasNumberInSecondPositionOutOfRangeLowerBound() {
        MoveParser parser = new MoveParser();
        String message = "C0";

        InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
            parser.parseInputMove(message);
        });
        assertTrue(thrown.getMessage().contains("Rank must be a number between 1 and 8...Please, try again"));
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new MoveParserTest("validInputIsSendAndShouldPass"));
        suite.addTest(new MoveParserTest("inputOfSizeOneShouldNotBeAccepted"));
        suite.addTest(new MoveParserTest("inputHasNotALetterInTheFirstPosition"));
        suite.addTest(new MoveParserTest("inputHasNotANumberInTheSecondPosition"));
        suite.addTest(new MoveParserTest("inputHasFileOutOfRange"));
        suite.addTest(new MoveParserTest("inputHasStrangeSymbolAsFileShouldNotPass"));
        suite.addTest(new MoveParserTest("inputHasNumberInSecondPositionOutOfRangeUpperBound"));
        suite.addTest(new MoveParserTest("inputHasNumberInSecondPositionOutOfRangeLowerBound"));
        return suite;
    }
}
