package Backtracking;

import java.util.ArrayList;

import p.p;

class NQueens{
    public static void main(String[] args) {
        Solution s = new Solution();

        ArrayList<ArrayList<String>> ss = s.solveNQueens(3);

        p.printl("ss has size of "+ss.size());


        for(int i=0;i<ss.size();i++){
            
            ArrayList<String> sss = ss.get(i);
            for(int j=0;j<sss.size();j++){
                p.printl(sss.get(j));
            }

            p.printl("                   ------");
        }

    }
}

class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        int dia[] = new int[2 * A - 1];
        int row[] = new int[A];
        int col[] = new int[A];

        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int j = 0; j < A; j++) {
                rowBuilder.append('.');
            }
            board.add(rowBuilder.toString());
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        tryAll(ans, board, dia, row, col, 0, A);

        return ans;
    }

    void tryAll(ArrayList<ArrayList<String>> ans, ArrayList<String> board, int dia[], int row[], int col[], int j, int A) {
        if (j == A) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int i = 0; i < A; i++) {
            if (isValid(board, dia, row, col, i, j, A)) {
                updateState(dia, row, col, i, j, A, 1);
                board.set(j, replaceCharAtIndex(board.get(j), i, 'Q'));
                tryAll(ans, board, dia, row, col, j + 1, A);
                updateState(dia, row, col, i, j, A, -1);
                board.set(j, replaceCharAtIndex(board.get(j), i, '.'));
            }
        }
    }

    boolean isValid(ArrayList<String> board, int dia[], int row[], int col[], int i, int j, int A) {
        return row[i] == 0 && col[j] == 0 && dia[i + j] == 0 && !isUnderAttack(board, i, j, A);
    }

    boolean isUnderAttack(ArrayList<String> board, int row, int col, int A) {
        for (int i = 0; i < A; i++) {
            if (board.get(i).charAt(col) == 'Q' || board.get(row).charAt(i) == 'Q') {
                return true;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return true;
            }
        }
        for (int i = row, j = col; i < A && j >= 0; i++, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return true;
            }
        }
        return false;
    }

    void updateState(int dia[], int row[], int col[], int i, int j, int A, int delta) {
        row[i] += delta;
        col[j] += delta;
        dia[i + j] += delta;
    }

    String replaceCharAtIndex(String str, int index, char newChar) {
        char[] charArray = str.toCharArray();
        charArray[index] = newChar;
        return new String(charArray);
    }
}
