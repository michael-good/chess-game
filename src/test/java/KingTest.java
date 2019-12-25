
import Game.Board;
import Game.Coordinate;
import Pieces.King;
import Pieces.Knight;
import Pieces.PieceColor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KingTest extends TestCase {

    Board board;

    public KingTest(String str) {
        super(str);
        board = new Board();
        board.resetBoard();
    }

    @Test
    public void kingMovesToSourceWhichShouldNotPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertFalse(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesToNotValidCellShouldNotPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 3);

        Assertions.assertFalse(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesForwardShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 0);
        Coordinate dest = new Coordinate(4, 1);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesForwardLeftShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 0);
        Coordinate dest = new Coordinate(3, 1);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesForwardRightShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 0);
        Coordinate dest = new Coordinate(5, 1);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesLeftShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 0);
        Coordinate dest = new Coordinate(3, 0);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesRightShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 0);
        Coordinate dest = new Coordinate(5, 0);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesBackwardShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 7);
        Coordinate dest = new Coordinate(4, 6);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesBackwardLeftShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 7);
        Coordinate dest = new Coordinate(3, 6);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesBackwardRightShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 7);
        Coordinate dest = new Coordinate(5, 6);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingPathWhenMovementShouldHaveTwoElementsSourceAndDest() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(1, 3);

        Coordinate[] path = king.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(dest));
        Assertions.assertEquals(path.length, 2);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new KingTest("kingMovesToSourceWhichShouldNotPass"));
        suite.addTest(new KingTest("kingMovesToNotValidCellShouldNotPass"));
        suite.addTest(new KingTest("kingMovesForwardShouldPass"));
        suite.addTest(new KingTest("kingMovesForwardLeftShouldPass"));
        suite.addTest(new KingTest("kingMovesForwardRightShouldPass"));
        suite.addTest(new KingTest("kingMovesLeftShouldPass"));
        suite.addTest(new KingTest("kingMovesRightShouldPass"));
        suite.addTest(new KingTest("kingMovesBackwardShouldPass"));
        suite.addTest(new KingTest("kingMovesBackwardLeftShouldPass"));
        suite.addTest(new KingTest("kingMovesBackwardRightShouldPass"));
        suite.addTest(new KingTest("kingPathWhenMovementShouldHaveTwoElementsSourceAndDest"));
        return suite;
    }
}
