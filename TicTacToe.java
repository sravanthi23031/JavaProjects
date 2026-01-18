
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    static char player = 'X';

    public static void displayBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        while (true) {
            displayBoard();

            System.out.print("Enter row (0-2): ");
            int row = scn.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scn.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move! Try again.\n");
                continue;
            }

            board[row][col] = player;

            if (isWin()) {
                System.out.println("=================================");
                displayBoard();
                System.out.println("Player " + player + " won the game!");
                break;
            }

            if (isDraw()) {
                displayBoard();
                System.out.println("Match Draw!");
                break;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        scn.close();
    }

    public static boolean isWin() {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
