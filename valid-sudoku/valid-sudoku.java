// Amazon
class Solution {
    /**
     * Problem Hint: Determine if a 9x9 Sudoku board is valid. A valid Sudoku board 
     *               must satisfy the following conditions:
     *               1. Each row contains unique digits (1-9) or '.'.
     *               2. Each column contains unique digits (1-9) or '.'.
     *               3. Each of the 9 sub-boxes (3x3) contains unique digits (1-9) or '.'.
     * Solution: Use a HashSet to keep track of seen entries in rows, columns, and sub-boxes.
     *           Encode these checks as strings for rows, columns, and sub-boxes and store 
     *           them in the set. If any encoded string is already in the set, the board 
     *           is invalid.
     * 
     * Time Complexity: O(1) - The board is always 9x9, so the maximum operations are constant.
     * Space Complexity: O(1) - The HashSet stores at most 27x9 entries (constant space for 9 rows,
     *                          9 columns, and 9 sub-boxes).
     */
    public boolean isValidSudoku(char[][] board) {
        // HashSet to store encoded strings representing numbers in rows, columns, and sub-boxes
        HashSet<String> seen = new HashSet<>();

        // Iterate through each cell of the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j]; // Current cell value

                // Skip empty cells ('.')
                if (num != '.') {
                    // Create unique strings for rows, columns, and sub-boxes
                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in block " + i / 3 + "-" + j / 3;

                    // If any key is already in the set, the board is invalid
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }

        // If no duplicates are found, the board is valid
        return true;
    }
}
