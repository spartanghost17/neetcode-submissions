class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #r = 9 / 4 = 2 , c = 9 % 4 = 1
        ROWS = len(matrix)
        COLS = len(matrix[0])
        l, r = 0, (ROWS * COLS) - 1
        while l <= r:
            mid = l + (r - l) // 2
            row, col = mid // COLS, mid % COLS
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                l += 1
            else:
                r -= 1
        return False