class Solution {
    public int findMin(int[] nums) {
        //l = 0, r = nums.length - 1, min = nums[0];
        //
        //while (l <= r):
        // if nums[l] < nums[r] -> return Math.min(min, nums[l])
        // mid = l  + ((r - l) / 2)
        // min = Math.min(min, nums[mid])
        //if nums[mid] >= nums[l]: -> #
        //   l = mid + 1
        //else:
        //   r = mid - 1 
        //4 + (5 - 4)/2
        //[[3,4,5,6,{7][1,2]}]
        // [4,5,0,1,2,3]
        //l = mid + 1

        int l = 0, r = nums.length - 1, min = nums[0];
        while(l <= r) {
            if(nums[l] < nums[r]) return Math.min(min, nums[l]);

            int mid = l + ((r - l) / 2);
            min = Math.min(min, nums[mid]);
            if(nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return min;
    }
}
