
import Game.Board;
import Game.Coordinate;
import Pieces.Bishop;
import Pieces.PieceColor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BishopTest extends TestCase {

    Board board;

    public BishopTest(String str) {
        super(str);
        board = new Board();
        board.resetBoard();
    }

    @Test
    public void bishopMovesToSourceWhichShouldNotPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertFalse(bishop.isValidMovement(source,dest));
    }

    @Test
    public void bishopMovesToNotValidSquareShouldNotPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 1);
        Coordinate dest = new Coordinate(2, 6);

        Assertions.assertFalse(bishop.isValidMovement(source,dest));
    }

    @Test
    public void bishopMovesForwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(1, 1);
        Coordinate dest = new Coordinate(3, 3);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void bishopMovesForwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(4, 4);
        Coordinate dest = new Coordinate(1, 7);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void bishopMovesBackwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 4);
        Coordinate dest = new Coordinate(7, 0);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void bishopMovesBackwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 4);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void bishopPathMovingForwarLeftShouldHaveThreeElements() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(1, 5);

        Coordinate[] path = bishop.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(2, 4)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void bishopPathMovingForwardRightShouldHaveThreeElements() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(5, 5);

        Coordinate[] path = bishop.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(4, 4)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void bishopPathMovingBackwardLeftShouldHaveThreeElements() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(1, 1);

        Coordinate[] path = bishop.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(2, 2)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void bishopPathMovingBackwardRightShouldHaveThreeElements() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(5, 1);

        Coordinate[] path = bishop.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(4, 2)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new BishopTest("bishopMovesToSourceWhichShouldNotPass"));
        suite.addTest(new BishopTest("bishopMovesToNotValidSquareShouldNotPass"));
        suite.addTest(new BishopTest("bishopMovesForwardRightShouldPass"));
        suite.addTest(new BishopTest("bishopMovesForwardLeftShouldPass"));
        suite.addTest(new BishopTest("bishopMovesBackwardRightShouldPass"));
        suite.addTest(new BishopTest("bishopMovesBackwardLeftShouldPass"));
        suite.addTest(new BishopTest("bishopPathMovingForwarLeftShouldHaveThreeElements"));
        suite.addTest(new BishopTest("bishopPathMovingForwardRightShouldHaveThreeElements"));
        suite.addTest(new BishopTest("bishopPathMovingBackwardLeftShouldHaveThreeElements"));
        suite.addTest(new BishopTest("bishopPathMovingBackwardRightShouldHaveThreeElements"));

        return suite;
    }
}
