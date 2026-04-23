class Solution {
    public int findMin(int[] nums) {
        /**
            Input: nums = [[3,4,5,6],[1,2]]
                                ^ 

            [1,2,3,4,5,6] -> [6,1,2,3,4,5]
            Output: 1 
        */

        int l = 0, r = nums.length - 1, res = nums[0];
        
        while(l <= r) {
            if(nums[l] < nums[r]) {
                res = Math.min(nums[l], res);
                break;
            }
            
            int mid = l + ((r - l) / 2);
            res = Math.min(nums[mid], res);
            if(nums[mid] >= nums[l]){
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }

        return res;

    }
}
