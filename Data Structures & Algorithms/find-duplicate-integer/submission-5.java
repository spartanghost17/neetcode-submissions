class Solution {
    public int findDuplicate(int[] nums) {
        //[1,2,3,2,2]
        //0 -> 1
        //1 -> 2
        //2 -> 3
        //3 -> 2
        //4 -> 2

        // 0 -> 1 -> 2 -> 3
        //           |----|
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int slow2 = 0;
        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        } while(slow != slow2);

        return slow;
    }
}
