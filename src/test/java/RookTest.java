
import Game.Board;
import Game.Coordinate;
import Pieces.Rook;
import Pieces.PieceColor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RookTest extends TestCase {

    Board board;

    public RookTest(String str) {
        super(str);
        board = new Board();
        board.resetBoard();
    }

    @Test
    public void rookMovesToSourceWhichShouldNotPass() {
        Rook rook = new Rook(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertFalse(rook.isValidMovement(source,dest));
    }

    @Test
    public void rookMovesToNotValidSquareShouldNotPass() {
        Rook rook = new Rook(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 6);

        Assertions.assertFalse(rook.isValidMovement(source,dest));
    }

    @Test
    public void rookMovesForwardShouldPass() {
        Rook rook = new Rook(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 7);

        Assertions.assertTrue(rook.isValidMovement(source,dest));
    }

    @Test
    public void rookMovesBackwardShouldPass() {
        Rook rook = new Rook(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 1);

        Assertions.assertTrue(rook.isValidMovement(source,dest));
    }

    @Test
    public void rookMovesRightShouldPass() {
        Rook rook = new Rook(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(6, 3);

        Assertions.assertTrue(rook.isValidMovement(source,dest));
    }

    @Test
    public void rookMovesLeftShouldPass() {
        Rook rook = new Rook(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(0, 3);

        Assertions.assertTrue(rook.isValidMovement(source,dest));
    }

    @Test
    public void rookPathMovingForwardShouldHaveThreeElements() {
        Rook rook = new Rook(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 5);

        Coordinate[] path = rook.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(3, 4)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void rookPathMovingBackwardShouldHaveThreeElements() {
        Rook rook = new Rook(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 1);

        Coordinate[] path = rook.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(dest));
        Assertions.assertTrue(path[1].equals(new Coordinate(3, 2)));
        Assertions.assertTrue(path[2].equals(source));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void rookPathMovingRightShouldHaveThreeElements() {
        Rook rook = new Rook(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(5, 3);

        Coordinate[] path = rook.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(4, 3)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void rookPathMovingLeftShouldHaveThreeElements() {
        Rook rook = new Rook(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(1, 3);

        Coordinate[] path = rook.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(dest));
        Assertions.assertTrue(path[1].equals(new Coordinate(2, 3)));
        Assertions.assertTrue(path[2].equals(source));
        Assertions.assertEquals(path.length, 3);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new RookTest("rookMovesToSourceWhichShouldNotPass"));
        suite.addTest(new RookTest("rookMovesToNotValidSquareShouldNotPass"));
        suite.addTest(new RookTest("rookMovesForwardShouldPass"));
        suite.addTest(new RookTest("rookMovesBackwardShouldPass"));
        suite.addTest(new RookTest("rookMovesRightShouldPass"));
        suite.addTest(new RookTest("rookMovesLeftShouldPass"));
        suite.addTest(new RookTest("rookPathMovingForwardShouldHaveThreeElements"));
        suite.addTest(new RookTest("rookPathMovingBackwardShouldHaveThreeElements"));
        suite.addTest(new RookTest("rookPathMovingRightShouldHaveThreeElements"));
        suite.addTest(new RookTest("rookPathMovingLeftShouldHaveThreeElements"));

        return suite;
    }
}
