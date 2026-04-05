class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        int step = 1;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i=0; i<n; i++) {
                int[] co = q.poll();

                for (int[] dir : dirs) {
                    int r = dir[0] + co[0];
                    int c = dir[1] + co[1];

                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                    || grid[r][c] == -1 || visited[r][c]) continue;

                    visited[r][c] = true;
                    grid[r][c] = Math.min(grid[r][c], step);

                    q.add(new int[] {r, c});
                }
            }
            step++;
        }
    }
}
