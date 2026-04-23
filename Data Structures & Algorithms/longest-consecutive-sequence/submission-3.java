class Solution {
    public int longestConsecutive(int[] nums) {
        //nums = [2,20,4,10,3,4,5]

        // [2, 3, 4, 5], [10], [20]
        //is start of seq if nums[i] - 1 != in set
        
        //longest = 0
        //for i -> nums:
        //if(!set.contains(nums[i] - 1))
        //  currLen = 1 -> 4
        //  while(set.contains(nums[i] + currLen)) currLen++
        //  longest = max(longest, currLen)
        //repeating values -> needs a set

        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for(int i : nums) {
            set.add(i);
        }

        for(int num : set) {
            if(!set.contains(num - 1)) {
                int currLen = 1;
                while(set.contains(num + currLen)) currLen++;
                longest = Math.max(currLen, longest);
            }
        }

        return longest;
    }
}
