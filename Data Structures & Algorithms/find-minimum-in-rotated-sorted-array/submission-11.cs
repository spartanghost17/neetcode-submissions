public class Solution {
    public int FindMin(int[] nums) {
        int l = 0; int r = nums.Length -1;
        int res = nums[0];
        while(l < r) {
            int mid = l + (r - l) / 2;
            //in sorted half
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
