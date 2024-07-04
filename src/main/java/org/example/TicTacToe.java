package org.example;

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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) == currentPlayer.getMarker() &&
                    board.getCell(i, 1) == currentPlayer.getMarker() &&
                    board.getCell(i, 2) == currentPlayer.getMarker()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board.getCell(0, i) == currentPlayer.getMarker() &&
                    board.getCell(1, i) == currentPlayer.getMarker() &&
                    board.getCell(2, i) == currentPlayer.getMarker()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board.getCell(0, 0) == currentPlayer.getMarker() &&
                board.getCell(1, 1) == currentPlayer.getMarker() &&
                board.getCell(2, 2) == currentPlayer.getMarker()) ||
                (board.getCell(0, 2) == currentPlayer.getMarker() &&
                        board.getCell(1, 1) == currentPlayer.getMarker() &&
                        board.getCell(2, 0) == currentPlayer.getMarker());
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
