class Solution {
    public int search(int[] nums, int target) {
        //[[4,5,6,7],[0,1,2]]
        //[4,5,1,2,3]
        //target < l  -> l = mid + 1
        //target > l 
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + ((r - l) / 2);
            if(nums[mid] == target) return mid;

            //are we in left portion?
            if(nums[l] <= nums[mid]) {
                //if target is less than mid or greater than 
                //start of lef tsequence nums[l]
                if(target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {//we are in the right portion
                if(target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
