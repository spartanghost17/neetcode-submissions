class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        INF = 2147483647
        R = len(grid)
        C = len(grid[0])

        queue = deque()
        # enqueue all chests
        for r in range(R):
            for c in range(C):
                if grid[r][c] == 0:
                    queue.append([r, c])

        dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        while len(queue) > 0:
            coord = queue.popleft()
            r, c = coord
            for di in dirs:
                nr, nc = r + di[0], c + di[1]
                if nr >= 0 and nc >= 0 and nr < R and nc < C and grid[nr][nc] == INF:
                    grid[nr][nc] = grid[r][c] + 1
                    queue.append([nr, nc])
