class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //[-1,0,1,2,-1,-4]
        //[-4,-1,-1,0,1,2]
        //[-4,-4,1,3]
        Arrays.sort(nums);//O(n log n)
        //res = []
        //if arr[l] >= 0: continue
        //skip values seen i != 0 and arr[n] == arr[n-1]: continue
        //l = i + 1, r = len(nums) - 1
        //while l < r: //O(n)
        // s = sum(arr[i], arr[l], arr[r])
        // if s < target:
        //    l++
        // elif s > target:
        //    r--
        // else:
        //    res.append(nums[i], nums[l], nums[r])
        //    while l < r and arr[l] == arr[l - 1]: l++
        //    l++, r--

        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > target) continue;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1; int r = nums.length - 1;
            
            while(l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if(s < target) l++;
                else if(s > target) r--;
                else {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++; r--;//reduce search space
                    while(l < r && nums[l] == nums[l - 1]) l++;
                    
                }
            }
        }

        return res;
    }
}
