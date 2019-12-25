
import Game.Board;
import Game.Coordinate;
import Pieces.Knight;
import Pieces.PieceColor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KnightTest extends TestCase {

    Board board;

    public KnightTest(String str) {
        super(str);
        board = new Board();
        board.resetBoard();
    }

    @Test
    public void knightMovesToSourceWhichShouldNotPass() {
        Knight knight = new Knight(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertFalse(knight.isValidMovement(source,dest));
    }

    @Test
    public void knightMovesToNotValidCellShouldNotPass() {
        Knight knight = new Knight(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 3);

        Assertions.assertFalse(knight.isValidMovement(source,dest));
    }

    @Test
    public void knightMovesToValidCellShouldPass() {
        Knight knight = new Knight(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 2);

        Assertions.assertTrue(knight.isValidMovement(source,dest));
    }

    @Test
    public void knightMovesToLocationOfPieceOfSameColorShouldNotPass() {
        Knight knight = new Knight(PieceColor.BLACK, board);
        Knight knightBlack = new Knight(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 2);
        board.getSquare(source).setPiece(knight);
        board.getSquare(dest).setPiece(knightBlack);

        Assertions.assertFalse(knight.isValidMovement(source,dest));
    }

    @Test
    public void knightPathWhenMovementShouldHaveTwoElementsSourceAndDest() {
        Knight knight = new Knight(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(1, 3);

        Coordinate[] path = knight.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(dest));
        Assertions.assertEquals(path.length, 2);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new KnightTest("knightMovesToSourceWhichShouldNotPass"));
        suite.addTest(new KnightTest("knightMovesToNotValidCellShouldNotPass"));
        suite.addTest(new KnightTest("knightMovesToValidCellShouldPass"));
        suite.addTest(new KnightTest("knightMovesToLocationOfPieceOfSameColorShouldNotPass"));
        suite.addTest(new KnightTest("knightPathWhenMovementShouldHaveTwoElementsSourceAndDest"));
        return suite;
    }
}
