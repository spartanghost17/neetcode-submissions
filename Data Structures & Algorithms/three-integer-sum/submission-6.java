class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //no duplicates
        //i,j,k cannot share index
        //sum = nums[i] + nums[j] + nums[k] == 0

        //[-1,0,1,2,-1,-4]
        // target = 0
        // for i -> Arrays.sort(nums)
        // no duplicates
        // if(nums[i] == nums[i-1]) continue;
        // if(nums[i] >= 0) break; 
        // j = i + 1;
        // k = nums.length - 1
        //[-4,-1,-1,0,1,2] -> [[-1,-1,2],[-1,0,1]]
        //scan subarray
        // while(j < k):->
            // sum = nums[i] + nums[j] + nums[k]
            // if(sum < target) j++;
            // else if(sum > target) k--
            // else finalArr.add(Arrays.asList(nums[i], nums[j], nums[k])
        // j++, k--;
        //[-1,-1,0,1] -> [-1,0,1]
        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        Arrays.sort(nums);//O(n Log n)
        //[-4, -3, -2, -1, 0, 1, 2, 3, 4]
        for(int i = 0; i < nums.length; i++) {//O(n^2)
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < target) l++;
                else if(sum > target) r--;
                else {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++; r--;

                    while(l < r && nums[l] == nums[l - 1]) l++;
                }
                
            }
        }

        return res;
    }
}
