package com.tic.tac.toe.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DynamicTicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get board size from user
        int boardSize;
        do {
            System.out.print("Enter board size (minimum 3): ");
            try {
                boardSize = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear invalid input
                System.out.println("Invalid input. Please enter a number.");
                boardSize = 0;
            }
        } while (boardSize < 3);

        // Create the board
        char[][] board = new char[boardSize][boardSize];
        initializeBoard(board);

        // Game loop
        char currentPlayer = 'X';
        while (true) {
            printBoard(board);

            // Get player move
            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter your move (row col): ");
                try {
                    row = scanner.nextInt() - 1; // Adjust for 0-based indexing
                    col = scanner.nextInt() - 1;
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Clear invalid input
                    System.out.println("Invalid input. Please enter two numbers.");
                    row = -1;
                    col = -1;
                }
            } while (!isValidMove(board, row, col));

            // Make the move
            board[row][col] = currentPlayer;

            // Check for winner or tie
            if (checkWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a tie!");
                break;
            }

            // Switch player
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

        scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("[" + board[i][j] + "] ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length && board[row][col] == '-';
    }

    private static boolean checkWinner(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < board.length; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < board[i].length; j++) {
                rowWin &= board[i][j] == player;
                colWin &= board[j][i] == player;
            }
            if (rowWin || colWin) {
                return true;
            }
        }

        // Check diagonals (only for square boards)
        if (board.length == board[0].length) {
            boolean diag1Win = true;
            boolean diag2Win = true;
            for (int i = 0; i < board.length; i++) {
                diag1Win &= board[i][i] == player;
                diag2Win &= board[i][board.length - i - 1] == player;
            }
            if (diag1Win || diag2Win) {
                return true;
            }
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}

