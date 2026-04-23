class Solution {
    public int search(int[] nums, int target) {
        //[[4,5,6,7m],[0,1,2]]
        //[[4,5,6],[0m,1,2,3]]
        //[[4,5,][1,2,3]]
        //target < l  -> l = mid + 1
        //target > l 
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + ((r - l) / 2);
            if(nums[mid] == target) return mid;
            if(nums[l] <= nums[mid]) { //left side
                if(target > nums[mid] || nums[l] > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { //right side
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
