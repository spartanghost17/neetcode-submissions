class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //map = {}
        //for each element:
        // if complement/target in map:
        //    found answer
        //map[element] = index/count
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
        return false;
    }
}