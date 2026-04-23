public class Solution {
    public int Search(int[] nums, int target) {
        int l = 0;
        int r = nums.Length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) 
                return mid;

            //LEFT HALF IS SORTED
            if(nums[l] <= nums[mid]) {
                if(nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } //RIGHT HALF IS SORTED
            else {
                if(nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return -1;
    }
}
