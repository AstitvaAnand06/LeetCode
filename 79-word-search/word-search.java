class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // Base case: Entire word is found
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character mismatch
        if (row < 0 || col < 0 ||
            row >= board.length ||
            col >= board[0].length ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        // Store current character
        char temp = board[row][col];

        // Mark cell as visited
        board[row][col] = '#';

        // Explore all four directions
        boolean found =

            dfs(board, word, row + 1, col, index + 1) ||

            dfs(board, word, row - 1, col, index + 1) ||

            dfs(board, word, row, col + 1, index + 1) ||

            dfs(board, word, row, col - 1, index + 1);

        // Backtracking: Restore original character
        board[row][col] = temp;

        return found;
    }
}