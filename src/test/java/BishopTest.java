
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
    public void whiteBishopMovesForwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(1, 1);
        Coordinate dest = new Coordinate(3, 3);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void whiteBishopMovesForwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(4, 4);
        Coordinate dest = new Coordinate(1, 7);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void whiteBishopMovesBackwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 4);
        Coordinate dest = new Coordinate(7, 0);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void whiteBishopMovesBackwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 4);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesForwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 4);
        Coordinate dest = new Coordinate(0, 1);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesForwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(6, 0);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesBackwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(5, 3);
        Coordinate dest = new Coordinate(2, 6);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesBackwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(5, 3);
        Coordinate dest = new Coordinate(7, 1);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopPathShouldHaveThreeElements() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(3, 3);
        Coordinate dest = new Coordinate(5, 5);

        Coordinate[] path = bishop.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(4, 4)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void whiteBishopPathShouldHaveThreeElements() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(4, 5);
        Coordinate dest = new Coordinate(2, 3);

        Coordinate[] path = bishop.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(dest));
        Assertions.assertTrue(path[1].equals(new Coordinate(3, 4)));
        Assertions.assertTrue(path[2].equals(source));
        Assertions.assertEquals(path.length, 3);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new BishopTest("bishopMovesToSourceWhichShouldNotPass"));
        suite.addTest(new BishopTest("bishopMovesToNotValidSquareShouldNotPass"));
        suite.addTest(new BishopTest("whiteBishopMovesForwardRightShouldPass"));
        suite.addTest(new BishopTest("whiteBishopMovesForwardLeftShouldPass"));
        suite.addTest(new BishopTest("whiteBishopMovesBackwardRightShouldPass"));
        suite.addTest(new BishopTest("whiteBishopMovesBackwardLeftShouldPass"));
        suite.addTest(new BishopTest("blackBishopMovesForwardRightShouldPass"));
        suite.addTest(new BishopTest("blackBishopMovesForwardLeftShouldPass"));
        suite.addTest(new BishopTest("blackBishopMovesBackwardRightShouldPass"));
        suite.addTest(new BishopTest("blackBishopMovesBackwardLeftShouldPass"));
        suite.addTest(new BishopTest("blackBishopPathShouldHaveThreeElements"));
        suite.addTest(new BishopTest("whiteBishopPathShouldHaveThreeElements"));

        return suite;
    }
}
