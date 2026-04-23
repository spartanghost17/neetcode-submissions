class Solution {
    public int findMin(int[] nums) {
        /**
            Input: nums = [[3,4,5,6],[1,2]]
                                ^ 

            [1,2,3,4,5,6] -> [6,1,2,3,4,5]
            Output: 1 
        */
        //[1, 2]
        //[6, 1, 2, 3, 4, 5]
        int l = 0, r = nums.length - 1;
        
        while(l < r) {
            int mid = l + (r - l) / 2;

            //if minimum on the right
            //i.e. if smaller values than mid point to right
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
