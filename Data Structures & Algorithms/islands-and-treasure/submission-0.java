class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // add all treasures (0s) to queue
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == 0) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >= 0 && nr < R && nc < C
                && grid[nr][nc] == Integer.MAX_VALUE
                )  {
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
