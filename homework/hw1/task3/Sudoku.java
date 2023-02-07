package task3;

import java.util.HashMap;

public class Sudoku {
    /**
     * This method determine if a given 9 x 9 task3.Sudoku board of characters is valid. Only the filled cells need to be validated
     * according to the following rules:
     * 1. Each row has the digits 1-9 without repetition.
     * 2. Each column has the digits 1-9 without repetition.
     * 3. Each of the nine 3 x 3 sub-boxes of the grid has the digits 1-9 without repetition.
     * Also, note that:
     * 1. A task3.Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * 2. Only the filled cells need to be validated according to the mentioned rules.
     * @param board a char-typed 2d array representing the board, '.' indicating empty cell
     * @return true if valid, false otherwise.
     */
    public static boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
}