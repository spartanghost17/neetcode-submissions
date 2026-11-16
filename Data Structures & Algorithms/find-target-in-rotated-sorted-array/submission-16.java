class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        //[7, 2, 3]
        //[3,4,5,6,7,2]
        while(l <= r) { //O(log n)
            int mid = l + (r - l) / 2; 
            if(nums[mid] == target) return mid;

            if(nums[l] <= nums[mid]) { // left half is sorted
                if(nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else { //left half is not sorted
                if(nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }

        return -1;
    }
}
