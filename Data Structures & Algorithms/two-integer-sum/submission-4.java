class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Input: 
        // nums = [3,4,5,6], target = 7
        //x + y = 7
        //y = 7 - x
        //{3: 0, } -> [0, 1]
        // Output: [0,1]
        Map<Integer, Integer> complements =  new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if(complements.containsKey(comp)) {
                return new int[] {complements.get(comp), i};
            }
            complements.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
