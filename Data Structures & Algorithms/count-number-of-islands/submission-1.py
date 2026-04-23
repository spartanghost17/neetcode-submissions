class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        R = len(grid)
        C = len(grid[0])
        count = 0
        for r in range(R):
            for c in range(C):
                if grid[r][c] == "1":
                    self.dfs(grid, r, c)
                    count += 1

        return count

    def dfs(self, grid: List[List[str]], r: int, c: int) -> None:
        if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] == "0":
            return
        grid[r][c] = "0"
        dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        for di in dirs:
            nr = r + di[0]
            nc = c + di[1]
            self.dfs(grid, nr, nc) 

        