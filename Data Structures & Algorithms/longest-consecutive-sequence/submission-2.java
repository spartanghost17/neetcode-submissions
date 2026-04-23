class Solution {
    public int longestConsecutive(int[] nums) {
        //nums = [2,4,20,10,3,4,5]
        //for -> nums
        //set(nums) 
        //res = 0
        //for i -> nums:
        //if !set.contains(nums[i] - 1) -> search for seq
            // l = 1 //4
            //while(set.contains(nums[i] + l)) l++;
            //res = max(res, l)
            //[2,3,4,5] [10] [20]
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i : nums) {
            set.add(i);
        }

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                int l = 1;
                while(set.contains(nums[i] + l)) l++;
                res = Math.max(res, l);
            }
        }
        return res;
    }
}
