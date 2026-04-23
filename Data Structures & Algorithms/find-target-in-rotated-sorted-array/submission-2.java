class Solution {
    public int search(int[] nums, int target) {

        //[3,4,5,6,1,2] t = 1;
        
        //[3,4,5,6,1,2] t = 2
        // ^
        int l = 0;
        int r = nums.length - 1;
        int res = -1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            
            if(nums[l] <= nums[mid]) {
                if(target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if(target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return res;
    }
}
