
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
    public void kingMovesToValidCellDiagonallyShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(1, 5);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesToValidLateralCellShouldPass() {
        King king = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertTrue(king.isValidMovement(source,dest));
    }

    @Test
    public void kingMovesToLocationOfPieceOfSameColorShouldNotPass() {
        King king = new King(PieceColor.BLACK, board);
        King kingBlack = new King(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 2);
        board.getSquare(source).setPiece(king);
        board.getSquare(dest).setPiece(kingBlack);

        Assertions.assertFalse(king.isValidMovement(source,dest));
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
        suite.addTest(new KingTest("kingMovesToValidCellDiagonallyShouldPass"));
        suite.addTest(new KingTest("kingMovesToValidLateralCellShouldPass"));
        suite.addTest(new KingTest("kingMovesToLocationOfPieceOfSameColorShouldNotPass"));
        suite.addTest(new KingTest("kingPathWhenMovementShouldHaveTwoElementsSourceAndDest"));
        return suite;
    }
}
