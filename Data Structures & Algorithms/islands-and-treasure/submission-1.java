class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Info> q = new ArrayDeque<>();
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row = grid.length;
        int col = grid[0].length;

        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    q.add(new Info(r, c, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Info node = q.poll();

            for (int[] dir : dirs) {
                int r = dir[0];
                int c = dir[1];
                int nextR = node.row + r;
                int nextC = node.col + c;

                if (nextR < row && nextC < col
                && nextR >= 0 && nextC >= 0 && grid[nextR][nextC] != -1
                && grid[nextR][nextC] != 0 && grid[nextR][nextC] > node.dist + 1) {
                    grid[nextR][nextC] = node.dist + 1;
                    q.add(new Info(nextR, nextC, node.dist + 1));
                }
            }
        }
    }

    private static class Info {
        int row;
        int col;
        int dist;

        public Info(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
