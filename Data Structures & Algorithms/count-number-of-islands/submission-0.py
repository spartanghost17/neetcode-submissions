class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count: int = 0
        rows = len(grid)
        cols = len(grid[0])

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    self.dfs(r, c, grid)
                    count += 1

        return count

    def dfs(self, r: int, c: int, grid: List[List[str]]):
        if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or grid[r][c] == "0":
            return
        # up, right, down, left
        direction = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        grid[r][c] = "0"
        for i in range(len(direction)):
            d1 = direction[i][0]
            d2 = direction[i][1]
            #nr = r + direction[i][0]
            #nc = c + direction[i][1]
            # if not in set:
            #     add to set
            self.dfs(r + d1, c + d2, grid)