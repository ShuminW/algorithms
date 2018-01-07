
// Analysis & Hypothesis
public class LC419 {
    class Solution {

        boolean isAboveX(char[][] board, int i, int j) {
            if (i == 0) {
                return false;
            }
            return board[i - 1][j] == 'X';
        }

        boolean isLeftX(char[][] board, int i, int j) {
            if (j == 0) {
                return false;
            }
            return board[i][j - 1] == 'X';
        }

        public int countBattleships(char[][] board) {
            int cnt = 0;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (board[i][j] == 'X') {
                        if ((!isAboveX(board, i, j)) && (!isLeftX(board, i, j))) {
                            ++cnt;
                        }
                    }
                }
            }
            return cnt;
        }
    }
}
