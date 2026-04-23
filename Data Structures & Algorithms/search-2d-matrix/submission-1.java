class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //each row sorted asc


        //rows[1][0] > row[0][cols.length - 1]
        //O(m log n)

        //O(n * m log(n * m))
        //O(m * log(n))
        //O(log(n * m))
        // 3 * 4
        // 11 -> row[2][3]
        int ROWS_LENGTH = matrix.length;
        int COLS_LENGTH = matrix[0].length;

        int l = 0;
        int r = (ROWS_LENGTH * COLS_LENGTH) - 1;

        while(l <= r) {
            int mid = l + ((r - l) / 2);
            int row = mid / COLS_LENGTH;//2
            int col = mid % COLS_LENGTH; //3
            if(matrix[row][col] < target) l = mid + 1;
            else if(matrix[row][col] > target) r = mid - 1;
            else return true;
        }


        return false;
    }
}
