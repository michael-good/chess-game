
import Exceptions.NoPieceMoveException;
import Game.Coordinate;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.PieceColor;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PawnTest extends TestCase {

    public PawnTest(String str) {
        super(str);
    }

    @Test
    public void coordiantesOutOfRangeShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(7, 0);
        Coordinate dest = new Coordinate(8, 0);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesTwoSquaresForwardInFirstMoveShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(1, 0);
        Coordinate dest = new Coordinate(3, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesTwoSquaresForwardInFirstMoveShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE);
        Coordinate source = new Coordinate(6, 0);
        Coordinate dest = new Coordinate(4, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesOneSquareForwardShouldPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(4, 0);
        Coordinate dest = new Coordinate(5, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesOneSquareForwardShouldPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE);
        Coordinate source = new Coordinate(5, 0);
        Coordinate dest = new Coordinate(4, 0);

        Assertions.assertTrue(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pawnMovesToRightShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(6, 0);
        Coordinate dest = new Coordinate(6, 1);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void pawnMovesToLeftShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(1, 5);
        Coordinate dest = new Coordinate(1, 4);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void blackPawnMovesBackwardsShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(1, 5);
        Coordinate dest = new Coordinate(0, 5);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    @Test
    public void whitePawnMovesBackwardsShouldNotPass() {
        Pawn pawn = new Pawn(PieceColor.WHITE);
        Coordinate source = new Coordinate(3, 2);
        Coordinate dest = new Coordinate(4, 2);

        Assertions.assertFalse(pawn.isValidMovement(source, dest));
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new PawnTest("coordiantesOutOfRangeShouldNotPass"));
        suite.addTest(new PawnTest("blackPawnMovesTwoSquaresForwardInFirstMoveShouldPass"));
        suite.addTest(new PawnTest("whitePawnMovesTwoSquaresForwardInFirstMoveShouldPass"));
        suite.addTest(new PawnTest("blackPawnMovesOneSquareForwardShouldPass"));
        suite.addTest(new PawnTest("whitePawnMovesOneSquareForwardShouldPass"));
        suite.addTest(new PawnTest("pawnMovesToRightShouldNotPass"));
        suite.addTest(new PawnTest("pawnMovesToLeftShouldNotPass"));
        suite.addTest(new PawnTest("blackPawnMovesBackwardsShouldNotPass"));
        suite.addTest(new PawnTest("whitePawnMovesBackwardsShouldNotPass"));
        return suite;
    }
}
