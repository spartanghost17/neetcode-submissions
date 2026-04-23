public class Solution {
    public int LongestConsecutive(int[] nums) {
        //[2,20,4,10,3,4,5]
        //[2,3,4,5][10][20]
        var set = new HashSet<int>();
        foreach(int num in nums) {
            set.Add(num);
        }
        int max = 0;
        for(int i = 0; i < nums.Length; i++) {
            if(!set.Contains(nums[i] - 1)) {
                int currL = 1;
                while(set.Contains(nums[i] + currL)) currL++;
                max = Math.Max(max, currL);
            }
        }

        return max;
    }
}
