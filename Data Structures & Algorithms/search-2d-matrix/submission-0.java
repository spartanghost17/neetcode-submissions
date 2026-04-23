class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //O(n^n)
        //start > end of prev
        //O(log(m * n))
        boolean isFound = true;
        for(int[] arr : matrix) {
            if(containsTarget(arr, target)) {
                return isFound;
            }
            
        }

        return !isFound;
    }

    private boolean containsTarget(int[] arr, int target) {

        int l = 0;
        int r = arr.length - 1;
        boolean isInArr = false;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(arr[mid] < target) {
                l = mid + 1;
            } else if(arr[mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return isInArr;
    }
}
