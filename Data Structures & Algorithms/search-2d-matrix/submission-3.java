class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //asc order
        // m log(n) -> log(n * m)

        // mid = (l + r) / 2

        //11 / 4 -> 2
        //11%4 -> 3

        //5 : 4 -> 1
        //5 % 4 -> 1

        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int l = 0;
        int r = (ROWS * COLS) - 1;

        while(l <= r) {
            int mid = l + ((r - l)/2);//(l + r) / 2;
            int row = mid / COLS;
            int col = mid % COLS;
            if(matrix[row][col] < target) l = mid + 1;
            else if(matrix[row][col] > target) r = mid - 1;
            else return true;
        } 

        return false;
    }
}
