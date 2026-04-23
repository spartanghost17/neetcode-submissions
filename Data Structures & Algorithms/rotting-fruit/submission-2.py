class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])
        time = 0
        fresh = 0
        q = deque()

        for r in range(R):
            for c in range(C):
                if grid[r][c] == 1:
                    fresh += 1
                if grid[r][c] == 2:
                    q.append([r, c])

        edges = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        while fresh > 0 and q:
            length = len(q) # process all rotten oranges at once
            for i in range(length):
                r, c = q.popleft()

                for edge in edges:
                    nr = r + edge[0]
                    nc = c + edge[1]

                    if nr >= 0 and nc >= 0 and nr < R and nc < C and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.append([nr, nc])
                        fresh -= 1
            time += 1
        return time if fresh == 0 else -1


                    
