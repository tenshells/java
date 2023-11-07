package Backtracking;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int n = 4; // Adjust the value of n as needed
        Solution solution = new Solution();
        ArrayList<ArrayList<String>> result = solution.solveNQueens(n);

        // Display the result
        for (ArrayList<String> row : result) {
            System.out.println(row);
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        solveNQueensUtil(result, queens, 0, n);
        return result;
    }

    private void solveNQueensUtil(ArrayList<ArrayList<String>> result, int[] queens, int row, int n) {
        if (row == n) {
            result.add(generateBoard(queens, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(queens, row, i)) {
                queens[row] = i;
                solveNQueensUtil(result, queens, row + 1, n);
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> generateBoard(int[] queens, int n) {
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(j == queens[i] ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
    }
}
