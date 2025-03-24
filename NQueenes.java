public class NQueens {
    private static void printSolution(char[][] board) {
        for (char[] row : board) {
            System.out.println(new String(row));
        }
        System.out.println();
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private static boolean solve(char[][] board, int row, int n) {
        if (row == n) {
            printSolution(board);
            return true;
        }

        boolean foundSolution = false;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                foundSolution |= solve(board, row + 1, n);
                board[row][col] = '.'; 
            }
        }
        return foundSolution;
    }

    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        if (!solve(board, 0, n)) {
            System.out.println("No solution exists");
        }
    }

    public static void main(String[] args) {
        int n = 8;
        solveNQueens(n);
    }
}
