
import Game.Board;
import Game.Coordinate;
import Pieces.Pawn;
import Pieces.PieceColor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PawnTest extends TestCase {

    Board board;

    public PawnTest(String str) {
        super(str);
        board = new Board();
        board.initializeBoard();
    }

    @Test
    public void coordiantesOutOfRangeShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(7, 0);
        Coordinate dest = new Coordinate(8, 0);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesTwoSquaresForwardInFirstMoveShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 0);
        Coordinate dest = new Coordinate(3, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesTwoSquaresForwardInFirstMoveShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(6, 0);
        Coordinate dest = new Coordinate(4, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesTwoSquaresForwardInFirstMoveWithPieceInFrontShouldNotPass() {
        Pawn pawnBlack = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 0);
        Coordinate dest = new Coordinate(3, 0);
        Pawn pawnWhite = new Pawn(PieceColor.WHITE, board);
        board.getSquare(new Coordinate(2, 0)).setPiece(pawnWhite);

        Assertions.assertFalse(pawnBlack.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesTwoSquaresForwardInFirstMoveWithPieceInFrontShouldNotPass() {
        Pawn pawnBlack = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(6, 0);
        Coordinate dest = new Coordinate(4, 0);
        Pawn pawnWhite = new Pawn(PieceColor.BLACK, board);
        board.getSquare(new Coordinate(5, 0)).setPiece(pawnWhite);

        Assertions.assertFalse(pawnBlack.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesOneSquareForwardShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 0);
        Coordinate dest = new Coordinate(5, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesOneSquareForwardShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(5, 0);
        Coordinate dest = new Coordinate(4, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pawnMovesToRightShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(6, 0);
        Coordinate dest = new Coordinate(6, 1);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pawnMovesToLeftShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 5);
        Coordinate dest = new Coordinate(1, 4);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesBackwardsShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(1, 5);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesBackwardsShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(3, 2);
        Coordinate dest = new Coordinate(4, 2);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnCapturesFrontRightShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 3);
        Coordinate dest = new Coordinate(5, 2);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.WHITE, board));

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnCapturesFrontRightShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(6, 5);
        Coordinate dest = new Coordinate(5, 6);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.BLACK, board));

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnCapturesFrontLeftShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(4, 3);
        Coordinate dest = new Coordinate(5, 4);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.WHITE, board));

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnCapturesFrontLeftShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(6, 5);
        Coordinate dest = new Coordinate(5, 4);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.BLACK, board));

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnCapturesPieceOfSameColorShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK, board);
        Coordinate source = new Coordinate(6, 5);
        Coordinate dest = new Coordinate(5, 4);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.BLACK, board));

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnCapturesPieceOfSameColorShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(6, 5);
        Coordinate dest = new Coordinate(5, 4);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.WHITE, board));

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pathWhenCapturingShouldBeSourceAndDest() {
        Pawn pawn = new Pawn(PieceColor.WHITE, board);
        Coordinate source = new Coordinate(6, 5);
        Coordinate dest = new Coordinate(5, 4);
        board.getSquare(source).setPiece(pawn);
        board.getSquare(dest).setPiece(new Pawn(PieceColor.WHITE, board));

        Coordinate[] path = pawn.getPath(source, dest);

        Assertions.assertTrue(path[0].equals(source));
        Assertions.assertTrue(path[1].equals(dest));
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new PawnTest("coordiantesOutOfRangeShouldNotPass"));
        suite.addTest(new PawnTest("blackPawnMovesTwoSquaresForwardInFirstMoveShouldPass"));
        suite.addTest(new PawnTest("whitePawnMovesTwoSquaresForwardInFirstMoveShouldPass"));
        suite.addTest(new PawnTest("blackPawnMovesTwoSquaresForwardInFirstMoveWithPieceInFrontShouldNotPass"));
        suite.addTest(new PawnTest("whitePawnMovesTwoSquaresForwardInFirstMoveWithPieceInFrontShouldNotPass"));
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
        suite.addTest(new PawnTest("blackPawnCapturesPieceOfSameColorShouldNotPass"));
        suite.addTest(new PawnTest("whitePawnCapturesPieceOfSameColorShouldNotPass"));
        suite.addTest(new PawnTest("pathWhenCapturingShouldBeSourceAndDest"));
        return suite;
    }
}
