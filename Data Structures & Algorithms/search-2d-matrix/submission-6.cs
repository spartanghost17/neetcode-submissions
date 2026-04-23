public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int R = matrix.Length;
        int C = matrix[0].Length;
        int l = 0; int r = R * C - 1;
        while(l <= r) {
            //5/4 -> 1 5%4 -> 1
            //9/4 -> 2 9%4 -> 1
            int mid = l + (r - l) / 2;
            int rc = mid/C; int cc = mid%C;
            if(matrix[rc][cc] < target) l = mid + 1;
            else if(matrix[rc][cc] > target) r = mid - 1;
            else return true;
        }

        return false;
    }
}
