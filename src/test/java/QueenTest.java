import Game.Board;
import Game.Coordinate;
import Pieces.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class QueenTest extends TestCase {

    Board board;

    public QueenTest(String str) {
        super(str);
        board = new Board();
        board.resetBoard();
    }

    @Test
    public void queenMovesToSourceWhichShouldNotPass() {
        Queen queen = new Queen(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertFalse(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesToNotValidSquareShouldNotPass() {
        Queen queen = new Queen(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 6);

        Assertions.assertFalse(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesForwardRightShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(1, 1);
        Coordinate dest = new Coordinate(3, 3);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesForwardLeftShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(4, 4);
        Coordinate dest = new Coordinate(1, 7);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesBackwardRightShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 4);
        Coordinate dest = new Coordinate(7, 0);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesBackwardLeftShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 4);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesForwardShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 7);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesBackwardShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 1);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesRightShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(6, 3);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenMovesLeftShouldPass() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(0, 3);

        Assertions.assertTrue(queen.isValidMovement(source,dest));
    }

    @Test
    public void queenPathMovingForwardShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 5);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(3, 4)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void queenPathMovingBackwardShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(3, 1);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(dest));
        Assertions.assertTrue(path[1].equals(new Coordinate(3, 2)));
        Assertions.assertTrue(path[2].equals(source));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void queenPathMovingRightShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(5, 3);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(4, 3)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void queenPathMovingLeftShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(1, 3);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(dest));
        Assertions.assertTrue(path[1].equals(new Coordinate(2, 3)));
        Assertions.assertTrue(path[2].equals(source));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void queenPathMovingForwarLeftShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(1, 5);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(2, 4)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void queenPathMovingForwardRightShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(5, 5);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(4, 4)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void queenPathMovingBackwardLeftShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(1, 1);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(2, 2)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void queenPathMovingBackwardRightShouldHaveThreeElements() {
        Queen queen = new Queen(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(5, 1);

        Coordinate[] path = queen.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(4, 2)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new QueenTest("queenMovesToSourceWhichShouldNotPass"));
        suite.addTest(new QueenTest("queenMovesToNotValidSquareShouldNotPass"));
        suite.addTest(new QueenTest("queenMovesForwardShouldPass"));
        suite.addTest(new QueenTest("queenMovesBackwardShouldPass"));
        suite.addTest(new QueenTest("queenMovesRightShouldPass"));
        suite.addTest(new QueenTest("queenMovesLeftShouldPass"));
        suite.addTest(new QueenTest("queenPathMovingForwardShouldHaveThreeElements"));
        suite.addTest(new QueenTest("queenPathMovingBackwardShouldHaveThreeElements"));
        suite.addTest(new QueenTest("queenPathMovingRightShouldHaveThreeElements"));
        suite.addTest(new QueenTest("queenPathMovingLeftShouldHaveThreeElements"));
        suite.addTest(new QueenTest("queenPathMovingForwarLeftShouldHaveThreeElements"));
        suite.addTest(new QueenTest("queenPathMovingForwardRightShouldHaveThreeElements"));
        suite.addTest(new QueenTest("queenPathMovingBackwardLeftShouldHaveThreeElements"));
        suite.addTest(new QueenTest("queenPathMovingBackwardRightShouldHaveThreeElements"));

        return suite;
    }
}
