class Solution {
    public void solve(char[][] board) {
        if (board == null) return;

        int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int row = board.length, col = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        addBoarderOs(board, q);

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            board[cell[0]][cell[1]] = 'S';

            for (int[] dir : dirs) {
                int r = cell[0] + dir[0], c = cell[1] + dir[1];

                if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] != 'O')
                continue;

                q.add(new int[] {r, c});
            }
        }

        mark(board, 'O', 'X', row, col);
        mark(board, 'S', 'O', row, col);
    }

    private void mark(char[][] board, char m1, char m2, int row, int col) {
        for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {
                if (board[r][c] == m1) board[r][c] = m2;
            }
        }
    }

    private void addBoarderOs(char[][] board, Queue<int[]> q) {
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                if (r == 0 || r == board.length - 1) {
                    if (board[r][c] == 'O') q.add(new int[] {r, c});
                }

                if (c == 0 || c == board[0].length - 1) {
                    if (board[r][c] == 'O') q.add(new int[] {r, c});
                }
            }
        }
    }
}
