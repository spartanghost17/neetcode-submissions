class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //[1, 2, 3, 4, 5, 6] 
        //left = 1, right = 1
        //-> <-
        //a[0] + a[1] + a[2] + a[3]
        //[1,   1,   2, 6]
        //[24, 12,   4, 1]
        //24, 12, 8, 6

        //[ 3]
        //ppf(n+1) = ppf(n)*n
        //

        int left = 1, right = 1;
        int[] arr = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i]; 
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }

        return arr;
    }
}  
