class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums = [-1,0,1,2,-1,-4] -> nlogn
        //[-4,-1,-1, 0,1,2]
        //for i -> nums
        //if(nums[i] > 0) continue
        //if(i > 0 && nums[i] == nums[i-1]) continue;
        //l = i + 1; r = nums.length - 1
        //while(l < r) ->
        // sum = nums[i] + nums[l] + nums[r]
        //if sum < target l++
        //else if sum > target r--
        //else -> 
        //list.add(Arrays.asList(nums[i] , nums[l] , nums[r]))
        //l++, r--
        //while(l < r && nums[l] == nums[l -1])l++

        List<List<Integer>> res = new ArrayList<>();//O(m)
        Arrays.sort(nums);//O(nlogn) + O(n^2)
        int target = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > target) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1; 
            int r = nums.length - 1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < target) l++;
                else if(sum > target) r--;
                else {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1])l++;
                }
            } 
        }  

        return res;
    }
}
