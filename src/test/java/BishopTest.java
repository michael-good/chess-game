
import Game.Board;
import Game.Coordinate;
import Pieces.Bishop;
import Pieces.King;
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
        Coordinate dest = new Coordinate(2, 3);

        Assertions.assertFalse(bishop.isValidMovement(source,dest));
    }

    @Test
    public void whiteBishopMovesForwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(1, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void whiteBishopMovesForwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void whiteBishopMovesBackwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(1, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void whiteBishopMovesBackwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesForwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(1, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesForwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesBackwardRightShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(1, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
    }

    @Test
    public void blackBishopMovesBackwardLeftShouldPass() {
        Bishop bishop = new Bishop(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 4);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertTrue(bishop.isValidMovement(source,dest));
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

        return suite;
    }
}
