import org.example.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testIsCellEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));  // positive case
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0)); // negative case
    }

    @Test
    public void testPlace() {
        Board board = new Board();
        board.place(1, 1, 'O');
        assertEquals('O', board.getCell(1, 1)); // positive case
    }

    @Test
    public void testIsFull() {
        Board board = new Board();
        assertFalse(board.isFull()); // negative case
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull()); // positive case
    }

    @Test
    public void testClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0)); // positive case
    }
}
