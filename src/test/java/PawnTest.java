
import Game.Board;
import Game.Coordinate;
import Pieces.Pawn;
import Pieces.PieceColor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PawnTest extends TestCase {

    Board board;

    public PawnTest(String str) {
        super(str);
        board = new Board();
        board.resetBoard();

    }

    @Test
    public void pawnRemainsInSameSquareShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(7, 1);
        Coordinate dest = new Coordinate(7, 1);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesTwoSquaresForwardInFirstMoveShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 6);
        Coordinate dest = new Coordinate(1, 4);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesTwoSquaresForwardInFirstMoveShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(4, 1);
        Coordinate dest = new Coordinate(4, 3);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesOneSquareForwardShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 6);
        Coordinate dest = new Coordinate(4, 5);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesOneSquareForwardShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(5, 1);
        Coordinate dest = new Coordinate(5, 2);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pawnMovesToRightShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(5, 1);
        Coordinate dest = new Coordinate(6, 1);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pawnMovesToLeftShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 5);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesBackwardsShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(0, 6);
        Coordinate dest = new Coordinate(0, 7);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesBackwardsShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 2);
        Coordinate dest = new Coordinate(3, 1);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnCapturesFrontRightShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 6);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnCapturesFrontRightShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 5);
        Coordinate dest = new Coordinate(2, 6);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnCapturesFrontLeftShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 6);
        Coordinate dest = new Coordinate(2, 5);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnCapturesFrontLeftShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(1, 1);
        Coordinate dest = new Coordinate(0, 2);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pathWhenCapturingShouldBeSourceAndDest() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(1, 1);
        Coordinate dest = new Coordinate(0, 2);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.WHITE, board));

        Coordinate[] path = pawn.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(dest));
        Assertions.assertEquals(path.length, 2);
    }

    @Test
    public void pathWhenNormalMovementShouldHaveTwoElements() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(6, 4);
        Coordinate dest = new Coordinate(6, 5);

        Coordinate[] path = pawn.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(dest));
        Assertions.assertEquals(path.length, 2);
    }

    @Test
    public void whitePawnPathWhenFirstMovementShouldHaveThreeElements() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(1, 1);
        Coordinate dest = new Coordinate(1, 3);

        Coordinate[] path = pawn.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(new Coordinate(source.getFile(), source.getRank() + 1)));
        Assertions.assertTrue(path[2].equals(dest));
        Assertions.assertEquals(path.length, 3);
    }

    @Test
    public void blackPawnPathWhenFirstMovementShouldHaveThreeElements() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 6);
        Coordinate dest = new Coordinate(1, 4);

        Coordinate[] path = pawn.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(dest));
        Assertions.assertTrue(path[1].equals(new Coordinate(source.getFile(), source.getRank() - 1)));
        Assertions.assertTrue(path[2].equals(source));
        Assertions.assertEquals(path.length, 3);
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new PawnTest("pawnRemainsInSameSquareShouldNotPass"));
        suite.addTest(new PawnTest("blackPawnMovesTwoSquaresForwardInFirstMoveShouldPass"));
        suite.addTest(new PawnTest("whitePawnMovesTwoSquaresForwardInFirstMoveShouldPass"));
        suite.addTest(new PawnTest("blackPawnMovesOneSquareForwardShouldPass"));
        suite.addTest(new PawnTest("whitePawnMovesOneSquareForwardShouldPass"));
        suite.addTest(new PawnTest("pawnMovesToRightShouldNotPass"));
        suite.addTest(new PawnTest("pawnMovesToLeftShouldNotPass"));
        suite.addTest(new PawnTest("blackPawnMovesBackwardsShouldNotPass"));
        suite.addTest(new PawnTest("whitePawnMovesBackwardsShouldNotPass"));
        suite.addTest(new PawnTest("blackPawnCapturesFrontRightShouldPass"));
        suite.addTest(new PawnTest("whitePawnCapturesFrontRightShouldPass"));
        suite.addTest(new PawnTest("blackPawnCapturesFrontLeftShouldPass"));
        suite.addTest(new PawnTest("whitePawnCapturesFrontLeftShouldPass"));
        suite.addTest(new PawnTest("pathWhenCapturingShouldBeSourceAndDest"));
        suite.addTest(new PawnTest("pathWhenNormalMovementShouldHaveTwoElements"));
        suite.addTest(new PawnTest("whitePawnPathWhenFirstMovementShouldHaveThreeElements"));
        suite.addTest(new PawnTest("blackPawnPathWhenFirstMovementShouldHaveThreeElements"));
        return suite;
    }
}
