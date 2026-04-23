class Solution {
    public int[] twoSum(int[] nums, int target) {
        // target = 7
        // nums = [3, 4, 5, 6]
        // {3: 0, 3:}

        //nums[i] + nums[j] == target
        //i != j (i * j must be different)
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } 
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
