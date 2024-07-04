import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = player1;
        System.out.println("Game started.");
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {
        // Implement win-checking logic
        return false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.print(currentPlayer.getMarker());
            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print(currentPlayer.getMarker());
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                } else if (board.isFull()) {
                    board.print(currentPlayer.getMarker());
                    System.out.println("The game is a draw!");
                    break;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is not empty. Try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
        game.play();
    }
}