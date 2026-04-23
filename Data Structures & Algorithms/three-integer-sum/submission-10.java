class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //O (n log n)
        //[-4, -1, -1, 0, 1, 2]
        //Arrays.sort(nums)
        
        //[-1, -1, 0, 1]
        //[-4, -1, -1, -1, 0, 1, 2]
        //target = 0
        //for i -> nums:
        //  if(nums[i] > target) break
        //  if(i > 0 && nums[i - 1] == nums[i]) continue
        //  l = i + 1, r = nums.length - 1
        //while(l < r) {
        //      int sum = nums[i] + nums[l] + nums[r]
        //  if(sum < target) l++
        //  else if(sum > target) r--
        //  else:
        //      res.add(Arrays.asList(nums[i], nums[l], nums[r]))
        //      l++; r--;
        //      while(l < r && nums[l - 1] == nums[l]) l++
        //}

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > target) break;
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int l = i + 1, r = nums.length - 1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < target) l++;
                else if(sum > target) r--;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                    while(l < r && nums[l - 1] == nums[l]) l++;
                }
            }
        }

        return res;
    }
}
