# Prompt 1:
please code me a version of the mankala game in java

# Response: 
```import java.util.Arrays;
import java.util.Scanner;

public class MancalaGame {
    public static void main(String[] args) {
        int[] board = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0}; // Initial board setup

        boolean playerTurn = true; // true for Player A, false for Player B

        while (!isGameOver(board)) {
            printBoard(board);

            int move = getPlayerMove(board, playerTurn);
            distributeStones(board, move, playerTurn);

            // If a player's last stone lands in their mancala, they get another turn
            if (playerTurn && move == 6 || !playerTurn && move == 13) {
                playerTurn = !playerTurn;
            } else {
                playerTurn = !playerTurn;
            }
        }

        determineWinner(board);
    }

    private static void printBoard(int[] board) {
        System.out.println("Player B's Mancala: " + board[13]);
        for (int i = 12; i >= 7; i--) {
            System.out.print(board[i] + " ");
        }
        System.out.println("\nPlayer A's Mancala: " + board[6]);
        for (int i = 0; i <= 5; i++) {
            System.out.print(board[i] + " ");
        }
        System.out.println();
    }

    private static boolean isGameOver(int[] board) {
        for (int i = 0; i <= 5; i++) {
            if (board[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static int getPlayerMove(int[] board, boolean playerTurn) {
        Scanner scanner = new Scanner(System.in);
        int playerMancala = playerTurn ? 6 : 13;
        int opponentMancala = playerTurn ? 13 : 6;
        int move;

        do {
            System.out.print("Player " + (playerTurn ? "A" : "B") + ", choose a pit (0-5): ");
            move = scanner.nextInt();
        } while (move < 0 || move > 5 || board[move] == 0);

        return move;
    }

    private static void distributeStones(int[] board, int move, boolean playerTurn) {
        int stones = board[move];
        board[move] = 0;

        int currentIndex = move;
        while (stones > 0) {
            currentIndex = (currentIndex + 1) % 14;
            if (currentIndex == (playerTurn ? 13 : 6)) {
                currentIndex = (currentIndex + 1) % 14;
            }
            board[currentIndex]++;
            stones--;
        }

        captureStones(board, currentIndex, playerTurn);
    }

    private static void captureStones(int[] board, int currentIndex, boolean playerTurn) {
        if (board[currentIndex] == 1 && currentIndex >= 0 && currentIndex <= 5) {
            int oppositePit = 12 - currentIndex;
            if (board[oppositePit] > 0) {
                int playerMancala = playerTurn ? 6 : 13;
                board[playerMancala] += board[currentIndex] + board[oppositePit];
                board[currentIndex] = board[oppositePit] = 0;
            }
        }
    }

    private static void determineWinner(int[] board) {
        int scorePlayerA = board[6];
        int scorePlayerB = board[13];

        if (scorePlayerA > scorePlayerB) {
            System.out.println("Player A wins!");
        } else if (scorePlayerA < scorePlayerB) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
```

# Result
After this one prompt the code worked