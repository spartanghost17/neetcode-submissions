class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
            O(m log n) -> O(log(m * n)) -> 2 x 3
            
            row = 11/4 -> 2
            col = 11%4 -> 3
        */

        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int l = 0, r = (ROWS * COLS) - 1;

        while(l <= r) {
            int mid = l + ((r - l) / 2);
            int row = mid / COLS;
            int col = mid % COLS;

            if(matrix[row][col] < target) l = mid + 1;
            else if(matrix[row][col] > target) r = mid - 1;
            else return true;
        }

        return false;
    }
}
