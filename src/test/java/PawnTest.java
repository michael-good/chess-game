
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
    public void coordiantesOutOfRangeShouldRaiseException() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(7, 0);
        Coordinate dest = new Coordinate(8, 0);

        NoPieceMoveException e = assertThrows(NoPieceMoveException.class,
                ()->{
                    pawn.isValidMovement(source, dest);
                });
        Assertions.assertTrue(e.getMessage().contains("Destination square outside board"));
    }

    @Test
    public void pawnMovesTwoSquaresForwardInFirstMoveShouldNotRaiseException() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(1, 0);
        Coordinate dest = new Coordinate(3, 0);

        try {
            pawn.isValidMovement(source, dest);
        } catch (NoPieceMoveException e) {
            fail("NoPieceMoveException should not be raised");
        }
    }

    @Test
    public void pawnMovesOneSquareForwardShouldNotRaiseException() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        pawn.setFirstMove(false);
        Coordinate source = new Coordinate(6, 0);
        Coordinate dest = new Coordinate(5, 0);

        try {
            pawn.isValidMovement(source, dest);
        } catch (NoPieceMoveException e) {
            fail("NoPieceMoveException should not be raised");
        }
    }

    @Test
    public void pawnMovesToRightShouldRaiseException() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(6, 0);
        Coordinate dest = new Coordinate(6, 1);

        NoPieceMoveException e = assertThrows(NoPieceMoveException.class,
                ()->{
                    pawn.isValidMovement(source, dest);
                });
        Assertions.assertTrue(e.getMessage().contains("Invalid pawn movement"));
    }

    @Test
    public void pawnMovesToLeftShouldRaiseException() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(1, 5);
        Coordinate dest = new Coordinate(1, 4);

        NoPieceMoveException e = assertThrows(NoPieceMoveException.class,
                ()->{
                    pawn.isValidMovement(source, dest);
                });
        Assertions.assertTrue(e.getMessage().contains("Invalid pawn movement"));
    }

    @Test
    public void pawnMovesBackwardsShouldRaiseException() {
        Pawn pawn = new Pawn(PieceColor.BLACK);
        Coordinate source = new Coordinate(1, 5);
        Coordinate dest = new Coordinate(0, 5);

        NoPieceMoveException e = assertThrows(NoPieceMoveException.class,
                ()->{
                    pawn.isValidMovement(source, dest);
                });
        Assertions.assertTrue(e.getMessage().contains("Invalid pawn movement"));
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new PawnTest("coordiantesOutOfRangeShouldRaiseException"));
        suite.addTest(new PawnTest("pawnMovesTwoSquaresForwardInFirstMoveShouldNotRaiseException"));
        suite.addTest(new PawnTest("pawnMovesOneSquareForwardShouldNotRaiseException"));
        suite.addTest(new PawnTest("pawnMovesToRightShouldRaiseException"));
        suite.addTest(new PawnTest("pawnMovesToLeftShouldRaiseException"));
        suite.addTest(new PawnTest("pawnMovesBackwardsShouldRaiseException"));
        return suite;
    }
}
