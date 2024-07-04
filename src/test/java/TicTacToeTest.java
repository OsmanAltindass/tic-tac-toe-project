import org.example.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchCurrentPlayer() {
        game.start();
        char initialPlayer = game.getCurrentPlayer().getMarker();
        game.switchCurrentPlayer();
        char nextPlayer = game.getCurrentPlayer().getMarker();
        assertNotEquals(initialPlayer, nextPlayer);
    }

    @Test
    public void testHasWinner() {
        game.start();
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testNoWinner() {
        game.start();
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(1, 0, 'O');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(1, 1, 'O');
        game.getBoard().place(2, 1, 'X');
        assertFalse(game.hasWinner());
    }

    @Test
    public void testDraw() {
        game.start();
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'O');
        game.getBoard().place(0, 2, 'X');
        game.getBoard().place(1, 0, 'X');
        game.getBoard().place(1, 1, 'O');
        game.getBoard().place(1, 2, 'X');
        game.getBoard().place(2, 0, 'O');
        game.getBoard().place(2, 1, 'X');
        game.getBoard().place(2, 2, 'O');
        assertFalse(game.hasWinner());
        assertTrue(game.getBoard().isFull());
    }
}
