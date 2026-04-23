class Solution {
    public int[] twoSum(int[] nums, int target) {
       //asc 
       int l = 0;
       int r = nums.length - 1;
       while(l < r) {
        int sum = nums[r] + nums[l];
        if(sum < target) l++;
        else if(sum > target) r--;
        else return new int[] {l+1, r+1};
       }

       return new int[]{-1,-1};
    }
}
