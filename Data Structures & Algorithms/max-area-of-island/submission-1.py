class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        #currMax = [0]
        res = 0
        R = len(grid)
        C = len(grid[0])
        for r in range(R):
            for c in range(C):
                if grid[r][c] == 1:
                    res = max(self.dfs(grid, r, c), res)
        return res

    def dfs(self, grid: List[List[int]], r: int, c: int) -> int:
        # if node in visited: return 
        # add to visited set [1, 1]
        # explore neighbors:
        #   dfs()
        if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] == 0:
            return 0
        grid[r][c] = 0 # mark as visited
        dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        count = 1
        for di in dirs:
            nr = r + di[0]
            nc = c + di[1]
            count += self.dfs(grid, nr, nc)
        
        return count
        
