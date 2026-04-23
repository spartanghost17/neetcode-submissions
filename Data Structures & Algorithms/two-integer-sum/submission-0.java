class Solution {
    public int[] twoSum(int[] nums, int target) {
       //sum = x + y
       //x = sum - y
       //[3, 4, 5, 6] -> reg{}
        Map<Integer, Integer> complement = new HashMap<>();
        //{value, idx}
        for(int i = 0; i < nums.length; i++) {

            int comp = target - nums[i];
            if(complement.containsKey(comp)) {  
                return new int[]{complement.get(comp), i};
            }
            complement.put(nums[i], i);
        }

        return new int[]{-1, -1}; 
    }
}
