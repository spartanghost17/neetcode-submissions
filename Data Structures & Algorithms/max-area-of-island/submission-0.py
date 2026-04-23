class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        #currMax = [0]
        res = 0
        ROWS = len(grid)
        COLS = len(grid[0])

        for r in range(ROWS):
            for c in range(COLS):
                res = max(res, self.dfs(grid, r, c)) 
        
        return res
    
    def dfs(self, grid: List[List[int]], r: int, c: int):
        if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or grid[r][c] == 0:
            return 0
        
        # add to visited set + increment count
        grid[r][c] = 0
        # up, right, down left
        graph = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        count = 1
        for v in graph:
            nr = r + v[0]
            nc = c + v[1]
            if r >= 0 or r < len(grid) and c >= 0 or c < len(grid[0]) and grid[nr][nc] == 1: # not in visited set
                count += self.dfs(grid, nr, nc)
        
        return count
        