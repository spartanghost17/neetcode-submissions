class Solution {
    public int longestConsecutive(int[] nums) {
        //len = 1
        //for -> nums
        //nums[i+1] = nums[i] + 1
        //[2,20,4,10,3,4,5]
        //  
        //[2, 3, 4, 5] [10] [20]

        //set = (nums)
        //longest = 0
        //for -> nums:
        // !set.contains(nums[i] - 1) {
        //  len = 1
        // while(set.contains(nums[i] + len)) len++;
        // longest = Math.max(len, longest)
        //}
        // return longest
        //

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        //[1, 2, 3, 4, 5, 6]
        int longest = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                int len = 1;
                while(set.contains(nums[i] + len)) len++;

                longest = Math.max(longest, len); 
            }
        }

        return longest;
    }
}
