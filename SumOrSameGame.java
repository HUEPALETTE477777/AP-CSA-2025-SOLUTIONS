package AP_CSA_2025_FRQ.QUESTION_4;

import java.util.Arrays;

public class SumOrSameGame {
    private int[][] puzzle;

    public SumOrSameGame(int numRows, int numCols) {
        puzzle = new int[numRows][numCols];

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                int rand = (int) (Math.random() * 9) + 1;
                puzzle[r][c] = rand;
            }
        }
    }

    public boolean clearPair(int row, int col) {
        int target = puzzle[row][col];
        for (int r = 0; r < puzzle.length; r++) {
            for (int c = 0; c < puzzle[r].length; c++) {
                int compare = puzzle[r][c];

                if (r == row && c == col) { continue; }

                if (r >= row) {
                    if (target + compare == 10 || target == compare) {
                        puzzle[row][col] = 0;
                        puzzle[r][c] = 0;
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {

        int nR1 = 3;
        int nC1 = 4;

        SumOrSameGame obj1 = new SumOrSameGame(nR1, nC1);
        System.out.println(Arrays.deepToString(obj1.puzzle)); // EXPECTED: ALL ELEMENTS MUST BE 1 - 9 INCLUSIVE
        obj1.clearPair(0,0);
        System.out.println(Arrays.deepToString(obj1.puzzle));

    }


}